package drawingtool;

import java.awt.Color;
import java.awt.geom.Path2D;
import java.util.ArrayList;

public class Fuselage implements OutlineObject {

	private int width, height;
	private int left, top;
	private int mainDoorWidth, mainDoorHeight, emergencyDoorWidth, emergencyDoorHeight, windowWidth, windowHeight,
			numWindows, windowStartPos, windowSeparation, pWindowArea;
	private Color color;
	private Door leftMainDoor, rightMainDoor, leftEmergencyDoor, rightEmergencyDoor;
	private ArrayList<PassengerWindow> passengerWindow; // Composite
	private CockpitWindow cockpitWindow; // Composite
	
	public Fuselage(int width, int height, int left, int top) {

		this.width = width;
		this.height = height;
		this.left = left;
		this.top = top;
		color = Color.white;
		
		constructComponents();
	}

	public Fuselage(int width, int height, int left, int top, Color color) {

		this.width = width;
		this.height = height;
		this.left = left;
		this.top = top;
		this.color = color;
		
		constructComponents();

	}

	private void constructComponents() {
		constructDoors(width, height, left, top);
		constructPWindows(width, height, left, top, Color.white);
		constructCWindows(width, height, left, top, Color.black);
	}

	private void constructDoors(int width, int height, int left, int top) {
		mainDoorWidth = (int) (width / 30);
		mainDoorHeight = (int) (height / 1.46);
		emergencyDoorWidth = (int) (width / 42.85);
		emergencyDoorHeight = (int) (height / 2.5);

		leftMainDoor = new Door(mainDoorWidth, mainDoorHeight, (int) (width / 37.5), (int) (height / 5),
				(int) (left + width / 5.69), (int) (top + height / 3.228));
		rightMainDoor = new Door(mainDoorWidth, mainDoorHeight, (int) (width / 37.5), (int) (height / 5),
				(int) (left + width / 1.043), (int) (top + height / 3.228));
		leftEmergencyDoor = new Door(emergencyDoorWidth, emergencyDoorHeight, (int) (width / 75),
				(int) (height / 11.67), (int) (left + width / 1.823), (int) (top + height / 2.098));
		rightEmergencyDoor = new Door(emergencyDoorWidth, emergencyDoorHeight, (int) (width / 75),
				(int) (height / 11.67), (int) (left + width / 1.752), (int) (top + height / 2.098));

	}

	private void constructPWindows(int width, int height, int left, int top, Color color) {
		passengerWindow = new ArrayList<PassengerWindow>();
		PassengerWindow pWindow;

		pWindowArea = (int) (width / 1.369);
		numWindows = 35;
		windowWidth = width / 75;
		windowHeight = height / 5;
		windowSeparation = (int) Math
				.ceil((windowWidth + (pWindowArea - (numWindows * windowWidth)) / numWindows * 1.5));

		for (int i = 0; i < numWindows; i++) {
			windowStartPos = (int) (left + width / 4.704);

			pWindow = new PassengerWindow(windowWidth, windowHeight, (int) (height / 8.75), (int) (height / 8.75),
					windowStartPos + (i * windowSeparation), (int) (top + height / 2.0125), color);
			passengerWindow.add(pWindow);
		}
	}

	private void constructCWindows(int width, int height, int left, int top, Color color) {
		int WWidth = width / 25;
		int WHeight = height / 5;
		left += width*1.045;
		top += height /4.4;
		cockpitWindow = new CockpitWindow(left, top, WWidth, WHeight, color);
	}
	
	public int getWidth() {
		return width ;
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

		// Flaps for gears
		outlineRec((int) (left + width * 0.93), (int) (top + height * 1.44), width / 27, height / 5, color);

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
		leftMainDoor.draw();// Backdoor
		rightMainDoor.draw();
		leftEmergencyDoor.draw();// Leftmost emergencydoor
		rightEmergencyDoor.draw();

		// Windows
		for (int i = 0; i < numWindows; i++) {
			if (!(passengerWindow.get(i).intersects(rightMainDoor))) {
				outlineRoundRectangualrObject(passengerWindow.get(i).getWidth(), passengerWindow.get(i).getHeight(),
						passengerWindow.get(i).getvDiameter(), passengerWindow.get(i).gethDiameter(),
						passengerWindow.get(i).getLeft(), passengerWindow.get(i).getTop(),
						passengerWindow.get(i).getColor());
			} else {
				break;
			}
		}
		
		cockpitWindow.draw();

	}

}
