package homework1;

import java.awt.*;
import java.util.Random;


/**
 * A LocationChaningShape is a Shape that can change its location using its step()
 * method. A LocationChaningShape has a velocity property that determines the speed
 * of location changing.
 * Thus, a typical LocationChaningShape consists of the following set of
 * properties: {location, color, shape, size, velocity}
 */
public abstract class LocationChangingShape extends Shape implements Animatable {
	
	private int velocityX_;
	private int velocityY_;
	private Rectangle boundRec_;
	
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
	public LocationChangingShape(Point location, Color color) {
    // TODO: Implement this constructor
		super(location, color);
		
		if(location == null || color == null) {
			throw new IllegalArgumentException();
		}
		Random rdm = new Random();
		int[] arr = {0,0};
		do {
			arr = rdm.ints(2, -5, 6).toArray();
		} while (arr[0]== 0 || arr[1] ==0);
		velocityX_ = arr[0];
		velocityY_ = arr[1];
    
    }


    /**
     * @return the horizontal velocity of this.
     */
    public int getVelocityX() {
    	// TODO: Implement this method
    	return this.velocityX_;
    }


    /**
     * @return the vertical velocity of this.
     */
    public int getVelocityY() {
    	// TODO: Implement this method
    	return this.velocityY_;
    }


    /**
     * @modifies this
     * @effects Sets the horizontal velocity of this to velocityX and the
     * 			vertical velocity of this to velocityY.
     */
    public void setVelocity(int velocityX, int velocityY) {
    	// TODO: Implement this method
    	this.velocityX_ = velocityX;
    	this.velocityY_ = velocityY;
    	checkRep();
    	
    }


    /**
     * @modifies this
     * @effects Let p = location
     * 				v = (vx, vy) = velocity
     * 				r = the bounding rectangle of this
     *         	If (part of r is outside bound) or (r is within bound but
     *          adding v to p would bring part of r outside bound) {
     * 				If adding v to p would move r horizontally farther away
     * 				from the center of bound,
     * 					vx = -vx
     * 				If adding v to p would move r vertically farther away
     * 				from the center of bound,
     * 					vy = -vy
     *          }
     * 			p = p + v
     */
    public void step(Rectangle bound) {
    	// TODO: Implement this method
    	if(bound.isEmpty())
    		return;
    	
    	int vx = velocityX_, vy = velocityY_;
    	boolean witdhOutOfBound = boundRec_.x < bound.x || 					// Cond. if shape is out of boundaries
    			boundRec_.x+ boundRec_.width > bound.x+ bound.width ||
    			boundRec_.x +velocityX_ < bound.x || 											// And now, conditions if adding velocityX moves shape boundaries out of bound
    			boundRec_.x+ boundRec_.width + velocityX_> bound.x + bound.width;
    	boolean heightOutOfBound = boundRec_.y < bound.y || 
    			boundRec_.y+ boundRec_.height > bound.y+ bound.height ||
    			boundRec_.y +velocityY_ < bound.y || 											// And now, conditions if adding velocityX moves shape boundaries out of bound
    			boundRec_.y+ boundRec_.height + velocityY_> bound.y+ bound.height;
    	
    	if(heightOutOfBound || witdhOutOfBound) {
    		Point centerBound = new Point(bound.x + bound.width/2 , bound.y+ bound.height/2);
    		Point centerBoundRec = new Point(boundRec_.x + boundRec_.width/2 , boundRec_.y+ boundRec_.height/2);

    		if(centerBoundRec.x < centerBound.x && vx < 0)
    			vx = -vx;
    		if(centerBoundRec.y < centerBound.y && vy < 0)
    			vy = -vy;
    	}
    	this.setLocation(new Point(getLocation().x + vx , getLocation().y +vy));
    	
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
    
    private void checkRep() {
    	assert getColor() != null;
    	assert getLocation() != null;
    }
}
