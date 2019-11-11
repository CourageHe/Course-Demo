package com.couragehe.file;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import com.couragehe.util.GZipUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherJSon {
	
	private static String weatherUrl = "http://wthrcdn.etouch.cn/weather_mini?city=";
	/*
	 * 读取json文件
	 * 返回json对象
	 */
	public static JsonObject getWeatherData(String city) throws Exception {
		File file = getWeatherFile(weatherUrl+city);
		//读取文件的jar包 commons-io 
        Long filelength = file.length();  
        byte[] filecontent = new byte[filelength.intValue()];  
        FileInputStream in = new FileInputStream(file);  
        in.read(filecontent);  
        in.close();  
        String content = new String(filecontent,"utf-8");  
//		String content = FileUtils.readFileToString(file,"utf-8");
		JsonObject json = new JsonParser().parse(content).getAsJsonObject();
		System.out.println(json.getAsJsonObject("data"));
		file.delete();
		return json;
	}
	/*
	 * 爬取压缩（gzip）文件并解压
	 * 解压文件为weatherip
	 */
	public static File getWeatherFile(String targetUrl) throws Exception {
		URL url;
		url = new URL(targetUrl);
		File gzipFile = new File("weather.gzip");
		FileOutputStream fos = new FileOutputStream(gzipFile );
		DataInputStream	dis = new DataInputStream(url.openStream());
		byte[]bytes = new byte[1024];
		int length = 0;
		while((length = dis.read(bytes,0,bytes.length)) != -1) {
			fos.write(bytes,0,length);
			fos.flush();
		}
		fos.close();
		//解压并删除该文件
		GZipUtils.decompress(gzipFile , true);
		fixedFileName("weatherip","weather.json");
		return new File("weather.json");
	}
	
	/*
	 * 修改解压文件名称 为weather.json
	 */
	public static void fixedFileName(String filePath ,String newFileName) {
		File f = new File(filePath);
		if(!f.exists()) return;
		newFileName = newFileName.trim();
		//文件名不能为空
		if("".equals(newFileName) || newFileName == null)return;
//		String fileParentPath = f.getParent();
		File nf = new File(/*fileParentPath + File.pathSeparator+*/ newFileName);
		f.renameTo(nf);
	}
	/*
	 * 网页直接爬取
	 */
	public static String getPageData(String targetUrl) throws IOException {
			int i = 0;
			StringBuffer sb = new StringBuffer("");
			URL url;
			try {
				url = new URL(targetUrl);
				BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
				String s = "";
				while ((s = br.readLine()) != null) {
					i++;
					
					sb.append(s + "\r\n");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println(sb.toString());			
			return sb.toString();
	}

	public static void main(String []args) throws Exception {
		getWeatherData("北京");
	}
}
