import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame();
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(frame);
		File file = fc.getSelectedFile();
		
		Picture pic = new Picture(file);
		
		frame.setSize(pic.width() + 100, pic.height() + 100);

		
		Manager manager = new Manager(pic);
		
		manager.manage();
	
		
		System.out.println("finish managing");
		
		//frame.add(panel);
		//panel.add(new Dot());
//		panel.add(new JLabel("label 1"));
//		panel.add(new Dot());
//		panel.add(new Dot(50, 50, 26, Color.BLUE));
//		panel.add(new JLabel("label 2"));
//		frame.add(panel);
		
		frame.add(manager);
		
		frame.setVisible(true);
		//frame.add(manager.drawImage());
		//frame.repaint();
		
	}

}
