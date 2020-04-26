package com.couragehe.test3.school;

public class Student extends Person{
//	private String id;
//	private String name;
	private String classId;
	private String mark;

	public Student(String id, String name, String classId, String mark) {
		super(id, name);
		this.classId = classId;
		this.mark = mark;
	}

	@Override
	public void Show() {
		super.Show();
		System.out.println("班号："+classId);
		System.out.println("成绩："+mark);
	}
	
	
	
}
