import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class
import java.util.Random; //access to generate random numbers

/**
 * <p>
 * Create a Steve Minecraft face in animation going diagonal and in zig zag
 * formation in a graphics window.
 * </p>
 * 
 * @author Zhuo Rong (Andy) Ruan Zhao
 */
public class MyFourthElement {
	// Your instance fields go here
	// location of the snow man
	private int x, y;
	// scale of the drawing
	private double scale;
	// graphics window
	private GWindow window;
	private boolean steveHeight = true;
	private Rectangle steveMustache;
	private Rectangle steveMouth;
	private Rectangle steveNose;
	private Rectangle steveRightEyePupil;
	private Rectangle steveRightEye;
	private Rectangle steveLeftEyePupil;
	private Rectangle steveLeftEye;
	private Rectangle steveHead;
	private Rectangle steveHair;
	private boolean zig;

	/**
	 * Create a snow man in at location (x,y) in the GWindow window.
	 * 
	 * @param x the x coordinate of the center of the head of steve from minecraft
	 * @param y the y coordinate of the center of the head of steve from minecraft
	 * @scale the factor that multiplies all default dimensions for steve from
	 *        minecraft (e.g. if the default head radius is 20, the head radius of
	 *        this snow man is scale * 20)
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
		steveHair = new Rectangle(x + (int) (10 * elementRadius), y + (int) (30 * elementRadius),
				(int) (6 * elementRadius), (int) (1.2 * elementRadius), Color.BLACK, true);
		steveHead = new Rectangle(x + (int) (10 * elementRadius), y + (int) (30 * elementRadius),
				(int) (6 * elementRadius), (int) (5 * elementRadius), MORE_LIGHT_BROWN, true);
		// The left eye of steve
		steveLeftEye = new Rectangle(x + (int) (11 * elementRadius), y + (int) (31.4 * elementRadius),
				(int) (1.4 * elementRadius), (int) (1 * elementRadius), Color.WHITE, true);
		steveLeftEyePupil = new Rectangle(x + (int) (11.7 * elementRadius), y + (int) (31.4 * elementRadius),
				(int) (0.8 * elementRadius), (int) (1 * elementRadius), Color.BLUE, true);
		// The right eye of steve
		steveRightEye = new Rectangle(x + (int) (13.7 * elementRadius), y + (int) (31.4 * elementRadius),
				(int) (1.4 * elementRadius), (int) (1 * elementRadius), Color.WHITE, true);
		steveRightEyePupil = new Rectangle(x + (int) (13.7 * elementRadius), y + (int) (31.4 * elementRadius),
				(int) (0.8 * elementRadius), (int) (1 * elementRadius), Color.BLUE, true);
		// The nose of steve
		steveNose = new Rectangle(x + (int) (12.4 * elementRadius), y + (int) (32.4 * elementRadius),
				(int) (1.4 * elementRadius), (int) (1 * elementRadius), LIGHT_BROWN, true);
		// The mouth of steve
		steveMouth = new Rectangle(x + (int) (12.4 * elementRadius), y + (int) (33.4 * elementRadius),
				(int) (1.4 * elementRadius), (int) (1 * elementRadius), DARK_SALMON, true);
		// The mustache of steve
		steveMustache = new Rectangle(x + (int) (11.7 * elementRadius), y + (int) (33.2 * elementRadius),
				(int) (2.8 * elementRadius), (int) (1.7 * elementRadius), DARK_BROWN, true);
		steveMustache.moveBy(0, +(int) (2));

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

	// My first element of Steve Minecraft face going diagonal in the x,y
	// coordinates
	// It goes diagonal towards the fourth and second quadrant.
	public void doAction() {

		if (steveHeight) {
			y += 50;
			x += 50;
			steveMustache.moveBy(30, 30);
			steveMouth.moveBy(30, 30);
			steveNose.moveBy(30, 30);
			steveRightEyePupil.moveBy(30, 30);
			steveRightEye.moveBy(30, 30);
			steveLeftEyePupil.moveBy(30, 30);
			steveLeftEye.moveBy(30, 30);
			steveHead.moveBy(30, 30);
			steveHair.moveBy(30, 30);

		} else {
			y -= 50;
			x -= 50;
			steveMouth.moveBy(-30, -30);
			steveMustache.moveBy(-30, -30);
			steveNose.moveBy(-30, -30);
			steveRightEyePupil.moveBy(-30, -30);
			steveRightEye.moveBy(-30, -30);
			steveLeftEyePupil.moveBy(-30, -30);
			steveLeftEye.moveBy(-30, -30);
			steveHead.moveBy(-30, -30);
			steveHair.moveBy(-30, -30);
		}
		if (y >= window.getWindowHeight()) {
			steveHeight = !steveHeight;
		}
		if (y <= 0) {
			steveHeight = true;
		}
	}

	// My second element of Steve minecraft face going down left and back up and
	// down again when reaching the
	// window bottom, in the third quadrant.
	public void doAction2() {
		if (steveHeight) {
			y -= 70;
			x += 70;
			steveMustache.moveBy(20, -20);
			steveMouth.moveBy(20, -20);
			steveNose.moveBy(20, -20);
			steveRightEyePupil.moveBy(20, -20);
			steveRightEye.moveBy(20, -20);
			steveLeftEyePupil.moveBy(20, -20);
			steveLeftEye.moveBy(20, -20);
			steveHead.moveBy(20, -20);
			steveHair.moveBy(20, -20);
		} else {
			y += 70;
			x -= 70;
			steveMustache.moveBy(-20, 20);
			steveMouth.moveBy(-20, 20);
			steveNose.moveBy(-20, 20);
			steveRightEyePupil.moveBy(-20, 20);
			steveRightEye.moveBy(-20, 20);
			steveLeftEyePupil.moveBy(-20, 20);
			steveLeftEye.moveBy(-20, 20);
			steveHead.moveBy(-20, 20);
			steveHair.moveBy(-20, 20);
		}
		if (y >= window.getWindowHeight()) {
			steveHeight = true;
		}
		if (y <= 0) {
			steveHeight = !steveHeight;
		}
	}

	// I imported the java.util.random; package
	// This changes colors from 0 - 200 in the scale of rgb.
	public static Color createRandomColor() {
		Random convert = new Random();
		int r = convert.nextInt(200);
		int g = convert.nextInt(200);
		int b = convert.nextInt(200);
		Color randomColor = new Color(r, g, b);

		return randomColor;
	}

	// Color random generator to change the color of my first and second element,
	// includes
	// the left, right eye and the hair of Steve Minecraft face.
	public void flashEye() {
		Color randomColor1 = createRandomColor();
		Color randomColor2 = createRandomColor();
		Color randomColor3 = createRandomColor();
		steveLeftEyePupil.setColor(randomColor1);
		steveRightEyePupil.setColor(randomColor2);
		steveHair.setColor(randomColor3);
	}

	// Color random generator to change the color of my third element colors, face
	// and
	// nose; of Steve Minecraft face.
	public void flashFace() {
		Color randomColor1 = createRandomColor();
		Color randomColor2 = createRandomColor();
		steveHead.setColor(randomColor1);
		steveNose.setColor(randomColor2);
	}

	// My third element of Steve Minecraft face moving in Zig Zag from bottom left
	// to top left.
	public void zigZag() {
		if (zig) {
			y -= 350;
			x -= 350;
			steveMustache.moveBy(-5, -10);
			steveMouth.moveBy(-5, -10);
			steveNose.moveBy(-5, -10);
			steveRightEyePupil.moveBy(-5, -10);
			steveRightEye.moveBy(-5, -10);
			steveLeftEyePupil.moveBy(-5, -10);
			steveLeftEye.moveBy(-5, -10);
			steveHead.moveBy(-5, -10);
			steveHair.moveBy(-5, -10);
		} else {
			y += 350;
			x += 350;
			steveMustache.moveBy(10, 10);
			steveMouth.moveBy(10, 10);
			steveNose.moveBy(10, 10);
			steveRightEyePupil.moveBy(10, 10);
			steveRightEye.moveBy(10, 10);
			steveLeftEyePupil.moveBy(10, 10);
			steveLeftEye.moveBy(10, 10);
			steveHead.moveBy(10, 10);
			steveHair.moveBy(10, 10);
		}
		if (y >= window.getWindowHeight()) {
			zig = true;
		}
		if (y <= 0) {
			zig = !zig;
		}
	}

}
