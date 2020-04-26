package com.couragehe.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


import com.couragehe.shape.base.Shape;

public class Triangle extends Shape {
	private static final long serialVersionUID = 1L;
	private int width;
	public Triangle(int x, int y, int w, Color bc, int bt,int bw, Color fc,int ft){
		super(x, y, bc, bt, bw, fc, ft);
		this.width = w;
	}

	@Override
	public void Draw(Graphics g) {
		super.Draw(g);
		System.out.println(x);
		g.setColor(bc);	
		g.drawLine(x, y, (int) (x-Math.cos(Math.PI/3)*width), (int) (y+Math.sin(Math.PI/3)*width));
		g.drawLine((int)(x-Math.cos(Math.PI/3)*width), (int)(y+Math.sin(Math.PI/3)*width),(int)(x+Math.cos(Math.PI/3)*width), (int)(y+Math.sin(Math.PI/3)*width));
		g.drawLine((int)(x+Math.cos(Math.PI/3)*width), (int)(y+Math.sin(Math.PI/3)*width), x, y);
		g.fillRect(fc.getAlpha(), fc.getRed(), fc.getGreen(), fc.getBlue());
	}

	@Override
	public boolean IsMatched(Point p) {
		// TODO 自动生成的方法存根
		return super.IsMatched(p);
	}

	@Override
	public void Serialize() {
		// TODO 自动生成的方法存根
		super.Serialize();
	}

}
