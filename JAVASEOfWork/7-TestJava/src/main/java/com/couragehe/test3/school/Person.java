package com.couragehe.test3.school;

public class Person {
	private String id;
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}

	private String name;
	
	public void Show() {
		System.out.println("编号："+id);
		System.out.println("姓名："+name);
	}
	
}
