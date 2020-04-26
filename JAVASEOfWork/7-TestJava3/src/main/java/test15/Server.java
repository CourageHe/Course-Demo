package test15;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Server extends JFrame {

	private JPanel contentPane;
	private JTextArea dialogArea = new JTextArea();
	private JTextField inputField = new JTextField();
	private JButton sendButton = new JButton("Send");
	private JPanel jPanel = new JPanel();

	//客户端
	private Socket socket;
	private ServerSocket server;
    // 服务端读取客户端数据输入流 
    private DataInputStream dataInputStream = null; 
	private DataOutputStream dataOutputStream = null; 
	public Server() {
		setTitle("服务器");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		getContentPane().add(dialogArea,BorderLayout.CENTER);
		getContentPane().add(jPanel, BorderLayout.SOUTH);
		jPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		inputField.setColumns(30);
		jPanel.add(inputField);
		jPanel.add(sendButton);
		
		//添加监听事件
		sendButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				sendMessage(inputField.getText());
				
			}
		});
		
		//关机
//		addWindowListener(new WindowAdapter(){
//			
//			public void windowOpened(WindowEvent e) {
//				setVisible(false);
//				System.exit(0);
//				
//			}
//		});
		 startServer();
	}
	/**
	 * 开启服务器
	 */
	public void startServer() {
		server = null;
			try {
				server = new ServerSocket(9999);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Thread t = new Thread() {
				@Override
				public void run() {
					super.run();
					try {
						//进入阻塞状态 等待客户端链接
						socket = server.accept();
						 // 获取客户端输入流 
				        dataInputStream = new DataInputStream(socket.getInputStream()); 
				        dataOutputStream = new DataOutputStream(socket.getOutputStream());
						while(true) {
							String message = dataInputStream.readUTF(); 
							if(message != null) {
								dialogArea.append("Client Say："+message+"\n");
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
			
		};
		t.start();

	}
	/**
	 * 向客户端发送信息
	 * @param message
	 */
	public void sendMessage(String message) {
		try {
			
			dataOutputStream.writeUTF(message);
			dataOutputStream.flush();
			dialogArea.append("Server Say："+message+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server frame = new Server();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
