package game;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DisplayAnimation {
	private static ImageIcon icon;
	private static JLabel label;

	public DisplayAnimation(String name, String action) {
		if (!action.equals("running") && !action.equals("attacking") && !action.equals("standing")) {
			action = "standing";
		}
		icon = new ImageIcon("src/Sprites/" + name + "_" + action + ".gif");
		label = new JLabel(icon);
	}

	public static ImageIcon getIcon() {
		return icon;
	}

	public static JLabel getLabel() {
		return label;
	}

	public static void main(String[] args) {
		DisplayAnimation anim = new DisplayAnimation("acid", "attacking");
		JFrame f = new JFrame("Animation");
		f.getContentPane().add(label);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}
