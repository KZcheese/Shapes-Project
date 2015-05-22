/*
 * A class derived from the line class that holds a vertical line with a set length.
 * Written by Kevin Zhan
 */
public class HLine extends Line {

	/*
	 * Delegates completely to the line class constructor.
	 */
	public HLine(char c, int length) {
		super(c, length);
	}

	/*
	 * Paints the line toward the right on screen s starting at the coordinate (x,y).
	 * If a part of the line is off the screen, that part is not painted.
	 */
	@Override
	public void paintOn(Screen s, int x, int y) {
		int length = this.getLength();
		while (length-- > 0) {
			if (s.isValid(x, y))
				s.paintAt(x++, y, this.getPaintChar());
			else
				x++;
		}
	}

	/*
	 * Test code.
	 */
	public static void main(String[] args) {
		Screen s = new Screen(10, 10, '#');
		HLine line = new HLine('x', 5);
		line.paintOn(s, 6, 6);
		s.draw();
		line.paintOn(s);
		line.paintOn(s, -1, 2);
		s.draw();
	}
}
