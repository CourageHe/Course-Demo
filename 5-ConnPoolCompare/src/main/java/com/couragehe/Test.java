package com.couragehe;

import org.openqa.selenium.WebDriver;

public class Test {

	public static void main(String[] args) {
				
		//单次连接
		long start = System.currentTimeMillis();
		WebDriver driver = MyConn.getWebDriver();
		driver.get("http://www.baidu.com");
		long end = System.currentTimeMillis();
		System.out.println(end-start+" ms");
	}

}
