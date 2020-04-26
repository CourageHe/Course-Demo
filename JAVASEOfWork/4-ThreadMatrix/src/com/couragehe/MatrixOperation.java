package com.couragehe;

import java.util.Random;

public class MatrixOperation {
	public static int[][]randomMatrix(int i) {
		Random rand = new Random();
		int[][] a = new int[i][i];
		for(int j = 0;j < i;j++) {
			for(int k = 0;k < i;k++) {
				a[j][k] = (int)(rand.nextInt(10)+1);
			}
		}
		return a;
	}
	public static int[][]multiplyMatrix(int[][]a,int[][]b){
		int[][] c = new int[a.length][a.length];
		for(int i= 0;i < a.length;i++) {
			for(int j = 0;j< a.length;j++) {
				for(int k = 0;k < a.length;k++) {
					c[i][j] += a[i][k] * b[k][j] ;
				}
			}
		}
		return c;
	}
	public static void printMatrix(int[][]a) {
		for(int i= 0;i < a.length;i++) {
			for(int j = 0;j< a.length;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[]args) {
		int a[][] = MatrixOperation.randomMatrix(5);
		MatrixOperation.printMatrix(a);
		int b[][] = MatrixOperation.randomMatrix(5);
		MatrixOperation.printMatrix(b);
		int c[][] = MatrixOperation.multiplyMatrix(a, b);
		MatrixOperation.printMatrix(c);
	}
	
}
