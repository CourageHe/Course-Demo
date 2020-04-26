package com.couragehe.test13;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.function.BinaryOperator;

/**
 * 1． double型数组中保存有如下数据：1.23，69.88，34.45，67.98，2345.67。将数据以二进制形式保存到文件中去
 * @author CourageHe
 *
 */
public class Test1 {
	static double[] arr = {1.23,69.88,34.45,67.98,2345,67};
	public static void toBinarySave() throws IOException {
		File file = new File("binary.txt");
		FileOutputStream fos = new FileOutputStream(file);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		for(Double a : arr) {
			bw.write(doubletobinary(a));
		}
		bw.close();
		
	}
	//转化为二进制
	public static String doubletobinary(double a){
		return Long.toBinaryString(Double.doubleToLongBits(a));
	}
	public static void main(String[]args) throws IOException {
		toBinarySave();
	}
}

