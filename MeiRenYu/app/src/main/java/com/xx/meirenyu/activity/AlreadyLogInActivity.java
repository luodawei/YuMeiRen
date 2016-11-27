package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.yss.yumeiren.R;
/**
 * Created by David on 2016/10/23.
 */
public class AlreadyLogInActivity extends Activity {
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
    RadioGroup menuBottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_log_in);
        myFriendLayout = (LinearLayout)findViewById(R.id.my_friend_layout);
        myPlanLayout = (LinearLayout)findViewById(R.id.my_plan_layout);
        myCollectionLayout = (LinearLayout) findViewById(R.id.my_collection_layout);
        myPostLayout = (LinearLayout) findViewById(R.id.my_post_layout);
        relativeRecommendLayout = (LinearLayout) findViewById(R.id.relative_recommend_layout);
        shareAppLayout = (LinearLayout) findViewById(R.id.share_app_layout);
        attentionLayout = (LinearLayout) findViewById(R.id.attention_layout);
        fansLayout = (LinearLayout) findViewById(R.id.fans_layout);
        integralLayout = (LinearLayout) findViewById(R.id.integral_layout);

        btnSetting = (ImageView) findViewById(R.id.btn_setting);

        //menuBottom = (RadioGroup) findViewById(R.id.menu_buttom);

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
        //menuBottom.setOnCheckedChangeListener(getOnCheckedChangeListener());
    }

    /**
     * RadioGroup监听
     * @return
     */
   /* private RadioGroup.OnCheckedChangeListener getOnCheckedChangeListener(){
        RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Intent intent;
                switch (checkedId){
                    case R.id.rd_btn_home:
                        intent = new Intent(AlreadyLogInActivity.this,YogaShopActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.rd_btn_pool:
                        break;
                    case R.id.rd_btn_shop:
                        intent = new Intent(AlreadyLogInActivity.this,YogaShopActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.rd_btn_mine:
                        break;
                }
            }
        };
        return onCheckedChangeListener;
    }*/

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.my_friend_layout:
                    //我的好友
                    Intent intent = new Intent(AlreadyLogInActivity.this,MyFriendsActivity.class);
                    startActivity(intent);
                    break;
                case R.id.my_plan_layout:
                    //我的计划
                    Intent intent1 = new Intent(AlreadyLogInActivity.this,MyPlanListViewActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.my_post_layout:
                    //瑜伽我的帖子
                    Intent intent2 = new Intent(AlreadyLogInActivity.this,YogaWoDeTieZiActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.my_collection_layout:
                    //我的收藏
                    Intent intent3 = new Intent(AlreadyLogInActivity.this,YogaMyCollectLvActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.relative_recommend_layout:
                    //订单
                    Intent intent4 = new Intent(AlreadyLogInActivity.this,MyOrderActivity.class);
                    startActivity(intent4);
                    break;
                case R.id.share_app_layout:
                    //分享APP
                    Intent intent5 = new Intent(AlreadyLogInActivity.this,ShareAppActivity.class);
                    startActivity(intent5);
                    break;
                case R.id.btn_setting:
                    //设置
                    Intent intent6 = new Intent(AlreadyLogInActivity.this,SettingActivity.class);
                    startActivity(intent6);
                    break;
                case R.id.attention_layout:
                    //关注
                    Intent intent7 = new Intent(AlreadyLogInActivity.this,MyGuanZhuActivity.class);
                    startActivity(intent7);
                    break;
                case R.id.fans_layout:
                    //我的粉丝
                    Intent intent8 = new Intent(AlreadyLogInActivity.this,FansActivity.class);
                    startActivity(intent8);
                    break;
                case R.id.integral_layout:
                    break;
            }
        }
    };
}
