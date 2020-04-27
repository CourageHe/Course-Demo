package com.couragehe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class BigChar {
	private char charName;
	private String fontData;
	
	public BigChar(char charName) {
		this.charName = charName;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("big"+charName+".txt"));
			String line;
			StringBuffer buffer = new StringBuffer();
			while ((line = reader.readLine())!= null) {
				buffer.append(line);
				buffer.append("\n");
			}
			reader.close();
			this.fontData = buffer.toString();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void print() {
		System.out.println(fontData);
	}
}
