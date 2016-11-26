package com.xx.meirenyu.utill.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.xx.meirenyu.utill.adapter.YuChiNearbyAdapter;
import com.xx.meirenyu.utill.adapter.YuChiNewAdapter;
import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/11/26.
 */
public class YuChiFragment extends Fragment {
    TextView btnNearBy;
    TextView btnNew;
    ListView yuChiListView;
    Activity activity;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_yu_chi,null);
        yuChiListView = (ListView) view.findViewById(R.id.yu_chi_list_view);
        btnNearBy = (TextView) view.findViewById(R.id.btn_nearby);
        btnNew = (TextView) view.findViewById(R.id.btn_new);
        activity = getActivity();

        yuChiListView.setAdapter(new YuChiNewAdapter(activity));
        btnNearBy.setOnClickListener(getOnClickListener());
        btnNew.setOnClickListener(getOnClickListener());

        return view;
    }
    public View.OnClickListener getOnClickListener(){
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_nearby:
                        yuChiListView.setAdapter(new YuChiNearbyAdapter(activity));
                        break;
                    case R.id.btn_new:
                        yuChiListView.setAdapter(new YuChiNewAdapter(activity));
                        break;
                }
            }
        };
        return onClickListener;
    }
}
