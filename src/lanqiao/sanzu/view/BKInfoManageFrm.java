package lanqiao.sanzu.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import lanqiao.sanzu.entity.Book;
import lanqiao.sanzu.service.impl.BookServiceImpl;
import lanqiao.sanzu.util.SetBackground;
import lanqiao.sanzu.util.SetIconImage;
import lanqiao.sanzu.util.SetJFrameLocation;

public class BKInfoManageFrm extends JFrame {

	private JPanel contentPane;
	private JTextField tfbookname1;
	private JTextField tfbookid1;
	private JTextField tfbookauthor1;
	private JTextField tfstoragetime1;
	private JTextField tfbookisborrow1;
	private JTable jtbookmsg;
	private JTextField tfbookname2;
	private JTextField tfbookid2;
	private JTextField tfbookauthor2;
	private JTextField tfstoragetime2;
	private JTextField tfisborrow2;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BKInfoManageFrm frame = new BKInfoManageFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public BKInfoManageFrm() {
		setResizable(false);
		new SetIconImage(this, "images/bookinfoicon.png");
		setTitle("图书资料管理");
		setVisible(true);
		setBounds(100, 100, 739, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		new SetBackground(this, "images/bookinfobg.jpg");    //设置背景图片
		contentPane.setLayout(null);
		new SetJFrameLocation(this);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.WHITE, 2, true));
		panel.setBounds(10, 10, 703, 100);
		contentPane.add(panel);
		panel.setOpaque(false);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("书名");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel.setBounds(23, 13, 89, 32);
		panel.add(lblNewLabel);
		
		tfbookname1 = new JTextField();
		tfbookname1.setBounds(79, 16, 161, 26);
		panel.add(tfbookname1);
		tfbookname1.setColumns(10);
		
		JLabel label = new JLabel("图书编号");
		label.setForeground(Color.RED);
		label.setFont(new Font("宋体", Font.BOLD, 15));
		label.setBounds(279, 13, 89, 32);
		panel.add(label);
		
		tfbookid1 = new JTextField();
		tfbookid1.setColumns(10);
		tfbookid1.setBounds(352, 17, 83, 26);
		panel.add(tfbookid1);
		
		JLabel label_1 = new JLabel("作者");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("宋体", Font.BOLD, 15));
		label_1.setBounds(23, 55, 89, 32);
		panel.add(label_1);
		
		tfbookauthor1 = new JTextField();
		tfbookauthor1.setColumns(10);
		tfbookauthor1.setBounds(79, 58, 83, 26);
		panel.add(tfbookauthor1);
		
		JLabel label_2 = new JLabel("入库时间");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("宋体", Font.BOLD, 15));
		label_2.setBounds(198, 52, 89, 32);
		panel.add(label_2);
		
		tfstoragetime1 = new JTextField();
		tfstoragetime1.setColumns(10);
		tfstoragetime1.setBounds(271, 56, 115, 26);
		panel.add(tfstoragetime1);
		
		JLabel label_3 = new JLabel("是否借出");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("宋体", Font.BOLD, 15));
		label_3.setBounds(487, 13, 89, 32);
		panel.add(label_3);
		
		tfbookisborrow1 = new JTextField();
		tfbookisborrow1.setColumns(10);
		tfbookisborrow1.setBounds(558, 17, 83, 26);
		panel.add(tfbookisborrow1);
		
		JButton btnselect = new JButton("查询");
		btnselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookname=tfbookname1.getText();
				String author=tfbookauthor1.getText();
				String isborrow=tfbookisborrow1.getText();
				String bookid = tfbookid1.getText();
				String storagetime = tfstoragetime1.getText();
				Book book=new Book(bookname,author,isborrow);
				if(!"".equals(bookid)){
					int boodid=Integer.parseInt(tfbookid1.getText());
					book.setBookId(boodid);
				}
				if(!"".equals(storagetime)) {
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					try {
						java.sql.Date date=new java.sql.Date(sdf.parse(tfstoragetime1.getText()).getTime());
						book.setStorageTime(date);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				fillTable(new BookServiceImpl().selectBookByCondition(book));
			}
		});
		btnselect.setForeground(Color.RED);
		btnselect.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 20));
		btnselect.setBounds(461, 52, 161, 35);
		panel.add(btnselect);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.WHITE, 2, true));
		panel_2.setBounds(10, 423, 703, 140);
		contentPane.add(panel_2);
		panel_2.setOpaque(false);
		panel_2.setLayout(null);
		
		JLabel label_4 = new JLabel("书名");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("宋体", Font.BOLD, 15));
		label_4.setBounds(27, 10, 89, 32);
		panel_2.add(label_4);
		
		tfbookname2 = new JTextField();
		tfbookname2.setColumns(10);
		tfbookname2.setBounds(83, 13, 161, 26);
		panel_2.add(tfbookname2);
		
		JLabel label_5 = new JLabel("图书编号");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("宋体", Font.BOLD, 15));
		label_5.setBounds(283, 10, 89, 32);
		panel_2.add(label_5);
		
		tfbookid2 = new JTextField();
		tfbookid2.setColumns(10);
		tfbookid2.setBounds(356, 14, 139, 26);
		panel_2.add(tfbookid2);
		
		JLabel label_6 = new JLabel("作者");
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("宋体", Font.BOLD, 15));
		label_6.setBounds(27, 52, 89, 32);
		panel_2.add(label_6);
		
		tfbookauthor2 = new JTextField();
		tfbookauthor2.setColumns(10);
		tfbookauthor2.setBounds(83, 55, 161, 26);
		panel_2.add(tfbookauthor2);
		
		JLabel label_7 = new JLabel("入库时间");
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("宋体", Font.BOLD, 15));
		label_7.setBounds(307, 52, 89, 32);
		panel_2.add(label_7);
		
		tfstoragetime2 = new JTextField();
		tfstoragetime2.setColumns(10);
		tfstoragetime2.setBounds(380, 56, 115, 26);
		panel_2.add(tfstoragetime2);
		
		JLabel label_8 = new JLabel("是否借出");
		label_8.setForeground(Color.RED);
		label_8.setFont(new Font("宋体", Font.BOLD, 15));
		label_8.setBounds(520, 10, 89, 32);
		panel_2.add(label_8);
		
		tfisborrow2 = new JTextField();
		tfisborrow2.setColumns(10);
		tfisborrow2.setBounds(591, 14, 83, 26);
		panel_2.add(tfisborrow2);
		
		JButton btnupdate = new JButton("修改");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!"".equals(tfbookname2.getText())&&!"".equals(tfbookid2.getText())&&!"".equals(tfbookauthor2.getText())&&
						!"".equals(tfstoragetime2.getText())&&!"".equals(tfisborrow2.getText())){
					String bookname=tfbookname2.getText();
					int bookid=Integer.parseInt(tfbookid2.getText());
					String author=tfbookauthor2.getText();
					String storagetime=tfstoragetime2.getText();
					String borrow=tfisborrow2.getText();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date date1=null;
					try {
						date1=sdf.parse(storagetime);
					} catch (ParseException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					java.sql.Date date = new Date(date1.getTime());
					boolean success=new BookServiceImpl().updateBook(new Book(bookname,bookid,author,date,borrow));
					if(success)	JOptionPane.showMessageDialog(null, "修改成功！");
					else	JOptionPane.showMessageDialog(null, "修改失败！");
				}else{
					JOptionPane.showMessageDialog(null, "请将内容输入完整，或点击上方表格获取需要修改的图书信息！");
				}
			}
		});
		btnupdate.setForeground(Color.RED);
		btnupdate.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 20));
		btnupdate.setBounds(163, 91, 161, 35);
		panel_2.add(btnupdate);
		
		JButton btndelete = new JButton("删除");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!"".equals(tfbookname2.getText())&&!"".equals(tfbookid2.getText())&&!"".equals(tfbookauthor2.getText())&&
						!"".equals(tfstoragetime2.getText())&&!"".equals(tfisborrow2.getText())){
					String bookname=tfbookname2.getText();
					int bookid=Integer.parseInt(tfbookid2.getText());
					String author=tfbookauthor2.getText();
					String storagetime=tfstoragetime2.getText();
					String borrow=tfisborrow2.getText();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date date1=null;
					try {
						date1=sdf.parse(storagetime);
					} catch (ParseException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					java.sql.Date date = new Date(date1.getTime());
					boolean success=new BookServiceImpl().deleteBook(new Book(bookname,bookid,author,date,borrow));
					if(success)	JOptionPane.showMessageDialog(null, "删除成功！");
					else	JOptionPane.showMessageDialog(null, "删除失败！");
				}else{
					JOptionPane.showMessageDialog(null, "请将内容输入完整，或点击上方表格获取需要删除的图书信息！");
				}
			}
		});
		btndelete.setForeground(Color.RED);
		btndelete.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 20));
		btndelete.setBounds(388, 91, 161, 35);
		panel_2.add(btndelete);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.WHITE, 2, true));
		panel_1.setBounds(10, 120, 703, 293);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 703, 293);
		scrollPane.setOpaque(false);
		panel_1.add(scrollPane);
		
		jtbookmsg = new JTable();
		jtbookmsg.getTableHeader().setReorderingAllowed(false); //不可整列移动
		jtbookmsg.getTableHeader().setResizingAllowed(false); //不可拉动表格
		jtbookmsg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=jtbookmsg.getSelectedRow();
				tfbookid2.setText(""+jtbookmsg.getValueAt(row, 0));
				tfbookname2.setText(""+jtbookmsg.getValueAt(row, 1));
				tfbookauthor2.setText(""+jtbookmsg.getValueAt(row, 2));
				tfstoragetime2.setText(""+jtbookmsg.getValueAt(row, 3));
				tfisborrow2.setText(""+jtbookmsg.getValueAt(row, 4));
			}
		});
		jtbookmsg.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"\u56FE\u4E66\u7F16\u53F7", "\u4E66\u540D", "\u4F5C\u8005", "\u5165\u5E93\u65F6\u95F4", "\u662F\u5426\u501F\u51FA"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		jtbookmsg.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(jtbookmsg);
		fillTable(new BookServiceImpl().selectAllBook());
	}
	
	//填充表格方法
	public void fillTable(Vector<Book> vector){
		DefaultTableModel dtm=(DefaultTableModel) jtbookmsg.getModel();
		dtm.setRowCount(0);
		for(Book book:vector){
			dtm.addRow(new Object[]{book.getBookId(),book.getBookName(),book.getAuthor(),book.getStorageTime(),book.getBorrow()});
		}
	}
}
