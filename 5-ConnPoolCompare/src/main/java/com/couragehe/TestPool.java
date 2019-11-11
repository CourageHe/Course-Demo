package com.couragehe;

import org.openqa.selenium.WebDriver;

public class TestPool {

	public static void main(String[] args) {
		//先用连接池]
		long start = System.currentTimeMillis();
		for(int i=0;i<300;i++) {
			MyConn conn = ConnPoolUtils.getInstance().getMyConn();
			WebDriver driver = conn.getDriver();
			ConnPoolUtils.getInstance().setFree(conn);
			System.out.println(ConnPoolUtils.getInstance());
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start+" ms");
		ConnPoolUtils.getInstance().closeAllDriver();
		
		//单次连接
		start = System.currentTimeMillis();
		for(int i=0;i<10;i++) {
			WebDriver driver2 = MyConn.getWebDriver();
			driver2.close();
		}
		end = System.currentTimeMillis();
		System.out.println(end-start+" ms");
	}

}
