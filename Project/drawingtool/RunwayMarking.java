package drawingtool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class RunwayMarking implements OutlineObject {
	private int lineNum = 4;

	public void draw() {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// Top stripe
		Drawing.pen().setColor(Color.decode("#F7B500"));
		Drawing.pen().fillRect(0, (int) (screenSize.height * 0.75), screenSize.width, (int) (screenSize.height * 0.01));

		// Bottom stripe
		Drawing.pen().fillRect(0, (int) (screenSize.height * 0.9), screenSize.width, (int) (screenSize.height * 0.01));

		// Runway lines
		int markingWidth = (int) (screenSize.width*0.15);
		int seperation = (int) (screenSize.width * 0.25);
		for (int i = 0; i < lineNum; i++) {
			outlineRec((int) (screenSize.width * 0.05)+i*seperation,(int) (screenSize.height * 0.82), markingWidth , (int) (screenSize.height * 0.025), Color.white );
		}
	}
}
