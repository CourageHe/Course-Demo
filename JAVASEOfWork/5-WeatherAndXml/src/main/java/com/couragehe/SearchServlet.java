package com.couragehe;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.couragehe.file.WeatherJSon;
import com.couragehe.file.WeatherXMl;
import com.couragehe.xml.Train;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchServlet() {
        super();
  }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String city = request.getParameter("city");
		try {
			WeatherXMl.createWeatherXml(WeatherJSon.getWeatherData(city));
			Train.TransformOperate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("search.html");
		
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
