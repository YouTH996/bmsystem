package lanqiao.sanzu.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import lanqiao.sanzu.entity.Manager;
import lanqiao.sanzu.entity.User;
import lanqiao.sanzu.service.impl.BookServiceImpl;
import lanqiao.sanzu.service.impl.BorrowServiceImpl;
import lanqiao.sanzu.service.impl.ManagerServiceImpl;
import lanqiao.sanzu.service.impl.UserServiceImpl;
import lanqiao.sanzu.util.SetBackground;
import lanqiao.sanzu.util.SetButtonImage;
import lanqiao.sanzu.util.SetIconImage;
import lanqiao.sanzu.util.SetJFrameLocation;
import lanqiao.sanzu.util.SetLabelImage;

public class ManagerMainFrm extends JFrame implements Runnable {
	private JLabel tftime;
	private JPanel logmsgpanel;
	private JPanel usermanpanel;
	private JPanel uppsdpanel;
	private JPanel contentPane;
	private JPanel libmanage;
	private JButton btnlibmanage;   //第一个面板中的图书管理按钮
	private JTextField tfoldpwd;
	private JTextField tfnewpwd1;              //第三个面板中用来确认新密码的文本框
	private JTextField tfnnewpwd;                  //第三个面板中用来输入新密码的文本框
	private JButton btnreset;     //第三个面板中的重置信息的按钮
	private JButton btnupdate1;   //第三个面板中的修改密码的按钮
	private JTextField tfuseraccount;           //第四个面板中用来查询用户信息的用户账户文本框
	private JTable jtusermsg;                  //第四个面板中显示用户所有信息的表格
	private JTextField usersid;                //第四个面板中修改用户id的文本框
	private JTextField useraccountupdate;     //第四个面板中修改用户账户的文本框
	private JTextField userpwdupdate;   //第四个面板中的修改用户密码的文本框
	private JButton btnuserselect;      //第四个面板中的查询用户信息功能
	private JButton btnuserupdate;       //第四个面板中的修改用户信息功能按钮
	private JButton btnuserdelete;     //第四个面板中的删除用户信息功能按钮
	private JButton addbook;     //第五个面板中的图书添加按钮
	private JButton bookinfomanage;   //第五个面板中的图书资料管理按钮
	private JTable jtborrowmsg6;
	private JTextField tfusername6;
	private JTextField tfuserid6;
	private JTextField tfbookid6;
	private JTextField tfbookname6;
	private JTextField tfborrowdate6;
	private JTextField tfusername7;
	private JTextField tfuserid7;
	private JTextField tfbookid7;
	private JTextField tfbookname7;
	private JTextField tfborrowdate7;
	private JTextField tfneedreturndate7;
	private JTextField tfreturndate7;
	private JComboBox cbborrowtime7;
	private JTextField tfborrowno7;
	

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public ManagerMainFrm(String name1,String pwd1) {
		
		new SetIconImage(this, "images/bmsmain.png");
		setVisible(true);
		setResizable(false);
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
		panel.setLayout(null);
		panel.setOpaque(false);
		
		JButton btnupdatepwd = new JButton();
		btnupdatepwd.setFont(new Font("楷体", Font.BOLD, 20));
		btnupdatepwd.setForeground(Color.RED);
		btnupdatepwd.setBounds(10, 28, 212, 43);
		new SetButtonImage(btnupdatepwd, "images/updatepwd.png");
		btnupdatepwd.setContentAreaFilled(false);
		panel.add(btnupdatepwd);
		
		JButton btnusermanage = new JButton();
		btnusermanage.setForeground(Color.RED);
		btnusermanage.setFont(new Font("楷体", Font.BOLD, 20));
		btnusermanage.setBounds(10, 110, 212, 43);
		new SetButtonImage(btnusermanage, "images/usermanage.png");
		btnusermanage.setContentAreaFilled(false);
		panel.add(btnusermanage);
		
		btnlibmanage = new JButton();
		btnlibmanage.setForeground(Color.RED);
		btnlibmanage.setFont(new Font("楷体", Font.BOLD, 20));
		btnlibmanage.setBounds(10, 188, 212, 43);
		new SetButtonImage(btnlibmanage, "images/bookmanage.png");
		btnlibmanage.setContentAreaFilled(false);
		panel.add(btnlibmanage);
		
		JButton btnselect = new JButton();
		btnselect.setForeground(Color.RED);
		btnselect.setFont(new Font("楷体", Font.BOLD, 20));
		btnselect.setBounds(10, 265, 212, 43);
		new SetButtonImage(btnselect, "images/selectborrow.png");
		btnselect.setContentAreaFilled(false);
		panel.add(btnselect);
		
		JLabel lblNewLabel = new JLabel("当前系统时间:");
		lblNewLabel.setForeground(new Color(75, 0, 130));
		lblNewLabel.setFont(new Font("新宋体", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(30, 355, 151, 30);
		panel.add(lblNewLabel);
		
		tftime = new JLabel("2019-7-16 17:23");
		tftime.setForeground(Color.RED);
		tftime.setFont(new Font("宋体", Font.BOLD, 18));
		tftime.setBounds(20, 395, 222, 54);
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
		logmsgpanel.setLayout(null);
		logmsgpanel.setOpaque(false);
		
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
		uppsdpanel.setLayout(null);
		uppsdpanel.setOpaque(false);
		
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
		label.setFont(new Font("宋体", Font.BOLD, 20));
		label.setForeground(new Color(0, 255, 255));
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
		
		btnupdate1 = new JButton("修改");
		
		btnupdate1.setBounds(62, 486, 137, 43);
		uppsdpanel.add(btnupdate1);
		
		JButton btnreset = new JButton("重置");
		
		btnreset.setBounds(266, 486, 137, 43);
		uppsdpanel.add(btnreset);
		
		JLabel lblNewLabel_11 = new JLabel("修改密码");
		lblNewLabel_11.setForeground(new Color(255, 0, 255));
		lblNewLabel_11.setFont(new Font("新宋体", Font.BOLD, 30));
		lblNewLabel_11.setBounds(137, 49, 198, 81);
		uppsdpanel.add(lblNewLabel_11);
		uppsdpanel.setVisible(false);
		
		
		//------------------------------分隔符----------------------------------
		//创建第四个面板
		usermanpanel = new JPanel();
		usermanpanel.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		usermanpanel.setBounds(246, 10, 637, 647);
		contentPane.add(usermanpanel);
		usermanpanel.setOpaque(false);
		usermanpanel.setLayout(null);
		
		JLabel lblNewLabel_111 = new JLabel("用户管理");
		lblNewLabel_111.setBounds(57, 52, 359, 50);
		lblNewLabel_111.setForeground(new Color(128, 0, 128));
		lblNewLabel_111.setFont(new Font("新宋体", Font.BOLD | Font.ITALIC, 30));
		usermanpanel.add(lblNewLabel_111);
		
		JLabel lblNewLabel_31 = new JLabel("用户账号");
		lblNewLabel_31.setForeground(Color.RED);
		lblNewLabel_31.setBounds(57, 156, 99, 33);
		lblNewLabel_31.setFont(new Font("宋体", Font.BOLD, 15));
		usermanpanel.add(lblNewLabel_31);
		
		tfuseraccount = new JTextField();
		tfuseraccount.setBounds(136, 151, 158, 43);
		usermanpanel.add(tfuseraccount);
		tfuseraccount.setColumns(10);
		
		btnuserselect = new JButton("查询");
		btnuserselect.setBounds(358, 156, 113, 33);
		usermanpanel.add(btnuserselect);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 221, 579, 216);
		scrollPane.setOpaque(false);
		usermanpanel.add(scrollPane);
		
		jtusermsg = new JTable();
		jtusermsg.getTableHeader().setReorderingAllowed(false); //不可整列移动
		jtusermsg.getTableHeader().setResizingAllowed(false); //不可拉动表格
		jtusermsg.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"\u7528\u6237\u5B66\u53F7", "\u7528\u6237\u8D26\u53F7", "\u7528\u6237\u5BC6\u7801"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(jtusermsg);
		fillTable(new UserServiceImpl().selectAllUser());
		
		JLabel lblNewLabel_4 = new JLabel("用户学号");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 12));
		lblNewLabel_4.setBounds(109, 456, 93, 33);
		usermanpanel.add(lblNewLabel_4);
		
		usersid = new JTextField();
		usersid.setEditable(false);
		usersid.setBounds(195, 452, 166, 42);
		usermanpanel.add(usersid);
		usersid.setColumns(10);
		
		JLabel label1 = new JLabel("用户账号");
		label1.setFont(new Font("宋体", Font.BOLD, 12));
		label1.setForeground(Color.RED);
		label1.setBounds(109, 519, 93, 33);
		usermanpanel.add(label1);
		
		useraccountupdate = new JTextField();
		useraccountupdate.setColumns(10);
		useraccountupdate.setBounds(195, 515, 166, 42);
		usermanpanel.add(useraccountupdate);
		
		JLabel label_2 = new JLabel("用户密码");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("宋体", Font.BOLD, 12));
		label_2.setBounds(109, 584, 93, 33);
		usermanpanel.add(label_2);
		
		userpwdupdate = new JTextField();
		userpwdupdate.setColumns(10);
		userpwdupdate.setBounds(195, 580, 166, 42);
		usermanpanel.add(userpwdupdate);
		
		btnuserupdate = new JButton("修改");
		btnuserupdate.setBounds(412, 502, 107, 33);
		usermanpanel.add(btnuserupdate);
		
		btnuserdelete = new JButton("删除");
		btnuserdelete.setBounds(412, 564, 107, 33);
		usermanpanel.add(btnuserdelete);
		usermanpanel.setVisible(false);
		
		//------------------------------分隔符----------------------------------
		//创建第五个面板
				libmanage = new JPanel();
				libmanage.setBorder(new LineBorder(Color.WHITE, 2, true));
				libmanage.setBounds(252, 10, 631, 647);
				contentPane.add(libmanage);
				libmanage.setOpaque(false);
				libmanage.setLayout(null);
				
				addbook = new JButton("添加图书");
				addbook.setFont(new Font("宋体", Font.BOLD, 30));
				addbook.setBounds(27, 179, 286, 77);
				libmanage.add(addbook);
				
				bookinfomanage = new JButton("图书资料管理");
				bookinfomanage.setFont(new Font("宋体", Font.BOLD, 30));
				bookinfomanage.setBounds(27, 304, 286, 77);
				libmanage.add(bookinfomanage);
				libmanage.setVisible(false);
		
		//------------------------------分隔符----------------------------------
		//创建第6个面板
				JPanel panel_6 = new JPanel();
				panel_6.setBorder(new LineBorder(Color.WHITE, 2, true));
				panel_6.setBounds(252, 10, 631, 647);
				contentPane.add(panel_6);
				panel_6.setOpaque(false);
				panel_6.setLayout(null);
				
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new LineBorder(Color.WHITE, 2, true));
				panel_1.setBounds(10, 10, 611, 133);
				panel_6.add(panel_1);
				panel_1.setOpaque(false);
				panel_1.setLayout(null);
				
				JLabel lblNewLabel_1111 = new JLabel("借阅用户");
				lblNewLabel_1111.setFont(new Font("宋体", Font.BOLD, 12));
				lblNewLabel_1111.setForeground(Color.RED);
				lblNewLabel_1111.setBounds(10, 10, 54, 27);
				panel_1.add(lblNewLabel_1111);
				
				tfusername6 = new JTextField();
				tfusername6.setBounds(63, 13, 88, 24);
				panel_1.add(tfusername6);
				tfusername6.setColumns(10);
				
				JLabel label11 = new JLabel("用户编号");
				label11.setFont(new Font("宋体", Font.BOLD, 12));
				label11.setForeground(Color.RED);
				label11.setBounds(180, 10, 54, 27);
				panel_1.add(label11);
				
				tfuserid6 = new JTextField();
				tfuserid6.setColumns(10);
				tfuserid6.setBounds(233, 13, 88, 24);
				panel_1.add(tfuserid6);
				
				JLabel label_11 = new JLabel("书   号");
				label_11.setFont(new Font("宋体", Font.BOLD, 12));
				label_11.setForeground(Color.RED);
				label_11.setBounds(355, 10, 54, 27);
				panel_1.add(label_11);
				
				tfbookid6 = new JTextField();
				tfbookid6.setColumns(10);
				tfbookid6.setBounds(408, 13, 88, 24);
				panel_1.add(tfbookid6);
				
				JLabel label_21 = new JLabel("书名");
				label_21.setForeground(Color.RED);
				label_21.setFont(new Font("宋体", Font.BOLD, 12));
				label_21.setBounds(10, 70, 54, 27);
				panel_1.add(label_21);
				
				tfbookname6 = new JTextField();
				tfbookname6.setColumns(10);
				tfbookname6.setBounds(63, 71, 88, 24);
				panel_1.add(tfbookname6);
				
				JLabel label_3 = new JLabel("借阅日期");
				label_3.setFont(new Font("宋体", Font.BOLD, 12));
				label_3.setForeground(Color.RED);
				label_3.setBounds(180, 70, 54, 27);
				panel_1.add(label_3);
				
				tfborrowdate6 = new JTextField();
				tfborrowdate6.setColumns(10);
				tfborrowdate6.setBounds(233, 71, 88, 24);
				panel_1.add(tfborrowdate6);
				
				JLabel label_4 = new JLabel("借阅时长");
				label_4.setFont(new Font("宋体", Font.BOLD, 12));
				label_4.setForeground(Color.RED);
				label_4.setBounds(355, 70, 54, 27);
				panel_1.add(label_4);
				
				JComboBox cbborrowtime6 = new JComboBox();
				cbborrowtime6.setForeground(Color.RED);
				cbborrowtime6.setModel(new DefaultComboBoxModel(new String[] {"选择借阅时长", "7天", "15天", "30天", "90天"}));
				cbborrowtime6.setFont(new Font("宋体", Font.BOLD, 10));
				cbborrowtime6.setBounds(408, 73, 88, 21);
				panel_1.add(cbborrowtime6);
				
				JButton btnselect6 = new JButton();
				btnselect6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Borrow borrow=new Borrow();
						if(!"".equals(tfusername6.getText())){
							String username=tfusername6.getText();
							borrow.setUsername(username);
						}
						if(!"".equals(tfbookname6.getText())){
							String bookname=tfbookname6.getText();
							borrow.setBookname(bookname);
						}
						if(!"选择借阅时长".equals(cbborrowtime6.getSelectedItem().toString())){
							String borrowtime=cbborrowtime6.getSelectedItem().toString();
							borrow.setBorrowTime(borrowtime);
						}
						if(!"".equals(tfuserid6.getText())){
							int userid=Integer.parseInt(tfuserid6.getText());
							borrow.setUserid(userid);
						}
						if(!"".equals(tfbookid6.getText())) {
							int bookid=Integer.parseInt(tfbookid6.getText());
							borrow.setBookid(bookid);
						}
						if(!"".equals(tfborrowdate6.getText())) {
							SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
							try {
								java.sql.Date borrowdate = new java.sql.Date(sdf.parse(tfborrowdate6.getText()).getTime());
								borrow.setBorrowDate(borrowdate);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						fillBorrowTable((new BorrowServiceImpl().selectBorrowByCondition(borrow)));
					}
				});
				btnselect6.setForeground(Color.RED);
				btnselect6.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 18));
				btnselect6.setBounds(518, 13, 72, 110);
				panel_1.add(btnselect6);
				new SetButtonImage(btnselect6, "images/btnselect7png.png");
				btnselect6.setContentAreaFilled(false);
				
				JPanel panel_2 = new JPanel();
				panel_2.setBorder(new LineBorder(Color.WHITE, 2, true));
				panel_2.setBounds(10, 168, 611, 306);
				panel_6.add(panel_2);
				panel_2.setOpaque(false);
				panel_2.setLayout(null);
				
				JScrollPane scrollPane1 = new JScrollPane();
				scrollPane1.setBounds(0, 0, 611, 306);
				scrollPane1.setOpaque(false);
				panel_2.add(scrollPane1);
				
				jtborrowmsg6 = new JTable();
				jtborrowmsg6.getTableHeader().setReorderingAllowed(false); //不可整列移动
				jtborrowmsg6.getTableHeader().setResizingAllowed(false); //不可拉动表格
				jtborrowmsg6.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int row = jtborrowmsg6.getSelectedRow();
						tfborrowno7.setText(""+jtborrowmsg6.getValueAt(row, 0));
						tfusername7.setText(""+jtborrowmsg6.getValueAt(row, 1));
						tfuserid7.setText(""+jtborrowmsg6.getValueAt(row, 2));
						tfbookid7.setText(""+jtborrowmsg6.getValueAt(row, 3));
						tfbookname7.setText(""+jtborrowmsg6.getValueAt(row, 4));
						cbborrowtime7.setSelectedItem(""+jtborrowmsg6.getValueAt(row, 5));
						tfborrowdate7.setText(""+jtborrowmsg6.getValueAt(row, 6));
						tfneedreturndate7.setText(""+jtborrowmsg6.getValueAt(row, 7));
						if(null==jtborrowmsg6.getValueAt(row, 8))
							tfreturndate7.setText("");
							
						else
							tfreturndate7.setText(""+jtborrowmsg6.getValueAt(row, 8));
					}
				});
				jtborrowmsg6.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null, null, null, null, null},
					},
					new String[] {
						"\u501F\u9605\u7F16\u53F7", "\u501F\u9605\u7528\u6237", "\u7528\u6237\u7F16\u53F7", "\u4E66   \u53F7", "\u4E66   \u540D", "\u501F\u9605\u65F6\u957F", "\u501F\u9605\u65E5\u671F", "\u5E94\u5F52\u8FD8\u65E5\u671F", "\u5F52\u8FD8\u65E5\u671F"
					}
				) {
					boolean[] columnEditables = new boolean[] {
						true, false, false, false, false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				jtborrowmsg6.getColumnModel().getColumn(0).setPreferredWidth(63);
				jtborrowmsg6.getColumnModel().getColumn(1).setPreferredWidth(68);
				jtborrowmsg6.getColumnModel().getColumn(2).setPreferredWidth(64);
				jtborrowmsg6.getColumnModel().getColumn(3).setPreferredWidth(62);
				jtborrowmsg6.getColumnModel().getColumn(4).setPreferredWidth(67);
				jtborrowmsg6.getColumnModel().getColumn(5).setPreferredWidth(66);
				jtborrowmsg6.getColumnModel().getColumn(7).setPreferredWidth(90);
				scrollPane1.setViewportView(jtborrowmsg6);
				fillBorrowTable(new BorrowServiceImpl().selectAllBorrow());
				
				JPanel panel_3 = new JPanel();
				panel_3.setBorder(new LineBorder(Color.WHITE, 2, true));
				panel_3.setBounds(10, 484, 611, 153);
				panel_6.add(panel_3);
				panel_3.setOpaque(false);
				panel_3.setLayout(null);
				
				JLabel label_8 = new JLabel("借阅用户");
				label_8.setForeground(Color.RED);
				label_8.setFont(new Font("宋体", Font.BOLD, 12));
				label_8.setBounds(10, 22, 54, 27);
				panel_3.add(label_8);
				
				tfusername7 = new JTextField();
				tfusername7.setEditable(false);
				tfusername7.setColumns(10);
				tfusername7.setBounds(63, 25, 88, 24);
				panel_3.add(tfusername7);
				
				JLabel label_9 = new JLabel("用户编号");
				label_9.setFont(new Font("宋体", Font.BOLD, 12));
				label_9.setForeground(Color.RED);
				label_9.setBounds(162, 22, 54, 27);
				panel_3.add(label_9);
				
				tfuserid7 = new JTextField();
				tfuserid7.setEditable(false);
				tfuserid7.setColumns(10);
				tfuserid7.setBounds(215, 25, 88, 24);
				panel_3.add(tfuserid7);
				
				JLabel label_10 = new JLabel("书    号");
				label_10.setFont(new Font("宋体", Font.BOLD, 12));
				label_10.setForeground(Color.RED);
				label_10.setBounds(337, 22, 54, 27);
				panel_3.add(label_10);
				
				tfbookid7 = new JTextField();
				tfbookid7.setEditable(false);
				tfbookid7.setColumns(10);
				tfbookid7.setBounds(390, 25, 88, 24);
				panel_3.add(tfbookid7);
				
				JLabel label_111 = new JLabel("书    名");
				label_111.setFont(new Font("宋体", Font.BOLD, 12));
				label_111.setForeground(Color.RED);
				label_111.setBounds(10, 69, 54, 27);
				panel_3.add(label_111);
				
				tfbookname7 = new JTextField();
				tfbookname7.setEditable(false);
				tfbookname7.setColumns(10);
				tfbookname7.setBounds(63, 72, 88, 24);
				panel_3.add(tfbookname7);
				
				JLabel label_12 = new JLabel("借阅日期");
				label_12.setFont(new Font("宋体", Font.BOLD, 12));
				label_12.setForeground(Color.RED);
				label_12.setBounds(162, 69, 54, 27);
				panel_3.add(label_12);
				
				tfborrowdate7 = new JTextField();
				tfborrowdate7.setColumns(10);
				tfborrowdate7.setBounds(215, 72, 88, 24);
				panel_3.add(tfborrowdate7);
				
				JLabel label_13 = new JLabel("借阅时长");
				label_13.setFont(new Font("宋体", Font.BOLD, 12));
				label_13.setForeground(Color.RED);
				label_13.setBounds(337, 69, 54, 27);
				panel_3.add(label_13);
				
				tfneedreturndate7 = new JTextField();
				tfneedreturndate7.setColumns(10);
				tfneedreturndate7.setBounds(94, 116, 88, 24);
				panel_3.add(tfneedreturndate7);
				
				JLabel label_14 = new JLabel("应归还日期");
				label_14.setFont(new Font("宋体", Font.BOLD, 12));
				label_14.setForeground(Color.RED);
				label_14.setBounds(10, 114, 74, 27);
				panel_3.add(label_14);
				
				JLabel label_15 = new JLabel("归还日期");
				label_15.setFont(new Font("宋体", Font.BOLD, 12));
				label_15.setForeground(Color.RED);
				label_15.setBounds(215, 113, 54, 27);
				panel_3.add(label_15);
				
				tfreturndate7 = new JTextField();
				tfreturndate7.setColumns(10);
				tfreturndate7.setBounds(268, 116, 88, 24);
				panel_3.add(tfreturndate7);
				
				cbborrowtime7 = new JComboBox();
				cbborrowtime7.setForeground(Color.RED);
				cbborrowtime7.setFont(new Font("宋体", Font.BOLD, 10));
				cbborrowtime7.setModel(new DefaultComboBoxModel(new String[] {"选择借阅时长", "7天", "15天", "30天", "90天"}));
				cbborrowtime7.setBounds(390, 72, 88, 21);
				panel_3.add(cbborrowtime7);
				
				JButton btnupdate7 = new JButton();
				btnupdate7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!"".equals(tfborrowno7.getText())){
							if(!"选择借阅时长".equals(cbborrowtime7.getSelectedItem().toString())){
								String username=tfusername7.getText();
								int	userid=Integer.parseInt(tfuserid7.getText());
								int bookid=Integer.parseInt(tfbookid7.getText());
								String bookname=tfbookname7.getText();
								SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
								java.sql.Date borrowdate=null;
								try {
									borrowdate = new java.sql.Date(sdf.parse(tfborrowdate7.getText()).getTime());
									String borrowtime=cbborrowtime7.getSelectedItem().toString();
									java.sql.Date duereturndate = new java.sql.Date(sdf.parse(tfneedreturndate7.getText()).getTime());
									Borrow borrow=new Borrow(username,userid,bookid,bookname,borrowdate,borrowtime,duereturndate);
									if(!"".equals(tfreturndate7.getText())){
										java.sql.Date returndate = new java.sql.Date(sdf.parse(tfreturndate7.getText()).getTime());
										if((sdf.parse(tfreturndate7.getText()).getTime()-sdf.parse(tfborrowdate7.getText()).getTime())>=0)
										borrow.setReturnDate(returndate);
										else{
											JOptionPane.showMessageDialog(null, "归还日期不能早于借阅日期！");
											return;
										}
									}
									int borrowno=Integer.parseInt(tfborrowno7.getText());
									borrow.setBorrowno(borrowno);
									boolean success = new BorrowServiceImpl().updateBorrow(borrow);
									if(success){
										JOptionPane.showMessageDialog(null, "修改成功");
										String borrow1="否";
										new BookServiceImpl().updateBookStatus(new Book(bookid,bookname,borrow1));
									}
									else JOptionPane.showMessageDialog(null, "修改失败");
								} catch (ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}else{
								JOptionPane.showMessageDialog(null, "借阅时长应为具体时间");
							}
						}else{
							JOptionPane.showMessageDialog(null, "请点击上方表格中要要查询的内容后在进行修改！");
						}
					}
				});
				btnupdate7.setForeground(Color.RED);
				btnupdate7.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 18));
				btnupdate7.setBounds(518, 25, 72, 110);
				panel_3.add(btnupdate7);
				new SetButtonImage(btnupdate7, "images/btnupdate7png.png");
				btnupdate7.setContentAreaFilled(false);
				
				JLabel label111 = new JLabel("借阅编号");
				label111.setFont(new Font("宋体", Font.BOLD, 12));
				label111.setForeground(Color.RED);
				label111.setBounds(367, 113, 54, 27);
				panel_3.add(label111);
				
				tfborrowno7 = new JTextField();
				tfborrowno7.setEditable(false);
				tfborrowno7.setColumns(10);
				tfborrowno7.setBounds(420, 116, 88, 24);
				panel_3.add(tfborrowno7);
				panel_6.setVisible(false);
				
		//------------------------------分隔符----------------------------------
		//事件处理
		//修改密码按钮
		btnupdatepwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logmsgpanel.setVisible(false);
				usermanpanel.setVisible(false);
				libmanage.setVisible(false);
				panel_6.setVisible(false);
				uppsdpanel.setVisible(true);
			}
		});
		
		//用户管理按钮
		btnusermanage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logmsgpanel.setVisible(false);
				uppsdpanel.setVisible(false);
				libmanage.setVisible(false);
				panel_6.setVisible(false);
				usermanpanel.setVisible(true);
			}
		});
		
		//图书管理按钮
		btnlibmanage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logmsgpanel.setVisible(false);
				uppsdpanel.setVisible(false);
				usermanpanel.setVisible(false);
				panel_6.setVisible(false);
				libmanage.setVisible(true);
			}
		});
		
		//查询借阅按钮
		btnselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logmsgpanel.setVisible(false);
				uppsdpanel.setVisible(false);
				usermanpanel.setVisible(false);
				libmanage.setVisible(false);
				panel_6.setVisible(true);
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
						boolean success=new ManagerServiceImpl().UpdateMpwd(new Manager(name1,newpwd));
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
		
		//查询按钮
		btnuserselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=tfuseraccount.getText();
				fillTable(new UserServiceImpl().selectUserByUserName(new User(username)));
			}
		});
		
		//点击表格功能
		jtusermsg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=jtusermsg.getSelectedRow();
				usersid.setText(""+jtusermsg.getValueAt(row, 0));
				useraccountupdate.setText(""+jtusermsg.getValueAt(row, 1));
				userpwdupdate.setText(""+jtusermsg.getValueAt(row, 2));
				
			}
		});
		
		//修改用户信息功能
		btnuserupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!"".equals(usersid.getText())&&!"".equals(useraccountupdate.getText())&&!"".equals(userpwdupdate.getText())){
					if(useraccountupdate.getText().length()>=2&&useraccountupdate.getText().length()<=4){
						if(userpwdupdate.getText().length()>=6&&userpwdupdate.getText().length()<=12){
							int userid=Integer.parseInt(usersid.getText());
							String username=useraccountupdate.getText();
							String userpwd=userpwdupdate.getText();
							boolean success=new UserServiceImpl().updateUser(new User(userid,username,userpwd));
							if(success)	JOptionPane.showMessageDialog(null, "修改成功！");
							else	JOptionPane.showMessageDialog(null, "修改失败！");
						}else{
							JOptionPane.showMessageDialog(null, "密码的长度应在6-12位");
						}
					}else{
						JOptionPane.showMessageDialog(null, "账号的长度应为2-4位");
					}
				}else{
					JOptionPane.showMessageDialog(null, "请将内容输入完整，或点击上方表格获取需要修改的用户信息！");
				}
				
			}
		});
		
		//删除用户信息功能
		btnuserdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!"".equals(usersid.getText())&&!"".equals(useraccountupdate.getText())&&!"".equals(userpwdupdate.getText())){
					int userid=Integer.parseInt(usersid.getText());
					String username=useraccountupdate.getText();
					String userpwd=userpwdupdate.getText();
					boolean success=new UserServiceImpl().deleteUser(new User(userid,username,userpwd));
					if(success)	JOptionPane.showMessageDialog(null, "删除成功！");
					else	JOptionPane.showMessageDialog(null, "删除失败！");
				}else{
					JOptionPane.showMessageDialog(null, "请将内容输入完整，或点击上方表格获取需要删除的用户信息！");
				}
			}
		});
		
		//添加图书按钮功能
		addbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddBookFrm();
			}
		});
		
		//图书资料管理按钮功能
		bookinfomanage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BKInfoManageFrm();
			}
		});
		new Thread(this).start();
	}
	
	//填充表格功能
	public void fillTable(Vector<User> vector){
		DefaultTableModel dtm=(DefaultTableModel) jtusermsg.getModel();
		dtm.setRowCount(0);
		for(User user:vector)
			dtm.addRow(new Object[]{user.getUserid(),user.getUsername(),user.getUserpwd()});
	}
	
	//填充借阅表表格功能
	public void fillBorrowTable(Vector<Borrow> vector){
		DefaultTableModel dtm=(DefaultTableModel) jtborrowmsg6.getModel();
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
