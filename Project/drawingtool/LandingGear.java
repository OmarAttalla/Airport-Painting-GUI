package drawingtool;

import java.awt.Color;

public class LandingGear implements OutlineObject {
	private int diameter;
	
	public LandingGear(int diameter) {
		this.diameter = diameter;
	}
	
	public void drawAt(int left, int top) {
		//Tire
		outlineOval(left, top, diameter, diameter,Color.black);
		//Rim
		outlineOval(left+diameter/4, top+diameter/4, diameter/2, diameter/2,Color.gray);
		//Hub
		outlineOval((int)(left+diameter/2.5), (int)(top+diameter/2.5), diameter/5, diameter/5,Color.black);
	}

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
	
	
}
