package com.couragehe.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.json.XML;

import com.couragehe.xml.Train;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class WeatherXMl {
	//递归转换为XML
	public static void createWeatherXml(JsonObject json) throws DocumentException, IOException {
		XMLWriter xwrite = new XMLWriter(new FileOutputStream(new File("weather.xml")));
		Document document = DocumentHelper.createDocument();
		Element root =  document.addElement("root"); //默认根节点
		Element ee = toXml(json, root, null);
		System.out.println(document.asXML());
		xwrite.write(document);
		xwrite.close();
	}
	
	public static Element toXml(JsonElement jsonElement,Element parentElement,String name) {
		if(jsonElement instanceof JsonArray) {
			JsonArray sonJsonArray = (JsonArray)jsonElement;
			for(int i =0;i<sonJsonArray.size();i++) {
				JsonElement arrayElement = sonJsonArray.get(i);
				toXml(arrayElement,parentElement,name);
			}
		}else if(jsonElement instanceof JsonObject) {
			JsonObject sonJsonObject = (JsonObject) jsonElement;
			Element currentElement = null;
			if(name != null) {
				currentElement = parentElement.addElement(name);
			}
			Set<Entry<String,JsonElement>> set = sonJsonObject.entrySet();
			for(Entry<String,JsonElement> s: set) {
				toXml(s.getValue(),currentElement!=null?currentElement:parentElement,s.getKey());
			}
		}else {
			addAttribute(parentElement,name,jsonElement.getAsString());
		}
		return parentElement;
	}
	public static void addAttribute(Element element, String name, String value) {
		//增加子节点，并为子节点赋值
		Element el = element.addElement(name);
		el.addText(value);
	}
	
	public static void main(String[]args) throws DocumentException, IOException, Exception {
		(new WeatherXMl()).createWeatherXml(WeatherJSon.getWeatherData("北京"));
	}
}
