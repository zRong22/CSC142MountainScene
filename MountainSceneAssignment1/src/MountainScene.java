import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class

/**
 * <p>
 * A MountainScene displays snow men, trees (with ornaments), a cable car and a
 * fourth element of your choice in a graphics window
 * </p>
 * 
 * @author Zhuo Rong (Andy) Ruan Zhao
 */

public class MountainScene {

	/** The graphics window that displays the picture */
	private GWindow window;

	/**
	 * Create an image of a mountain scene
	 */
	public MountainScene() {

		// The graphics window
		// The window is by default 500 wide and 400 high
		this.window = new GWindow("Mountain scene");
		this.window.setExitOnClose(); // so that a click on the close box of the
		// window terminates the application

		// Background (Light blue here)
		Color LIGHT_BLUE = new Color(51, 204, 255);
		Rectangle bgnd = new Rectangle(0, 0, window.getWindowWidth(), window.getWindowHeight(), LIGHT_BLUE, true);
		this.window.add(bgnd);

		// Create the scene elements
		// e.g. a tree in the lower left area 1.5 times the normal size
		new Tree(30, 80, 1.2 , this.window);
		new Tree(440, 60, 1.3, this.window);
		new Tree(130, 60, 1.4, this.window);
		new Tree(30, 170, 0.9, this.window);
		new Tree(406, 205, 1 , this.window);
		new Tree(100, 190, 1.5, this.window);
		new SnowMan(360, 40, 0.4, this.window);
		new SnowMan(450, 300, 0.5, this.window);
		new SnowMan(60, 300, 0.3, this.window);
		new CableCar(250, 40, 1.8, this.window);
		new MyFourthElement(10, 50, 0.4, this.window);
		new MyFourthElement(10, -180, 0.8, this.window);
		new MyFourthElement(190, -205, 0.6, this.window);
	}

	/**
	 * Entry point of the program
	 */
	public static void main(String[] args) {
		new MountainScene();
	}

}