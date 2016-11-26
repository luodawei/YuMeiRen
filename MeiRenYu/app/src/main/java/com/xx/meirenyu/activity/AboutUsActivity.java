package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yss.yumeiren.R;

/**
 * Created by David on 2016/10/25.
 */

public class AboutUsActivity extends Activity {
    ImageView btnBack;
    LinearLayout updateBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        btnBack = (ImageView) findViewById(R.id.btn_back);
        updateBtn= (LinearLayout) findViewById(R.id.update_btn);
        //设置监听
        btnBack.setOnClickListener(onClickListener);
        updateBtn.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_back:
                /*返回按钮监听事件，直接 finish()*/
                    finish();
                    break;
                case R.id.update_btn:
                    Intent intent=new Intent(AboutUsActivity.this,AppUpdateActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
