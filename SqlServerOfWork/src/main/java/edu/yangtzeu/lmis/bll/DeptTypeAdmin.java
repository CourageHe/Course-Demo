package edu.yangtzeu.lmis.bll;

import edu.yangtzeu.lmis.dal.DeptTypeDAL;
import edu.yangtzeu.lmis.model.DepartMentType;
import edu.yangtzeu.lmis.model.ReaderType;

public class DeptTypeAdmin {
	private DeptTypeDAL dal = new DeptTypeDAL();
	
	public DepartMentType[] getDeptTypes() {
		try {
			return (DepartMentType[])dal.getAllObjects();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	
	public DepartMentType getObjectById(int id) {
		try {
			return (DepartMentType)dal.getObjectByID(id);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
}
