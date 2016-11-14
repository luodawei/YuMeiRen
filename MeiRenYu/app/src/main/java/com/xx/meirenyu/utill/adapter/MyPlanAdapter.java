package com.xx.meirenyu.utill.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yss.yumeiren.R;

/**
 * Created by David on 2016/10/23.
 */

public class MyPlanAdapter extends BaseAdapter {
    Context context;
    public MyPlanAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return content.length;
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
        LayoutInflater inflater = LayoutInflater.from(context);
        if (convertView == null){
            convertView = inflater.inflate(R.layout.my_plan_lv_item,null);
        }
        TextView myPlanContent = (TextView)convertView.findViewById(R.id.my_plan_content);
        myPlanContent.setText(content[position]+position);
        ImageView myPlanDelete = (ImageView)convertView.findViewById(R.id.my_plan_delete);
        if (position == 3){
            myPlanDelete.setVisibility(View.VISIBLE);
        }
        return convertView;
        /*View view = inflater.inflate(R.layout.my_plan_item,null);
        TextView myPlanContent;
        if (convertView == null){
            myPlanContent = (TextView)view.findViewById(R.id.my_plan_content);
        }else {
            myPlanContent = (TextView)convertView;//估计是这里转化出了问题
        }
        myPlanContent.setText(contentId[position]);
        return myPlanContent;*/
    }
    String[] content = {"我的健身计划","我的健身计划","我的健身计划",
            "我的健身计划","我的健身计划","我的健身计划",
            "我的健身计划","我的健身计划","我的健身计划",};
}
