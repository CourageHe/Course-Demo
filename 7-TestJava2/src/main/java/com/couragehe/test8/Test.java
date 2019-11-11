package com.couragehe.test8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 颜色列表框为红色、绿色和蓝色。
 * @author CourageHe
 *
 */
public class Test extends JFrame {

	private JPanel contentPane;
	JComboBox comboBox = new JComboBox();
	JCheckBox checkBox_1 = new JCheckBox("选择框");
	JCheckBox checkBox = new JCheckBox("背景");
	
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		checkBox.setBounds(132, 59, 71, 27);
		contentPane.add(checkBox);
		
		
		checkBox_1.setBounds(248, 59, 98, 27);
		contentPane.add(checkBox_1);
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"红色", "蓝色", "绿色"}));
		comboBox.setBounds(75, 13, 287, 24);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int colorCount = comboBox.getSelectedIndex();
				boolean after = checkBox.isSelected();
				boolean select = checkBox_1.isSelected();
				
				Color[]color = {Color.RED,Color.BLUE,Color.GREEN};
				if(select) {
					comboBox.setBackground(color[colorCount]);
				}
				if(after) {
					contentPane.setBackground(color[colorCount]);
				}
			}
		});
		btnNewButton.setBounds(75, 116, 81, 27);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("取消");
		button.setBounds(281, 116, 81, 27);
		contentPane.add(button);
	}
}
