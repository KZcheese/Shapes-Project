/*
 * Represents a digital screen of pixels in text form. The points on the screen on represented by a coordinate grid with X growing to the right, and Y growing downward.
 * Written by Kevin Zhan
 */
public class Screen {
	/*
	 * The screen is stored as a 2 dimensional array of characters. Empty pixels
	 * are represented as null. The character used to draw the border of the
	 * screen is stored as the char border.
	 */
	private char[][] screen;
	private char border;

	/*
	 * Creates a screen with a width of x, and a height of y, and a border of c.
	 */
	public Screen(int x, int y, char c) {
		screen = new char[y][x];
		border = c;
	}

	/*
	 * Prints out the screen in text form. Empty pixels are represented with the
	 * ' ' (space) character, and the border is represented by the border
	 * character.
	 */
	public void draw() {
		String out = "";
		String line = "";
		String borderSpaced = border + " ";
		for (int i = 0; i < screen[0].length + 2; i++)
			line += borderSpaced;
		out += line + "\n";
		for (char[] row : screen)
			out += borderSpaced + drawRow(row) + borderSpaced + "\n";
		out += line;
		System.out.println(out);
	}

	/*
	 * Prints out the inputed char array in a row. Used by the draw() method.
	 */
	private String drawRow(char[] in) {
		String out = "";
		for (char c : in) {
			if ((int) c == 0)
				out += "  ";
			else
				out += c + " ";
		}
		return out;
	}

	/*
	 * Empties the screen.
	 */
	public void clearScreen() {
		screen = new char[screen.length][screen[0].length];
	}

	/*
	 * Changes the value at (x,y) of the screen to character c. Used to draw
	 * things onto the screen. Precondition: The character cannot be tab or
	 * null.
	 */
	public void paintAt(int x, int y, char c) {
		screen[y][x] = c;
	}

	/*
	 * Checks to see if the coordinate (x,y) is a valid coordinate on the screen
	 * and returns true if it is, false if it isn't.
	 */
	public boolean isValid(int x, int y) {
		if (x < 0 || x > screen[0].length - 1 || y < 0 || y > screen.length - 1)
			return false;
		return true;
	}

	/*
	 * Getters and setters for the border character.
	 */
	public void setBorder(char c) {
		border = c;
	}

	public char getBorder() {
		return border;
	}

	/*
	 * Returns width and height of the screen respectively.
	 */
	public int getX() {
		return screen[0].length;
	}

	public int getY() {
		return screen.length;
	}

	/*
	 * Test code.
	 */
	public static void main(String[] args) {
		Screen test = new Screen(5, 10, '#');
		test.draw();
		test.paintAt(3, 3, 'x');
		test.draw();
		test.paintAt(0, 0, 'x');
		test.draw();
	}

}
