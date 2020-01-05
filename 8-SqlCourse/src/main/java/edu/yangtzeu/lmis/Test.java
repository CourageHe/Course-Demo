package edu.yangtzeu.lmis;

import java.util.Date;

import edu.yangtzeu.lmis.model.Reader;

public class Test {
	public static Reader reader;
	static {
		reader = new Reader();
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
		reader.setRdAdminRoles(1);
	}
}
