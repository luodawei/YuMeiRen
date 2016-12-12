package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.yss.yumeiren.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

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
        new Thread(){
            @Override
            public void run() {
                getData();
            }
        }.start();
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
    private void getData(){
        StringBuilder stringBuilder = new StringBuilder();//创建一个字符序列
        String httpUrl = "http://10.0.2.2/index.php/home/Report/addReport?user_id=1&topic_id=1&content=4561335455&date=2016-12-10";
        try {
                URL url = null;
                url = new URL(httpUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.connect();

                if (httpURLConnection.getResponseCode()==200){
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(),"utf-8"));
                    String s;
                    while ((s = bufferedReader.readLine())!=null){
                    stringBuilder.append(s);
                }
                Log.i("data ====>",stringBuilder.toString());
                JSONObject jsonObject = new JSONObject(stringBuilder.toString());
                JSONArray jsonArray = jsonObject.getJSONArray("newslist");
                for (int i = 0;i<jsonArray.length();i++){
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                }
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
