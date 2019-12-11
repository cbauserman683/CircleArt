import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame();
		
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(frame);
		File file = fc.getSelectedFile();
		
		Picture pic = new Picture(file);

		
		
		
		
	}

}
