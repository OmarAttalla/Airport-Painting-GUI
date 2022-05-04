package drawingtool;

import java.awt.Color;
/**
 * Provides a panel which can be used for drawing.
 * 
 * @author Björn Gottfried
 * @version 1.0
 */
//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class DrawingArea extends JPanel {
	private static final long serialVersionUID = 1L;
	
	protected void paintComponent(Graphics g) {
		Graphics2D pen = (Graphics2D) g;

		super.paintComponent(pen);
		Drawing.set(pen);
		
		RenderingHints rh = new RenderingHints(
		RenderingHints.KEY_ANTIALIASING,
		RenderingHints.VALUE_ANTIALIAS_ON);
		pen.setRenderingHints(rh);
		
		Airport airport= new Airport(375, 35);
		airport.drawAt(200,200);
		
		
		
	}
} 