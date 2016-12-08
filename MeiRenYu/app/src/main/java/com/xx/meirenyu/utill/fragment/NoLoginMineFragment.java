package com.xx.meirenyu.utill.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xx.meirenyu.activity.FansActivity;
import com.xx.meirenyu.activity.GaoDeActivity;
import com.xx.meirenyu.activity.IntegralActivity;
import com.xx.meirenyu.activity.MyFriendsActivity;
import com.xx.meirenyu.activity.MyGuanZhuActivity;
import com.xx.meirenyu.activity.MyOrderActivity;
import com.xx.meirenyu.activity.MyPlanListViewActivity;
import com.xx.meirenyu.activity.SettingActivity;
import com.xx.meirenyu.activity.ShareAppActivity;
import com.xx.meirenyu.activity.YogaMyCollectLvActivity;
import com.xx.meirenyu.activity.YogaWoDeTieZiActivity;
import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/12/8.
 */

public class NoLoginMineFragment extends Fragment {
    TextView login;
    LinearLayout myFriendLayout;
    LinearLayout myPlanLayout;
    LinearLayout myCollectionLayout;
    LinearLayout myPostLayout;
    LinearLayout relativeRecommendLayout;
    LinearLayout shareAppLayout;
    LinearLayout attentionLayout;
    LinearLayout fansLayout;
    LinearLayout integralLayout;
    LinearLayout myLocation;
    ImageView btnSetting;
    Activity activity;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_login,null);
        login= (TextView) view.findViewById(R.id.login);
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
        myLocation= (LinearLayout) view.findViewById(R.id.my_location);
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
        myLocation.setOnClickListener(onClickListener);
        return view;
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()){
                case R.id.my_friend_layout:
                    //我的好友
                    intent = new Intent(activity,MyFriendsActivity.class);
                    startActivity(intent);
                    break;
                case R.id.my_plan_layout:
                    //我的计划
                    intent = new Intent(activity,MyPlanListViewActivity.class);
                    startActivity(intent);
                    break;
                case R.id.my_post_layout:
                    //瑜伽我的帖子
                    intent = new Intent(activity,YogaWoDeTieZiActivity.class);
                    startActivity(intent);
                    break;
                case R.id.my_collection_layout:
                    //我的收藏
                    intent = new Intent(activity,YogaMyCollectLvActivity.class);
                    startActivity(intent);
                    break;
                case R.id.relative_recommend_layout:
                    //订单
                    intent = new Intent(activity,MyOrderActivity.class);
                    startActivity(intent);
                    break;
                case R.id.share_app_layout:
                    //分享APP
                    intent = new Intent(activity,ShareAppActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_setting:
                    //设置
                    intent = new Intent(activity,SettingActivity.class);
                    startActivity(intent);
                    break;
                case R.id.attention_layout:
                    //关注
                    intent = new Intent(activity,MyGuanZhuActivity.class);
                    startActivity(intent);
                    break;
                case R.id.fans_layout:
                    //我的粉丝
                    intent = new Intent(activity,FansActivity.class);
                    startActivity(intent);
                    break;
                //积分
                case R.id.integral_layout:
                    intent = new Intent(activity,IntegralActivity.class);
                    startActivity(intent);
                    break;
                case R.id.my_location:
                    intent = new Intent(activity,GaoDeActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
    public void loginDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(activity);
        builder.setTitle("提示")
                .setIcon()
    }
}
