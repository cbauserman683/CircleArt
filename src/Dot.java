import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;

public class Dot extends Component {
	
	private Point center;
	private Color color;
	private int radius;
	
	
	public Dot() {
	
		this.center = new Point(0,0);
		this.color = Color.BLACK;
		this.radius = 10;
		
	}
	
	public Dot(int x, int y, int rad, Color col) {
		this.color = col;
		
		this.radius = rad;
		
		//calculate center
		this.center = new Point();
		this.center.x = x - (this.radius/2);
		this.center.y = y - (this.radius/2);
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
		this.radius++;
	}
	
	public int getDiameter() {
		return 2*this.radius;
	}
	
	@Override
	public void paint(Graphics g) {
		
		System.out.println("paint circle");
		
		//set the color
		g.setColor(this.color);
		
		//draw oval
		g.fillOval(this.center.x, this.center.y, this.radius, this.radius);
		
		
	}
	
	public String toString() {
		return "Radius: " + this.radius + " Color: " + this.color;
	}
	

}
