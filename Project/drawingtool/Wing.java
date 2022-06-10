package drawingtool;

import java.awt.Color;

public class Wing implements OutlineObject{
	private int width,height;
	private Color color;
	private Engine engine; //Composite

	public Wing(int width, int height) {
		this.width = width;
		this.height = height;
		color = Color.white;
		engine= new Engine((int)(width/2.5),(int) (height/1.5));
	}
	
	public Wing(int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.color = color;
		engine= new Engine((int)(width/2.5),(int) (height/1.5));
	}
	public void drawAt(int left, int top) {
		outlineOval(left, top, width, height,color);
		engine.drawAt(left+(int)(width*0.9), top+(int)(height/2.3));
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
	
	
}
