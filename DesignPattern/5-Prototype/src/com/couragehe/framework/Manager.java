package com.couragehe.framework;

import java.util.HashMap;

public class Manager {
	private HashMap<String,Product> showcase = new HashMap<String,Product>();
	public void register(String name,Product product) {
		showcase.put(name, product);
	}
	public Product create(String protoname){
		Product product  = showcase.get(protoname);
		return product.creatClone();
	}
	
}
