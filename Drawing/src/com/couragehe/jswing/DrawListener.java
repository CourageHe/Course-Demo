package com.couragehe.jswing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JDialog;

import com.couragehe.shape.Circle;
import com.couragehe.shape.Ellipse;
import com.couragehe.shape.Rectangle;
import com.couragehe.shape.Square;
import com.couragehe.shape.Text;
import com.couragehe.shape.Triangle;
import com.couragehe.shape.base.Shape;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawListener implements MouseListener, MouseMotionListener,ActionListener {
	private Shape shape;
	private Graphics g;
	private Shape[]shapeParameter;
	private int index = -1;
	
	
	public Shape[] getShapeParameter() {
		return shapeParameter;
	}
	//初始化图形数组
	public void setShapeParameter(Shape[] shapeParameter) {
		this.shapeParameter = shapeParameter;
	}
	
	public Graphics getG() {
		return g;
	}
	//初始化画笔
	public void setG(Graphics g) {
		this.g = g;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO 自动生成的方法存根

	}
	
	//按下鼠标
	@Override
	public void mouseClicked(MouseEvent e) {
		Point p = e.getPoint();
		if(e.getButton() == 1) {//鼠标点击左键
			DrawingJDialog dialog = new DrawingJDialog(p);
			dialog.setDialog(dialog);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
			System.out.println("图元类型：" + dialog.ShapeType);
			System.out.println("" + dialog.pointX0+dialog.pointY0+dialog.width0+dialog.BorderColor+dialog.BorderType+dialog.BorderWidth0+dialog.FillColor+dialog.FillType);
			
			switch(dialog.ShapeType) {
				case 0: shape = new Square(dialog.pointX0,dialog.pointY0,dialog.width0,dialog.BorderColor,dialog.BorderType,dialog.BorderWidth0,dialog.FillColor,dialog.FillType);
					//将正方形存入数组
					shapeParameter[++index] = shape;
					break;
				case 1: shape = new Rectangle(dialog.pointX0,dialog.pointY0,dialog.width0,dialog.height0,dialog.BorderColor,dialog.BorderType,dialog.BorderWidth0,dialog.FillColor,dialog.FillType);
					//将长方形存入数组
					shapeParameter[index++] = shape;
					dialog.dispose();
					break;
				case 2: shape = new Circle(dialog.pointX0,dialog.pointY0,dialog.width0,dialog.BorderColor,dialog.BorderType,dialog.BorderWidth0,dialog.FillColor,dialog.FillType);
					//将圆存入数组
					shapeParameter[index++] = shape;
					break;
				case 3: shape = new Ellipse(dialog.pointX0,dialog.pointY0,dialog.width0,dialog.height0,dialog.BorderColor,dialog.BorderType,dialog.BorderWidth0,dialog.FillColor,dialog.FillType);
					//将椭圆存入数组
					shapeParameter[index++] = shape;
					break;
				case 4: shape = new Triangle(dialog.pointX0,dialog.pointY0,dialog.width0,dialog.BorderColor,dialog.BorderType,dialog.BorderWidth0,dialog.FillColor,dialog.FillType);
					//将正三角形存入数组
					shapeParameter[index++] = shape;
					break;
				case 5: shape = new Text(dialog.pointX0,dialog.pointY0,dialog.width0,dialog.height0,"长江大学软件工程专业",dialog.BorderColor,dialog.BorderType,dialog.BorderWidth0,dialog.FillColor,dialog.FillType);
					//将文字存入数组
					shapeParameter[index++] = shape;
					break;
				default: System.out.println("图形选择错误！！！");break;
			}
			
		}else if(e.getButton() == 3) {//鼠标点击右键
			System.out.println("右键点击！！！");
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO 自动生成的方法存根

	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}

}
