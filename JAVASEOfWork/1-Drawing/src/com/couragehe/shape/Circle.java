package com.couragehe.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Line2D;

import com.couragehe.shape.base.Shape;

public class Circle extends Shape {
	private static final long serialVersionUID = 1L;
	private int radius;
	
	public Circle(int x, int y, int r, Color bc, int bt,int bw, Color fc,int ft){
		super(x, y, bc, bt, bw, fc, ft);
		this.radius = r;
	}

	@Override
	public void Draw(Graphics g) {
		super.Draw(g);
		System.out.println(x);
		g.setColor(bc);
		g.drawOval(x, y, radius, radius);
		g.fillOval(fc.getAlpha(), fc.getRed(), fc.getGreen(), fc.getBlue());
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
