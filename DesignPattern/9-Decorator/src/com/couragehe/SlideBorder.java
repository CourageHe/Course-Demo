package com.couragehe;

public class SlideBorder extends Border {
	private char boderChar;//表示装饰边框的字符
	
	public SlideBorder(Display display,char ch) {
		super(display);
		this.boderChar = ch;
	}

	@Override
	public int getColumns() {
		return 1+display.getColumns()+1;
	}

	@Override
	public int getRows() {
		
		return display.getRows();
	}

	@Override
	public String getRowText(int row) {
		// TODO 自动生成的方法存根
		return boderChar+display.getRowText(row)+boderChar;
	}

}
