package com.couragehe.staticproxy;
/**
 * 美团外卖小哥类
 * @author 52423
 *
 */
public interface Takeaway {
	/*
	 * 安排小哥出去送外卖了
	 */
	public void AddAway();
	/*
	 * 小哥外卖送到了
	 */
	public void ArriveAway();
	/*
	 * 货已被取，小哥任务完成等待接单
	 */
	public void SuccessAway();
}
