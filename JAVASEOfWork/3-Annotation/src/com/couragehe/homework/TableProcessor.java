package com.couragehe.homework;

import java.io.File;
import java.util.List;


public class TableProcessor implements IProcessor{
	public String process(String url) {
		List<File> classFiles = Scanner.getClassFiles(url);
		StringBuilder sql = new StringBuilder();
		for(File file : classFiles) {
			Class<?> clazz = ClassFileLoader.loadClass(file);
			TableInfo table = (new TableInfo()).parse(clazz);
			if(table != null) 
				sql.append(table.toString());
		}
		return sql.toString();
	}
}
