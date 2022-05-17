package drawingtool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Runway {

	private RunwayMarking runwayMarkings; //Composites
	
	public Runway() {
		runwayMarkings = new RunwayMarking();
	}
	
	public void draw() {
		
		Dimension screenSize  = Toolkit.getDefaultToolkit().getScreenSize();
		
		//Taxi area
		Drawing.pen().setColor(Color.decode("#5a5348"));
		Drawing.pen().fillRect(0, (int)(screenSize.height*0.75), screenSize.width, (int)(screenSize.height*0.2));
		
		//Main runway
		Drawing.pen().setColor(Color.decode("#48423a"));
		Drawing.pen().fillRect(0, (int)(screenSize.height*0.75), screenSize.width, (int)(screenSize.height*0.15));
		
		Drawing.pen().setColor(Color.decode("#348C31"));
		Drawing.pen().fillRect(0, (int)(screenSize.height*0.95), screenSize.width, (int)(screenSize.height*0.05));
		
		Drawing.pen().setColor(Color.decode("#228B22"));
		Drawing.pen().fillRect(0, (int)(screenSize.height*0.97), screenSize.width, (int)(screenSize.height*0.05));
		
		runwayMarkings.draw();
	}
}
