import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class

/**
 * <p>
 * Create a tree with ornaments in a graphics window
 * </p>
 * 
 * @author Zhuo Rong (Andy) Ruan Zhao
 */

public class Tree {

	// Instance fields
	// The graphics window this tree belongs to
	private GWindow window;
	// The location of this tree
	// (precisely (as done in the draw method), (x,y) is
	// the upper left corner of the tree trunk)
	private int x;
	private int y;
	// The scale used to draw this tree
	private double scale;

	/**
	 * Creates a tree
	 * 
	 * @param x      the x coordinate of the tree location (upper left corner of the
	 *               tree trunk)
	 * @param y      the y coordinate of the tree location
	 * @param window the graphics window this Tree belongs to
	 * @param scale  the scale of the drawing (all default dimensions are multiplied
	 *               by scale)
	 */
	public Tree(int x, int y, double scale, GWindow window) {
		// Initialize the instance fields (the use of this is required
		// since the instance fields have the same name as the
		// parameters of the constructor)
		this.window = window;
		this.scale = scale;
		this.x = x;
		this.y = y;

		// the details of the drawing are in written in the private method draw()
		pineTree();
		ballOrnament();
	}

	/**
	 * Draw a pine tree with the color of Dark brown
	 */
	private void pineTree() {
		// trunk of the tree: a brown rectangle
		// (int) converts to an int 20*this scale (etc...), which is a double
		// For instance, (int)23.8 is 23
		// This is necessary since the Rectangle constructor takes integers
		Color DARK_BROWN = new Color(78, 39, 0);
		Color darkGreen = new Color(0, 100, 0);
		int treeTrunk = (int) (2 * scale);
		Rectangle trunk = new Rectangle(x, y, (int) (10 * treeTrunk), (int) (30 * treeTrunk), DARK_BROWN, true);
		// Foliage (improve the drawing!)
		// a green triangle
		// It is improve by (x,y)and different end point dimensions
		int treeScale = (int) (2 * scale);
		Triangle foliage1 = new Triangle(x - (int) (15 * treeScale), y + (int) (15 * treeScale),
				this.x + (int) (5 * treeScale), y - (int) (5 * treeScale), x + (int) (25 * treeScale),
				this.y + (int) (15 * treeScale), darkGreen, true);
		Triangle foliage2 = new Triangle(x - (int) (15 * treeScale), y + (int) (5 * treeScale),
				x + (int) (5 * treeScale), y - (int) (5 * treeScale), x + (int) (25 * treeScale),
				y + (int) (5 * treeScale), darkGreen, true);
		Triangle foliage3 = new Triangle(x - (int) (15 * treeScale), y + (int) (15 * treeScale),
				x + (int) (5 * treeScale), y - (int) (5 * treeScale), x + (int) (25 * treeScale),
				y + (int) (15 * treeScale), darkGreen, true);

		foliage1.moveBy(-(int) (0.4 * treeScale), -(int) (3 * treeScale));
		foliage3.moveBy(0, (int) (5 * treeScale));
		foliage2.moveBy(0, -(int) (4 * treeScale));
		window.add(trunk);
		window.add(foliage1);
		window.add(foliage2);
		window.add(foliage3);

		// Improve version with BallOrnaments on the pine tree's at (x,y) points
	}

	private void ballOrnament() {

		int ordRadius = (int) (2 * scale);
		// The first one is colored Blue for the ornament
		// Top part of the pine tree
		Oval circler = new Oval(x - (int) (12.5 * ordRadius), y - (int) (ordRadius + 6), 5 * ordRadius, 5 * ordRadius,
				Color.BLUE, true);
		// The second one is colored Red for the ornament
		// Below part of the pine tree leave's
		Oval circle1r = new Oval(x - (int) (12.5 * ordRadius), y - ordRadius, 5 * ordRadius, 5 * ordRadius, Color.RED,
				true);
		// The third is colored Yellow for the ornament
		// Middle part of the pine tree leave's
		Oval circle2r = new Oval(x - (int) (12.5 * ordRadius), y - ordRadius, 5 * ordRadius, 5 * ordRadius,
				Color.YELLOW, true);
		// The fourth is colored Cyan for the ornament
		// Bottom right of the pine tree leave's
		Oval circle3r = new Oval(x + (int) (12.5 * ordRadius), y + (int) (6 * ordRadius), 5 * ordRadius, 5 * ordRadius,
				Color.CYAN, true);
		circler.moveBy((int) (8 * ordRadius), (int) (1.4 * ordRadius));
		circle1r.moveBy((int) (10 * ordRadius), (int) (10 * ordRadius));
		circle2r.moveBy((int) (20 * ordRadius), 0);

		window.add(circler);
		window.add(circle1r);
		window.add(circle2r);
		window.add(circle3r);
	}
}
