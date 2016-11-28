package com.xx.meirenyu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yss.yumeiren.R;

/**
 * 商城——结算页面
 * Created by Administrator on 2016/11/25.
 */
public class ShopCartJieSuanActivity extends Activity {
    TextView changegoods_num01,
            changegoods_num02,
            goods_num01,
            goods_num02,
            price_01,
            price_02,
            price_all,
            shop_cart_delete;
    ImageView fanhui,
            image_sub01,
            image_add01,
            image_sub02,
            image_add02;
    CheckedTextView shop_cart_bianji;
    LinearLayout shop_cart_jiesuan01,
            shop_cart_jiesuan02,
            Shop_cart_bianji01,
            Shop_cart_bianji02;
    RelativeLayout jiesuan_layout,
            shanchu_layout;
    CheckBox shop_cart_cb01,
            shop_cart_cb02,
            shop_cart_cball;
    int num1,num2,price_01_num,
            price_02_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_cart_jiesuan);
        shop_cart_bianji = (CheckedTextView) findViewById(R.id.shop_cart_editing);
        fanhui = (ImageView) findViewById(R.id.fanhui);
        shop_cart_jiesuan01 = (LinearLayout) findViewById(R.id.shop_cart_jiesuan01);
        shop_cart_jiesuan02 = (LinearLayout) findViewById(R.id.shop_cart_jiesuan02);
        Shop_cart_bianji01 = (LinearLayout) findViewById(R.id.shop_cart_bianji01);
        Shop_cart_bianji02 = (LinearLayout) findViewById(R.id.shop_cart_bianji02);
        jiesuan_layout = (RelativeLayout) findViewById(R.id.jiesuan_layout);
        shanchu_layout = (RelativeLayout) findViewById(R.id.shanchu_layout);

        shop_cart_cb01 = (CheckBox) findViewById(R.id.shop_cart_cb01);
        shop_cart_cb02 = (CheckBox) findViewById(R.id.shop_cart_cb02);
        shop_cart_cball = (CheckBox) findViewById(R.id.shop_cart_cball);

        changegoods_num01 = (TextView) findViewById(R.id.changegoods_num_01);
        changegoods_num02 = (TextView) findViewById(R.id.changegoods_num_02);
        goods_num01 = (TextView) findViewById(R.id.goods_num_01);
        goods_num02 = (TextView) findViewById(R.id.goods_num_02);
        price_01 = (TextView) findViewById(R.id.price_01);
        price_02 = (TextView) findViewById(R.id.price_02);
        price_all = (TextView) findViewById(R.id.price_all);
        shop_cart_delete = (TextView) findViewById(R.id.shop_cart_delete);

        image_sub01 = (ImageView) findViewById(R.id.image_sub01);
        image_sub02 = (ImageView) findViewById(R.id.image_sub02);
        image_add01 = (ImageView) findViewById(R.id.image_add01);
        image_add02 = (ImageView) findViewById(R.id.image_add02);
        shop_cart_bianji.setOnClickListener(onClickListener);
        fanhui.setOnClickListener(onClickListener);
        image_sub01.setOnClickListener(onClickListener);
        image_sub02.setOnClickListener(onClickListener);
        image_add01.setOnClickListener(onClickListener);
        image_add02.setOnClickListener(onClickListener);
        shop_cart_cball.setOnClickListener(onClickListener);
        shop_cart_delete.setOnClickListener(onClickListener);

        num1 =Integer.valueOf(changegoods_num01.getText().toString());
        num2 = Integer.valueOf(changegoods_num02.getText().toString());
        price_01_num = Integer.valueOf(price_01.getText().toString());
        price_02_num = Integer.valueOf(price_02.getText().toString());


    }

    View.OnClickListener onClickListener = new View.OnClickListener() {

        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.fanhui:
                    finish();
                    break;
                case R.id.shop_cart_editing:
                    if (shop_cart_bianji.isChecked() == true) {
                        shop_cart_jiesuan01.setVisibility(View.VISIBLE);
                        shop_cart_jiesuan02.setVisibility(View.VISIBLE);
                        jiesuan_layout.setVisibility(View.VISIBLE);
                        shanchu_layout.setVisibility(View.GONE);
                        Shop_cart_bianji01.setVisibility(View.GONE);
                        Shop_cart_bianji02.setVisibility(View.GONE);
                        shop_cart_bianji.setText("编辑");
                        shop_cart_bianji.setChecked(false);
                        goods_num01.setText(Integer.toString(num1));
                        goods_num02.setText(Integer.toString(num2));
                    } else {
                        shop_cart_jiesuan01.setVisibility(View.GONE);
                        shop_cart_jiesuan02.setVisibility(View.GONE);
                        jiesuan_layout.setVisibility(View.GONE);
                        shanchu_layout.setVisibility(View.VISIBLE);
                        Shop_cart_bianji01.setVisibility(View.VISIBLE);
                        Shop_cart_bianji02.setVisibility(View.VISIBLE);
                        shop_cart_bianji.setText("完成");
                        shop_cart_bianji.setChecked(true);
                    price_all.setText(Integer.toString(price_01_num*num1+price_02_num*num2));
                    }
                    break;
                case R.id.image_sub01:
                    if(num1>1){
                    changegoods_num01.setText(Integer.toString(--num1));
                    }else {
                        Toast.makeText(ShopCartJieSuanActivity.this,"不能再减了",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.image_add01:
                    changegoods_num01.setText(Integer.toString(++num1));
                    break;
                case R.id.image_sub02:
                    if(num2>1){
                    changegoods_num02.setText(Integer.toString(--num2));
                    }else {
                        Toast.makeText(ShopCartJieSuanActivity.this,"不能再减了",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.image_add02:
                    changegoods_num02.setText(Integer.toString(++num2));
                    break;
                case R.id.shop_cart_cball:
                    if(shop_cart_cball.isChecked()){
                    shop_cart_cb01.setChecked(true);
                    shop_cart_cb02.setChecked(true);
                    }else {
                        shop_cart_cb01.setChecked(false);
                        shop_cart_cb02.setChecked(false);
                    }
                    break;
                case R.id.shop_cart_delete:
                    break;

            }

        }
    };


}