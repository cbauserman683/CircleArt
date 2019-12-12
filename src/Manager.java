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
	
	private final int MAX_FAILS = 1000000;
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
				//System.out.println(fails);
			} else {
				//get color from original image
				Color color = picture.get((int)randomX, (int)randomY);
				
				//reset fails
				fails = 0;
				
				//next add the new color to a dot
				Dot currPixel = new Dot((int)randomX, (int)randomY, 15, color);
				
				//add the dot to the array list
				dots.add(currPixel);
				
				this.usedPixel.add(currPoint);
			}
			
			
			//scan arraylist and increase each size 
			//IF it won't hit another
//			for(Dot dot: dots) {
//				dot.growRadius();
//				
//				//this grows area around the pixel, but not the best way possible
//				Point above = new Point(Math.max(0, dot.getCenter().x), Math.max(0, dot.getCenter().y-1));
//				Point below = new Point(Math.max(0, dot.getCenter().x), Math.max(0, dot.getCenter().y+1));
//				Point left  = new Point(Math.max(0, dot.getCenter().x-1), Math.max(0, dot.getCenter().y));
//				Point right = new Point(Math.max(0, dot.getCenter().x+1), Math.max(0, dot.getCenter().y));
//				
//				
//				this.usedPixel.add(above);
//				this.usedPixel.add(below);
//				this.usedPixel.add(left);
//				this.usedPixel.add(right);
//
//				
//				
//			}
			
			
			//if fails > 100 set finished to true
			if(fails > this.MAX_FAILS) {
				this.finished = true;
			}
			
		}
		
		
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Shape circle;
		
//		circle = new Dot().getShape();
//		g2.setColor(new Dot().getColor());
//		g2.draw(circle);
//		g2.fill(circle);
		
		
		
		for(Dot dot: this.dots) {
			circle = dot.getShape();
			g2.setColor(dot.getColor());
			g2.draw(circle);
			g2.fill(circle);
			
			System.out.println(dot.toString());
		}	
	}
}
