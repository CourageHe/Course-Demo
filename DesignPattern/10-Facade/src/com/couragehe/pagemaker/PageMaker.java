package com.couragehe.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageMaker {
	private PageMaker() {
		
	}
	public static void makeWelcomPage(String mailAddr,String fileName) {
		try {
		Properties mailProp = Database.getProperties("maildata");
		String username = mailProp.getProperty(mailAddr);
		HtmlWriter writer = new HtmlWriter(new FileWriter(fileName));
		writer.title("Welcome to "+username+"'s page!");
	
		writer.paragraph(username+"欢迎来到"+username+"的主页");

		writer.paragraph("等着你的邮件哦！！！");
		writer.mailto(mailAddr, username);
		writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
