package lanqiao.sanzu.util;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class SetJFrameLocation extends JFrame{
	public SetJFrameLocation(JFrame frame) {
		// TODO Auto-generated constructor stub
		int height2 = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int width2 = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		frame.setLocation((width2-frame.getWidth())/2, (height2-frame.getHeight())/2);
		
	}
}
