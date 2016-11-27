package com.xx.meirenyu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/11/27.
 */
public class IntegralInGiftsActivity extends Activity {
    ImageView fanhui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_integral_gift);
        fanhui = (ImageView) findViewById(R.id.fanhui);
        fanhui.setOnClickListener(onClickListener);
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        switch (v.getId()){
            case R.id.fanhui:
                finish();
                break;
        }
        }
    };
}
