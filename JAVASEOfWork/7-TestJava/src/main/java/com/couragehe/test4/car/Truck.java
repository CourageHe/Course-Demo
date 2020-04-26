package com.couragehe.test4.car;

public class Truck  extends Vehicle{
	//载重量
	private int payload;


	public Truck(int wheels, int weight, int payload) {
		super(wheels, weight);
		this.payload = payload;
	}

	public int getPayload() {
		return payload;
	}

	public void setPayload(int payload) {
		this.payload = payload;
	}

	@Override
	public void show() {
		// TODO 自动生成的方法存根
		super.show();
		System.out.println("载重量："+payload);
	}
	
	public static void main(String[]args) {
		Truck truck = new Truck(8, 3000, 5000);
		truck.show();
	}
	
}
