package com.couragehe;

public abstract class Border extends Display{
	protected Display display;//表示被装饰物

	public Border(Display display) {
		this.display = display;
	}
	
	
}
