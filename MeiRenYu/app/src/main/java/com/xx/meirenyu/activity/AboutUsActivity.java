package com.xx.meirenyu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.yss.yumeiren.R;

/**
 * Created by David on 2016/10/25.
 */

public class AboutUsActivity extends Activity {
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        btnBack= (ImageView) findViewById(R.id.btn_back);

        //设置监听
        btnBack.setOnClickListener(onClickListener);
    }
    View.OnClickListener onClickListener =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_back:
                /*返回按钮监听事件，直接 finish()*/
                    finish();
                    break;
            }
        }
    };
}
