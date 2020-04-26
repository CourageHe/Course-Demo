package com.couragehe;
/*
 * 使用单线程进行矩阵乘法
 * 单线程即顺序运行该程序
 */
public class SingleThread {
	public static void TestSingle(int a[][],int b[][]){
		long start = System.currentTimeMillis();
		MatrixOperation.multiplyMatrix(a, b);
		long end= System.currentTimeMillis();
		System.out.print("单线程：");
		System.out.println(end-start+ " ms");
	}
}
