package drawingtool;

public class Airport {
	
	private int width,height;
	private TerminalBuilding terminalBuilding;
	private ATCTower tower;
	private Sky sky;
	private Runway runway;
	private Plane plane;
	
	public Airport() {
		plane = new Plane(375, 35);
	}
	

	public Airport(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		plane = new Plane(375, 35);
	}
	
	public void drawAt(int left, int bottom) {
		plane.drawAt(left, bottom);
	}

}
