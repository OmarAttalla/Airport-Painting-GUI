package drawingtool;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Buttons {
	private JButton planeButton = new JButton("Airport");
	private JButton colorTailsButtton = new JButton("Add Some Color");
	private JButton colorPlanesButton = new JButton("Add Even More Color");
	private JButton terminalButton = new JButton("Terminal");
	private int numButtons = 4;

	public void addActionListener(ActionListener listener) {
		planeButton.addActionListener(listener);
		colorTailsButtton.addActionListener(listener);
		colorPlanesButton.addActionListener(listener);
		terminalButton.addActionListener(listener);
	}

	public void addButtonsToAPanel(JFrame frame) {
		JPanel menu = new JPanel();
		menu.setLayout(new GridLayout(numButtons, 1, 0, 4));

		menu.add(planeButton);
		menu.add(colorTailsButtton);
		menu.add(colorPlanesButton);
		menu.add(terminalButton);

		menu.setBorder(BorderFactory.createRaisedBevelBorder());
		frame.add(menu, BorderLayout.WEST);
	}

	public JButton getPlaneButton() {
		return planeButton;
	}

	public JButton getColorTailsButton() {
		return colorTailsButtton;
	}

	public JButton getColorPlanesButton() {
		return colorPlanesButton;
	}

	public JButton getTerminalButton() {
		return terminalButton;
	}

}
