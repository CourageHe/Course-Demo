package edu.yangtzeu.lmis.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;

import edu.yangtzeu.lmis.Test;
import edu.yangtzeu.lmis.bll.BookAdmin;
import edu.yangtzeu.lmis.bll.BorrowAdmin;
import edu.yangtzeu.lmis.bll.DeptTypeAdmin;
import edu.yangtzeu.lmis.bll.ReaderAdmin;
import edu.yangtzeu.lmis.bll.ReaderTypeAdmin;
import edu.yangtzeu.lmis.dal.SQLHelper;
import edu.yangtzeu.lmis.model.Book;
import edu.yangtzeu.lmis.model.Borrow;
import edu.yangtzeu.lmis.model.CustomizedTableModel;
import edu.yangtzeu.lmis.model.DepartMentType;
import edu.yangtzeu.lmis.model.Reader;
import edu.yangtzeu.lmis.model.ReaderType;
import edu.yangtzeu.lmis.model.view.BorrowView;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
public class BorrowPanel extends JPanel {

	private JTextField tfReaderId;
	private JTextField tfReaderName;
	private JTextField tfCanLendCount;
	private JTextField tfReaderDept;
	private JTextField tfCanLendDay;
	private JTextField tfReaderType;
	private JTextField tfBorrowedCount;
	private JTextField tfBookId;
	private JTextField tfBookName;

	private JButton btnSearchReader;
	private JButton btnSearchBookById;
	private JButton btnSearchBookByName;
	private JButton btnBorrow;
	private JButton btnReturn;

	private JLabel lableOperator;
	private JLabel lableTime;

	private JPanel readerInfoPanel;
	private JPanel borrowedPanel;
	private JPanel bookInfoPanel;
	
	
	private JTable searchBookJTable;
	private JTable searchBorrowJTable;
	
	
	private ReaderAdmin readerBll = new ReaderAdmin();
	private ReaderTypeAdmin readerTypeBll = new ReaderTypeAdmin();
	private BookAdmin bookBll = new BookAdmin();
	private BorrowAdmin borrowBLl = new BorrowAdmin();
	private DeptTypeAdmin deptBLl = new DeptTypeAdmin();
	
	private Reader readerOperator = Test.reader;
	private Reader reader = null;
	private ReaderType readerType = null;	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowPanel  frame = new BorrowPanel ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BorrowPanel() {
		setLayout(null);
		//初始化各个Panel
		initReaderInfoPanel();
		initBorrowedPanel();
		initBookInfoPanel();
		initListener();
		
	}
	public void initReaderInfoPanel(){
		readerInfoPanel = new JPanel();
		readerInfoPanel.setBounds(0, 0, 1292, 117);
		add(readerInfoPanel);
		readerInfoPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("读者信息");
		lblNewLabel.setBounds(0, 0, 72, 18);
		readerInfoPanel.add(lblNewLabel);
		
		JLabel label = new JLabel("读者编号");
		label.setBounds(0, 56, 72, 18);
		readerInfoPanel.add(label);
		
		tfReaderId = new JTextField();
		tfReaderId.setBackground(Color.ORANGE);
		tfReaderId.setBounds(68, 53, 145, 24);
		readerInfoPanel.add(tfReaderId);
		tfReaderId.setColumns(10);
		
		btnSearchReader = new JButton("New button");
	
		btnSearchReader.setBounds(212, 52, 38, 26);
		readerInfoPanel.add(btnSearchReader);
		
		tfReaderName = new JTextField();
		tfReaderName.setEditable(false);
		tfReaderName.setColumns(10);
		tfReaderName.setBounds(378, 13, 145, 24);
		readerInfoPanel.add(tfReaderName);
		
		JLabel label_1 = new JLabel("读者姓名");
		label_1.setBounds(310, 16, 72, 18);
		readerInfoPanel.add(label_1);
		
		tfCanLendCount = new JTextField();
		tfCanLendCount.setEditable(false);
		tfCanLendCount.setColumns(10);
		tfCanLendCount.setBounds(378, 56, 145, 24);
		readerInfoPanel.add(tfCanLendCount);
		
		JLabel label_2 = new JLabel("可借书数量");
		label_2.setBounds(289, 59, 93, 18);
		readerInfoPanel.add(label_2);
		
		tfReaderDept = new JTextField();
		tfReaderDept.setEditable(false);
		tfReaderDept.setColumns(10);
		tfReaderDept.setBounds(660, 13, 145, 24);
		readerInfoPanel.add(tfReaderDept);
		
		JLabel label_3 = new JLabel("读者单位");
		label_3.setBounds(592, 16, 72, 18);
		readerInfoPanel.add(label_3);
		
		tfCanLendDay = new JTextField();
		tfCanLendDay.setEditable(false);
		tfCanLendDay.setColumns(10);
		tfCanLendDay.setBounds(660, 56, 145, 24);
		readerInfoPanel.add(tfCanLendDay);
		
		JLabel label_4 = new JLabel("可借书天数");
		label_4.setBounds(572, 59, 92, 18);
		readerInfoPanel.add(label_4);
		
		tfReaderType = new JTextField();
		tfReaderType.setEditable(false);
		tfReaderType.setColumns(10);
		tfReaderType.setBounds(937, 13, 145, 24);
		readerInfoPanel.add(tfReaderType);
		
		JLabel label_5 = new JLabel("读者类型");
		label_5.setBounds(869, 16, 72, 18);
		readerInfoPanel.add(label_5);
		
		tfBorrowedCount = new JTextField();
		tfBorrowedCount.setEditable(false);
		tfBorrowedCount.setColumns(10);
		tfBorrowedCount.setBounds(937, 56, 145, 24);
		readerInfoPanel.add(tfBorrowedCount);
		
		JLabel label_6 = new JLabel("已借数量");
		label_6.setBounds(869, 59, 72, 18);
		readerInfoPanel.add(label_6);
		
		JLabel label_7 = new JLabel("已借图书");
		label_7.setBounds(0, 100, 72, 18);
		readerInfoPanel.add(label_7);
	}
	public void initBorrowedPanel(){
		borrowedPanel = new JPanel();
		borrowedPanel.setBounds(0, 118, 1292, 250);
		add(borrowedPanel);
		borrowedPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		borrowedPanel.add(scrollPane, BorderLayout.CENTER);
		
		
		
		CustomizedTableModel<BorrowView>tableModel = new CustomizedTableModel<BorrowView>(
				borrowBLl.getDisplayColumnNames(), borrowBLl.getMethodNames());
		scrollPane.setBounds(0, 80, 1292, 339);
		searchBorrowJTable = new JTable(tableModel);
		//选择模式设置为选择单条记录：
		searchBorrowJTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(searchBorrowJTable);
	}
	public void initBookInfoPanel(){
		bookInfoPanel = new JPanel();
		bookInfoPanel.setBounds(0, 368, 1292, 370);
		add(bookInfoPanel);
		bookInfoPanel.setLayout(null);
		
		JLabel label_8 = new JLabel("图书信息");
		label_8.setBounds(0, 2, 72, 13);
		bookInfoPanel.add(label_8);
		
		tfBookId = new JTextField();
		tfBookId.setColumns(10);
		tfBookId.setBackground(Color.ORANGE);
		tfBookId.setBounds(68, 28, 145, 24);
		bookInfoPanel.add(tfBookId);
		
		btnSearchBookById = new JButton("New button");

		btnSearchBookById.setBounds(212, 27, 38, 26);
		bookInfoPanel.add(btnSearchBookById);
		
		JLabel label_9 = new JLabel("图书序号");
		label_9.setBounds(0, 31, 72, 18);
		bookInfoPanel.add(label_9);
		
		tfBookName = new JTextField();
		tfBookName.setColumns(10);
		tfBookName.setBackground(Color.ORANGE);
		tfBookName.setBounds(352, 29, 145, 24);
		bookInfoPanel.add(tfBookName);
		
		btnSearchBookByName = new JButton("New button");
		
		btnSearchBookByName.setBounds(496, 28, 38, 26);
		bookInfoPanel.add(btnSearchBookByName);
		
		JLabel label_10 = new JLabel("图书名称");
		label_10.setBounds(284, 32, 72, 18);
		bookInfoPanel.add(label_10);
		

		CustomizedTableModel<Book>tableModel = new CustomizedTableModel<Book>(
			bookBll.getDisplayColumnNames(), bookBll.getMethodNames());
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 80, 1292, 290);
		bookInfoPanel.add(scrollPane_1);
		searchBookJTable = new JTable(tableModel);
		//选择模式设置为选择单条记录：
		searchBookJTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(searchBookJTable);
		
		// JLabel lyout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("操作员");
		lblNewLabel_1.setBounds(10, 750, 72, 18);
		add(lblNewLabel_1);
		
		lableOperator = new JLabel("");
		lableOperator.setBounds(62, 750, 72, 18);
		lableOperator.setText(readerOperator.getRdName());
		add(lableOperator);
		
		btnBorrow = new JButton("借阅");
	
	
		btnBorrow.setBounds(849, 741, 113, 27);
		add(btnBorrow);
		
		btnReturn = new JButton("返回");

		btnReturn.setBounds(969, 740, 113, 27);
		add(btnReturn);
		
		lableTime = new JLabel("");
		lableTime.setBounds(1114, 769, 178, 18);
		add(lableTime);
	}
	/**
	 * 添加监听事件，进行状态切换
	 */
	private void initListener() {
		
		//查询读者
		btnSearchReader.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//首先对展示框清空
				clearField();
				int readerId = Integer.valueOf(tfReaderId.getText());
				reader = readerBll.getReader(readerId);
				readerType = readerTypeBll.getObjectById(reader.getRdType());
				DepartMentType dept = deptBLl.getObjectById(reader.getRdDept());
				tfReaderName.setText(reader.getRdName());
				tfCanLendCount.setText(readerType.getCanLendQty()+"" );
				tfCanLendDay.setText(readerType.getCanLendDay()+"" );
				tfReaderDept.setText( dept.getDpTypeName());
				tfReaderType.setText(readerType.getRdTypeName());
				tfBorrowedCount.setText(borrowBLl.getReaderBorrowCount(reader.getRdID(), 0)+"");
				
				BorrowView[] borrowViews = borrowBLl.getBorrowViews(readerId);
				updateBorrowTable(borrowViews);
			}
		});
		
		btnSearchBookById.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int bookID  = 0;
				try {
					bookID = Integer.valueOf(tfBookId.getText());					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "请正确输入数字");
					return;
				}
				Book[] books = {bookBll.getObjectById(bookID)};
				updateBookTable(books);
			}
		});
		btnSearchBookByName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String bookName = String.valueOf(tfBookName.getText());					
				Book[] books = bookBll.getBooksByName(bookName);
				updateBookTable(books);
			}
		});
		
		//借阅操作
		btnBorrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//1、检查是否选中图书行
				int selectedRow = searchBookJTable.getSelectedRow();
				if(selectedRow<0) {
					JOptionPane.showMessageDialog(null, "请先选中一条记录");
					return;
				}
				//获取选中行
				Book book = ((Book)((CustomizedTableModel) searchBookJTable.getModel()).getObjectAt(selectedRow));
				//2、检查是否确定读者
				if(reader == null) {
					JOptionPane.showMessageDialog(null, "请先选中读者");
					return;
				}
				//3、检查是否借书数量超过规定
				int lendCount = borrowBLl.getReaderBorrowCount(reader.getRdID(), 0);
				if( lendCount>= readerType.getCanLendQty()) {
					JOptionPane.showMessageDialog(null, "借书数量已达上限");
					return;
				}
				//4、借书操作
				Borrow borrow = new Borrow();
				borrow.setRdID(reader.getRdID());
				//日期可能需要特别处理
				borrow.setBkID(book.getBkID());
				borrow.setLdContinueTimes(0);
				borrow.setLdDateOut(new Date());
				Date retDate = new Date();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(retDate );
				calendar.add(Calendar.DATE, 30);
				retDate  = calendar.getTime();
				borrow.setLdDateRetPlan(retDate);
				
				borrow.setLdDateRetAct(new Date());
				borrow.setLdOverDay(0);
				borrow.setLdOverMoney(0f);
				borrow.setLdPunishMoney(0f);
				borrow.setIsHasReturn(false);
				borrow.setOperatorLend(Test.reader.getRdName());
				borrow.setOperatorRet("");
				borrowBLl.addBorrow(borrow);
				
				//5、更新书籍状态
				book.setBkStatus("借出");
				bookBll.updateBook(book);
				//6、更新gui上的借书数量
				tfBorrowedCount.setText(lendCount+1+"");
				//7、更新借书列表
				BorrowView[] borrowViews = borrowBLl.getBorrowViews(reader.getRdID());
				updateBorrowTable(borrowViews);
				
				//8、更新书籍列表
				String bookName = String.valueOf(tfBookName.getText());					
				Book[] books = bookBll.getBooksByName(bookName);
				updateBookTable(books);
			}
		});
		
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		Thread thread = new Thread(new Runnable() {
			 
			public void run() {
				while (true) {
					Date date = new Date();
					lableTime.setText(SQLHelper.formaDatetime(date));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					
				}
			}
		});
	}
	
	public void updateBorrowTable(BorrowView[] borrowViews){
		if(borrowViews == null) {
			JOptionPane.showMessageDialog(null,"没有在借书籍");
			return;
		} 
		CustomizedTableModel<BorrowView>tableModel = (CustomizedTableModel<BorrowView>)searchBorrowJTable.getModel();
		tableModel.setRecords(borrowViews);
		//更新数据
		tableModel.fireTableDataChanged();
	}
	public void updateBookTable(Book[] books){
		if(books == null) {
			JOptionPane.showMessageDialog(null,"没有找到符合要求的记录");
			return;
		} 
		CustomizedTableModel<Book>tableModel = (CustomizedTableModel<Book>)searchBookJTable.getModel();
		tableModel.setRecords(books);
		//更新数据
		tableModel.fireTableDataChanged();
	}
	
	public void clearField() {
		tfReaderName.setText("");
		tfCanLendCount.setText("");
		tfCanLendDay.setText("");
		tfReaderDept.setText("");
		tfReaderType.setText("");
		tfBorrowedCount.setText("");
	}
	
	
}