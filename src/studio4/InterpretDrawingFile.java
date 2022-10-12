package studio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class InterpretDrawingFile {

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser("resources");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); //making Scanner with a File
		String shape = in.next();
		int redComponent = in.nextInt();
		int greenComponent = in.nextInt();
		int blueComponent = in.nextInt();
		boolean isFilled = in.nextBoolean();
		double x = in.nextDouble();
		double y = in.nextDouble();
		double halfWidth = in.nextDouble();
		double halfHeight = in.nextDouble();
		double x3 = in.nextDouble();
		double y3 = in.nextDouble();
		double[] triangleX = { x, halfWidth, x3};
		double[] triangleY = { y, halfHeight, y3};
		
		StdDraw.setPenColor(redComponent, greenComponent, blueComponent);
		if (isFilled == true) {
			if (shape.equals("rectangle")) {
				StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
			}	
			else if (shape.equals("ellipse")) {
				StdDraw.filledEllipse(x, y, halfWidth, halfHeight);
			}
			else {
				StdDraw.filledPolygon(triangleX, triangleY);
			}
		}
		else {
			if (shape.equals("rectangle")) {
				StdDraw.rectangle(x, y, halfWidth, halfHeight);
			}
			else if (shape.equals("ellipse")) {
				StdDraw.ellipse(x, y, halfWidth, halfHeight);
			}
			else {
				StdDraw.polygon(triangleX, triangleY);
			}
		}
		
	}
}
