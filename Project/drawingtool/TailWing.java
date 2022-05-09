package drawingtool;

import java.awt.Color;
import java.awt.geom.Path2D;

public class TailWing {

	private int width, height;
	private Color color;

	public TailWing(int width, int height) {
		this.width = width;
		this.height = height;
		color = Color.white;
	}

	public TailWing(int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.color = color;
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void drawAt(int left, int top) {
		Path2D.Double tailWing = new Path2D.Double();
		double xEndPoint, yEndPoint;

		tailWing.moveTo(left, top);
		//Leftmost part
		tailWing.lineTo(left - width*6/37.5, top - height);
		xEndPoint = left - width*6/37.5;
		yEndPoint = top - height;
		
		//Top
		tailWing.lineTo(xEndPoint + width * 0.4, yEndPoint);
		xEndPoint += width * 0.4;
		
		//Rightmost part
		tailWing.lineTo(xEndPoint + width * 0.7, top);
		xEndPoint += width * 0.7;
		yEndPoint = top;

		Drawing.pen().draw(tailWing);
		Drawing.pen().setColor(color);
		Drawing.pen().fill(tailWing);
		
		Drawing.pen().setColor(Color.black);
	}
}