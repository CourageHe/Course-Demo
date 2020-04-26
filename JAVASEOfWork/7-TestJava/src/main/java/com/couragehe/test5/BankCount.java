package com.couragehe.test5;	//创建程序包
import java.util.*;    				  //引入程序包
class BankCount 				  //定义类
{	int id;
 	String name,date;
 	float money;
 	
 	public BankCount(int id, String name, String date, float money) {  //构造方法
 		//方法体
 		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.money = money;
	}
 	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "BankCount [id=" + id + ", name=" + name + ", date=" + date + ", money=" + money + "]";
	}
 	
}

