package com.couragehe.test4.car;

public class Vehicle {
	private int wheels;
	private int weight;
	
	
	public Vehicle(int wheels, int weight) {
		super();
		this.wheels = wheels;
		this.weight = weight;
	}
	public int getWheels() {
		return wheels;
	}
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void show() {
		System.out.println("车轮个数："+wheels);
		System.out.println("重量："+weight);
	}
	
}
