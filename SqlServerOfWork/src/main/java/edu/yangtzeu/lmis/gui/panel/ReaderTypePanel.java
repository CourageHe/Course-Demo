package edu.yangtzeu.lmis.gui.panel;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import edu.yangtzeu.lmis.bll.ReaderTypeAdmin;
import edu.yangtzeu.lmis.dal.SQLHelper;
import edu.yangtzeu.lmis.model.CustomizedTableModel;
import edu.yangtzeu.lmis.model.DepartMentType;
import edu.yangtzeu.lmis.model.Reader;
import edu.yangtzeu.lmis.model.ReaderType;

import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class ReaderTypePanel extends JPanel {
	private JTextField tfRdTypeName;
	private JTextField tfCanLendQty;
	private JTextField tfCanLendDay;
	private JTextField tfCanContinueTimes;
	private JTextField tfPunishRate;
	private JTextField tfDateValid;

	private JButton btnNewRdType;
	private JButton btnUpdateRdType;
	private JButton btnDelRdType;
	private JButton btnCancelButton;
	private JButton btnReturnType;
	
	private JTable searchResultJTable;
	private int currentRdType;

	private ReaderTypeAdmin readerTypeBll = new ReaderTypeAdmin();
	
	public ReaderTypePanel() {
		setLayout(null);
		
		initSearchPanel();
		initSearchResultPanel();
		initFunctionCtrlPanel();
		initListener();
		
		//更新查询结果
		updateResultTable(readerTypeBll.getReaderTypes());
		}
	public void initSearchPanel() {
		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(0, 0, 746, 205);
		add(searchPanel);
		searchPanel.setLayout(null);
		
		JLabel label1 = new JLabel("类型名称");
		label1.setBounds(14, 27, 72, 18);
		searchPanel.add(label1);
		
		tfRdTypeName = new JTextField();
		tfRdTypeName.setBounds(100, 24, 86, 24);
		searchPanel.add(tfRdTypeName);
		tfRdTypeName.setColumns(10);
		
		JLabel label2 = new JLabel("可借数量");
		label2.setBounds(266, 30, 72, 18);
		searchPanel.add(label2);
		
		tfCanLendQty = new JTextField();
		tfCanLendQty.setColumns(10);
		tfCanLendQty.setBounds(352, 27, 86, 24);
		searchPanel.add(tfCanLendQty);
		
		JLabel lable3 = new JLabel("可借天数");
		lable3.setBounds(507, 24, 72, 18);
		searchPanel.add(lable3);
		
		tfCanLendDay = new JTextField();
		tfCanLendDay.setColumns(10);
		tfCanLendDay.setBounds(593, 21, 86, 24);
		searchPanel.add(tfCanLendDay);
		
		JLabel label4 = new JLabel("可续借次数");
		label4.setBounds(14, 95, 72, 18);
		searchPanel.add(label4);
		
		tfCanContinueTimes = new JTextField();
		tfCanContinueTimes.setColumns(10);
		tfCanContinueTimes.setBounds(100, 92, 86, 24);
		searchPanel.add(tfCanContinueTimes);
		
		JLabel lable5 = new JLabel("罚金率");
		lable5.setBounds(266, 95, 72, 18);
		searchPanel.add(lable5);
		
		tfPunishRate = new JTextField();
		tfPunishRate.setColumns(10);
		tfPunishRate.setBounds(352, 92, 86, 24);
		searchPanel.add(tfPunishRate);
		
		JLabel lable6 = new JLabel("有效期");
		lable6.setBounds(507, 95, 72, 18);
		searchPanel.add(lable6);
		
		tfDateValid = new JTextField();
		tfDateValid.setColumns(10);
		tfDateValid.setBounds(593, 92, 86, 24);
		searchPanel.add(tfDateValid);
	}
	public void initSearchResultPanel() {
		
		CustomizedTableModel<ReaderType>tableModel = new CustomizedTableModel<ReaderType>(
				readerTypeBll.getDisplayColumnNames(), readerTypeBll.getMethodNames());
		JPanel searchResultPanel = new JPanel();
		searchResultPanel.setBounds(0, 206, 746, 343);
		add(searchResultPanel);
		searchResultPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane searchResultScroll = new JScrollPane();
		searchResultPanel.add(searchResultScroll, BorderLayout.CENTER);
		searchResultJTable = new JTable(tableModel);
		//选择模式设置为选择单条记录：
		searchResultJTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		searchResultScroll.setViewportView(searchResultJTable);
	}
	public void initFunctionCtrlPanel() {
		JPanel functionCtrlPanel = new JPanel();
		functionCtrlPanel.setBounds(0, 574, 749, 53);
		add(functionCtrlPanel);
		
		btnNewRdType = new JButton("添加");
	
		functionCtrlPanel.add(btnNewRdType);
		
		btnUpdateRdType = new JButton("修改");
		functionCtrlPanel.add(btnUpdateRdType);
		
		btnDelRdType = new JButton("删除");
		functionCtrlPanel.add(btnDelRdType);
		
		btnCancelButton = new JButton("取消");
		functionCtrlPanel.add(btnCancelButton);
		
		btnReturnType = new JButton("返回");
		functionCtrlPanel.add(btnReturnType);
	}
	public void setReaderToText(ReaderType rdType) {
		currentRdType = rdType.getRdType();
		tfRdTypeName.setText(String.valueOf(rdType.getRdTypeName()));
		tfCanLendQty.setText(String.valueOf(rdType.getCanLendQty()));
		tfCanLendDay.setText(String.valueOf(rdType.getCanLendDay()));
		tfCanContinueTimes.setText(String.valueOf(rdType.getCanContinueTimes()));
		tfPunishRate.setText(String.valueOf(rdType.getPunishRate()));
		tfDateValid.setText(String.valueOf(rdType.getDateValid()));
	
	}
	
	public void initListener() {
		//为table列添加监听
		ListSelectionModel selectionMode=searchResultJTable.getSelectionModel();
		selectionMode.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = searchResultJTable.getSelectedRow();
				//当更新的时候默认选中-1 模型则会报错
				if(selectedRow <0) return;
				//并填充到输入框中
				setReaderToText((ReaderType)((CustomizedTableModel) searchResultJTable.getModel()).getObjectAt(selectedRow));
				
			}
		});
	
		
		
		//新增操作
		btnNewRdType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 ReaderType rdType = getReaderTypeFromText();
				readerTypeBll.addReaderType(rdType);
				JOptionPane.showMessageDialog(null, "新增成功");
				updateResultTable(readerTypeBll.getReaderTypes());
				
				clearField();
				
			}
		});
		//更新操作
		btnUpdateRdType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 ReaderType rdType = getReaderTypeFromText();
					readerTypeBll.updateReaderType(rdType);
					JOptionPane.showMessageDialog(null, "更新成功");
					updateResultTable(readerTypeBll.getReaderTypes());
					clearField();
			}
		});
		//删除操作
		btnDelRdType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ReaderType readerType = getReaderTypeFromText();
				readerTypeBll.delReaderType(readerType);
				updateResultTable(readerTypeBll.getReaderTypes());
				clearField();
			}
		});
		//取消操作
		btnCancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				clearField();
			}
		});
		//返回操作
		btnReturnType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//更新查询结果
				updateResultTable(readerTypeBll.getReaderTypes());
			}
		});
	}
	/**
	 * 从输入框中的填写数据得读者类型
	 * @return
	 */
	private ReaderType getReaderTypeFromText() {		
		ReaderType rdType = new ReaderType();
		rdType.setRdType(currentRdType);
		rdType.setCanContinueTimes(Integer.valueOf(tfCanContinueTimes.getText().trim()));
		rdType.setCanLendDay(Integer.valueOf(tfCanLendDay.getText().trim()));
		rdType.setCanLendQty(Integer.valueOf(tfCanLendQty.getText().trim()));
		rdType.setDateValid(Integer.valueOf(tfDateValid.getText().trim()));
		rdType.setPunishRate(Float.valueOf(tfPunishRate.getText().trim()));
		rdType.setRdTypeName(String.valueOf(tfRdTypeName.getText().trim()));
		
		return rdType;
		
	}
	
	public void updateResultTable(ReaderType[]rdTypes){
		if(rdTypes == null) {
			JOptionPane.showMessageDialog(null,"没有找到符合要求的记录");
			return;
		} 
		
		CustomizedTableModel<ReaderType>tableModel = (CustomizedTableModel<ReaderType>)searchResultJTable.getModel();
		tableModel.setRecords(rdTypes);
		//更新数据
		tableModel.fireTableDataChanged();
	}
	
	/**
	 * 清空输入框中的数据
	 */
	public void clearField() {
		tfRdTypeName.setText("");
		tfCanLendQty.setText("");
		tfCanLendDay.setText("");
		tfCanContinueTimes.setText("");
		tfPunishRate.setText("");
		tfDateValid.setText("");
	}
}
