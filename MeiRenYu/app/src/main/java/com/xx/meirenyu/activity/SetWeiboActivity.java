package com.xx.meirenyu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.yss.yumeiren.R;

/**
 * Created by David on 2016/10/25.
 * 设置微博页面
 */

public class SetWeiboActivity extends Activity {
    ImageView btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_weibo);
        btnBack= (ImageView) findViewById(R.id.btn_back);
        btnBack.setOnClickListener(onClickListener);
    }
    //成员内部类点击监听事件
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_back:
                    /*返回按钮事件，直接销毁当前页面没有传值*/
                    finish();
                    Toast.makeText(SetWeiboActivity.this,"恭喜您微博绑定成功",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}
