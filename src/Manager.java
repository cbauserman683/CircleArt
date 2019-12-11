import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Manager {
	
	private boolean finished;
	private ArrayList<Dot> dots;
	private Picture picture;
	private int fails;
	private HashSet<Point> usedPixel;
	
	public Manager(Picture pic) {
		this.finished = false;
		this.dots = new ArrayList<Dot>();
		this.picture = pic;
		this.fails = 0;
		this.usedPixel = new HashSet<Point>();
	}
	
	
	public void manage() {
		double randomX;
		double randomY;
		boolean intersection = false;
		
		while(!finished) {
			//throw dart at image
			randomX = Math.random();
			randomX = randomX * picture.width();
			
			randomY = Math.random();
			randomY = randomY * picture.height();
			
			Point currPoint = new Point((int)randomX, (int)randomY);
			
			//check if there is a dot there
			if(usedPixel.contains(currPoint)) {
				intersection = true;
			}
			
			//if there is then increment fails
			//if there is not then get the color and set fails to 0
			
			if(intersection) {
				//there is already a dot
				fails++;
				System.out.println(fails);
			} else {
				Color color = picture.get((int)randomX, (int)randomY);
				
				fails = 0;
				
				//next add the new color to a dot
				Dot currPixel = new Dot((int)randomX, (int)randomY, 1, color);
				
				//add the dot to the array list
				dots.add(currPixel);
				
				this.usedPixel.add(currPoint);
			}
			
			
			//scan arraylist and increase each size 
			//IF it won't hit another
			for(Dot dot: dots) {
				if(dot.getDiameter() <= 16) {
					dot.growRadius();
				}
								
			}
			
			
			//if fails > 100 set finished to true
			if(fails > 100) {
				this.finished = true;
			}
			
		}
		
		
		
	}
	
	public JPanel drawImage() {

		
		JPanel panel = new JPanel();
		panel.setVisible(true);
		panel.setSize(499, 499);
		
		for(Dot dot: this.dots) {
			panel.add(dot);
			System.out.println(dot.toString());
		}
		
		return panel;
	}

}
