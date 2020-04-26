package com.couragehe.test9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
/**
 * 设计一个五角星
 * @author CourageHe
 *
 */
public class Test3 extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0)); 
		setContentPane(contentPane);
	}
	public void paint( Graphics g ){
		super.paint( g );
		g.setColor( Color.BLUE );
		g.drawLine(150,50,90,200);
		g.drawLine(150,50,210,200);
		g.drawLine(70,100,230,100);
		g.drawLine(230,100,90,200);
		g.drawLine(70,100,210,200);
		}

}

