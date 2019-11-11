package com.couragehe;
/**
 * 整数矩阵实现加乘
 */
public class IntegerMatrix extends GenericMatrix<Integer> {

	@Override
	public Integer add(Integer e1, Integer e2) {
		return e1+e2;
		
	}

	@Override
	public Integer multiply(Integer e1, Integer e2) {
		return e1*e2;
		
	}

	@Override
	public Integer zero() {
		return 0;
		
	}
}
