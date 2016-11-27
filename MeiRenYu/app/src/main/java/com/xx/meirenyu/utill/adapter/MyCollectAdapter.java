package com.xx.meirenyu.utill.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/11/27.
 */
public class MyCollectAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    public MyCollectAdapter(Context context){
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 15;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = inflater.inflate(R.layout.activity_yoga_my_collect_lv_item,null);
        }
        return convertView;
    }
}
