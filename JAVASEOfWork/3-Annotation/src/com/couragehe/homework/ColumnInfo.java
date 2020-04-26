package com.couragehe.homework;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.couragehe.homework.annotaion.Column;
import com.couragehe.homework.annotaion.ID;

public class ColumnInfo {
	private String columnName;
	private Class<?> type;
	private boolean isID=false;
	private boolean  nullable = true;
	private boolean needPersist = false;
	private int length = 32;
	/*
	 * 根据属性描述对象Field,解析字段信息
	 * 其解析的流程如下：
	 * 1.获取Field对象的名称，作为字段名名称
	 * 2.获取Fiel对象的类型，作为字段的类型
	 * 3.获取改属性上声明的注解集合，并便利这些注解
	 * 4.如果竹节式@Column，则表明该属性应映射成数据库中的字段
	 * 5.如果注解式@ID,则表明该属性作为数据库中表的主键
	 * 6.判读那属性是否需要持久化，如需要返回解析后的字段信息对象，否则返回null
	 */
	public ColumnInfo Parse(Field field) {
			this.columnName = field.getName();
			this.type = field.getType();
			Annotation[] annotations= field.getAnnotations();
			for(Annotation annotation: annotations) {
				if(annotation.annotationType().equals(Column.class)) {
					this.needPersist = true;
					Column  column = (Column)annotation;
					if(!column.value().equals("")) {
						//若value不为空，则将字段名设置成注解 value的参数值
						this.columnName = column.value();
						this.nullable = column.nullable();
						if(column.length()!=-1) {
							this.length = column.length();
						}
					}else if(annotation.annotationType().equals(ID.class)) {
						this.needPersist= true;
						ID id = (ID)annotation;
						this.isID = true;
						if(!id.value().equals("")) {
							//若用户设置了value,则以value作为字段名
							this.columnName= id.value();
						}
					}
				}
			}
			if(this.needPersist) {
				return this;
			}else {
				return null;
			}
	}
	@Override
	public String toString() {
		StringBuilder sql = new StringBuilder(columnName);
		if(this.type.equals(String.class)) {
			sql.append(Symbol.BLANK+"VARCHAR("+this.length+")");			
		}else if(this.type.equals(Integer.class)) {
			sql.append(Symbol.BLANK+"INT");
		}
		if(this.isID) {
			sql.append(Symbol.BLANK+"PRIMARY KEY");		
		}
		if(!this.nullable) {
			sql.append(Symbol.BLANK+"NOT NULL");
		}
		sql.append(";");
		return sql.toString();
	}
}
