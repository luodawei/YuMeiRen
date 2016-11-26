package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
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
    ImageView fanhui;
    RadioButton quanbu;
    RadioButton daifukuan;
    RadioButton daifahuo;
    RadioButton daishouhuo;
    View quanbu_view;
    View daifukuan_view;
    View daifahuo_view;
    View daishouhuo_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        shouye = (TextView) findViewById(R.id.shouye);
        gouwuche = (TextView) findViewById(R.id.gouwuche);
        dingdan = (TextView) findViewById(R.id.dingdan);
        zaixiankefu = (TextView) findViewById(R.id.zaixiankefu);
        fanhui = (ImageView) findViewById(R.id.fanhui);
        quanbu = (RadioButton) findViewById(R.id.quanbu);
        daifukuan = (RadioButton) findViewById(R.id.daifukuan);
        daifahuo = (RadioButton) findViewById(R.id.daifahuo);
        daishouhuo = (RadioButton) findViewById(R.id.daishouhuo);
        quanbu_view = findViewById(R.id.quanbu_view);
        daifukuan_view = findViewById(R.id.daifukuan_view);
        daifahuo_view = findViewById(R.id.daifahuo_view);
        daishouhuo_view = findViewById(R.id.daishouhuo_view);


        shouye.setOnClickListener(onClickListener);
        gouwuche.setOnClickListener(onClickListener);
        dingdan.setOnClickListener(onClickListener);
        zaixiankefu.setOnClickListener(onClickListener);
        fanhui.setOnClickListener(onClickListener);
        quanbu.setOnClickListener(onClickListener);
        daifukuan.setOnClickListener(onClickListener);
        daifahuo.setOnClickListener(onClickListener);
        daishouhuo.setOnClickListener(onClickListener);
        quanbu_view.setOnClickListener(onClickListener);
        daifukuan_view.setOnClickListener(onClickListener);
        daifahuo_view.setOnClickListener(onClickListener);
        daishouhuo_view.setOnClickListener(onClickListener);

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
                case R.id.fanhui:
                    break;
                case R.id.quanbu:

                    break;
                case R.id.daifukuan:

                    break;
                case R.id.daifahuo:
                    break;
                case R.id.daishouhuo:
                    break;

            }
        }
    };
}
