package drawingtool;

import java.awt.Color;

public class RunwayStripe implements OutlineObject {
	private int height, width;
	private Color color;
	
	public RunwayStripe(int height, int width) {
		this.height = height;
		this.width = width;
		color = Color.white;
	}
	
	public void drawAt(int left, int top) {
		outlineRec(left, top, width, height, color);
	}
	
	
}
