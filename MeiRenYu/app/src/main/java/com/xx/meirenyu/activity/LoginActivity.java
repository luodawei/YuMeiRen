package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xx.meirenyu.utill.fragment.MineFragment;
import com.yss.yumeiren.R;

/**
 * Created by David on 2016/10/23.
 */

public class LoginActivity extends Activity {
    StringBuilder builder=new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView login = (TextView)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MineFragment.class);
                startActivity(intent);
            }
        });
    }

}
