package com.couragehe.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import com.couragehe.chat.utils.Utils;

public class Channel implements Runnable {
	public List<Channel> all = Server.all;
	private DataInputStream dis;//高级输入流
	private DataOutputStream dos;//高级输出流
	private Socket client;
	private boolean isRunning;
	protected String name;
	
	public Channel(Socket client) {
		isRunning = true;
		this.client = client;
		try {
			//获取输入输出高级流
			dis = new DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());
			//获取名称
			this.name = this.receive();
			this.send("Welcome to Login");
			this.sendOthers(name+" sucessfully Login", true);//系统消息
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 接受消息
	 */
	public String receive() {
		String msg = "";
		try {
			msg = dis.readUTF();//输入流读取信息（UTF-8）
		} catch (IOException e) {
			e.printStackTrace();
		}
		return msg;
	}
	/*
	 * 基本功能：发送消息
	 */
	public void send(String msg) {
		try {
			dos.writeUTF(msg);//输出流打印信息（UTF-8）
			dos.flush();//刷新一下
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 封装的发送消息的功能
	 * 
	 * 群聊：  获取自己的消息，发送给其他人
	 * 私聊：约定数据格式：@xxx:msg（格式）
	 * @param msg 发送的信息
	 * @param isSys 是否为系统消息
	 */
	public void sendOthers(String msg,boolean isSys) {
		boolean isPrivate = msg.startsWith("@");
		if(isPrivate) {
			int idx = msg.indexOf(":");
			//获取目标和数据
			String targetName = msg.substring(1,idx);
			msg= msg.substring(idx+1);
			for(Channel other : all) {
				if(other.name.equals(targetName)) {
					other.send(this.name+ "private say:"+msg);
					break;
				}
			}
		}else {
			for(Channel other :all) {
				if(this == other) {
					continue;
				}
				if(!isSys) {
					other.send(this.name+ "private say:"+msg);//群聊消息
				}else {
					other.send(msg);//系统消息
				}
			}
		}
	}
	//释放资源
	public void release() {
		this.isRunning = false;
		Utils.close(dis,dos,client);
		all.remove(this);
		this.sendOthers(this.name+"log out",true);
		this.sendOthers(this.name+"log out",true);
	}
	@Override
	public void run() {
		while(isRunning) {
			String msg = this.receive();
			if(!msg.equals("")) {
				this.sendOthers(msg,false);
			}
		}
	}

}
