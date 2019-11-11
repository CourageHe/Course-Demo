package com.couragehe;
/**
 * 实数矩阵实现加乘
 */
public class RationalMatrix extends GenericMatrix<Double> {

	@Override
	public Double add(Double e1, Double e2) {
		return e1+e2;
		
	}

	@Override
	public Double multiply(Double e1, Double e2) {
		return e1*e2;
		
	}

	@Override
	public Double zero() {
		return new Double(0);
		
	}

}
