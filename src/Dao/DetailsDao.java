package Dao;

import Entity.Details;
import Utility.SQLHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Utility.SQLHelper.getConnection;

public class DetailsDao {

      static Connection connection  = null;
      static PreparedStatement pStatement = null;
      static ResultSet rSet = null;

      public static ResultSet queryBorrowRecordsById(int id) {
            connection = SQLHelper.getConnection();
            String sql = "select * from Details where Rid = ?";
            try {
                  pStatement = connection.prepareStatement(sql);
                  pStatement.setInt(1, id);
                  rSet = pStatement.executeQuery();
            } catch (SQLException e) {
                  e.printStackTrace();
            }
            return rSet;
      }
      public static ResultSet queryReturnRecordsById(int id) {
            connection = SQLHelper.getConnection();
            String sql = "select * from Details where Rid = ? and DreturnDate != null";
            try {
                  pStatement = connection.prepareStatement(sql);
                  pStatement.setInt(1, id);
                  rSet = pStatement.executeQuery();
            } catch (SQLException e) {
                  e.printStackTrace();
            }
            return rSet;
      }
      public static ResultSet queryNotReturnRecordsById(int id) {
            connection = SQLHelper.getConnection();
            String sql = "select * from Details where Rid in (select Rid where Rid = ? and Dstatus = 'δ����')";
            try {
                  pStatement = connection.prepareStatement(sql);
                  pStatement.setInt(1, id);
                  rSet = pStatement.executeQuery();
            } catch (SQLException e) {
                  e.printStackTrace();
            }
            return rSet;
      }
      public static int Details1(Details details1) {
            try {
                  getConnection();

                  String details = "Insert into Details values (?,?,?,?,?,?)";
                  pStatement = connection.prepareStatement(details);

                  pStatement.setInt(1, details1.getRid());
                  pStatement.setInt(2, details1.getDid());
                  pStatement.setString(3, details1.getDname());
                  pStatement.setString(4, details1.getDstatus());
                  pStatement.setDate(5, details1.getDborrowDate());

                  pStatement.setObject(6, null);/// ????
                  return pStatement.executeUpdate();
            } catch (SQLException e) {
                  e.printStackTrace();
                  return 0;
            }
      }
      public static int Details2(Details details1) {
            try {
                  getConnection();

                  String details = "Update Details set Dreturndate=?,Dstatus=? where Rid=? and Did=?";
                  pStatement = connection.prepareStatement(details);


                  pStatement.setDate(1, details1.getDreturnDate());/// ????
                  pStatement.setString(2, details1.getDstatus());
                  pStatement.setInt(3, details1.getRid());
                  pStatement.setInt(4, details1.getDid());
                  return pStatement.executeUpdate();
            } catch (SQLException e) {
                  e.printStackTrace();
                  return 0;
            }
      }
      public static ResultSet Details3(int rid) {
            try {
                  getConnection();

                  String showsbdetails = "select * from Details where Rid=?";
                  pStatement = connection.prepareStatement(showsbdetails,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                  pStatement.setInt(1, rid);
                  return pStatement.executeQuery();
            } catch (SQLException e) {
                  e.printStackTrace();
                  return rSet;
            }
      }
}
