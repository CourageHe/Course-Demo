package com.couragehe;
/*
 * 表示发生问题的类
 */
public class Trouble {
	private int number;
	public Trouble(int number) { 
		this.number = number;
	}
	public int getNumber() {
		return number;
	}
	@Override
	public String toString() {
		return "Trouble [number=" + number + "]";
	}
	
}
