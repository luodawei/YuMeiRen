package com.xx.meirenyu.utill.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.xx.meirenyu.activity.OnlineServiceActivity;
import com.xx.meirenyu.activity.ShopCartJieSuanActivity;
import com.xx.meirenyu.activity.YogaHomeActivity;
import com.xx.meirenyu.utill.adapter.YogaShowGridViewAdapter;
import com.xx.meirenyu.utill.model.YogaShopGridViewModel;
import com.yss.yumeiren.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/26.
 */
public class YogaShopFragment extends Fragment {
    Activity myActivity;
    ImageView shop_cart;
    ImageView online_service;
    View view;
   // GridView gridView;
    //List<YogaShopGridViewModel> list=new ArrayList<YogaShopGridViewModel>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setGridView();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_yoga_shop,null);
        shop_cart = (ImageView) view.findViewById(R.id.shop_cart);
        online_service = (ImageView) view.findViewById(R.id.online_service);
        //gridView= (GridView) view.findViewById(R.id.yoga_show_gv);
        shop_cart.setOnClickListener(onClickListener);
        online_service.setOnClickListener(onClickListener);
        myActivity = getActivity();
       // getData();
        //YogaShowGridViewAdapter yogaShowGridViewAdapter=new YogaShowGridViewAdapter(getActivity(),list);
       // gridView.setAdapter(yogaShowGridViewAdapter);
        return view;
    }
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
            }
        }
    };
   /* public void setGridView(){

    }*/
   /* public void getData(){
        for (int i=0;i<10;i++){
            YogaShopGridViewModel model = new YogaShopGridViewModel();
            model.setImg(R.mipmap.ic_launcher);
            model.setName("商品名"+i);
            list.add(model);
        }

    }*/
}
