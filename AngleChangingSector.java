package homework1;

import java.awt.*;
import java.util.Random;

import org.w3c.dom.css.Rect;

/**
 * A LocationChaningShape is a Shape that can change its location using its step()
 * method. A LocationChaningShape has a velocity property that determines the speed
 * of location changing.
 * Thus, a typical LocationChaningShape consists of the following set of
 * properties: {location, color, shape, size, velocity}
 */
public class AngleChangingSector extends Shape implements Animatable {
	
	private int initialAngle;
	private int sectorAngle;
	private Rectangle boundRec_;
	
	private static final int DEFAULT_WIDTH = 30;
	private static final int DEFAULT_HEIGHT = 30;

	// TODO: Write Abstraction Function:
	//			represents a Shape which has a location, a color, a size (a bounding rectangle), a shape
	//			and has X and Y velocities : velocityX, velocityY
	//			this class objects can change location
	
	// TODO: Write Representation Invariant
	// location != null , color != null, horizontal and vertical velocity are integers
	// 
	
	/**
	 * @requires none
	 * @effects Initializes this with a a given location and color. Each
	 *          of the horizontal and vertical velocities of the new
	 *          object is set to a random integral value i such that
	 *          -5 <= i <= 5 and i != 0
	 * @modifies this
	 */
	public AngleChangingSector(Point location, Color color, int initialAngle, int sectorAngle) {
    // TODO: Implement this constructor
		super(location, color);
		if(location == null || color == null) {
			throw new IllegalArgumentException("location or color == null");
		}
		
		this.initialAngle = initialAngle;
		this.sectorAngle = sectorAngle; 
		//Set shape dimension:
		boundRec_ = new Rectangle(location.x , location.y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		}

    public void draw(Graphics g) {
    	g = (Graphics2D) g;
    	setColor(this.getColor());
    	g.fillArc(boundRec_.x, boundRec_.y, boundRec_.width, boundRec_.height, initialAngle, sectorAngle);
    }

       
    /**
     * @modifies this
     * @effects Resizes this so that its bounding rectangle has the specified
     * 			dimension.
     * 			If this cannot be resized to the specified dimension =>
     * 			this is not modified, throws ImpossibleSizeException
     * 			(the exception suggests an alternative dimension that is
     * 			 supported by this).
     */
    public void setSize(Dimension dimension)
    	throws ImpossibleSizeException{
    	if(dimension.height <= 0 || dimension.width <= 0)
    		throw new ImpossibleSizeException(dimension.toString());
    	else {
    		boundRec_.height = dimension.height;
    		boundRec_.width = dimension.width;
    	}
    }

    
    /**
     * @return the bounding rectangle of this.
     */
    //public Rectangle getBounds() {

    public Rectangle getBounds() {
    	return new Rectangle(boundRec_.x, boundRec_.y, boundRec_.width, boundRec_.height);
    }
    
    public void step(Rectangle bound) {
    	this.initialAngle++;
    }
    
    private void checkRep() {
    	assert getColor() != null;
    	assert getLocation() != null;
    	assert boundRec_ !=null;
    }
    
}
