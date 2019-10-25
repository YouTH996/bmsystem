package lanqiao.sanzu.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import lanqiao.sanzu.entity.User;
import lanqiao.sanzu.service.impl.UserServiceImpl;
import lanqiao.sanzu.util.SetBackground;
import lanqiao.sanzu.util.SetIconImage;
import lanqiao.sanzu.util.SetJFrameLocation;
import java.awt.Font;

public class RegisterFrm extends JFrame {

	private JPanel contentPane;
	private JTextField tfname;
	private JTextField tfpwd;
	private JTextField tfpwd2;
	private JButton btnregister;
	private JButton btnback;
	private JTextField tfuserid;
	private JLabel lblNewLabel_1;
	private JLabel errortip1;
	private JLabel errortip3;
	private JLabel errortip2;

	/**
	 * Create the frame.
	 */
	public RegisterFrm() {
		setResizable(false);
		new SetIconImage(this, "images/registericon.png");
		setVisible(true);
		setTitle("注册");
		setBounds(100, 100, 682, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		new SetJFrameLocation(this);
		new SetBackground(this, "images/registerbg.jpg");
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.WHITE, 2, true));
		panel.setBounds(10, 10, 646, 398);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setOpaque(false);
		
		JLabel lblNewLabel = new JLabel("请输入账号");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(31, 127, 106, 26);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("请输入密码");
		label.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 16));
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(31, 187, 106, 26);
		panel.add(label);
		
		JLabel label_1 = new JLabel("确认密码");
		label_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 16));
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setBounds(42, 253, 106, 26);
		panel.add(label_1);
		
		tfname = new JTextField();
		tfname.setBounds(137, 124, 176, 33);
		panel.add(tfname);
		tfname.setColumns(10);
		
		tfpwd = new JTextField();
		tfpwd.setColumns(10);
		tfpwd.setBounds(137, 184, 176, 33);
		panel.add(tfpwd);
		
		tfpwd2 = new JTextField();
		tfpwd2.setColumns(10);
		tfpwd2.setBounds(137, 251, 176, 33);
		panel.add(tfpwd2);
		
		btnregister = new JButton("注册");
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!"".equals(tfuserid.getText())&&!"".equals(tfpwd2.getText())&&!"".equals(tfpwd.getText())){
					if(9==(tfuserid.getText().length())){
						if(tfname.getText().length()>=2&&tfname.getText().length()<=4){
							
						
							if(!(tfpwd.getText()).equals(tfpwd2.getText())){
								JOptionPane.showMessageDialog(null, "两次密码输入不一致，请重新输入！");
							}else{
								if(tfpwd2.getText().length()>=6 && tfpwd2.getText().length()<=12){
									int userid=Integer.parseInt(tfuserid.getText());
									String username=tfname.getText();
									String userpwd=tfpwd2.getText();
									Vector<User> selectAllUser = new UserServiceImpl().selectAllUser();
									if(selectAllUser.get(0).getUserid()==userid){
										errortip1.setText("已存在的学号!");
									}else{
										boolean success=new UserServiceImpl().registerUser(new User(userid,username,userpwd));
										if(success)	{
											JOptionPane.showMessageDialog(null, "注册成功！");
											dispose();
										}else{
											System.out.println();
											JOptionPane.showMessageDialog(null, "注册失败！");
										}
									}
								}else{
									errortip3.setText("密码的长度不小于6位不大于12位！");
								}
							}
						}else{
							errortip2.setText("姓名的长度在2-4位！");
						}
					}else{
						errortip1.setText("学号的长度为9位!");
					}
				}else{
					JOptionPane.showMessageDialog(null, "请将内容输入完整！");
				}
				
			}
		});
		btnregister.setBounds(98, 310, 111, 33);
		panel.add(btnregister);
		
		btnback = new JButton("返回");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnback.setBounds(332, 310, 111, 33);
		panel.add(btnback);
		
		JLabel label_2 = new JLabel("请输入学号");
		label_2.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 16));
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setBounds(31, 60, 106, 26);
		panel.add(label_2);
		
		tfuserid = new JTextField();
		tfuserid.setColumns(10);
		tfuserid.setBounds(137, 57, 176, 33);
		panel.add(tfuserid);
		
		lblNewLabel_1 = new JLabel("请输入9位学号，例如310240204000");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 12));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(359, 66, 240, 15);
		panel.add(lblNewLabel_1);
		
		JLabel label_3 = new JLabel("请输入姓名，例如“张三”");
		label_3.setFont(new Font("宋体", Font.BOLD, 12));
		label_3.setForeground(Color.RED);
		label_3.setBounds(359, 133, 202, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("密码的长度不小于6位，不大于12位");
		label_4.setFont(new Font("宋体", Font.BOLD, 12));
		label_4.setForeground(Color.RED);
		label_4.setBounds(359, 193, 240, 15);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("确认您的新密码");
		label_5.setFont(new Font("宋体", Font.BOLD, 12));
		label_5.setForeground(Color.RED);
		label_5.setBounds(359, 260, 202, 15);
		panel.add(label_5);
		
		errortip1 = new JLabel("");
		errortip1.setForeground(Color.RED);
		errortip1.setBounds(137, 102, 176, 15);
		panel.add(errortip1);
		
		errortip3 = new JLabel("");
		errortip3.setForeground(Color.RED);
		errortip3.setBounds(137, 223, 240, 15);
		panel.add(errortip3);
		
		errortip2 = new JLabel("");
		errortip2.setForeground(Color.RED);
		errortip2.setBounds(137, 163, 176, 15);
		panel.add(errortip2);
	}
}
