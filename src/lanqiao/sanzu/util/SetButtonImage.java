package lanqiao.sanzu.util;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SetButtonImage extends JFrame{
	public SetButtonImage(JButton jButton,String path) {
		// TODO Auto-generated constructor stub
		jButton.setIcon(new ImageIcon(path));
	}
}
