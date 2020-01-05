package edu.yangtzeu.lmis.model;

import java.util.Date;
/**
 * 借阅记录实体类
 * @author CourageHe
 *
 */
public class Borrow extends AbstractModel{
    private int BorrowID;	
	private int rdID;
    private int bkID;
    //续借次数（第一次借时，记为0）
    private int ldContinueTimes;
    private Date ldDateOut;
    private Date ldDateRetPlan;
    private Date ldDateRetAct;
    private int ldOverDay;
    private float ldOverMoney;
    private float  ldPunishMoney;
   // 是否已经还书，缺省为0-未还
    boolean isHasReturn;
    private String OperatorLend;
	private String OperatorRet;
	
	public Borrow() {
		
	}

	public int getBorrowID() {
		return BorrowID;
	}

	public void setBorrowID(int borrowID) {
		BorrowID = borrowID;
	}

	public int getRdID() {
		return rdID;
	}

	public void setRdID(int rdID) {
		this.rdID = rdID;
	}

	public int getBkID() {
		return bkID;
	}

	public void setBkID(int bkID) {
		this.bkID = bkID;
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

	public Date getLdDateRetAct() {
		return ldDateRetAct;
	}

	public void setLdDateRetAct(Date ldDateRetAct) {
		this.ldDateRetAct = ldDateRetAct;
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

	public float getLdPunishMoney() {
		return ldPunishMoney;
	}

	public void setLdPunishMoney(float ldPunishMoney) {
		this.ldPunishMoney = ldPunishMoney;
	}

	public boolean getIsHasReturn() {
		return isHasReturn;
	}

	public void setIsHasReturn(boolean isHasReturn) {
		this.isHasReturn = isHasReturn;
	}

	public String getOperatorLend() {
		return OperatorLend;
	}

	public void setOperatorLend(String operatorLend) {
		OperatorLend = operatorLend;
	}

	public String getOperatorRet() {
		return OperatorRet;
	}

	public void setOperatorRet(String operatorRet) {
		OperatorRet = operatorRet;
	}
	
}
