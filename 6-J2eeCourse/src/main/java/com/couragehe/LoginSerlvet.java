package com.couragehe;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.couragehe.dao.UserDao;

public class LoginSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginSerlvet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String Dpassword= UserDao.findPassByName(username);
		System.out.println(username+":"+password);
		if(Dpassword=="") {
			System.out.println("该用户没有注册");
		}else if(Dpassword.equals(password)) {
			System.out.println("该用户注册成功");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			System.out.println("该用户密码错误");			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
