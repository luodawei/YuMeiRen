package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.yss.yumeiren.R;

/**
 * 商城的空白页面
 * Created by Administrator on 2016/11/25.
 */
public class ShopCartKongBaiActivity extends Activity {
    ImageView fanhui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_cart_kongbai);
        fanhui = (ImageView) findViewById(R.id.fanhui);
        fanhui.setOnClickListener(onClickListener);

    }
    Intent intent;
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.fanhui:
                    finish();
                    break;
            }
        }
    };
}
