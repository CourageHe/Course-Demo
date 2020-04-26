package com.couragehe;

import java.util.Random;

class Initable{
	//编译器静态常量
	static final int staticFinal = 47;
	//非编译器静态常量
	static final int staticFinal2 = ClassInitialization.rand.nextInt();
	static {
		System.out.println("Initializing Initable");
	}
}
class Initable2{
	//编译器静态常量
	static  int staticNonFinal = 147;
	static {
		System.out.println("Initializing Initable2");
	}
}
class Initable3{
	//编译器静态常量
	static  int staticNonFinal = 74;
	static {
		System.out.println("Initializing Initable3");
	}
}
public class ClassInitialization {
	public static Random  rand = new Random(47);
	public static void main(String[]args) throws ClassNotFoundException {
		//字面常量获取方式获取Class对象
	    Class initable = Initable.class;
	    System.out.println("After creating Initable ref");
	    //不触发类初始化
	    System.out.println(Initable.staticFinal);
	    //会触发类初始化
	    System.out.println(Initable.staticFinal2);
	    //会触发类初始化
	    System.out.println(Initable2.staticNonFinal);
	    //forName方法获取Class对象
	    Class initable3 = Class.forName("com.couragehe.Initable3");
	    System.out.println("After creating Initable3 ref");
	    System.out.println(Initable3.staticNonFinal);
	}
}


//https://blog.csdn.net/javazejian/article/details/70768369
