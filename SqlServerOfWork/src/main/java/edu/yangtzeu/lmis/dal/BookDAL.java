package edu.yangtzeu.lmis.dal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.yangtzeu.lmis.model.AbstractModel;
import edu.yangtzeu.lmis.model.Book;
import edu.yangtzeu.lmis.model.ReaderType;

public class BookDAL extends  AbstractDAL{

	private String[]dispColNames = new String[] {"ID","索书号","书名","作者","出版社","出版日期","ISBN","分类号","语种" ,"页数","价格","入馆时间","状态"};
	private String[] methodNames = new String[] {"getBkID","getBkCode","getBkName","getBkAuthor","getBkPress","getBkDatePress","getBkISBN","getBkCatalog","getBkLanguage","getBkPages","getBkPrice","getBkDateIn","getBkStatus"};

	@Override
	public AbstractModel[] getAllObjects() throws Exception {
		ArrayList<Book>objects = new ArrayList<Book>();
		ResultSet rs = SQLHelper.getResultSet("SELECT * FROM TB_Book",null);
		if(rs != null) {
			while (rs.next()) {
				Book ld = initBook(rs);
				objects.add(ld);
			}
			rs.close();
		}
		//列表转为数组实现动态装载
		Book[]Books =new Book[objects.size()];
		objects.toArray(Books);
		return Books;
	}

	@Override
	public int add(AbstractModel object) throws Exception {
		if(object instanceof Book ==false) {
			throw new Exception("Can Only Handl Book");
		}
		Book bk= (Book)object;
		String  sql = "INSERT INTO TB_Book(bkCode,bkName,bkAuthor,bkPress,bkDatePress,bkISBN,bkCatalog,bkLanguage,bkPrice,bkPages,bkDateIn,bkBrief,bkCover,bkStatus)"
						+"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[]params= new Object[14];
		params[0] = bk.getBkCode();
		params[1] = bk.getBkName();
		params[2] = bk.getBkAuthor();
		params[3] = bk.getBkPress();
		String datePress = SQLHelper.formaDatetime(bk.getBkDatePress());
		params[4] = datePress;
		params[5] =bk.getBkISBN();
		params[6] = bk.getBkCatalog();
		params[7] = bk.getBkLanguage();
		params[8] = bk.getBkPrice();
		params[9] = bk.getBkPages();
		String dateIn = SQLHelper.formaDatetime(bk.getBkDateIn());
		params[10] = dateIn;
		params[11] = bk.getBkBrief();
		
		byte[] photoBytes = SQLHelper.read(bk.getBkCover());
		params[12] = photoBytes;
		params[13] = bk.getBkStatus();
		return SQLHelper.ExecSql(sql, params);
	}

	@Override
	public int delete(AbstractModel object) throws Exception {
		if(object instanceof Book ==false) {
			throw new Exception("Can Only Handl Book");
		}
		Book bk= (Book)object;
		String  sql = "DELETE FROM TB_Book WHERE bkID=?";
		Object[]params= new Object[] {bk.getBkID()};
		return SQLHelper.ExecSql(sql, params);
	}

	@Override
	public int update(AbstractModel object) throws Exception {
		if(object instanceof Book ==false) {
			throw new Exception("Can Only Handl Book");
		}
		Book bk = (Book)object;
		String  sql = "UPDATE TB_Book SET bkCode=?,bkName=?,bkAuthor=?,bkPress=?,bkDatePress=?,bkISBN=?,bkCatalog=?,bkLanguage=?,bkPrice=?,bkPages=?,bkDateIn=?,bkBrief=?,bkCover=?,bkStatus=? WHERE  bkID=?";
		String datePress = SQLHelper.formaDatetime(bk.getBkDatePress());
		String dateIn = SQLHelper.formaDatetime(bk.getBkDateIn());
		
		byte[] photoBytes = SQLHelper.read(bk.getBkCover());
		Object[]params= new Object[] {bk.getBkCode() ,bk.getBkName(),bk.getBkAuthor(),bk.getBkPress(),datePress,bk.getBkISBN(),bk.getBkCatalog(),bk.getBkLanguage(),bk.getBkPrice(),bk.getBkPages(),dateIn ,bk.getBkBrief(),photoBytes,bk.getBkStatus(),bk.getBkID()};
		return SQLHelper.ExecSql(sql, params);
	}

	@Override
	public AbstractModel getObjectByID(int bkID) throws Exception {
		Book bk= null;
		String sql = "SELECT bkID,bkCode,bkName,bkAuthor,bkPress,bkDatePress,bkISBN,bkCatalog,bkLanguage,bkPrice,bkPages,bkDateIn,bkBrief,bkCover,bkStatus FROM TB_Book WHERE bkID=?";
		Object[]params = new Object[]{bkID};
		ResultSet rs = SQLHelper.getResultSet(sql,params);
		if(rs.next()) {
			bk= initBook(rs);
		}
		rs.close();
		return bk;
	}
	public Book[] getBooksByName(String bookName) throws SQLException {
		
		ArrayList<Book>objects = new ArrayList<Book>();
		Book bk= null;
		String sql = "SELECT bkID,bkCode,bkName,bkAuthor,bkPress,bkDatePress,bkISBN,bkCatalog,bkLanguage,bkPrice,bkPages,bkDateIn,bkBrief,bkCover,bkStatus FROM TB_Book WHERE bkName like ?";
		Object[]params = new Object[]{"%"+bookName+"%"};
		ResultSet rs = SQLHelper.getResultSet(sql,params);
		if(rs != null) {
			while (rs.next()) {
				Book ld = initBook(rs);
				objects.add(ld);
			}
			rs.close();
		}
		//列表转为数组实现动态装载
		Book[]Books =new Book[objects.size()];
		objects.toArray(Books);
		return Books;
	}
	/**
	 * 初始化BookType
	 * @param rs
	 * @return
	 * @throws SQLException 
	 */
	private Book initBook(ResultSet rs) throws SQLException {
		Book bk= new Book();

		bk.setBkID(rs.getInt("bkID"));
		bk.setBkCode(rs.getString("bkCode"));
		//日期可能需要特别处理
		bk.setBkName(rs.getString("bkName"));
		bk.setBkAuthor(rs.getString("bkAuthor"));
		bk.setBkPress(rs.getString("bkPress"));
		bk.setBkDatePress(rs.getDate("bkDatePress"));
		bk.setBkISBN(rs.getString("bkISBN"));
		bk.setBkCatalog(rs.getString("bkCatalog"));
		bk.setBkLanguage(rs.getInt("bkLanguage"));
		bk.setBkPrice(rs.getFloat("bkPrice"));
		bk.setBkPages(rs.getInt("bkPages"));
		bk.setBkDateIn(rs.getDate("bkDateIn"));
		bk.setBkBrief(rs.getString("bkBrief"));
		
		//图片转换
		byte[] bytes = rs.getBytes("bkCover"); 
		InputStream in = new ByteArrayInputStream(bytes);
		bk.setBkCover(in);
		bk.setBkStatus(rs.getString("bkStatus"));

		return bk;
		
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
	/**
	 * 根据任意字段进行查询
	 * @param columnName
	 * @param bkEasyName
	 * @return
	 * @throws SQLException
	 */
	public Book[] getBooksByColumn(String columnName, String bkEasyName) throws SQLException {
		ArrayList<Book>objects = new ArrayList<Book>();
		Book bk= null;
		String sql = "SELECT bkID,bkCode,bkName,bkAuthor,bkPress,bkDatePress,bkISBN,bkCatalog,bkLanguage,bkPrice,bkPages,bkDateIn,bkBrief,bkCover,bkStatus FROM TB_Book WHERE "+columnName+" like ?";
		Object[]params = new Object[]{"%"+ bkEasyName+"%"};
		ResultSet rs = SQLHelper.getResultSet(sql,params);
		if(rs != null) {
			while (rs.next()) {
				Book ld = initBook(rs);
				objects.add(ld);
			}
			rs.close();
		}
		//列表转为数组实现动态装载
		Book[]Books =new Book[objects.size()];
		objects.toArray(Books);
		return Books;
	}
	/**
	 * 高级查询
	 * @param bkName
	 * @param bkDesc
	 * @param bkPress
	 * @param bkCata
	 * @param bkAuthor
	 * @param bkYear
	 * @return
	 * @throws SQLException
	 */
	public Book[] getBooksByColumn(String bkName, String bkDesc, String bkPress, String bkCata, String bkAuthor,
			String bkYear) throws SQLException {
		ArrayList<Book>objects = new ArrayList<Book>();
		Book bk= null;
//		AND convert( varchar(32), bkDatePress, 20 )  = ?
		String sql = "SELECT bkID,bkCode,bkName,bkAuthor,bkPress,bkDatePress,bkISBN,bkCatalog,bkLanguage,bkPrice,bkPages,bkDateIn,bkBrief,bkCover,bkStatus FROM TB_Book "
				+ "WHERE bkName like ? AND  bkBrief like ? AND  bkPress like ? AND  bkCatalog like ? AND  bkAuthor like ? ";
		Object[]params = new Object[]{"%"+bkName+"%","%"+bkDesc+"%","%"+bkPress+"%","%"+bkCata+"%","%"+bkAuthor+"%"/*,"%"+bkYear+"%"*/};
		ResultSet rs = SQLHelper.getResultSet(sql,params);
		//	https://zhidao.baidu.com/question/177330803.html
		if(rs != null) {
			while (rs.next()) {
				Book ld = initBook(rs);
				objects.add(ld);
			}
			rs.close();
		}
		//列表转为数组实现动态装载
		Book[]Books =new Book[objects.size()];
		objects.toArray(Books);
		return Books;
	}

}
