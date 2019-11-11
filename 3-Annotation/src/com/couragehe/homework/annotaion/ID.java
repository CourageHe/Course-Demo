package com.couragehe.homework.annotaion;
/**
 * 表示属性作为映射表的注解
 * @author 52423
 *
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ID {
	public String value() default"";
}
