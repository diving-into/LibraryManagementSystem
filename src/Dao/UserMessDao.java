package Dao;

import GUI.Amenu;
import GUI.ReaderFrame;
import Utility.SQLHelper;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Utility.SQLHelper.close;

public class UserMessDao {
    static Connection connection  = null;
    static PreparedStatement pStatement = null;
    static ResultSet rSet = null;
    public static void Register(int id, String password, String rePassword, String gender, String tele, String qqMobile)  {
        try {
            connection = SQLHelper.getConnection();
            String sql1 = "insert into UserMess values(?,?,?,?,?,?)";

            pStatement = connection.prepareStatement(sql1);

            pStatement.setInt(1, id);
            pStatement.setString(2, password);
            pStatement.setString(3, rePassword);
            pStatement.setString(4, gender);
            pStatement.setString(5, tele);
            pStatement.setString(6, qqMobile);

            pStatement.executeUpdate();

        }catch(SQLException e) {
                e.printStackTrace();

        }finally {
           close();
        }
    }
    public static void Login(int id,String password,String user) throws SQLException {
        try {
            connection = SQLHelper.getConnection();
            String sql2;
            if(user.equals("普通用户"))
                sql2="select * from usermess where id=?";//数据库的id列
            else
                sql2="select * from managermess where id=?";
            pStatement=connection.prepareStatement(sql2);
            pStatement.setInt(1, id);//id传入的参数，设置的问号是什么
            ResultSet ret1=pStatement.executeQuery();
            if(!ret1.next()) {
                JOptionPane.showMessageDialog(null, "此用户未注册！");
            }
            //
            if(ret1.getString(2).equals(password)) {
                JOptionPane.showMessageDialog(null, "登陆成功");

                if(user.equals("普通用户")) {
                    ReaderFrame readerFrame=new ReaderFrame();
                    readerFrame.setVisible(true);
                }
                else {
                    Amenu amenu=new Amenu();
                    amenu.setVisible(true);
                }

            }

            else {
                JOptionPane.showMessageDialog(null, "密码与用户名不匹配，请重新输入！");
                ReaderFrame readerFrame=new ReaderFrame();
                readerFrame.setVisible(false);
                Amenu amenu=new Amenu();
                amenu.setVisible(false);
            }

        } finally {
            close();
        }

    }
    public static void ModifyPM(int id, String password, String rePassword, String tele, String qqMobile)throws SQLException {

        try {
            connection = SQLHelper.getConnection();
            String sql1="update usermess set password = ?,rePassword = ?,tele = ?, qqMobile = ? where id = ?";
            pStatement=connection.prepareStatement(sql1);
            pStatement.setInt(5, id);

            pStatement.setString(1,password);
            pStatement.setString(2,rePassword);
            pStatement.setString(3,tele);
            pStatement.setString(4,qqMobile);

            pStatement.executeUpdate();

        }finally {
            close();
        }
    }
    public static void ModifyPM(int id, String password, String rePassword)throws SQLException {
        try {
            connection = SQLHelper.getConnection();
            String sql1="update usermess set password = ?,rePassword = ? where id = ?";
            pStatement=connection.prepareStatement(sql1);
            pStatement.setInt(3, id);

            pStatement.setString(1,password);
            pStatement.setString(2,rePassword);


            pStatement.executeUpdate();

        }finally {
            close();
        }
    }
    public static void ModifyPM2(int id, String tele, String qqMobile)throws SQLException {
        try {
            connection = SQLHelper.getConnection();
            String sql1="update usermess set tele = ?,qqMobile = ? where id = ?";
            pStatement=connection.prepareStatement(sql1);
            pStatement.setInt(3, id);

            pStatement.setString(1,tele);
            pStatement.setString(2,qqMobile);


            pStatement.executeUpdate();

        }finally {
            close();
        }
    }
    public static void ModifyPM(int id, String tele)throws SQLException {
        try {
            connection = SQLHelper.getConnection();
            String sql1="update usermess set tele = ? where id = ?";
            pStatement=connection.prepareStatement(sql1);
            pStatement.setInt(2, id);

            pStatement.setString(1,tele);



            pStatement.executeUpdate();

        }finally {
            close();
        }
    }
    public static void ModifyPM3(int id, String qqMobile)throws SQLException {
        try {
            connection = SQLHelper.getConnection();
            String sql1="update usermess set qqMobile = ? where id = ?";
            pStatement=connection.prepareStatement(sql1);
            pStatement.setInt(2, id);

            pStatement.setString(1,qqMobile);


            pStatement.executeUpdate();

        }finally {
            close();
        }
    }
    public static void ModifyPM(int id, String password, String rePassword, String qqMobile)throws SQLException {

        try {
            connection = SQLHelper.getConnection();
            String sql1="update usermess set password = ?,rePassword = ?, qqMobile = ? where id = ?";
            pStatement=connection.prepareStatement(sql1);
            pStatement.setInt(4, id);

            pStatement.setString(1,password);
            pStatement.setString(2,rePassword);

            pStatement.setString(3,qqMobile);

            pStatement.executeUpdate();

        }finally {
            close();
        }
    }
    public static void ModifyPM1(int id, String password, String rePassword, String tele)throws SQLException {

        try {
            connection = SQLHelper.getConnection();
            String sql1="update usermess set password = ?,rePassword = ?,tele = ? where id = ?";
            pStatement=connection.prepareStatement(sql1);
            pStatement.setInt(4, id);

            pStatement.setString(1,password);
            pStatement.setString(2,rePassword);
            pStatement.setString(3,tele);


            pStatement.executeUpdate();

        }finally {
            close();
        }
    }
    public static void ModifyAdminPw(int id, String password, String tele, String qqMobile)throws SQLException {
        try {
            connection = SQLHelper.getConnection();
            String sql1="update usermess set password = ?,tele = ?, qqMobile = ? where id = ?";
            pStatement=connection.prepareStatement(sql1);
            pStatement.setInt(4, id);

            pStatement.setString(1,password);
            pStatement.setString(2,tele);
            pStatement.setString(3,qqMobile);

            pStatement.executeUpdate();

        }finally {
            close();
        }
    }
    public static void ModifyAdminPw(int id, String password, String qqMobile)throws SQLException {
        try {
            connection = SQLHelper.getConnection();
            String sql1="update usermess set pword = ?, qqMobile = ? where id = ?";
            pStatement=connection.prepareStatement(sql1);
            pStatement.setInt(3, id);

            pStatement.setString(1,password);

            pStatement.setString(2,qqMobile);

            pStatement.executeUpdate();

        }finally {
            close();
        }
    }
    //ModifyAdminPw
    public static void ModifyAdminPw1(int id, String password, String tele)throws SQLException {
        try {
            connection = SQLHelper.getConnection();
            String sql1="update usermess set pword = ?, tele = ? where id = ?";
            pStatement=connection.prepareStatement(sql1);
            pStatement.setInt(3, id);

            pStatement.setString(1,password);

            pStatement.setString(2,tele);

            pStatement.executeUpdate();

        }finally {
            close();
        }
    }

    public void ModifyAdminPw2(int id,String tele,String qqMobile)throws SQLException {
        try {
            connection = SQLHelper.getConnection();
            String sql1="update usermess set  tele = ? ,qqMobile = ? where id = ?";
            pStatement=connection.prepareStatement(sql1);
            pStatement.setInt(3, id);


            pStatement.setString(1,tele);
            pStatement.setString(2,qqMobile);
            pStatement.executeUpdate();

        }finally {
            close();
        }
    }
    public void ModifyAdminPw(int id,String password)throws SQLException {
        try {
            connection = SQLHelper.getConnection();
            String sql1="update usermess set  pword = ? where id = ?";
            pStatement=connection.prepareStatement(sql1);
            pStatement.setInt(2, id);


            pStatement.setString(1,password);

            pStatement.executeUpdate();

        }finally {
            close();
        }
    }
    public static void ModifyAdminPw1(int id, String tele)throws SQLException {
        try {
            connection = SQLHelper.getConnection();
            String sql1="update usermess set  tele = ? where id = ?";
            pStatement=connection.prepareStatement(sql1);
            pStatement.setInt(2, id);


            pStatement.setString(1,tele);

            pStatement.executeUpdate();

        }finally {
            close();
        }
    }

    public static void ModifyAdminPw2(int id, String qqMoile)throws SQLException {
        try {
            connection = SQLHelper.getConnection();
            String sql1="update usermess set  qqMobile = ? where id = ?";
            pStatement=connection.prepareStatement(sql1);
            pStatement.setInt(2, id);


            pStatement.setString(1,qqMoile);

            pStatement.executeUpdate();

        }finally {
            close();
        }
    }

}
