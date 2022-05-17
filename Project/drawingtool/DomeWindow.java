package drawingtool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class DomeWindow {
	private Color color;
	private int width ;
	private int height ;
	
	Dimension screenSize  = Toolkit.getDefaultToolkit().getScreenSize();
	
	public DomeWindow(Color color) {
		this.color = color;
		
		width = (int)(screenSize.width*0.36);
		height = (int)(screenSize.height*0.465);
	}
	public void draw() {
	Drawing.pen().setColor(color);
	Drawing.pen().fillArc((int)(screenSize.width*0.32), (int)(screenSize.height*0.52), 
			width, height, 0,180 );
	
	Drawing.pen().setColor(Color.black);
	Drawing.pen().drawArc((int)(screenSize.width*0.32), (int)(screenSize.height*0.52), 
			width, height, 0,180 );
}}
