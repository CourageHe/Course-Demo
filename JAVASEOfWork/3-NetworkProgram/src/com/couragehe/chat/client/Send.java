package com.couragehe.chat.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.couragehe.chat.utils.Utils;

/**
 * 使用多线程封装了客户发送端
 * 1.发送消息
 * 2.从控制台获取消息
 * 3.释放资源
 * 4.重写run
 * @author CourageHe
 *
 */
public class Send implements Runnable{
	private BufferedReader console;
	private DataOutputStream dos;
	private Socket client;
	private boolean isRunning;
	private String name;
	public Send(Socket client, String name) {
		isRunning = true;
		this.client = client;
		this.name = name;
		try {
			console = new BufferedReader(new InputStreamReader(System.in));
			dos = new DataOutputStream(client.getOutputStream());
			send(name);
		} catch (IOException e) {
			Utils.println("---------Client Send-----------");
			this.relese();
			e.printStackTrace();
		}
	}
	/*
	 * 用户登陆
	 */
	public void login() {
		
	}
	/*
	 * 用户注册
	 */
	public void register() {
		
	}
	private void send(String msg) {
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			Utils.println("---------Client Send-----------");
			this.relese();
			e.printStackTrace();
		}
	}
	//从控制台获取信息
	private String getStringFromConsole() {
		try {
			return  console.readLine();
		} catch (IOException e) {
			Utils.println("---------Client console-----------");
			this.relese();
			e.printStackTrace();
		}
		return "";
	}
	//释放资源
	private void relese() {
		this.isRunning= false;
		Utils.close(dos,client);
		
	}
	@Override
	public void run() {
		while(isRunning) {
			String msg= this.getStringFromConsole();
			if(!msg.equals("")) {
				this.send(msg);
			}
		}
	}
	
}
