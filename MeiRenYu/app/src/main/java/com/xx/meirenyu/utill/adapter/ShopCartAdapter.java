package com.xx.meirenyu.utill.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xx.meirenyu.activity.ShopCartJieSuanActivity;
import com.xx.meirenyu.utill.model.ShopCart;
import com.yss.yumeiren.R;

import java.util.List;

/**
 * Created by Administrator on 2016/11/30.
 */
public class ShopCartAdapter extends BaseAdapter {
    TextView priceAll,shop_cart_delete;
    ShopCartJieSuanActivity mactivity;
    CheckBox shop_cart_cball;
    CheckedTextView shop_cart_bianji;
    List<ShopCart> shopCartList;
    LayoutInflater layoutInflater;
    RelativeLayout jiesuan_layout, shanchu_layout;

    public ShopCartAdapter(ShopCartJieSuanActivity mactivity,
                           TextView priceAll,TextView shop_cart_delete,
                           CheckedTextView shop_cart_bianji,
                           CheckBox shop_cart_cball,
                           RelativeLayout jiesuan_layout,
                           RelativeLayout shanchu_layout,
                           List<ShopCart> shopCartList) {
        this.mactivity = mactivity;
        this.shopCartList = shopCartList;
        this.priceAll = priceAll;
        this.shop_cart_delete = shop_cart_delete;
        this.shop_cart_cball = shop_cart_cball;
        this.shop_cart_bianji = shop_cart_bianji;
        this.jiesuan_layout = jiesuan_layout;
        this.shanchu_layout = shanchu_layout;
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return shopCartList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        layoutInflater = LayoutInflater.from(mactivity);
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.shop_cart_item, null);
        }
        return convertView;
    }
}
