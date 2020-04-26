package edu.yangtzeu.lmis.model;

import java.io.InputStream;
import java.util.Date;
/**
 * 图书实体类
 * @author CourageHe
 *
 */
public class Book extends AbstractModel{
	
	
    private int bkID;
    private String bkCode;
    private String bkName;
    private String bkAuthor;
    private String bkPress;
    private Date bkDatePress;
    private String bkISBN;
    private String bkCatalog;
    //语言，0-中文，1-英文，2-日文，3-俄文，4-德文，5-法文
    private int bkLanguage;
    private int bkPages;
    private float bkPrice;
    private Date bkDateIn;
    private String bkBrief;
    //	图书封面照片
    private InputStream bkCover;
    //图书状态，在馆、借出、遗失、变卖、销毁
    private String bkStatus;
    public Book () {
    	
    }
	public int getBkID() {
		return bkID;
	}
	public void setBkID(int bkID) {
		this.bkID = bkID;
	}
	public String getBkCode() {
		return bkCode;
	}
	public void setBkCode(String bkCode) {
		this.bkCode = bkCode;
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
	public String getBkPress() {
		return bkPress;
	}
	public void setBkPress(String bkPress) {
		this.bkPress = bkPress;
	}
	public Date getBkDatePress() {
		return bkDatePress;
	}
	public void setBkDatePress(Date bkDatePress) {
		this.bkDatePress = bkDatePress;
	}
	public String getBkISBN() {
		return bkISBN;
	}
	public void setBkISBN(String bkISBN) {
		this.bkISBN = bkISBN;
	}
	public String getBkCatalog() {
		return bkCatalog;
	}
	public void setBkCatalog(String bkCatalog) {
		this.bkCatalog = bkCatalog;
	}
	public int getBkLanguage() {
		return bkLanguage;
	}
	public void setBkLanguage(int bkLanguage) {
		this.bkLanguage = bkLanguage;
	}
	public int getBkPages() {
		return bkPages;
	}
	public void setBkPages(int bkPages) {
		this.bkPages = bkPages;
	}
	public float getBkPrice() {
		return bkPrice;
	}
	public void setBkPrice(float bkPrice) {
		this.bkPrice = bkPrice;
	}
	public Date getBkDateIn() {
		return bkDateIn;
	}
	public void setBkDateIn(Date bkDateIn) {
		this.bkDateIn = bkDateIn;
	}
	public String getBkBrief() {
		return bkBrief;
	}
	public void setBkBrief(String bkBrief) {
		this.bkBrief = bkBrief;
	}
	public InputStream getBkCover() {
		return bkCover;
	}
	public void setBkCover(InputStream bkCover) {
		this.bkCover = bkCover;
	}
	public String getBkStatus() {
		return bkStatus;
	}
	public void setBkStatus(String bkStatus) {
		this.bkStatus = bkStatus;
	}
	    
}
