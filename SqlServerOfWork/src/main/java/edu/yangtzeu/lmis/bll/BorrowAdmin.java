package edu.yangtzeu.lmis.bll;

import java.sql.SQLException;

import edu.yangtzeu.lmis.dal.BorrowDAL;
import edu.yangtzeu.lmis.dal.ReaderDAL;
import edu.yangtzeu.lmis.model.Borrow;
import edu.yangtzeu.lmis.model.view.BorrowView;

public class BorrowAdmin  extends LibraryBLL{
    //	private BorrowViewDAL dal;
	
	public BorrowAdmin() {
		dal = new BorrowDAL();
	}
	public int getReaderBorrowCount(int rdID, int state) {
		try {
			return ( (BorrowDAL) dal).getReaderBorrowCount(rdID, state);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 0;
	}
	public BorrowView[] getBorrowViews(int readerId) {
		try {
			return ((BorrowDAL)dal).getAllBorrowViews(readerId);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	public BorrowView[] getBorrows() {
		try {
			return (BorrowView[]) dal.getAllObjects();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	public Borrow getObjectById(int id) {
		try {
			return (Borrow) dal.getObjectByID(id);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateBorrow(Borrow borrow) {
		try {
			dal.update(borrow);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void addBorrow(Borrow borrow) {
		try {
			dal.add(borrow);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void delBorrow(BorrowView borrowBorrowView) {
		try {
			dal.delete(borrowBorrowView);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
