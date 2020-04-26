package edu.yangtzeu.lmis.model;

import edu.yangtzeu.lmis.bll.DeptTypeAdmin;

public class DepartMentType extends AbstractModel {
	private int dpType;
	private String dpTypeName;
	public int getDpType() {
		return dpType;
	}
	public void setDpType(int dpType) {
		this.dpType = dpType;
	}
	public String getDpTypeName() {
		return dpTypeName;
	}
	public void setDpTypeName(String dpTypeName) {
		this.dpTypeName = dpTypeName;
	}
	
	@Override
	public String toString() {
		return getDpTypeName();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof DepartMentType) {
			DepartMentType dp= (DepartMentType) obj;
			return this.dpType == dp.dpType;
			
		}
		return false;
	}
	
}
