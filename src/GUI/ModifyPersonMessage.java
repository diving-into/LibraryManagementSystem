package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.BookInformationDao;
import Dao.UserMessDao;
import Entity.Reader;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ModifyPersonMessage extends JFrame {

	private JPanel contentPane;
	private JPasswordField mpasswordField;
	private JPasswordField cmpasswordField;
	private JTextField mteleField;
	private JTextField mqqmobileField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyPersonMessage frame = new ModifyPersonMessage();
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
	public ModifyPersonMessage() {
		setTitle("修改个人信息");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 743, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("修改个人信息");
		lblNewLabel.setFont(new Font("仿宋", Font.PLAIN, 60));
		lblNewLabel.setBounds(171, 26, 381, 69);
		panel.add(lblNewLabel);
		
		JLabel mpwLabel = new JLabel("修改密码:");
		mpwLabel.setFont(new Font("华文仿宋", Font.PLAIN, 25));
		mpwLabel.setBounds(136, 105, 122, 42);
		panel.add(mpwLabel);
		
		JLabel comfirmpwLable = new JLabel("确认密码:");
		comfirmpwLable.setFont(new Font("华文仿宋", Font.PLAIN, 25));
		comfirmpwLable.setBounds(136, 168, 122, 42);
		panel.add(comfirmpwLable);
		
		JLabel mteleLable = new JLabel("修改手机号:");
		mteleLable.setFont(new Font("华文仿宋", Font.PLAIN, 25));
		mteleLable.setBounds(136, 232, 130, 42);
		panel.add(mteleLable);
		
		JLabel lblqq = new JLabel("修改QQ邮箱:");
		lblqq.setFont(new Font("华文仿宋", Font.PLAIN, 25));
		lblqq.setBounds(136, 295, 162, 42);
		panel.add(lblqq);
		
		mpasswordField = new JPasswordField();
		mpasswordField.setBounds(268, 105, 284, 42);
		panel.add(mpasswordField);
		
		cmpasswordField = new JPasswordField();
		cmpasswordField.setBounds(268, 168, 284, 42);
		panel.add(cmpasswordField);
		
		JButton modifyButton = new JButton("修改");
		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id= Reader.getRid();
				String password=mpasswordField.getText();
				String rePassword=cmpasswordField.getText();
				
				String tele=mteleField.getText();
				String qqMobile=mqqmobileField.getText();
				System.out.println(id);

				try {
					//1.
					if(tele.length()==0&&password.length()!=0&&rePassword.length()!=0&&qqMobile.length()!=0) {
						if(qqMobile.equals("无效邮箱"))
							JOptionPane.showMessageDialog(ModifyPersonMessage.this,"无效邮箱，请重新输入！");
						else {
							UserMessDao.ModifyPM(id,password,rePassword,qqMobile);

							JOptionPane.showMessageDialog(ModifyPersonMessage.this,"修改成功！");
						}
					}
						
					if(qqMobile.length()==0&&password.length()!=0&&rePassword.length()!=0&&tele.length()!=0){
						if(tele.equals("无效手机号"))
							JOptionPane.showMessageDialog(ModifyPersonMessage.this,"无效手机号，请重新输入！");
						else {
							UserMessDao.ModifyPM1(id,password,rePassword,tele);
							JOptionPane.showMessageDialog(ModifyPersonMessage.this,"修改成功！");
						}
						
					}
						
					if(password.length()==0&&rePassword.length()==0&&qqMobile.length()!=0&&tele.length()!=0)
					{
						if(tele.equals("无效手机号")||qqMobile.equals("无效邮箱")) {
							JOptionPane.showMessageDialog(ModifyPersonMessage.this,"含有无效信息，请重新输入！");
						}
						else {
							UserMessDao.ModifyPM2(id,tele,qqMobile);
							JOptionPane.showMessageDialog(ModifyPersonMessage.this,"修改成功！");
						}
					}
						
					if(password.length()!=0&&rePassword.length()!=0&&qqMobile.length()==0&&tele.length()==0) {
						UserMessDao.ModifyPM(id,password,rePassword);
						JOptionPane.showMessageDialog(ModifyPersonMessage.this,"修改成功！");
					}
						
					if(password.length()==0&&rePassword.length()==0&&qqMobile.length()==0&&tele.length()!=0) {
						if(tele.equals("无效手机号"))
							JOptionPane.showMessageDialog(ModifyPersonMessage.this,"无效手机号，请重新输入！");
						else {
							UserMessDao.ModifyPM(id,tele);
							JOptionPane.showMessageDialog(ModifyPersonMessage.this,"修改成功！");
						}
						
					}
						
					if(password.length()==0&&rePassword.length()==0&&tele.length()==0&&qqMobile.length()!=0) {
						if(qqMobile.equals("无效邮箱"))
							JOptionPane.showMessageDialog(ModifyPersonMessage.this,"无效邮箱，请重新输入！");
						else {
							UserMessDao.ModifyPM3(id,qqMobile);
							JOptionPane.showMessageDialog(ModifyPersonMessage.this,"修改成功！");
						}
					}
						
					if(password.length()!=0&&rePassword.length()!=0&&qqMobile.length()!=0&&tele.length()!=0) {
						if(tele.equals("无效手机号")||qqMobile.equals("无效邮箱")) {
							JOptionPane.showMessageDialog(ModifyPersonMessage.this,"含有无效信息，请重新输入！");
						}
						else {
							UserMessDao.ModifyPM(id,password,rePassword,tele,qqMobile);
							JOptionPane.showMessageDialog(ModifyPersonMessage.this,"修改成功！");
						}
					}
						
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		modifyButton.setFont(new Font("华文仿宋", Font.PLAIN, 30));
		modifyButton.setBounds(262, 359, 194, 57);
		panel.add(modifyButton);
		
		mteleField = new JTextField();
		mteleField.setBounds(292, 232, 271, 42);
		panel.add(mteleField);
		mteleField.setColumns(10);
		
		mqqmobileField = new JTextField();
		mqqmobileField.setColumns(10);
		mqqmobileField.setBounds(292, 295, 271, 42);
		panel.add(mqqmobileField);
		
		//密码验证
				mpasswordField.addFocusListener(new FocusListener() {
					
					@Override
					public void focusLost(FocusEvent e) {
						String sql2=mpasswordField.getText();
						
						
						Pattern pattern=Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z0-9]{6,15}$");
						Matcher matcher1=pattern.matcher(sql2);
						if(!matcher1.matches()&&!(sql2.length()==0)) {
							JOptionPane.showMessageDialog(mpasswordField, "密码格式不正确");

//							mpasswordField.setText("无效密码");
							mpasswordField.setFont(new Font("宋体", Font.PLAIN, 18));
							mpasswordField.setForeground(Color.RED);
						}
						
					}
					
					@Override
					public void focusGained(FocusEvent e) {
						if(mpasswordField.getForeground()==Color.RED)
							mpasswordField.setText("");
						mpasswordField.setFont(new Font("宋体", Font.PLAIN, 18));
						mpasswordField.setForeground(Color.BLACK);
					}
				});
				
				//确认密码验证
				cmpasswordField.addFocusListener(new FocusListener() {
					
					@Override
					public void focusLost(FocusEvent e) {
						String sql2=cmpasswordField.getText();
					
						if(!sql2.equals(mpasswordField.getText())&&!(sql2.length()==0)) {
							JOptionPane.showMessageDialog(cmpasswordField, "确认密码与原密码不一致");
//							cmpasswordField.setText("确认密码与原密码不一致");
							cmpasswordField.setFont(new Font("宋体", Font.PLAIN, 18));
							cmpasswordField.setForeground(Color.RED);
						}
					}
					
					
					@Override
					public void focusGained(FocusEvent e) {
						// TODO Auto-generated method stub
						if(cmpasswordField.getForeground()==Color.RED)
							cmpasswordField.setText("");
						cmpasswordField.setFont(new Font("宋体", Font.PLAIN, 18));
						cmpasswordField.setForeground(Color.BLACK);
					}
				});
				
				//手机号验证
				mteleField.addFocusListener(new FocusListener() {
					
					@Override
					public void focusLost(FocusEvent e) {
						String sql2=mteleField.getText();
						
						Pattern pattern=Pattern.compile("1[3578][0-9]{9}");
						Matcher matcher1=pattern.matcher(sql2);
						if(!matcher1.matches()&&!(sql2.length()==0)) {
							mteleField.setText("无效手机号");
							mteleField.setFont(new Font("宋体", Font.PLAIN, 18));
							mteleField.setForeground(Color.RED);
						}
						
					}
					
					@Override
					public void focusGained(FocusEvent e) {
						if(mteleField.getForeground()==Color.RED)
							mteleField.setText("");
						mteleField.setFont(new Font("宋体", Font.PLAIN, 18));
						mteleField.setForeground(Color.BLACK);
					}
				});
				
				//QQ邮箱验证
				mqqmobileField.addFocusListener(new FocusListener() {
					
					@Override
					public void focusLost(FocusEvent e) {
						String sql2=mqqmobileField.getText();
						
						Pattern pattern=Pattern.compile("[0-9]{6,10}@qq\\.com");//{}限制前面的数字不影响后面的@qq.com
						Matcher matcher1=pattern.matcher(sql2);
						if(!matcher1.matches()&&!(sql2.length()==0)) {
							mqqmobileField.setText("无效邮箱");
							mqqmobileField.setFont(new Font("宋体", Font.PLAIN, 18));
							mqqmobileField.setForeground(Color.RED);
						}
						
					}
					
					@Override
					public void focusGained(FocusEvent e) {
						// TODO Auto-generated method stub
						if(mqqmobileField.getForeground()==Color.RED)
							mqqmobileField.setText("");
						mqqmobileField.setFont(new Font("宋体", Font.PLAIN, 18));
						mqqmobileField.setForeground(Color.BLACK);
					}
				});
	}
}
