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
	
	public default void outlineOval(int x, int y,int width, int height, Color color) {
		Drawing.pen().setColor(color);
		Drawing.pen().fillOval(x, y, width, height);
		Drawing.pen().setColor(Color.black);
		Drawing.pen().drawOval(x, y, width, height);
	}
	
	public default void outlinePolygon(int x[], int y[], Color color) {
		Drawing.pen().setColor(color);
		Drawing.pen().fillPolygon(x, y, y.length);
		Drawing.pen().setColor(Color.black);
		Drawing.pen().drawPolygon(x, y, y.length);
	}
	
	public default void outlineRoundRectangualrObject(int width, int height, int vDiameter, int hDiameter, int left, int top, Color color) {
		Drawing.pen().setColor(color);
		Drawing.pen().fillRoundRect(left, top, width, height, hDiameter, vDiameter);
		Drawing.pen().setColor(Color.black);
		Drawing.pen().drawRoundRect(left, top, width, height, hDiameter, vDiameter);
	}
}
