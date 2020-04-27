package com.couragehe;

public class TricketMaker {
	private static TricketMaker maker = new TricketMaker();
	private int ticket = 1000;
	private TricketMaker() {}
	
	public static TricketMaker newInstance() {
		return maker;
	}
	
	public int getNextTicketNumber() {
		return ticket++;
	}
}
