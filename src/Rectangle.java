/*
 * An abstract class derived from the shape class that holds a rectangle with a set length and height.
 * Written by Kevin Zhan
 */
public abstract class Rectangle extends Shape {
	/*
	 * The length and height of the rectangle are stored as an integer length and height. 
	 * They are stored as integers because the screen class only supports integer coordinates.
	 */
	private int height;
	private int length;

	/*
	 * Receives a paint character, a length, and a height.
	 * The paint character is delegated to the shape class constructor.
	 * Precondition: Length and height must be positive.
	 */
	public Rectangle(char c, int length, int height) {
		super(c);
		this.height = height;
		this.length = length;
	}

	/*
	 * Getters and setters for length and height.
	 */
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
