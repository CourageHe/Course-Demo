package com.couragehe.test3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 3. 设计一个Birthday类，其成员变量有：year,month,day；
 * 提供构造方法、 * 输出Birthday对象值的方法和计算年龄的方法。
 * 编写程序测试这个类。
 * @author CourageHe
 *
 */
public class Birthday {
	private int  year;
	private int month;
	private int day;
	
	public Birthday(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	/**
	 * 将时间转化为日历计算
	 * Date类许多api渐渐开始废弃
	 */
	public void getAge() {
		//获取当前时间
		Calendar cal = Calendar.getInstance();
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow =cal.get(Calendar.MONTH);
		int dayNow = cal.get(Calendar.DAY_OF_MONTH);
		//整岁
		int age = yearNow-year;
		//如果月份小于等于生日月份
		if(monthNow<= month ){
			if(month == monthNow) {
				//如果日期小于等于生日日期
				if(dayNow<day)age--;
			}else {
				age--;
			}
		}
		
//		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
//		Date dateB =sdf.parse(year+"-"+month+"-"+day);
			
			System.out.println(age+"岁");
		
	}

	@Override
	public String  toString() {
		return "Birthday [year=" + year + ", month=" + month + ", day=" + day + "]";
	}

	public static void main(String[] args) {
		Birthday  b =new Birthday(1998, 6, 05);
		System.out.println(b);
		b.getAge();
	}

}
