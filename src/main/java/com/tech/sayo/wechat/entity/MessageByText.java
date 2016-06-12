package com.tech.sayo.wechat.entity;

public class MessageByText {

	private String touser;
	private String msgtype;
	private MessageText text;

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public MessageText getText() {
		return text;
	}

	public void setText(MessageText text) {
		this.text = text;
	}

}
