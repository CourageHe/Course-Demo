package com.couragehe.test2;

import java.util.Scanner;

public class CalculateSquare {
	public static void calculateArea(int width,int height) {
		System.out.println ("长方形面积："+width*height);
		System.out.println ("长方形周长："+(width+height)*2);
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print ("长方形宽：");
		int width = s.nextInt();
		System.out.print ("长方形长：");
		int height = s.nextInt();
		s.close();
		calculateArea(width,height);
		
	}

}
