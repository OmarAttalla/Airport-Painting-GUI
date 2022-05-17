package drawingtool;

import java.awt.Color;

public interface OutlineObject {
	
	public default void outlineRec(int x, int y,int width, int height, Color color) {
		Drawing.pen().setColor(color);
		Drawing.pen().fillRect(x, y, width, height);
		Drawing.pen().setColor(Color.black);
		Drawing.pen().drawRect(x, y, width, height);
	}
	
	public default void outlineArc(int x, int y, int width, int height, int startAngle, int arcAngle, Color color) {
		Drawing.pen().setColor(color);
		Drawing.pen().fillArc(x, y, width, height, startAngle, arcAngle);
		Drawing.pen().setColor(Color.black);
		Drawing.pen().drawArc(x, y, width, height, startAngle, arcAngle);
	}
}
