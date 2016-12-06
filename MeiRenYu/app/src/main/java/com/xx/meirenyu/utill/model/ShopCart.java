package com.xx.meirenyu.utill.model;

import android.widget.CheckBox;

/**
 * Created by Administrator on 2016/12/1.
 */
public class ShopCart {
    String title;
    String context;
    int shopImg;

    public int getShopImg() {
        return shopImg;
    }

    public void setShopImg(int shopImg) {
        this.shopImg = shopImg;
    }

    int goodsnum;
    float goodsprice;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(int goodsnum) {
        this.goodsnum = goodsnum;
    }

    public float getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(float goodsprice) {
        this.goodsprice = goodsprice;
    }

    boolean checkBox;

    public boolean isCheckBox() {
        return checkBox;
    }

    public void setCheckBox(boolean checkBox) {
        this.checkBox = checkBox;
    }
}
