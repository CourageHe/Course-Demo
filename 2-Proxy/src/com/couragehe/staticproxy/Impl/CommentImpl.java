package com.couragehe.staticproxy.Impl;

import com.couragehe.staticproxy.Comment;


/**
 * 美团外卖点评类
 * @author 52423
 *
 */
public class CommentImpl implements Comment{
	private int state;//肥宅收取外卖状态 0、无外卖  1、等待外卖  2、收取外卖
	public CommentImpl(){
		this.state = 0;
	}
	/*
	 * 肥宅下订单，等待外卖
	 */
	public void StartOrder() {
		System.out.println("Comment.StartOrder()");
		System.out.println("肥宅下订单，等待外卖");
		this.state = 1;
	}
	/*
	 * 废渣取回外卖，可以评论
	 */
	public void SuccessOrder() {
		System.out.println("Comment.SuccessOrder()");
		System.out.println("废渣取回外卖，可以评论");
		this.state = 2;
	}
	/*
	 * 肥宅收取外卖，给出五星好评
	 */
	public void CommentOrder() {
		System.out.println("Comment.CommentOrder()");
		if(state != 2) {
			System.out.println("肥宅偷懒没有取外卖，不能评论");			
		}
		System.out.println("肥宅收取外卖，给出五星好评");
		this.state = 0;
	}
}
