package com.couragehe.shape.base;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

enum ElementType { NOTSET, SQUARE, RECTANGLE, CIRCLE, ELLIPSE, TRIANGLE, TEXT };
public class Shape	extends JPanel{
	private static final long serialVersionUID = 1L;
	
	protected ElementType Type;//图元类型
	protected int x;//原点坐标
	protected int y;
	protected Color bc;//边界颜色
	protected int bt;//边界线型--实线、虚线、虚点线等
	protected int bw;//边界宽度
	protected Color  fc;//填充颜色
	protected int ft; //填充类型--实心、双对角、十字交叉等
	
	protected String BorderTypes[] = {"DASH", "DASHDOT", "SOLID"};
	public Shape(int x, int y, Color bc, int bt, int bw, Color fc, int ft) {
		super();
		this.x = x;
		this.y = y;
		this.bc = bc;
		this.bt = bt;
		this.bw = bw;
		this.fc = fc;
		this.ft = ft;
	}
	//绘制图元
	public void Draw(Graphics g) {
		
	}
	//点是否落在图形内部
	public  boolean IsMatched(Point p){
		
		return true;
	}
	
	public  void Serialize(){
		
	}
}
