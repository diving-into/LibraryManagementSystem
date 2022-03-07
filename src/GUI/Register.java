package GUI;


import Dao.UserMessDao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import java.awt.SystemColor;
class BgroundPanel3 extends JPanel {

    private String imgPath; // 用于指定图片路径

    public BgroundPanel3(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    protected void paintComponent(Graphics g) {
        ImageIcon icon = new ImageIcon(imgPath);
        g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
public class Register extends JFrame {
    int flag1=0,flag2=0,flag3=0,flag4=0;
    private BgroundPanel3 contentPane;
    private JTextField idField;
    private JPasswordField passwordField;
    private JPasswordField rePasswordField;
    private JTextField teleField;
    private JTextField qqMobileField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Register frame = new Register();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Scanner scanner=new Scanner(System.in);
        String select=scanner.nextLine();
    }

    /**
     * Create the frame.
     */
    public Register() {
        setBounds(100, 100, 800, 500);
        contentPane = new BgroundPanel3("src/photos/lib2.jpg");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        BgroundPanel3 panel = new BgroundPanel3("src/photos/lib2.jpg");
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel registerLabel = new JLabel("注 册 界 面");
        registerLabel.setForeground(SystemColor.inactiveCaption);
        registerLabel.setFont(new Font("宋体", Font.PLAIN, 40));
        registerLabel.setBounds(268, 45, 242, 58);
        panel.add(registerLabel);

        JLabel idLabel = new JLabel("用户ID：");
        idLabel.setForeground(SystemColor.info);
        idLabel.setFont(new Font("宋体", Font.PLAIN, 21));
        idLabel.setBounds(37, 147, 83, 24);
        panel.add(idLabel);

        idField = new JTextField();
        idField.setBounds(130, 139, 251, 45);
        panel.add(idField);
        idField.setColumns(10);

        JLabel passwLabel = new JLabel("密码：");
        passwLabel.setForeground(SystemColor.info);
        passwLabel.setFont(new Font("宋体", Font.PLAIN, 21));
        passwLabel.setBounds(57, 213, 83, 24);
        panel.add(passwLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(130, 205, 251, 45);
        panel.add(passwordField);
        passwordField.setColumns(10);

        JLabel passworLabel = new JLabel("确认密码：");
        passworLabel.setForeground(SystemColor.info);
        passworLabel.setFont(new Font("宋体", Font.PLAIN, 21));
        passworLabel.setBounds(27, 279, 113, 24);
        panel.add(passworLabel);

        rePasswordField = new JPasswordField();
        rePasswordField.setColumns(10);
        rePasswordField.setBounds(130, 271, 251, 45);
        panel.add(rePasswordField);


        JLabel gender = new JLabel("性别：");
        gender.setForeground(SystemColor.info);
        gender.setFont(new Font("宋体", Font.PLAIN, 21));
        gender.setBounds(424, 148, 94, 22);
        panel.add(gender);

        JLabel teleNumber = new JLabel("手机号：");
        teleNumber.setForeground(SystemColor.info);
        teleNumber.setFont(new Font("宋体", Font.PLAIN, 21));
        teleNumber.setBounds(413, 215, 94, 22);
        panel.add(teleNumber);

        teleField = new JTextField();
        teleField.setColumns(10);
        teleField.setBounds(497, 205, 251, 45);
        panel.add(teleField);

        JLabel postNumber = new JLabel("邮箱：");
        postNumber.setForeground(SystemColor.info);
        postNumber.setFont(new Font("宋体", Font.PLAIN, 21));
        postNumber.setBounds(424, 280, 94, 22);
        panel.add(postNumber);

        qqMobileField = new JTextField();
        qqMobileField.setColumns(10);
        qqMobileField.setBounds(497, 271, 251, 45);
        panel.add(qqMobileField);

        JComboBox genderBox = new JComboBox();
        genderBox.setFont(new Font("宋体", Font.PLAIN, 21));
        genderBox.setModel(new DefaultComboBoxModel(new String[] {"男", "女"}));
        genderBox.setBounds(497, 139, 251, 45);
        panel.add(genderBox);




        //ID验证
        idField.addFocusListener(new FocusListener() {//焦点监听器

            @Override
            public void focusLost(FocusEvent e) {
                // TODO Auto-generated method stub
                String sql1=idField.getText();
                if(sql1.length()==0) {
                    idField.setText("ID不能为空");
                    idField.setFont(new Font("宋体", Font.PLAIN, 18));
                    idField.setForeground(Color.RED);
                }

                Pattern pattern=Pattern.compile("[0-9]{6}");
                Matcher matcher1=pattern.matcher(sql1);
                if(!matcher1.matches()&&!(sql1.length()==0)) {
                    idField.setText("无效ID");
                    idField.setFont(new Font("宋体", Font.PLAIN, 18));
                    idField.setForeground(Color.RED);
                }

            }

            @Override
            public void focusGained(FocusEvent e) {
                // TODO Auto-generated method stub
                if(idField.getForeground()==Color.RED) {//if语句防止再次点击时原来的内容消失
                    idField.setText("");
                }

                idField.setFont(new Font("宋体", Font.PLAIN, 18));
                idField.setForeground(Color.BLACK);


            }
        });

        //密码验证
        passwordField.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                String sql2=passwordField.getText();
                if(sql2.length()==0) {
//					passwordField.setText("密码不能为空");
                    JOptionPane.showMessageDialog(passwordField, "密码不能为空");
                    passwordField.setFont(new Font("宋体", Font.PLAIN, 18));
                    passwordField.setForeground(Color.RED);

                }

                Pattern pattern=Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z0-9]{6,15}$");
                Matcher matcher1=pattern.matcher(sql2);
                if(!matcher1.matches()&&!(sql2.length()==0)) {
//					passwordField.setText("无效密码");
                    JOptionPane.showMessageDialog(passwordField, "密码格式不正确");
                    passwordField.setFont(new Font("宋体", Font.PLAIN, 18));

                    passwordField.setForeground(Color.RED);
                    flag1=0;
                }
                else {
                    flag1=1;
                }

            }

            @Override
            public void focusGained(FocusEvent e) {
                if(passwordField.getForeground()==Color.RED)
                    passwordField.setText("");
                passwordField.setFont(new Font("宋体", Font.PLAIN, 18));
                passwordField.setForeground(Color.BLACK);
            }
        });

        //确认密码验证
        rePasswordField.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                Pattern pattern=Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z0-9]{6,15}$");

                String sql2=rePasswordField.getText();
                String sqlString=passwordField.getText();
                Matcher matcher1=pattern.matcher(sqlString);
                boolean match = matcher1.matches();
                if(sql2.length()==0&&sqlString.length()!=0&&match) {
                    JOptionPane.showMessageDialog(rePasswordField, "确认密码不能为空");
//					rePasswordField.setText("确认密码不能为空");


//					rePasswordField.setFont(new Font("宋体", Font.PLAIN, 18));
//					rePasswordField.setForeground(Color.RED);
//					textPane.setText("确认密码不能为空");
//					textPane.setFont(new Font("宋体", Font.PLAIN, 10));
//					textPane.setForeground(Color.RED);
                }
                if(!sql2.equals(passwordField.getText())&&!(sql2.length()==0)) {
//					rePasswordField.setText("确认密码与原密码不一致");
                    JOptionPane.showMessageDialog(rePasswordField, "确认密码与原密码不一致");
                    rePasswordField.setFont(new Font("宋体", Font.PLAIN, 18));
                    rePasswordField.setForeground(Color.RED);
                    flag2=0;
                }else {
                    if(match)
                        flag2=1;
                }

            }

            @Override
            public void focusGained(FocusEvent e) {
                // TODO Auto-generated method stub
                if(rePasswordField.getForeground()==Color.RED)
                    rePasswordField.setText("");
                rePasswordField.setFont(new Font("宋体", Font.PLAIN, 18));
                rePasswordField.setForeground(Color.BLACK);
            }
        });

        //手机号验证
        teleField.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                String sql2=teleField.getText();
                if(sql2.length()==0) {
                    teleField.setText("手机号码不能为空");
                    teleField.setFont(new Font("宋体", Font.PLAIN, 18));
                    teleField.setForeground(Color.RED);
                }

                Pattern pattern=Pattern.compile("1[3578][0-9]{9}");
                Matcher matcher1=pattern.matcher(sql2);
                if(!matcher1.matches()&&!(sql2.length()==0)) {
                    teleField.setText("无效手机号");
                    teleField.setFont(new Font("宋体", Font.PLAIN, 18));
                    teleField.setForeground(Color.RED);
                    flag3=0;
                }
                else {
                    flag3=1;
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if(teleField.getForeground()==Color.RED)
                    teleField.setText("");
                teleField.setFont(new Font("宋体", Font.PLAIN, 18));
                teleField.setForeground(Color.BLACK);
            }
        });

        //QQ邮箱验证
        qqMobileField.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                String sql2=qqMobileField.getText();
                if(sql2.length()==0) {
                    qqMobileField.setText("QQ邮箱不能为空");
                    qqMobileField.setFont(new Font("宋体", Font.PLAIN, 18));
                    qqMobileField.setForeground(Color.RED);
                }
                Pattern pattern=Pattern.compile("[0-9]{6,10}@qq\\.com");//{}限制前面的数字不影响后面的@qq.com
                Matcher matcher1=pattern.matcher(sql2);
                if(!matcher1.matches()&&!(sql2.length()==0)) {
                    qqMobileField.setText("无效邮箱");
                    qqMobileField.setFont(new Font("宋体", Font.PLAIN, 18));
                    qqMobileField.setForeground(Color.RED);
                    flag4=0;
                }else {
                    flag4=1;
                }

            }

            @Override
            public void focusGained(FocusEvent e) {
                // TODO Auto-generated method stub
                if(qqMobileField.getForeground()==Color.RED)
                    qqMobileField.setText("");
                qqMobileField.setFont(new Font("宋体", Font.PLAIN, 18));
                qqMobileField.setForeground(Color.BLACK);
            }
        });
        JButton registerButton = new JButton("注册");
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int id=Integer.parseInt(idField.getText());
                String password=passwordField.getText();
                String rePassword=rePasswordField.getText();
                String gender=genderBox.getSelectedItem().toString();//实现复选框数据的获得
                String tele=teleField.getText();
                String qqMobile=qqMobileField.getText();

                if(!(password.length()==0)&&!(rePassword.length()==0)&&!(gender.length()==0)
                        &&!(tele.length()==0)&&!(qqMobile.length()==0)&&flag1!=0&&flag2!=0&&flag3!=0&&flag4!=0) {
                    UserMessDao.Register(id,password,rePassword,gender,tele,qqMobile);
                    JOptionPane.showMessageDialog(Register.this, "注册成功!");
                    Register.this.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(Register.this, "请完善所有信息!");
                }


            }
        });
        registerButton.setFont(new Font("宋体", Font.PLAIN, 18));
        registerButton.setBounds(326, 360, 121, 45);
        panel.add(registerButton);
    }
}
