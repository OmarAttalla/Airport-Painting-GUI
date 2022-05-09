package drawingtool;

import java.awt.Color;
import java.awt.geom.Path2D;
import java.util.ArrayList;

public class Fuselage {

	private int width, height;
	private int mainDoorWidth, mainDoorHeight, emergencyDoorWidth, emergencyDoorHeight, windowWidth, windowHeight,
			numWindows, mainDoorsY, emergencyDoorsY, windowsY, windowStartPos, windowSeparation;
	private Color color;
	private Door leftMainDoor, rightMainDoor, leftEmergencyDoor, rightEmergencyDoor;
	private ArrayList<PassengerWindow> passengerWindow;
	private CockpitWindow cockpitWindows;

	public Fuselage(int width, int height) {

		this.width = width;
		this.height = height;
		color = Color.white;

		passengerWindow = new ArrayList<PassengerWindow>();
		PassengerWindow pWindow;

		mainDoorWidth = (int) (width / 30);
		mainDoorHeight = (int) (height / 1.46);
		emergencyDoorWidth = (int) (width / 42.85);
		emergencyDoorHeight = (int) (height / 2.5);

		numWindows = 35;
		windowWidth = width / 75;
		windowHeight = height / 5;

		leftMainDoor = new Door(mainDoorWidth, mainDoorHeight, (int) (width / 37.5), (int) (height / 5));
		rightMainDoor = new Door(mainDoorWidth, mainDoorHeight, (int) (width / 37.5), (int) (height / 5));
		leftEmergencyDoor = new Door(emergencyDoorWidth, emergencyDoorHeight, (int) (width / 75),
				(int) (height / 11.67));
		rightEmergencyDoor = new Door(emergencyDoorWidth, emergencyDoorHeight, (int) (width / 75),
				(int) (height / 11.67));

		for (int i = 0; i < numWindows; i++) {
			pWindow = new PassengerWindow(windowWidth, windowHeight, (int) (height / 8.75), (int) (height / 8.75));
			passengerWindow.add(pWindow);
		}
	}

	public Fuselage(int width, int height, Color color) {

		this.width = width;
		this.height = height;
		this.color = color;

		passengerWindow = new ArrayList<PassengerWindow>();
		PassengerWindow pWindow;

		mainDoorWidth = (int) (width / 30);
		mainDoorHeight = (int) (height / 1.46);
		emergencyDoorWidth = (int) (width / 42.85);
		emergencyDoorHeight = (int) (height / 2.5);

		numWindows = 35;
		windowWidth = width / 75;
		windowHeight = height / 5;
		windowSeparation= 0; // It is either set by the user using the setter or set to default calculation
		
		leftMainDoor = new Door(mainDoorWidth, mainDoorHeight, (int) (width / 37.5), (int) (height / 5));
		rightMainDoor = new Door(mainDoorWidth, mainDoorHeight, (int) (width / 37.5), (int) (height / 5));
		leftEmergencyDoor = new Door(emergencyDoorWidth, emergencyDoorHeight, (int) (width / 75),
				(int) (height / 11.67));
		rightEmergencyDoor = new Door(emergencyDoorWidth, emergencyDoorHeight, (int) (width / 75),
				(int) (height / 11.67));

		for (int i = 0; i < numWindows; i++) {
			pWindow = new PassengerWindow(windowWidth, windowHeight, (int) (width / 93.75), (int) (height / 8.75));
			passengerWindow.add(pWindow);
		}

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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
	public int getWindowSeparation() {
		return windowSeparation;
	}

	public void setWindowSeparation(int windowSeparation) {
		this.windowSeparation = windowSeparation;
	}

	public double getRelativeWidthScaling(int fuselageWidth) {
		int ogTestingWidth = 375;
		return fuselageWidth/ogTestingWidth  ;
	}

	public double getRelativeHeightScaling(int fuselageHeight) {
		int ogTestingHeight = 35;
		return  fuselageHeight / ogTestingHeight;
	}
	
	public int calculateWindowSeparation(double scaleFactor) {
		int ogTestSeparation = 3;
		int num= 0;
		if (scaleFactor == 1) {
			return 3;
		}else if(scaleFactor % 0.5==0) { //Multiple of 0.5
			num+=1;
		}
		return 0;
		
	}
	public void drawAt(int left, int top) {

		Path2D.Double fuselage = new Path2D.Double();

		double xEndPoint, yEndPoint;

		fuselage.moveTo(left, top);

		// straight top segment
		fuselage.lineTo(left + width, top);
		xEndPoint = left + width;
		yEndPoint = top;

		// cockpit segment
		fuselage.curveTo(xEndPoint + width / 46.15, yEndPoint - height / 21.875, xEndPoint + width / 14.29,
				yEndPoint + height / 175, xEndPoint + width / 8.1, top + height / 2.24);
		xEndPoint += width / 8.1;
		yEndPoint += height / 2.24;

		// nose
		fuselage.curveTo(xEndPoint + width / 9.17, yEndPoint + height / 3.47, xEndPoint + width / 18.52,
				yEndPoint + height, xEndPoint - width / 3.94, yEndPoint + height);
		xEndPoint -= width / 3.94;
		yEndPoint += height;

		// Belly
		fuselage.lineTo(xEndPoint - width / 1.75, yEndPoint);
		xEndPoint -= width / 1.75;

		// Slanted Tail section
		fuselage.curveTo(xEndPoint - width / 20, yEndPoint - height / 50, xEndPoint - width / 10,
				yEndPoint - height / 20, left, yEndPoint - height);
		fuselage.closePath();

		Drawing.pen().draw(fuselage);
		Drawing.pen().setColor(color);
		Drawing.pen().fill(fuselage);

		Drawing.pen().setColor(Color.black);

		// Doors
		mainDoorsY = (int) (top + height / 3.228);
		emergencyDoorsY = (int) (top + height / 2.098);
		leftMainDoor.drawAt((int) (left + width / 5.69), mainDoorsY); // Backdoor
		rightMainDoor.drawAt((int) (left + width / 1.043), mainDoorsY);
		leftEmergencyDoor.drawAt((int) (left + width / 1.823), emergencyDoorsY);// Leftmost emergencydoor
		rightEmergencyDoor.drawAt((int) (left + width / 1.752), emergencyDoorsY);

		// Windows
		windowsY = (int) (top + height / 2.0125);
		windowStartPos = (int) (left + width / 4.704);
		if (windowSeparation == 0) {
			windowSeparation= (windowWidth+(int)(width/95));
		}
		
		for (int i = 0; i < numWindows; i++) {
			passengerWindow.get(i).drawAt(windowStartPos+(i*windowSeparation),windowsY);

//			passengerWindow.get(i).drawAt(windowStartPos + (i * (windowWidth + (int) (6))), windowsY);
		}

		// Flaps for gears

	}

}
