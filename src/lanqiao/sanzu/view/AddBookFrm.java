package lanqiao.sanzu.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import lanqiao.sanzu.entity.Book;
import lanqiao.sanzu.service.impl.BookServiceImpl;
import lanqiao.sanzu.util.SetBackground;
import lanqiao.sanzu.util.SetIconImage;
import lanqiao.sanzu.util.SetJFrameLocation;
import lanqiao.sanzu.util.SetLabelImage;
import java.awt.Font;

public class AddBookFrm extends JFrame {

	private JPanel contentPane;
	private JTextField tfbookid;
	private JTextField tfbookname;
	private JTextField tfbookauthor;
	private JTextField tfbookstoagetime;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookFrm frame = new AddBookFrm();
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
	public AddBookFrm() {
		
		new SetIconImage(this, "images/addbookicon.png");
		setResizable(false);
		setVisible(true);
		setBounds(100, 100, 559, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		new SetBackground(this, "images/addbookbg.jpg");
		contentPane.setLayout(null);
		new SetJFrameLocation(this);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.WHITE, 2, true));
		panel.setBounds(10, 84, 523, 141);
		contentPane.add(panel);
		panel.setOpaque(false);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("图书编号：");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setBounds(26, 28, 65, 15);
		panel.add(lblNewLabel);
		
		tfbookid = new JTextField();
		tfbookid.setBounds(92, 25, 136, 21);
		panel.add(tfbookid);
		tfbookid.setColumns(10);
		
		JLabel label = new JLabel("图书书名：");
		label.setFont(new Font("宋体", Font.BOLD, 12));
		label.setForeground(Color.CYAN);
		label.setBounds(238, 31, 66, 15);
		panel.add(label);
		
		tfbookname = new JTextField();
		tfbookname.setBounds(314, 28, 184, 21);
		panel.add(tfbookname);
		tfbookname.setColumns(10);
		
		JLabel label_1 = new JLabel("图书作者：");
		label_1.setFont(new Font("宋体", Font.BOLD, 12));
		label_1.setForeground(Color.CYAN);
		label_1.setBounds(26, 86, 65, 21);
		panel.add(label_1);
		
		tfbookauthor = new JTextField();
		tfbookauthor.setBounds(92, 86, 136, 21);
		panel.add(tfbookauthor);
		tfbookauthor.setColumns(10);
		
		JLabel label_2 = new JLabel("入库时间：");
		label_2.setForeground(Color.CYAN);
		label_2.setFont(new Font("宋体", Font.BOLD, 12));
		label_2.setBounds(238, 86, 66, 18);
		panel.add(label_2);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		tfbookstoagetime = new JTextField(sdf.format(new java.util.Date()));
		tfbookstoagetime.setBounds(314, 86, 99, 21);
		panel.add(tfbookstoagetime);
		tfbookstoagetime.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("例如2019-07-17");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(423, 89, 90, 15);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.WHITE, 2, true));
		panel_1.setBounds(10, 235, 523, 40);
		contentPane.add(panel_1);
		panel_1.setOpaque(false);
		panel_1.setLayout(null);
		
		JButton btnadd = new JButton("添加");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!"".equals(tfbookname.getText())&&!"".equals(tfbookid.getText())&&!"".
						equals(tfbookauthor.getText())&&!"".equals(tfbookstoagetime.getText())){
					String bookname=tfbookname.getText();
					int bookid=Integer.parseInt(tfbookid.getText());
					String bookauthor=tfbookauthor.getText();
					String storagetime=tfbookstoagetime.getText();
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					String borrow="否";    //图书是否借出，默认为否
					Date date=null;
					try {
						date=new Date((sdf.parse(storagetime).getTime()));
						boolean success=new BookServiceImpl().addBook(new Book(bookname,bookid,bookauthor,date,borrow));
						if(success) JOptionPane.showMessageDialog(null, "图书添加成功");
						else JOptionPane.showMessageDialog(null, "图书添加失败");
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(null, "请将内容填写完整！");
				}
			}
		});
		btnadd.setBounds(115, 10, 93, 23);
		panel_1.add(btnadd);
		
		JButton btnclose = new JButton("关闭");
		btnclose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnclose.setBounds(305, 10, 93, 23);
		panel_1.add(btnclose);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.WHITE, 2, true));
		panel_2.setBounds(10, 10, 523, 69);
		panel_2.setOpaque(false);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		new SetLabelImage(lblNewLabel_2, "images/addbookjlb.png");
		lblNewLabel_2.setBounds(0, 0, 523, 69);
		panel_2.add(lblNewLabel_2);
	}
}
