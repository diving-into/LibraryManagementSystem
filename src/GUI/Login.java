package GUI;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Dao.BookInformationDao;
import Dao.UserMessDao;
import Entity.Admin;
import Entity.Reader;
import Entity.UserMess;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;



import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import java.awt.SystemColor;
class BgroundPanel2 extends JPanel {

    private String imgPath; // 用于指定图片路径

    public BgroundPanel2(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    protected void paintComponent(Graphics g) {
        ImageIcon icon = new ImageIcon(imgPath);
        g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
public class Login extends JFrame {

    private BgroundPanel2 contentPane;
    private JTextField idField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Login() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new BgroundPanel2("src/photos/lib.jpg");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("图书信息管理系统");
        lblNewLabel.setForeground(SystemColor.info);
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 35));
        lblNewLabel.setBounds(300, 10, 298, 83);
        contentPane.add(lblNewLabel);

        JLabel idLabel = new JLabel("ID：");
        idLabel.setForeground(SystemColor.info);
        idLabel.setFont(new Font("宋体", Font.PLAIN, 21));
        idLabel.setBounds(236, 198, 106, 41);
        contentPane.add(idLabel);

        idField = new JTextField();
        idField.setBounds(300, 192, 287, 47);
        contentPane.add(idField);
        idField.setColumns(10);


        JLabel passwordLabel = new JLabel("密码：");
        passwordLabel.setForeground(SystemColor.info);
        passwordLabel.setFont(new Font("宋体", Font.PLAIN, 21));
        passwordLabel.setBounds(233, 278, 71, 24);
        contentPane.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(300, 266, 287, 47);
        contentPane.add(passwordField);
        passwordField.setColumns(10);

        JLabel UserLabel = new JLabel("身份：");
        UserLabel.setForeground(SystemColor.info);
        UserLabel.setFont(new Font("宋体", Font.PLAIN, 21));
        UserLabel.setBounds(235, 135, 69, 24);
        contentPane.add(UserLabel);

        JComboBox userBox = new JComboBox();
        userBox.setModel(new DefaultComboBoxModel(new String[] {"普通用户", "管理员"}));
        userBox.setFont(new Font("宋体", Font.PLAIN, 21));
        userBox.setBounds(300, 120, 287, 47);
        contentPane.add(userBox);

        JButton loginButton = new JButton("登录");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(idField.getText());
                String password=passwordField.getText();
                String userString=userBox.getSelectedItem().toString();
                if(userString.equals("普通用户")) {
                    Reader reader=new Reader(id);
                }
                else {
                    Admin admin = new Admin(id);
                }

                try {
                    UserMessDao.Login(id,password,userString);
//					Login.this.dispose();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
        });
        loginButton.setFont(new Font("宋体", Font.PLAIN, 18));
        loginButton.setBounds(300, 364, 106, 41);
        contentPane.add(loginButton);

        JButton loginButton_1 = new JButton("注册");
        loginButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userboxString=userBox.getSelectedItem().toString();
                if(userboxString.equals("普通用户")) {
                    Register register=new Register();
                    register.setVisible(true);
                }
                else {
                    Amenu amenu=new Amenu();
                    amenu.setVisible(true);
                }

            }
        });
        loginButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
        loginButton_1.setBounds(481, 364, 106, 41);
        contentPane.add(loginButton_1);

        JLabel lblNewLabel_1 = new JLabel("欢迎");
        lblNewLabel_1.setForeground(SystemColor.inactiveCaption);
        lblNewLabel_1.setFont(new Font("幼圆", Font.PLAIN, 60));
        lblNewLabel_1.setBounds(10, 70, 174, 89);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("来到");
        lblNewLabel_2.setForeground(SystemColor.inactiveCaption);
        lblNewLabel_2.setFont(new Font("幼圆", Font.PLAIN, 60));
        lblNewLabel_2.setBounds(10, 143, 132, 96);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("时光");
        lblNewLabel_3.setForeground(SystemColor.inactiveCaption);
        lblNewLabel_3.setFont(new Font("幼圆", Font.PLAIN, 60));
        lblNewLabel_3.setBounds(10, 224, 132, 78);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("书馆");
        lblNewLabel_4.setForeground(SystemColor.inactiveCaption);
        lblNewLabel_4.setFont(new Font("幼圆", Font.PLAIN, 60));
        lblNewLabel_4.setBounds(10, 296, 132, 78);
        contentPane.add(lblNewLabel_4);


    }

}

