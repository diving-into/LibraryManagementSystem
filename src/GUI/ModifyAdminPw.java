package GUI;

import Dao.UserMessDao;
import Entity.Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ModifyAdminPw extends JFrame {

	private JPanel contentPane;
	private JTextField passwordField;
	private JTextField qqMobileField;
	private JTextField teleField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyAdminPw frame = new ModifyAdminPw();
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
	public ModifyAdminPw() {
		setTitle("修改管理员密码");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel Label = new JLabel("更改管理员信息");
		Label.setFont(new Font("华文楷体", Font.PLAIN, 50));
		Label.setBounds(116, 10, 353, 47);
		panel.add(Label);
		
		JLabel passwordLabel = new JLabel("重置密码：");
		passwordLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		passwordLabel.setBounds(63, 87, 139, 47);
		panel.add(passwordLabel);
		
		JLabel qqMobileLabel = new JLabel("重置QQ邮箱：");
		qqMobileLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		qqMobileLabel.setBounds(38, 153, 164, 47);
		panel.add(qqMobileLabel);
		
		JLabel teleLabel = new JLabel("重置手机号：");
		teleLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		teleLabel.setBounds(38, 222, 164, 47);
		panel.add(teleLabel);
		
		passwordField = new JTextField();
		passwordField.setBounds(199, 87, 244, 38);
		panel.add(passwordField);
		passwordField.setColumns(10);
		
		qqMobileField = new JTextField();
		qqMobileField.setColumns(10);
		qqMobileField.setBounds(199, 153, 244, 38);
		panel.add(qqMobileField);
		
		teleField = new JTextField();
		teleField.setColumns(10);
		teleField.setBounds(199, 222, 244, 38);
		panel.add(teleField);
		
		JButton ModifyButton = new JButton("更改");
		ModifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id= Admin.getRid();
				String password=passwordField.getText();
				
				String tele=teleField.getText();
				String qqMobile=qqMobileField.getText();

				try {
					//手机号为空,但其他两个不为空
					if(tele.length()==0&&password.length()!=0&&qqMobile.length()!=0) {
						if(qqMobile.equals("无效邮箱"))
							JOptionPane.showMessageDialog(ModifyAdminPw.this,"无效邮箱，请重新输入！");
						else {
							UserMessDao.ModifyAdminPw(id, password, qqMobile);
							JOptionPane.showMessageDialog(ModifyAdminPw.this,"更改成功！");
						}
					}
					//手机号密码为空,但qq不为空
					if(tele.length()==0&&password.length()==0&&qqMobile.length()!=0) {
						if(qqMobile.equals("无效邮箱"))
							JOptionPane.showMessageDialog(ModifyAdminPw.this,"无效邮箱，请重新输入！");
						else {
							UserMessDao.ModifyAdminPw2(id, qqMobile);
							JOptionPane.showMessageDialog(ModifyAdminPw.this,"更改成功！");
						}
					}
					//QQ邮箱为空，但其他两个不为空
					if(qqMobile.length()==0&&password.length()!=0&&tele.length()!=0){
						if(tele.equals("无效手机号"))
							JOptionPane.showMessageDialog(ModifyAdminPw.this,"无效手机号，请重新输入！");
						else {
							UserMessDao.ModifyAdminPw1(id,password,tele);
							JOptionPane.showMessageDialog(ModifyAdminPw.this,"更改成功！");
						}
						
					}
					//QQ邮箱密码为空，手机号不为空
					if(qqMobile.length()==0&&password.length()==0&&tele.length()!=0){
						if(tele.equals("无效手机号"))
							JOptionPane.showMessageDialog(ModifyAdminPw.this,"无效手机号，请重新输入！");
						else {
							UserMessDao.ModifyAdminPw1(id,tele);
							JOptionPane.showMessageDialog(ModifyAdminPw.this,"更改成功！");
						}
						
					}
					//密码为空
					if(password.length()==0&&qqMobile.length()!=0&&tele.length()!=0)
					{
						if(tele.equals("无效手机号")||qqMobile.equals("无效邮箱")) {
							JOptionPane.showMessageDialog(ModifyAdminPw.this,"含有无效信息，请重新输入！");
						}
						else {
							UserMessDao.ModifyAdminPw(id, tele, qqMobile);
							JOptionPane.showMessageDialog(ModifyAdminPw.this,"更改成功！");
						}
					}
					UserMessDao.ModifyAdminPw(id, password,  tele, qqMobile);
					//密码不为空，其他均为空
					if(password.length()!=0&&qqMobile.length()==0&&tele.length()==0) {
						UserMessDao.ModifyPM(id,password);
						JOptionPane.showMessageDialog(ModifyAdminPw.this,"修改成功！");
					}
					//均不为空
					if(password.length()!=0&&qqMobile.length()!=0&&tele.length()!=0) {
						if(tele.equals("无效手机号")||qqMobile.equals("无效邮箱")) {
							JOptionPane.showMessageDialog(ModifyAdminPw.this,"含有无效信息，请重新输入！");
						}
						else {
							UserMessDao.ModifyAdminPw(id, password,tele, qqMobile);
							JOptionPane.showMessageDialog(ModifyAdminPw.this,"更改成功！");
						}
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		ModifyButton.setFont(new Font("宋体", Font.PLAIN, 25));
		ModifyButton.setBounds(199, 284, 139, 57);
		panel.add(ModifyButton);
	}

}
