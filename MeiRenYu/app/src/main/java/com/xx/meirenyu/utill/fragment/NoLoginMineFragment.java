package com.xx.meirenyu.utill.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xx.meirenyu.activity.SetLoginActivity;
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
        login.setOnClickListener(onClickListener);
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
        myFriendLayout.setOnClickListener(onClickListener);
        myPlanLayout.setOnClickListener(onClickListener);
        myCollectionLayout.setOnClickListener(onClickListener);
        myPostLayout.setOnClickListener(onClickListener);
        relativeRecommendLayout.setOnClickListener(onClickListener);
        shareAppLayout.setOnClickListener(onClickListener);
        myLocation.setOnClickListener(onClickListener);
        return view;
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()){
                case R.id.login:
                    intent=new Intent(activity,SetLoginActivity.class);
                    startActivity(intent);
                    break;
                case R.id.my_friend_layout:
                    //我的好友
                    loginDialog();
                    break;
                case R.id.my_plan_layout:
                    //我的计划
                    loginDialog();
                    break;
                case R.id.my_post_layout:
                    //瑜伽我的帖子
                    loginDialog();
                    break;
                case R.id.my_collection_layout:
                    //我的收藏
                    loginDialog();
                    break;
                case R.id.relative_recommend_layout:
                    //订单
                    loginDialog();
                    break;
                case R.id.share_app_layout:
                    //分享APP
                    loginDialog();
                    break;
                case R.id.my_location:
                    loginDialog();
                    break;
            }
        }
    };
    public void loginDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(activity);
        builder.setTitle("提示")
                .setIcon(R.mipmap.jinggao)
                .setMessage("您还未登录,是否立即登陆")
        .setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(activity, SetLoginActivity.class);
                startActivity(intent);
            }
        }).setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
}
