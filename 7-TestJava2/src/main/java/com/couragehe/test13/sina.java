package com.couragehe.test13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class sina {
	public static  void saveSinaFile() {
		try {
			HttpClient client = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet("http://www.sina.com.cn");
			//添加请求头
			httpGet.addHeader("user-agent: ","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.87 Safari/537.36");
			//执行get方法
			HttpResponse response = client.execute(httpGet);
			//输出结果(以字符集utf-8)
			String result = EntityUtils.toString(response.getEntity(),"utf-8"); 
			//清除entity的缓存
			EntityUtils.consume(response.getEntity());
			
			File file = new File("sina.html");
			
			FileOutputStream fos =  new FileOutputStream(file);
			//以字符集为utf-8进行保存
			OutputStreamWriter  osw = new OutputStreamWriter(fos,"utf-8");
			PrintWriter pw = new PrintWriter(osw);
			pw.write(result);
			
			System.out.println(result);
			
			
//			URL url = new URL("http://www.sina.com.cn");
//			HttpURLConnection conn = (HttpURLConnection)url.openConnection(); 
//		    BufferedReader buffer = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		    StringBuffer sb = new StringBuffer();
//		    String line ="";
//		     while ( ( line  = buffer.readLine()) != null)
//		     {
//		    	 sb.append(line);
//		     }
//		     System.out.println(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[]args) {
		saveSinaFile();
	}
}
