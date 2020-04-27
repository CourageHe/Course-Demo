package com.couragehe;

/*
 * 请求者
 */
public class Main {

	public static void main(String[] args) {
		Print print = new PrintBanner("Hello");
		print.printWeak();
		print.printStrong();

	}

}
