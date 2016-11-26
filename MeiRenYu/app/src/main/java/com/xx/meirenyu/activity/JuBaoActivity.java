package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/11/25.
 */

public class JuBaoActivity extends Activity {
    ImageView jubaoBackBtn;
    TextView jubaoSendBtn;
    CheckBox jubaoTypeNne,jubaoTypeTwo,jubaoTypeThree,jubaoTypeFouth,jubaoTypeFive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jubao);
        init();

    }
    public void init(){
        //初始化
        jubaoBackBtn= (ImageView) findViewById(R.id.jubao_back_btn);
        jubaoSendBtn= (TextView) findViewById(R.id.jubao_send_btn);

        jubaoTypeNne= (CheckBox) findViewById(R.id.jubao_type_one);
        jubaoTypeTwo= (CheckBox) findViewById(R.id.jubao_type_two);
        jubaoTypeThree= (CheckBox) findViewById(R.id.jubao_type_three);
        jubaoTypeFouth= (CheckBox) findViewById(R.id.jubao_type_furth);
        jubaoTypeFive= (CheckBox) findViewById(R.id.jubao_type_five);
        //设置监听
        jubaoBackBtn.setOnClickListener(onClickListener);
        jubaoSendBtn.setOnClickListener(onClickListener);

    }
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        switch (v.getId()){
            case R.id.jubao_back_btn:
                /*返回按钮*/
                finish();
                break;
            case R.id.jubao_send_btn:
                //发送消息
                Intent intent=new Intent(JuBaoActivity.this,JuBaoSuccesedActivity.class);
                startActivity(intent);
                Toast.makeText(JuBaoActivity.this,"举报成功",Toast.LENGTH_SHORT).show();
        }
        }
    };
}
