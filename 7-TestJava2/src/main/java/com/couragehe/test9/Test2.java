package com.couragehe.test9;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
/**
 * 2．设计一个程序，程序执行时，随机产生一条直线、一个矩形、
 * 一个椭圆，并且每个图形的颜色不同。
 * （说明：可利用系统类Math中的静态方法random(),
 * 该方法产生一个0~1间的小数）
 * @author 52423
 *
 */
public class Test2 extends JFrame {

	private JPanel contentPane;

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


	public Test2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	/**
	 * 0-0.333画一条直线
	 * 0.333-0.66画一个矩形
	 * 0.5-画一个椭圆
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Double d = Math.random();
		if(d<0.3333) {
			g.drawLine((int)(1000*d), (int)(1000*d), (int)(9999*d), (int)(9999*d));
		}else if(d<0.666) {
			g.drawRect((int)(100*d), (int)(100*d), (int)(999*d), (int)(999*d));
		}else {
			g.drawOval((int)(100*d), (int)(100*d), (int)(666*d), (int)(999*d));
		}
	}
	

}
