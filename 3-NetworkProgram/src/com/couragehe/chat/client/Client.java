package com.couragehe.chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.couragehe.chat.utils.Utils;

public class Client {
	public static void main(String[]args) throws IOException {
		Utils.println("---------Client Boot-----------");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Utils.print("Please input name:");
		String name = br.readLine();
		//建立链接
		Socket client = new Socket("localhost",8000);
		//客户端发送消息
		new Thread(new Send(client,name)).start();
		//客户端获取消息
		new Thread(new Receive(client)).start();
	}
}
