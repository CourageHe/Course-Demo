package com.couragehe;
/*
 * 被适配
 */
public class Banner {
	private String string;

	public Banner(String string) {
		this.string = string;
	}
	
	public void showWithParen() {
		System.out.println("("+string+")");
	}
	public void showWithAsterisk() {
		System.out.println("*"+string+"*");
	}
	
}
