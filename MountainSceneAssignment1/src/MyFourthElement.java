import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class

public class MyFourthElement {
	// Your instance fields go here
	// location of the snow man
	private int x, y;
	// scale of the drawing
	private double scale;
	// graphics window
	private GWindow window;

	/**
	 * Create a snow man in at location (x,y) in the GWindow window.
	 * 
	 * @param x the x coordinate of the center of the head of steve from minecraft
	 * @param y the y coordinate of the center of the head of steve from minecraft
	 * @scale the factor that multiplies all default dimensions for steve from minecraft
	 *        (e.g. if the default head radius is 20, the head radius of this snow
	 *        man is scale * 20)
	 * @window the graphics window is the Face of steve from minecraft belongs to
	 */
	public MyFourthElement(int x, int y, double scale, GWindow window) {
		// initialize the instance fields
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.window = window;
		// Put the details of the drawing in a private method

		steveMinecraft();
	}

	/** Draw in the graphics window a steve Face of Minecraft (x,y) */

	private void steveMinecraft() {
		Color LIGHT_BROWN = new Color(105, 70, 34);
		Color DARK_SALMON = new Color(169, 125, 100);
		Color DARK_BROWN = new Color(78, 39, 0);
		Color MORE_LIGHT_BROWN = new Color(193, 138, 96);

		int elementRadius = (int) (20 * scale);
		// The top part of steve, head and hair
		Rectangle steveHair = new Rectangle(x + (int) (10 * elementRadius), y + (int) (30 * elementRadius),
				(int) (6 * elementRadius), (int) (1.2 * elementRadius), Color.BLACK, true);
		Rectangle steveHead = new Rectangle(x + (int) (10 * elementRadius), y + (int) (30 * elementRadius),
				(int) (6 * elementRadius), (int) (5 * elementRadius), MORE_LIGHT_BROWN, true);
		// The left eye of steve
		Rectangle steveLeftEye = new Rectangle(x + (int) (11 * elementRadius), y + (int) (31.4 * elementRadius),
				(int) (1.4 * elementRadius), (int) (1 * elementRadius), Color.WHITE, true);
		Rectangle steveLeftEyePupil = new Rectangle(x + (int) (11.7 * elementRadius), y + (int) (31.4 * elementRadius),
				(int) (0.8 * elementRadius), (int) (1 * elementRadius), Color.BLUE, true);
		// The right eye of steve
		Rectangle steveRightEye = new Rectangle(x + (int) (13.7 * elementRadius), y + (int) (31.4 * elementRadius),
				(int) (1.4 * elementRadius), (int) (1 * elementRadius), Color.WHITE, true);
		Rectangle steveRightEyePupil = new Rectangle(x + (int) (13.7 * elementRadius), y + (int) (31.4 * elementRadius),
				(int) (0.8 * elementRadius), (int) (1 * elementRadius), Color.BLUE, true);
		// The nose of steve
		Rectangle steveNose = new Rectangle(x + (int) (12.4 * elementRadius), y + (int) (32.4 * elementRadius),
				(int) (1.4 * elementRadius), (int) (1 * elementRadius), LIGHT_BROWN, true);
		// The mouth of steve
		Rectangle steveMouth = new Rectangle(x + (int) (12.4 * elementRadius), y + (int) (33.4 * elementRadius),
				(int) (1.4 * elementRadius), (int) (1 * elementRadius), DARK_SALMON, true);
		// The mustache of steve
		Rectangle steveMustache = new Rectangle(x + (int) (11.7 * elementRadius), y + (int) (33.2 * elementRadius),
				(int) (2.8 * elementRadius), (int) (1.7 * elementRadius), DARK_BROWN, true);
		steveMustache.moveBy(0, +(int)(2));

		window.add(steveHead);
		window.add(steveHair);
		window.add(steveLeftEye);
		window.add(steveLeftEyePupil);
		window.add(steveRightEye);
		window.add(steveRightEyePupil);
		window.add(steveNose);
		window.add(steveMustache);
		window.add(steveMouth);

	}
}
