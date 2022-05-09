/**
 * Provides a test application window with a panel.
 * 
 * @author Björn Gottfried
 * 
 * @version 1.0
 */

package drawingtool;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestDrawingTool extends JFrame  {
	private static final long serialVersionUID = 1L;
	private JFrame applicationFrame;
	
	public TestDrawingTool(String title) {
		applicationFrame = new JFrame(title);
		Dimension screenSize = applicationFrame.getToolkit().getScreenSize();
		applicationFrame.setBounds(0, 0, screenSize.width, screenSize.height);
		applicationFrame.setVisible(true);
		
	}
	
	public void addACanvas(JPanel p) {
		applicationFrame.add(p);
	}
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		System.out.println("Button pressed");
//		if(((JButton)(e.getSource()).getText()).equalsTo("Whatever")) {
//			//do whatever
//		}
//	}
	public static void main(String[] args) {
		TestDrawingTool anApplication = new TestDrawingTool("Airport");
		anApplication.addACanvas(new DrawingArea());
		
	}
}