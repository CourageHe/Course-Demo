package com.couragehe.staticproxy;

import com.couragehe.staticproxy.Impl.CommentImpl;
import com.couragehe.staticproxy.Impl.TakeawayImpl;

/**
 * 客户端
 * @author 52423
 *
 */
public class Client {
	public static void main(String[]args) {
		//开启美团业务
		MeituanProxy meituan = new MeituanProxy(new TakeawayImpl("奥巴马"),new CommentImpl());
		//下达订单
		meituan.StartOrder();

		//安排外卖派送
		meituan.AddAway();
		//外卖送达
		meituan.ArriveAway();
		//外卖取走
		meituan.SuccessOrder();
		//外卖成功被取 
		meituan.SuccessAway();
		//开始评论
		meituan.CommentOrder();
		
	}
}
