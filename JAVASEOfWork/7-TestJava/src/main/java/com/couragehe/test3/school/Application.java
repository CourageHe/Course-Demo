package com.couragehe.test3.school;
/**
 * 4．（选作）编写一个学生和教师数据输入和显示程序，
 * 学生数据有编号、姓名、班号和成绩，教师数据有编号、姓名、职称和部门。
 * 要求将编号、姓名输入和显示设计成一个类Person,
 * 并作为学生数据操作类Student和教师数据操作类Teacher的基类。
 * @author CourageHe
 *
 */
public class Application {

	public static void main(String[] args) {
		Teacher teacher = new Teacher("123", "向华", "大学教师", "计科");
		teacher.Show();
		
		Student student = new Student("201702991", "何勇", "11701", "90");
		student.Show();
	}

}
