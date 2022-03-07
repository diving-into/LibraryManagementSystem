package GUI;

import Dao.BookInformationDao;
import Utility.SQLHelper;

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

import static Dao.BookInformationDao.*;

public class queryBookStatus extends JFrame {
	private JPanel contentPane;
	private JTable table;
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
					queryBookStatus frame = new queryBookStatus();
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
	public queryBookStatus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7684\u501F\u9605\u4FE1\u606F");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(237, 27, 140, 26);
		contentPane.add(lblNewLabel);
		
		String[] columnNames = {"编号", "书名", "在馆数量", "借阅人", "状态", "借出时间", "归还时间"};
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.setColumnIdentifiers(columnNames);
		table = new JTable(defaultTableModel);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(47, 73, 550, 198);
		getContentPane().add(scrollPane);
		scrollPane.setVisible(true);
		//table.setBounds(47, 73, 550, 198);
		//contentPane.add(table);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u56FE\u4E66\u76F8\u5173\u4FE1\u606F \uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(47, 301, 210, 26);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(265, 301, 332, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6839\u636Eid\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.removeAll();
				defaultTableModel.setRowCount(0);
				getContentPane().add(scrollPane);
				String[] columnNames = {"编号", "书名", "在馆数量", "借阅人", "状态", "借出时间", "归还时间"};
				defaultTableModel.setColumnIdentifiers(columnNames);
				ResultSet rs = queryBooksById(Integer.valueOf(textField.getText()));
				int res = BookInformationDao.queryBooksNumberInLibrary1(Integer.valueOf(textField.getText()));
				
				try {
					while (rs.next()) {
						Vector<String> v = new Vector<>(7);
						v.add(0, rs.getString("Bid"));
						v.add(1, rs.getString("Bname"));
						v.add(2, String.valueOf(res));
						v.add(3, rs.getString("BreaderName"));
						v.add(4, rs.getString("Bstatus"));
						v.add(5, rs.getString("BborrowDate"));
						v.add(6, rs.getString("BreturnDate"));	
						defaultTableModel.addRow(v);
					
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}
				table = new JTable(defaultTableModel);
				scrollPane = new JScrollPane(table);
				scrollPane.setBounds(47, 73, 550, 198);
				getContentPane().add(scrollPane);
				scrollPane.setVisible(true);
			}
			
		});
		btnNewButton.setBounds(47, 341, 128, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6839\u636E\u4E66\u540D\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.removeAll();
				defaultTableModel.setRowCount(0);
				getContentPane().add(scrollPane);
				String[] columnNames = {"编号", "书名", "在馆数量", "借阅人", "状态", "借出时间", "归还时间"};
				defaultTableModel.setColumnIdentifiers(columnNames);
				ResultSet rs = queryBooksByName(textField.getText());
				int res = BookInformationDao.queryBooksNumberInLibrary2(textField.getText());
				
				try {
					while (rs.next()) {
						Vector<String> v = new Vector<>(7);
						v.add(0, rs.getString("Bid"));
						v.add(1, rs.getString("Bname"));
						v.add(2, String.valueOf(res));
						v.add(3, rs.getString("BreaderName"));
						v.add(4, rs.getString("Bstatus"));
						v.add(5, rs.getString("BborrowDate"));
						v.add(6, rs.getString("BreturnDate"));	
						defaultTableModel.addRow(v);
					
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}
				table = new JTable(defaultTableModel);
				scrollPane = new JScrollPane(table);
				scrollPane.setBounds(47, 73, 550, 198);
				getContentPane().add(scrollPane);
				scrollPane.setVisible(true);
			}
			
		});
		btnNewButton_1.setBounds(462, 341, 128, 31);
		contentPane.add(btnNewButton_1);
		setVisible(true);
	}
}
