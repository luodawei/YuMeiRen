package com.xx.meirenyu.utill.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xx.meirenyu.utill.model.YogaShopGridViewModel;
import com.yss.yumeiren.R;

import java.util.List;

/**
 * Created by Administrator on 2016/11/26.
 */

public class YogaShowGridViewAdapter extends BaseAdapter {
    List<YogaShopGridViewModel> list;
    Context context;
    LayoutInflater inflater;
    public YogaShowGridViewAdapter(Context context, List<YogaShopGridViewModel> list){
        this.context=context;
        this.list=list;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list.size();
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
        if (convertView==null){
            convertView=inflater.inflate(R.layout.yoga_shop_gridview_item,null);
        }
        TextView textView= (TextView) convertView.findViewById(R.id.grid_item);
        YogaShopGridViewModel yogaShopGridViewModel=list.get(position);
        textView.setText(yogaShopGridViewModel.getName());
        textView.setBackgroundResource(yogaShopGridViewModel.getImg());
        return convertView;
    }

}
