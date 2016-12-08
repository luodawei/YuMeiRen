package com.xx.meirenyu.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.xx.meirenyu.utill.fragment.MineFragment;
import com.xx.meirenyu.utill.model.User;
import com.xx.meirenyu.utill.netutill.HttpUtils;
import com.xx.meirenyu.utill.netutill.NetUtils;
import com.yss.yumeiren.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by David on 2016/10/24.
 * 设置登陆页面
 */

public class SetLoginActivity extends Activity {
    TextView btnLogin;
    TextView btnRegister;
    EditText inputAccount,inputPassword;
    NetUtils   netUtils;//检查网络的工具类
    HttpUtils httpUtils;//网络请求把工具类
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_login);
        context=this;
        init();
    }
    //用方法初始化控件
    public void init(){
        btnLogin = (TextView) findViewById(R.id.btn_login);
        btnRegister = (TextView) findViewById(R.id.btn_register);
        inputAccount= (EditText) findViewById(R.id.input_account);
        inputAccount= (EditText) findViewById(R.id.input_password);
        //设置监听
        btnLogin.setOnClickListener(onClickListener);
        btnRegister.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_login:
                   new Thread(){
                       @Override
                       public void run() {
                          Login();
                       }
                   }.start();
                    /*Intent intent = new Intent(SetLoginActivity.this, YogaHomeActivity.class);
                    intent.putExtra("HaveLogin",true);
                    startActivity(intent);*/
                    break;
                case R.id.btn_register:
                    Intent intent1 = new Intent(SetLoginActivity.this, SetRegisterActivity.class);
                    startActivity(intent1);
                    break;
            }
        }
    };
    public void Login(){
            try {
                StringBuilder builder=new StringBuilder();
                String uri="http://10.0.2.3/index.php/home/shop/getShop?shop_name="+ URLDecoder.decode("能吃的瑜伽垫","utf-8");
                URL url = new URL(uri);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();


                InputStreamReader inputStreamReader=new InputStreamReader(httpURLConnection.getInputStream(),"utf-8");
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                String s;
                while((s=bufferedReader.readLine())!=null){
                    builder.append(s);
                }
                Log.i("Request","请求成功"+builder.toString());
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
