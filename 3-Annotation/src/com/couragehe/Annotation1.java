package com.couragehe;
/**
 * Java常用注解
 * @Override 表示当前方法将覆盖弗雷德同名、同参数方法，如果定义的
 * 方法在父类中不存在，编译器将会提示 must override or implements method错误
 * 
 * @SuppressWarnings 关闭无需关心的警告信息，该注解可用于整个类上，也可以用于方法上。（JDK5之后才起作用）
 * 
 * @Deprecated 使用该注解来声明方法或类已过时。
 * 
 * @author CourageHe
 *
 */
/*
 * 1、在方法上使用该注解
 * @Deprecated表示该类已过时，不建议使用该类
 */
@Deprecated
abstract class Annotation1{
	//2、在方法上使用注解
	@Deprecated
	public void speak() {}
	//3、在属性上使用注解
	@Deprecated
	public String name;
	//4、为注解设置参数
	@SuppressWarnings(value="unused")
	private String nick;

	
}
