package com.couragehe.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import com.couragehe.chat.utils.*;

/**
 * 在线聊天室
 * 目标：实现登陆、注册、聊天、注销等信息
 * @author CourageHe
 *
 */
public class Server {
	public static List<Channel> all = new ArrayList<Channel>();
	public static void main(String[]args) {
		Utils.println("---------Server Boot-----------");
		try {
			//1.指定端口
			ServerSocket server = new ServerSocket(8000);
			//阻塞式等待链接accept
			while(true) {
				Socket client = server.accept();
				Channel c = new Channel(client);
				all.add(c);//添加至列表之中管理
				new Thread(c).start();
				//日志打印
				Utils.println(c.name+" successfully connected ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
