 package drawingtool;

import java.awt.Color;
import java.awt.geom.Path2D;
import java.util.ArrayList;

public class Fuselage {

	private int width, height;
	private int mainDoorWidth, mainDoorHeight,emergencyDoorWidth,emergencyDoorHeight,windowWidth,windowHeight,numWindows;
	private Color color;
	private Door mainDoor1,mainDoor2,emergencyDoor1, emergencyDoor2;
	private ArrayList<PassengerWindow> passengerWindow;
	private CockpitWindow cockpitWindows;

	public Fuselage(int width, int height) {

		this.width = width;
		this.height = height;
		color = Color.white;
		
		passengerWindow = new ArrayList<PassengerWindow>();
		PassengerWindow pWindow;
		
		mainDoorWidth=(int)(width/30);
		mainDoorHeight=(int)(height/1.46);
		emergencyDoorWidth=(int)(width/42.85);
		emergencyDoorHeight=(int)(height/2.5);
		
		numWindows = height;
		windowWidth = height/7;
		windowHeight = height/5;
		mainDoor1 = new Door(mainDoorWidth,mainDoorHeight,(int)(width/37.5),(int)(height/5));
		mainDoor2 = new Door(mainDoorWidth,mainDoorHeight,(int)(width/37.5),(int)(height/5));
		emergencyDoor1 = new Door(emergencyDoorWidth,emergencyDoorHeight,(int)(width/75),(int)(height/11.67));
		emergencyDoor2 = new Door(emergencyDoorWidth,emergencyDoorHeight,(int)(width/75),(int)(height/11.67));
		
		for(int i=0; i<numWindows; i++) {
			pWindow = new PassengerWindow(windowWidth,windowHeight,(int)(height/8.75),(int)(height/8.75));
			passengerWindow.add(pWindow);
		}
	}

	public Fuselage(int width, int height, Color color) {

		this.width = width;
		this.height = height;
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

		// Belly
		fuselage.lineTo(xEndPoint - width / 1.75, yEndPoint);
		xEndPoint -= width / 1.75;

		// Slanted Tail section
		fuselage.curveTo(xEndPoint-width/20, yEndPoint-height/50, xEndPoint-width/10, yEndPoint-height/20, left, yEndPoint-height);
		fuselage.closePath();
			
		Drawing.pen().draw(fuselage);
		Drawing.pen().setColor(color);
		Drawing.pen().fill(fuselage);
		
		Drawing.pen().setColor(Color.black);
		
		//Doors
		mainDoor1.drawAt((int)(width/1.41), (int)(height/0.166)); //Backdoor
		mainDoor2.drawAt((int)(width/0.67), (int)(height/0.166));
		emergencyDoor1.drawAt((int)(left/0.493), (int)(top/0.923));// Leftmost emergencydoor
		emergencyDoor2.drawAt((int)(left/0.483), (int)(top/0.923));
		
		//Windows
		for(int i = 0; i< numWindows; i++) {
			passengerWindow.get(i).drawAt((int)(left/0.715)+(i*(windowWidth+3)),(int)(top/0.92));
		}
		
		//Flaps for gears
		
			
		}
		
	}

