/*
 * An abstract class derived from the shape class that holds a line represented by a linear equation in standard form.
 * Written by Kevin Zhan
 */
public class LinearEquation extends Shape {
	/*
	 * a, b, and c, represent the letters a, b, and c in ax + by + c respectively
	 */
	private double a, b, c;

	/*
	 * Constructor receives a double for a, b, and c.
	 * The paint character is delegated to the shape class constructor.
	 * Precondition: Both a and b cannot by zero.
	 */
	public LinearEquation(char ch, double a, double b, double c) {
		super(ch);
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/*
	 * Paints the line on screen s.
	 * Parts of the line that are off screen are not painted.
	 */
	public void paintOn(Screen s) {
		int aInt = (int) Math.round(a);
		int bInt = (int) Math.round(b);
		if (a == 0) {
			if (b == 0)
				return;
			else if (s.isValid(0, bInt))
				for (int i = 0; i < s.getX(); i++)
					s.paintAt(i, bInt, super.getPaintChar());
		} else if (b == 0 && s.isValid(aInt, 0))
			for (int i = 0; i < s.getY(); i++)
				s.paintAt(aInt, i, super.getPaintChar());
		else {
			double slope = -a / b;
			double yInt = c / b;
			int x = 0, y = 0;
			if (Math.abs(slope) > 1)
				while (y < s.getY()) {
					x = (int) Math.round((y - yInt) / slope);
					if (s.isValid(x, y))
						s.paintAt(x, y, super.getPaintChar());
					y++;
				}
			else
				while (x < s.getX()) {
					y = (int) Math.round(slope * x + yInt);
					if (s.isValid(x, y))
						s.paintAt(x, y, super.getPaintChar());
					x++;
				}
		}
	}

	/*
	 * Delegates to the paintOn(Screen s) method and ignores input for x and y due to the nature of a linear equation.
	 */
	@Override
	public void paintOn(Screen s, int x, int y) {
		paintOn(s);
	}

	/*
	 * Test code.
	 */
	public static void main(String[] args) {
		Screen s = new Screen(15, 15, 'x');
		LinearEquation e = new LinearEquation('x', 2, 5, 25);
		e.paintOn(s);
		s.draw();
		System.out.println(e);
	}

}
