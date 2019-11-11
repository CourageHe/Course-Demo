package com.couragehe.stringbuilder;

public class StringDetail {
	public static void main(String[]args) {
		String a = "abc";
		String b = "abc";
		System.out.println(a==b);//true
		
		String c = new String("xyz");
		String d = new String("xyz");
		System.out.println(c==d);//false
		
		String e = "abcd";
		String f = "ab" + "cd";
		System.out.println(e==f);//true
	}
}
