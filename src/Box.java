/*
 * A class derived from the rectangle class that holds a filled rectangle with a set length and height.
 * Written by Kevin Zhan
 */
public class Box extends Rectangle {

	/*
	 * Delegates completely to the rectangle class constructor.
	 */
	public Box(char c, int length, int height) {
		super(c, length, height);
	}

	/*
	 * Paints the box toward the right and downward on screen s starting at the coordinate (x,y).
	 * If a part of the box is off the screen, that part is not painted.
	 */
	@Override
	public void paintOn(Screen s, int x, int y) {
		int height = this.getHeight();
		while (height-- > 0)
			this.paintLine(s, x, y++);
	}

	/*
	 * Paints one row of the box. Used by the paintOn method.
	 */
	private void paintLine(Screen s, int x, int y) {
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
		Box b = new Box('x', 6, 6);
		b.paintOn(s, 1, 1);
		s.draw();
	}

}
