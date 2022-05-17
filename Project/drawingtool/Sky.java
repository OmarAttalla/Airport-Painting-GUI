package drawingtool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Sky {
	private Color color;
	
	public Sky(Color color) {
		this.color = color;
	}
	
	public void draw() {
		
		Dimension screenSize  = Toolkit.getDefaultToolkit().getScreenSize();
		Drawing.pen().setColor(color);
		Drawing.pen().fillRect(0, 0, screenSize.width, (int)(screenSize.height*0.75));
	}
}
