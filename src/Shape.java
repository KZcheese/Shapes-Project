/*
 * An abstract class that contains a paintable shape for the Screen class.
 * Written by Kevin Zhan
 */
public abstract class Shape {
	/*
	 * Stores the character that the shape will be painted with when the paintOn
	 * method is called.
	 */
	private char paintChar;

	/*
	 * Accepts a character that is stored as paintChar.
	 * Precondition: The paint character cannot be tab or null.
	 */
	public Shape(char c) {
		paintChar = c;
	}

	/*
	 * Getters and setters for the paintChar.
	 */
	public char getPaintChar() {
		return paintChar;
	}

	public void setPaintChar(char paintChar) {
		this.paintChar = paintChar;
	}

	/*
	 * Paints the shape on screen S at the coordinates X and Y using paintChar.
	 */
	public abstract void paintOn(Screen s, int x, int y);

	/*
	 * Paints the shape at the coordinates (0,0).
	 */
	public void paintOn(Screen s) {
		paintOn(s, 0, 0);
	}
}
