package drawingtool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class TerminalWindow {
	private Color color;
	
	public TerminalWindow(Color color) {
		this.color = color;
	}
	
	public void draw() {
		Dimension screenSize  = Toolkit.getDefaultToolkit().getScreenSize();
		
		int Width = (int)(screenSize.width*0.5);
		int Height = (int)(screenSize.height*0.15);
		
		int x1= (int) (screenSize.width * 0.055);
		int y1 = (int) (screenSize.height * 0.54);
		// top left side of terminal
		Drawing.pen().setColor(color);
		Drawing.pen().fillRect(x1, y1,
				(int) (Width * (0.7)), (int) (Height/4));

		Drawing.pen().setColor(Color.black);
		Drawing.pen().drawRect(x1, y1,
				(int) (Width * 0.7), (int) (Height/4));

		// Bottom left part of the Terminal
		Drawing.pen().setColor(color);
		Drawing.pen().fillRect((int) (screenSize.width * 0.03+10), (int) (screenSize.height * 0.58+10), Width,
				Height);

		Drawing.pen().setColor(Color.black);
		Drawing.pen().drawRect((int) (screenSize.width * 0.03+10), (int) (screenSize.height * 0.58+10), Width,
				Height);
		
	}
}
