package com.couragehe.mssql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.couragehe.util.DBUtils;

public class MsSqlConnector {
	public static void main(String []args) throws SQLException {
		DBUtils.init("mssql.properties");
		Connection conn = DBUtils.getConnection();
		String sql = " select * from book";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		String title = null;
		String note = null;
		while(rs.next()){
			title = rs.getString("title");
			note = rs.getString("note");
			System.out.println("title:"+title+"\nstatus:"+ note+"\n");
		}
		System.out.println(conn);
		DBUtils.close(conn);
	}
}
