package com.couragehe;

public class ThreaMain {

	public static void main(String[] args) {
		int a[][] = MatrixOperation.randomMatrix(1500);
		int b[][] = MatrixOperation.randomMatrix(1500);
		SingleThread.TestSingle(a, b);
		
		Thread t = new Thread(new MultiThread(a,b));
		t.start();
		
		ThreadPool.TestPool(a, b);
	}

}
