package com.couragehe;

import com.couragehe.factory.*;

public class Main {

	public static void main(String[] args) {
		Factory factory = Factory.getFactory("listfactory.ListFactory");
		
		Link people = factory.createLink("人民日报","http://www.people.com.cn/");
		Link gmw = factory.createLink("光明日报", "https://www.gmw.cn/");
		Tray traynews = factory.createTray("日报");
		traynews.add(people);
		traynews.add(gmw);
		
		
		Link us_yahoo = factory.createLink("Yahoo", "http://www.yahoo.com/");
		Link jp_yahoo = factory.createLink("Yahoo!Japan", "http://www.yahoo.co.jp/");
		Link baidu= factory.createLink("百度", "http://www.baidu.com");
		Link google= factory.createLink("Google", "http://www.google.com/");
		
	
		
		Tray trayYahoo= factory.createTray("Yahoo!");
		trayYahoo.add(us_yahoo);
		trayYahoo.add(jp_yahoo);
		
		Tray traySearch = factory.createTray("搜索引擎");
		traySearch.add(trayYahoo);
		traySearch.add(baidu);
		traySearch.add(google);
		
		Page page = factory.createPage("LinkPage", "CourageHe");
		page.add(traynews);
		page.add(traySearch);
		page.output();
	}

}
