package drawingtool;

public class Runway {

	private int width, height;
	private RunwayMarking runwayMarkings;
	
	public Runway(int width, int height) {
		this.width = width;
		this.height = height;
		runwayMarkings = new RunwayMarking();
	}
	
	public void drawAt(int left, int top) {
	}
}
