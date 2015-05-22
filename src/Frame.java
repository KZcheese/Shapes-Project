/*
 * A class derived from the rectangle class that holds an empty rectangle with a set length and height.
 * Written by Kevin Zhan
 */
public class Frame extends Rectangle {

	/*
	 * Delegates completely to the rectangle class constructor.
	 */
	public Frame(char c, int length, int height) {
		super(c, length, height);
		// TODO Auto-generated constructor stub
	}

	/*
	 * Paints the frame toward the right and downward on screen s starting at the coordinate (x,y).
	 * If a part of the frame is off the screen, that part is not painted.
	 */
	@Override
	public void paintOn(Screen s, int x, int y) {
		int height = this.getHeight() - 1;
		this.paintLine(s, x, y);
		while (height-- > 0)
			this.paintBorderLine(s, x, ++y);
		this.paintLine(s, x, y);
	}

	/*
	 * Paints one empty row of the box. Used by the paintOn method to paint the body of the frame.
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
	 * Paints one filled row of the box. Used by the paintOn method to paints the top and bottom border of the frame.
	 */
	private void paintBorderLine(Screen s, int x, int y) {
		int length = this.getLength() - 2;
		if (s.isValid(x, y))
			s.paintAt(x++, y, this.getPaintChar());
		else
			x++;
		while (length-- > 0) {
			x++;
		}
		if (s.isValid(x, y))
			s.paintAt(x++, y, this.getPaintChar());
		else
			x++;
	}

	/*
	 * Test code.
	 */
	public static void main(String[] args) {
		Screen s = new Screen(10, 10, '#');
		Frame f = new Frame('x', 6, 6);
		f.paintOn(s, 1, 1);
		s.draw();
	}

}
