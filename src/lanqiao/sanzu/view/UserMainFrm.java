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

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import lanqiao.sanzu.entity.Borrow;
import lanqiao.sanzu.entity.User;
import lanqiao.sanzu.service.impl.BookServiceImpl;
import lanqiao.sanzu.service.impl.BorrowServiceImpl;
import lanqiao.sanzu.service.impl.UserServiceImpl;
import lanqiao.sanzu.util.SetBackground;
import lanqiao.sanzu.util.SetButtonImage;
import lanqiao.sanzu.util.SetIconImage;
import lanqiao.sanzu.util.SetJFrameLocation;
import lanqiao.sanzu.util.SetLabelImage;

public class UserMainFrm extends JFrame implements Runnable {
	private JLabel tftime;
	private JPanel logmsgpanel;
	private JPanel selebookpanel;
	private JPanel uppsdpanel;
	private JPanel contentPane;
	private JPanel borrowbookpanel;
	private JPanel panel_6;
	private JButton btnbookborrow;   //第一个面板中的图书管理按钮
	private JTextField tfoldpwd;
	private JTextField tfnewpwd1;              //第三个面板中用来确认新密码的文本框
	private JTextField tfnnewpwd;                  //第三个面板中用来输入新密码的文本框
	private JButton btnreset;     //第三个面板中的重置信息的按钮
	private JButton btnupdate1;   //第三个面板中的修改密码的按钮
	private JTextField tfbookname1;
	private JTextField tfbookid1;
	private JTextField tfisborrow1;
	private JTextField tfauthor1;
	private JTextField tfstoragetime;
	private JTable jtbookmsg;
	private JTextField tfbookname3;
	private JTextField tfbookid3;
	private JTextField tfisborrow3;
	private JTextField tfbookauthor3;
	private JTextField tfstoragetime3;
	private JTable jtbbookmsg3;
	private JTextField tfbookborrowuser4;
	private JTextField tfbookborrowuserid4;
	private JTextField tfbookid4;
	private JTextField tfbookname4;
	private JTextField tfbookborrowdate4;
	private JTextField tfneedreturntime4;
	private JButton btnselect3;
	private JComboBox cbborrortime4;
	private JButton btnconfirm4;
	private JButton btnborrow4;
	private JTextField tfusername7;
	private JTextField tfuserid7;
	private JTextField tfbookid7;
	private JTextField tfbookname7;
	private JTextField tfborrowdate7;
	private JTextField tfusername8;
	private JTextField tfuserid8;
	private JTextField tfbookid8;
	private JTextField tfbookname8;
	private JTextField tfborrowdate8;
	private JTextField tfduereturndate8;
	private JTextField tfreturndate8;
	private JTable jtborrowmsg7;
	private JComboBox cbborrowtime8;
	private JTextField tfborrowno8;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public UserMainFrm(String name1,String pwd1) {
		
		new SetIconImage(this, "images/bmsmain.png");
		setResizable(false);
		setVisible(true);
		setTitle("图书管理系统主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 706);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		new SetBackground(this, "images/mainbg.jpg");
		new SetJFrameLocation(this);
		
		
		//创建第一个面板
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.WHITE, 2));
		panel.setBounds(10, 10, 232, 647);
		contentPane.add(panel);
		panel.setOpaque(false);
		panel.setLayout(null);
		
		JButton btnupdatepwd = new JButton();
		btnupdatepwd.setFont(new Font("楷体", Font.BOLD, 20));
		btnupdatepwd.setForeground(Color.RED);
		btnupdatepwd.setBounds(10, 28, 212, 43);
		new SetButtonImage(btnupdatepwd, "images/updatepwd.png");
		btnupdatepwd.setContentAreaFilled(false);
		panel.add(btnupdatepwd);
		
		JButton btselectbook = new JButton();
		btselectbook.setForeground(Color.RED);
		btselectbook.setFont(new Font("楷体", Font.BOLD, 20));
		btselectbook.setBounds(10, 110, 212, 43);
		new SetButtonImage(btselectbook,"images/selectbook.png");
		btselectbook.setContentAreaFilled(false);
		panel.add(btselectbook);
		
		btnbookborrow = new JButton();
		btnbookborrow.setForeground(Color.RED);
		btnbookborrow.setFont(new Font("楷体", Font.BOLD, 20));
		btnbookborrow.setBounds(10, 188, 212, 43);
		new SetButtonImage(btnbookborrow, "images/borrowbook.png");
		btnbookborrow.setContentAreaFilled(false);
		panel.add(btnbookborrow);
		
		JButton btnbookreturn = new JButton();
		btnbookreturn.setForeground(Color.RED);
		btnbookreturn.setFont(new Font("楷体", Font.BOLD, 20));
		btnbookreturn.setBounds(10, 265, 212, 43);
		new SetButtonImage(btnbookreturn, "images/returnbook.png");
		btnbookreturn.setContentAreaFilled(false);
		panel.add(btnbookreturn);
		
		JLabel lblNewLabel = new JLabel("当前系统时间:");
		lblNewLabel.setForeground(new Color(75, 0, 130));
		lblNewLabel.setFont(new Font("新宋体", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(30, 355, 151, 30);
		panel.add(lblNewLabel);
		
		tftime = new JLabel("2019-7-16 17:23");
		tftime.setForeground(Color.RED);
		tftime.setFont(new Font("宋体", Font.BOLD, 18));
		tftime.setBounds(10, 395, 212, 54);
		panel.add(tftime);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(30, 459, 174, 174);
		panel.add(lblNewLabel_2);
		new SetLabelImage(lblNewLabel_2, "images/time.png");
		
		
		//------------------------------分隔符----------------------------------
		//创建第二个面板
		logmsgpanel = new JPanel();
		logmsgpanel.setForeground(Color.WHITE);
		logmsgpanel.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		logmsgpanel.setBounds(252, 10, 631, 647);
		contentPane.add(logmsgpanel);
		logmsgpanel.setOpaque(false);
		logmsgpanel.setLayout(null);
		
		JLabel name = new JLabel(name1);
		name.setBounds(54, 54, 209, 58);
		name.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 28));
		name.setForeground(new Color(0, 0, 205));
		logmsgpanel.add(name);
		
		JLabel lblNewLabel_1 = new JLabel("欢迎回来");
		lblNewLabel_1.setBounds(210, 122, 165, 108);
		lblNewLabel_1.setForeground(new Color(128, 128, 0));
		lblNewLabel_1.setFont(new Font("黑体", Font.BOLD, 30));
		logmsgpanel.add(lblNewLabel_1);
		logmsgpanel.setVisible(true);
		
		//------------------------------分隔符----------------------------------
		//创建第三个面板
		uppsdpanel = new JPanel();
		uppsdpanel.setBorder(new LineBorder(Color.WHITE, 2, true));
		uppsdpanel.setBounds(252, 10, 631, 647);
		contentPane.add(uppsdpanel);
		uppsdpanel.setOpaque(false);
		uppsdpanel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("请输入原密码");
		lblNewLabel_3.setForeground(new Color(0, 255, 255));
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_3.setBounds(20, 199, 177, 43);
		uppsdpanel.add(lblNewLabel_3);
		
		tfoldpwd = new JTextField();
		tfoldpwd.setBounds(160, 202, 212, 37);
		uppsdpanel.add(tfoldpwd);
		tfoldpwd.setColumns(10);
		
		JLabel label = new JLabel("请输入新密码");
		label.setForeground(new Color(0, 255, 255));
		label.setFont(new Font("宋体", Font.BOLD, 20));
		label.setBounds(20, 275, 177, 43);
		uppsdpanel.add(label);
		
		tfnewpwd1 = new JTextField();
		tfnewpwd1.setColumns(10);
		tfnewpwd1.setBounds(160, 278, 212, 37);
		uppsdpanel.add(tfnewpwd1);
		
		JLabel label_1 = new JLabel("确认新密码");
		label_1.setForeground(new Color(0, 255, 255));
		label_1.setFont(new Font("宋体", Font.BOLD, 20));
		label_1.setBounds(20, 371, 177, 43);
		uppsdpanel.add(label_1);
		
		tfnnewpwd = new JTextField();
		tfnnewpwd.setColumns(10);
		tfnnewpwd.setBounds(160, 374, 212, 37);
		uppsdpanel.add(tfnnewpwd);
		
		btnupdate1 = new JButton();
		btnupdate1.setBounds(62, 486, 137, 43);
		uppsdpanel.add(btnupdate1);
		new SetButtonImage(btnupdate1, "images/updatepwd1.png");
		btnupdate1.setContentAreaFilled(false);
		
		JButton btnreset = new JButton("重置");
		btnreset.setBounds(266, 486, 137, 43);
		uppsdpanel.add(btnreset);
		new SetButtonImage(btnreset, "images/resetpwd1.png");
		btnreset.setContentAreaFilled(false);
		
		JLabel lblNewLabel_11 = new JLabel("修改密码");
		lblNewLabel_11.setForeground(new Color(255, 0, 255));
		lblNewLabel_11.setFont(new Font("新宋体", Font.BOLD, 30));
		lblNewLabel_11.setBounds(137, 49, 198, 81);
		uppsdpanel.add(lblNewLabel_11);
		uppsdpanel.setVisible(false);
		
		
		//------------------------------分隔符----------------------------------
		//创建第四个面板
		selebookpanel = new JPanel();
		selebookpanel.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		selebookpanel.setBounds(246, 10, 637, 647);
		contentPane.add(selebookpanel);
		selebookpanel.setOpaque(false);
		selebookpanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(10, 10, 617, 140);
		selebookpanel.add(panel_1);
		panel_1.setOpaque(false);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_111 = new JLabel("书名");
		lblNewLabel_111.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel_111.setForeground(Color.RED);
		lblNewLabel_111.setBounds(24, 26, 94, 29);
		panel_1.add(lblNewLabel_111);
		
		tfbookname1 = new JTextField();
		tfbookname1.setBounds(66, 26, 117, 29);
		panel_1.add(tfbookname1);
		tfbookname1.setColumns(10);
		
		JLabel label1 = new JLabel("图书编号");
		label1.setForeground(Color.RED);
		label1.setFont(new Font("宋体", Font.BOLD, 15));
		label1.setBounds(218, 26, 94, 29);
		panel_1.add(label1);
		
		tfbookid1 = new JTextField();
		tfbookid1.setColumns(10);
		tfbookid1.setBounds(293, 26, 94, 29);
		panel_1.add(tfbookid1);
		
		JLabel label_11 = new JLabel("是否借出");
		label_11.setForeground(Color.RED);
		label_11.setFont(new Font("宋体", Font.BOLD, 15));
		label_11.setBounds(411, 26, 94, 29);
		panel_1.add(label_11);
		
		tfisborrow1 = new JTextField();
		tfisborrow1.setColumns(10);
		tfisborrow1.setBounds(497, 26, 94, 29);
		panel_1.add(tfisborrow1);
		
		JLabel label_2 = new JLabel("作者");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("宋体", Font.BOLD, 15));
		label_2.setBounds(24, 81, 94, 29);
		panel_1.add(label_2);
		
		tfauthor1 = new JTextField();
		tfauthor1.setColumns(10);
		tfauthor1.setBounds(66, 81, 66, 29);
		panel_1.add(tfauthor1);
		
		JLabel label_3 = new JLabel("入库时间");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("宋体", Font.BOLD, 15));
		label_3.setBounds(165, 81, 94, 29);
		panel_1.add(label_3);
		
		tfstoragetime = new JTextField();
		tfstoragetime.setColumns(10);
		tfstoragetime.setBounds(261, 81, 137, 29);
		panel_1.add(tfstoragetime);
		
		JButton btnuserselectbook = new JButton();
		btnuserselectbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookname=tfbookname1.getText();
				String author=tfauthor1.getText();
				String isborrow=tfisborrow1.getText();
				String bookid = tfbookid1.getText();
				String storagetime = tfstoragetime.getText();
				Book book=new Book(bookname,author,isborrow);
				if(!"".equals(bookid)){
					int boodid=Integer.parseInt(tfbookid1.getText());
					book.setBookId(boodid);
				}
				if(!"".equals(storagetime)) {
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					try {
						java.sql.Date date=new java.sql.Date(sdf.parse(tfstoragetime.getText()).getTime());
						book.setStorageTime(date);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				fillTable(new BookServiceImpl().selectBookByCondition(book));
			}
		});
		btnuserselectbook.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
		btnuserselectbook.setForeground(Color.RED);
		btnuserselectbook.setBounds(433, 81, 137, 37);
		new SetButtonImage(btnuserselectbook, "images/selectbook1.png");
		btnuserselectbook.setContentAreaFilled(false);
		panel_1.add(btnuserselectbook);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 168, 617, 469);
		selebookpanel.add(panel_2);
		panel_2.setOpaque(false);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 597, 449);
		scrollPane.setOpaque(false);
		panel_2.add(scrollPane);
		
		jtbookmsg = new JTable();
		jtbookmsg.getTableHeader().setReorderingAllowed(false); //不可整列移动
		jtbookmsg.getTableHeader().setResizingAllowed(false); //不可拉动表格
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
		scrollPane.setViewportView(jtbookmsg);
		fillTable(new BookServiceImpl().selectAllBook());
		selebookpanel.setVisible(false);
		
		//------------------------------分隔符----------------------------------
		//创建第五个面板
				borrowbookpanel = new JPanel();
				borrowbookpanel.setBorder(new LineBorder(Color.WHITE, 2, true));
				borrowbookpanel.setBounds(252, 10, 631, 647);
				contentPane.add(borrowbookpanel);
				borrowbookpanel.setOpaque(false);
				borrowbookpanel.setLayout(null);
				
				JPanel panel_11 = new JPanel();
				panel_11.setLayout(null);
				panel_11.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panel_11.setBounds(10, 18, 617, 140);
				panel_11.setOpaque(false);
				borrowbookpanel.add(panel_11);
				
				JLabel label11 = new JLabel("书名");
				label11.setForeground(Color.RED);
				label11.setFont(new Font("宋体", Font.BOLD, 15));
				label11.setBounds(24, 26, 94, 29);
				panel_11.add(label11);
				
				tfbookname3 = new JTextField();
				tfbookname3.setColumns(10);
				tfbookname3.setBounds(66, 26, 117, 29);
				panel_11.add(tfbookname3);
				
				JLabel label_111 = new JLabel("图书编号");
				label_111.setForeground(Color.RED);
				label_111.setFont(new Font("宋体", Font.BOLD, 15));
				label_111.setBounds(218, 26, 94, 29);
				panel_11.add(label_111);
				
				tfbookid3 = new JTextField();
				tfbookid3.setColumns(10);
				tfbookid3.setBounds(293, 26, 94, 29);
				panel_11.add(tfbookid3);
				
				JLabel label_21 = new JLabel("是否借出");
				label_21.setForeground(Color.RED);
				label_21.setFont(new Font("宋体", Font.BOLD, 15));
				label_21.setBounds(411, 26, 94, 29);
				panel_11.add(label_21);
				
				tfisborrow3 = new JTextField();
				tfisborrow3.setColumns(10);
				tfisborrow3.setBounds(497, 26, 94, 29);
				panel_11.add(tfisborrow3);
				
				JLabel label_31 = new JLabel("作者");
				label_31.setForeground(Color.RED);
				label_31.setFont(new Font("宋体", Font.BOLD, 15));
				label_31.setBounds(24, 81, 94, 29);
				panel_11.add(label_31);
				
				tfbookauthor3 = new JTextField();
				tfbookauthor3.setColumns(10);
				tfbookauthor3.setBounds(66, 81, 66, 29);
				panel_11.add(tfbookauthor3);
				
				JLabel label_4 = new JLabel("入库时间");
				label_4.setForeground(Color.RED);
				label_4.setFont(new Font("宋体", Font.BOLD, 15));
				label_4.setBounds(165, 81, 94, 29);
				panel_11.add(label_4);
				
				tfstoragetime3 = new JTextField();
				tfstoragetime3.setColumns(10);
				tfstoragetime3.setBounds(261, 81, 137, 29);
				panel_11.add(tfstoragetime3);
				
				btnselect3 = new JButton("");
				btnselect3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String bookname=tfbookname3.getText();
						String author=tfbookauthor3.getText();
						String isborrow=tfisborrow3.getText();
						String bookid = tfbookid3.getText();
						String storagetime = tfstoragetime3.getText();
						Book book=new Book(bookname,author,isborrow);
						if(!"".equals(bookid)){
							int boodid=Integer.parseInt(tfbookid3.getText());
							book.setBookId(boodid);
						}
						if(!"".equals(storagetime)) {
							SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
							try {
								java.sql.Date date=new java.sql.Date(sdf.parse(tfstoragetime3.getText()).getTime());
								book.setStorageTime(date);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						fillTable2(new BookServiceImpl().selectBookByCondition(book));
					}
					
				});
				btnselect3.setForeground(Color.RED);
				btnselect3.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
				btnselect3.setBounds(433, 81, 137, 37);
				new SetButtonImage(btnselect3, "images/selectbook1.png");
				btnselect3.setContentAreaFilled(false);
				panel_11.add(btnselect3);
				
				JPanel panel_21 = new JPanel();
				panel_21.setLayout(null);
				panel_21.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel_21.setBounds(10, 168, 617, 185);
				panel_21.setOpaque(false);
				borrowbookpanel.add(panel_21);
				
				JScrollPane scrollPane1 = new JScrollPane();
				scrollPane1.setBounds(10, 10, 597, 165);
				scrollPane1.setOpaque(false);
				panel_21.add(scrollPane1);
				
				jtbbookmsg3 = new JTable();
				jtbbookmsg3.getTableHeader().setReorderingAllowed(false); //不可整列移动
				jtbbookmsg3.getTableHeader().setResizingAllowed(false); //不可拉动表格
				jtbbookmsg3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						tfbookborrowuser4.setText(name1);
						Vector<User> v = new UserServiceImpl().selectUserByUserName(new User(name1));
						tfbookborrowuserid4.setText(v.get(0).getUserid()+"");
						int row = jtbbookmsg3.getSelectedRow();
						tfbookid4.setText(""+jtbbookmsg3.getValueAt(row, 1));
						tfbookname4.setText(""+jtbbookmsg3.getValueAt(row, 2));
						Object selectedItem = cbborrortime4.getSelectedItem();
						String borrowtime=selectedItem.toString();
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
						java.sql.Date date=new java.sql.Date(new java.util.Date().getTime());
						tfbookborrowdate4.setText(date.toString());
						
						
					}
				});
				jtbbookmsg3.setModel(new DefaultTableModel(
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
				scrollPane1.setViewportView(jtbbookmsg3);
				fillTable2(new BookServiceImpl().selectAllBook());
				
				JPanel panel_3 = new JPanel();
				panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panel_3.setBounds(10, 364, 617, 261);
				borrowbookpanel.add(panel_3);
				panel_3.setOpaque(false);
				panel_3.setLayout(null);
				
				JLabel label_5 = new JLabel("借阅用户");
				label_5.setForeground(Color.RED);
				label_5.setFont(new Font("宋体", Font.BOLD, 15));
				label_5.setBounds(22, 22, 116, 32);
				panel_3.add(label_5);
				
				tfbookborrowuser4 = new JTextField();
				tfbookborrowuser4.setColumns(10);
				tfbookborrowuser4.setBounds(94, 23, 95, 32);
				panel_3.add(tfbookborrowuser4);
				
				JLabel label_6 = new JLabel("用户编号");
				label_6.setForeground(Color.RED);
				label_6.setFont(new Font("宋体", Font.BOLD, 15));
				label_6.setBounds(316, 22, 116, 32);
				panel_3.add(label_6);
				
				tfbookborrowuserid4 = new JTextField();
				tfbookborrowuserid4.setColumns(10);
				tfbookborrowuserid4.setBounds(388, 23, 95, 32);
				panel_3.add(tfbookborrowuserid4);
				
				JLabel label_7 = new JLabel("书    号");
				label_7.setForeground(Color.RED);
				label_7.setFont(new Font("宋体", Font.BOLD, 15));
				label_7.setBounds(22, 70, 116, 32);
				panel_3.add(label_7);
				
				tfbookid4 = new JTextField();
				tfbookid4.setColumns(10);
				tfbookid4.setBounds(94, 70, 95, 32);
				panel_3.add(tfbookid4);
				
				JLabel label_8 = new JLabel("书    名");
				label_8.setForeground(Color.RED);
				label_8.setFont(new Font("宋体", Font.BOLD, 15));
				label_8.setBounds(316, 70, 116, 32);
				panel_3.add(label_8);
				
				tfbookname4 = new JTextField();
				tfbookname4.setColumns(10);
				tfbookname4.setBounds(388, 70, 95, 32);
				panel_3.add(tfbookname4);
				
				JLabel label_9 = new JLabel("借阅时长");
				label_9.setForeground(Color.RED);
				label_9.setFont(new Font("宋体", Font.BOLD, 15));
				label_9.setBounds(22, 123, 116, 32);
				panel_3.add(label_9);
				
				JLabel label_10 = new JLabel("借阅日期");
				label_10.setForeground(Color.RED);
				label_10.setFont(new Font("宋体", Font.BOLD, 15));
				label_10.setBounds(316, 123, 116, 32);
				panel_3.add(label_10);
				
				tfbookborrowdate4 = new JTextField();
				tfbookborrowdate4.setColumns(10);
				tfbookborrowdate4.setBounds(388, 124, 143, 32);
				panel_3.add(tfbookborrowdate4);
				
				cbborrortime4 = new JComboBox();
				cbborrortime4.setFont(new Font("宋体", Font.PLAIN, 11));
				cbborrortime4.setModel(new DefaultComboBoxModel(new String[] {"选择借阅时长", "7天", "15天", "30天", "90天"}));
				cbborrortime4.setBounds(94, 129, 95, 21);
				panel_3.add(cbborrortime4);
				
				JLabel label_1111 = new JLabel("应归还日期");
				label_1111.setForeground(Color.RED);
				label_1111.setFont(new Font("宋体", Font.BOLD, 15));
				label_1111.setBounds(22, 180, 116, 32);
				panel_3.add(label_1111);
				
				tfneedreturntime4 = new JTextField();
				tfneedreturntime4.setColumns(10);
				tfneedreturntime4.setBounds(120, 181, 130, 32);
				panel_3.add(tfneedreturntime4);
				
				btnconfirm4 = new JButton("确认");
				btnconfirm4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!"".equals(tfbookname4.getText())){
							int row = jtbbookmsg3.getSelectedRow();
							String isborrow=""+jtbbookmsg3.getValueAt(row, 4);
							if("是".equals(isborrow)){
								JOptionPane.showMessageDialog(null, "对不起该书已被借出!");
							}else{
								tfbookborrowuser4.setText(name1);
								Vector<User> v = new UserServiceImpl().selectUserByUserName(new User(name1));
								tfbookborrowuserid4.setText(v.get(0).getUserid()+"");
								tfbookid4.setText(""+jtbbookmsg3.getValueAt(row, 0));
								tfbookname4.setText(""+jtbbookmsg3.getValueAt(row, 1));
								Object selectedItem = cbborrortime4.getSelectedItem();
								String borrowtime=selectedItem.toString();
								if("选择借阅时长".equals(borrowtime)) JOptionPane.showMessageDialog(null, "请选择借阅时长");
								else{
									SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
									java.sql.Date date=new java.sql.Date(new java.util.Date().getTime());
									tfbookborrowdate4.setText(date.toString());
									if("7天".equals(borrowtime)){
										tfneedreturntime4.setText(sdf.format(new java.util.Date().getTime()+ (long)7 * 24 * 60 * 60 * 1000));
									}
									if("15天".equals(borrowtime)){
										tfneedreturntime4.setText(sdf.format(new java.util.Date().getTime()+ (long)15 * 24 * 60 * 60 * 1000));
									}
									if("30天".equals(borrowtime)){
										tfneedreturntime4.setText(sdf.format(new java.util.Date().getTime()+ (long)30 * 24 * 60 * 60 * 1000));
									}
									if("90天".equals(borrowtime)){
										tfneedreturntime4.setText(sdf.format(new java.util.Date().getTime()+ (long)90 * 24 * 60 * 60 * 1000));
									}
									tfbookborrowuser4.setEditable(false);
									tfbookborrowuserid4.setEditable(false);
									tfbookid4.setEditable(false);
									tfbookname4.setEditable(false);
									cbborrortime4.setEditable(false);
									tfbookborrowdate4.setEditable(false);
									tfneedreturntime4.setEditable(false);
								}
							}
						}else{
							JOptionPane.showMessageDialog(null, "请点击上方表格导入想要借的书后再点击确定按钮！");
						}
					}
					
				});
				btnconfirm4.setForeground(Color.RED);
				btnconfirm4.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
				btnconfirm4.setBounds(283, 185, 137, 37);
				panel_3.add(btnconfirm4);
				
				btnborrow4 = new JButton("借阅");
				btnborrow4.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(!"".equals(tfneedreturntime4.getText())){
							String username=tfbookborrowuser4.getText();
							int userid=Integer.parseInt(tfbookborrowuserid4.getText());
							int bookid=Integer.parseInt(tfbookid4.getText());
							String bookname=tfbookname4.getText();
							Object selectedItem = cbborrortime4.getSelectedItem();
							String borrowtime=selectedItem.toString();
							User user=new User(username,userid);
							Book book=new Book(bookid,bookname);
							SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
							try {
								Date borrowdate=new java.sql.Date(sdf.parse(tfbookborrowdate4.getText()).getTime());
								Date needreturndate=new java.sql.Date(sdf.parse(tfneedreturntime4.getText()).getTime());
								boolean success=new BorrowServiceImpl().borrow(new Borrow(userid,username,bookid,bookname,borrowtime,borrowdate,needreturndate));
								if(success){
									JOptionPane.showMessageDialog(null, "恭喜您，借书成功，请在应归还日期之前还书");
									String isborrow="是";
									new BookServiceImpl().updateBookStatus(new Book(bookid,bookname,isborrow));
								}
								else JOptionPane.showMessageDialog(null, "借书失败");
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}else{
							JOptionPane.showMessageDialog(null, "请先点击确认按钮，再点击借阅按钮!");
						}
						
						
					}
				});
				btnborrow4.setForeground(Color.RED);
				btnborrow4.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 30));
				btnborrow4.setBounds(447, 185, 137, 37);
				panel_3.add(btnborrow4);
				borrowbookpanel.setVisible(false);
				
		//------------------------------分隔符----------------------------------
		//创建第六面板
		
		panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(Color.WHITE, 2, true));
		panel_6.setBounds(240, 10, 640, 647);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		panel_6.setOpaque(false);
		panel_6.setVisible(false);
		
		JPanel panel_111 = new JPanel();
		panel_111.setLayout(null);
		panel_111.setBorder(new LineBorder(Color.WHITE, 2, true));
		panel_111.setBounds(19, 10, 611, 133);
		panel_111.setOpaque(false);
		panel_6.add(panel_111);
		
		JLabel label111 = new JLabel("借阅用户");
		label111.setFont(new Font("宋体", Font.BOLD, 12));
		label111.setForeground(Color.RED);
		label111.setBounds(10, 10, 54, 27);
		panel_111.add(label111);
		
		tfusername7 = new JTextField(name1);
		tfusername7.setEditable(false);
		tfusername7.setColumns(10);
		tfusername7.setBounds(63, 13, 88, 24);
		panel_111.add(tfusername7);
		
		JLabel label_11111 = new JLabel("用户编号");
		label_11111.setFont(new Font("宋体", Font.BOLD, 12));
		label_11111.setForeground(Color.RED);
		label_11111.setBounds(180, 10, 54, 27);
		panel_111.add(label_11111);
		
		Vector<User> vector = new UserServiceImpl().selectUserByUserName(new User(name1));
		tfuserid7 = new JTextField(""+vector.get(0).getUserid());
		tfuserid7.setEditable(false);
		tfuserid7.setColumns(10);
		tfuserid7.setBounds(233, 13, 88, 24);
		panel_111.add(tfuserid7);
		
		JLabel label_211 = new JLabel("书   号");
		label_211.setFont(new Font("宋体", Font.BOLD, 12));
		label_211.setForeground(Color.RED);
		label_211.setBounds(355, 10, 54, 27);
		panel_111.add(label_211);
		
		tfbookid7 = new JTextField();
		tfbookid7.setColumns(10);
		tfbookid7.setBounds(408, 13, 88, 24);
		panel_111.add(tfbookid7);
		
		JLabel label_311 = new JLabel("书名");
		label_311.setFont(new Font("宋体", Font.BOLD, 12));
		label_311.setForeground(Color.RED);
		label_311.setBounds(10, 70, 54, 27);
		panel_111.add(label_311);
		
		tfbookname7 = new JTextField();
		tfbookname7.setColumns(10);
		tfbookname7.setBounds(63, 71, 88, 24);
		panel_111.add(tfbookname7);
		
		JLabel label_41 = new JLabel("借阅日期");
		label_41.setFont(new Font("宋体", Font.BOLD, 12));
		label_41.setForeground(Color.RED);
		label_41.setBounds(180, 70, 54, 27);
		panel_111.add(label_41);
		
		tfborrowdate7 = new JTextField();
		tfborrowdate7.setColumns(10);
		tfborrowdate7.setBounds(233, 71, 88, 24);
		panel_111.add(tfborrowdate7);
		
		JLabel label_51 = new JLabel("借阅时长");
		label_51.setFont(new Font("宋体", Font.BOLD, 12));
		label_51.setForeground(Color.RED);
		label_51.setBounds(355, 70, 54, 27);
		panel_111.add(label_51);
		
		JComboBox cbborrowtime7 = new JComboBox();
		cbborrowtime7.setForeground(Color.RED);
		cbborrowtime7.setModel(new DefaultComboBoxModel(new String[] {"选择借阅时长", "7天", "15天", "30天", "90天"}));
		cbborrowtime7.setFont(new Font("宋体", Font.PLAIN, 10));
		cbborrowtime7.setBounds(408, 73, 88, 21);
		panel_111.add(cbborrowtime7);
		
		JButton btnselect7 = new JButton();
		btnselect7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Borrow borrow=new Borrow();
				if(!"".equals(tfusername7.getText())){
					String username=tfusername7.getText();
					borrow.setUsername(username);
				}
				if(!"".equals(tfbookname7.getText())){
					String bookname=tfbookname7.getText();
					borrow.setBookname(bookname);
				}
				if(!"选择借阅时长".equals(cbborrowtime7.getSelectedItem().toString())){
					String borrowtime=cbborrowtime7.getSelectedItem().toString();
					borrow.setBorrowTime(borrowtime);
				}
				if(!"".equals(tfuserid7.getText())){
					int userid=Integer.parseInt(tfuserid7.getText());
					borrow.setUserid(userid);
				}
				if(!"".equals(tfbookid7.getText())) {
					int bookid=Integer.parseInt(tfbookid7.getText());
					borrow.setBookid(bookid);
				}
				if(!"".equals(tfborrowdate7.getText())) {
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					try {
						java.sql.Date borrowdate = new java.sql.Date(sdf.parse(tfborrowdate7.getText()).getTime());
						borrow.setBorrowDate(borrowdate);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				fillBorrowTable((new BorrowServiceImpl().selectBorrowByCondition(borrow)));
			}
		});
		btnselect7.setForeground(Color.RED);
		btnselect7.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 18));
		btnselect7.setBounds(518, 13, 72, 110);
		panel_111.add(btnselect7);
		new SetButtonImage(btnselect7, "images/btnselect7png.png");
		btnselect7.setContentAreaFilled(false);
		
		JPanel panel_211 = new JPanel();
		panel_211.setLayout(null);
		panel_211.setBorder(new LineBorder(Color.WHITE, 2, true));
		panel_211.setBounds(19, 168, 611, 306);
		panel_211.setOpaque(false);
		panel_6.add(panel_211);
		
		JScrollPane scrollPane11 = new JScrollPane();
		scrollPane11.setBounds(0, 0, 611, 306);
		panel_211.add(scrollPane11);
		
		jtborrowmsg7 = new JTable();
		jtborrowmsg7.getTableHeader().setReorderingAllowed(false); //不可整列移动
		jtborrowmsg7.getTableHeader().setResizingAllowed(false); //不可拉动表格
		jtborrowmsg7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cbborrowtime8.setEnabled(false);
				int row = jtborrowmsg7.getSelectedRow();
				tfborrowno8.setText(""+jtborrowmsg7.getValueAt(row, 0));
				tfusername8.setText(""+jtborrowmsg7.getValueAt(row, 1));
				tfuserid8.setText(""+jtborrowmsg7.getValueAt(row, 2));
				tfbookid8.setText(""+jtborrowmsg7.getValueAt(row, 3));
				tfbookname8.setText(""+jtborrowmsg7.getValueAt(row, 4));
				cbborrowtime8.setSelectedItem(""+jtborrowmsg7.getValueAt(row, 5));
				tfborrowdate8.setText(""+jtborrowmsg7.getValueAt(row, 6));
				tfduereturndate8.setText(""+jtborrowmsg7.getValueAt(row, 7));
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				tfreturndate8.setText(sdf.format(new java.util.Date()));
			}
			
		});
		jtborrowmsg7.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\u501F\u9605\u7F16\u53F7", "\u501F\u9605\u7528\u6237", "\u7528\u6237\u7F16\u53F7", "\u4E66    \u53F7", "\u4E66    \u540D", "\u501F\u9605\u65F6\u95F4", "\u501F\u9605\u65E5\u671F", "\u5E94\u8FD8\u65E5\u671F", "\u8FD8\u4E66\u65E5\u671F"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		jtborrowmsg7.getColumnModel().getColumn(0).setPreferredWidth(68);
		jtborrowmsg7.getColumnModel().getColumn(1).setPreferredWidth(71);
		jtborrowmsg7.getColumnModel().getColumn(2).setPreferredWidth(68);
		jtborrowmsg7.getColumnModel().getColumn(3).setPreferredWidth(72);
		jtborrowmsg7.getColumnModel().getColumn(4).setPreferredWidth(70);
		jtborrowmsg7.getColumnModel().getColumn(5).setResizable(false);
		jtborrowmsg7.getColumnModel().getColumn(5).setPreferredWidth(79);
		jtborrowmsg7.getColumnModel().getColumn(6).setPreferredWidth(92);
		jtborrowmsg7.getColumnModel().getColumn(7).setPreferredWidth(78);
		jtborrowmsg7.getColumnModel().getColumn(8).setPreferredWidth(89);
		scrollPane11.setViewportView(jtborrowmsg7);
		fillBorrowTable(new BorrowServiceImpl().selectBorrowByCondition(new Borrow(name1)));
		
		
		JPanel panel_31 = new JPanel();
		panel_31.setLayout(null);
		panel_31.setBorder(new LineBorder(Color.WHITE, 2, true));
		panel_31.setBounds(19, 484, 611, 153);
		panel_31.setOpaque(false);
		panel_6.add(panel_31);
		
		JLabel label_61 = new JLabel("借阅用户");
		label_61.setFont(new Font("宋体", Font.BOLD, 12));
		label_61.setForeground(Color.RED);
		label_61.setBounds(10, 22, 54, 27);
		panel_31.add(label_61);
		
		tfusername8 = new JTextField();
		tfusername8.setEditable(false);
		tfusername8.setColumns(10);
		tfusername8.setBounds(63, 25, 88, 24);
		panel_31.add(tfusername8);
		
		JLabel label_71 = new JLabel("用户编号");
		label_71.setFont(new Font("宋体", Font.BOLD, 12));
		label_71.setForeground(Color.RED);
		label_71.setBounds(162, 22, 54, 27);
		panel_31.add(label_71);
		
		tfuserid8 = new JTextField();
		tfuserid8.setEditable(false);
		tfuserid8.setColumns(10);
		tfuserid8.setBounds(215, 25, 88, 24);
		panel_31.add(tfuserid8);
		
		JLabel label_81 = new JLabel("书    号");
		label_81.setFont(new Font("宋体", Font.BOLD, 12));
		label_81.setForeground(Color.RED);
		label_81.setBounds(337, 22, 54, 27);
		panel_31.add(label_81);
		
		tfbookid8 = new JTextField();
		tfbookid8.setEditable(false);
		tfbookid8.setColumns(10);
		tfbookid8.setBounds(390, 25, 88, 24);
		panel_31.add(tfbookid8);
		
		JLabel label_91 = new JLabel("书    名");
		label_91.setFont(new Font("宋体", Font.BOLD, 12));
		label_91.setForeground(Color.RED);
		label_91.setBounds(10, 69, 54, 27);
		panel_31.add(label_91);
		
		tfbookname8 = new JTextField();
		tfbookname8.setEditable(false);
		tfbookname8.setColumns(10);
		tfbookname8.setBounds(63, 72, 88, 24);
		panel_31.add(tfbookname8);
		
		JLabel label_101 = new JLabel("借阅日期");
		label_101.setFont(new Font("宋体", Font.BOLD, 12));
		label_101.setForeground(Color.RED);
		label_101.setBounds(162, 69, 54, 27);
		panel_31.add(label_101);
		
		tfborrowdate8 = new JTextField();
		tfborrowdate8.setEditable(false);
		tfborrowdate8.setColumns(10);
		tfborrowdate8.setBounds(215, 72, 88, 24);
		panel_31.add(tfborrowdate8);
		
		JLabel label_111111 = new JLabel("借阅时长");
		label_111111.setFont(new Font("宋体", Font.BOLD, 12));
		label_111111.setForeground(Color.RED);
		label_111111.setBounds(337, 69, 54, 27);
		panel_31.add(label_111111);
		
		tfduereturndate8 = new JTextField();
		tfduereturndate8.setEditable(false);
		tfduereturndate8.setColumns(10);
		tfduereturndate8.setBounds(94, 116, 88, 24);
		panel_31.add(tfduereturndate8);
		
		JLabel label_12 = new JLabel("应归还日期");
		label_12.setFont(new Font("宋体", Font.BOLD, 12));
		label_12.setForeground(Color.RED);
		label_12.setBounds(10, 114, 74, 27);
		panel_31.add(label_12);
		
		JLabel label_13 = new JLabel("归还日期");
		label_13.setFont(new Font("宋体", Font.BOLD, 12));
		label_13.setForeground(Color.RED);
		label_13.setBounds(203, 113, 54, 27);
		panel_31.add(label_13);
		
		tfreturndate8 = new JTextField();
		tfreturndate8.setEditable(false);
		tfreturndate8.setColumns(10);
		tfreturndate8.setBounds(256, 116, 88, 24);
		panel_31.add(tfreturndate8);
		
		cbborrowtime8 = new JComboBox();
		cbborrowtime8.setForeground(new Color(255, 0, 0));
		cbborrowtime8.setModel(new DefaultComboBoxModel(new String[] {"选择借阅时长", "7天", "15天", "30天", "90天"}));
		cbborrowtime8.setFont(new Font("宋体", Font.BOLD, 10));
		cbborrowtime8.setBounds(390, 72, 88, 21);
		panel_31.add(cbborrowtime8);
		
		JButton btnreturnbook8 = new JButton("还书");
		btnreturnbook8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!"".equals(tfborrowno8.getText())){
					if(null!=(jtborrowmsg7.getValueAt(jtborrowmsg7.getSelectedRow(), 8))){
						JOptionPane.showMessageDialog(null, "对不起，你选择的该书已还");
					}else{
						String username=tfusername8.getText();
						int bookid=Integer.parseInt(tfbookid8.getText());
						String bookname=tfbookname8.getText();
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
						try {
							java.sql.Date returndate=new java.sql.Date(sdf.parse(tfreturndate8.getText()).getTime());
							int borrowno=Integer.parseInt(tfborrowno8.getText());
							boolean success=new BorrowServiceImpl().returnBook(new Borrow(borrowno,username,bookid,returndate));
							if(success){
								JOptionPane.showMessageDialog(null, "恭喜您，还书成功！");
								String borrow="否";
								new BookServiceImpl().updateBookStatus(new Book(bookid,bookname,borrow));
								
							}else{
								JOptionPane.showMessageDialog(null, "还书失败！");
							}
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}else{
					JOptionPane.showMessageDialog(null, "请点击上方表格选择你要归还的书后再点击还书按钮!");
				}
				
			}
		});
		btnreturnbook8.setForeground(Color.RED);
		btnreturnbook8.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 18));
		btnreturnbook8.setBounds(518, 25, 72, 110);
		panel_31.add(btnreturnbook8);
		
		JLabel label1111 = new JLabel("借阅编号");
		label1111.setFont(new Font("宋体", Font.BOLD, 12));
		label1111.setForeground(Color.RED);
		label1111.setBounds(367, 113, 54, 27);
		panel_31.add(label1111);
		
		tfborrowno8 = new JTextField();
		tfborrowno8.setEditable(false);
		tfborrowno8.setColumns(10);
		tfborrowno8.setBounds(420, 116, 88, 24);
		panel_31.add(tfborrowno8);
		//------------------------------分隔符----------------------------------
		//事件处理
		//修改密码按钮
		btnupdatepwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logmsgpanel.setVisible(false);
				selebookpanel.setVisible(false);
				borrowbookpanel.setVisible(false);
				panel_6.setVisible(false);
				uppsdpanel.setVisible(true);
			}
		});
		
		//用户管理按钮
		btselectbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logmsgpanel.setVisible(false);
				uppsdpanel.setVisible(false);
				borrowbookpanel.setVisible(false);
				panel_6.setVisible(false);
				selebookpanel.setVisible(true);
			}
		});
		
		//图书管理按钮
		btnbookborrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logmsgpanel.setVisible(false);
				uppsdpanel.setVisible(false);
				selebookpanel.setVisible(false);
				panel_6.setVisible(false);
				borrowbookpanel.setVisible(true);
			}
		});
		
		//修改密码按钮
		btnupdate1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!"".equals(tfoldpwd.getText())&&!"".equals(tfnnewpwd.getText())&&!"".equals(tfnewpwd1.getText())){
					String oldpwd=tfoldpwd.getText();
					String newpwd=tfnnewpwd.getText();
					String newpwd2=tfnewpwd1.getText();
					if(oldpwd.equals(pwd1)&&newpwd.equals(newpwd2)){
						boolean success=new UserServiceImpl().updateUserPwd(new User(name1,newpwd));
						if(success) JOptionPane.showMessageDialog(null, "密码修改成功");
						else	JOptionPane.showMessageDialog(null, "密码修改失败");
					}
					else{
						JOptionPane.showMessageDialog(null, "原密码错误或两次输入的密码不一致");
					}
				}else{
					JOptionPane.showMessageDialog(null, "请将内容输入完整！");
				}
			
			}
		});
		
		//还书功能按钮
		btnbookreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logmsgpanel.setVisible(false);
				uppsdpanel.setVisible(false);
				selebookpanel.setVisible(false);
				borrowbookpanel.setVisible(false);
				panel_6.setVisible(true);
			}
		});
		
		//------------------------------分隔符----------------------------------
		//重置按钮
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!"".equals(tfoldpwd.getText())&&!"".equals(tfnnewpwd.getText())&&!"".equals(tfnewpwd1.getText())){
					tfoldpwd.setText("");
					tfnewpwd1.setText("");
					tfnnewpwd.setText("");
				}else{
					JOptionPane.showMessageDialog(null, "请将内容输入完整！");
				}
			}
		});
		new Thread(this).start();
	}
	
	//填充表格功能
	public void fillTable(Vector<Book> vector){
		DefaultTableModel dtm=(DefaultTableModel) jtbookmsg.getModel();
		dtm.setRowCount(0);
		for(Book book:vector){
			dtm.addRow(new Object[]{book.getBookId(),book.getBookName(),book.getAuthor(),book.getStorageTime(),book.getBorrow()});
		}
	}
	
	//填充表格功能
		public void fillTable2(Vector<Book> vector){
			DefaultTableModel dtm=(DefaultTableModel) jtbbookmsg3.getModel();
			dtm.setRowCount(0);
			for(Book book:vector){
				dtm.addRow(new Object[]{book.getBookId(),book.getBookName(),book.getAuthor(),book.getStorageTime(),book.getBorrow()});
			}
		}
		
		//填充借阅表表格功能
		public void fillBorrowTable(Vector<Borrow> vector){
			DefaultTableModel dtm=(DefaultTableModel) jtborrowmsg7.getModel();
			dtm.setRowCount(0);
			for(Borrow borrow:vector) {
				dtm.addRow(new Object[]{borrow.getBorrowno(),borrow.getUsername(),borrow.getUserid(),
						borrow.getBookid(),borrow.getBookname(),borrow.getBorrowTime(),
						borrow.getBorrowDate(),borrow.getDueDate(),borrow.getReturnDate()});
			}
		}
		


	
	public void run() {
		while(true){
			try {
				java.util.Date now=new java.util.Date();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String str=sdf.format(now);
				tftime.setText(str);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
