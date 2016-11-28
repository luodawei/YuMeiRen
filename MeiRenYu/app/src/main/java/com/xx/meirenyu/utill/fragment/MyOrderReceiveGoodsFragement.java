package com.xx.meirenyu.utill.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.xx.meirenyu.utill.adapter.MyOrderReceiveGoodsAdapter;
import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/11/27.
 */
public class MyOrderReceiveGoodsFragement extends Fragment {
    ListView myorder_lv;
    Activity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myorder_listview,null);
        myorder_lv = (ListView) view.findViewById(R.id.myorder_listview);
        MyOrderReceiveGoodsAdapter myOrderReceiveGoodsAdapter = new MyOrderReceiveGoodsAdapter(getActivity());
        myorder_lv.setAdapter(myOrderReceiveGoodsAdapter);
        activity =getActivity();
        return view;
    }
}
