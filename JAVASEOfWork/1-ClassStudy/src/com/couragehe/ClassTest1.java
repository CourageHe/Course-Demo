package com.couragehe;
/**
 * Candy Gum Cookie 都存在一个static语句，
 * 这个语句会在类第一次被加载时执行，作用就是告诉该类什么时候加载
 * 
 * Class类的获取方法
 * @author 52423
 *
 */
class Candy{
	static {
		System.out.println("Loading Candy");
	}
}
class Gum{
	static {
		System.out.println("Loading Gum");
	}
}
class Cookie{
	static {
		System.out.println("Loading Cookie");
	}
}

public class ClassTest1 {
	public static void print(Object obj) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println(obj);

	}
	public static void main(String[]args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		print("inside main");
		//一、new 一个Candy对象和Cookie对象，构造函数将被调用，
		//属于静态方法的引用
//		new Candy() ;
		System.out.println(new Candy().getClass());
		print("After creating Candy");
//		try {
//			//forName 方法时Class类的一个static成员方法，
//			//与new相比好处是无需通过持有该类的实例对象引用而去获取Class对象
//			//所有的Class对象都源于这个Class类，因此Class中定义的方法
//			//将适应所有的Class对象
//			Class.forName("com.couragehe.Gum");
//		} catch (ClassNotFoundException e) {
//			//编译器无法检测传递的字符串对应的类是否存在，
//			//只能程序运行时检测，如不存在，则派出ClssNotFoundException
//			print("Couldn't find Gum");
//			e.printStackTrace();
//		}
//		print("After Class.forName(\"com.couragehe.Gum\");");
		
		
		try{
		      //二、通过Class.forName获取Gum类的Class对象
		      Class clazz=Class.forName("com.couragehe.Gum");
		      System.out.println("forName=clazz:"+clazz.getName());
		    }catch (ClassNotFoundException e){
		      e.printStackTrace();
		    }

		    //通过实例对象获取Gum的Class对象
			//之前已被加载，不再加载static方法
		    Gum gum = new Gum();
		    Class clazz2=gum.getClass();
		    System.out.println("new=clazz2:"+clazz2.getName());
		    
	
//		    class1 = ClassTest1.class.getClassLoader().loadClass("com.couragehe.Cookie");
//		    Object Dog = class1.newInstance();
		}
}
