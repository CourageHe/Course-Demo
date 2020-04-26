package com.couragehe.staticproxy;
/**
 * 	美团静态综合代理
 * @author 52423
 *
 */
public class MeituanProxy implements Comment,Takeaway {
	private Takeaway takeway;//外卖小哥
	private Comment comment;//肥宅评论
	
	MeituanProxy(Takeaway takeway,Comment comment){
		this.takeway = takeway;
		this.comment = comment;
	}
	/*
	 * 安排小哥出去送外卖了
	 */
	public void AddAway() {
		takeway.AddAway();
	}
	/*
	 * 小哥外卖送到了
	 */
	public void ArriveAway() {
		takeway.ArriveAway();
	}
	/*
	 * 货已被取，小哥任务完成等待接单
	 */
	public void SuccessAway() {
		takeway.SuccessAway();
	}
	/*
	 * 肥宅下订单，等待外卖
	 */
	public void StartOrder() {
		comment.StartOrder();
	}
	/*
	 * 废渣取回外卖，可以评论
	 */
	public void SuccessOrder() {
		comment.SuccessOrder();
	}
	/*
	 * 肥宅收取外卖，给出五星好评
	 */
	public void CommentOrder() {
		comment.CommentOrder();
	}
	
}
