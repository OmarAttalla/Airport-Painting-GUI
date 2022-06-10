package drawingtool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class DomeWindow implements OutlineObject{
	private Color color;
	private int width ;
	private int height,
	x,
	y;
	
	Dimension screenSize  = Toolkit.getDefaultToolkit().getScreenSize();
	
	public DomeWindow(Color color) {
		this.color = color;
		x =(int)(screenSize.width*0.32);
		y = (int)(screenSize.height*0.52);
		width = (int)(screenSize.width*0.36);
		height = (int)(screenSize.height*0.465);
	}
	
	public void draw() {
	//Shadow
	outlineArc(x, y, 
			width, height, 0, 180, Color.decode("#032543") );
	
	//window
	Drawing.pen().setColor(color);
	Drawing.pen().fillArc(x+5, y+5, width-10, height-10, 0, 180);
	Drawing.pen().setColor(Color.black);
}}
