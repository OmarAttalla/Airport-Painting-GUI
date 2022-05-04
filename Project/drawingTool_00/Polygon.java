package drawingTool_00;


import java.awt.Graphics;
import javax.swing.JPanel;
import java.lang.Math;

public class Polygon extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private int sides;
	
	public Polygon(int sides) {
		this.sides = sides;
	}

	public int getSides() {
		return sides;
	}

	public void setSides(int sides) {
		this.sides = sides;
	}
	
	public double calculateAngles() { 
		double externalAngle = (180-((sides - 2) * 180)/sides);
		return externalAngle;
	}
	
	protected void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		
		int startingX= 100;
		int startingY= 100;
		double angle = calculateAngles();
		
		double xDisplacement = startingX* Math.cos(angle);
		double yDisplacement = startingY* Math.sin(angle);
		
		for(int i = 0; i<sides; i++) {
			if (i%2 == 0){
				pen.drawLine(startingX, startingY, (int)(startingX+xDisplacement), (int)(startingY+yDisplacement));
				startingX = (int)(startingX+xDisplacement);
				startingY = (int)(startingY+yDisplacement);
			}else {
				pen.drawLine(startingX, startingY, (int)(startingY+yDisplacement), (int)(startingX+xDisplacement));
				startingX = (int)(startingY+yDisplacement);
				startingY = (int)(startingX+xDisplacement);
			
			}
			
		}
	}
		
}
