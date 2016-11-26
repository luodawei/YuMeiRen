package com.xx.meirenyu.utill.model;

/**
 * Created by Administrator on 2016/11/26.
 */

public class FansItemModel {
    boolean isHaveMesage=false;//用户是否有消息
    int messageNumber;//用户消息数量
    int userImg;//用户头像
    String userName;//用户名
    String userQianMing;//用户签名

    public boolean isHaveMesage() {
        return isHaveMesage;
    }

    public void setHaveMesage(boolean haveMesage) {
        isHaveMesage = haveMesage;
    }

    public int getMessageNumber() {
        return messageNumber;
    }

    public void setMessageNumber(int messageNumber) {
        this.messageNumber = messageNumber;
    }

    public int getUserImg() {
        return userImg;
    }

    public void setUserImg(int userImg) {
        this.userImg = userImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserQianMing() {
        return userQianMing;
    }

    public void setUserQianMing(String userQianMing) {
        this.userQianMing = userQianMing;
    }

    public boolean isSsex() {
        return Ssex;
    }

    public void setSsex(boolean ssex) {
        Ssex = ssex;
    }

    boolean Ssex;//性别

}
