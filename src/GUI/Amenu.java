package GUI;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Amenu extends JFrame {

    private JPanel MenuPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Amenu frame = new Amenu();
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
    public Amenu() {
        setTitle("管理员操作菜单");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 665, 521);
        MenuPane = new JPanel();
        MenuPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(MenuPane);
        MenuPane.setLayout(null);

        JButton UpdatePasswordButton = new JButton("修改密码");
        UpdatePasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ModifyAdminPw modifyAdminPw=new ModifyAdminPw();
                modifyAdminPw.setVisible(true);
            }
        });
        UpdatePasswordButton.setFont(new Font("宋体", Font.PLAIN, 20));
        UpdatePasswordButton.setBounds(197, 128, 242, 39);
        MenuPane.add(UpdatePasswordButton);

        JButton AddAdminButton = new JButton("添加其他管理员账户");
        AddAdminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddAdminMess addAdminMess=new AddAdminMess();
                addAdminMess.setVisible(true);
            }
        });
        AddAdminButton.setFont(new Font("宋体", Font.PLAIN, 20));
        AddAdminButton.setBounds(197, 194, 242, 39);
        MenuPane.add(AddAdminButton);

        JButton OperationButton = new JButton("管理图书");
        OperationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AOperation().setVisible(true);
            }
        });
        OperationButton.setFont(new Font("宋体", Font.PLAIN, 20));
        OperationButton.setBounds(197, 262, 242, 39);
        MenuPane.add(OperationButton);

        JButton FindBookButton = new JButton("查询图书信息");
        FindBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                  new queryBooks();
            }
        });
        FindBookButton.setFont(new Font("宋体", Font.PLAIN, 20));
        FindBookButton.setBounds(197, 330, 242, 39);
        MenuPane.add(FindBookButton);

        JButton FindReaderButton = new JButton("查询借阅记录");
        FindReaderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new queryRecords();
            }
        });
        FindReaderButton.setFont(new Font("宋体", Font.PLAIN, 20));
        FindReaderButton.setBounds(197, 396, 242, 39);
        MenuPane.add(FindReaderButton);

        JLabel AdminLabel = new JLabel("管理员操作菜单");
        AdminLabel.setFont(new Font("宋体", Font.PLAIN, 30));
        AdminLabel.setBounds(209, 50, 223, 48);
        MenuPane.add(AdminLabel);
    }
}
