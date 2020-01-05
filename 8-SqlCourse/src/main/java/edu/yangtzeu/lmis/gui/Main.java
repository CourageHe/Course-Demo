package edu.yangtzeu.lmis.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.yangtzeu.lmis.gui.panel.BookPanel;
import edu.yangtzeu.lmis.gui.panel.BorrowPanel;
import edu.yangtzeu.lmis.gui.panel.ReaderPanel;
import edu.yangtzeu.lmis.gui.panel.UserPanel;
import edu.yangtzeu.lmis.model.Reader;

import java.awt.FlowLayout;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

public class Main extends JFrame {

	private JPanel contentPane;

	
	//菜单组件
	private JMenu MN_BookMgt;
	private JMenu MN_ReaderMgt;
	private JMenu MN_BorrowMgt;
	private JMenu MN_UserMgt;
	
	//子窗体内容名
	private final String blankPanelName = "Blank";
	private final String readerPanelName = "Reader";
	private final String bookPanelName = "Book";
	private final String borrowPanelName = "Borrow";	
	private final String userPanelName = "User";

	private JPanel cards;
	private ReaderPanel readerPanel;
	private BookPanel bookPanel;
	private BorrowPanel borrowPanel;
	private UserPanel userPanel;
	
	private Reader reader = Login.reader;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setTitle("长江大学图书馆管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1058, 752);
		initComponents();
		initMenu();
		initCardPanel();
		
	}
	private void initCardPanel() {
		JPanel blankPanel = new JPanel();
		readerPanel = new ReaderPanel();
		readerPanel.setVisible(true);
		
		bookPanel = new BookPanel();
		bookPanel.setVisible(true);
		
		borrowPanel = new BorrowPanel();
		borrowPanel.setVisible(true);
		
		userPanel = new UserPanel();
		userPanel.setVisible(true);
		
		
		/**
		 * CardLayout是Swing众多布局管理器中的一种，每次只允许该容器中一个组件可见
		 */
		cards= new JPanel(new CardLayout());
		cards.add(blankPanel,blankPanelName);
		cards.add(readerPanel,readerPanelName);
		cards.add(bookPanel,bookPanelName);
		cards.add(borrowPanel,borrowPanelName);
		cards.add(borrowPanel,userPanelName);
		getContentPane().add(cards);
	
		MN_BookMgt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards,bookPanelName);
				
			}
		});
		MN_ReaderMgt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards,readerPanelName);
				
			}
		});
		MN_BorrowMgt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards,borrowPanelName);
				
			}
		});
		MN_UserMgt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards,userPanelName);
				
			}
		});
	}
	
	/**
	 * 初始化组件
	 */
	private void initComponents() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		//菜单组件
				JMenuBar menuBar_1 = new JMenuBar();// 创建菜单栏MenuBar
//				contentPane.add(menuBar_1);
				
				MN_ReaderMgt = new JMenu("读者管理");
//				MN_ReaderMgt.setBounds(94, 15, 69, 24);
//				contentPane.add(MN_ReaderMgt);
				
				JMenuItem MI_NewReader = new JMenuItem("办理借书证");
				MN_ReaderMgt.add(MI_NewReader);
				
				JMenuItem MI_ChangeReaderInfo = new JMenuItem("借书证信息变更");
				MN_ReaderMgt.add(MI_ChangeReaderInfo);
				
				JMenuItem MI_LostReader = new JMenuItem("借书证挂失与解除");
				MN_ReaderMgt.add(MI_LostReader);
				
				JMenuItem MI_CancelReader = new JMenuItem("注销借书证");
				MN_ReaderMgt.add(MI_CancelReader);
				
				JMenuItem MI_ReaderTypeMgt = new JMenuItem("读者类型管理");
				MN_ReaderMgt.add(MI_ReaderTypeMgt);
				
				menuBar_1.add(MN_ReaderMgt);
				
				setJMenuBar(menuBar_1);
				
				MN_BookMgt = new JMenu("图书管理");
				menuBar_1.add(MN_BookMgt);
				
				JMenuItem MI_NewBook = new JMenuItem("新书入库");
				MN_BookMgt.add(MI_NewBook);
				
				JMenuItem MI_ChangeBookInfo = new JMenuItem("图书信息维护");
				MN_BookMgt.add(MI_ChangeBookInfo);
				
				MN_BorrowMgt = new JMenu("借阅管理");
				menuBar_1.add(MN_BorrowMgt);
				
				JMenuItem MI_Borror = new JMenuItem("借书");
				MN_BorrowMgt.add(MI_Borror);
				
				JMenuItem MI_Renew = new JMenuItem("续借");
				MN_BorrowMgt.add(MI_Renew);
				
				JMenuItem MI_Return = new JMenuItem("还书");
				MN_BorrowMgt.add(MI_Return);
				
				MN_UserMgt = new JMenu("用户管理");
				menuBar_1.add(MN_UserMgt);
				
				JMenuItem MI_PermissionMgt = new JMenuItem("权限管理");
				MN_UserMgt.add(MI_PermissionMgt);
				
				JMenuItem MI_UpdatePassword = new JMenuItem("密码修改");
				MN_UserMgt.add(MI_UpdatePassword);
	}
	/**
	 * 分配权限
	 */
	private void initMenu() {
		MN_BookMgt.setEnabled(reader.isBookAdmin());
		MN_ReaderMgt.setEnabled(reader.isReaderAdmin());
		MN_BorrowMgt.setEnabled(reader.isBorrowAdmin());
		MN_UserMgt.setEnabled(reader.isSysAdmin());
		
	}
	
}
