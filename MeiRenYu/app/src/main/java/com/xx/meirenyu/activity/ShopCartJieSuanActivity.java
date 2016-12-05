package com.xx.meirenyu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xx.meirenyu.utill.adapter.ShopCartAdapter;
import com.xx.meirenyu.utill.model.ShopCart;
import com.yss.yumeiren.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 商城——结算页面
 * Created by Administrator on 2016/11/25.
 */
public class ShopCartJieSuanActivity extends Activity {
    TextView priceAll,shop_cart_delete,changegoods_num_01;
    CheckBox shop_cart_cball;
    ImageView fanhui,shopAdd,shopSub;
    CheckedTextView shop_cart_bianji;
    ListView shop_cart_lv;
    LayoutInflater inflater;
    RelativeLayout jiesuan_shopcart, shanchu_shopcart;
    ShopCartAdapter shopCartAdapter;
    View item;
    LinearLayout jiesuan_linlayout;
    LinearLayout shanchu_linlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_cart_jiesuan);
        shop_cart_bianji = (CheckedTextView) findViewById(R.id.shop_cart_editing);
        fanhui = (ImageView) findViewById(R.id.fanhui);
        shop_cart_lv = (ListView) findViewById(R.id.shop_cart_lv);
        jiesuan_shopcart = (RelativeLayout) findViewById(R.id.jiesuan_shopcart);
        shanchu_shopcart = (RelativeLayout) findViewById(R.id.shanchu_shopcart);
        priceAll = (TextView) findViewById(R.id.price_all);
        shop_cart_delete = (TextView) findViewById(R.id.shop_cart_delete);
        shop_cart_cball = (CheckBox) findViewById(R.id.shop_cart_cball);
        inflater=LayoutInflater.from(this);
        item=inflater.inflate(R.layout.shop_cart_item,null);

        jiesuan_linlayout= (LinearLayout) item.findViewById(R.id.jiesuan_layout);
        shanchu_linlayout= (LinearLayout) item.findViewById(R.id.shanchu_layout);
        shop_cart_bianji.setOnClickListener(onClickListener);
        fanhui.setOnClickListener(onClickListener);

        shopCartAdapter = new ShopCartAdapter(ShopCartJieSuanActivity.this,
                priceAll,shop_cart_delete,shop_cart_bianji,shop_cart_cball,
                jiesuan_shopcart,shanchu_shopcart,shopCartList);
        shop_cart_lv.setAdapter(shopCartAdapter);


        shop_cart_lv.setOnItemClickListener(onItemClickListener);
    }

    List<ShopCart> shopCartList = new ArrayList<ShopCart>();

    View.OnClickListener onClickListener = new View.OnClickListener() {

        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.fanhui:
                    finish();
                    break;
                case R.id.shop_cart_cball:
                    break;
                case R.id.shop_cart_editing:
                    if (shop_cart_bianji.isChecked()==true){
                        shop_cart_bianji.setText("编辑");
                        shop_cart_bianji.setChecked(false);
                        jiesuan_shopcart.setVisibility(View.VISIBLE);
                        shanchu_shopcart.setVisibility(View.GONE);
                    }else{
                        jiesuan_shopcart.setVisibility(View.GONE);
                        shanchu_shopcart.setVisibility(View.VISIBLE);
                        shop_cart_bianji.setText("完成");
                        shop_cart_bianji.setChecked(true);

                    }

                    break;

            }
        }
    };
    ListView.OnItemClickListener onItemClickListener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (parent.getId()){
                case R.id.wancheng:
                    shopAdd= (ImageView) view.findViewById(R.id.shop_add);
                    shopSub= (ImageView) view.findViewById(R.id.shop_sub);
                    changegoods_num_01= (TextView) view.findViewById(R.id.changegoods_num_01);
                    View.OnClickListener onClickListener=new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            switch (v.getId()) {
                                case R.id.shop_add:
                                    changegoods_num_01.setText("" + (Integer.valueOf(changegoods_num_01.getText().toString()) + 1));
                                    break;
                                case R.id.shop_sub:
                                    if (Integer.valueOf(changegoods_num_01.getText().toString()) > 1) {
                                        changegoods_num_01.setText("" + (Integer.valueOf(changegoods_num_01.getText().toString()) - 1));
                                    }
                                    Toast.makeText(ShopCartJieSuanActivity.this, "不能再减了", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }
                    };
                    shopAdd.setOnClickListener(onClickListener);
                    shopSub.setOnClickListener(onClickListener);
                    break;
            }

        }
    };

}

