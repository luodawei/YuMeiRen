package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

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
        myFriendLayout.setOnClickListener(onClickListener);
        myPlanLayout.setOnClickListener(onClickListener);
        myCollectionLayout.setOnClickListener(onClickListener);
        myPostLayout.setOnClickListener(onClickListener);
        relativeRecommendLayout.setOnClickListener(onClickListener);
        shareAppLayout.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.my_friend_layout:
                    Intent intent = new Intent(AlreadyLogInActivity.this,MyFriendsActivity.class);
                    startActivity(intent);
                    break;
                case R.id.my_plan_layout:
                    Intent intent1 = new Intent(AlreadyLogInActivity.this,MyPlanListViewActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.my_post_layout:
                    Intent intent2 = new Intent(AlreadyLogInActivity.this,MyPlanListViewActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.my_collection_layout:
                    Intent intent3 = new Intent(AlreadyLogInActivity.this,MyPlanListViewActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.relative_recommend_layout:
                    Intent intent4 = new Intent(AlreadyLogInActivity.this,MyFriendsActivity.class);
                    startActivity(intent4);
                    break;
                case R.id.share_app_layout:
                    Intent intent5 = new Intent(AlreadyLogInActivity.this,ShareAppActivity.class);
                    startActivity(intent5);
                    break;
            }
        }
    };
}
