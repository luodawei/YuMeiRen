package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/11/26.
 * 更新版本的页面
 */

public class AppUpdateActivity extends Activity {
    ImageView backBtn;
    TextView appVersions,appVersionDetailsTitle,appVersionDetails;
    Button updateBtn;
    boolean isHaveUpdate=false;//判断是否有更新
    String odlVersion,newVersion;//版本好
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_update);
        getVersion();
        init();
        if (isHaveUpdate){
            updateBtn.setBackground(getResources().getDrawable(R.drawable.bg_login_now));
            updateBtn.setClickable(isHaveUpdate);

            isHaveUpdate=false;
        }else {
            updateBtn.setBackground(getResources().getDrawable(R.drawable.app_update_btn_false));
            updateBtn.setClickable(isHaveUpdate);
            isHaveUpdate=true;
        }

        backBtn.setOnClickListener(onClickListener);
        appVersionDetails.setOnClickListener(onClickListener);
        updateBtn.setOnClickListener(onClickListener);
    }
    //初始化空间方法
    public void init(){
        backBtn= (ImageView) findViewById(R.id.back_btn);
        appVersions= (TextView) findViewById(R.id.app_versions);
        appVersionDetailsTitle= (TextView) findViewById(R.id.app_version_details_title);
        appVersionDetails= (TextView) findViewById(R.id.app_version_details);
        updateBtn= (Button) findViewById(R.id.app_update_btn);
        appVersions.setText("已有最新版本：美人瑜"+newVersion);
        appVersionDetailsTitle.setText("美人瑜"+odlVersion+"主要更新");
        appVersionDetails.setText("更新了很对优惠，妹子多！");
    }
    Intent intent;
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        switch (v.getId()){
           case  R.id.back_btn:
               //更新返回按钮
            finish();
            break;
            case  R.id.app_update_btn:
                //版本更新按钮，通过判断版本状态，如果有就显示绿色可以点击，点击后更新
                getVersion();
                break;
        }
        }
    };
    //过得版本的方法
    public String getVersion(){
        odlVersion="1.3.34";
        newVersion="1.3.35";
        char[] ch1=odlVersion.toCharArray();
        char[] ch2=newVersion.toCharArray();
        for (int i=0;i<ch2.length;i++){
            if (ch2[i]>ch1[i]){
                odlVersion=newVersion;
            }
        }
        return odlVersion;
    }
}
