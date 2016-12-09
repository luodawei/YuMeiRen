package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.yss.yumeiren.R;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


/**
 * Created by David on 2016/10/24.
 * 设置登陆页面
 */

public class SetLoginActivity extends Activity {
    TextView btnLogin;
    TextView btnRegister;
    EditText inputAccount,inputPassword;
    Context context;
    String usernName,password;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    CheckBox passwordLook;
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
        inputPassword= (EditText) findViewById(R.id.input_password);
        passwordLook= (CheckBox) findViewById(R.id.password_look);
        /**
         * loginRequest是数据库，保存了登录时用户返回的ID，token
         * */
        sharedPreferences=context.getSharedPreferences("loginRequest",Activity.MODE_APPEND);
        editor=sharedPreferences.edit();
        //设置监听
        btnLogin.setOnClickListener(onClickListener);
        btnRegister.setOnClickListener(onClickListener);
        passwordLook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordLook.isChecked()){
                    //如果选中显示密码
                    inputPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    //否则隐藏密码
                    inputPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_login:
                    new Thread(){
                        @Override
                        public void run() {
                          login();
                        }
                    }.start();
                    Intent intent = new Intent(SetLoginActivity.this, YogaHomeActivity.class);
                    intent.putExtra("HaveLogin",true);
                    startActivity(intent);
                    break;
                case R.id.btn_register:
                    Intent intent1 = new Intent(SetLoginActivity.this, SetRegisterActivity.class);
                    startActivity(intent1);
                    break;
            }

        }
    };
    public void login(){
        //获得输入框的值
        usernName=inputAccount.getText().toString();
        password=inputPassword.getText().toString();
        try {
            String uri="http://192.168.7.23/index.php/home/user/login?username="+
                    URLEncoder.encode(usernName,"utf-8")+"&password="+password;
            try {
                /**
                 * UrlEncode编码主要用于将字符串以URL编码,，返回一个字符串；
                 * UrlDecode解码主要对字符串进行URL解码，返回已解码的字符串
                 * */
                URL url = new URL(uri);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode()==200){
                    StringBuilder builder=new StringBuilder();
                    InputStreamReader inputStreamReader=
                            new InputStreamReader(httpURLConnection.getInputStream(),"utf-8");
                    BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                    String s;
                    while((s=bufferedReader.readLine())!=null){
                        builder.append(s);
                    }
                    Log.i("Request","登录成功"+builder.toString());
                    if (inputStreamReader!=null){
                        inputStreamReader.close();
                }
                    String data=builder.toString();
                    //数据解析
                    JSONObject loginJsonObject=new JSONObject(data);
                    editor.putString("message",loginJsonObject.optString("message",""));
                    JSONObject loginResultJN=loginJsonObject.optJSONObject("result");
                    editor.putString("id",loginResultJN.optString("id",""));
                    editor.putString("token",loginResultJN.optString("token",""));
                    editor.commit();//提交数据
                }
            }catch (MalformedURLException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
