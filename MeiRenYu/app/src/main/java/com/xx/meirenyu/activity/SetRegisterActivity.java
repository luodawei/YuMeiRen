package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yss.yumeiren.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by David on 2016/10/24.
 * 设置注册页面
 */
public class SetRegisterActivity extends Activity {
    Context context;
    EditText inputPhone,inputPassword,
            inputRepassword,inputVerification;
    TextView userAgreement,
            nowRegisterBtn,registerZhiFuBao,
            registerWeiXin,registerWeiBo;
    CheckBox userAgreementBtn,passwordLook,getVerificationCode;
    String phoneNumber,password,repassword;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_register);
        context=this;
        init();
    }
    //初始化控件方法
    public void init(){
        inputPhone= (EditText) findViewById(R.id.input_phone);
        inputPassword= (EditText) findViewById(R.id.input_password);
        inputRepassword= (EditText) findViewById(R.id.input_repassword);
        inputVerification= (EditText) findViewById(R.id.input_verification);


        userAgreement= (TextView) findViewById(R.id.user_agreement);
        nowRegisterBtn= (TextView) findViewById(R.id.now_register_btn);
        registerZhiFuBao= (TextView) findViewById(R.id.register_zhifubao);
        registerWeiXin= (TextView) findViewById(R.id.register_weixin);
        registerWeiBo= (TextView) findViewById(R.id.regisetr_weibo);

        userAgreementBtn= (CheckBox) findViewById(R.id.user_agreement_btn);
        passwordLook= (CheckBox) findViewById(R.id.password_look);
        getVerificationCode= (CheckBox) findViewById(R.id.get_verification_code);
        sharedPreferences=context.getSharedPreferences("registerRequest",Activity.MODE_APPEND);
        editor=sharedPreferences.edit();
        //设置监听
        getVerificationCode.setOnClickListener(onClickListener);
        nowRegisterBtn.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        switch (v.getId()){
            case R.id.get_verification_code:
                phoneNumber=phoneNumber.trim();
                if (!TextUtils.isEmpty(phoneNumber)&&!TextUtils.isEmpty(password)&&!TextUtils.isEmpty(repassword)){
                    getVerificationCode.setChecked(true);
                }
                if (getVerificationCode.isChecked()){
                    Toast.makeText(SetRegisterActivity.this,"发送验证码",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SetRegisterActivity.this,"请输入验证码或密码",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.now_register_btn:
                        if (!TextUtils.isEmpty(getVerificationCode.getText().toString())){
                           if (userAgreementBtn.isChecked()){
                               new Thread() {
                                   @Override
                                   public void run() {
                                       register();
                                   }
                               }.start();
                               Toast.makeText(context,"登录成功",Toast.LENGTH_SHORT);
                           }else {
                               Toast.makeText(context,"请同意用户协议",Toast.LENGTH_SHORT);
                           }
                        }else {
                            Toast.makeText(context,"请输入验证码",Toast.LENGTH_SHORT);
                        }

                break;
        }
        }
    };
    public void register(){
        phoneNumber=inputPhone.getText().toString();
        password=inputPassword.getText().toString();
        repassword=inputRepassword.getText().toString();
        try {
            String uri="http://192.168.7.23/index.php/home/user/register?username="+phoneNumber+"&password="+password+"&repassword="+repassword;
            URL url=new URL(uri);
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.connect();
            if (conn.getResponseCode()==200){
                StringBuilder builder=new StringBuilder();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
                String s;
                while ((s=bufferedReader.readLine())!=null){
                    builder.append(s);
                }
                String data=builder.toString();
                Log.i("RegisterRequest",data);
                if (bufferedReader!=null){
                    bufferedReader.close();
                }
                //数据解析
                JSONObject registerJS=new JSONObject(data);
                message=registerJS.optString("message","");
                editor.putString("usertoken",registerJS.optString("userToken",""));
                editor.commit();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
