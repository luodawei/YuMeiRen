package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yss.yumeiren.R;

/**
 * Created by David on 2016/10/24.
 * 设置登陆页面
 */

public class SetLoginActivity extends Activity {
    TextView btnLogin;
    TextView btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_login);
        btnLogin = (TextView) findViewById(R.id.btn_login);
        btnRegister = (TextView) findViewById(R.id.btn_register);
        btnLogin.setOnClickListener(onClickListener);
        btnRegister.setOnClickListener(onClickListener);
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_login:
                    Intent intent = new Intent(SetLoginActivity.this,AlreadyLogInActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_register:
                    Intent intent1 = new Intent(SetLoginActivity.this,SetRegisterActivity.class);
                    startActivity(intent1);
                    break;
            }
        }
    };
}
