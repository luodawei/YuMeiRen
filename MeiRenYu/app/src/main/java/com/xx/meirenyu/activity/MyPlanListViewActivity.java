package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
    private ImageView btnBack;
    private ImageView btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_plan_lv);
        ListView listView = (ListView) findViewById(R.id.my_plan_list);
        btnBack = (ImageView) findViewById(R.id.btn_back);
        btnAdd = (ImageView) findViewById(R.id.btn_add);
        getData();
        listView.setAdapter(new ListAdapter());
        btnBack.setOnClickListener(getOnClickListener());
        btnAdd.setOnClickListener(getOnClickListener());
        /*new Thread(){
            @Override
            public void run() {
                getPlan();
            }
        }.start();*/

    }
    private void getData(){
        for (int i = 0;i<15;i++){
            list.add("我的计划"+i);
        }
    }
    public View.OnClickListener getOnClickListener(){
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (v.getId()){
                    case R.id.btn_back:
                        finish();
                        break;
                    case R.id.btn_add:
                        intent = new Intent(MyPlanListViewActivity.this,MyPlanDetailActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        };
        return onClickListener;
    }
    public void getPlan(){
        HttpURLConnection httpURLConnection = null;
        String httpUrl = "http://10.0.2.2/index.php/home/plan/addplan?user_id=2";
        try {
            URL url = new URL(httpUrl);
            try {
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.connect();
                if(httpURLConnection.getResponseCode()==200){
                    StringBuilder stringBuilder = new StringBuilder();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String s;
                    while ((s = bufferedReader.readLine())!=null){
                        stringBuilder.append(s);
                    }
                    Log.i("data==>",stringBuilder.toString());


                }else {
                    Log.i("请求失败","状态码为："+httpURLConnection.getResponseCode());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            getPlan();
        }
    };
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
