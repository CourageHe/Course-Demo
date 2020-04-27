package com.couragehe;

public class Main {

	public static void main(String[] args) {
		Display d1 = new Display(new StringDisplayImpl("Hello World!!!"));
		Display d2 = new Display(new StringDisplayImpl("Hello China!!!"));
		CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello HuBei!!!"));
		d1.display();
		d2.display();
		d3.display();
		
		d3.multiDisplay(5);
	}

}
