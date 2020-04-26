package com.couragehe.test7;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
/***
 * 按钮布局
 * @author 52423
 *
 */
public class Test2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test2 frame = new Test2();
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
	public Test2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(0, 0, 113, 107);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(106, 0, 195, 54);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("New button");
		button.setBounds(0, 108, 113, 107);
		contentPane.add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(300, 108, 113, 107);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(300, 0, 113, 107);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("New button");
		button_3.setBounds(106, 45, 195, 64);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("New button");
		button_4.setBounds(106, 108, 99, 64);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("New button");
		button_5.setBounds(202, 108, 99, 64);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("New button");
		button_6.setBounds(106, 161, 99, 64);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("New button");
		button_7.setBounds(202, 151, 99, 64);
		contentPane.add(button_7);
	}
}
