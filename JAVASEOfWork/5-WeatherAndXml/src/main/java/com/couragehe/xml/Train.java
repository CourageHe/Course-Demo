package com.couragehe.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;



public class Train {
    public static  void TransformOperate()throws IOException {	
        String xmlFileName = "F:/java/CourseDemo/5-WeatherAndXml/weather.xml";
        String xslFileName = "F:/java/CourseDemo/5-WeatherAndXml/src/main/resources/weather.xsl";
        String htmlFileName = "F:/java/CourseDemo/5-WeatherAndXml/src/main/webapp/search.html";
        System.out.println("TransformOperate()");
        Train.Transform(xmlFileName, xslFileName, htmlFileName);
    }
    public static void main(String[]args) throws IOException {
    	
    	TransformOperate();
    }

    public static void Transform(String xmlFileName, String xslFileName,
            String htmlFileName) {
        try {
            TransformerFactory tFac = TransformerFactory.newInstance();
            Source xslSource = new StreamSource(xslFileName);
            Transformer t = tFac.newTransformer(xslSource);
            File xmlFile = new File(xmlFileName);
            File htmlFile = new File(htmlFileName);
            Source source = new StreamSource(xmlFile);
            Result result = new StreamResult(htmlFile);
//            System.out.println(result.toString());
            t.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
