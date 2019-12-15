import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.util.ArrayList;
import java.util.HashSet;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Manager extends JPanel{
	
	private final int MAX_DOTS = 100000;
	private boolean finished;
	private ArrayList<Dot> dots;
	private Picture picture;
	private int dotCount;
	private HashSet<Point> usedPixel;
	
	public Manager(Picture pic) {
		this.finished = false;
		this.dots = new ArrayList<Dot>();
		this.picture = pic;
		this.dotCount = 0;
		this.usedPixel = new HashSet<Point>();
	}
	
	
	public void manage() {
		double randomX;
		double randomY;
		
		while(!finished) {
			//throw dart at image
			randomX = Math.random();
			randomX = randomX * picture.width();
			
			randomY = Math.random();
			randomY = randomY * picture.height();
			
			//make a point
			Point currPoint = new Point((int)randomX, (int)randomY);
		
			//get color from original image
			Color color = picture.get((int)randomX, (int)randomY);
			
			//count the dots
			this.dotCount++;
			
			//next add the new color to a dot
			Dot currPixel = new Dot((int)randomX, (int)randomY, (int) (Math.random() *15), color);
			
			//add the dot to the array list
			dots.add(currPixel);
			
			this.usedPixel.add(currPoint);

			//if fails > max fails set finished to true
			if(this.dotCount > this.MAX_DOTS) {
				this.finished = true;
			}	
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Shape circle;
			
		for(Dot dot: this.dots) {
			circle = dot.getShape();
			g2.setColor(dot.getColor());
			g2.draw(circle);
			g2.fill(circle);
			
			System.out.println(dot.toString());
		}	
	}
}
