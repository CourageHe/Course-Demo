package edu.yangtzeu.lmis.dal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * 对SQL Server数据库进行访问的通用类
 * @author CourageHe
 *
 */
public class SQLHelper {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	static {
		//读取properties文件 获取输入流
		Properties config = new Properties();
		InputStream in = SQLHelper.class.getClassLoader().getResourceAsStream("db.properties");
		//获取配置信息
		try {
			config.load(in);
			driver = config.getProperty("jdbc.driver");
			url = config.getProperty("jdbc.url");
			username = config.getProperty("jdbc.username");
			password = config.getProperty("jdbc.password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 打开数据库连接
	 * @return
	 */
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
	/**
	 * 关闭数据库连接
	 * @param conn
	 */
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
	 * 执行SQL语句，支持带image列的插入和修改SQL语句。
	 * @param sql sql语句
	 * @param params 参数数组
	 * @return 返回执行状态 int
	 * @throws SQLException 
	 */
	public static int ExecSql(String sql,Object[]params) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		int i = 1;
		for(Object param: params) {
			pstm.setObject(i, param);
			i++;			
		}
		return pstm.executeUpdate();
	}
	/**
	 * 执行存储过程
	 * @param sql
	 * @return
	 * @throws SQLException 
	 */
	public static ResultSet getResultSet(String sql,Object[]params) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		int i = 1;
		if(params != null) {	
			for(Object param: params) {
				pstm.setObject(i, param);
				i++;			
			}
		}
		ResultSet rs =pstm.executeQuery();
		return rs;
	}
	public static String formaDatetime(Date date) {
		SimpleDateFormat timeFormat=new SimpleDateFormat("yyyy-MM-dd");
		String times=timeFormat.format(date);
		return times;
	}
	public static Date parseDatetime(String datetimeSql) {
		SimpleDateFormat timeFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = timeFormat.parse(datetimeSql);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	public static byte[]read(InputStream inputStream) throws IOException {
		if(inputStream == null) return null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int num = inputStream.read(buffer);
            while (num != -1) {
                baos.write(buffer, 0, num);
                num = inputStream.read(buffer);
            }
            baos.flush();
            return baos.toByteArray();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
