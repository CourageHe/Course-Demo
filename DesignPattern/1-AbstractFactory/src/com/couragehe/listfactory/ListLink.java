package com.couragehe.listfactory;

import com.couragehe.factory.*;

public class ListLink extends Link {

	public ListLink(String caption, String url) {
		super(caption, url);
	}
 
	@Override
	public String makeHTML() {
		return "<li><a hreg=\""+ url +"\">"+caption+"</a></li>\n";
	}

}
