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
		this.radius = 1;
		
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
		
		//set the color
		g.setColor(this.color);
		
		//calculate center
		int x = this.center.x - (this.radius/2);
		int y = this.center.y - (this.radius/2);
		
		//draw oval
		g.fillOval(x, y, this.radius, this.radius);
		
	}
	

}
