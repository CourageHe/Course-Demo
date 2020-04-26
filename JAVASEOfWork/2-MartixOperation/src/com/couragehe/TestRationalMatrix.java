package com.couragehe;

public class TestRationalMatrix {
	public static void main(String[]args) {
		Double[][] e1 = new Double[][] { 
			{ 1.3, 2.4, 3.5 }, 
			{ 4.6, 5.7, 6.3 },
			{ 1.4, 1.7, 1.3 } };
		Double[][] e2 = new Double[][] { 
			{ 1.3, 1.8, 1.3 }, 
			{ 3.2, 2.8, 2.9 },
			{ 0.3, 1.2, 1.2 } };
		RationalMatrix rationalMatrix = new RationalMatrix();
//		Integer[][] e3 = (Integer[][])integerMatrix.addMartix(e2, e2);
		rationalMatrix .printResult(e1, e2, rationalMatrix.addMartix(e2, e2), '+');

		Double[][] e4 = rationalMatrix.multipyMartix(e1, e2);
		rationalMatrix .printResult(e1, e2, e4, 'X');
	}
}
