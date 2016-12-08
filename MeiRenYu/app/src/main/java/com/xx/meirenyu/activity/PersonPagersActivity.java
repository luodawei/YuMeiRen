package com.xx.meirenyu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.xx.meirenyu.utill.adapter.PostMsgListViewAdapter;
import com.xx.meirenyu.utill.view.NoLoginDialog;
import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/12/6.
 */

public class PersonPagersActivity extends Activity {
    LayoutInflater inflater;//视图转换器
    ListView personalPageslv;
    TextView add_collection;
    TextView add_friend;
    NoLoginDialog noLoginDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_pagers_lv);
        add_collection= (TextView) findViewById(R.id.add_collection);
        add_friend= (TextView) findViewById(R.id.add_friends);
        noLoginDialog=new NoLoginDialog(this);
        add_collection.setOnClickListener(onClickListener);
        add_friend.setOnClickListener(onClickListener);
        init();
    }
    public void init(){
        inflater=LayoutInflater.from(this);
        personalPageslv= (ListView) findViewById(R.id.personal_pages_lv);
        personalPageslv.setAdapter(new PostMsgListViewAdapter(this));
        View view=inflater.inflate(R.layout.activity_personal_pages_lv_head,null);
        personalPageslv.addHeaderView(view);
    }
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_collection:
                if (  getIntent().getBooleanExtra("isLogin",false)){
                    Toast.makeText(PersonPagersActivity.this,"关注成功",Toast.LENGTH_SHORT).show();
                }else {
                    noLoginDialog.loginDialog();
                }
                break;
            case R.id.add_friends:
                if (  getIntent().getBooleanExtra("isLogin",false)){
                    Toast.makeText(PersonPagersActivity.this,"添加好友成功",Toast.LENGTH_SHORT).show();
                }else {
                    noLoginDialog.loginDialog();
                }
                break;
        }
        }
    };
}
