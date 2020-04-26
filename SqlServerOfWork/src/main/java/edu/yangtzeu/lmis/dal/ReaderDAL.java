package edu.yangtzeu.lmis.dal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.interfaces.RSAKey;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.yangtzeu.lmis.model.AbstractModel;
import edu.yangtzeu.lmis.model.DepartMentType;
import edu.yangtzeu.lmis.model.Reader;
import edu.yangtzeu.lmis.model.ReaderType;

public class ReaderDAL extends  AbstractDAL{
	private String[]dispColNames = new String[] {"ID","姓名","性别","类型","院系","电话","Email","状态","已借书数量","注册日期"};
	private String[] methodNames = new String[] {"getRdID","getRdName","getRdSex","getRdType","getRdDept","getRdPhone","getRdEmail","getRdStatus","getRdBorrowQty","getRdDateReg"};

	@Override
	public AbstractModel[] getAllObjects() throws Exception {
		ArrayList<Reader>objects = new ArrayList<Reader>();
		ResultSet rs = SQLHelper.getResultSet("SELECT * FROM TB_Reader",null);
		if(rs != null) {
			while (rs.next()) {
				Reader rd = initReader(rs);
				objects .add(rd);
			}
			rs.close();
		}
		//列表转为数组实现动态装载
		Reader[]readers =new Reader[objects.size()];
		objects.toArray(readers);
		return readers;
	}

	@Override
	public int add(AbstractModel object) throws Exception {
		if(object instanceof Reader ==false) {
			throw new Exception("Can Only Handl Reader");
		}
		Reader rd = (Reader)object;
		String  sql = "INSERT INTO TB_Reader(rdID,rdName,rdSex,rdType,rdDept,rdPhone,rdEmail,rdDateReg,rdPhoto,rdStatus,rdBorrowQty,rdPwd,rdAdminRoles)"
						+"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[]params= new Object[13];
		params[0] = rd.getRdID();
		params[1] = rd.getRdName();
		params[2] = rd.getRdSex();
		params[3] = rd.getRdType();
		params[4] = rd.getRdDept();
		params[5] =rd.getRdPhone();
		params[6] =rd.getRdEmail();
		//时间格式转换
		String datetimeSql = SQLHelper.formaDatetime(rd.getRdDateReg());
		params[7] = datetimeSql;
		//图片转化为byte数据
		byte[] photoBytes = SQLHelper.read(rd.getRdPhoto());
		params[8] = photoBytes;
		params[9] = rd.getRdStatus();
		params[10] = rd.getRdBorrowQty();
		params[11] = rd.getRdPwd();
		params[12] = rd.getRdAdminRoles();
		return SQLHelper.ExecSql(sql, params);
	}

	@Override
	public int delete(AbstractModel object) throws Exception {
		if(object instanceof Reader ==false) {
			throw new Exception("Can Only Handl Reader");
		}
		Reader rd = (Reader)object;
		String  sql = "DELETE FROM TB_Reader WHERE rdID=?";
		Object[]params= new Object[] {rd.getRdID()};
		return SQLHelper.ExecSql(sql, params);
	}

	@Override
	public int update(AbstractModel object) throws Exception {
		if(object instanceof Reader ==false) {
			throw new Exception("Can Only Handl Reader");
		}
		Reader rd = (Reader)object;
		String  sql = "UPDATE TB_Reader SET rdName=?,rdSex=?,rdType=?,rdDept=?,rdPhone=?,rdEmail=?,rdDateReg=?,rdPhoto=?,rdStatus=?,rdBorrowQty=?,rdPwd=?,rdAdminRoles=? WHERE  rdID=?";
		
		String datetimeSql = SQLHelper.formaDatetime(rd.getRdDateReg());
		byte[] photoBytes = SQLHelper.read(rd.getRdPhoto());
		Object[]params= new Object[] {rd.getRdName(),rd.getRdSex(),rd.getRdType(),rd.getRdDept(),rd.getRdPhone(),rd.getRdEmail(),datetimeSql,photoBytes ,rd.getRdStatus(),rd.getRdBorrowQty(),rd.getRdPwd(),rd.getRdAdminRoles(),rd.getRdID()};
		
		return SQLHelper.ExecSql(sql, params);
	}

	@Override
	public AbstractModel getObjectByID(int rdID) throws Exception {
		Reader rd = null;
		String sql = "SELECT rdID,rdName,rdSex,rdType,rdDept,rdPhone,rdEmail,rdDateReg,rdPhoto,rdStatus,rdBorrowQty,rdPwd,rdAdminRoles FROM TB_Reader WHERE rdID=?";
		Object[]params = new Object[]{rdID};
		ResultSet rs = SQLHelper.getResultSet(sql,params);
		
		if(rs.next()) {
			rd = initReader(rs);
		}
		rs.close();
		return rd;
	}
	/**
	 * 初始化ReaderType
	 * @param rs
	 * @return
	 * @throws SQLException 
	 */
	private Reader initReader(ResultSet rs) throws SQLException {
		Reader rd = new Reader();
		rd.setRdAdminRoles(rs.getInt("rdAdminRoles"));
		rd.setRdBorrowQty(rs.getInt("rdBorrowQty"));
		//日期可能需要特别处理
		rd.setRdDateReg(rs.getDate("rdDateReg"));
		rd.setRdDept(rs.getInt("rdDept"));
		rd.setRdEmail(rs.getString("rdEmail"));
		rd.setRdID(rs.getInt("rdID"));
		rd.setRdName(rs.getString("rdName"));
		rd.setRdPhone(rs.getString("rdPhone"));
		
		//图片转换
		byte[] bytes = rs.getBytes("rdPhoto"); 
		InputStream in = null;
		if(bytes != null) {
			in = new ByteArrayInputStream(bytes);			
		}
		rd.setRdPhoto(in);
		rd.setRdPwd(rs.getString("rdPwd"));
		rd.setRdSex(rs.getString("rdSex"));
		rd.setRdStatus(rs.getString("rdStatus"));
		rd.setRdType(rs.getInt("rdType"));
		return rd;
		
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
	public  Reader[]getReadersBy(ReaderType rdType,DepartMentType deptType,String userName) throws SQLException{
		
		ArrayList<Reader> readers = new ArrayList<Reader>();
		String sql = "SELECT rdID,rdName,rdSex,rdType,rdDept,rdPhone,rdEmail,rdDateReg,rdPhoto,rdStatus,rdBorrowQty,rdPwd,rdAdminRoles FROM TB_Reader WHERE rdType=?  AND rdDept = ? AND rdName like ?";
		Object[]params = new Object[]{rdType.getRdType(),deptType.getDpType(),"%"+userName+"%"};
		ResultSet rs = SQLHelper.getResultSet(sql,params);
		if(rs!=null) {
			while(rs.next()) {
				Reader rd = initReader(rs);
				readers.add(rd);
			}
			rs.close();
		}
		if(readers.size()>0) {
			Reader[] array = new Reader[readers.size()];
			readers.toArray(array);
			return array;
		}
		return null;
		
	}


}
