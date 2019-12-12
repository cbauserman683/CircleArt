import java.awt.Color;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame();
		frame.setSize(750, 750);
		
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(frame);
		File file = fc.getSelectedFile();
		
		Picture pic = new Picture(file);

		
		Manager manager = new Manager(pic);
		
		manager.manage();
		
		System.out.println("finish managing");
		JPanel panel = new JPanel();
		panel.setSize(500, 500);
		
		
		//frame.add(panel);
		//panel.add(new Dot());
//		panel.add(new JLabel("label 1"));
//		panel.add(new Dot());
//		panel.add(new Dot(50, 50, 26, Color.BLUE));
//		panel.add(new JLabel("label 2"));
//		frame.add(panel);
		
		frame.add(manager.drawImage());
		
		frame.setVisible(true);
		//frame.add(manager.drawImage());
		//frame.repaint();
		
		
	}

}
