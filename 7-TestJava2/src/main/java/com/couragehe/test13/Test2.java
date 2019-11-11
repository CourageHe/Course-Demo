package com.couragehe.test13;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 2．编程将以上数据以可打印形式保存到文件中去。
 * @author CourageHe
 *
 */
public class Test2 {
	static double[] arr = {1.23,69.88,34.45,67.98,2345,67};
	public static void toStringSave() throws IOException {
		File file = new File("double.txt");
		FileOutputStream fos = new FileOutputStream(file);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		for(Double a : arr) {
			bw.write(a+" ");
		}
		bw.close();
		
	}
	public static void main(String[]args) throws IOException {
		toStringSave();
	}
}
