package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.xx.meirenyu.utill.adapter.FansListViewAdapter;
import com.xx.meirenyu.utill.model.FansItemModel;
import com.yss.yumeiren.R;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Administrator on 2016/11/26.
 */

public class FansActivity extends Activity{
    ImageView backBtn;
    ListView fansListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fans_lv);
        backBtn= (ImageView) findViewById(R.id.back_btn);
        fansListView= (ListView) findViewById(R.id.fans_lv);
        List<FansItemModel> list=getFansData();
        FansListViewAdapter fansListViewAdapter=new FansListViewAdapter(this,list);
        fansListView.setAdapter(fansListViewAdapter);
        fansListView.setOnItemClickListener(onItemClickListener);
        //返回按钮点击事件
        backBtn.setOnClickListener(onClickListener);
    }
    List<FansItemModel> list=new ArrayList<FansItemModel>();
    //获取数据
    public List<FansItemModel> getFansData(){
        for (int i=0;i<10;i++){
            FansItemModel fansModel=new FansItemModel();
            fansModel.setMessageNumber(i);
            //设置消息显示
            if (fansModel.getMessageNumber()>0){
                fansModel.setHaveMesage(true);
            }
            fansModel.setUserImg(R.id.friend_nickname);
            fansModel.setUserName("海绵宝宝"+i);
            if (i>5){
                //设置性别女
                fansModel.setSsex(false);
            }else {
                //设置性别男
                fansModel.setSsex(true);
            }
            fansModel.setUserQianMing("我用技术，我为我自己带盐"+i);
            list.add(fansModel);
        }
        return list;
    }
    //listView的监听
    ListView.OnItemClickListener onItemClickListener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (parent.getId()){
                case R.id.fans_lv:
                    //带你listview的子项跳转
                    Toast.makeText(FansActivity.this,"粉丝"+position,Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_btn:
                /*返回按钮*/
                finish();
            break;
        }
        }
    };
}
