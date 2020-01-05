package edu.yangtzeu.lmis.model;

import java.lang.reflect.InvocationTargetException;

import javax.swing.table.AbstractTableModel;

public class CustomizedTableModel<T extends AbstractModel> extends AbstractTableModel {
	T[] records = null;
	String[]columnNames = null;
	String[]methodNames= null;

	
	public CustomizedTableModel(String[] columnNames, String[] methodNames) {
		this.columnNames = columnNames;
		this.methodNames = methodNames;
	}

	public void setRecords(T[] records) {
		this.records = records;
	}
	public T getObjectAt(int row) {
		return records[row];
	}
	public String getColumnName(int col) {
		return columnNames[col];
	}
	public int getColumnCount() {
		return columnNames == null?0:columnNames.length;
	}

	public int getRowCount() {
		return records== null?0:records.length;
	}

	public Object getValueAt(int row, int col) {
		T record = records[row];
		try {
			return record.getFieldValue(record.getClass(),methodNames[col]);
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
		return null;
	}
	

}
