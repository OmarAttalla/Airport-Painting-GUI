package drawingtool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

public class Airport {
	
	private int width,height;
	private TerminalBuilding terminalBuilding;//Aggregate
	private ATCTower tower; //Aggregate
	private Sky sky; //Composite
	private Runway runway; //Composite
	private ArrayList<Plane> planes;//Aggregates
	private int maxPlaneNum;
	
	public Airport() {
		Dimension screenSize  = Toolkit.getDefaultToolkit().getScreenSize();
		planes = new ArrayList<Plane>();
		
		maxPlaneNum = 5;
		for(int i = 1; i<=maxPlaneNum; i++) {
			int width = RandomNumber.between(125, 750);
			int height = (int) (width/10.71);
			int x = RandomNumber.between(0, (int) (screenSize.width*0.8));
			int y = RandomNumber.between((int) (screenSize.height*0.75), (int) (screenSize.height*0.765));
			
			System.out.println(x +" "+ y);
			Plane plane = new Plane(width,height,x, y);
			
			if(vacantSpot(plane)){
				planes.add(plane);
				System.out.println("Plane "+ i + " was added!");
			}else {
				System.out.println("No sufficient place for plane "+ i+ "!");
			}
		}
		
		sky = new Sky(Color.decode("#C2E0F9"));
		runway= new Runway();
		terminalBuilding= new TerminalBuilding(Color.decode("#d2d2d1"));
		
		int towerY = (int)(screenSize.height*0.35);
		tower = new ATCTower(0,towerY, 110, (int)(screenSize.height*0.75 - towerY), Color.decode("#bdbdbb"));
	}
	
	private boolean vacantSpot(LocatedRectangle plane) {
		boolean anyIntersection = false;
		for (LocatedRectangle p : planes)
			anyIntersection = anyIntersection || p.intersects(plane, 50);
		return !anyIntersection;
	}
	
	public void setAllPlanes() {
		Dimension screenSize  = Toolkit.getDefaultToolkit().getScreenSize();
		
		System.out.println("setAllplaness");
		Plane newPlane;
		
		int size = maxPlaneNum;
		planes.clear();
		for(int i = 1; i<=size;i++) {
			int width = RandomNumber.between(125, 750);
			int height = (int) (width/10.71);
			int x = RandomNumber.between(0, (int) (screenSize.width*0.8));
			int y = RandomNumber.between((int) (screenSize.height*0.75), (int) (screenSize.height*0.765));
			
			newPlane = new Plane(width, height, x, y);
			if(vacantSpot(newPlane)){
				planes.add(newPlane);
				System.out.println("newPlane "+ i + " was added!");
			}else {
				System.out.println("No sufficient place for newPlane "+ i+ "!");
			}
		}
	}
	
	public void setTerminal() {
		planes.clear();
	}
	
	public void colorTails() {
		int colorNum;
		Color newColor = null;
		
		for(int i =0; i< planes.size(); i++) {
			colorNum = RandomNumber.between(1,5);
			
			switch(colorNum) {
			case(1):
				newColor = Color.decode("#C0161C");
				break;
			case(2):
				newColor = Color.decode("#2A4057");
				break;
			case(3):
				newColor = Color.decode("#2A7568");
				break;
			case(4):
				newColor = Color.decode("#1C936F");
				break;
			case(5):
				newColor = Color.decode("#B97715");
				break;
			}
			
			planes.get(i).getTailWing().setColor(newColor);
		}
	}
	
		public void colorPlanes() {
			int colorNum;
			Color newColor = null;
			Color wingColor = null;
			
			for(int i =0; i< planes.size(); i++) {
				colorNum = RandomNumber.between(1,5);
				
				switch(colorNum) {
				case(1):
					newColor = Color.decode("#EF767A");
					wingColor = Color.decode("#C0161C");
					break;
				case(2):
					newColor = Color.decode("#456990");
				wingColor = Color.decode("#2A4057");
					break;
				case(3):
					newColor = Color.decode("#49BEAA");
				wingColor = Color.decode("#2A7568");
					break;
				case(4):
					newColor = Color.decode("#49DCB1");
				wingColor = Color.decode("#1C936F");
					break;
				case(5):
					newColor = Color.decode("#EEB868");
				wingColor = Color.decode("#B97715");
					break;
				}
				
				planes.get(i).getFuselage().setColor(newColor);
				planes.get(i).getWing().setColor(wingColor);
			}

		
		
	}
	public void draw() {
		sky.draw();
		runway.draw();
		tower.draw();
		terminalBuilding.draw();
		
		
		for(int i= 0; i<planes.size(); i++) {
			planes.get(i).draw();
		}
		
	}

	
}
