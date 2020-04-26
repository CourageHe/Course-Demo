package com.couragehe.chat.utils;
/**
 * 返回响应模板
 * @author CourageHe
 *
 */
public class ResultNote {
	@SuppressWarnings("unused")
	private String command;
	@SuppressWarnings("unused")
	private String state;
	@SuppressWarnings("unused")
	private String message;
	public ResultNote(String command, String state, String message) {
		this.command = command;
		this.state = state;
		this.message = message;
	}
}
