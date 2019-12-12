package homework1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * A LocationChangingNumberedOval is a LocationChangingOval that can change its location using its step()
 * method. A LocationChangingNumberedOval has a velocity property that determines the speed
 * of location changing.
 * A LocationChangingNumberedOval objects also have an unique ID which is printed in the center of the oval when it's drawn
 * Thus, a typical LocationChangingNumberedOval consists of the following set of
 * properties: {location, color, size, velocity, id}
 */
public class LocationChangingNumberedOval extends LocationChangingOval {
	// Abstraction Function:
	//			represents an Oval which has a location, a color, a size (a bounding rectangle) and has X and Y velocities : velocityX, velocityY
	//			this class objects can change location
	
	// Representation Invariant
	// location != null , color != null, horizontal and vertical velocity are integers
	// 
  private static int number = 0;
  private int id;

	public static void main(String[] args) {
		Point p = new Point(2, 3);
		Color c = new Color(2,3,1);
		LocationChangingNumberedOval sh = new LocationChangingNumberedOval(p,c);
		Point pp = sh.getLocation();
		Color cc = sh.getColor();
		System.out.println("point , color are : " + pp.toString() + cc.toString());
		System.out.println("Dimension : " + sh.getBounds().toString());
		System.out.println("number , id : " + sh.id +" "+ sh.number);
		
		LocationChangingNumberedOval sh2 = new LocationChangingNumberedOval(p,c);
		System.out.println("number , id : " + sh2.id +" "+ sh2.number);


	}
	
	public LocationChangingNumberedOval(Point location, Color color) {
		super(location, color);
		id = number;
		number++;
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
  	g.drawString(((Integer)(id)).toString() , (dim.x +dim.width)/2, (dim.y + dim.height)/2);
  	
  }
  public int getId() {
  	return id;
  }
  
  public int getNumberOfOvals() {
  	return number;
  }

}