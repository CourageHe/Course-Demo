package com.couragehe.chat.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import com.couragehe.chat.utils.Utils;

/**
 * 使用多线程封装了客户端接收端
 * 1.接受信息
 * 2.释放资源
 * 3.重写run
 * 
 */
public class Receive implements Runnable{
	private DataInputStream dis;
	private Socket client;
	private boolean  isRunning;
	public Receive(Socket client) {
		this.client = client;
		this.isRunning = true;
		try {
			dis= new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			Utils.println("---------Client Receive-----------");
			this.release(client, dis);
			e.printStackTrace();
		}
	}
	//接收消息
	public String receive() {
		String msg = "";
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
			Utils.println("---------Client receive()-----------");
			this.release(client, dis);
			e.printStackTrace();
		}
		return msg;
	}
	//释放资源
	private void release(Socket client,DataInputStream dis) {
		this.isRunning = false;
		Utils.close(client,dis);
	}
	@Override
	public void run() {
		while(isRunning) {
			String msg = this.receive();
			if(!msg.equals("")) {
				Utils.println(msg);
			}
		}
	}
	
}
