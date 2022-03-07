package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utility.SQLHelper;

public class ReaderDao {
	static Connection connection  = null;
    static PreparedStatement pStatement = null;
    static ResultSet rSet = null;
    
    public static ResultSet queryReaderById(int Rid) {
    	connection = SQLHelper.getConnection();
        String sqlString = "select * from Reader where Rid = ?";
        try {
			pStatement = connection.prepareStatement(sqlString);
			pStatement.setInt(1, Rid);
			rSet = pStatement.executeQuery();
			return rSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return rSet;	

    }
	public static ResultSet queryReaderNameById(int Rid) {
		connection = SQLHelper.getConnection();
		String sqlString = "select Rname from Reader where Rid = ?";
		try {
			pStatement = connection.prepareStatement(sqlString);
			pStatement.setInt(1, Rid);
			rSet = pStatement.executeQuery();
			return rSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rSet;

	}
}
