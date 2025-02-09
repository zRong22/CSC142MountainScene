import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class

/**
 * <p>
 * Create a snow man with the animation of the arms and hat going up and down in
 * motion in a graphics window.
 * </p>
 * 
 * @author Zhuo Rong (Andy) Ruan Zhao
 */

public class SnowMan {

	// Your instance fields go here
	private int x;
	private int y;
	private GWindow window;
	private double scale;
	private Rectangle hat;
	private Rectangle hatAccesory1;
	private Rectangle hatAccesory2;
	private Line snowRight;
	private Line rightFinger;
	private Line rightBottomFinger;
	private Line snowLeft;
	private Line leftFinger;
	private Line leftBottomFinger;
	private boolean moveUp;
	private boolean armsAreUp;

	/**
	 * Creates a snow man in at location (x,y) in the GWindow window.
	 * 
	 * @param x      the x coordinate of the center of the head of the snow man
	 * @param y      the y coordinate of the center of the head of the snow man
	 * @param scale  the factor that multiplies all default dimensions for this snow
	 *               man (e.g. if the default head radius is 20, the head radius of
	 *               this snow man is scale * 20)
	 * @param window the graphics window this snow man belongs to
	 */
	public SnowMan(int x, int y, double scale, GWindow window) {
		// initialize the instance fields
		this.window = window;
		this.scale = scale;
		this.x = x;
		this.y = y;

		// Put the details of the drawing in a private method
		bodySnow();
		snowEye();
		noseSnow();
		mouthSnow();
		hatSnow();
		snowButtons();
		snowArms();
	}

	/** Draw in the graphics window a snow man at location (x,y) */
	// The hat of the snowman
	private void hatSnow() {
		int hatRadius = (int) (20 * scale);
		hat = new Rectangle(x - (int) (5.4 * hatRadius), y - (int) (0.9 * hatRadius), (int) (4 * hatRadius),
				(int) (0.4 * hatRadius), Color.BLACK, true);
		hatAccesory1 = new Rectangle(this.x - (int) (4.4 * hatRadius), this.y - (int) (3.8 * hatRadius),
				(int) (2 * hatRadius), (int) (3.2 * hatRadius), Color.BLACK, true);
		hatAccesory2 = new Rectangle(this.x - (int) (4.4 * hatRadius), this.y - (int) (2 * hatRadius),
				(int) (2 * hatRadius), (int) (0.4 * hatRadius), Color.RED, true);
		window.add(hat);
		window.add(hatAccesory1);
		window.add(hatAccesory2);
	}

	// The left and right eye of the snow man
	private void snowEye() {
		int leftEyeRadius = (int) (7 * scale);
		Oval leftEye = new Oval(x - (int) (90 * scale), y + (int) (4 * scale), 2 * leftEyeRadius, 2 * leftEyeRadius,
				Color.BLACK, true);
		int rightEyeRadius = (int) (7 * scale);
		Oval rightEye = new Oval(x - (int) (90 * scale), y + (int) (4 * scale), 2 * rightEyeRadius, 2 * rightEyeRadius,
				Color.BLACK, true);
		rightEye.moveBy((int) (30 * scale), 0);
		window.add(leftEye);
		window.add(rightEye);
	}

	// The nose of the snow man
	private void noseSnow() {
		int noseHeight = (int) (12 * scale);
		int noseWidth = (int) (12 * scale);
		Color darkOrange = new Color(255, 140, 0);
		Triangle nose = new Triangle(x - (int) (2 * noseWidth), y + noseHeight / 2, x + (int) (2 * noseWidth),
				y + (int) (noseHeight), x - (int) (2 * noseWidth), y - noseHeight, darkOrange, true);
		nose.moveBy(-(int) (52 * scale), (int) (20 * scale));
		window.add(nose);
	}

	// The mouth of the snow man (x,y) points
	private void mouthSnow() {
		int mouthRadius = (int) (20 * scale);
		Rectangle mouth = new Rectangle(this.x - (int) (2.1 * mouthRadius), this.y - (int) (2 * mouthRadius),
				(int) (3 * mouthRadius / 2), (int) (2 * mouthRadius / 4), Color.BLACK, true);
		mouth.moveBy((int) (-2 * mouthRadius), +(int) (3.6 * mouthRadius));
		window.add(mouth);
	}

	// The body of snow man
	private void bodySnow() {
		int headSnowRadius = (int) (35 * scale);
		Oval head = new Oval(x - (int) (3 * headSnowRadius), y + (int) -(0.5 * headSnowRadius), 2 * headSnowRadius,
				2 * headSnowRadius, Color.WHITE, true);
		window.add(head);
		Oval bodySnow = new Oval(x - 4 * headSnowRadius, (int) (y + 1.3 * headSnowRadius), 4 * headSnowRadius,
				4 * headSnowRadius, Color.WHITE, true);
		window.add(bodySnow);
	}

	// The buttons of the snow man
	private void snowButtons() {
		int buttonRadius = (int) (20 * scale);
		Oval button1 = new Oval(x - (int) (3.7 * buttonRadius), y + (int) (3.4 * buttonRadius),
				(int) (0.8 * buttonRadius), (int) (1.2 * buttonRadius), Color.BLACK, true);
		Oval button2 = new Oval(x - (int) (3.7 * buttonRadius), y + (int) (3.4 * buttonRadius),
				(int) (0.8 * buttonRadius), (int) (1.2 * buttonRadius), Color.BLACK, true);
		Oval button3 = new Oval(x - (int) (3.7 * buttonRadius), y + (int) (3.4 * buttonRadius),
				(int) (0.8 * buttonRadius), (int) (1.2 * buttonRadius), Color.BLACK, true);
		button2.moveBy(0, (int) (1.7 * buttonRadius));
		button3.moveBy(0, (int) (3.4 * buttonRadius));

		window.add(button1);
		window.add(button2);
		window.add(button3);
	}

	// Both the left,right and left, right snow man fingers and arms
	private void snowArms() {
		int rightRadius = (int) (15 * scale);
		snowRight = new Line(x - (int) (2 * rightRadius), y + (int) (5 * rightRadius), x + (int) (6 * rightRadius),
				y + (int) (5 * rightRadius));
		rightFinger = new Line(x + (int) (4.6 * rightRadius), y + (int) (5 * rightRadius),
				x + (int) (2.6 * rightRadius), y + (int) (3 * rightRadius));
		rightBottomFinger = new Line(x + (int) (4 * rightRadius), y + (int) (5 * rightRadius),
				x + (int) (6 * rightRadius), y + (int) (3 * rightRadius));
		rightBottomFinger.moveBy(2, -(int) (2));
		rightBottomFinger.moveBy(-(int) (19.7 * rightRadius), (int) (2.2 * rightRadius));
		rightFinger.moveBy(-(int) (18 * rightRadius), 0);
		snowLeft = new Line(x - (int) (2 * rightRadius), y + (int) (5 * rightRadius), x + (int) (6 * rightRadius),
				y + (int) (5 * rightRadius));
		snowLeft.moveBy(-(int) (13.8 * rightRadius), 0);
		leftFinger = new Line(x + (int) (4 * rightRadius), y + (int) (5 * rightRadius), x + (int) (6 * rightRadius),
				y + (int) (3 * rightRadius));
		leftBottomFinger = new Line(x + (int) (4 * rightRadius), y + (int) (5 * rightRadius),
				x + (int) (6 * rightRadius), y + (int) (7 * rightRadius));

		window.add(snowRight);
		window.add(leftFinger);
		window.add(snowLeft);
		window.add(rightFinger);
		window.add(leftBottomFinger);
		window.add(rightBottomFinger);
	}

	// The snow man arms and hat going up and down in motion in the (x,y)
	// coordinates
	public void moveArmsAndHat() {
		int factorScale = (int) (15 * scale); // Scale for the right and left arm snow man.
		int hatScale = (int) (2 * scale); // Scale for the hat snow man.
		double degrees = 30; // The arms of left and right of the snow man and the amount of bending in
								// degrees.

		if (armsAreUp) {
			snowRight.rotateAround(x - (int) (2 * factorScale), y + (int) (5 * factorScale), -degrees);
			rightFinger.rotateAround(x - (int) (7.8 * factorScale), y + (int) (5 * factorScale), degrees);
			rightBottomFinger.rotateAround(x - (int) (7.8 * factorScale), y + (int) (5 * factorScale), degrees);
			snowLeft.rotateAround(x - (int) (7.8 * factorScale), y + (int) (5 * factorScale), degrees);
			leftFinger.rotateAround(x - (int) (2 * factorScale), y + (int) (5 * factorScale), -degrees);
			leftBottomFinger.rotateAround(x - (int) (2 * factorScale), y + (int) (5 * factorScale), -degrees);
		} else {
			snowRight.rotateAround(x - (int) (2 * factorScale), y + (int) (5 * factorScale), degrees);
			rightFinger.rotateAround(x - (int) (7.8 * factorScale), y + (int) (5 * factorScale), -degrees);
			rightBottomFinger.rotateAround(x - (int) (7.8 * factorScale), y + (int) (5 * factorScale), -degrees);
			snowLeft.rotateAround(x - (int) (7.8 * factorScale), y + (int) (5 * factorScale), -degrees);
			leftFinger.rotateAround(x - (int) (2 * factorScale), y + (int) (5 * factorScale), degrees);
			leftBottomFinger.rotateAround(x - (int) (2 * factorScale), y + (int) (5 * factorScale), degrees);
		}
		armsAreUp = !armsAreUp;
		if (moveUp) {
			hat.moveBy(0, (int) (5.4 * hatScale));
			hatAccesory1.moveBy(0, (int) (5.4 * hatScale));
			hatAccesory2.moveBy(0, (int) (5.4 * hatScale));

		} else {
			hat.moveBy(0, -(int) (5.4 * hatScale));
			hatAccesory1.moveBy(0, -(int) (5.4 * hatScale));
			hatAccesory2.moveBy(0, -(int) (5.4 * hatScale));

		}
		moveUp = !moveUp;
	}
}
//		
//	}

//}
