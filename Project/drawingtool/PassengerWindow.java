package drawingtool;

import java.awt.Color;
import java.awt.Point;

public class PassengerWindow extends RoundRectangularObject implements LocatedRectangle {

	public PassengerWindow(int width, int height, int vDiameter, int hDiameter, int left, int top, Color color) {
		super(width, height, vDiameter, hDiameter, left, top, color);
	}
	
	@Override
	public Point address() {
		return getAddress();
	}

	@Override
	public int width() {
		return getWidth();
	}

	@Override
	public int height() {
		return getHeight();
	}

}
