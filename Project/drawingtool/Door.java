package drawingtool;

import java.awt.Point;

public class Door extends RoundRectangularObject implements LocatedRectangle {
	

	public Door(int width, int height, int vDiameter, int hDiameter, int left, int top) {
		super(width, height, vDiameter, hDiameter, left, top);
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
