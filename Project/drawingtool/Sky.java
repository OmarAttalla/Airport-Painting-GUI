package drawingtool;

import java.awt.Color;

public class Sky {
	private Color color;
	private Sun sun;
	
	public Sky(Color color) {
		this.color = color;
		sun = new Sun();
	}
	
	public void drawAt(int left, int top) {
		sun.drawAt(left,top);
	}
}
