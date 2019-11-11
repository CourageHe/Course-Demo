package com.couragehe.homework.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于指明实体类中那些属性需要映射成数据库中的字段
 * @author 52423
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	public String value() default"";
	public boolean nullable() default true;
	public int length() default -1;
}
