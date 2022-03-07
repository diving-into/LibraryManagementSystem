package GUI;

import Exception.ExistException;

import Dao.BookInformationDao;
import Entity.BookInformation;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import static Dao.BookInformationDao.bnumber;


public class AOperation extends JFrame {

    public JTable table;
    public JPanel Pane;
    public JTextField oldidField;
    public JTextField nameField;
    public JTextField numberField;
    public JTextField writerField;
    public JTextField publishField;
    public JTextField positionField;
    public JTextField indateField;
    public JTextField statusField;
    public JTextField readernameField;
    public JTextField borrowField;
    public JTextField returnField;
    private ResultSetTableModel model;
    public JTextField idField;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AOperation frame = new AOperation();
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
    public AOperation() {
        setResizable(false);
        setTitle("管理员操作界面");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 647, 582);
        setLocationRelativeTo(null);
        Pane = new JPanel();
        Pane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(Pane);
        Pane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 643, 180);
        Pane.add(scrollPane);


        bnumber();
        model = new ResultSetTableModel();
        table = new JTable(model);
        initTable(); // 自定义方法用于设置JTable的样式
        scrollPane.setViewportView(table);

        JLabel idLabel = new JLabel("编号：");
        idLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        idLabel.setBounds(173, 202, 76, 30);
        Pane.add(idLabel);

        JLabel nameLabel = new JLabel("书名：");
        nameLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        nameLabel.setBounds(43, 255, 76, 30);
        Pane.add(nameLabel);

        nameField = new JTextField();
        nameField.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        nameField.setColumns(10);
        nameField.setBounds(115, 252, 185, 41);
        Pane.add(nameField);

        JLabel numberLabel = new JLabel("总数量：");
        numberLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        numberLabel.setBounds(323, 255, 83, 30);
        Pane.add(numberLabel);

        numberField = new JTextField();
        numberField.setEditable(false);
        numberField.setText("1");
        numberField.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        numberField.setColumns(10);
        numberField.setBounds(416, 252, 185, 41);
        Pane.add(numberField);

        JLabel writerLabel = new JLabel("作者：");
        writerLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        writerLabel.setBounds(43, 306, 76, 30);
        Pane.add(writerLabel);

        writerField = new JTextField();
        writerField.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        writerField.setColumns(10);
        writerField.setBounds(115, 303, 185, 41);
        Pane.add(writerField);

        JLabel publishLabel = new JLabel("出版社：");
        publishLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        publishLabel.setBounds(323, 306, 93, 30);
        Pane.add(publishLabel);

        publishField = new JTextField();
        publishField.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        publishField.setColumns(10);
        publishField.setBounds(416, 303, 185, 41);
        Pane.add(publishField);

        JLabel positionLabel = new JLabel("位置：");
        positionLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        positionLabel.setBounds(43, 357, 76, 30);
        Pane.add(positionLabel);

        positionField = new JTextField();
        positionField.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        positionField.setColumns(10);
        positionField.setBounds(115, 354, 185, 41);
        Pane.add(positionField);

        JLabel indateLabel = new JLabel("入库时间：");
        indateLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        indateLabel.setBounds(310, 357, 102, 30);
        Pane.add(indateLabel);

        indateField = new JTextField();
        indateField.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        indateField.setColumns(10);
        indateField.setBounds(416, 354, 185, 41);
        Pane.add(indateField);

        JLabel statusLabel = new JLabel("状态：");
        statusLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        statusLabel.setBounds(43, 408, 76, 30);
        Pane.add(statusLabel);

        statusField = new JTextField();
        statusField.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        statusField.setColumns(10);
        statusField.setBounds(115, 405, 185, 41);
        Pane.add(statusField);

        JLabel readernameLabel = new JLabel("借阅人：");
        readernameLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        readernameLabel.setBounds(28, 459, 93, 30);
        Pane.add(readernameLabel);

        readernameField = new JTextField();
        readernameField.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        readernameField.setColumns(10);
        readernameField.setBounds(115, 456, 185, 41);
        Pane.add(readernameField);

        JLabel borrowLabel = new JLabel("借阅日期：");
        borrowLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        borrowLabel.setBounds(314, 408, 102, 30);
        Pane.add(borrowLabel);

        borrowField = new JTextField();
        borrowField.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        borrowField.setColumns(10);
        borrowField.setBounds(416, 405, 185, 41);
        Pane.add(borrowField);

        JLabel returnLabel = new JLabel("归还日期：");
        returnLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        returnLabel.setBounds(314, 459, 102, 30);
        Pane.add(returnLabel);

        returnField = new JTextField();
        returnField.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        returnField.setColumns(10);
        returnField.setBounds(416, 456, 185, 41);
        Pane.add(returnField);

        ButtonListener buttonListener=new ButtonListener();

        JButton Insert = new JButton("插入");
        Insert.addActionListener(buttonListener);
        Insert.setFont(new Font("宋体", Font.PLAIN, 18));
        Insert.setBounds(249, 507, 124, 30);
        Pane.add(Insert);

        idField = new JTextField();
        idField.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        idField.setColumns(10);
        idField.setBounds(251, 199, 185, 41);
        Pane.add(idField);

        JButton Delete = new JButton("删除");
        Delete.setFont(new Font("宋体", Font.PLAIN, 18));
        Delete.setBounds(426, 507, 124, 30);
        Pane.add(Delete);
        Delete.addActionListener(buttonListener);

        JButton Update = new JButton("修改");
        Update.setFont(new Font("宋体", Font.PLAIN, 18));
        Update.setBounds(66, 507, 124, 30);
        Pane.add(Update);
        Update.addActionListener(buttonListener);
    }

    private void initTable() {
        table.getTableHeader().setResizingAllowed(true); // 设置不允许手动改变列宽
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
                readernameField.setText(table.getValueAt(row, 7).toString());
                indateField.setText(table.getValueAt(row, 8).toString());
                borrowField.setText(table.getValueAt(row, 9).toString());
                returnField.setText(table.getValueAt(row, 10).toString());


            }

            ;

            // 首先通过表格对象 table 获取选择器模型
            ListSelectionModel selectionModel = table.getSelectionModel();
            // 设置选择器模式，参数可能的值为:
            // ListSelectionModel.MULTIPLE_INTERVAL_SELECTION 一次选择一个或多个连续的索引范围（默认）
            // ListSelectionModel.SINGLE_INTERVAL_SELECTION 一次选择一个连续的索引范围
            // ListSelectionModel.SINGLE_SELECTION 一次只能选择一个列表索引
            //selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        });
    }

    // 扩展AbstractTableModel，用于将一个ResultSet包装成TableModel
    static class ResultSetTableModel extends AbstractTableModel {
        private ResultSet rSet;
        private String[] columnNames = {"编号", "书名", "总数量", "作者", "出版社", "位置", "状态", "借阅人", "入库时间", "借出时间", "归还时间"};

        public ResultSetTableModel() {
            rSet = BookInformationDao.queryTable();

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

    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(idField.getText().trim());
            String name = nameField.getText().trim();
            int number = Integer.parseInt(numberField.getText().trim());
            String writer = writerField.getText().trim();
            String publish = publishField.getText().trim();
            String position = positionField.getText().trim();
            String readername = readernameField.getText().trim();
            String indate = indateField.getText().trim();
            String status = statusField.getText().trim();
            Date borrow = Date.valueOf(borrowField.getText().trim());
            Date bookreturn = Date.valueOf(returnField.getText().trim());


            BookInformation bookInformation = new BookInformation(id, name, number,writer, position,readername, indate,borrow , bookreturn ,Integer.parseInt(readername));

            String button = e.getActionCommand();
            switch (button) {
                case "插入":
                    try {
                        BookInformationDao.insertTable(bookInformation);
                    } catch (ExistException exception) {
                        JOptionPane.showConfirmDialog(AOperation.this, "该图书已存在", "插入数据错误", JOptionPane.CLOSED_OPTION,
                                JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case "删除":
                    BookInformationDao.deleteTable(bookInformation);
                    break;

                case "修改":
                    BookInformationDao.updateTable(bookInformation);
                    break;
            }
            BookInformationDao.bnumber();
            ResultSetTableModel model = new ResultSetTableModel();
            table.setModel(model);
        }

    }
}
