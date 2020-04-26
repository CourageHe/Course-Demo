package edu.yangtzeu.lmis.gui.panel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.swing.filechooser.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.swing.JTextField;

import edu.yangtzeu.lmis.bll.BookAdmin;
import edu.yangtzeu.lmis.dal.SQLHelper;
import edu.yangtzeu.lmis.model.Book;
import edu.yangtzeu.lmis.model.CustomizedTableModel;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
/**
 * 新书入库Panel
 * @author CourageHe
 *
 */
public class ModifyBookPanel extends JPanel {
	private JTextField tfBkID;
	private JTextField tfBkCode;
	private JTextField tfBkName;
	private JTextField tfBkAuthor;
	private JTextField tfBkPress;
	private JTextField tfBkDatePress;
	private JTextField tfBkISBN;
	private JTextField tfBkCatName;
	private JTextField tfBkPages;
	private JTextField tfBkPrices;
	private JTextField tfBkDateIn;
	private JTextField tfBkNum;
	private JComboBox cbBkLanguage;

	private JLabel lblPhoto;
	private JTextArea taBkBriefArea;
	
	
	private JButton btnAdd; 
	private JButton btnCancel; 
	private JButton btnReturn; 
	private JButton btnLoadPictureFile; 
	
	private BookAdmin bookBll = new BookAdmin();
	/**
	 * Create the panel.
	 */
	public ModifyBookPanel(Book book) {
		setLayout(null);
	
		initBookInfoPanel();
		initFunctionPanel();
		initcoverPanel();
		initListener();
		setReaderToText(book);

	}
	public void initBookInfoPanel(){
	
		JPanel bookInfoPanel = new JPanel();
		bookInfoPanel.setBounds(0, 0, 835, 744);
		add(bookInfoPanel);
		bookInfoPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("图书馆起始序号");
		lblNewLabel_1.setBounds(0, 65, 109, 18);
		bookInfoPanel.add(lblNewLabel_1);
		
		tfBkID = new JTextField();
		tfBkID.setEditable(false);
		tfBkID.setBounds(110, 62, 230, 24);
		bookInfoPanel.add(tfBkID);
		tfBkID.setColumns(10);
		
		JLabel label_1 = new JLabel("索书号");
		label_1.setBounds(14, 114, 72, 18);
		bookInfoPanel.add(label_1);
		
		tfBkCode = new JTextField();
		tfBkCode.setColumns(10);
		tfBkCode.setBounds(110, 111, 230, 24);
		bookInfoPanel.add(tfBkCode);
		
		JLabel label_2 = new JLabel("图书名称");
		label_2.setBounds(14, 169, 72, 18);
		bookInfoPanel.add(label_2);
		
		tfBkName = new JTextField();
		tfBkName.setColumns(10);
		tfBkName.setBounds(110, 166, 230, 24);
		bookInfoPanel.add(tfBkName);
		
		JLabel label_3 = new JLabel("图书作者");
		label_3.setBounds(14, 220, 72, 18);
		bookInfoPanel.add(label_3);
		
		tfBkAuthor = new JTextField();
		tfBkAuthor.setColumns(10);
		tfBkAuthor.setBounds(110, 217, 230, 24);
		bookInfoPanel.add(tfBkAuthor);
		
		JLabel label_4 = new JLabel("出版社");
		label_4.setBounds(14, 269, 72, 18);
		bookInfoPanel.add(label_4);
		
		tfBkPress = new JTextField();
		tfBkPress.setColumns(10);
		tfBkPress.setBounds(110, 266, 230, 24);
		bookInfoPanel.add(tfBkPress);
		
		JLabel label_5 = new JLabel("出版日期");
		label_5.setBounds(14, 322, 72, 18);
		bookInfoPanel.add(label_5);
		
		tfBkDatePress = new JTextField();
		tfBkDatePress.setColumns(10);
		tfBkDatePress.setBounds(110, 319, 230, 24);
		bookInfoPanel.add(tfBkDatePress);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(14, 371, 72, 18);
		bookInfoPanel.add(lblIsbn);
		
		tfBkISBN = new JTextField();
		tfBkISBN.setColumns(10);
		tfBkISBN.setBounds(110, 368, 230, 24);
		bookInfoPanel.add(tfBkISBN);
		
		JLabel label_7 = new JLabel("分类名");
		label_7.setBounds(14, 418, 72, 18);
		bookInfoPanel.add(label_7);
		
		tfBkCatName = new JTextField();
		tfBkCatName.setColumns(10);
		tfBkCatName.setBounds(110, 415, 230, 24);
		bookInfoPanel.add(tfBkCatName);
		
		JLabel label_9 = new JLabel("语种");
		label_9.setBounds(14, 467, 72, 18);
		bookInfoPanel.add(label_9);
		
		cbBkLanguage = new JComboBox();
		cbBkLanguage.setModel(new DefaultComboBoxModel(new String[] {"中文", "英文", "日文", "俄文", "德文"}));
		cbBkLanguage.setBounds(110, 465, 230, 24);
		bookInfoPanel.add(cbBkLanguage);
		
		JLabel label_10 = new JLabel("图书页数");
		label_10.setBounds(14, 514, 72, 18);
		bookInfoPanel.add(label_10);
		
		tfBkPages = new JTextField();
		tfBkPages.setColumns(10);
		tfBkPages.setBounds(110, 511, 230, 24);
		bookInfoPanel.add(tfBkPages);
		
		JLabel label_11 = new JLabel("图书价格");
		label_11.setBounds(14, 570, 72, 18);
		bookInfoPanel.add(label_11);
		
		tfBkPrices = new JTextField();
		tfBkPrices.setColumns(10);
		tfBkPrices.setBounds(110, 567, 230, 24);
		bookInfoPanel.add(tfBkPrices);
		
		JLabel label_12 = new JLabel("入馆日期");
		label_12.setBounds(14, 621, 72, 18);
		bookInfoPanel.add(label_12);
		
		tfBkDateIn = new JTextField();
		tfBkDateIn.setColumns(10);
		tfBkDateIn.setBounds(110, 618, 230, 24);
		bookInfoPanel.add(tfBkDateIn);
		
		JLabel label_6 = new JLabel("图书本数");
		label_6.setBounds(14, 665, 72, 18);
		bookInfoPanel.add(label_6);
		
		tfBkNum = new JTextField();
		tfBkNum.setColumns(10);
		tfBkNum.setBounds(110, 662, 230, 24);
		bookInfoPanel.add(tfBkNum);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(420, 62, 398, 540);
		bookInfoPanel.add(scrollPane);
		
		taBkBriefArea = new JTextArea();
		scrollPane.setViewportView(taBkBriefArea);
		taBkBriefArea.setLineWrap(true);        //激活自动换行功能 
		taBkBriefArea.setWrapStyleWord(true);
		
		JLabel lblNewLabel = new JLabel("内容简介");
		lblNewLabel.setBounds(0, 0, 96, 52);
		bookInfoPanel.add(lblNewLabel);
	}
	public void initFunctionPanel(){
		JPanel functionPanel = new JPanel();
		functionPanel.setBounds(451, 697, 398, 54);
		add(functionPanel);
		functionPanel.setLayout(null);
		
		btnCancel = new JButton("取消");
		btnCancel.setBounds(285, 27, 113, 27);
		functionPanel.add(btnCancel);
		
		btnReturn = new JButton("返回");
		btnReturn.setBounds(140, 27, 113, 27);
		functionPanel.add(btnReturn);
		
		btnAdd = new JButton("保存修改");
		btnAdd.setBounds(0, 27, 113, 27);
		functionPanel.add(btnAdd);
		
	}
	public void initcoverPanel(){
		JPanel coverPanel = new JPanel();
		coverPanel.setBounds(833, 0, 459, 713);
		add(coverPanel);
		coverPanel.setLayout(null);
		
		lblPhoto = new JLabel("");
		lblPhoto.setBounds(43, 59, 365, 553);
		lblPhoto.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		coverPanel.add(lblPhoto);
		
		btnLoadPictureFile = new JButton("修改图片");
		btnLoadPictureFile.setBounds(189, 648, 93, 27);
		coverPanel.add(btnLoadPictureFile);
		
		JLabel label_13 = new JLabel("封面");
		label_13.setBounds(43, 43, 60, 18);
		coverPanel.add(label_13);
	}
		public void setReaderToText(Book book) {
//		currentRdType = rdType.getRdType();
//		tfRdTypeName.setText(String.valueOf(rdType.getRdTypeName()));
//		tfCanLendQty.setText(String.valueOf(rdType.getCanLendQty()));
//		tfCanLendDay.setText(String.valueOf(rdType.getCanLendDay()));
//		tfCanContinueTimes.setText(String.valueOf(rdType.getCanContinueTimes()));
//		tfPunishRate.setText(String.valueOf(rdType.getPunishRate()));
//		tfDateValid.setText(String.valueOf(rdType.getDateValid()));
			

			tfBkID.setText(String.valueOf(book.getBkID()));
			tfBkCode.setText(String.valueOf(book.getBkCode()));
			tfBkName.setText(String.valueOf(book.getBkName()));
			tfBkAuthor.setText(String.valueOf(book.getBkAuthor()));
			tfBkPress.setText(String.valueOf(book.getBkPress()));
			tfBkDatePress.setText(String.valueOf(book.getBkDatePress()));
			tfBkISBN.setText(String.valueOf(book.getBkISBN()));
//			tfBkCatName.setText(String.valueOf(book.getBk));
			tfBkPages.setText(String.valueOf(book.getBkPages()));
			tfBkPrices.setText(String.valueOf(book.getBkPress()));
			tfBkDateIn.setText(String.valueOf(book.getBkDateIn()));
			
//			tfBkNum.setText(String.valueOf(book.getBk));
	
	}
	
	public void initListener() {
		
		//增加操作
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Book book= getBookFromText();
				int count = Integer.parseInt(tfBkNum.getText());
				int state = bookBll.addBook(book,count);
				if(state == 0) {
					JOptionPane.showMessageDialog( null,"添加失败");
				}else {					
					JOptionPane.showMessageDialog(null, "新增成功");
					clearField();
				}
			
				
			}
		});
		//取消操作
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearField();
			}
		});
				//返回操作
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
			}
		});
		//读者头像的读取和显示组件
		btnLoadPictureFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser fc = new JFileChooser();
				fc.addChoosableFileFilter(new FileFilter() {

				    public boolean accept(File f) {
				        String name = f.getName().toLowerCase();
				        return (name.endsWith(".png") &&
				                        name.endsWith(".jpg") &&
				                        name.endsWith(".gif") &&
				                        name.endsWith(".bmp") &&
				                        f.length() < 3 * (1024 * 1024));
				    }

				    public String getDescription() {
				        return "Images < 3mb";
				    }
				});
				int returnVal = fc.showOpenDialog(ModifyBookPanel.this);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					try {
						BufferedImage img = ImageIO.read(file);
						Image dimg = img.getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
						ImageIcon icon = new ImageIcon(dimg);
						lblPhoto.setIcon(icon);
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			}
		});

	}
	/**
	 * 从输入框中的填写数据得读者类型
	 * @return
	 */
	private Book getBookFromText() {	
	
		Book book = new Book();
//		book.setBkID(Integer.valueOf(tfBkID.getText().trim()));
		book.setBkCode(String.valueOf(tfBkCode.getText().trim()));
		book.setBkName(String.valueOf(tfBkName.getText().trim()));
		book.setBkAuthor(String.valueOf(tfBkAuthor.getText().trim()));
		book.setBkPress(String.valueOf(tfBkPress.getText().trim()));
		Date dateString1 = SQLHelper.parseDatetime(tfBkDatePress.getText().trim());
		book.setBkDatePress(dateString1);
		book.setBkISBN(String.valueOf(tfBkISBN.getText().trim()));
		
		book.setBkCatalog(String.valueOf(tfBkName.getText().trim()));
		book.setBkLanguage(cbBkLanguage.getSelectedIndex());		
		book.setBkPages(Integer.valueOf(tfBkPages.getText().trim()));
		book.setBkPrice(Float.valueOf(tfBkPrices.getText().trim()));
		Date dateString2 = SQLHelper.parseDatetime(tfBkDateIn.getText().trim());
		book.setBkDateIn(dateString2);
		book.setBkBrief(String.valueOf(taBkBriefArea.getText().trim()));
		book.setBkStatus(String.valueOf("在馆"));
		

		if(lblPhoto.getIcon()!=null) {
			Image image = ((ImageIcon)lblPhoto.getIcon()).getImage();
			BufferedImage bi = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_4BYTE_ABGR);
			Graphics2D g2 = bi.createGraphics();
			g2.drawImage(image, 0,0,null);
			g2.dispose();
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			
			try {
				ImageIO.write(bi, "png", os);
			} catch (IOException e) {
				e.printStackTrace();
			}
			InputStream fis = new ByteArrayInputStream(os.toByteArray());
			book.setBkCover(fis);
		}
		return book;
		
	}
	
	public void updateResultTable(Book[] books){
		if(books == null) {
			JOptionPane.showMessageDialog(null,"没有找到符合要求的记录");
			return;
		} 
		
//		CustomizedTableModel<Book>tableModel = (CustomizedTableModel<Book>)searchResultJTable.getModel();
//		tableModel.setRecords(books);
		//更新数据
//		tableModel.fireTableDataChanged();
	}
	
	/**
	 * 清空输入框中的数据
	 */
	public void clearField() {
		tfBkID.setText("");
		tfBkCode.setText("");
		tfBkName.setText("");
		tfBkAuthor.setText("");
		tfBkPress.setText("");
		tfBkDatePress.setText("");
		tfBkISBN.setText("");
		tfBkCatName.setText("");
		tfBkPages.setText("");
		tfBkPrices.setText("");
		tfBkDateIn.setText("");
		tfBkNum.setText("");
		
		taBkBriefArea.setText("");
		lblPhoto.setIcon(null);
	}
}
