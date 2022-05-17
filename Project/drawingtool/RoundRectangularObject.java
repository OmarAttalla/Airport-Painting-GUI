package drawingtool;

import java.awt.Point;

public class RoundRectangularObject {
	private int width, height, vDiameter, hDiameter, left, top;
	private Point address;

	public RoundRectangularObject(int width, int height, int vDiameter, int hDiameter, int left, int top) {
		this.width = width;
		this.height = height;
		this.vDiameter = vDiameter;
		this.hDiameter = hDiameter;
		
		this.left = left;
		this.top = top;
		
		address = new Point (left, top);
	}
	
	public Point getAddress() {
		return address;
	}
	
	public void setAddress( Point newAddress) {
		address = newAddress;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getvDiameter() {
		return vDiameter;
	}

	public void setvDiameter(int vDiameter) {
		this.vDiameter = vDiameter;
	}

	public int gethDiameter() {
		return hDiameter;
	}

	public void sethDiameter(int hDiameter) {
		this.hDiameter = hDiameter;
	}

	public void draw() {
		Drawing.pen().drawRoundRect(left, top, width, height, hDiameter, vDiameter);
	}
}
