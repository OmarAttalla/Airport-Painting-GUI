package drawingtool;

import java.util.ArrayList;

public class Plane {

	private Fuselage fuselage;
	private LandingGear gear;
	private Wing wings;
	private TailWing tailWing;
	
	public Plane(int width, int height){
		fuselage = new Fuselage(width, height);
		gear = new LandingGear();
		wings = new Wing();
		//tailWing = new TailWing();
	}

	public void drawAt(int left, int top) {
		fuselage.drawAt(left,top);
	}
}
