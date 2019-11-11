package com.couragehe.test7;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class Test3 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton button_13;
	private JButton button_14;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test3 frame = new Test3();
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
	public Test3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(1, 48, 436, 191);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("7");
		btnNewButton.setBounds(0, 5, 112, 44);
		panel.add(btnNewButton);
		
		button = new JButton("8");
		button.setBounds(113, 4, 113, 44);
		panel.add(button);
		
		button_1 = new JButton("9");
		button_1.setBounds(224, 5, 113, 44);
		panel.add(button_1);
		
		button_2 = new JButton("/");
		button_2.setBounds(336, 6, 113, 44);
		panel.add(button_2);
		
		button_3 = new JButton("4");
		button_3.setBounds(-2, 51, 112, 44);
		panel.add(button_3);
		
		button_4 = new JButton("5");
		button_4.setBounds(111, 50, 113, 44);
		panel.add(button_4);
		
		button_5 = new JButton("6");
		button_5.setBounds(222, 51, 113, 44);
		panel.add(button_5);
		
		button_6 = new JButton("*");
		button_6.setBounds(334, 52, 113, 44);
		panel.add(button_6);
		
		button_7 = new JButton("1");
		button_7.setBounds(-1, 96, 112, 44);
		panel.add(button_7);
		
		button_8 = new JButton("2");
		button_8.setBounds(112, 95, 113, 44);
		panel.add(button_8);
		
		button_9 = new JButton("3");
		button_9.setBounds(223, 96, 113, 44);
		panel.add(button_9);
		
		button_10 = new JButton("-");
		button_10.setBounds(335, 97, 113, 44);
		panel.add(button_10);
		
		button_11 = new JButton("0");
		button_11.setBounds(0, 143, 112, 44);
		panel.add(button_11);
		
		button_12 = new JButton("。");
		button_12.setBounds(113, 142, 113, 44);
		panel.add(button_12);
		
		button_13 = new JButton("=");
		button_13.setBounds(224, 143, 113, 44);
		panel.add(button_13);
		
		button_14 = new JButton("+");
		button_14.setBounds(336, 144, 113, 44);
		panel.add(button_14);
		
		textField = new JTextField();
		textField.setBounds(-1, 6, 438, 41);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
