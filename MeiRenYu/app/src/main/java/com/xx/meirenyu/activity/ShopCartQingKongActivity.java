package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yss.yumeiren.R;

/**
 * 商城——清空页面
 * Created by Administrator on 2016/11/25.
 */
public class ShopCartQingKongActivity extends Activity {
    ImageView fanhui;
    TextView shop_cart_empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_cart_qingkong);
        shop_cart_empty = (TextView) findViewById(R.id.shop_cart_empty);
        fanhui = (ImageView) findViewById(R.id.fanhui);

        fanhui.setOnClickListener(onClickListener);
        shop_cart_empty.setOnClickListener(onClickListener);

    }
    Intent intent;
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.fanhui:
                    finish();
                    break;
                case R.id.shop_cart_empty:
                    intent = new Intent(ShopCartQingKongActivity.this, ShopCartKongBaiActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}

