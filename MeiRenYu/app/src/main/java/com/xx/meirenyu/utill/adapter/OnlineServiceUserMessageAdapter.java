package com.xx.meirenyu.utill.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xx.meirenyu.utill.model.UserMessageModel;
import com.yss.yumeiren.R;

import java.util.List;

/**
 * Created by Administrator on 2016/11/27.
 */

public class OnlineServiceUserMessageAdapter extends BaseAdapter {
    List<UserMessageModel> list;
    Context context;
    LayoutInflater inflater;
    public OnlineServiceUserMessageAdapter(Context context,List<UserMessageModel> list){
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
            convertView=inflater.inflate(R.layout.online_service_lv_user_item,null);
        }
        TextView message= (TextView) convertView.findViewById(R.id.user_message);
        message.setText(list.get(position).getMessage());
        return convertView;
    }
}
