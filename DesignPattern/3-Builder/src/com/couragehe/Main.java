package com.couragehe;

public class Main {

	public static void main(String[] args) {
//		Builder builder = new TextBuilder();
		Builder builder = new HTMLBuilder();
		Director director = new Director(builder);
		director.construct();
		String result = builder.getResult();
		System.out.println(result);

	}

}
