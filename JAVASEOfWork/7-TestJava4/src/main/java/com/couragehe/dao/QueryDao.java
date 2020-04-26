package com.couragehe.dao;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class QueryDao {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	static {
		//读取properties文件 获取输入流
		Properties config = new Properties();
		InputStream in = QueryDao.class.getClassLoader().getResourceAsStream("db.properties");
		//获取配置信息
		try {
			config.load(in);
			driver = config.getProperty("driver");
			url = config.getProperty("url");
			username = config.getProperty("username");
			password = config.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		//配置jdbc链接数据库
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn) {
		if(conn !=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

	public static void main(String[]args) {
	
	}
}
