package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

import static Dao.BookInformationDao.queryBooksByReaderName3;
import static Dao.DetailsDao.*;

public class queryRecords extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private DefaultTableModel defaultTableModel;
	private JScrollPane scrollPane = new JScrollPane();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					queryRecords frame = new queryRecords();
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
	public queryRecords() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u501F\u8FD8\u8BB0\u5F55");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(281, 10, 101, 36);
		contentPane.add(lblNewLabel);
		
		String[] columnNames = {"编号", "书名", "状态", "借出时间", "归还时间"};
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.setColumnIdentifiers(columnNames);
		table = new JTable(defaultTableModel);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 45, 646, 147);
		getContentPane().add(scrollPane);
		scrollPane.setVisible(true);
		//table.setBounds(10, 45, 646, 147);
		//contentPane.add(table);
		
		textField = new JTextField();
		textField.setBounds(213, 215, 443, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u7528\u6237ID \uFF1A");
		lblNewLabel_1.setFont(new Font("幼圆", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(39, 212, 164, 36);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2\u501F\u9605\u8BB0\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.removeAll();
				defaultTableModel.setRowCount(0);
				getContentPane().add(scrollPane);
				ResultSet rs = queryBorrowRecordsById(Integer.valueOf(textField.getText()));

				String[] columnNames = {"编号", "书名", "状态", "借出时间", "归还时间"};
				defaultTableModel.setColumnIdentifiers(columnNames);
				try {
					while (rs.next()) {
						Vector<String> v = new Vector<>(5);
						v.add(0, rs.getString("Rid"));
						v.add(1, rs.getString("Dname"));
						v.add(2, rs.getString("Bstatus"));
						v.add(3, rs.getString("BborrowDate"));
						v.add(4, rs.getString("BreturnDate"));
						defaultTableModel.addRow(v);

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				table = new JTable(defaultTableModel);
				scrollPane = new JScrollPane(table);
				scrollPane.setBounds(10, 45, 646, 147);
				getContentPane().add(scrollPane);
				scrollPane.setVisible(true);
			   
			}
		});
		btnNewButton.setBounds(39, 287, 118, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2\u8FD8\u4E66\u8BB0\u5F55");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.removeAll();
				defaultTableModel.setRowCount(0);
				getContentPane().add(scrollPane);
				ResultSet rs =queryReturnRecordsById(Integer.valueOf(textField.getText()));
				String[] columnNames = {"编号", "书名", "状态", "借出时间", "归还时间"};
				defaultTableModel.setColumnIdentifiers(columnNames);
				try {
					while (rs.next()) {
						Vector<String> v = new Vector<>(5);
						v.add(0, rs.getString("Rid"));
						v.add(1, rs.getString("Dname"));
						v.add(2, rs.getString("Bstatus"));
						v.add(3, rs.getString("BborrowDate"));
						v.add(4, rs.getString("BreturnDate"));
						defaultTableModel.addRow(v);

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				table = new JTable(defaultTableModel);
				scrollPane = new JScrollPane(table);
				scrollPane.setBounds(10, 45, 646, 147);
				getContentPane().add(scrollPane);
				scrollPane.setVisible(true);
			 }
		});
		btnNewButton_1.setBounds(281, 287, 120, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u67E5\u8BE2\u672A\u8FD8\u56FE\u4E66");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.removeAll();
				defaultTableModel.setRowCount(0);
				getContentPane().add(scrollPane);
				ResultSet resultSet = queryNotReturnRecordsById(Integer.valueOf(textField.getText()));
				try {
					ResultSet rs = queryBooksByReaderName3(resultSet.getString("Dname"));
					String[] columnNames = {"编号", "书名", "状态", "借出时间", "归还时间"};
					defaultTableModel.setColumnIdentifiers(columnNames);
					try {
						while (rs.next()) {
							Vector<String> v = new Vector<>(5);
							v.add(0, rs.getString("Rid"));
							v.add(1, rs.getString("Dname"));
							v.add(2, rs.getString("Bstatus"));
							v.add(3, rs.getString("BborrowDate"));
							v.add(4, rs.getString("BreturnDate"));
							defaultTableModel.addRow(v);
						
						}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				} catch (SQLException se) {
					se.printStackTrace();
				}
				table = new JTable(defaultTableModel);
				scrollPane = new JScrollPane(table);
				scrollPane.setBounds(10, 45, 646, 147);
				getContentPane().add(scrollPane);
				scrollPane.setVisible(true);
			 }
		});
		btnNewButton_2.setBounds(538, 287, 118, 36);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u70B9\u51FB\u8DF3\u8F6C");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queryBookStatus frame = new queryBookStatus();
				frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(315, 356, 120, 30);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("\u70B9\u51FB\u67E5\u8BE2\u56FE\u4E66\u7684\u501F\u9605\u4FE1\u606F\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(39, 353, 250, 33);
		contentPane.add(lblNewLabel_2);
		setVisible(true);
	}
}
