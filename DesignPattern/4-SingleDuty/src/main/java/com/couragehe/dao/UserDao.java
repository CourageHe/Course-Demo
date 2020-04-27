package com.couragehe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.couragehe.entity.User;
import com.couragehe.util.DBUtils;

public class UserDao {

	
	public User findUser(String userName,String password) {
		Connection conn = DBUtils.getConnection();
		String sql = "select * from tb_user where userName = ? and password = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, userName);
			pstm.setString(1, password);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				User user = new User();
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
