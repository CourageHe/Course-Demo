package edu.yangtzeu.lmis.bll;

import java.sql.SQLException;

import edu.yangtzeu.lmis.dal.ReaderDAL;
import edu.yangtzeu.lmis.model.DepartMentType;
import edu.yangtzeu.lmis.model.Reader;
import edu.yangtzeu.lmis.model.ReaderType;

public class ReaderAdmin extends LibraryBLL{
//	private ReaderDAL dal;
	
	public ReaderAdmin() {
		dal= new ReaderDAL();
	}
	//系统根据借书证号获取读者对象
	public Reader getReader(int rdID) {
		try {
			return (Reader)dal.getObjectByID(rdID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public	Reader[]retrieveReaders(ReaderType rdType,DepartMentType deptType,String userName){
		try {
			//加强制类型转换 使用ReaderDalde 
			return ( (ReaderDAL) dal).getReadersBy(rdType,deptType,userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public int updateReader(Reader reader) {
		try {
			dal.update(reader);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 0;
	}
	public int addReader(Reader reader) {
		try {
			return dal.add(reader);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 0;
	}
}
