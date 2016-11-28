package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xx.meirenyu.utill.adapter.MyPlanAdapter;
import com.xx.meirenyu.utill.view.SwipeListLayout;
import com.yss.yumeiren.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by David on 2016/10/23.
 * 我的计划列表
 */

public class MyPlanListViewActivity extends Activity {
    private List<String> list = new ArrayList<String>();
    private Set<SwipeListLayout> sets = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_plan_lv);
        ListView listView = (ListView) findViewById(R.id.my_plan_list);
        getData();
        listView.setAdapter(new ListAdapter());
    }
    private void getData(){
        for (int i = 0;i<15;i++){
            list.add("我的计划"+i);
        }
    }
    class ListAdapter extends BaseAdapter{

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
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null){
                convertView = LayoutInflater.from(MyPlanListViewActivity.this).inflate(R.layout.my_plan_lv_item,null);
            }
            TextView myPlanContent = (TextView) convertView.findViewById(R.id.my_plan_content);
            myPlanContent.setText(list.get(position));
            final SwipeListLayout sll_main = (SwipeListLayout) convertView.findViewById(R.id.sll_main);
            ImageView delete = (ImageView) convertView.findViewById(R.id.my_plan_delete);
            sll_main.setOnSwipeStatusListener(new MyOnSlipStatusListener(sll_main));
            delete.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    sll_main.setStatus(SwipeListLayout.Status.Close,true);
                    list.remove(position);
                    notifyDataSetChanged();
                }
            });
            return convertView;
        }
    }
    class MyOnSlipStatusListener implements SwipeListLayout.OnSwipeStatusListener {

        private SwipeListLayout slipListLayout;

        public MyOnSlipStatusListener(SwipeListLayout slipListLayout) {
            this.slipListLayout = slipListLayout;
        }

        @Override
        public void onStatusChanged(SwipeListLayout.Status status) {
            if (status == SwipeListLayout.Status.Open) {
                //若有其他的item的状态为Open，则Close，然后移除
                if (sets.size() > 0) {
                    for (SwipeListLayout s : sets) {
                        s.setStatus(SwipeListLayout.Status.Close, true);
                        sets.remove(s);
                    }
                }
                sets.add(slipListLayout);
            } else {
                if (sets.contains(slipListLayout))
                    sets.remove(slipListLayout);
            }
        }

        @Override
        public void onStartCloseAnimation() {

        }

        @Override
        public void onStartOpenAnimation() {

        }

    }
}
