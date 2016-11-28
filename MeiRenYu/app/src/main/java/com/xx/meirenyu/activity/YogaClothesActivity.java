package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.xx.meirenyu.utill.fragment.YogaShopFragment;
import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/11/27.
 */
public class YogaClothesActivity extends Activity {
    ImageView fanhui1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_clothes);
        fanhui1= (ImageView) findViewById(R.id.fanhui1);
        fanhui1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
