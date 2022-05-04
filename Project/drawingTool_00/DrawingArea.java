/**
 * Provides a panel which can be used for drawing.
 * 
 * @author Björn Gottfried
 * @version 1.0
 */

package drawingTool_00;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawingArea extends JPanel {
	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		
		int[] polygonXs = { 250, 350, 300, 200, 150 };
		int[] polygonYs = { 100, 200, 300, 300, 200 };
		int polygonVertices = polygonXs.length;
		
		pen.drawLine(100, 100, 800, 800); 
		
		pen.setColor(Color.blue); // a color constant
		pen.drawRect(10, 10, 200, 300);
	
		pen.setColor(Color.decode("#7a5230")); // HEX representation
		pen.fillOval(300, 234, 800, 200);
		
		
		pen.setColor(new Color(255,100,100)); // RGB representation
		pen.drawString("Hello World", 666, 280);
		
		pen.fillPolygon(polygonXs, polygonYs, polygonVertices);
	}
} 