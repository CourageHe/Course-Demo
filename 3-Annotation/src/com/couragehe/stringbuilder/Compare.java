package com.couragehe.stringbuilder;

public class Compare {
	public static void compareString() {
		String str = "";
		long begin = System.currentTimeMillis();
		for(int i=0;i<999999;i++) {
			str = str + i;
		}
		long end = System.currentTimeMillis();
		System.out.println("String增加字符串用时："+(end-begin)/1000+"秒");
	
	}
	public static void compareStringBuilder() {
		StringBuilder builder= new StringBuilder("");
		long begin = System.currentTimeMillis();
		for(int i=0;i<9999999;i++) {
			builder.append(i);
		}
		long end = System.currentTimeMillis();
		System.out.println("StringBuilder增加字符串用时："+(end-begin)+"毫秒");
	
	}
	public static void compareStringBuffer() {
		StringBuffer buffer = new StringBuffer("");
		long begin = System.currentTimeMillis();
		for(int i=0;i<9999999;i++) {
			buffer.append(i);
		}
		long end = System.currentTimeMillis();
		System.out.println("StringBuffer增加字符串用时："+(end-begin)+"毫秒");
	
	}

	public static void main(String[] args) {
//		Compare.compareString(); //时间太长不足计算
		Compare.compareStringBuilder();//813
		Compare.compareStringBuffer();//1120
	}
}
