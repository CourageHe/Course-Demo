package com.couragehe.dynamicproxy;

import com.couragehe.staticproxy.Comment;
import com.couragehe.staticproxy.Takeaway;
import com.couragehe.staticproxy.Impl.CommentImpl;
import com.couragehe.staticproxy.Impl.TakeawayImpl;

public class Client {
	public static void main(String[]args) {
		MeituanDynaProxy proxy1 = new MeituanDynaProxy();
		MeituanDynaProxy proxy2 = new MeituanDynaProxy();
		Comment comment = (Comment)proxy1.newProxyInstance(new CommentImpl());
		Takeaway takeway = (Takeaway) proxy2.newProxyInstance(new TakeawayImpl("奥巴马"));
		comment.StartOrder();
		takeway.AddAway();
		takeway.ArriveAway();
		comment.SuccessOrder();
		takeway.SuccessAway();
		comment.CommentOrder();
	}
	
	
	
	
	
	
	
	
}
