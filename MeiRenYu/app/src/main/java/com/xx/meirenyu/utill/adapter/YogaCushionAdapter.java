package com.xx.meirenyu.utill.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xx.meirenyu.utill.model.YogaCushionModel;
import com.yss.yumeiren.R;

import java.util.List;

/**
 * Created by Administrator on 2016/11/30.
 */

public class YogaCushionAdapter extends BaseAdapter {
    List<YogaCushionModel> list;
    Context context;
    LayoutInflater inflater;
    public YogaCushionAdapter(Context context, List<YogaCushionModel> list){
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
        ViewHodler viewHodler;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.activity_yoga_cushion_lv_item,null);
            viewHodler=new ViewHodler();
            viewHodler.yogaCushionImg0=(ImageView)convertView.findViewById(R.id.yoga_cushion_img0);
            viewHodler.yogaCushionImg=(ImageView)convertView.findViewById(R.id.yoga_cushion_img);
            viewHodler.yogaCushionPrice0=(TextView)convertView.findViewById(R.id.yoga_cushion_price0);
            viewHodler.yogaCushionPrice=(TextView)convertView.findViewById(R.id.yoga_cushion_price);
            viewHodler.yogaCushionTitle0=(TextView)convertView.findViewById(R.id.yoga_cushion_title0);
            viewHodler.yogaCushionTitle=(TextView)convertView.findViewById(R.id.yoga_cushion_title);
            convertView.setTag(viewHodler);
        }
        viewHodler=(ViewHodler)convertView.getTag();
        YogaCushionModel yogaCushionModel=list.get(position);
        viewHodler.yogaCushionImg.setImageResource(yogaCushionModel.getImg());
        viewHodler.yogaCushionImg0.setImageResource(yogaCushionModel.getImg0());
        viewHodler.yogaCushionTitle0.setText(yogaCushionModel.getYogaCushionTile0());
        viewHodler.yogaCushionTitle.setText(yogaCushionModel.getYogaCushionTile());
        viewHodler.yogaCushionPrice0.setText(yogaCushionModel.getYogaCushionPrice0());
        viewHodler.yogaCushionPrice.setText(yogaCushionModel.getYogaCushionPrice());
        return convertView;
    }
    public class ViewHodler{
        ImageView yogaCushionImg0;
        TextView yogaCushionTitle0;
        TextView yogaCushionPrice0;
        ImageView yogaCushionImg;
        TextView yogaCushionTitle;
        TextView yogaCushionPrice;
    }
}
