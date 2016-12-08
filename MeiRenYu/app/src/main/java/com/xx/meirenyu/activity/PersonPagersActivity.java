package com.xx.meirenyu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.xx.meirenyu.utill.adapter.PostMsgListViewAdapter;
import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/12/6.
 */

public class PersonPagersActivity extends Activity {
    LayoutInflater inflater;//视图转换器
    ListView personalPageslv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_pagers_lv);
        init();

    }
    public void init(){
        inflater=LayoutInflater.from(this);
        personalPageslv= (ListView) findViewById(R.id.personal_pages_lv);
        personalPageslv.setAdapter(new PostMsgListViewAdapter(this));
        View view=inflater.inflate(R.layout.activity_personal_pages_lv_head,null);
        personalPageslv.addHeaderView(view);
    }
}
