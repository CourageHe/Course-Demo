package com.couragehe.listfactory;

import java.util.Iterator;

import com.couragehe.factory.*;

public class ListPage extends Page {



	public ListPage(String title, String author) {
		super(title, author);
	}

	@Override
	public String makeHTML() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<html><head><title>"+title+"</title></head>\n");
		buffer.append("<body>\n");
		
		buffer.append("<h1>"+title+"</h1>\n");
		buffer.append("<ul>");
		Iterator it = content.iterator();
		while (it.hasNext()) {
			Item item = (Item) it.next();
			buffer.append(item.makeHTML());
		}
		buffer.append("</ul>");
		buffer.append("<hr><address>"+author+"</address>");
		buffer.append("</body></html>\n");
		return buffer.toString();
	}

}
