package edu.yangtzeu.lmis.gui.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;

public class UserPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public UserPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 693, 38);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 58, 499, 377);
		add(panel_1);

	}
}
