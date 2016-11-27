package com.xx.meirenyu.utill.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.xx.meirenyu.activity.PostActivity;
import com.xx.meirenyu.activity.PostMsgLvActivity;
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
    ImageView btnAdd;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_yu_chi, null);
        yuChiListView = (ListView) view.findViewById(R.id.yu_chi_fragment_list_view);
        btnNearBy = (TextView) view.findViewById(R.id.btn_nearby);
        btnNew = (TextView) view.findViewById(R.id.btn_new);
        btnAdd = (ImageView) view.findViewById(R.id.btn_add);
        activity = getActivity();

        yuChiListView.setAdapter(new YuChiNewAdapter(activity));
        btnNearBy.setOnClickListener(getOnClickListener());
        btnNew.setOnClickListener(getOnClickListener());
        btnAdd.setOnClickListener(getOnClickListener());
        yuChiListView.setOnItemClickListener(onItemClickListener);
        return view;
    }

    ListView.OnItemClickListener onItemClickListener = new ListView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Log.i("onItemClick", "onItemClick");
            Intent intent;
            switch (position) {
                case 0:
                    intent = new Intent(activity, PostMsgLvActivity.class);
                    startActivity(intent);
                    Toast.makeText(activity, "点击了Item", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    intent = new Intent(activity, PostMsgLvActivity.class);
                    startActivity(intent);
                    Toast.makeText(activity, "点击了Item", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    intent = new Intent(activity, PostMsgLvActivity.class);
                    startActivity(intent);
                    Toast.makeText(activity, "点击了Item", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    intent = new Intent(activity, PostMsgLvActivity.class);
                    startActivity(intent);
                    Toast.makeText(activity, "点击了Item", Toast.LENGTH_SHORT).show();
                    break;
                case 4:
                    intent = new Intent(activity, PostMsgLvActivity.class);
                    startActivity(intent);
                    Toast.makeText(activity, "点击了Item", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    public View.OnClickListener getOnClickListener() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (v.getId()) {
                    case R.id.btn_nearby:
                        btnNearBy.setTextColor(getResources().getColor(R.color.white));
                        btnNearBy.setBackgroundColor(getResources().getColor(R.color.main_blue));
                        btnNew.setTextColor(getResources().getColor(R.color.black));
                        btnNew.setBackgroundColor(getResources().getColor(R.color.grey));
                        yuChiListView.setAdapter(new YuChiNearbyAdapter(activity));
                        break;
                    case R.id.btn_new:
                        btnNew.setTextColor(getResources().getColor(R.color.white));
                        btnNew.setBackgroundColor(getResources().getColor(R.color.main_blue));
                        btnNearBy.setTextColor(getResources().getColor(R.color.black));
                        btnNearBy.setBackgroundColor(getResources().getColor(R.color.grey));
                        yuChiListView.setAdapter(new YuChiNewAdapter(activity));
                        break;
                    case R.id.btn_add:
                        intent = new Intent(activity, PostActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        };
        return onClickListener;
    }
}
