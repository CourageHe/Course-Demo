package com.couragehe.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.couragehe.util.DBUtils;

public class MySqlConnector {
	public static void main(String[]args) throws SQLException {
		DBUtils.init("mysql.properties");
		Connection conn = DBUtils.getConnection();
		String sql = " select cn_note_title,cn_note_status_id from cn_note";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		String title = null;
		int status = 0;
		while(rs.next()){
			title = rs.getString("cn_note_title");
			status = rs.getInt("cn_note_status_id");
			System.out.println("title:"+title+"\nstatus:"+ status);
		}
		System.out.println(conn);
		DBUtils.close(conn);
	}
}
