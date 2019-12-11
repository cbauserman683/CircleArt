import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setVisible(true);
		
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(frame);
		File file = fc.getSelectedFile();
		
		Picture pic = new Picture(file);

		
		Manager manager = new Manager(pic);
		
		manager.manage();
		
		System.out.println("finish managing");
		//JPanel panel = manager.drawImage();
		
		//frame.add(panel);
		frame.add(manager.drawImage());
		frame.repaint();
		
		
	}

}
