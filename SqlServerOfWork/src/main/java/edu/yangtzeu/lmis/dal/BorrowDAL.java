package edu.yangtzeu.lmis.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.yangtzeu.lmis.bll.BookAdmin;
import edu.yangtzeu.lmis.bll.ReaderAdmin;
import edu.yangtzeu.lmis.model.AbstractModel;
import edu.yangtzeu.lmis.model.Book;
import edu.yangtzeu.lmis.model.Borrow;
import edu.yangtzeu.lmis.model.Reader;
import edu.yangtzeu.lmis.model.view.BorrowView;

public class BorrowDAL extends  AbstractDAL{
	
	private String[]dispColNames = new String[] {"图书序号","图书名称","图书作者","续借次数","借阅日期","应还日期","超期天数","超期金额"};
	private String[] methodNames = new String[] {"getBkID","getBkName","getBkAuthor","getLdContinueTimes","getLdDateOut","getLdDateRetPlan","getLdOverDay","getLdOverMoney"};


	@Override
	public AbstractModel[] getAllObjects() throws Exception {
		ArrayList<Borrow>objects = new ArrayList<Borrow>();
		ResultSet rs = SQLHelper.getResultSet("SELECT * FROM TB_Borrow",null);
		if(rs != null) {
			while (rs.next()) {
				Borrow ld = initBorrow(rs);
				objects.add(ld);
			}
			rs.close();
		}
		//列表转为数组实现动态装载
		Borrow[]Borrows =new Borrow[objects.size()];
		objects.toArray(Borrows);
		return Borrows;
	}
	

	@Override
	public int add(AbstractModel object) throws Exception {
		if(object instanceof Borrow ==false) {
			throw new Exception("Can Only Handl Borrow");
		}
		Borrow ld= (Borrow)object;
		String  sql = "INSERT INTO TB_Borrow(rdID,bkID,ldContinueTimes,ldDateOut,ldDateRetPlan,ldDateRetAct,ldOverDay,ldOverMoney,ldPunishMoney,isHasReturn,OperatorLend,OperatorRet)"
						+"VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[]params= new Object[12];
		params[0] = ld.getRdID();
		params[1] = ld.getBkID();		
		params[2] = ld.getLdContinueTimes();
		String ldDateOut = SQLHelper.formaDatetime(ld.getLdDateOut());
		String ldDateRetPlan = SQLHelper.formaDatetime(ld.getLdDateRetPlan());
		String ldDateRetAct= SQLHelper.formaDatetime(ld.getLdDateRetAct());
		params[3] = ldDateOut;
		params[4] = ldDateRetPlan;
		params[5] = ldDateRetAct;
		
		params[6] = ld.getLdOverDay();
		params[7] = ld.getLdOverMoney();
		params[8] = ld.getLdPunishMoney();
		params[9] = ld.getIsHasReturn();
		params[10] = ld.getOperatorLend();
		params[11] = ld.getOperatorRet();
		return SQLHelper.ExecSql(sql, params);
	}

	@Override
	public int delete(AbstractModel object) throws Exception {
		if(object instanceof Borrow ==false) {
			throw new Exception("Can Only Handl Borrow");
		}
		Borrow ld= (Borrow)object;
		String  sql = "DELETE FROM TB_Borrow WHERE BorrowID=?";
		Object[]params= new Object[] {ld.getBorrowID()};
		return SQLHelper.ExecSql(sql, params);
	}

	@Override
	public int update(AbstractModel object) throws Exception {
		if(object instanceof Borrow ==false) {
			throw new Exception("Can Only Handl Borrow");
		}
		Borrow ld = (Borrow)object;
		String  sql = "UPDATE TB_Borrow SET rdID=?,bkID=?,ldContinueTimes=?,ldDateOut=?,ldDateRetPlan=?,ldDateRetAct=?,ldOverDay=?,ldOverMoney=?,ldPunishMoney=?,isHasReturn=?,OperatorLend=?,OperatorRet=? WHERE  BorrowID=?";
		String ldDateOut = SQLHelper.formaDatetime(ld.getLdDateOut());
		String ldDateRetPlan = SQLHelper.formaDatetime(ld.getLdDateRetPlan());
		String ldDateRetAct= SQLHelper.formaDatetime(ld.getLdDateRetAct());
		Object[]params= new Object[] {ld.getRdID(),ld.getBkID(),ld.getLdContinueTimes(),ldDateOut,ldDateRetPlan,ldDateRetAct,ld.getLdOverDay(),ld.getLdOverMoney(),ld.getLdPunishMoney(),ld.getIsHasReturn(),ld.getOperatorLend(),ld.getOperatorRet(),ld.getBorrowID()};
		
		return SQLHelper.ExecSql(sql, params);
	}

	
	@Override
	public AbstractModel getObjectByID(int BorrowID) throws Exception {
		Borrow ld= null;
		
		String sql = "SELECT BorrowID,rdID,bkID,ldContinueTimes,ldDateOut,ldDateRetPlan,ldDateRetAct,ldOverDay,ldOverMoney,ldPunishMoney,isHasReturn,OperatorLend,OperatorRet FROM TB_Borrow WHERE BorrowID=?";
		Object[]params = new Object[]{BorrowID};
		ResultSet rs = SQLHelper.getResultSet(sql,params);
		if(rs.next()) {
			ld= initBorrow(rs);
		}
		rs.close();
		return ld;
	}
	/**
	 * 根据读者ID查询借书的数量(借、还)
	 * @param rdID
	 * @param state
	 * @return
	 * @throws SQLException
	 */
	public int getReaderBorrowCount(int rdID,int state) throws SQLException {
		int count = 0;
		String sql = "SELECT  COUNT(*) AS count FROM TB_Borrow WHERE rdID=? AND isHasReturn = ?";
		Object[]params = new Object[]{rdID,state};
		ResultSet rs = SQLHelper.getResultSet(sql,params);
		if(rs.next()) {
			count= rs.getInt("count");
		}
		rs.close();
		return count;
	}
	
	
	/**
	 * 初始化Borrow
	 * @param rs
	 * @return
	 * @throws SQLException 
	 */
	private Borrow initBorrow(ResultSet rs) throws SQLException {
		Borrow ld= new Borrow();
		ld.setBorrowID(rs.getInt("BorrowID"));
		ld.setRdID(rs.getInt("rdID"));
		//日期可能需要特别处理
		ld.setBkID(rs.getInt("bkID"));
		ld.setLdContinueTimes(rs.getInt("ldContinueTimes"));
		ld.setLdDateOut(rs.getDate("ldDateOut"));
		ld.setLdDateRetPlan(rs.getDate("ldDateRetPlan"));
		ld.setLdDateRetAct(rs.getDate("ldDateRetAct"));
		ld.setLdOverDay(rs.getInt("ldOverDay"));
		ld.setLdOverMoney(rs.getFloat("ldOverMoney"));
		ld.setLdPunishMoney(rs.getFloat("ldPunishMoney"));
		ld.setIsHasReturn(rs.getBoolean("isHasReturn"));
		ld.setOperatorLend(rs.getString("OperatorLend"));
		ld.setOperatorRet(rs.getString("OperatorRet"));
		return ld;
		
	}
	
	/**
	 * 获取读者所有的构建视图BorrowViews
	 * @param readerId 
	 * @return
	 * @throws Exception
	 */
	public BorrowView[] getAllBorrowViews(int readerId) throws Exception {
		ArrayList<BorrowView>objects = new ArrayList<BorrowView>();
		Object[]params = new Object[]{readerId};
		ResultSet rs = SQLHelper.getResultSet("SELECT * FROM TB_Borrow WHERE rdID= ?",params);
		
		if(rs != null) {
			while (rs.next()) {
				BorrowView ld = initBorrowView(rs);
				objects.add(ld);
			}
			rs.close();
		}
		//列表转为数组实现动态装载
		BorrowView[]Borrows =new BorrowView[objects.size()];
		objects.toArray(Borrows);
		return Borrows;
	}
	/**
	 * 初始化BorrowView
	 * @param rs
	 * @return
	 * @throws SQLException 
	 */
	private BorrowView initBorrowView(ResultSet rs) throws SQLException {
		BorrowView ld= new BorrowView();
		ld.setBorrowID(rs.getInt("BorrowID"));
		//日期可能需要特别处理
		ld.setBkID(rs.getInt("bkID"));
		ld.setLdContinueTimes(rs.getInt("ldContinueTimes"));
		ld.setLdDateOut(rs.getDate("ldDateOut"));
		ld.setLdDateRetPlan(rs.getDate("ldDateRetPlan"));
		ld.setLdOverDay(rs.getInt("ldOverDay"));
		ld.setLdOverMoney(rs.getFloat("ldOverMoney"));
		
		BookAdmin bookBll = new BookAdmin();
		Book book = bookBll.getObjectById(rs.getInt("bkID"));
		ld.setBkAuthor(book.getBkAuthor());
		ld.setBkName(book.getBkName());
		return ld;
		
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
