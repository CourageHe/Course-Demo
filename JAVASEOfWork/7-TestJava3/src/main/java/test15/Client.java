package test15;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Client extends JFrame {

	private JPanel contentPane;
	private JTextArea dialogArea = new JTextArea();
	private JTextField inputField = new JTextField();
	private JButton sendButton = new JButton("Send");
	private JPanel jPanel = new JPanel();
	private JButton ConnectButton = new JButton("连接服务器");
	private JPanel jPanel2 = new JPanel();

	//客户端
	private Socket socket = null;
	private DataOutputStream dataOutputStream = null; 
	private DataInputStream dataInputStream = null; 
	public Client() {
		setTitle("客户端");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		add(dialogArea,BorderLayout.CENTER);
		add(jPanel, BorderLayout.SOUTH);
		add(jPanel2,BorderLayout.NORTH);
		
		jPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		inputField.setColumns(30);
		jPanel.add(inputField);
		jPanel.add(sendButton);
		jPanel2.add(ConnectButton);
		
		//添加监听事件
		ConnectButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				getConnection();
			}
		});
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

	}
	/**
	 * 与服务器取得连接
	 */
	public void getConnection() {
		try {
			socket = new Socket("localhost",9999);
			dataOutputStream = new DataOutputStream(socket.getOutputStream()); 
			dataInputStream = new DataInputStream(socket.getInputStream());
//			OutputStream out = client.getOutputStream();
//			bw = new BufferedWriter(new OutputStreamWriter(out));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Thread t = new Thread() {	
		@Override
		public void run() {
			super.run();
			try {
				while(true) {
					String message = dataInputStream.readUTF();
					dialogArea.append("Server Say："+message+"\n");
					inputField.setText("");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
	};
	t.start();
	
	}
	/**
	 * 向服务器发送信息
	 */
	public void sendMessage(String message) {
		
		try {
//			client = new Socket("127.0.0.1",9999);
//	       PrintWriter pw = new PrintWriter(client.getOutputStream());
	        
//			bw.write(message);
//			bw.flush();
			//以utf-8字符集写入信息
			dataOutputStream.writeUTF(message);
			//刷新缓存
			dataOutputStream.flush();
			inputField.setText("");
			dialogArea.append("Client Say："+message+"\n");
//			bw.close();
//			client.close();
//			client.shutdownOutput();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
