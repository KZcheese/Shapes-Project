/*
 * A class that provides an interface through the console for users to access and control the screen class and all of its respective shape classes.
 * Written by Kevin Zhan
 */
import java.util.Scanner;

public class Interactive {
	/*
	 * Scanner s is used to recieve input from the console.
	 * Screen screen is the screen the program paints on a displays in the terminal.
	 */
	private static Scanner s = new Scanner(System.in);
	private static Screen screen;

	/*
	 * Handles the main menu of the interface. This is where the user chooses what type of action they would like to initiate.
	 * From here, the user can:
	 * Press S to make a new Screen
	 * Press D to draw the Screen
	 * Press V to make a new Vertical Line
	 * Press H to make a new Horizontal Line
	 * Press T to make a new Text Line
	 * Press B to make a new Box
	 * Press F to make a new Frame
	 * Press L to make a new Linear Equation
	 * Press C to clear the screen
	 * Press Q to quit
	 * If the user does not make any of the inputs mentioned above, they will be asked to try again.
	 */
	public static void mainMenu() {
		System.out
				.println("Welcome to my drawing application.\nA default 15 x 15 size screen has been created with the border character of '#'. You can change this by making a new screen.");
		screen = new Screen(15, 15, '#');
		while (true) {
			System.out.println();
			System.out
					.println("Press S to make a new Screen\nPress D to draw the Screen\nPress V to make a new Vertical Line\nPress H to make a new Horizontal Line\nPress T to make a new Text Line\nPress B to make a new Box\nPress F to make a new Frame\nPress L to make a new Linear Equation\nPress C to clear the screen\nPress Q to quit");
			String input = s.nextLine();
			if (input.equalsIgnoreCase("s")) {
				boolean goOn = true;
				System.out
						.println("This will delete all of your existing shapes. Are you sure you want to continue? (Enter y for yes, n for no)");
				goOn = yesPrompt();
				if (goOn)
					makeScreen();
			} else if (input.equalsIgnoreCase("d"))
				screen.draw();
			else if (input.equalsIgnoreCase("v") || input.equalsIgnoreCase("h")) {
				boolean isVert = false;
				if (input.equalsIgnoreCase("v"))
					isVert = true;
				Line l = makeLine(isVert);
				paintShape("line", l);
			} else if (input.equalsIgnoreCase("t")) {
				TextLine t = new TextLine(stringPrompt());
				paintShape("text line", t);
			} else if (input.equalsIgnoreCase("b")
					|| input.equalsIgnoreCase("f")) {
				boolean isFilled = false;
				if (input.equalsIgnoreCase("b"))
					isFilled = true;
				Rectangle r = makeRectangle(isFilled);
				paintShape("rectangle", r);
			} else if (input.equalsIgnoreCase("l")) {
				LinearEquation l = makeEquation();
				l.paintOn(screen);
			} else if (input.equalsIgnoreCase("c"))
				screen.clearScreen();
			else if (input.equalsIgnoreCase("q"))
				System.exit(0);
			else
				System.out
						.println("That is not a valid input. Please try again.");
		}
	}

	/*
	 * Makes Screen screen based on user input.
	 */
	public static void makeScreen() {
		int x = limitedIntPrompt("width of the screen");
		int y = limitedIntPrompt("height of the screen");
		char c = charPrompt("border of the screen");
		screen = new Screen(x, y, c);
	}

	/*
	 * Makes a line based on user input. This line is vertical if isVert is true, and horizontal is isVert is false.
	 * The state of boolean isVert is decided by the user in the mainMenu() method.
	 */
	public static Line makeLine(boolean isVert) {
		int l = posIntPrompt("length of the line");
		char c = charPrompt("line");
		if (isVert)
			return new VLine(c, l);
		return new HLine(c, l);
	}

	/*
	 * Makes a rectangle based on user input. This line is a box if isFilled is true, and a frame if isFilled is false.
	 * The state of boolean isFilled is decided by the user in the mainMenu() method.
	 */
	public static Rectangle makeRectangle(boolean isFilled) {
		int w = posIntPrompt("width of the rectangle");
		int h = posIntPrompt("height of the rectangle");
		char c = charPrompt("rectangle");
		if (isFilled)
			return new Box(c, w, h);
		return new Frame(c, w, h);
	}

	/*
	 * Makes linear equation based on user input. If both a and b are zero, the user is asked to input a different a and/or b.
	 */
	public static LinearEquation makeEquation() {
		System.out
				.println("The linear equations used in this program are represented in the form ax + by = c.");
		double a = doublePrompt("'a'");
		double b = doublePrompt("'b'");
		while (a == 0 && b == 0) {
			System.out
					.println("You cannot make both 'a' and 'b' equal to 0. Please input a and b again.");
			a = doublePrompt("'a'");
			b = doublePrompt("'b'");
		}
		double c = doublePrompt("'c'");
		char ch = charPrompt("line");
		return new LinearEquation(ch, a, b, c);
	}

	/*
	 * Paints shape sh at coordinates inputed by the user. String name is used to indicate to the user what they are painting.
	 */
	public static void paintShape(String name, Shape sh) {
		int x = intPrompt("X coordinate you like to paint this " + name + " at");
		int y = intPrompt("Y coordinate you like to paint this " + name + " at");
		sh.paintOn(screen, x, y);
	}

	/*
	 * Prompts the user for an integer. String name is used to indicate to the user what they are entering an integer for.
	 */
	public static int intPrompt(String name) {
		System.out.println("Please enter an integer for the " + name + ".");
		int num;
		while (true) {
			if (s.hasNextInt()) {
				num = s.nextInt();
				s.nextLine();
				return num;
			}
			System.out.println("That is not a valid input. Please try again.");
			s.nextLine();
		}
	}

	/*
	 * Prompts the user for a positive integer. String name is used to indicate to the user what they are entering an integer for.
	 */
	public static int posIntPrompt(String name) {
		System.out.println("Please enter positive integer for the " + name
				+ ".");
		int num;
		while (true) {
			if (s.hasNextInt()) {
				num = s.nextInt();
				if (num > 0) {
					s.nextLine();
					return num;
				}
			}
			System.out.println("That is not a valid input. Please try again.");
			s.nextLine();
		}
	}

	/*
	 * Prompts the user for a positive integer from 1 to 100. String name is used to indicate to the user what they are entering an integer for.
	 */
	public static int limitedIntPrompt(String name) {
		System.out.println("Please enter an integer from 1 to 100 for the "
				+ name + ".");
		int num;
		while (true) {
			if (s.hasNextInt()) {
				num = s.nextInt();
				if (num > 0 && num < 101) {
					s.nextLine();
					return num;
				}
			}
			System.out.println("That is not a valid input. Please try again.");
			s.nextLine();
		}
	}

	/*
	 * Prompts the user for a double. String name is used to indicate to the user what they are entering a double for.
	 */
	public static double doublePrompt(String name) {
		System.out.println("Please enter a number (double) for " + name + ".");
		while (true) {
			if (s.hasNextDouble()) {
				double d = s.nextDouble();
				s.nextLine();
				return d;
			}
			System.out.println("That is not a valid input. Please try again.");
			s.nextLine();
		}
	}

	/*
	 * Prompts the user for a char. String name is used to indicate to the user what they are entering a char for.
	 */
	public static char charPrompt(String name) {
		System.out
				.println("Please enter a character you would like to use to paint the "
						+ name
						+ ". If multiple characters are entered, only the first one will be used. Please refrain from using the tab character");
		String input;
		while (true) {
			input = s.nextLine();
			if (input.length() > 0 && input.charAt(0) != '\t')
				return input.charAt(0);
			System.out.println("That is not a valid input. Please try again.");
		}
	}

	/*
	 * Prompts the user for a String. Since this method is only used in one specific instance, a String name parameter is not necessary.
	 */
	public static String stringPrompt() {
		System.out
				.println("Please enter the text you would like to paint. Please do not use the tab button.");
		String text;
		while (true) {
			text = s.nextLine();
			if (text.length() > 0 && !text.contains("\t"))
				return text;
			System.out.println("That is not a valid input. Please try again.");
		}
	}

	/*
	 * Prompts the user for a yes or no represented by the user input of y or n respectively. Since this method is only used in one specific instance, a String name parameter is not necessary.
	 */
	public static Boolean yesPrompt() {
		while (true) {
			String yOrN = s.nextLine();
			if (yOrN.equalsIgnoreCase("y"))
				return true;
			else if (yOrN.equalsIgnoreCase("n"))
				return false;
			else
				System.out
						.println("That is not a valid input. Please try again.");
		}
	}

	/*
	 * Runs the mainMenu() method at the start of the program.
	 */
	public static void main(String[] args) {
		mainMenu();
	}

}
