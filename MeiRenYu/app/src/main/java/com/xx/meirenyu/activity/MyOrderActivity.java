package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yss.yumeiren.R;

/**
 * 商城——我的订单
 * Created by Administrator on 2016/11/25.
 */
public class MyOrderActivity extends Activity {
    TextView shouye;
    TextView gouwuche;
    TextView dingdan;
    TextView zaixiankefu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        shouye = (TextView) findViewById(R.id.shouye);
        gouwuche = (TextView) findViewById(R.id.gouwuche);
        dingdan = (TextView) findViewById(R.id.dingdan);
        zaixiankefu = (TextView) findViewById(R.id.zaixiankefu);

        shouye.setOnClickListener(onClickListener);
        gouwuche.setOnClickListener(onClickListener);
        dingdan.setOnClickListener(onClickListener);
        zaixiankefu.setOnClickListener(onClickListener);
    }
        Intent intent;
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.shouye:
                    break;
                case R.id.gouwuche:
                    intent = new Intent(MyOrderActivity.this, ShopCartJieSuanActivity.class);
                    startActivity(intent);
                    break;
                case R.id.dingdan:
                    break;
                case R.id.zaixiankefu:
                    intent = new Intent(MyOrderActivity.this, OnlineServiceActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
