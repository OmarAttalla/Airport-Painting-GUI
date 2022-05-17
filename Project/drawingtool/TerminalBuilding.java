package drawingtool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class TerminalBuilding implements OutlineObject {

	private TerminalWindow terminalWindow; //Composite
	private DomeWindow domeWindow;//Composite
	private Color color;
	
	public TerminalBuilding(Color color) {
		terminalWindow = new TerminalWindow(Color.decode("#032543"));
		domeWindow = new DomeWindow(Color.decode("#032543"));
		this.color = color;
	}

	public void draw() {
		//
		Dimension screenSize  = Toolkit.getDefaultToolkit().getScreenSize();
		
		int terminalBuildingWidth = (int)(screenSize.width*0.5);
		int terminalBuildingHeight = (int)(screenSize.height*0.17);
		
		int terminalDomeWidth = (int)(screenSize.width*0.4);
		int terminalDomeHeight = (int)(screenSize.height*0.5);
		
		//top left side of terminal
		outlineRec((int)(screenSize.width*0.05), (int)(screenSize.height*0.53), 
			 (int) (terminalBuildingWidth*(0.8)), terminalBuildingHeight,color);
		
		//Bottom left part of the Terminal
		outlineRec((int)(screenSize.width*0.03), (int)(screenSize.height*0.58), 
				terminalBuildingWidth, terminalBuildingHeight,color);
		terminalWindow.draw();
		
		//Dome
		outlineArc((int)(screenSize.width*0.3), (int)(screenSize.height*0.5), terminalDomeWidth, terminalDomeHeight, 0,180,color );
		domeWindow.draw();
		
		
		
	}
}
