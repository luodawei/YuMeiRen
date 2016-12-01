package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/11/25.
 */
public class YogaShopActivity extends Activity {
    ImageView shop_cart;
    ImageView online_service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_yoga_shop);
        shop_cart = (ImageView) findViewById(R.id.shop_cart);
        online_service = (ImageView) findViewById(R.id.online_service);
        shop_cart.setOnClickListener(onClickListener);
        online_service.setOnClickListener(onClickListener);
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()) {
                case R.id.shop_cart:
                   /* intent = new Intent(YogaShopActivity.this, ShopCartJieSuanActivity.class);
                    startActivity(intent);*/
                    break;
                case R.id.online_service:
                  /*  intent = new Intent(YogaShopActivity.this, OnlineServiceActivity.class);
                    startActivity(intent);*/
                    break;
            }
        }
    };
}
