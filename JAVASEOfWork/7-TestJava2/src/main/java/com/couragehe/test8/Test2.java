package com.couragehe.test8;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 加减法
 * @author CourageHe
 *
 */
public class Test2 extends JFrame {

	private JPanel contentPane;
	private JTextField addNum1;
	private JTextField addNum2;
	private JTextField result;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 432, 184);
		contentPane.add(panel);
		panel.setLayout(null);
		
		addNum1 = new JTextField();
		addNum1.setForeground(Color.CYAN);
		addNum1.setBounds(157, 0, 86, 74);
		panel.add(addNum1);
		addNum1.setColumns(10);
		
		addNum2 = new JTextField();
		addNum2.setForeground(Color.CYAN);
		addNum2.setColumns(10);
		addNum2.setBounds(157, 76, 86, 74);
		panel.add(addNum2);
		
		JLabel label = new JLabel("加数1");
		label.setBounds(53, 38, 72, 18);
		panel.add(label);
		
		JLabel label_1 = new JLabel("加数2");
		label_1.setBounds(53, 104, 72, 18);
		panel.add(label_1);
		
		JButton button = new JButton("求和");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1 = Integer.parseInt( addNum1.getText());
				int num2 = Integer.parseInt( addNum2.getText());
				result.setText(num1+num2+"");
			}
		});
		button.setBounds(10, 197, 113, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("清除");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum1.setText("");
				addNum2.setText("");
				result.setText("");
			}
		});
		button_1.setBounds(290, 197, 113, 27);
		contentPane.add(button_1);
		
		result = new JTextField();
		result.setBackground(Color.WHITE);
		result.setEditable(false);
		result.setForeground(Color.CYAN);
		result.setColumns(10);
		result.setBounds(156, 183, 86, 70);
		contentPane.add(result);
	}
}
