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

import edu.yangtzeu.lmis.Test;
import edu.yangtzeu.lmis.gui.panel.BorrowPanel;
import edu.yangtzeu.lmis.gui.panel.NewBookPanel;
import edu.yangtzeu.lmis.gui.panel.ReaderPanel;
import edu.yangtzeu.lmis.gui.panel.ReaderTypePanel;
import edu.yangtzeu.lmis.gui.panel.UserPanel;
import edu.yangtzeu.lmis.gui.panel.QueryBookPanel;
import edu.yangtzeu.lmis.model.Reader;

import java.awt.FlowLayout;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	
	//菜单组件
	private JMenu MN_BookMgt;
	private JMenu MN_ReaderMgt;
	private JMenu MN_BorrowMgt;
	private JMenu MN_UserMgt;

	//菜单子组件
	private JMenuItem MI_NewReader;	
	private JMenuItem MI_ReaderTypeMgt;
	private JMenuItem MI_ChangeReaderInfo;
	private JMenuItem MI_LostReader;
	private JMenuItem MI_CancelReader;
	private JMenuItem MI_NewBook;
	private JMenuItem MI_ChangeBookInfo;
	private JMenuItem MI_Borror;
	private JMenuItem MI_Renew;
	private JMenuItem MI_Return;
	private JMenuItem MI_PermissionMgt;
	private JMenuItem MI_UpdatePassword;
	
	//子窗体内容名
	private final String blankPanelName = "Blank";
	private final String readerPanelName = "Reader";	
	private final String userPanelName = "User";
	private final String readerTypePanleName = "ReaderPanel";
	private final String queryBookPanelName = "QueryBookPanel";
	private final String newBookPanelName = "NewBookPanel";; 
	private final String borrowPanelName =	"BorrowPanel";
	
	
	private JPanel cards;
	private ReaderPanel readerPanel;
	private QueryBookPanel queryBookPanel;
	private NewBookPanel newBookPanel;
	private UserPanel userPanel;
	private ReaderTypePanel readerTypePanel;
	private BorrowPanel borrowPanel;
	
	private Reader reader = LoginFrame.reader;
	//测试使用
//	private Reader reader = Test.reader;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("长江大学图书馆管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1296, 890);
		initComponents();
		initMenu();
		initCardPanel();
		
	}
	private void initCardPanel() {
		JPanel blankPanel = new JPanel();
		
		readerPanel = new ReaderPanel();
		readerPanel.setVisible(true);

				
		readerTypePanel = new ReaderTypePanel();
		readerTypePanel.setVisible(true);
		
		newBookPanel = new NewBookPanel();
		newBookPanel.setVisible(true);
		
		queryBookPanel = new QueryBookPanel();
		queryBookPanel.setVisible(true);


		
		borrowPanel= new BorrowPanel();
		borrowPanel.setVisible(true);
			
		userPanel = new UserPanel();
		userPanel.setVisible(true);

		
		/**
		 * CardLayout是Swing众多布局管理器中的一种，每次只允许该容器中一个组件可见
		 */
		cards= new JPanel(new CardLayout());
		cards.setBounds(0, 0, 1274, 800);
		cards.add(blankPanel,blankPanelName);
		cards.add(readerPanel,readerPanelName);
		cards.add(readerTypePanel,readerTypePanleName);
		cards.add(newBookPanel, newBookPanelName);
		cards.add(queryBookPanel,queryBookPanelName );
		cards.add(borrowPanel, borrowPanelName);
		cards.add(userPanel,userPanelName);
		getContentPane().add(cards);
	
	
		//JmenuItem 不能监听mouseClicked事件
//		/*MN_ReaderMgt*/MI_ChangeReaderInfo.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				CardLayout cl = (CardLayout)(cards.getLayout());
//				cl.show(cards,readerPanelName);
//			}
//		});
		MI_ChangeReaderInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards,readerPanelName);
			}
		});
		MI_ReaderTypeMgt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards,readerTypePanleName);
			}
		});
		MI_NewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards,newBookPanelName);
			}
		});
		
		MI_ChangeBookInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards,queryBookPanelName);
			}
		});
		
		
		MI_Borror.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards,borrowPanelName);
			}
		});
		
		MN_UserMgt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
		
		MI_NewReader = new JMenuItem("办理借书证");
		MN_ReaderMgt.add(MI_NewReader);
		
		MI_ChangeReaderInfo = new JMenuItem("借书证信息变更");
		MN_ReaderMgt.add(MI_ChangeReaderInfo);
		
		MI_LostReader = new JMenuItem("借书证挂失与解除");
		MN_ReaderMgt.add(MI_LostReader);
		
		MI_CancelReader = new JMenuItem("注销借书证");
		MN_ReaderMgt.add(MI_CancelReader);
		
		MI_ReaderTypeMgt = new JMenuItem("读者类型管理");
	
		MN_ReaderMgt.add(MI_ReaderTypeMgt);
		
		menuBar_1.add(MN_ReaderMgt);
		
		setJMenuBar(menuBar_1);
		
		MN_BookMgt = new JMenu("图书管理");
		menuBar_1.add(MN_BookMgt);
		
		MI_NewBook = new JMenuItem("新书入库");
	
		MN_BookMgt.add(MI_NewBook);
		
		MI_ChangeBookInfo = new JMenuItem("图书信息维护");
	
		MN_BookMgt.add(MI_ChangeBookInfo);
		
		MN_BorrowMgt = new JMenu("借阅管理");
		menuBar_1.add(MN_BorrowMgt);
		
		MI_Borror = new JMenuItem("借书");
	
		MN_BorrowMgt.add(MI_Borror);
		
		MI_Renew = new JMenuItem("续借");
		MN_BorrowMgt.add(MI_Renew);
		
		MI_Return = new JMenuItem("还书");
		MN_BorrowMgt.add(MI_Return);
		
		MN_UserMgt = new JMenu("用户管理");
		menuBar_1.add(MN_UserMgt);
		
		MI_PermissionMgt = new JMenuItem("权限管理");
		MN_UserMgt.add(MI_PermissionMgt);
		
		MI_UpdatePassword = new JMenuItem("密码修改");
		MN_UserMgt.add(MI_UpdatePassword);
	}
	/**
	 * 分配权限
	 */
	private void initMenu() {
		MN_ReaderMgt.setEnabled(reader.isReaderAdmin());
		 MN_BookMgt.setEnabled(reader.isBookAdmin());
		 MN_BorrowMgt.setEnabled(reader.isBorrowAdmin());
		 MN_UserMgt.setEnabled(reader.isSysAdmin());
	}

	
}
