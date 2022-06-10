package drawingtool;

import java.awt.Color;

public class CockpitWindow {
	
	private int width, height, left, top;
	private Color color;
	
	public CockpitWindow(int left, int top, int width, int height) {
		this.width = width;
		this.height = height;
		this.left = left;
		this.top = top;
		color = Color.black;
	}
	
	

	public CockpitWindow(int left, int top, int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.left = left;
		this.top = top;
		this.color = color;	
	}

	

	public Color getColor() {
		return color;
	}



	public void setColor(Color color) {
		this.color = color;
	}



	public void draw() {
		int triangleX[] = {left+width, left+width,  (int)(left+width*2)};
		int triangleY[] = {top,        top+height,  top+height};
		
		Drawing.pen().fillPolygon(triangleX, triangleY, triangleY.length);
		Drawing.pen().fillRect(left-width/40, top, (int) (width/1.2), height);
	}
}
