package com.couragehe.staticproxy.Impl;

import com.couragehe.staticproxy.Takeaway;

/**
 * 美团外卖小哥类
 * @author 52423
 *
 */
public class TakeawayImpl implements Takeaway{
	private String name;//外卖小哥名字
	private int state;//外卖状态 0、空闲 1、途中 2、送达
	public TakeawayImpl(String name){
		this.name = name;
		this.state = 0;
	}
	
	/*
	 * 安排小哥出去送外卖了
	 */
	public void AddAway() {
		System.out.println("Takeaway.addAway()");
		System.out.println("安排小哥"+name+"出去送外卖了");
		this.state = 1;
	}
	/*
	 * 小哥外卖送到了
	 */
	public void ArriveAway() {
		System.out.println("Takeaway.ArriveAway()");
		System.out.println("小哥"+name+"外卖送到了");
		this.state = 2;
	}
	/*
	 * 货已被取，小哥任务完成等待接单
	 */
	public void SuccessAway() {
		System.out.println("Takeaway.SuceessAway()");
		System.out.println("货已被取，小哥"+name+"任务完成等待接单");
		this.state = 0;
	}
	
}
