package edu.yangtzeu.lmis.dal;

import java.security.interfaces.RSAKey;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.yangtzeu.lmis.model.AbstractModel;
import edu.yangtzeu.lmis.model.DepartMentType;

public class DeptTypeDAL extends  AbstractDAL{

	@Override
	public AbstractModel[] getAllObjects() throws Exception {
		ArrayList<DepartMentType>objects = new ArrayList<DepartMentType>();
		ResultSet rs = SQLHelper.getResultSet("SELECT * FROM TB_DeptType",null);
		if(rs != null) {
			while (rs.next()) {
				DepartMentType dp = initDeptType(rs);
				objects .add(dp);
			}
			rs.close();
		}
		//列表转为数组实现动态装载
		DepartMentType[]types=new DepartMentType[objects.size()];
		objects.toArray(types);
		return types;
	}

	@Override
	public int add(AbstractModel object) throws Exception {
		if(object instanceof DepartMentType ==false) {
			throw new Exception("Can Only Handl DeptType");
		}
		DepartMentType dp = (DepartMentType)object;
		String  sql = "INSERT INTO TB_DeptType(dpType,dpTypeName)"
						+"VALUES(?,?,?,?,?,?,?)";
		Object[]params= new Object[7];
		params[0] = dp.getDpType();
		params[1] = dp.getDpTypeName();
		return SQLHelper.ExecSql(sql, params);
	}

	@Override
	public int delete(AbstractModel object) throws Exception {
		if(object instanceof DepartMentType ==false) {
			throw new Exception("Can Only Handl DeptType");
		}
		DepartMentType dp = (DepartMentType)object;
		String  sql = "DELETE FROM TB_DeptType WHERE dpType=?";
		Object[]params= new Object[] {dp.getDpType()};
		return SQLHelper.ExecSql(sql, params);
	}

	@Override
	public int update(AbstractModel object) throws Exception {
		if(object instanceof DepartMentType ==false) {
			throw new Exception("Can Only Handl DeptType");
		}
		DepartMentType dp = (DepartMentType)object;
		String  sql = "UPDATE TB_DeptType SET ,dpTypeName=? WHERE dpType=?";
		Object[]params= new Object[] {dp.getDpTypeName(),dp.getDpType()};
		
		return SQLHelper.ExecSql(sql, params);
	}

	@Override
	public AbstractModel getObjectByID(int dpType) throws Exception {
		DepartMentType dp = null;
		String sql = "SELECT dpType,dpTypeName FROM TB_DeptType WHERE dpType=?";
		Object[]params= new Object[]{ dpType};
		ResultSet rs = SQLHelper.getResultSet(sql,params);
		if(rs.next()) {
			dp = initDeptType(rs);
		}
		rs.close();
		return dp;
	}
	/**
	 * 初始化DeptType
	 * @param rs
	 * @return
	 * @throws SQLException 
	 */
	private DepartMentType initDeptType(ResultSet rs) throws SQLException {
		DepartMentType dp = new DepartMentType();
		dp.setDpType(rs.getInt("dpType"));
		dp.setDpTypeName(rs.getString("dpTypeName"));
		return dp;
	}
	@Override
	public String[] getPrettyColumnNames() throws Exception {
		return null;
	}

	@Override
	public String[] getMethodNames() throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}

}
