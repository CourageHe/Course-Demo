package test16;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mysql.jdbc.Driver;
import com.sun.corba.se.impl.legacy.connection.USLPort;
import com.sun.org.apache.bcel.internal.generic.RETURN;
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
	/**
	 * 根绝id查找所有的信息
	 * @param sid
	 * @return
	 */
	public static Score queryScoreBySid(String sid){
		Score s = new Score();
		
		String sql = "SELECT * FROM score WHERE sid='"+sid+"'";
		Connection conn = getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				s.setSid(rs.getString("sid"));
				s.setSname(rs.getString("sname"));
				s.setScore(rs.getInt("score"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	/**
	 * 查询所有的成绩信息
	 * @return
	 */
	public static List<Score> queryScoreByScore(){
		List<Score> list = new ArrayList<Score>();
		String sql = "SELECT * FROM score ORDER BY score";
		Connection conn = getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Score s = new Score();
				s.setSid(rs.getString("sid"));
				s.setSname(rs.getString("sname"));
				s.setScore(rs.getInt("score"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 查询不及格的成绩信息
	 * @return
	 */
	public static List<Score> queryFailByScore(){
		List<Score> list = new ArrayList<Score>();
		String sql = "SELECT * FROM score WHERE score < 60;";
		Connection conn = getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Score s = new Score();
				s.setSid(rs.getString("sid"));
				s.setSname(rs.getString("sname"));
				s.setScore(rs.getInt("score"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[]args) {
		queryFailByScore();
		queryScoreByScore();
		queryScoreBySid("123456");
	}
}
