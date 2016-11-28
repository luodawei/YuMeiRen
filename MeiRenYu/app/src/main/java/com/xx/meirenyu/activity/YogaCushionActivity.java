package com.xx.meirenyu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/11/27.
 */
public class YogaCushionActivity extends Activity {
    ImageView fanhui2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_cushion);
        fanhui2 = (ImageView) findViewById(R.id.fanhui2);
        fanhui2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
