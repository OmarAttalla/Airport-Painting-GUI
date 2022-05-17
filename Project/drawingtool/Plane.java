package drawingtool;

import java.awt.Point;
import java.util.ArrayList;

public class Plane implements LocatedRectangle{
	
	private int width, height, left, top;
	private Fuselage fuselage; //Aggregate
	private LandingGear gear; //Composite
	private Wing wing; //Composite
	private TailWing tailWing; //Composite
	private Point address;
	
	public Plane(int width, int height, int left, int top){
		this.left = left;
		this.top = top;
		address = new Point (left, top);
		fuselage = new Fuselage(width, height, left, top);
		gear = new LandingGear();
		wing = new Wing((int)(width/3),(int)(height/1.5));
		tailWing = new TailWing(width/5, (int)(height/0.6));
	}
	
	public Fuselage getFuselage() {
		return fuselage;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void draw() {
		fuselage.drawAt(address.x,address.y);
		tailWing.drawAt(address.x+(fuselage.getWidth()/40), address.y);
		wing.drawAt((address.x+(int)(fuselage.getWidth()/2)),
				(int) (address.y+fuselage.getHeight()/1.1));
	}
	
	public int height() {
		return height;
	}
	
	public int width() {
		return width;
	}
	
	public Point address() {
		return address;
	}
}
