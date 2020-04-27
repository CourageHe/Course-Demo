package com.couragehe;

public class Main {

	public static void main(String[] args) {
		System.out.println("Start");
		
		TricketMaker maker1 = TricketMaker.newInstance();
		TricketMaker maker2 = TricketMaker.newInstance();		
		if(maker1 == maker2) {
			System.out.println("两对象 地址相等");
		}else {
			System.out.println("两对象地址不等");
		}
		for (int i = 0; i < 5; i++) 
			System.out.println("maker1卖票号码："+maker1.getNextTicketNumber());
		
		for (int i = 0; i < 5; i++) 
			System.out.println("maker2卖票号码："+maker2.getNextTicketNumber());
			
	
	}

}
