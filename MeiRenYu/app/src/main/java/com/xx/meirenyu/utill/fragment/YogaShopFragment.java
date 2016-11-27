package com.xx.meirenyu.utill.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xx.meirenyu.activity.OnlineServiceActivity;
import com.xx.meirenyu.activity.ShopCartJieSuanActivity;
import com.xx.meirenyu.activity.YogaClothesActivity;
import com.xx.meirenyu.activity.YogaCushionActivity;
import com.xx.meirenyu.activity.YogaHomeActivity;
import com.xx.meirenyu.activity.YogaOtherShopActivity;
import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/11/26.
 */
public class YogaShopFragment extends Fragment {
    Activity myActivity;
    ImageView shop_cart;
    ImageView online_service;
    TextView yogaClothes;
    TextView yogaCushion;
    TextView yogaOtherShop;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_yoga_shop,null);
        shop_cart = (ImageView) view.findViewById(R.id.shop_cart);
        online_service = (ImageView) view.findViewById(R.id.online_service);
        yogaClothes = (TextView) view.findViewById(R.id.textView1);
        yogaCushion = (TextView) view.findViewById(R.id.textView2);
        yogaOtherShop = (TextView) view.findViewById(R.id.textView3);

        shop_cart.setOnClickListener(getOnClickListener());
        online_service.setOnClickListener(getOnClickListener());
        yogaClothes.setOnClickListener(getOnClickListener());
        yogaCushion.setOnClickListener(getOnClickListener());
        yogaOtherShop.setOnClickListener(getOnClickListener());
        myActivity = getActivity();
        return view;
    }

    /**
     * 获得onClickListener对象的方法
     * @return
     */
    public View.OnClickListener getOnClickListener(){
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (v.getId()) {
                    case R.id.shop_cart:
                        intent = new Intent(myActivity, ShopCartJieSuanActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.online_service:
                        intent = new Intent(myActivity, OnlineServiceActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.textView1:
                        intent = new Intent(myActivity, YogaClothesActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.textView2:
                        intent = new Intent(myActivity, YogaCushionActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.textView3:
                        intent = new Intent(myActivity, YogaOtherShopActivity.class);
                        startActivity(intent);
                        break;

                }
            }
        };
        return onClickListener;
    }

}
