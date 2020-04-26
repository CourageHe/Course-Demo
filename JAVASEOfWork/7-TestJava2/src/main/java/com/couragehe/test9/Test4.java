package com.couragehe.test9;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Test4 extends JFrame{
	private static final long serialVersionUID = -3229434935585351686L;
	public void lauchFFrame(){
		setBounds(300,300,500,400);
		
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				setVisible(false);
				System.exit(0);
			}
		});
		
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				int x = e.getX();
				int y = e.getY();
				System.out.println("x:"+x+",y:"+y);
			}
		});
		setVisible(true);
	}
	
	/**
	 * 覆盖父类方法 自动调用
	 */
	public void paint(Graphics g){
		
		g.setColor(Color.blue);
		g.fillRect((500-100)/2, 80, 100, 100);
		g.drawOval((500-150)/2, 60, 150, 150);
		g.setColor(Color.RED);
		g.fillRect((500-300)/2,150,300,100);
		g.fillOval(90, 140, 20, 20);
		g.fillOval(390, 140, 20, 20);
		g.fillOval(90, 240, 20, 20);
		g.fillOval(390, 240, 20, 20);
		g.fillRect(90, 150, 10, 100);
		g.fillRect(400, 150, 10, 100);
		g.fillRect(100,140,300,10);
		g.fillRect(100,250,300,10);
		g.fillOval(140, 240, 60, 60);
		g.fillOval(300, 240, 60, 60);
		g.setColor(Color.BLACK);
		g.drawLine(50, 300, 450, 300);
		int xa[]= {50,144,99,50};
		int ya[]= {300,300,341,300};
		int xb[]= {143,190,246,143};
		int yb[]= {300,333,300,300};
		int xc[]= {247,297,349,247};
		int yc[]= {300,341,300,300};
		int xd[]= {350,388,450,350};
		int yd[]= {300,337,300,300};
		g.fillPolygon(xd, yd, 4);
		g.fillPolygon(xa, ya, 4);
		g.fillPolygon(xb,yb, 4);
		g.fillPolygon(xc,yc, 4);
	}
	public static void main(String args[]) {
		Test4 a=new Test4();
		a.lauchFFrame();
		
//		a.paint(b);
	}
		}
