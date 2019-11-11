package com.couragehe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.couragehe.utils.DBUtils;

public class UserDao {
	
	public static String findPassByName(String username) {
		String sql = "select password from user where username= ?";
		Connection conn = DBUtils.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			String password ="";
			while(rs.next()) {
				password = rs.getString("password");
				
			}
			rs.close();
			return password;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn);			
		}
		return null;
	}
	public static void addUser(String username,String password) {
		String sql = "insert into user values (?,?)";
		Connection conn = DBUtils.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2,password);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn);			
		}
	}
	public static void main(String[]args) {
		addUser("CourageHe1","123456");
		String password = findPassByName("CourageH");
		System.out.println(password=="");
	}
}
