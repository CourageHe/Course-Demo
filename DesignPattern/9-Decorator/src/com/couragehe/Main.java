package com.couragehe;

public class Main {

	public static void main(String[] args) {
		Display d1 = new StringDisplay("Hello World");
		Display d2 = new SlideBorder(d1,'#');
		Display d3 = new FullBorder(d2);
		
		d1.show();
		d2.show();
		d3.show();
		
		Display d4 = new SlideBorder(
						new FullBorder(
							new FullBorder(
								new SlideBorder(
									new FullBorder(
										new StringDisplay("Hello World")
									),
								'*')
							)
						),
					'/');
		d4.show();
		
	}

}
