package drawingtool;

public class LandingGear {
	private int diameter;

	public LandingGear(int diameter) {
		this.diameter = diameter;
	}
	
	public LandingGear() {
		
	}

	public void drawAt(int left, int top) {
		//Tire
		Drawing.pen().fillOval(left, top, diameter, diameter);
		//Rim
		Drawing.pen().fillOval(left, top, diameter/2, diameter/2);
		//Hub
		Drawing.pen().fillOval(left, top, diameter/5, diameter/5);
	}
}
