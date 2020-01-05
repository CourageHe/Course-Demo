package edu.yangtzeu.lmis.dal;

import java.sql.SQLException;

import edu.yangtzeu.lmis.model.AbstractModel;
import edu.yangtzeu.lmis.model.DepartMentType;
import edu.yangtzeu.lmis.model.Reader;
import edu.yangtzeu.lmis.model.ReaderType;

public abstract class AbstractDAL {
	/**
	 * 获取该表中的所有记录(生成读者类型下拉列表和单位下拉列表时有用)
	 * @return
	 * @throws Exception
	 */
	public abstract AbstractModel[] getAllObjects() throws Exception;
	
	public abstract int add(AbstractModel object)throws Exception;
	
	public abstract int delete(AbstractModel object)throws Exception;
	
	public abstract int update(AbstractModel object)throws Exception;
	
	public abstract AbstractModel getObjectByID(int id)throws Exception;
	/**
	 * 用于实现实体类到UI组件JTable数据的转换，比如以列表形式显示查询得到的读者、借阅记录等
	 * @return
	 * @throws Exception
	 */
	public abstract String[] getPrettyColumnNames()throws Exception;
	
	public abstract String[] getMethodNames()throws Exception;
}
