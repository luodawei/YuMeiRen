package com.xx.meirenyu.utill.mycalender;
/**
 * 日历存储数据库
 */

public class sqlit {
	String date;
	String isselct;

	public sqlit() {
	}

	public sqlit(String date, String isselct) {
		this.date = date;
		this.isselct = isselct;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getIsselct() {
		return isselct;
	}

	public void setIsselct(String isselct) {
		this.isselct = isselct;
	}

}
