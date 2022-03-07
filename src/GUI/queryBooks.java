package GUI;

import Dao.BookInformationDao;
import Entity.BookInformation;
import Utility.SQLHelper;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;




import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.print.attribute.standard.PrinterMessageFromOperator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import static Dao.BookInformationDao.*;

public class queryBooks extends JFrame {
	private JPanel contentPane;
	private JTable table_1;
	private JTextField textField;
	private DefaultTableModel defaultTableModel;
	private JScrollPane scrollPane = new JScrollPane();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					queryBooks frame = new queryBooks();
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
	public queryBooks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u67E5\u8BE2\u56FE\u4E66\u4FE1\u606F");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(302, 10, 131, 30);
		contentPane.add(lblNewLabel);
		
//		
		//table_1.setBounds(26, 56, 375, 121);
		
		String[] columnNames = {"编号", "书名", "数量", "作者", "出版社", "位置", "借阅人", "入库时间", "状态", "借出时间", "归还时间"};
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.setColumnIdentifiers(columnNames);
		
		table_1 = new JTable(defaultTableModel);
		scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(26, 56, 694, 172);
		getContentPane().add(scrollPane);
		scrollPane.setVisible(true);
		
		JButton btnNewButton = new JButton("\u901A\u8FC7\u7F16\u53F7\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.removeAll();
				defaultTableModel.setRowCount(0);
				getContentPane().add(scrollPane);
				ResultSet rs = BookInformationDao.queryBooksById(Integer.valueOf(textField.getText()));
				String[] columnNames = {"编号", "书名", "数量", "作者", "出版社", "位置", "借阅人", "入库时间", "状态", "借出时间", "归还时间"};
				defaultTableModel.setColumnIdentifiers(columnNames);
				try {
					while (rs.next()) {
						Vector<String> v = new Vector<>(11);
						v.add(0, rs.getString("Bid"));
						v.add(1, rs.getString("Bname"));
						v.add(2, rs.getString("Bwriter"));
						v.add(3, rs.getString("Bposition"));
						v.add(4, rs.getString("BreaderName"));
						v.add(5, rs.getString("Bnumber"));
						v.add(6, rs.getString("Bookpublish"));
						v.add(7, rs.getString("BinDate"));
						v.add(8, rs.getString("Bstatus"));
						v.add(9, rs.getString("BborrowDate"));
						v.add(10, rs.getString("BreturnDate"));	
						defaultTableModel.addRow(v);
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}
				table_1 = new JTable(defaultTableModel);
				scrollPane = new JScrollPane(table_1);
				scrollPane.setBounds(26, 56, 694, 172);
				getContentPane().add(scrollPane);
				scrollPane.setVisible(true);
			}
		});
		btnNewButton.setBounds(39, 318, 151, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u901A\u8FC7\u540D\u79F0\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.removeAll();
				defaultTableModel.setRowCount(0);
				getContentPane().add(scrollPane);
				ResultSet rs = queryBooksByName(textField.getText());
				String[] columnNames = {"编号", "书名", "数量", "作者", "出版社", "位置", "借阅人", "入库时间", "状态", "借出时间", "归还时间"};
				defaultTableModel.setColumnIdentifiers(columnNames);
				try {
					while (rs.next()) {
						Vector<String> v = new Vector<>(11);
						v.add(0, rs.getString("Bid"));
						v.add(1, rs.getString("Bname"));
						v.add(2, rs.getString("Bwriter"));
						v.add(3, rs.getString("Bposition"));
						v.add(4, rs.getString("BreaderName"));
						v.add(5, rs.getString("Bnumber"));
						v.add(6, rs.getString("Bookpublish"));
						v.add(7, rs.getString("BinDate"));
						v.add(8, rs.getString("Bstatus"));
						v.add(9, rs.getString("BborrowDate"));
						v.add(10, rs.getString("BreturnDate"));	
						defaultTableModel.addRow(v);
					
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}
				table_1 = new JTable(defaultTableModel);
				scrollPane = new JScrollPane(table_1);
				scrollPane.setBounds(26, 56, 694, 172);
				getContentPane().add(scrollPane);
				scrollPane.setVisible(true);
			}
			
		});
		btnNewButton_1.setBounds(290, 318, 160, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u901A\u8FC7\u5165\u5E93\u65F6\u95F4\u67E5\u8BE2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.removeAll();
				defaultTableModel.setRowCount(0);
				getContentPane().add(scrollPane);
				Date date = Date.valueOf(textField.getText());
			
				ResultSet rs =queryBooksByDate(date);
				String[] columnNames = {"编号", "书名", "数量", "作者", "出版社", "位置", "借阅人", "入库时间", "状态", "借出时间", "归还时间"};
				defaultTableModel.setColumnIdentifiers(columnNames);
				try {
					while (rs.next()) {
						Vector<String> v = new Vector<>(11);
						v.add(0, rs.getString("Bid"));
						v.add(1, rs.getString("Bname"));
						v.add(2, rs.getString("Bwriter"));
						v.add(3, rs.getString("Bposition"));
						v.add(4, rs.getString("BreaderName"));
						v.add(5, rs.getString("Bnumber"));
						v.add(6, rs.getString("Bookpublish"));
						v.add(7, rs.getString("BinDate"));
						v.add(8, rs.getString("Bstatus"));
						v.add(9, rs.getString("BborrowDate"));
						v.add(10, rs.getString("BreturnDate"));	
						defaultTableModel.addRow(v);
					
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}
				table_1 = new JTable(defaultTableModel);
				scrollPane = new JScrollPane(table_1);
				scrollPane.setBounds(26, 56, 694, 172);
				getContentPane().add(scrollPane);
				scrollPane.setVisible(true);
			
			}
		});
		btnNewButton_2.setBounds(569, 318, 151, 30);
		contentPane.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(204, 258, 516, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u67E5\u8BE2\u4FE1\u606F\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(26, 255, 168, 38);
		contentPane.add(lblNewLabel_1);
		setVisible(true);
	}
	
	
}
