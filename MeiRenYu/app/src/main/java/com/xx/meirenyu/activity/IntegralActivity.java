package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/11/27.
 */
public class IntegralActivity extends Activity {
    ImageView fanhui;
    TextView integral_in_gifts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integral);
        fanhui = (ImageView) findViewById(R.id.fanhui);
        integral_in_gifts = (TextView) findViewById(R.id.integral_in_gifts);
        fanhui.setOnClickListener(onClickListener);
        integral_in_gifts.setOnClickListener(onClickListener);
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()){
                case R.id.fanhui:
                    finish();
                    break;
                case R.id.integral_in_gifts:
                    intent = new Intent(IntegralActivity.this,IntegralInGiftsActivity.class);
                    startActivity(intent);
                    break;

            }
        }
    };
}
