package com.xx.meirenyu.utill.netutill;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * Created by Administrator on 2016/12/9.
 */

public class HttputillGet extends Thread{
    private String Uri;
    public HttputillGet(String Uri){

        this.Uri=Uri;
    }
    public String data=null;
    public void doGET(){
        try {
            /**
             * UrlEncode编码主要用于将字符串以URL编码,，返回一个字符串；
             * UrlDecode解码主要对字符串进行URL解码，返回已解码的字符串
             * */
            StringBuilder builder=new StringBuilder();
            URL url = new URL(Uri);
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();

            InputStreamReader inputStreamReader=
                    new InputStreamReader(httpURLConnection.getInputStream(),"utf-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String s;
            while((s=bufferedReader.readLine())!=null){
                builder.append(s);
            }
            Log.i("Request","请求成功"+builder.toString());
            data=builder.toString();
            if (inputStreamReader!=null){
                inputStreamReader.close();
            }

        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        doGET();
    }
}
