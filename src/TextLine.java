/*
 * An abstract class derived from the shape class that holds a string of text.
 * Written by Kevin Zhan
 */
public class TextLine extends Shape {
	/*
	 * The text is stored in a String object.
	 */
	String text;

	/*
	 * Receives a String that is used as the text for the text line.
	 * Sets the paintChar in the super constructor to the null character, as it is not used.
	 */
	public TextLine(String text) {
		super('\0');
		this.text = text;
	}

	/*
	 * Paints the text line toward the right on screen s starting at the coordinate (x,y).
	 * If a part of the line is off the screen, that part is not painted.
	 */
	public void paintOn(Screen s, int x, int y) {
		for (int i = 0; i < text.length(); i++, x++)
			if (s.isValid(x, y))
				s.paintAt(x, y, text.charAt(i));
	}

	/*
	 * Test code.
	 */
	public static void main(String[] args) {
		Screen s = new Screen(10, 10, '#');
		TextLine text = new TextLine("Derpherp");
		text.paintOn(s, 1, 1);
		s.draw();
	}
}
