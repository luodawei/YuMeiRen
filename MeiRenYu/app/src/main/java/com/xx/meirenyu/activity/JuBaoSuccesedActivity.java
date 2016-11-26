package com.xx.meirenyu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/11/25.
 * 这个类是举报成功后的页面，提示用户！
 */

public class JuBaoSuccesedActivity extends Activity {
    ImageView jubaoSudBackBtn;
    TextView jubaoQuedingBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jubao_succeed);

    }
public void init(){
    jubaoSudBackBtn= (ImageView) findViewById(R.id.back_btn);
    jubaoQuedingBtn= (TextView) findViewById(R.id.queren);
}
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_btn:
                //举报返回按钮
                finish();
                break;
            case R.id.queren:
                //确认
                break;
        }
        }
    };
}
