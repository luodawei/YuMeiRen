package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.yss.yumeiren.R;

/**
 * Created by David on 2016/10/23.
 * 我的计划详情
 */

public class MyPlanDetailActivity extends Activity {
    ImageView btnBack;
    ImageView btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_plan_detail);
        btnBack = (ImageView)findViewById(R.id.btn_back);
        btnAdd = (ImageView) findViewById(R.id.btn_add);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 获得监听事件对象的方法
     * @return
     */
    public View.OnClickListener getOnClickListener(){
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_add:
                        Toast.makeText(MyPlanDetailActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
        return onClickListener;
    }

}
