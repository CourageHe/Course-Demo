package edu.yangtzeu.lmis.bll;

import edu.yangtzeu.lmis.dal.ReaderTypeDAL;
import edu.yangtzeu.lmis.model.Reader;
import edu.yangtzeu.lmis.model.ReaderType;

public class ReaderTypeAdmin  extends LibraryBLL{
//	private ReaderTypeDAL dal;
	
	public ReaderTypeAdmin() {
		dal = new ReaderTypeDAL();
	}
	
	public ReaderType[] getReaderTypes() {
		try {
			return (ReaderType[])dal.getAllObjects();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	
	public ReaderType getObjectById(int id) {
		try {
			return (ReaderType)dal.getObjectByID(id);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateReaderType(ReaderType readerType) {
		try {
			dal.update(readerType);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void addReaderType(ReaderType readerType) {
		try {
			dal.add(readerType);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void delReaderType(ReaderType readerType) {
		try {
			dal.delete(readerType);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}

