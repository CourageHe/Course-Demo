package com.couragehe;
/**
 * 矩阵抽象方法类
 */
public abstract class GenericMatrix<E extends Number> {
	public abstract  E add(E e1, E e2);
	public abstract E multiply(E e1, E e2);
	public abstract E zero();
	public void print(E e[][]) {
		for(int i =0;i<e.length;i++) {
			for(int j =0;j<e[0].length;j++) {
				System.out.print(e[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public E[][] addMartix(E[][] e1,E[][] e2) {
		//e1的列数 不等于e2的行数则不可相乘
		if(e1.length != e2.length ||e1[0].length != e2[0].length )
			return null;
		E[][] e3= (E[][]) new Number[e1.length][e1[0].length];
		for(int i = 0;i<e1.length;i++) {
			for(int j = 0;j<e1[0].length;j++) {
				e3[i][j] = add(e1[i][j],e2[i][j]);
				System.out.print(e2[i][j]);
			}
		}
		return e3;	
	}
	public E[][] multipyMartix(E[][] e1,E[][] e2) {
		//e1的列数 不等于e2的行数则不可相乘
		if(e1[0].length != e2.length)
			return null;
		E[][] e3= (E[][]) new Number[e1.length][e2[0].length];
		for(int i = 0;i<e3.length;i++) {
			for(int j = 0;j<e3[0].length;j++) {
				for(int k = 0;k<e2[0].length;k++) {
					e3[i][j] = add(e3[i][j],multiply(e1[i][k],e2[k][j]));
				}
			}
		}
		return e3;	

	}
	/**
	 * 
	 * @param e1 参数矩阵1
	 * @param e2 参数矩阵2
	 * @param e3 结果矩阵
	 * @param operation 运算符
	 */
	public void  printResult(E[][] e1,E[][] e2,E [][]e3,char operation) {
		print(e1);
		System.out.println(operation);
		print(e2);
		System.out.println("=");
		print(e3);
	}
}
