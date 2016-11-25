package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yss.yumeiren.R;

/**
 * 商城的空白页面
 * Created by Administrator on 2016/11/25.
 */
public class ShopCartKongBaiActivity extends Activity {
    TextView shouye;
    TextView gouwuche;
    TextView dingdan;
    TextView zaixiankefu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_cart_kongbai);
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
                    break;
                case R.id.dingdan:
                    intent = new Intent(ShopCartKongBaiActivity.this, MyOrderActivity.class);
                    startActivity(intent);
                    break;
                case R.id.zaixiankefu:
                    intent = new Intent(ShopCartKongBaiActivity.this, OnlineServiceActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
