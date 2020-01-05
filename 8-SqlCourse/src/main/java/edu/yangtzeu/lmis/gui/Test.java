package edu.yangtzeu.lmis.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import edu.yangtzeu.lmis.gui.panel.ReaderPanel;
import edu.yangtzeu.lmis.gui.panel.ReaderTypePanel;

public class Test extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test() {
		getContentPane().setLayout(null);
//		
//		JPanel panel = new JPanel();
//		panel.setBounds(57, 35, 692, 346);
//		getContentPane().add(panel);
//			ReaderPanel readerPanle = new ReaderPanel();
		ReaderTypePanel readerPanle = new ReaderTypePanel();
		readerPanle.setBounds(0, 0, 1250, 707);
		
		getContentPane().add(readerPanle);
		readerPanle.setVisible(true);
	}
}
