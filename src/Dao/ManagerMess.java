package Dao;

import Utility.SQLHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerMess {
    static Connection connection  = null;
    static PreparedStatement pStatement = null;
    static ResultSet rSet = null;
    public static void AddAdminMess(int id,String password,String gender,String tele,String qqMobile) throws SQLException {
        try {
            connection = SQLHelper.getConnection();
            String sql1="insert into ManagerMess values(?,?,?,?,?)";
            pStatement=connection.prepareStatement(sql1);

            pStatement.setInt(1, id);
            pStatement.setString(2,password);
            pStatement.setString(3,gender);
            pStatement.setString(4,tele);
            pStatement.setString(5,qqMobile);

            pStatement.executeUpdate();

        }finally {
            SQLHelper.close();
        }
    }

}
