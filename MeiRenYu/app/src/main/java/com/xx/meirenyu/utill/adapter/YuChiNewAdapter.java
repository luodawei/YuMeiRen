package com.xx.meirenyu.utill.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/11/26.
 */
public class YuChiNewAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    public YuChiNewAdapter(Context context){
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 5;
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
            convertView = inflater.inflate(R.layout.yuchi_zuixin_item,null);
        }
        return convertView;
    }
}
