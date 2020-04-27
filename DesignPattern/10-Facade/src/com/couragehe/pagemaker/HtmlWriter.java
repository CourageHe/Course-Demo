package com.couragehe.pagemaker;

import java.io.IOException;
import java.io.Writer;

public class HtmlWriter {
	private Writer writer;
	
	public HtmlWriter(Writer writer) {
		this.writer  = writer;
	}
	public void title(String title) throws IOException {
		writer.write("<html><head><title>"+title+"</title></head><body>\n");
		writer.write("<h1>"+title+"</h1>\n");
	}
	public void paragraph(String msg) throws IOException {
		writer.write("<p>"+msg+"</p>");
	}
	public void link(String href,String caption) throws IOException {
		paragraph("<a href=\""+href+"\">"+caption+"</a>");
	}
	public void mailto(String mailAddr,String userName) throws IOException {
		link("mailto:"+mailAddr,userName);
	}
	public void close() throws IOException {
		writer.write("</body></html>\n");
		writer.close();
	}
}
