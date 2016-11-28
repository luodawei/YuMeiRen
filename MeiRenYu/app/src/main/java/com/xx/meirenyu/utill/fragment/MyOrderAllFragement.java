package com.xx.meirenyu.utill.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.xx.meirenyu.utill.adapter.MyOrderAllAdapter;
import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/11/27.
 */
public class MyOrderAllFragement extends Fragment {
    ListView my_order_lv;
    Activity activity;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myorder_listview,null);
        my_order_lv = (ListView) view.findViewById(R.id.myorder_listview);
        MyOrderAllAdapter myOrderAllAdapter = new MyOrderAllAdapter(getActivity());
        my_order_lv.setAdapter(myOrderAllAdapter);
        activity =getActivity();
        return view;
    }
}
