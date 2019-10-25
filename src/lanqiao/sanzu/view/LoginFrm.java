package lanqiao.sanzu.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import lanqiao.sanzu.entity.Manager;
import lanqiao.sanzu.entity.User;
import lanqiao.sanzu.service.impl.ManagerServiceImpl;
import lanqiao.sanzu.service.impl.UserServiceImpl;
import lanqiao.sanzu.util.SetBackground;
import lanqiao.sanzu.util.SetIconImage;
import lanqiao.sanzu.util.SetJFrameLocation;
import lanqiao.sanzu.util.SetLabelImage;

public class LoginFrm extends JFrame {

	private JPanel contentPane;
	private JTextField tfname;
	private JPasswordField tfpassword;
	private String username;
	private String password;
	private JRadioButton rbuser;
	private JRadioButton rbmanager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
					org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					UIManager.put("RootPane.setupButtonVisible", false);
					LoginFrm frame = new LoginFrm();
					frame.setVisible(true);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
				
			}
		});
	}

	/**ad
	 * Create the frame.
	 */
	public LoginFrm() {
		setResizable(false);
		new SetIconImage(this, "images/library.jpg");
		setForeground(Color.RED);
		setFont(new Font("Dialog", Font.BOLD, 20));
		setTitle("BMS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//设置背景图片
		new SetBackground(this, "images/bg.jpg");
		new SetJFrameLocation(this);
		
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 20));
		lblNewLabel.setBounds(163, 107, 145, 50);
		contentPane.add(lblNewLabel);
		new SetLabelImage(lblNewLabel, "images/usernamelb.png");
		
		JLabel tfpwd = new JLabel();
		tfpwd.setForeground(Color.RED);
		tfpwd.setFont(new Font("楷体", Font.BOLD, 20));
		tfpwd.setBounds(163, 194, 145, 50);
		contentPane.add(tfpwd);
		new SetLabelImage(tfpwd, "images/userpwdlb.png");
		
		tfname = new JTextField();
		tfname.setFont(new Font("宋体", Font.PLAIN, 20));
		tfname.setBounds(318, 111, 232, 43);
		contentPane.add(tfname);
		tfname.setColumns(10);
		
		tfpassword = new JPasswordField();
		tfpassword.setFont(new Font("宋体", Font.PLAIN, 20));
		
		tfpassword.setBounds(318, 198, 232, 43);
		contentPane.add(tfpassword);
		
		
		JButton btnlogin = new JButton(new ImageIcon("images/login.png"));
//		btnlogin.setFocusPainted(false);
	    btnlogin.setContentAreaFilled(false);
		
		btnlogin.setBounds(178, 348, 113, 37);
		contentPane.add(btnlogin);
		
		JButton btnregister = new JButton(new ImageIcon("images/register.png"));
		btnregister.setContentAreaFilled(false);
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterFrm();
			}
		});
		btnregister.setBounds(388, 348, 113, 37);
		contentPane.add(btnregister);
		
		rbmanager = new JRadioButton("管理员");
		
		rbmanager.setForeground(Color.GREEN);
		rbmanager.setFont(new Font("宋体", Font.BOLD, 22));
		rbmanager.setSelected(true);
		rbmanager.setBounds(178, 277, 121, 43);
		rbmanager.setContentAreaFilled(false);
		contentPane.add(rbmanager);
		
		ButtonGroup btnGroup = new ButtonGroup();
		rbuser = new JRadioButton("普通用户");
	
		rbuser.setForeground(Color.GREEN);
		rbuser.setFont(new Font("宋体", Font.BOLD, 22));
		rbuser.setBounds(352, 277, 132, 43);
		rbuser.setContentAreaFilled(false);
		contentPane.add(rbuser);
		btnGroup.add(rbuser);
		btnGroup.add(rbmanager);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("images/font.png"));
		lblNewLabel_1.setBounds(511, 45, 320, 330);
		contentPane.add(lblNewLabel_1);
	
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		
		
		
		tfpassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					login();
				}
			}
		});
		rbuser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					login();
				}
			}
		});
		
		rbmanager.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					login();
				}
			}
		});
	}
	
	//登录方法
	public void login(){
		if(!"".equals(tfname.getText())&&!"".equals(tfpassword.getText()))
			if(rbmanager.isSelected()){
				username=tfname.getText();
				password=tfpassword.getText();
				boolean success=new ManagerServiceImpl().login(new Manager(username,password));
				if(success) {
					dispose();
					new ManagerMainFrm(username,password);
				}
				else
					JOptionPane.showMessageDialog(null, "账号或密码错误!");
			}else{
				username=tfname.getText();
				password=tfpassword.getText();
				boolean success=new UserServiceImpl().login(new User(username,password));
				if(success) {
					dispose();
					new UserMainFrm(username,password);
					
				}
				else
					JOptionPane.showMessageDialog(null, "账号或密码错误!");
			}else{
				JOptionPane.showMessageDialog(null, "请输入用户名或密码");
		}
	}
}
