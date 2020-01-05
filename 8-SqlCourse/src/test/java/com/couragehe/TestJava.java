package com.couragehe;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.Date;

import org.junit.Test;
import org.omg.CORBA.DATA_CONVERSION;

import edu.yangtzeu.lmis.bll.ReaderAdmin;
import edu.yangtzeu.lmis.dal.BookDAL;
import edu.yangtzeu.lmis.dal.ReaderDAL;
import edu.yangtzeu.lmis.dal.SQLHelper;
import edu.yangtzeu.lmis.gui.LoginFrame;
import edu.yangtzeu.lmis.model.Book;
import edu.yangtzeu.lmis.model.Reader;


public class TestJava {

	@Test
	public void TestReader() throws Exception {
		ReaderDAL dal= new ReaderDAL();
		Reader  reader = new Reader();
		reader.setRdID(201702991);
		reader.setRdName("CourageHe");
		reader.setRdSex("男");
		reader.setRdType(20);
		reader.setRdDept(11);
		reader.setRdPhone("123456789");
		reader.setRdEmail("524235428@qq.com");
		reader.setRdDateReg(new Date());
		
		reader.setRdPhoto(null);
		reader.setRdStatus("有效");
		reader.setRdBorrowQty(0);
		reader.setRdPwd("123456");
		reader.setRdAdminRoles(0);
		//add
		
		//1、
		dal.add(reader);
		
		//2、
		/*
		Reader readaer = (Reader)dal.getObjectByID(201702991);
		System.out.println("成功");
		*/
		
		
		//3、
//		dal.update(reader);
	}
	@Test
	public void TestBook() throws Exception {
		BookDAL dal= new BookDAL();
		//add
		Book book = new Book();
		book.setBkID(132456);
		book.setBkCode("TP132115646");
		book.setBkName("数据");
		book.setBkAuthor("CourageHe");
		book.setBkPress("清华出版社 长江");
		book.setBkDatePress(new Date());
		book.setBkISBN("798-87-98");
		book.setBkCatalog("TP123-5465-44");
		book.setBkLanguage(0);
		book.setBkPages(464);
		book.setBkPrice(45.6f);
		book.setBkDateIn(new Date());
		book.setBkBrief("fdjas兰的空间发");
		book.setBkCover(null);
		book.setBkStatus("在馆");
		//1、
		dal.add(book);
		
		//2、
		
//		Reader readaer = (Reader)dal.getObjectByID(132456);
//		System.out.println("成功");

		
		
		//3、
//		dal.update(book);
	}
	
	@Test
	public void test() {

		int rdAdminRoles =1;
		System.out.println((rdAdminRoles & 1)>0);

		System.out.println((rdAdminRoles & 2)>0);

		System.out.println((rdAdminRoles & 4)>0);

		System.out.println((rdAdminRoles & 8)>0);

		
	}

}
