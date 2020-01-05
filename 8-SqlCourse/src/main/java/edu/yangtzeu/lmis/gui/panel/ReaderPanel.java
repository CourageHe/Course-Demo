/*
 * @Author: your name
 * @Date: 2019-12-06 17:24:19
 * @LastEditTime: 2019-12-10 00:21:07
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \8-SqlCourse\src\main\java\edu\yangtzeu\lmis\gui\panel\ReaderPanel.java
 */
package edu.yangtzeu.lmis.gui.panel;

import javax.imageio.ImageIO;
import javax.naming.InitialContext;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import edu.yangtzeu.lmis.bll.DeptTypeAdmin;
import edu.yangtzeu.lmis.bll.ReaderAdmin;
import edu.yangtzeu.lmis.bll.ReaderTypeAdmin;
import edu.yangtzeu.lmis.dal.SQLHelper;
import edu.yangtzeu.lmis.model.CustomizedTableModel;
import edu.yangtzeu.lmis.model.DepartMentType;
import edu.yangtzeu.lmis.model.Reader;
import edu.yangtzeu.lmis.model.ReaderType;

import java.awt.BorderLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.filechooser.FileFilter;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;


public class ReaderPanel extends JPanel {
	private JTextField tfUserName;
	private JTextField tfReaderID;
	private JTextField tfReaderName;
	private JPasswordField passwordField;
	private JTextField tfNumBorrowed;
	private JTextField tfReaderStatus;
	private JTextField tfReaderRole;
	private JTextField tfEmail;
	private JTextField tfDate;

	
	private JTable searchResultJTable;
	private JLabel lblPhoto;
	private JComboBox rdTypeComboBox;
	private JComboBox deptTypeComboBox;


	private JPanel searchPanel ;
	private JPanel searchResultPanel;
	private JPanel readerInfoPanel;
	private JPanel functionCtrlPanel;
	private JPanel editCtrlPanel ;

	private JButton btnAddReader;
	private JButton btnSubmitUpdate;
	private JButton btnCancelEdit;
	private JButton  btnClose;
	private JButton  btnCancelReader;
	private JButton  btnFound;
	private JButton  btnLost;
	private JButton  btnUpdateReader;
	private JButton  btnNewReader;
	private JButton btnLoadPictureFile;
	private JButton btnQuery;
	private JButton btnToExcel;

	private ReaderTypeAdmin readerTypeBll = new ReaderTypeAdmin();
	private DeptTypeAdmin deptTypeBll = new DeptTypeAdmin();
	
	private ReaderAdmin readerBll = new ReaderAdmin();
	
	private String[]dispColNames = new String[] {"ID","姓名","性别","类型","院系","电话","Email","状态","已借书数量","注册日期"};
	private String[] methodNames = new String[] {"getRdID","getRdName","getRdSex","getRdType","getRdDept","getRdPhone","getRdEmail","getRdStatus","getRdBorrowQty","getRdDateReg"};
	//示3种窗口操作状态
	private enum OpStatus{inSelect ,inNew,inChange};
	private OpStatus ops;
	private JTextField tfReaderPhone;
	private JComboBox cbGender;
	private JComboBox cbDeptType;
	private JComboBox cbReaderType;
	private void setStatus(OpStatus opst) {
		ops = opst;
		switch(ops) {
		case inSelect:		
			searchPanel.setEnabled(true); ;
			searchResultPanel.setEnabled(true);;
			functionCtrlPanel.setEnabled(true);;
			
			this.setComponentStatusInPanel(functionCtrlPanel,true);
			
			readerInfoPanel.setEnabled(false);
			readerInfoPanel.setVisible(false);
			editCtrlPanel.setEnabled(false) ;
			editCtrlPanel.setVisible(false);
			this.setComponentStatusInPanel(editCtrlPanel,false);
			break;
		case inNew:
			searchPanel.setEnabled(false); ;
			searchResultPanel.setEnabled(false);;
			functionCtrlPanel.setEnabled(false);;
			
//			this.setComponentStatusInPanel(functionCtrlPanel,false);
			
			readerInfoPanel.setEnabled(true);
			readerInfoPanel.setVisible(true);
			editCtrlPanel.setEnabled(true) ;
			editCtrlPanel.setVisible(true);
			this.setComponentStatusInPanel(editCtrlPanel,true);
			btnSubmitUpdate.setEnabled(false);
			
			break;
		case inChange:
			searchPanel.setEnabled(false); ;
			searchResultPanel.setEnabled(false);;
			functionCtrlPanel.setEnabled(false);;
			
			this.setComponentStatusInPanel(functionCtrlPanel,false);
			
			readerInfoPanel.setEnabled(true);
			readerInfoPanel.setVisible(true);
			editCtrlPanel.setEnabled(true) ;
			editCtrlPanel.setVisible(true);
			this.setComponentStatusInPanel(editCtrlPanel,true);
			btnAddReader.setEnabled(false);
			break;
		}
	}
	/**
	 * 开启或关闭面板内的所有组件
	 * @param panel
	 * @param status
	 */
	private void setComponentStatusInPanel(JPanel panel,boolean status) {
		for(Component comp:panel.getComponents()) {
			comp.setEnabled(status);

		}
		
	}
	public ReaderPanel() {
		setLayout(null);
		//初始化各个Panel
		initSearchPanel();
		initSearchResultPanel();
		initReaderInfoPanel();
		initFunctionControlsPanel();
		initEditControlsSearchPanel();
		//设置初始操作状态
		setStatus(OpStatus.inSelect);
		//添加动作监听器
		initListener();
	}
	private void initSearchPanel() {
		//查询条件
		searchPanel = new JPanel();
		searchPanel .setBounds(0, 0, 1040, 34);
		searchPanel.setLayout(null);
		add(searchPanel);
		
		JLabel lblNewLabel = new JLabel("读者类别：");
		lblNewLabel.setBounds(46, 9, 75, 18);
		searchPanel.add(lblNewLabel);
		
		
		rdTypeComboBox = new JComboBox/*<ReaderType>*/(readerTypeBll.getReaderTypes());
		rdTypeComboBox.setBounds(149, 6, 74, 24);
		searchPanel.add(rdTypeComboBox);
//				rdTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"教师", "本科生", "研究生", "博士"}));
		
		JLabel label = new JLabel("单位：");
		label.setBounds(281, 9, 45, 18);
		searchPanel.add(label);
	
		deptTypeComboBox = new JComboBox/*<DepartMentType>*/(deptTypeBll.getDeptTypes());
		deptTypeComboBox.setBounds(340, 6, 149, 24);
		searchPanel.add(deptTypeComboBox);
		
//				deptTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"计算机科学学院","计算机科学与技术", "软件工程", "物联网工程", "网络工程"}));
		
		JLabel label_1 = new JLabel("姓名：");
		label_1.setBounds(523, 9, 45, 18);
		searchPanel.add(label_1);
		
		tfUserName = new JTextField();
		tfUserName.setBounds(569, 6, 163, 24);
		searchPanel.add(tfUserName);
		tfUserName.setColumns(10);
		
		btnQuery = new JButton("查找");
		
		btnQuery.setBounds(793, 5, 63, 27);
		searchPanel.add(btnQuery);
		
		btnToExcel = new JButton("Excel");
	
		btnToExcel.setBounds(864, 5, 73, 27);
		searchPanel.add(btnToExcel);
	}
	private void initSearchResultPanel() {
		//查询结果
		searchResultPanel = new JPanel();
		searchResultPanel.setBounds(0, 59, 708, 547);
		add(searchResultPanel);
		searchResultPanel.setLayout(new BorderLayout(0, 0));
		JScrollPane searchResultScroll = new JScrollPane();
		searchResultScroll.setToolTipText("查询结果");
		searchResultPanel.add(searchResultScroll, BorderLayout.CENTER);
		
//				JTable searchResultJTable = new JTable();
//				searchResultScroll.setViewportView(searchResultJTable);
//				searchResultJTable.setModel(new DefaultTableModel(
//					new Object[][] {
//					},
//					dispColNames
//				));
		CustomizedTableModel<Reader>tableModel = new CustomizedTableModel<Reader>(
				readerBll.getDisplayColumnNames(), readerBll.getMethodNames());
		searchResultJTable = new JTable(tableModel);
		//选择模式设置为选择单条记录：
		searchResultJTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		searchResultScroll.setViewportView(searchResultJTable);
	}
	private void initReaderInfoPanel() {
		readerInfoPanel = new JPanel();
		readerInfoPanel.setToolTipText("");
		readerInfoPanel.setBounds(740, 58, 377, 548);
		add(readerInfoPanel);
		readerInfoPanel.setLayout(null);
		
		JLabel label_2 = new JLabel("借书证号");
		label_2.setBounds(14, 16, 60, 18);
		readerInfoPanel.add(label_2);
		
		tfReaderID = new JTextField();
		tfReaderID.setBounds(88, 13, 116, 24);
		tfReaderID.setColumns(10);
		readerInfoPanel.add(tfReaderID);
		
		JLabel label_3 = new JLabel("姓名");
		label_3.setBounds(14, 56, 60, 18);
		readerInfoPanel.add(label_3);
		
		tfReaderName = new JTextField();
		tfReaderName.setColumns(10);
		tfReaderName.setBounds(88, 53, 116, 24);
		readerInfoPanel.add(tfReaderName);
		
		JLabel label_4 = new JLabel("密码");
		label_4.setBounds(14, 96, 60, 18);
		readerInfoPanel.add(label_4);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(88, 93, 116, 24);
		readerInfoPanel.add(passwordField);
		
		JLabel label_5 = new JLabel("性别");
		label_5.setBounds(14, 136, 60, 18);
		readerInfoPanel.add(label_5);
		
		cbGender = new JComboBox();
		cbGender.setModel(new DefaultComboBoxModel(new String[] {"女", "男"}));
		cbGender.setBounds(88, 130, 116, 24);
		readerInfoPanel.add(cbGender);
		
		JLabel label_6 = new JLabel("已借书数");
		label_6.setBounds(14, 176, 75, 18);
		readerInfoPanel.add(label_6);
		
		tfNumBorrowed = new JTextField();
		tfNumBorrowed.setColumns(10);
		tfNumBorrowed.setBounds(88, 173, 116, 24);
		readerInfoPanel.add(tfNumBorrowed);
		
		JLabel label_7 = new JLabel("证件状态");
		label_7.setBounds(14, 216, 60, 18);
		readerInfoPanel.add(label_7);
		
		tfReaderStatus = new JTextField();
		tfReaderStatus.setColumns(10);
		tfReaderStatus.setBounds(88, 213, 116, 24);
		readerInfoPanel.add(tfReaderStatus);
		
		JLabel label_8 = new JLabel("读者角色");
		label_8.setBounds(14, 256, 60, 18);
		readerInfoPanel.add(label_8);
		
		tfReaderRole = new JTextField();
		tfReaderRole.setColumns(10);
		tfReaderRole.setBounds(88, 253, 116, 24);
		readerInfoPanel.add(tfReaderRole);
		
		lblPhoto = new JLabel("");
		lblPhoto.setBounds(218, 13, 145, 264);
		lblPhoto.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		readerInfoPanel.add(lblPhoto);
		
		btnLoadPictureFile = new JButton("图片文件");
	
		btnLoadPictureFile.setBounds(228, 294, 113, 27);
		readerInfoPanel.add(btnLoadPictureFile);
		
		JLabel label_10 = new JLabel("读者类别");
		label_10.setBounds(14, 298, 60, 18);
		readerInfoPanel.add(label_10);
		
		cbReaderType = new JComboBox/*<ReaderType>*/(readerTypeBll.getReaderTypes());
		cbReaderType.setBounds(88, 295, 116, 24);
		readerInfoPanel.add(cbReaderType);
		
		JLabel label_11 = new JLabel("单位");
		label_11.setBounds(14, 335, 60, 18);
		readerInfoPanel.add(label_11);
		
		
		cbDeptType = new JComboBox/*<DepartMentType>*/(deptTypeBll.getDeptTypes());
		cbDeptType.setBounds(88, 332, 169, 24);
		readerInfoPanel.add(cbDeptType);
		JLabel lable_o = new JLabel("电话号码");
		lable_o.setBounds(14, 377, 60, 18);
		readerInfoPanel.add(lable_o);
		
		tfReaderPhone = new JTextField();
		tfReaderPhone.setColumns(10);
		tfReaderPhone.setBounds(88, 374, 169, 24);
		readerInfoPanel.add(tfReaderPhone);
		
		JLabel label_12 = new JLabel("电子邮件");
		label_12.setBounds(14, 414, 60, 18);
		readerInfoPanel.add(label_12);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(88, 413, 169, 24);
		readerInfoPanel.add(tfEmail);
		
		JLabel label_13 = new JLabel("办证日期");
		label_13.setBounds(14, 451, 60, 18);
		readerInfoPanel.add(label_13);
		
		tfDate = new JTextField();
		tfDate.setColumns(10);
		tfDate.setBounds(88, 453, 169, 24);
		readerInfoPanel.add(tfDate);
		
		//用于显示读者的历史借阅记录数和未归还图书数量。
		JLabel tfReaderInfo = new JLabel("");
		tfReaderInfo.setBounds(24, 490, 233, 18);
		readerInfoPanel.add(tfReaderInfo);
		
		JLabel searchLabel = new JLabel("查询结果");
		searchLabel.setBounds(0, 40, 72, 18);
		add(searchLabel);
		
		JLabel readerLabel = new JLabel("读者信息");
		readerLabel.setBounds(740, 40, 72, 18);
		add(readerLabel);
	}
	
	private void initFunctionControlsPanel() {
		functionCtrlPanel = new JPanel();
		functionCtrlPanel.setBounds(0, 634, 708, 34);
		add(functionCtrlPanel);
		
		btnNewReader = new JButton("办理借书证");
		
		functionCtrlPanel.add(btnNewReader);
		
		btnUpdateReader = new JButton("变更信息");
		
		functionCtrlPanel.add(btnUpdateReader);
		
		btnLost = new JButton("挂失");
	
		functionCtrlPanel.add(btnLost);
		
		btnFound = new JButton("解除挂失");

		functionCtrlPanel.add(btnFound);
		
		btnCancelReader = new JButton("注销");
	
		functionCtrlPanel.add(btnCancelReader);
		
		btnClose = new JButton("退出");
		functionCtrlPanel.add(btnClose);
		
		
	}
	private void initEditControlsSearchPanel() {
		editCtrlPanel = new JPanel();
		editCtrlPanel.setBounds(740, 634, 377, 34);
		add(editCtrlPanel);
		
		btnAddReader = new JButton("确认办证");
	
		editCtrlPanel.add(btnAddReader);
		
		btnSubmitUpdate = new JButton("确认变更");
	
		editCtrlPanel.add(btnSubmitUpdate);
		
		btnCancelEdit = new JButton("取消");
		
		editCtrlPanel.add(btnCancelEdit);
	}
	/**
	 * 添加监听事件，进行状态切换
	 */
	private void initListener() {
		
		btnNewReader.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setStatus(OpStatus.inNew);
			}
		});
		
		btnUpdateReader.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = searchResultJTable.getSelectedRow();
				if(selectedRow<0) {
					JOptionPane.showMessageDialog(null, "请先选中一条记录");
					return;
				}
				//获取选中行
				setReaderToText((Reader)((CustomizedTableModel) searchResultJTable.getModel()).getObjectAt(selectedRow));
				setStatus(OpStatus.inChange);
			}
		});
		btnCancelEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setStatus(OpStatus.inSelect);
			}
		});
		//?确认办证、确认变更的Click事件该如何切换状态？
		btnAddReader.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Reader reader = getReaderFromText();
				int state = readerBll.addReader(reader);	
				if(state == 0) {
					JOptionPane.showMessageDialog( null,"添加失败");
				}else {
					JOptionPane.showMessageDialog( null,"添加成功");
					clearField();
				}
			}
		});
		
		btnSubmitUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Reader reader = getReaderFromText();
				int state =  readerBll.updateReader(reader);
				if(state == 0) {
					JOptionPane.showMessageDialog( null,"修改成功");
				}else {
					JOptionPane.showMessageDialog( null,"修改成功");
					clearField();
				}
			}
		});
		//挂失操作
		btnLost.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = searchResultJTable.getSelectedRow();
				if(selectedRow<0) {
					JOptionPane.showMessageDialog(null, "请先选中一条记录");
					return;
				}
				//获取选中行
				Reader rd = (Reader)((CustomizedTableModel) searchResultJTable.getModel()).getObjectAt(selectedRow);
				rd.setRdStatus("挂失");
				readerBll.updateReader(rd);
			}
		});
		//解除挂失操作
		btnFound.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = searchResultJTable.getSelectedRow();
				if(selectedRow<0) {
					JOptionPane.showMessageDialog(null, "请先选中一条记录");
					return;
				}
				//获取选中行
				Reader rd = (Reader)((CustomizedTableModel) searchResultJTable.getModel()).getObjectAt(selectedRow);
				rd.setRdStatus("有效");
				readerBll.updateReader(rd);
			
			}
		});
		//注销操作
		btnCancelReader.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = searchResultJTable.getSelectedRow();
				if(selectedRow<0) {
					JOptionPane.showMessageDialog(null, "请先选中一条记录");
					return;
				}
				//获取选中行
				Reader rd = (Reader)((CustomizedTableModel) searchResultJTable.getModel()).getObjectAt(selectedRow);
				rd.setRdStatus("注销");
				readerBll.updateReader(rd);
			
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
				int returnVal = fc.showOpenDialog(ReaderPanel.this);
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
		//查询操作
		btnQuery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ReaderType rdType = (ReaderType)rdTypeComboBox.getSelectedItem();
				DepartMentType deptType = (DepartMentType)deptTypeComboBox.getSelectedItem();
				String userName = tfUserName.getText().trim();
				Reader[]hits = readerBll.retrieveReaders(rdType, deptType, userName);
				//更新查询结果
				updateResultTable(hits);
			}
		});
		
		//实现excel导出
		btnToExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	
	}
	public void setReaderToText(Reader reader) {
		tfReaderID.setText(String.valueOf(reader.getRdID()));
		tfReaderName.setText(String.valueOf(reader.getRdName()));
		passwordField.setText(String.valueOf(reader.getRdPwd()));
		tfNumBorrowed.setText(String.valueOf(reader.getRdBorrowQty()));
		tfReaderStatus.setText(String.valueOf(reader.getRdStatus()));
		tfReaderRole.setText(String.valueOf(reader.getRdAdminRoles()));
		tfReaderPhone.setText(String.valueOf(reader.getRdPhone()));
		tfEmail.setText(String.valueOf(reader.getRdEmail()));
		tfDate.setText(String.valueOf(reader.getRdDateReg()));
		cbGender.setSelectedItem(reader.getRdSex());
		
		
		//需重写Equals方法 自动调用
		cbReaderType.setSelectedItem(readerTypeBll.getObjectById(reader.getRdType()));
		cbDeptType.setSelectedItem(deptTypeBll.getObjectById(reader.getRdDept()));
		if(reader.getRdPhoto()!= null) {
			try {
				Image image= ImageIO.read(reader.getRdPhoto());
				lblPhoto.setIcon(new ImageIcon(image));
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	private Reader getReaderFromText() {
		Reader reader = new Reader();
		reader.setRdID(Integer.valueOf(tfReaderID.getText()));
		reader.setRdName(String.valueOf(tfReaderName.getText()));
		reader.setRdPwd(String.valueOf(passwordField.getPassword()));
		reader.setRdSex(String.valueOf(cbGender.getSelectedItem().toString()));
		reader.setRdType(Integer.valueOf(((ReaderType) cbReaderType.getSelectedItem()).getRdType()));
		reader.setRdDept(Integer.valueOf(((DepartMentType)cbDeptType.getSelectedItem()).getDpType()));
		reader.setRdPhone(String.valueOf(tfReaderPhone.getText().trim()));
		reader.setRdEmail(String.valueOf(tfEmail.getText().trim()));
		reader.setRdStatus(String.valueOf(tfReaderStatus.getText().trim()));
		Date dateReg =  SQLHelper.parseDatetime(String.valueOf(tfDate.getText().trim()));
		reader.setRdDateReg(dateReg);
		
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
			reader.setRdPhoto(fis);
		}
		return reader;
		
	}
	public void updateResultTable(Reader[]readers){
		if(readers == null) {
			JOptionPane.showMessageDialog(null,"没有找到符合要求的记录");
			return;
		} 
		CustomizedTableModel<Reader>tableModel = (CustomizedTableModel<Reader>)searchResultJTable.getModel();
		tableModel.setRecords(readers);
		//更新数据
		tableModel.fireTableDataChanged();
	}
	public void clearField() {
		tfUserName.setText("");
		tfReaderID.setText("");
		tfReaderName.setText("");
		passwordField.setText("");;
		tfNumBorrowed.setText("");
		tfReaderStatus.setText("");
		tfReaderRole.setText("");
		tfEmail.setText("");
		tfDate.setText("");
		lblPhoto.setIcon(null);
	}
}

//https://blog.csdn.net/wangxiaojingo/article/details/8927170 JLable的使用方法
