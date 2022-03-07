package GUI;

import Dao.ManagerMess;
import Dao.UserMessDao;
import Entity.UserMess;

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

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
class BgroundPanel1 extends JPanel {

    private String imgPath; // 用于指定图片路径

    public BgroundPanel1(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    protected void paintComponent(Graphics g) {
        ImageIcon icon = new ImageIcon(imgPath);
        g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
public class AddAdminMess extends JFrame {
    int flag1=0,flag2=0,flag3=0,flag4=0;
    private BgroundPanel1 contentPane;
    private JTextField idField;
    private JPasswordField passwordField;
    private JTextField teleField;
    private JTextField qqField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddAdminMess frame = new AddAdminMess();
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
    public AddAdminMess() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 830, 527);
        contentPane = new BgroundPanel1("src/photos/lib2.jpg");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        BgroundPanel1 panel = new BgroundPanel1("src/photos/lib2.jpg");
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("新增管理员信息");
        lblNewLabel.setForeground(SystemColor.info);
        lblNewLabel.setFont(new Font("仿宋", Font.PLAIN, 55));
        lblNewLabel.setBounds(184, 38, 395, 66);
        panel.add(lblNewLabel);

        JLabel idLabel = new JLabel("管理员ID：");
        idLabel.setForeground(SystemColor.info);
        idLabel.setFont(new Font("仿宋", Font.PLAIN, 25));
        idLabel.setBounds(163, 115, 153, 43);
        panel.add(idLabel);

        JLabel passwordLabel = new JLabel("密码：");
        passwordLabel.setForeground(SystemColor.info);
        passwordLabel.setFont(new Font("仿宋", Font.PLAIN, 25));
        passwordLabel.setBounds(213, 187, 153, 43);
        panel.add(passwordLabel);

        JLabel genderLabel = new JLabel("性别：");
        genderLabel.setForeground(SystemColor.info);
        genderLabel.setFont(new Font("仿宋", Font.PLAIN, 25));
        genderLabel.setBounds(213, 257, 153, 43);
        panel.add(genderLabel);

        JLabel teleLabel = new JLabel("手机号码：");
        teleLabel.setForeground(SystemColor.info);
        teleLabel.setFont(new Font("仿宋", Font.PLAIN, 25));
        teleLabel.setBounds(163, 325, 153, 43);
        panel.add(teleLabel);

        JLabel QQMobileLabel = new JLabel("QQ邮箱：");
        QQMobileLabel.setForeground(SystemColor.info);
        QQMobileLabel.setFont(new Font("仿宋", Font.PLAIN, 25));
        QQMobileLabel.setBounds(184, 389, 153, 43);
        panel.add(QQMobileLabel);

        JComboBox genderBox = new JComboBox();
        genderBox.setModel(new DefaultComboBoxModel(new String[] {"男", "女"}));
        genderBox.setFont(new Font("宋体", Font.PLAIN, 21));
        genderBox.setBounds(284, 258, 254, 45);
        panel.add(genderBox);

        idField = new JTextField();
        idField.setColumns(10);
        idField.setBounds(284, 113, 251, 45);
        panel.add(idField);

        passwordField = new JPasswordField();
        passwordField.setColumns(10);
        passwordField.setBounds(284, 185, 254, 45);
        panel.add(passwordField);

        teleField = new JTextField();
        teleField.setColumns(10);
        teleField.setBounds(284, 323, 251, 45);
        panel.add(teleField);

        qqField = new JTextField();
        qqField.setColumns(10);
        qqField.setBounds(284, 389, 251, 45);
        panel.add(qqField);


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

                Pattern pattern=Pattern.compile("[0-9]{0,6}");
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
        qqField.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                String sql2=qqField.getText();
                if(sql2.length()==0) {
                    qqField.setText("QQ邮箱不能为空");
                    qqField.setFont(new Font("宋体", Font.PLAIN, 18));
                    qqField.setForeground(Color.RED);
                }
                Pattern pattern=Pattern.compile("[0-9]{6,10}@qq\\.com");//{}限制前面的数字不影响后面的@qq.com
                Matcher matcher1=pattern.matcher(sql2);
                if(!matcher1.matches()&&!(sql2.length()==0)) {
                    qqField.setText("无效邮箱");
                    qqField.setFont(new Font("宋体", Font.PLAIN, 18));
                    qqField.setForeground(Color.RED);
                    flag4=0;
                }else {
                    flag4=1;
                }

            }

            @Override
            public void focusGained(FocusEvent e) {
                // TODO Auto-generated method stub
                if(qqField.getForeground()==Color.RED)
                    qqField.setText("");
                qqField.setFont(new Font("宋体", Font.PLAIN, 18));
                qqField.setForeground(Color.BLACK);
            }
        });
        JButton newAddButton = new JButton("添加");
        newAddButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(idField.getText());
                String password=passwordField.getText();
                String gender=genderBox.getSelectedItem().toString();//实现复选框数据的获得
                String tele=teleField.getText();
                String qqMobile=qqField.getText();
                try {
                    if(!(password.length()==0)&&!(gender.length()==0)
                            &&!(tele.length()==0)&&!(qqMobile.length()==0)&&flag1!=0&&flag3!=0&&flag4!=0) {
                        ManagerMess.AddAdminMess(id,password,gender,tele,qqMobile);
                        JOptionPane.showMessageDialog(AddAdminMess.this, "添加成功!");
                        AddAdminMess.this.dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(AddAdminMess.this, "请完善所有信息!");
                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }

        });
        newAddButton.setFont(new Font("宋体", Font.PLAIN, 24));
        newAddButton.setBounds(629, 389, 129, 43);
        panel.add(newAddButton);
    }
}

