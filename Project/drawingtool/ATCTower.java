package drawingtool;

import java.awt.Color;

public class ATCTower implements OutlineObject{
	
	private int width, height;
	private int left,  top;
	private Color color;
	
	public ATCTower(int left, int top, int width, int height, Color color) {
		this.left=left;
		this.top = top;
		this.width = width;
		this.height = height;
		this.color= color;
	}
	
	public void draw() {
		//Straight bottom part
		outlineRec(left, top, width, height, color);
		
		//Top trapezium
		int roomX[] = {left+width, left+(int)(1.5*width), left+(2*width),  left+(2*width),    left+width,            0,                     0};
		int roomY[] = {top,        top-(height/10),       top - (height/3),top-(int)(height/2.2),           top - (int)(height/1.7), top - (int)(height/1.7), top};
		outlinePolygon(roomX, roomY, color);
	}
}
