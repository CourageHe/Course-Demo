package com.couragehe.listfactory;

import com.couragehe.factory.*;

public class ListFactory extends Factory {

	public ListFactory() {
		// TODO 自动生成的构造函数存根
	}

	@Override
	public Link createLink(String caption, String url) {
		// TODO 自动生成的方法存根
		return new ListLink(caption, url);
	}

	@Override
	public Tray createTray(String caption) {
		// TODO 自动生成的方法存根
		return new ListTray(caption);
	}

	@Override
	public Page createPage(String title, String author) {
		// TODO 自动生成的方法存根
		return new ListPage(title, author);
	}

}
