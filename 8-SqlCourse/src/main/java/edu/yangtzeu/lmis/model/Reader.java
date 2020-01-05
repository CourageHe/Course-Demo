package edu.yangtzeu.lmis.model;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;

/**
 * 读者实体类
 * @author CourageHe
 * 参考：https://blog.csdn.net/xiangjun_28/article/details/6656244
 *
 */
public class Reader extends AbstractModel{
    private int rdID;
    private String rdName;
    private String rdSex;
    private int rdType;
    private int rdDept;
    private String rdPhone;
    private String rdEmail;
    private Date rdDateReg;
    private InputStream rdPhoto; //JDBC操作Image类型数据
    private String rdStatus;
    private int rdBorrowQty;
    private String rdPwd;
    private int rdAdminRoles;
    
    public Reader() {
    	
    }
	public int getRdID() {
		return rdID;
	}
	public void setRdID(int rdID) {
		this.rdID = rdID;
	}
	public String getRdName() {
		return rdName;
	}
	public void setRdName(String rdName) {
		this.rdName = rdName;
	}
	public String getRdSex() {
		return rdSex;
	}
	public void setRdSex(String rdSex) {
		this.rdSex = rdSex;
	}
	public int getRdType() {
		return rdType;
	}
	public void setRdType(int rdType) {
		this.rdType = rdType;
	}
	public int getRdDept() {
		return rdDept;
	}
	public void setRdDept(int rdDept) {
		this.rdDept = rdDept;
	}
	public String getRdPhone() {
		return rdPhone;
	}
	public void setRdPhone(String rdPhone) {
		this.rdPhone = rdPhone;
	}
	public String getRdEmail() {
		return rdEmail;
	}
	public void setRdEmail(String rdEmail) {
		this.rdEmail = rdEmail;
	}
	public Date getRdDateReg() {
		return rdDateReg;
	}
	public void setRdDateReg(Date rdDateReg) {
		this.rdDateReg = rdDateReg;
	}
	public InputStream getRdPhoto() {
		return rdPhoto;
	}
	public void setRdPhoto(InputStream rdPhoto) {
		this.rdPhoto = rdPhoto;
	}
	public String getRdStatus() {
		return rdStatus;
	}
	public void setRdStatus(String rdStatus) {
		this.rdStatus = rdStatus; 
	}
	public int getRdBorrowQty() {
		return rdBorrowQty;
	}
	public void setRdBorrowQty(int rdBorrowQty) {
		this.rdBorrowQty = rdBorrowQty;
	}
	public String getRdPwd() {
		return rdPwd;
	}
	public void setRdPwd(String rdPwd) {
		this.rdPwd = rdPwd;
	}
	public int getRdAdminRoles() {
		return rdAdminRoles;
	}
	//判断权限
	public void setRdAdminRoles(int rdAdminRoles) {
		this.rdAdminRoles = rdAdminRoles;
	}
	
	
	public boolean isReaderAdmin() {
//		return (this.rdAdminRoles & 1)>0;
		return true;
	}
	public boolean isBookAdmin() {
//		return (this.rdAdminRoles & 2)>0;
		return true;
	}
	public boolean isBorrowAdmin() {
//		return (this.rdAdminRoles & 4)>0;
		return true;
	}
	public boolean isSysAdmin() {
//		return (this.rdAdminRoles & 8)>0;
		return true;
	}
	
}
