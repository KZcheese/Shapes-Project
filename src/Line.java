/*
 * An abstract class derived from the shape class that holds a line with a set length.
 * Written by Kevin Zhan
 */
public abstract class Line extends Shape {
	/*
	 * The length of the line is stored as an integer length. 
	 * The length is stored as a integer because the screen class only supports integer coordinates.
	 */
	private int length;

	/*
	 * Receives a paint character and a length.
	 * The paint character is delegated to the shape class constructor.
	 * Precondition: Length must be positive.
	 */
	public Line(char c, int length) {
		super(c);
		this.length = length;
	}

	/*
	 * Getters and setters for the length.
	 */
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
