package edu.yangtzeu.lmis.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Sd extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sd frame = new Sd();
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
	public Sd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 954, 766);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel searchResultPanel = new JPanel();
		searchResultPanel.setBounds(0, 66, 708, 547);
		searchResultPanel.setLayout(null);
		getContentPane().add(searchResultPanel);
		
		String[] headers = { "表头一", "表头二", "表头三" };
		Object[][] cellData = null;

		DefaultTableModel model = new DefaultTableModel(cellData, headers) {

		  public boolean isCellEditable(int row, int column) {
		    return false;
		  }
		};
		JTable searchResultJTable  = new JTable(model);
//		JTable searchResultJTable = new JTable();

//		DefaultTableModel tableModel = (DefaultTableModel)searchResultJTable.getModel();
//		tableModel.addColumn("ID");
//		tableModel.addColumn("姓名");
//		tableModel.addColumn("性别");

		searchResultJTable.setBounds(27, 95, 708, 534);
		searchResultPanel.add(searchResultJTable);
	}

}
