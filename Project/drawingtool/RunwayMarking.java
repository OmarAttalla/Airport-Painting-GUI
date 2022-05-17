package drawingtool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class RunwayMarking {
	
public void draw() {
		
		Dimension screenSize  = Toolkit.getDefaultToolkit().getScreenSize();
		
		//Top stripe 
		Drawing.pen().setColor(Color.white);
		Drawing.pen().fillRect(0, (int)(screenSize.height*0.75), screenSize.width, (int)(screenSize.height*0.01));
		
		//Bottom stripe
		Drawing.pen().fillRect(0, (int)(screenSize.height*0.9), screenSize.width, (int)(screenSize.height*0.01));
		
		
}
}
