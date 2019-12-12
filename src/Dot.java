import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Dot extends Component {
	
	private Point center;
	private Color color;
	private int radius;
	private int maxSize;
	
	
	public Dot() {
	
		this.center = new Point(0,0);
		this.color = Color.BLACK;
		this.radius = 10;
		this.maxSize = 15;
		
	}
	
	public Dot(int x, int y, int rad, Color col) {
		this.color = col;
		
		this.radius = rad;
		
		//calculate center
		this.center = new Point();
		this.center.x = x - (this.radius/2);
		this.center.y = y - (this.radius/2);
		
		this.maxSize = (int) (Math.random() * 10);
	}
	
	public Point getCenter() {
		return this.center;
	}
	
	public void setCenter(Point newCenter) {
		this.center = newCenter;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void setColor(Color newColor) {
		this.color = newColor;
	}
	
	public void growRadius() {
		if(this.radius < 10) {
			this.radius++;
		}
	}
	
	public int getRadius() {
		return this.radius;
	}
	
	public int getDiameter() {
		return 2*this.radius;
	}
	
	public Shape getShape() {
		return new Ellipse2D.Double(this.center.x, this.center.y, this.getDiameter(), this.getDiameter());
	}
	
	public String toString() {
		return "Radius: " + this.radius + " Color: " + this.color;
	}
	

}
