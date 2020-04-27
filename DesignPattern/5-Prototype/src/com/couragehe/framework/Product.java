package com.couragehe.framework;

public interface Product extends Cloneable{
	public abstract void use(String s);
	public abstract Product creatClone();
}
