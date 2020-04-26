package com.couragehe.chat.utils;

import java.io.Closeable;
import java.io.IOException;

public class Utils {
	public static void close(Closeable...targets) {
		for(Closeable target : targets) {
			try {
				if(target != null) {
					target.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void print(String msg) {
		System.out.print(msg);
	}
	public static void println(String msg) {
		System.out.println(msg);
	}
}
