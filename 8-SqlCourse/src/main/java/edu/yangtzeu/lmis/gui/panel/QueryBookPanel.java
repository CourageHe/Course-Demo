package edu.yangtzeu.lmis.gui.panel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import org.omg.CORBA.PRIVATE_MEMBER;

import edu.yangtzeu.lmis.bll.BookAdmin;
import edu.yangtzeu.lmis.model.Book;
import edu.yangtzeu.lmis.model.CustomizedTableModel;
import edu.yangtzeu.lmis.model.Reader;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.Thread.State;

import javax.swing.DefaultComboBoxModel;

public class QueryBookPanel extends JPanel {

	private JTable searchResultJTable ;
	private JPanel easyPanel;
	private JPanel highPanel;
	private JPanel CardPanel;
	private JPanel functionPanel;
//	private JPanel modifyBookContainPanel;
//	private JPanel modifyBookPanel;
	
	private JButton btnEasyCard;
	private JButton btnHighCard;
	private JButton btnModify;
	private JButton btnDelete;
	private JButton btnToExcel;
	private JButton btnReturn;
	private JButton btnEasyQuery;
	private JButton btnHighQuery;
	
	private final String easyPanelName = "JPanel1";
	private final String highPanelName = "JPanel2";
	
	private BookAdmin bookBll = new BookAdmin();
	public static Book book;


	private JTextField tfEasyQuery;
	private JTextField tfBKName;
	private JTextField tfBKDesc;
	private JTextField tfBKPress;
	private JTextField tfCatalog;
	private JTextField tfBKAutohr;
	private JTextField tfBKYear;
	private JComboBox<Object> cbEasyQuery;
	
	public QueryBookPanel() {
		setLayout(null);
		
		initModifyBookPanel();
	
		initEasyPanel();
		initHighPanel();
		initSearchResultPanel();
		initListenet();
		initCardPanel();

	}
	public void initEasyPanel(){
		easyPanel= new JPanel();
		easyPanel.setLayout(null);
		
		JLabel label = new JLabel("检索字段");
	
		label.setBounds(0, 0, 946, 100);
		easyPanel.add(label);
		
		cbEasyQuery = new JComboBox<Object>();
		cbEasyQuery.setModel(new DefaultComboBoxModel(new String[] {"图书名称", "图书作者", "图书描述", "出版社名", "分类号", "出版年"}));
		cbEasyQuery.setBounds(80, 38, 172, 24);
		easyPanel.add(cbEasyQuery);
		
		tfEasyQuery = new JTextField();
		tfEasyQuery.setBounds(473, 38, 314, 24);
		easyPanel.add(tfEasyQuery);
		tfEasyQuery.setColumns(10);
		
		btnEasyQuery = new JButton("查询");
		btnEasyQuery.setBounds(819, 37, 113, 27);
		easyPanel.add(btnEasyQuery);
	}
	public void initHighPanel(){
		highPanel= new JPanel();
		highPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("图书名称");
		lblNewLabel.setBounds(14, 13, 72, 18);
		highPanel.add(lblNewLabel);
		
		tfBKName = new JTextField();
		tfBKName.setBounds(88, 10, 161, 24);
		highPanel.add(tfBKName);
		tfBKName.setColumns(10);
		
		JLabel label_1 = new JLabel("图书描述");
		label_1.setBounds(572, 16, 72, 18);
		highPanel.add(label_1);
		
		tfBKDesc = new JTextField();
		tfBKDesc.setColumns(10);
		tfBKDesc.setBounds(646, 13, 161, 24);
		highPanel.add(tfBKDesc);
		
		JLabel label_2 = new JLabel("出版社名");
		label_2.setBounds(14, 66, 72, 18);
		highPanel.add(label_2);
		
		tfBKPress = new JTextField();
		tfBKPress.setColumns(10);
		tfBKPress.setBounds(88, 63, 161, 24);
		highPanel.add(tfBKPress);
		
		JLabel label_4 = new JLabel("分类号");
		label_4.setBounds(291, 63, 72, 18);
		highPanel.add(label_4);
		
		tfCatalog = new JTextField();
		tfCatalog.setColumns(10);
		tfCatalog.setBounds(365, 60, 161, 24);
		highPanel.add(tfCatalog);
		
		JLabel label = new JLabel("图书作者");
		label.setBounds(291, 16, 72, 18);
		highPanel.add(label);
		
		tfBKAutohr = new JTextField();
		tfBKAutohr.setColumns(10);
		tfBKAutohr.setBounds(365, 13, 161, 24);
		highPanel.add(tfBKAutohr);
		
		JLabel label_3 = new JLabel("出版年");
		label_3.setBounds(572, 63, 72, 18);
		highPanel.add(label_3);
		
		tfBKYear = new JTextField();
		tfBKYear.setColumns(10);
		tfBKYear.setBounds(646, 60, 161, 24);
		highPanel.add(tfBKYear);
		
		btnHighQuery = new JButton("查询");

		btnHighQuery.setBounds(839, 33, 93, 27);
		highPanel.add(btnHighQuery);
	}
	public void initSearchResultPanel(){
		
		
		JPanel searchResultPanel = new JPanel();
		searchResultPanel.setBounds(0, 150, 946, 500);
		add(searchResultPanel);
		searchResultPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane searchResultScroll = new JScrollPane();
		searchResultPanel.add(searchResultScroll, BorderLayout.CENTER);
		CustomizedTableModel<Reader>tableModel = new CustomizedTableModel<Reader>(
				bookBll.getDisplayColumnNames(), bookBll.getMethodNames());
		searchResultJTable = new JTable(tableModel);
		//选择模式设置为选择单条记录：
		searchResultJTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		searchResultScroll.setViewportView(searchResultJTable);
		
		functionPanel = new JPanel();
		functionPanel.setBounds(0, 679, 946, 57);
		add(functionPanel);
		
		btnModify = new JButton("修改");
		functionPanel.add(btnModify);
		
		btnDelete = new JButton("删除");
		functionPanel.add(btnDelete);
		
		btnToExcel = new JButton("导出Excel");
		functionPanel.add(btnToExcel);
		
		btnReturn = new JButton("返回");
		functionPanel.add(btnReturn);
		

		
		btnEasyCard = new JButton("简单查询");
		
	
		btnEasyCard.setBounds(0, 0, 113, 27);
		add(btnEasyCard);
		
		btnHighCard = new JButton("高级查询");
		btnHighCard.setBounds(127, 0, 113, 27);
		add(btnHighCard);
	}
	private void initCardPanel() {
		CardPanel = new JPanel();
		CardPanel.setBounds(0, 30, 946, 100);
		add(CardPanel);
		CardPanel.setLayout(new CardLayout(0, 0));
		CardPanel.add(easyPanel,easyPanelName);
		CardPanel.add( highPanel,highPanelName);
		
	
		easyPanel = new JPanel();
		highPanel = new JPanel();
		
		
		
		btnEasyCard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnEasyCard.setBackground(Color.blue);
				btnHighCard.setBackground(new Color(240, 240, 240));
				CardLayout cl = (CardLayout)(CardPanel.getLayout());
				cl.show(CardPanel,easyPanelName);
				
			}
		});
		btnHighCard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnHighCard.setBackground(Color.blue);
				btnEasyCard.setBackground(new Color(240, 240, 240));
				CardLayout cl = (CardLayout)(CardPanel.getLayout());
				cl.show(CardPanel,highPanelName);
			}
		});

	}
	public void initModifyBookPanel() {
		
		//打开修改图书信息的窗口
//		modifyBookPanel = new ModifyBookPanel ();
////		modifyBookPanel.setBounds(0, 0, 1313, 723);
//		add(modifyBookPanel);
//		modifyBookPanel.setBounds(0, 0, 0, 0);
	}
	public void initListenet() {
	
		btnEasyQuery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String[] queryColumns= { "bkName","bkAuthor","bkPress","bkBrief","bkPress","bkDatePress"};
				String columnName= queryColumns[cbEasyQuery.getSelectedIndex()];
				String bkEasyName= tfEasyQuery.getText();
				Book[] books = bookBll.getBooksByColumn(columnName,bkEasyName);
				updateResultTable(books);
			}
		});
		btnHighQuery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String bkName= tfBKName.getText();
				String bkDesc= tfBKDesc.getText();
				String bkPress= tfBKPress.getText();
				String bkCata= tfCatalog.getText();
				String bkAuthor= tfBKAutohr.getText();
				String bkYear= tfBKYear.getText();
				
				Book[] books = bookBll.getBooksByColumns(bkName,bkDesc,bkPress,bkCata,bkAuthor,bkYear);
				updateResultTable(books);
			}
		});
		//改变图书信息
		btnModify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = searchResultJTable.getSelectedRow();
				if(selectedRow<0) {
					JOptionPane.showMessageDialog(null, "请先选中一条记录");
					return;
				}
				book = (Book)((CustomizedTableModel) searchResultJTable.getModel()).getObjectAt(selectedRow);
				//打开修改图书信息的窗口
				CardPanel.setBounds(0, 0, 0, 0);
				searchResultJTable.setBounds(0, 0, 0, 0);;
				easyPanel.setBounds(0, 0, 0, 0);
				highPanel.setBounds(0, 0, 0, 0);
				functionPanel.setBounds(0, 0, 0, 0);
				JPanel modifyBookPanel = new ModifyBookPanel (book);
				add(modifyBookPanel);
				modifyBookPanel.setBounds(0, 0, 1313, 723);
				
				
//				modifyBookPanel.setVisible(true);
//				modifyBookContainPanel.add(modifyBookPanel);
				
				
			}
		});
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = searchResultJTable.getSelectedRow();
				if(selectedRow<0) {
					JOptionPane.showMessageDialog(null, "请先选中一条记录");
					return;
				}
				Book book = (Book)((CustomizedTableModel) searchResultJTable.getModel()).getObjectAt(selectedRow);
				int state = bookBll.delBook(book);
				if(state == 0) {
					JOptionPane.showMessageDialog(null, "删除失败");
					return;
				}else {
					JOptionPane.showMessageDialog(null, "删除成功");
					return;
				}
			}
		});
		btnToExcel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearField();
			}
		});
	}

	public void updateResultTable(Book[]books){
		if(books.length == 0) {
			JOptionPane.showMessageDialog(null,"没有找到符合要求的记录");
			return;
		} 
		
		CustomizedTableModel<Book>tableModel = (CustomizedTableModel<Book>)searchResultJTable.getModel();
		tableModel.setRecords(books);
		//更新数据
		tableModel.fireTableDataChanged();
	}
	public void clearField(){
		tfEasyQuery.setText("");
		tfBKName.setText("");
		tfBKDesc.setText("");
		tfBKPress.setText("");
		tfCatalog.setText("");
		tfBKAutohr.setText("");
		tfBKYear.setText("");
	}
}
