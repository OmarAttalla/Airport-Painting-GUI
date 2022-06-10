package drawingtool;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class TerminalWindow implements OutlineObject {
	private Color color;
	
	public TerminalWindow(Color color) {
		this.color = color;
	}
	
	public void draw() {
		Dimension screenSize  = Toolkit.getDefaultToolkit().getScreenSize();
		
		int width = (int)(screenSize.width*0.5);
		int height = (int)(screenSize.height*0.15);
		
		int xTL= (int) (screenSize.width * 0.055);
		int yTL = (int) (screenSize.height * 0.54);
		
		// top left side of terminal
		outlineRec(xTL, yTL,
				(int) (width * 0.7), (int) (height/4),color);
		
			//window grid
		int gridX = xTL;
		BasicStroke stroke = new BasicStroke(5);
		Drawing.pen().setStroke(stroke);
		Drawing.pen().setColor(Color.white);
		
		for(int i = 1;gridX<(width * (0.7)); i++) {
			gridX+=i*20;
			Drawing.pen().drawLine(gridX, yTL, gridX, yTL+(int) (height/4));
		}
		
			//Resetting pen
		Drawing.pen().setColor(Color.black);
		stroke =new BasicStroke(1);
		Drawing.pen().setStroke(stroke);
		
		// Bottom left part of the Terminal
		int xBL = (int) (screenSize.width * 0.03+10);
		int yBL = (int) (screenSize.height * 0.58+10);
		
		outlineRec(xBL, yBL, width,
				height,color);
		
			//window grid
		
			//vertical part
		int gridX2 = xBL;
		stroke = new BasicStroke(5);
		Drawing.pen().setStroke(stroke);
		Drawing.pen().setColor(Color.white);
		
		for(int i = 1;gridX2<width; i++) {
			gridX2+=i*20;
			Drawing.pen().drawLine(gridX2, yBL, 
					gridX2, yBL+ height);
		}
			//Horizontal Part
		Drawing.pen().drawLine(xBL, yBL+height/2, 
				xBL+width, yBL+height/2);
		
			//Resetting pen
		Drawing.pen().setColor(Color.black);
		stroke =new BasicStroke(1);
		Drawing.pen().setStroke(stroke);
	}
}
