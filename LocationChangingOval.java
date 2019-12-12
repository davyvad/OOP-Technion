package homework1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * A LocationChangingOval is a Oval that can change its location using its step()
 * method. A LocationChangingRectangle has a velocity property that determines the speed
 * of location changing.
 * Thus, a typical LocationChangingOval consists of the following set of
 * properties: {location, color, size, velocity}
 */
public class LocationChangingOval extends LocationChangingShape{

	// Abstraction Function:
	//			represents an Oval which has a location, a color, a size (a bounding rectangle) and has X and Y velocities : velocityX, velocityY
	//			this class objects can change location
	
	// Representation Invariant
	// location != null , color != null, horizontal and vertical velocity are integers
	// 
	public static void main(String[] args) {
		Point p = new Point(2, 3);
		Color c = new Color(2,3,1);
		LocationChangingShape sh = new LocationChangingOval(p,c);
		Point pp = sh.getLocation();
		Color cc = sh.getColor();
		System.out.println("point , color are : " + pp.toString() + cc.toString());
		System.out.println("Dimension : " + sh.getBounds().toString());
	}
	
	public LocationChangingOval(Point location, Color color) {
		super(location, color);
		
	}
	
	/**
   * @modifies g
   * @effects Draws this onto g.
   */
  public void draw(Graphics g) {
  	g = (Graphics2D) g;
  	setColor(this.getColor());
  	Rectangle dim = getBounds();
  	g.fillOval(dim.x, dim.y, dim.width, dim.height);
  	
  }

}