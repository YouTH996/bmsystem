package lanqiao.sanzu.util;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SetBackground extends JFrame{
	public SetBackground(JFrame jframe,String path) {
		//设置背景图片
		JLabel back=new JLabel(new ImageIcon(path));
		back.setBounds(0, 0, jframe.getWidth(), jframe.getHeight());
		jframe.getLayeredPane().setLayout(null);   //设置空布局
		jframe.getLayeredPane().add(back,new Integer(Integer.MIN_VALUE));
		((JPanel) jframe.getContentPane()).setOpaque(false);
	}
}
