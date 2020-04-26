package com.couragehe.homework.test;

import com.couragehe.homework.TableProcessor;

public class AnnotationTest {
	public static void main(String[]args) {
		TableProcessor  processor = new TableProcessor();
		String sql = processor.process(System.getProperty("user.dir"));
		System.out.println(sql);
	}
}
