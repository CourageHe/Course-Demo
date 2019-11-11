package com.couragehe.test3;
/**
 * 创建一个图书类，类中包含的属性有：书名、作者、出版社；
 * 包含的方法有：设置书籍状态，查看书籍状态。书籍状态有在馆和外借两种
 * @author CourageHe
 *
 */
public class Book {
	private String name;
	private String authot;
	private String pree;//出版社
	private int state;//书籍状态：0 在馆 外借
	
	public Book(String name, String authot, String pree, int state) {
		super();
		this.name = name;
		this.authot = authot;
		this.pree = pree;
		this.state = state;
	}
	//查看书籍状态
	public int getState() {
		if(state == 0) {
			System.out.println(this.name +" 在馆");
			
		}else if(state == 1) {
			System.out.println(this.name +" 外借");
			
		}
		return state;
	}
	//设置书籍状态
	public void setState(int state) {
		this.state = state;
	}

	public static void main(String[] args) {
		Book book = new Book("Java编程思想","Bruce Eckel","机械工业出版社",0);
		book.setState(1);
		//查看状态
		book.getState();
	}

}
