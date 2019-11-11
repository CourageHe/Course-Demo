package com.couragehe.test2;
/**
 * 1.计算 Result=1!+2!+3!+…+10!
 * @author CourageHe
 *
 */
public class FactorialDemo {
	public static int factorialFun(int i) {
		int factorial = 1;
		for(int j = 1;j<=i;j++) {
			factorial *=j;
		}
		return factorial;
	}
	public static void main(String[]args) {
		int sum =0;
		for(int i=1;i<=10;i++) {
			sum +=factorialFun(i);
		}
		System.out.println(sum);
	}
}
