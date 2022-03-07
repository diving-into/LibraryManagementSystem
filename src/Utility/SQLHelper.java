package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLHelper {


    //	public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static final String URL = "jdbc:mysql://localhost:3306/library?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    private static Connection connection = null;
    private static PreparedStatement pStatement = null;
    private static ResultSet rSet = null;

    static {
        //加载驱动程序
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public static void close() {
        if (rSet != null) {
            try {
                rSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (pStatement != null) {
            try {
                pStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}




