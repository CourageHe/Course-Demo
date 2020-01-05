package edu.yangtzeu.lmis.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * AbstractDAL	抽象数据访问类，用于统一数据访问类的方法接口
 * @author CourageHeww
 *
 */
public abstract class AbstractModel {
	public Object getFieldValue(Class<?>objeClass,String methodName) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[]allMethods = objeClass.getDeclaredMethods();
		for(Method m:allMethods) {
			String mName = m.getName();
			if(mName.equals(methodName)) {
				return m.invoke(this, null);//反射执行方法
			}
		}
		return null
				;
	}
}
