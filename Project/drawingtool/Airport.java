package drawingtool;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Airport {
	
	private int width,height;
	private TerminalBuilding terminalBuilding;//Aggregate
	private ATCTower tower; //Aggregate
	private Sky sky; //Composite
	private Runway runway; //Composite
	private ArrayList<Plane> planes;//Aggregates
	
	public Airport() {
		planes = new ArrayList<Plane>();
		
		int width = RandomNumber.between(125, 750);
		int height = (int) (width/10.71);
		Plane plane1 = new Plane(width,height,100, 850);
		
		width = RandomNumber.between(125, 750);
		height = (int) (width/10.71);
		Plane plane2 = new Plane(width, height,1000, 800);
		
		if(!(plane1.intersects(plane2))) {
        	planes.add(plane1);
    		planes.add(plane2);
        }
		
		sky = new Sky(Color.decode("#C2E0F9"));
		runway= new Runway();
		terminalBuilding= new TerminalBuilding(Color.decode("#d2d2d1"));
	}
	
	public void draw() {
		sky.draw();
		runway.draw();
		terminalBuilding.draw();
	
		for(int i= 0; i<planes.size(); i++) {
			planes.get(i).draw();
		}
		
	}

	
}
