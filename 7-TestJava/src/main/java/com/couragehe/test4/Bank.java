package com.couragehe.test4;
/**
 * 2. 设计一个银行帐户类，成员变量包括账号、
 * 储户姓名、开户时间、身份证号码、存款余额等帐户信息，
 * 成员方法包括存款、取款操作。
 * @author Couragehe
 *
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bank {
	private String accoutn;
	private String name;
	private Date date;
	private String cardId;
	private float money;
	
	public Bank(String accoutn, String name, Date date, String cardId, float money) {
		super();
		this.accoutn = accoutn;
		this.name = name;
		this.date = date;
		this.cardId = cardId;
		this.money = money;
	}
	/**
	 * 取款
	 * @param fmoney
	 * @return
	 */
	public float withdrawMoney(float fmoney) {
		System.out.println("取钱："+fmoney);
		money -= fmoney;
		return fmoney;
	}
	/**
	 * 存款
	 * @param fmoney
	 */
	public void saveMoney(float fmoney) {
		System.out.println("存钱："+fmoney);
		this.money += fmoney;
	}
	@Override
	public String toString() {
		return "Bank [accoutn=" + accoutn + ", name=" + name + ", date=" + date + ", cardId=" + cardId + ", money="
				+ money + "]";
	}
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat ssf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		Date date = ssf.parse("2010-10-10 18:33:22");
		Bank bank = new Bank("123456789", "何勇", date, "66666666", 4500.156f);
		bank.withdrawMoney(1000f);
		bank.saveMoney(1234f);
		System.out.println(bank);
	}
	
}
