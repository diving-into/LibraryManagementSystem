package GUI;

import Dao.BookInformationDao;
import Dao.DetailsDao;
import Entity.BookInformation;
import Entity.Details;
import Entity.Reader;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ReaderQueryFrame extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTable table;
	private JTextField writername;
	private JTextField bookname;
	private ResultSetTableModel model;
	private ResultSet rSet;
	private JTextField idField;
	private JTextField nameField;
	private JTextField numberField;
	private JTextField writerField;
	private JTextField publishField;
	private JTextField positionField;
	private JTextField statusField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderQueryFrame frame = new ReaderQueryFrame();
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
	public ReaderQueryFrame() {
		setTitle("查询");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 659, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(0, 0, 652, 297);
		contentPane.add(scrollPane);
		// 实例化model对象
		model = new ResultSetTableModel();
		table = new JTable(model);

		initTable(); // 自定义方法用于设置JTable的样式
		scrollPane.setViewportView(table);



		JLabel lblNewLabel = new JLabel("按作者姓名关键字查找：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(255, 411, 233, 44);
		contentPane.add(lblNewLabel);

		writername = new JTextField();
		writername.setBounds(494, 411, 126, 39);
		contentPane.add(writername);
		writername.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("按图书名称关键字查找：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(255, 465, 233, 44);
		contentPane.add(lblNewLabel_1);

		bookname = new JTextField();
		bookname.setBounds(494, 471, 126, 37);
		contentPane.add(bookname);
		bookname.setColumns(10);

		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//		    if(writername.getText()!=null&&bookname.getText()!=null) {
				if (!writername.getText().equals("") && !bookname.getText().equals("")) {
					String Bwriter1 = writername.getText();
					String Bname1 = bookname.getText();
					rSet = BookInformationDao.ReaderQueryTable1(Bwriter1, Bname1);
				}
				if (!writername.getText().equals("") && bookname.getText().equals("")) {
					String Bwriter2 = writername.getText();
					rSet = BookInformationDao.ReaderQueryTable2(Bwriter2);
				}
				if (writername.getText().equals("") && !bookname.getText().equals("")) {
					String Bname3 = bookname.getText();
					rSet = BookInformationDao.ReaderQueryTable3(Bname3);
				}

				model = new ResultSetTableModel(rSet);
				table.setModel(model);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(395, 519, 93, 30);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("序号：");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(0, 307, 60, 24);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("图书名称：");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(0, 337, 105, 35);
		contentPane.add(lblNewLabel_1_1);

		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(94, 301, 113, 30);
		contentPane.add(idField);

		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(94, 338, 113, 30);
		contentPane.add(nameField);

		JLabel lblNewLabel_1_1_1 = new JLabel("在馆数量：");
		lblNewLabel_1_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(0, 373, 105, 35);
		contentPane.add(lblNewLabel_1_1_1);

		numberField = new JTextField();
		numberField.setColumns(10);
		numberField.setBounds(94, 373, 113, 30);
		contentPane.add(numberField);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("作者：");
		lblNewLabel_1_1_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(0, 414, 105, 35);
		contentPane.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("出版社：");
		lblNewLabel_1_1_1_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(0, 449, 105, 35);
		contentPane.add(lblNewLabel_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("位置：");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1.setBounds(0, 485, 105, 35);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("状态：");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(0, 517, 105, 35);
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1);

		writerField = new JTextField();
		writerField.setColumns(10);
		writerField.setBounds(94, 409, 113, 30);
		contentPane.add(writerField);
       JComboBox comboBox;
		publishField = new JTextField();
		publishField.setColumns(10);
		publishField.setBounds(94, 445, 113, 30);
		contentPane.add(publishField);

		positionField = new JTextField();
		positionField.setColumns(10);
		positionField.setBounds(94, 481, 113, 30);
		contentPane.add(positionField);

		statusField = new JTextField();
		statusField.setColumns(10);
		statusField.setBounds(94, 517, 113, 30);
		contentPane.add(statusField);

		JButton btnNewButton_1 = new JButton("归还");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(idField.getText().trim());
				if (BookInformationDao.IfBorrowReader(id) == Reader.getRid()) {
					String name = nameField.getText().trim();
					int number = Integer.parseInt(numberField.getText().trim()) + 1;
					String writer = writerField.getText().trim();
					String publish = publishField.getText().trim();
					String position = positionField.getText().trim();
					String status = "未借阅";
					String status1="还书";
//				String book = nameField.getText().trim();
					Date returndate = Date.valueOf(String.valueOf(LocalDateTime.now()));

					Date borrowdate =Date.valueOf(String.valueOf(BookInformationDao.Bookreturnneed(id)));

					BookInformation bookinformation1 = new BookInformation(id, name, number, writer, publish, position,
							status, null, null ,0);


//				Reader reader = new Reader(book);
					BookInformationDao.ReturnBook(bookinformation1);

					int rid = Reader.getRid();
					Details details1 = new Details(rid, id, name, status1, borrowdate, returndate);
					DetailsDao.Details2(details1);

					model = new ResultSetTableModel();
					table.setModel(model);


				} else {
					new ReturnFrame().setVisible(true);
				}
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(158, 557, 93, 32);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("借阅");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(idField.getText().trim());
				if (BookInformationDao.Ifnotcan(id).equals("未借阅")) {

					String name = nameField.getText().trim();
					int breaderid = Reader.getRid();
					System.out.println(breaderid);
					int number = Integer.parseInt(numberField.getText().trim());
					number = number - 1;
					String writer = writerField.getText().trim();
					String publish = publishField.getText().trim();
					String position = positionField.getText().trim();
					String status = "已借阅";
					String status1="借书";
//				String book = nameField.getText().trim();

					Date borrowdate = Date.valueOf(String.valueOf(LocalDateTime.now()));
					Date bretrunDate;
					BookInformation bookinformation = new BookInformation(id, name, number, writer, publish, position,
							status, null, null ,0);
					BookInformationDao.BorrowBook(bookinformation);


//				Reader reader = new Reader(book);/////????

					int rid = Reader.getRid();
					Details details1 = new Details(rid, id, name, status1, borrowdate, null);
					DetailsDao.Details1(details1);

					model = new ResultSetTableModel();
					table.setModel(model);
				}

				else
					new BorrowFrame().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_2.setBounds(12, 557, 93, 32);
		contentPane.add(btnNewButton_2);
	}


	private void initTable() {
		table.getTableHeader().setResizingAllowed(false); // 设置不允许手动改变列宽
		table.getTableHeader().setReorderingAllowed(false); // 设置不允许拖动重新排序各列
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();

				idField.setText(table.getValueAt(row, 0).toString());
				nameField.setText(table.getValueAt(row, 1).toString());
				numberField.setText(table.getValueAt(row, 2).toString());
				writerField.setText(table.getValueAt(row, 3).toString());
				publishField.setText(table.getValueAt(row, 4).toString());
				positionField.setText(table.getValueAt(row, 5).toString());
				statusField.setText(table.getValueAt(row, 6).toString());
			}

		});

		// 首先通过表格对象 table 获取选择器模型
		ListSelectionModel selectionModel = table.getSelectionModel();
		// 设置选择器模式，参数可能的值为:
		// ListSelectionModel.MULTIPLE_INTERVAL_SELECTION 一次选择一个或多个连续的索引范围（默认）
		// ListSelectionModel.SINGLE_INTERVAL_SELECTION 一次选择一个连续的索引范围
		// ListSelectionModel.SINGLE_SELECTION 一次只能选择一个列表索引
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	// 扩展AbstractTableModel，用于将一个ResultSet包装成TableModel
	 class ResultSetTableModel extends AbstractTableModel {
		private ResultSet rSet;
		private String[] columnNames = { "序号", "图书名称", "在馆数量", "作者", "出版社", "位置", "状态" };

		public ResultSetTableModel() {
			rSet = BookInformationDao.ReaderQueryTable();
		}

		public ResultSetTableModel(ResultSet rSet) {
			this.rSet = rSet;
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
