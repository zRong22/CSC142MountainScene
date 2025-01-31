import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class

/**
 * <p>
 * Create a cable car in a graphics window
 * </p>
 * 
 * @author Zhuo Rong (Andy) Ruan Zhao
 */

public class CableCar {

	// Your instance fields go here
	private int x;
	private int y;
	private double scale;
	private GWindow window;

	/**
	 * Create a cable car at location (x,y) in the GWindow window.
	 * 
	 * @param x      the x coordinate of the center of the cable car
	 * @param y      the y coordinate of the center of the cable car
	 * @param scale  the factor that multiplies all default dimensions for this
	 *               cable car (e.g. if the default size is 80, the size of this
	 *               cable car is scale * 80)
	 * @param window the graphics window this cable car belongs to
	 */
	public CableCar(int x, int y, double scale, GWindow window) {
		// initialize the instance fields
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.window = window;

		// The details of the drawing are in a private method
		cableCar();
		car();
	}

	/**
	 * Draws cable Lines and the Rope at location (x,y)
	 */
	private void cableCar() {
		Line cableFloor = new Line(0, y + (int) (60 * scale), window.getWindowWidth(), y + (int) (60 * scale));
		Line cableLine1 = new Line(x + (int) (2 * scale), y + (int) (80 * scale), x + (int) (10 * scale),
				y + (int) (60 * scale));
		Line cableLine2 = new Line(x + (int) (22 * scale), y + (int) (80 * scale), x + (int) (14 * scale),
				y + (int) (60 * scale));
		Line cableLine3 = new Line(x + (int) (13 * scale), y + (int) (100 * scale), x + (int) (22 * scale),
				y + (int) (80 * scale));
		Line cableLine4 = new Line(x + (int) (12 * scale), y + (int) (100 * scale), x + (int) (2 * scale),
				y + (int) (80 * scale));
		Rectangle carRope = new Rectangle(x + (int) (12.5 * scale), y + (int) (60 * scale), (int) (1 * scale),
				(int) (40 * scale), Color.BLACK, true);

		window.add(cableFloor);
		window.add(cableLine1);
		window.add(cableLine2);
		window.add(cableLine3);
		window.add(cableLine4);
		window.add(carRope);
	}

	// Draws the actual car of the cable
	private void car() {
		int cableCart = (int) (20 * scale);
		Color VERY_LIGHT_YELLOW = new Color(255, 255, 204);

		Rectangle car = new Rectangle(x - (int) (2 * cableCart), y + (int) (5 * cableCart), (int) (4 * cableCart),
				(int) (2 * cableCart), Color.BLACK, true);
		Rectangle carInterior = new Rectangle(x - (int) (1 * cableCart), y + (int) (6 * cableCart),
				(int) (4 * cableCart), (int) (1 * cableCart), Color.LIGHT_GRAY, true);
		Rectangle carInterior1 = new Rectangle(x - (int) (1 * cableCart), y + (int) (5 * cableCart),
				(int) (4 * cableCart), (int) (1 * cableCart), VERY_LIGHT_YELLOW, true);
		Rectangle carWindow1 = new Rectangle(x - (int) (0.7 * cableCart), y + (int) (5.6 * cableCart),
				(int) (0.7 * cableCart), (int) (0.7 * cableCart), Color.WHITE, true);
		Rectangle carWindow2 = new Rectangle(x + (int) (0.4 * cableCart), y + (int) (5.6 * cableCart),
				(int) (0.7 * cableCart), (int) (0.7 * cableCart), Color.WHITE, true);
		Rectangle carWindow3 = new Rectangle(x + (int) (1.5 * cableCart), y + (int) (5.6 * cableCart),
				(int) (0.7 * cableCart), (int) (0.7 * cableCart), Color.WHITE, true);

		window.add(car);
		window.add(carInterior);
		window.add(carInterior1);
		window.add(carWindow1);
		window.add(carWindow2);
		window.add(carWindow3);
	}
}
