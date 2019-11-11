package com.couragehe;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 一、自定义注解
 * 元注解	Java定义的用于创建注解的工具，他们本身也是注解。
 * @Target 表明了自定义的作用域，可能的定义域被定义在一个枚举类型中（ElementType）
 * @Retention 申明注解信息的保留策略，可选的级别被存放在美剧RetentionPolicy中
 * @Doucmentd 表明制作JavaDoc时，是否将注解信息加入文档。
 * @Inherited 表明注解是否会被子类继承，默认情况是不继承的。
 */

@Target(ElementType.TYPE)//作用在类、接口、枚举上
@Retention(RetentionPolicy.RUNTIME)//将会保留到运行时
@interface Entity{
	public int type()default -2;
	public String name();
}
/*
 * 在该类上使用了自定义注解@Entity，
 * 并并为该注解的name参数指明了Person,
 * 自定义的注释域Java定义的注释使用方法相同
 */
@Entity(name="person")
class Person{
	public void Speak(String Meassgae) {}
}
/*二、注解参数说明
 * 1、注解参数只能使用制定的类型，所有基本类型（byte short int long float double boolean char） 
 * 以及String Class，enum,Annotation的数组
 * 2、注解参数的赋值要求，参数不能是不确定值，
 * 要么在定义注解的时候进行赋值，要么在使用的时候赋值
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface ID{
	public String value();
	public String description()default"";
}
class Demo{
	//若注解含有参数value，隐式赋值，自动对value进行赋值
	@ID("PeronId")
	private Integer Id;
}

