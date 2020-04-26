package edu.yangtzeu.lmis.bll;

import edu.yangtzeu.lmis.dal.AbstractDAL;

public abstract class LibraryBLL{
	
	
	protected AbstractDAL dal;
	public String [] getDisplayColumnNames() {
		try {
			return dal.getPrettyColumnNames();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	public String[] getMethodNames() {
		try {
			return dal.getMethodNames();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	
}