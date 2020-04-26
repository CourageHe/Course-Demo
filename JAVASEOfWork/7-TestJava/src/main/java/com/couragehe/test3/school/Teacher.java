package com.couragehe.test3.school;

public class Teacher extends Person {
	private String  positionaltitles;
	private String  department;
	public Teacher(String id, String name, String positionaltitles, String department) {
		super(id, name);
		this.positionaltitles = positionaltitles;
		this.department = department;
	}
	@Override
	public void Show() {
		// TODO 自动生成的方法存根
		super.Show();
		System.out.println("职称："+positionaltitles);
		System.out.println("部门："+ department);
	}
	
}
