package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ReaderFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderFrame frame = new ReaderFrame();
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
	public ReaderFrame() {
		setTitle("用户");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 661, 520);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 637, 473);
		panel.add(panel_1);
		
		JButton queryButton_1 = new JButton("查询记录");
		queryButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BorrowReturnDetails().setVisible(true);
				
			}
		});
		queryButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		queryButton_1.setBounds(243, 251, 117, 41);
		panel_1.add(queryButton_1);
		
		JButton leaveButton = new JButton("退出");
		leaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		System.exit(0);
			}
		});
		leaveButton.setBounds(243, 326, 117, 41);
		panel_1.add(leaveButton);
		leaveButton.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton changeButton = new JButton("修改用户个人信息");
		changeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ModifyPersonMessage modifyPersonMessage=new ModifyPersonMessage();
			modifyPersonMessage.setVisible(true);// 必须有JFRAME
			}
		});
		changeButton.setBounds(194, 105, 213, 41);
		panel_1.add(changeButton);
		changeButton.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton queryButton = new JButton("查询图书");
		queryButton.setBounds(243, 176, 117, 41);
		panel_1.add(queryButton);
		queryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReaderQueryFrame().setVisible(true);
			}
		});
		queryButton.setFont(new Font("宋体", Font.PLAIN, 20));
		changeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			}
		});
	}
}
