package lanqiao.sanzu.util;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class SetIconImage extends JFrame {
	public SetIconImage(JFrame jFrame,String path) {
		// TODO Auto-generated constructor stub
		jFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(path));
	}
}
