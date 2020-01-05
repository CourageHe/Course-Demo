package edu.yangtzeu.lmis.model.view;

import java.util.Date;

import edu.yangtzeu.lmis.model.AbstractModel;
/**
 * 借阅记录视图查看
 * @author CourageHe
 *
 */
public class BorrowView extends AbstractModel{
    private int BorrowID;	
	private int bkID;
	private String bkName;
    private String bkAuthor;
    //续借次数（第一次借时，记为0）
    private int ldContinueTimes;
    private Date ldDateOut;
    private Date ldDateRetPlan;
    private int ldOverDay;
    private float ldOverMoney;
	public int getBorrowID() {
		return BorrowID;
	}
	public void setBorrowID(int borrowID) {
		BorrowID = borrowID;
	}
	public int getBkID() {
		return bkID;
	}
	public void setBkID(int bkID) {
		this.bkID = bkID;
	}
	public String getBkName() {
		return bkName;
	}
	public void setBkName(String bkName) {
		this.bkName = bkName;
	}
	public String getBkAuthor() {
		return bkAuthor;
	}
	public void setBkAuthor(String bkAuthor) {
		this.bkAuthor = bkAuthor;
	}
	public int getLdContinueTimes() {
		return ldContinueTimes;
	}
	public void setLdContinueTimes(int ldContinueTimes) {
		this.ldContinueTimes = ldContinueTimes;
	}
	public Date getLdDateOut() {
		return ldDateOut;
	}
	public void setLdDateOut(Date ldDateOut) {
		this.ldDateOut = ldDateOut;
	}
	public Date getLdDateRetPlan() {
		return ldDateRetPlan;
	}
	public void setLdDateRetPlan(Date ldDateRetPlan) {
		this.ldDateRetPlan = ldDateRetPlan;
	}
	public int getLdOverDay() {
		return ldOverDay;
	}
	public void setLdOverDay(int ldOverDay) {
		this.ldOverDay = ldOverDay;
	}
	public float getLdOverMoney() {
		return ldOverMoney;
	}
	public void setLdOverMoney(float ldOverMoney) {
		this.ldOverMoney = ldOverMoney;
	}
	
	
}
