package com.couragehe.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
	private static String driver ;
	private static String url ;
	private static String username;
	private static String password ;
	//参数进行初始化
	public static void init(String path){
		Properties config = new Properties();
		InputStream in =  DBUtils.class.getClassLoader().getResourceAsStream(path);
		try {
			config.load(in);
			//初始化 连接参数
			driver = config.getProperty("jdbc.driver");
			url = config.getProperty("jdbc.url");
			username = config.getProperty("jdbc.username");
			password = config.getProperty("jdbc.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 封装数据库链接过程
	 * 简化数据库链接
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	/**
	 * 数据库链接关闭进行封装
	 * @param conn
	 */
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
