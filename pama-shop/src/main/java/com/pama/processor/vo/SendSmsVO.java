package com.pama.processor.vo;

import java.io.Serializable;

public class SendSmsVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 807927385577777380L;

	private String msg;
	
	private String rphone;
	
	private String sphone1;
	
	private String sphone2;
	
	private String sphone3;
	
	private String rdate;
	
	private String rtime;
	
	private String mode;
	
	private String subject;
	
	private String smsType;
	
	private String testflag;
	
	private String destination;
	
	private String repeatFlag;
	
	private String repeatNum;
	
	private String repeatTime;
	
	private String returnurl;
	
	private String nointeractive;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getRphone() {
		return rphone;
	}

	public void setRphone(String rphone) {
		this.rphone = rphone;
	}

	public String getSphone1() {
		return sphone1;
	}

	public void setSphone1(String sphone1) {
		this.sphone1 = sphone1;
	}

	public String getSphone2() {
		return sphone2;
	}

	public void setSphone2(String sphone2) {
		this.sphone2 = sphone2;
	}

	public String getSphone3() {
		return sphone3;
	}

	public void setSphone3(String sphone3) {
		this.sphone3 = sphone3;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getRtime() {
		return rtime;
	}

	public void setRtime(String rtime) {
		this.rtime = rtime;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSmsType() {
		return smsType;
	}

	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}

	public String getTestflag() {
		return testflag;
	}

	public void setTestflag(String testflag) {
		this.testflag = testflag;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getRepeatFlag() {
		return repeatFlag;
	}

	public void setRepeatFlag(String repeatFlag) {
		this.repeatFlag = repeatFlag;
	}

	public String getRepeatNum() {
		return repeatNum;
	}

	public void setRepeatNum(String repeatNum) {
		this.repeatNum = repeatNum;
	}

	public String getRepeatTime() {
		return repeatTime;
	}

	public void setRepeatTime(String repeatTime) {
		this.repeatTime = repeatTime;
	}

	public String getReturnurl() {
		return returnurl;
	}

	public void setReturnurl(String returnurl) {
		this.returnurl = returnurl;
	}

	public String getNointeractive() {
		return nointeractive;
	}

	public void setNointeractive(String nointeractive) {
		this.nointeractive = nointeractive;
	}
	
}
