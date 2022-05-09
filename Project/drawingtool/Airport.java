package drawingtool;

import java.util.ArrayList;

public class Airport  {
	
	private int width,height;
	private TerminalBuilding terminalBuilding;
	private ATCTower tower;
	private Sky sky;
	private Runway runway;
	private ArrayList<Plane> planes;
	
	public Airport() {
		planes = new ArrayList<Plane>();
		Plane plane1 = new Plane(375,35);
		Plane plane2 = new Plane(375/2, 35/2);
		plane2.getFuselage().setWindowSeparation(4);
		
		planes.add(plane1);
		planes.add(plane2);
	}
	
	public void draw() {
		planes.get(0).drawAt(100, 500);
		for(int i= 1; i<planes.size(); i++) {
			planes.get(i).drawAt(1000, 500);
		}
		
	}

}
