package lanqiao.sanzu.util;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SetLabelImage extends JFrame{
	public SetLabelImage(JLabel jlabel,String path) {
		jlabel.setIcon(new ImageIcon(path));
		
	}
}
