package drawingtool;

public class RoundRectangularObject {
	private int width, height, vDiameter, hDiameter;

	public RoundRectangularObject(int width, int height, int vDiameter, int hDiameter) {
		this.width = width;
		this.height = height;
		this.vDiameter = vDiameter;
		this.hDiameter = hDiameter;
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

	public int getvDiameter() {
		return vDiameter;
	}

	public void setvDiameter(int vDiameter) {
		this.vDiameter = vDiameter;
	}

	public int gethDiameter() {
		return hDiameter;
	}

	public void sethDiameter(int hDiameter) {
		this.hDiameter = hDiameter;
	}

	public void drawAt(int left, int top) {
		Drawing.pen().drawRoundRect(left, top, width, height, hDiameter, vDiameter);
	}
}
