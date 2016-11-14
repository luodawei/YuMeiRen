package com.xx.meirenyu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/10/21.
 */
public class MessageHintActivity extends Activity {
    TextView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_hint);
        backBtn= (TextView) findViewById(R.id.search_back_btn);

        //设置监听
        backBtn.setOnClickListener(onClickListener);
    }
//点击事件监听器
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                //当点击了返回按钮就结束当前Activity
                case R.id.search_back_btn:
                    finish();
            }
        }
    };
}
