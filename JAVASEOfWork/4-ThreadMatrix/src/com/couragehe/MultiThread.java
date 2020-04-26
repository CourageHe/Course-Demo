package com.couragehe;
/**
 * 使用多线程进行矩阵乘法
 * @author 52423
 *
 */
public class MultiThread implements Runnable{
	int a[][];
	int b[][];
	MultiThread (int a[][],int b[][]){
		this.a = a;
		this.b = b;
	}
	@Override
	public void run() {
		long start = System.currentTimeMillis();
		MatrixOperation.multiplyMatrix(a, b);
		long end= System.currentTimeMillis();
		System.out.print("多线程：");
		System.out.println(end-start+" ms");
	}
}
