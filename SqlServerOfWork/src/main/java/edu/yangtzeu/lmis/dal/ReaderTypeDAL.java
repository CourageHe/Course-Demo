package edu.yangtzeu.lmis.dal;

import java.security.interfaces.RSAKey;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.yangtzeu.lmis.model.AbstractModel;
import edu.yangtzeu.lmis.model.ReaderType;

public class ReaderTypeDAL extends  AbstractDAL{

	private String[]dispColNames = new String[] {"ID","读者类型","可借数量","可借天数","可续借次数","罚金率","证件有效期"};
	private String[] methodNames = new String[] {"getRdType","getRdTypeName","getCanLendQty","getCanLendDay","getCanContinueTimes","getPunishRate","getDateValid"};

	@Override
	public AbstractModel[] getAllObjects() throws Exception {
		ArrayList<ReaderType>objects = new ArrayList<ReaderType>();
		ResultSet rs = SQLHelper.getResultSet("SELECT * FROM TB_ReaderType",null);
		if(rs != null) {
			while (rs.next()) {
				ReaderType rt = initReaderType(rs);
				objects .add(rt);
			}
			rs.close();
		}
		//列表转为数组实现动态装载
		ReaderType[]types=new ReaderType[objects.size()];
		objects.toArray(types);
		return types;
	}

	@Override
	public int add(AbstractModel object) throws Exception {
		if(object instanceof ReaderType ==false) {
			throw new Exception("Can Only Handl ReaderType");
		}
		ReaderType rt = (ReaderType)object;
		String  sql = "INSERT INTO TB_ReaderType(rdTypeName,CanLendQty,CanLendDay,CanContinueTimes,PunishRate,DateValid)"
						+"VALUES(?,?,?,?,?,?)";
		Object[]params= new Object[6];
		params[0] = rt.getRdTypeName();
		params[1] = rt.getCanLendQty();
		params[2] = rt.getCanLendDay();
		params[3] = rt.getCanContinueTimes();
		params[4] = rt.getPunishRate();
		params[5] = rt.getDateValid();
		return SQLHelper.ExecSql(sql, params);
	}

	@Override
	public int delete(AbstractModel object) throws Exception {
		if(object instanceof ReaderType ==false) {
			throw new Exception("Can Only Handl ReaderType");
		}
		ReaderType rt = (ReaderType)object;
		String  sql = "DELETE FROM TB_ReaderType WHERE rdType=?";
		Object[]params= new Object[] {rt.getRdType()};
		return SQLHelper.ExecSql(sql, params);
	}

	@Override
	public int update(AbstractModel object) throws Exception {
		if(object instanceof ReaderType ==false) {
			throw new Exception("Can Only Handl ReaderType");
		}
		ReaderType rt = (ReaderType)object;
		String  sql = "UPDATE TB_ReaderType SET rdTypeName=?,CanLendQty=?,CanLendDay=?,CanContinueTimes=?,PunishRate=?,DateValid=? WHERE rdType=?";
		Object[]params= new Object[] {rt.getRdTypeName(),rt.getCanLendQty(),rt.getCanLendDay(),rt.getCanContinueTimes(),rt.getPunishRate(),rt.getDateValid(),rt.getRdType()};
		
		return SQLHelper.ExecSql(sql, params);
	}

	@Override
	public AbstractModel getObjectByID(int rdType) throws Exception {
		ReaderType rt = null;
		String sql = "SELECT rdType,rdTypeName,CanLendQty,CanLendDay,CanContinueTimes,PunishRate,DateValid FROM TB_ReaderType WHERE rdType=?";
		Object[]params= new Object[]{ rdType};
		ResultSet rs = SQLHelper.getResultSet(sql,params);
		if(rs.next()) {
			rt = initReaderType(rs);
		}
		rs.close();
		return rt;
	}
	/**
	 * 初始化ReaderType
	 * @param rs
	 * @return
	 * @throws SQLException 
	 */
	private ReaderType initReaderType(ResultSet rs) throws SQLException {
		ReaderType rt = new ReaderType();
		rt.setCanContinueTimes(rs.getInt("CanContinueTimes"));
		rt.setCanLendDay(rs.getInt("CanLendDay"));
		rt.setCanLendQty(rs.getInt("CanLendQty"));
		rt.setDateValid(rs.getInt("DateValid"));
		rt.setPunishRate(rs.getFloat("PunishRate"));
		rt.setRdType(rs.getInt("rdType"));
		rt.setRdTypeName(rs.getString("rdTypeName"));
		return rt;
	}
	/**
	 * 前者供JTable初始化表头时调用，即初始化表格结构
	 */
	@Override
	public String[] getPrettyColumnNames() throws Exception {
		return dispColNames;
	}
	/**
	 * 后者返回获取指定JTable列数据所需要调用的Reader实体类方法名称
	 */
	public String getMethodNameForColumn(int col) throws Exception {
		// TODO 自动生成的方法存根
		return methodNames[col];
	}

	@Override
	public String[] getMethodNames() throws Exception {
		// TODO 自动生成的方法存根
		return methodNames;
	}

}
