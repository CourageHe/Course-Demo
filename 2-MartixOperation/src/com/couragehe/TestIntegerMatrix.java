package com.couragehe;

public class TestIntegerMatrix {
	public static void main(String[]args) {
		Integer[][] e1 = new Integer[][] { 
			{ 1, 2, 3 }, 
			{ 4, 5, 6 },
			{ 1, 1, 1 } };
		Integer[][] e2 = new Integer[][] { 
			{ 1, 1, 1 }, 
			{ 2, 2, 2 },
			{ 0, 0, 0 } };
		IntegerMatrix integerMatrix = new IntegerMatrix();
//		Integer[][] e3 = (Integer[][])integerMatrix.addMartix(e2, e2);
		integerMatrix.printResult(e1, e2, integerMatrix.addMartix(e2, e2), '+');

		Integer[][] e4 = integerMatrix.multipyMartix(e1, e2);
		integerMatrix.printResult(e1, e2, e4, 'X');

	}
}
