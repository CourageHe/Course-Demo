package com.couragehe.jswing;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.couragehe.shape.Square;
import com.couragehe.shape.base.Shape;

import java.awt.event.MouseAdapter;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

public class DrawingJframe extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private Shape[]shapeParameter = new Shape[1000];

	/**
	 * Create the frame.
	 */
	public DrawingJframe() {
		setTitle("Drawing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//创建事件监听对象
		DrawListener dl = new DrawListener();
		//给画布添加监听器
		this.addMouseListener(dl);
		this.addMouseMotionListener(dl);
		
		//获取画笔
		Graphics g = this.getGraphics();
		//画笔传递
		dl.setG(g);
		dl.setShapeParameter(shapeParameter);
		
	}

	public void paint(Graphics g) {
		super.paint(g);
		//遍历图形数组，重绘图形
		for(int i =0;i<shapeParameter.length;i++) {
			if(shapeParameter[i] !=null) {
				Shape shape = shapeParameter[i];
				shape.Draw(g);
			}
			
		}		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingJframe frame = new DrawingJframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
