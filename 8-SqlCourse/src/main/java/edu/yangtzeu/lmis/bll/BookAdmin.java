package edu.yangtzeu.lmis.bll;

import java.sql.SQLException;

import edu.yangtzeu.lmis.dal.BookDAL;
import edu.yangtzeu.lmis.model.Book;
import edu.yangtzeu.lmis.model.Book;

public class BookAdmin extends LibraryBLL {
// private BookDAL dal;
	
	public BookAdmin() {
		dal = new BookDAL();
	}
	
	public Book[] getBooks() {
		try {
			return (Book[])dal.getAllObjects();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	
	public Book getObjectById(int id) {
		try {
			return (Book)dal.getObjectByID(id);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateBook(Book book) {
		try {
			dal.update(book);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	/**
	 *  按本数往书籍表中添加
	 * @param book
	 * @param count
	 * @return
	 */
	public int addBook(Book book, int count) {
		try {
			int row = 0;
			while(count > 0 ) {
				dal.add(book);
				row++;
				count--;
			}
			return row;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 0;
	}
	public int delBook(Book book) {
		try {
			return dal.delete(book);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 0;
	}

	public Book[] getBooksByName(String bookName) {
		try {
			return ((BookDAL)dal).getBooksByName(bookName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Book[] getBooksByColumn(String columnName, String bkEasyName) {
		try {
			return ((BookDAL)dal).getBooksByColumn(columnName,bkEasyName);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	public Book[] getBooksByColumns(String bkName, String bkDesc, String bkPress, String bkCata, String bkAuthor,
			String bkYear) {
		try {
			return ((BookDAL)dal).getBooksByColumn(bkName,bkDesc,bkPress,bkCata,bkAuthor,bkYear);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		// TODO 自动生成的方法存根
		return null;
	}
}
