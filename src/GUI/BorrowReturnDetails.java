package GUI;

import Dao.DetailsDao;
import Entity.Reader;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;


import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BorrowReturnDetails extends JFrame {

	private JPanel contentPane;
//	private Helper helper = new Helper();
	private ResultSetTableModel model;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowReturnDetails frame = new BorrowReturnDetails();
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
	public BorrowReturnDetails() {
		setTitle("借阅记录");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 647, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 633, 261);
		contentPane.add(scrollPane);

		// 实例化model对象
		model = new ResultSetTableModel();
		table = new JTable(model);
		initTable(); // 自定义方法用于设置JTable的样式
		scrollPane.setViewportView(table);
		

			}

	private void initTable() {
		table.getTableHeader().setResizingAllowed(false); // 设置不允许手动改变列宽
		table.getTableHeader().setReorderingAllowed(false); // 设置不允许拖动重新排序各列


		// 首先通过表格对象 table 获取选择器模型
		ListSelectionModel selectionModel = table.getSelectionModel();
		// 设置选择器模式，参数可能的值为:
		// ListSelectionModel.MULTIPLE_INTERVAL_SELECTION 一次选择一个或多个连续的索引范围（默认）
		// ListSelectionModel.SINGLE_INTERVAL_SELECTION 一次选择一个连续的索引范围
		// ListSelectionModel.SINGLE_SELECTION 一次只能选择一个列表索引
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	// 扩展AbstractTableModel，用于将一个ResultSet包装成TableModel
	private class ResultSetTableModel extends AbstractTableModel {
		private ResultSet rSet;
		private String[] columnNames = { "学号", "序号", "书名", "状态", "借阅日期", "归还日期" };
	;
		public ResultSetTableModel() {
			rSet = DetailsDao.Details3(Reader.getRid());

		}

		// 返回列名称（表头名称）
		@Override
		public String getColumnName(int column) {
			return columnNames[column];
		}

		// 返回列数
		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		// 返回行数
		@Override
		public int getRowCount() {
			try {
				rSet.last();
				return rSet.getRow();
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
		}

		// 指定单元格的值
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			try {
				rSet.absolute(rowIndex + 1);
				return rSet.getObject(columnIndex + 1);
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
	}

