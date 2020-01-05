package edu.yangtzeu.lmis.gui;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.yangtzeu.lmis.bll.ReaderAdmin;
import edu.yangtzeu.lmis.model.Reader;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Login extends JFrame implements ActionListener{

	//窗体构件
	private JPanel contentPane;
	private JTextField tfUserName;
	private JPasswordField pwdField;
	
	private JButton btnLogin;
	private JButton btnClose;
	private JLabel labelLoginInfo;
	
	//系统逻辑
	private int loginTimes = 0;//登录次数
	private ReaderAdmin readerBLL = new ReaderAdmin();
	public static Reader reader = null;//登陆用户信息，可用于整个程序（窗体关闭之后任然可见）
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Login() {
		setTitle("长江大学图书馆管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelUsername = new JLabel("用户编号：");
		labelUsername.setBounds(141, 81, 90, 18);
		contentPane.add(labelUsername);
		
		JLabel labelPassword = new JLabel("用户密码：");
		labelPassword.setBounds(141, 139, 90, 18);
		contentPane.add(labelPassword);
		
		tfUserName = new JTextField();
		tfUserName.setBounds(219, 78, 149, 24);
		contentPane.add(tfUserName);
		tfUserName.setColumns(10);
		
		btnLogin = new JButton("登陆");
		//添加监听事件
		btnLogin.addActionListener(this);
		
		pwdField = new JPasswordField();
		pwdField.setBounds(219, 133, 149, 24);
		contentPane.add(pwdField);
		
		btnLogin.setBounds(118, 209, 113, 27);
		contentPane.add(btnLogin);
		
		btnClose = new JButton("退出");
		//添加监听事件
		btnClose.addActionListener(this);
		btnClose.setBounds(310, 209, 113, 27);
		contentPane.add(btnClose);
		
		labelLoginInfo = new JLabel("");
		labelLoginInfo.setBounds(219, 269, 189, 18);
		contentPane.add(labelLoginInfo);
	}
	  public void actionPerformed(ActionEvent e){   
		  //如果用户点击登陆按钮
		if(e.getSource()==btnLogin ){
			++loginTimes;
			String errorMsg = "";
			int rdID = -1;
			try {				
				String string = tfUserName.getText().trim();
				rdID = Integer.parseInt(tfUserName.getText().trim());
			} catch (NumberFormatException e2) {
				errorMsg = "用户名无效";
				tfUserName.requestFocus();
			}
			
			if(rdID != -1) {
				reader = readerBLL.getReader(rdID);
				if(reader==null) {
					errorMsg = "用户名无效";
					tfUserName.requestFocus();
				}else if(reader.getRdPwd().contentEquals(new String(pwdField.getPassword()).trim())) {
					//密码匹配成功 加载主窗体
					loadMainGUI();
				}else {
					errorMsg = "密码错误";
					//焦点聚焦
					pwdField.requestFocus();
				}
			}
			if(errorMsg.length()>0){
				labelLoginInfo.setText(errorMsg);
			}
			
		}
		//如果用户点击关闭按钮
		if(e.getSource()==btnClose){
			//关闭当前窗体
			dispose();
		     
		}
	 }
	  /**
	   * 当登陆成功是 装在Main主窗体
	   */
	  public void loadMainGUI() {
		  this.dispose();
		   
		  Main mainGUI = new Main();
		  mainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  mainGUI.setLocationRelativeTo(null);
		  mainGUI.setVisible(true);
		  
	  }
}
