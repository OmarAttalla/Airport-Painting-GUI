package drawingtool;

import java.awt.Color;

public class CockpitWindow {
	
	private int width, height;
	private Color color;
	
	public CockpitWindow(int width, int height) {
		this.width = width;
		this.height = height;
		color = Color.black; 
	}
	
	

	public CockpitWindow(int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}



	public void drawAt(int left, int top) {
		
	}
}
