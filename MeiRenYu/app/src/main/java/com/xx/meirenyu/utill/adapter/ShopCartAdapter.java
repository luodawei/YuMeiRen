package com.xx.meirenyu.utill.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.xx.meirenyu.activity.ShopCartJieSuanActivity;
import com.yss.yumeiren.R;

import java.util.List;

/**
 * Created by Administrator on 2016/11/30.
 */
public class ShopCartAdapter extends BaseAdapter {
    ShopCartJieSuanActivity context;
    List<String> list;
    LayoutInflater layoutInflater;

    public ShopCartAdapter(ShopCartJieSuanActivity context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        layoutInflater = LayoutInflater.from(context);
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.shop_cart_item, null);
        }
        return convertView;
    }
}
