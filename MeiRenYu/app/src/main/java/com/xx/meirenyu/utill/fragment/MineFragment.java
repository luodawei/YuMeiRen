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
import android.widget.LinearLayout;

import com.xx.meirenyu.activity.FansActivity;
import com.xx.meirenyu.activity.MyFriendsActivity;
import com.xx.meirenyu.activity.MyGuanZhuActivity;
import com.xx.meirenyu.activity.MyOrderActivity;
import com.xx.meirenyu.activity.MyPlanListViewActivity;
import com.xx.meirenyu.activity.SettingActivity;
import com.xx.meirenyu.activity.ShareAppActivity;
import com.xx.meirenyu.activity.YogaMyCollectionLvActivity;
import com.xx.meirenyu.activity.YogaWoDeTieZiActivity;
import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/11/26.
 */
public class MineFragment extends Fragment {
    LinearLayout myFriendLayout;
    LinearLayout myPlanLayout;
    LinearLayout myCollectionLayout;
    LinearLayout myPostLayout;
    LinearLayout relativeRecommendLayout;
    LinearLayout shareAppLayout;
    LinearLayout attentionLayout;
    LinearLayout fansLayout;
    LinearLayout integralLayout;
    ImageView btnSetting;
    Activity activity;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine,null);
        activity = getActivity();
        myFriendLayout = (LinearLayout)view.findViewById(R.id.my_friend_layout);
        myPlanLayout = (LinearLayout)view.findViewById(R.id.my_plan_layout);
        myCollectionLayout = (LinearLayout) view.findViewById(R.id.my_collection_layout);
        myPostLayout = (LinearLayout) view.findViewById(R.id.my_post_layout);
        relativeRecommendLayout = (LinearLayout) view.findViewById(R.id.relative_recommend_layout);
        shareAppLayout = (LinearLayout) view.findViewById(R.id.share_app_layout);
        attentionLayout = (LinearLayout) view.findViewById(R.id.attention_layout);
        fansLayout = (LinearLayout) view.findViewById(R.id.fans_layout);
        integralLayout = (LinearLayout) view.findViewById(R.id.integral_layout);

        btnSetting = (ImageView) view.findViewById(R.id.btn_setting);

        myFriendLayout.setOnClickListener(onClickListener);
        myPlanLayout.setOnClickListener(onClickListener);
        myCollectionLayout.setOnClickListener(onClickListener);
        myPostLayout.setOnClickListener(onClickListener);
        relativeRecommendLayout.setOnClickListener(onClickListener);
        shareAppLayout.setOnClickListener(onClickListener);
        btnSetting.setOnClickListener(onClickListener);
        attentionLayout.setOnClickListener(onClickListener);
        fansLayout.setOnClickListener(onClickListener);
        integralLayout.setOnClickListener(onClickListener);
        return view;
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.my_friend_layout:
                    //我的好友
                    Intent intent = new Intent(activity,MyFriendsActivity.class);
                    startActivity(intent);
                    break;
                case R.id.my_plan_layout:
                    //我的计划
                    Intent intent1 = new Intent(activity,MyPlanListViewActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.my_post_layout:
                    //瑜伽我的帖子
                    Intent intent2 = new Intent(activity,YogaWoDeTieZiActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.my_collection_layout:
                    //我的收藏
                    Intent intent3 = new Intent(activity,YogaMyCollectionLvActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.relative_recommend_layout:
                    //订单
                    Intent intent4 = new Intent(activity,MyOrderActivity.class);
                    startActivity(intent4);
                    break;
                case R.id.share_app_layout:
                    //分享APP
                    Intent intent5 = new Intent(activity,ShareAppActivity.class);
                    startActivity(intent5);
                    break;
                case R.id.btn_setting:
                    //设置
                    Intent intent6 = new Intent(activity,SettingActivity.class);
                    startActivity(intent6);
                    break;
                case R.id.attention_layout:
                    //关注
                    Intent intent7 = new Intent(activity,MyGuanZhuActivity.class);
                    startActivity(intent7);
                    break;
                case R.id.fans_layout:
                    //我的粉丝
                    Intent intent8 = new Intent(activity,FansActivity.class);
                    startActivity(intent8);
                    break;
                case R.id.integral_layout:
                    break;
            }
        }
    };
}
