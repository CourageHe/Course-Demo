package com.couragehe.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.couragehe.dao.UserDao;
import com.couragehe.entity.User;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField tf_name;
	private JTextField tf_pass;
	private JLabel lb_pass;
	
	private UserDao  dao = new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf_name = new JTextField();
		tf_name.setBounds(191, 173, 179, 24);
		contentPane.add(tf_name);
		tf_name.setColumns(10);
		
		JLabel lb_name = new JLabel("用户名");
		lb_name.setBounds(124, 176, 72, 18);
		contentPane.add(lb_name);
		
		tf_pass = new JTextField();
		tf_pass.setColumns(10);
		tf_pass.setBounds(191, 233, 179, 24);
		contentPane.add(tf_pass);
		
		lb_pass = new JLabel("密码");
		lb_pass.setBounds(124, 236, 72, 18);
		contentPane.add(lb_pass);
		
		JButton btn_login = new JButton("登录");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userName = tf_name.getText();
				String password = tf_pass.getText();
				User user = dao.findUser(userName, password);
				
				
			}
		});
		btn_login.setBounds(323, 334, 113, 27);
		contentPane.add(btn_login);
	}
}
