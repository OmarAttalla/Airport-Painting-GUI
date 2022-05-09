package drawingtool;

import java.awt.Point;
import java.util.ArrayList;

public class Plane {
	
	private int width, height;
	private Point address;
	private Fuselage fuselage;
	private LandingGear gear;
	private Wing wing;
	private TailWing tailWing;
	
	public Plane(int width, int height){
		fuselage = new Fuselage(width, height);
		gear = new LandingGear();
		wing = new Wing((int)(width/3),(int)(height/1.5));
		tailWing = new TailWing(width/5, (int)(height/0.6));
	}
	
	public Fuselage getFuselage() {
		return fuselage;
	}
	
	public int width() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int Height() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}
	
	public Point address() {
		return address;
	}

	public void drawAt(int left, int top) {
		fuselage.drawAt(left,top);
		tailWing.drawAt(left+(fuselage.getWidth()/40), top);
		wing.drawAt((left+(int)(fuselage.getWidth()/2)),(int) (top+fuselage.getHeight()/1.1));
	}
}
