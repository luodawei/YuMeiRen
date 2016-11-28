package com.xx.meirenyu.utill.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xx.meirenyu.utill.model.FansItemModel;
import com.yss.yumeiren.R;

import java.util.List;
/**
 * Created by Administrator on 2016/11/26.
 */

public class FansListViewAdapter extends BaseAdapter {
    Context context;
    List<FansItemModel> list;
    LayoutInflater layoutInflater;
    public FansListViewAdapter(Context context,List<FansItemModel> list){
        this.context=context;
        this.list=list;
        layoutInflater=LayoutInflater.from(context);
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
        ViewHodler viewHodler;
        if (convertView==null){
            viewHodler=new ViewHodler();
            convertView=layoutInflater.inflate(R.layout.activity_fans_lv_item,null);
            viewHodler.user_ms_nb= (TextView) convertView.findViewById(R.id.user_ms_nb);
            viewHodler.user_details_img= (RelativeLayout) convertView.findViewById(R.id.user_details_img);
            viewHodler.user_name= (TextView) convertView.findViewById(R.id.user_name);
            viewHodler.user_qianming= (TextView) convertView.findViewById(R.id.user_qianming);
            convertView.setTag(viewHodler);
        }
        viewHodler= (ViewHodler) convertView.getTag();
        FansItemModel fansItemModel=list.get(position);
        //判断有消息是否
        boolean isHaveMessage=fansItemModel.isHaveMesage();
        if (isHaveMessage){
            viewHodler.user_ms_nb.setVisibility(View.VISIBLE);
            int number=fansItemModel.getMessageNumber();
            viewHodler.user_ms_nb.setText(number+"");
        }else {
            viewHodler.user_ms_nb.setVisibility(View.GONE);
        }


        //判断性别
        Drawable drawable;
        boolean sex=fansItemModel.isSsex();
        if (sex){
            //性别男
           drawable=context.getResources().getDrawable(R.mipmap.boy);
        }else{
            //性别女
            drawable=context.getResources().getDrawable(R.mipmap.girl);
        }
        viewHodler.user_name.setCompoundDrawables(null,null,drawable,null);
        //设置签名
        String content=fansItemModel.getUserQianMing();
        if (content.length()>15){
            content=content.substring(0,19)+"...";
        }
        viewHodler.user_qianming.setText(content);
        return convertView;
    }
    public class ViewHodler{
        TextView user_ms_nb;
        RelativeLayout user_details_img;
        TextView user_name;
        TextView user_qianming;
    }
}
