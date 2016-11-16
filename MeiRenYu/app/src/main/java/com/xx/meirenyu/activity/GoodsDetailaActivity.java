package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/10/19.
 */
public class GoodsDetailaActivity extends Activity {
    private TextView searchBackBtn,baoypuAddress,chanceSizeBtn,addShopCarBtn,buyNowBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_details);
        searchBackBtn= (TextView) findViewById(R.id.search_back_btn);
        baoypuAddress= (TextView) findViewById(R.id.baoypu_address);
        chanceSizeBtn= (TextView) findViewById(R.id.chance_size_btn);
        addShopCarBtn= (TextView) findViewById(R.id.add_shop_car_btn);
        buyNowBtn= (TextView) findViewById(R.id.buy_now_btn);

        searchBackBtn.setOnClickListener(onClickListener);
        baoypuAddress.setOnClickListener(onClickListener);
        chanceSizeBtn.setOnClickListener(onClickListener);
        addShopCarBtn.setOnClickListener(onClickListener);
        buyNowBtn.setOnClickListener(onClickListener);
    }
//监听事件
    View.OnClickListener onClickListener=new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.search_back_btn:
            finish();
            break;
        case R.id.baoypu_address:
            Toast.makeText(GoodsDetailaActivity.this,"请选择地址",Toast.LENGTH_SHORT).toString();
            break;
        case R.id.chance_size_btn:
            Toast.makeText(GoodsDetailaActivity.this,"请选择您喜欢的样式",Toast.LENGTH_SHORT).toString();
            break;
        case R.id.add_shop_car_btn:
            Toast.makeText(GoodsDetailaActivity.this,"加如购物车成功",Toast.LENGTH_SHORT).toString();
            break;
        case R.id.buy_now_btn:
            Intent intent=new Intent(GoodsDetailaActivity.this,ShopCartJieSuanAvtivity.class);
            startActivity(intent);
            break;
    }
    }
};
}
