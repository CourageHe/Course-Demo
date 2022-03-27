package com.couragehe;

public class Main {

	public static void main(String[] args) {
		Support alice = new NoSupport("Alice") ;
		Support bob = new LimitSupport("Bob", 100);
		Support charlie = new SpecialSupport("charlie", 429);
		Support diana = new LimitSupport("Diana", 200);
		Support elmo = new OddSupport("Elmo");
		Support fred = new LimitSupport("Fred", 300);
		
		//形成职责链
		alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
		//制造各种问题
		for (int i = 0; i < 500; i++) {
			alice.support(new Trouble(i));
			
		}
	}

}
