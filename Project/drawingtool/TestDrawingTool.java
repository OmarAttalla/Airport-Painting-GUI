/**
 * Provides a test application window with a panel.
 * 
 * @author Björn Gottfried
 * 
 * @version 1.0
 */

package drawingtool;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class TestDrawingTool extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private static DrawingArea drawing;
	private Buttons buttons = new Buttons();
	
	public TestDrawingTool(String title) {
		super(title);
		Dimension screenSize = getToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);

		this.constructButtonMenu();
		this.constructDrawingArea();
		setVisible(true);
	}
	
	private void constructButtonMenu() {
		buttons.addButtonsToAPanel(this);
		buttons.addActionListener(this);
	}

	private void constructDrawingArea() {
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		drawing = new DrawingArea();
		getContentPane().add(drawing );
		drawing.setLayout(new BorderLayout(0, 0));
	}
	public void addACanvas(JPanel p) {
		getContentPane().add(p);
	}
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		System.out.println("Button pressed");
//		if(((JButton)(e.getSource()).getText()).equalsTo("Whatever")) {
//			//do whatever
//		}
//	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttons.getPlaneButton()) {
			tidyUpDrawingArea();
			drawing.getAirport().setAllPlanes();
			
		} else if (e.getSource() == buttons.getColorTailsButton()) {
			tidyUpDrawingArea();
			drawing.getAirport().colorTails();

		} else if (e.getSource() == buttons.getColorPlanesButton()) {
			tidyUpDrawingArea();
			drawing.getAirport().colorPlanes();
		} else if (e.getSource() == buttons.getTerminalButton()) {
			tidyUpDrawingArea();
			drawing.getAirport().setTerminal();

		}
	}

	private void tidyUpDrawingArea() {
		drawing.removeAll();
		drawing.revalidate();
		drawing.repaint();
	}
	public static void main(String[] args) {
		drawing = new DrawingArea();
		TestDrawingTool anApplication = new TestDrawingTool("Airport");
		anApplication.addACanvas(drawing);
		
	}
}