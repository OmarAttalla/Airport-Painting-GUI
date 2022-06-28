package drawingtool;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Plane implements LocatedRectangle {

	private int width, height, left, top ;
	private Fuselage fuselage; // Aggregate
	private LandingGear frontGear, backGear; // Composite
	private Wing wing; // Aggregate
	private TailWing tailWing; // Aggregate
	private Point address;

	public Plane(int width, int height, int left, int top) {
		this.width = width;
		this.height = height;
		this.left = left;
		this.top = top;
		address = new Point(left, top);
		
		fuselage = new Fuselage(width, height, left, top);
		frontGear = new LandingGear((int) (height/2.5));
		backGear = new LandingGear((int) (height/2.5));
		wing = new Wing((int) (width / 3), (int) (height / 1.5));
		tailWing = new TailWing(width / 5, (int) (height / 0.6));
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

	
	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}
	
	public int height() {
		return height;
	}

	public int width() {
		return width ;
	}

	public Point address() {
		return address;
	}
	
	public TailWing getTailWing() {
		return tailWing;
	}
	
	public Wing getWing() {
		return wing;
	}
	public void draw() {
		fuselage.drawAt(address.x, address.y);
		tailWing.drawAt(address.x + (fuselage.getWidth() / 40), address.y);
		wing.drawAt((address.x + (int) (fuselage.getWidth() / 2)), (int) (address.y + fuselage.getHeight() / 1.1));
		frontGear.drawAt((address.x + (int) (fuselage.getWidth()* 0.93)),(int) (address.y + fuselage.getHeight() * 1.5));
		backGear.drawAt((address.x + (int) (fuselage.getWidth()* 0.5)),(int) (address.y + fuselage.getHeight() * 1.5));
//For dubugging purposes
//		System.out.println("new plane "+ width); 
//		System.out.println(height);
	}

	
}
