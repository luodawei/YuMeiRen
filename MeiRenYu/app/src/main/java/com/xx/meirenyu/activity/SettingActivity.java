package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/10/19.
 * 系统设置页面
 */
public class SettingActivity extends Activity {
    TextView clearhuancun;//清除缓存按钮
    LayoutInflater layoutInflater;//视图转换器
    AlertDialog alertDialog;//弹出框对象
    AlertDialog.Builder builder;//builder对象
    Button yesBtn;//清除缓存确认按钮
    Button noBtn;//清除缓存取消按钮
    TextView exitText;//退出按钮
    TextView exitBtn;//退出登录按钮
    Button canceBtn;//取消取出登录按钮
    TextView fontsetting;//字体设置按钮
    TextView xiaohao;//小号设置按钮
    TextView biaozhun;//标准字体设置按钮
    TextView dahao;//大号字体设置按钮
    TextView teda;//特大号字体设置按钮
    TextView messageSettingBtn;//设置页面消息提示按钮
    TextView settingBackBtn;//返回按钮
    TextView setWeiBoBtn;//微博绑定按钮
    TextView aboutUsBtn;//关于我们跳转按钮
    Intent intent;//跳转意图
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        clearhuancun= (TextView) findViewById(R.id.clear_huancun);
        exitText= (TextView) findViewById(R.id.exit_text);
        fontsetting= (TextView) findViewById(R.id.font_setting);
        messageSettingBtn= (TextView) findViewById(R.id.message_setting_btn);
        settingBackBtn= (TextView) findViewById(R.id.search_back_btn);
        setWeiBoBtn= (TextView) findViewById(R.id.set_weiBo_btn);
        aboutUsBtn= (TextView) findViewById(R.id.about_us_btn);
        //设置监听
        fontsetting.setOnClickListener(onClickListener);
        exitText.setOnClickListener(onClickListener);
        clearhuancun.setOnClickListener(onClickListener);
        messageSettingBtn.setOnClickListener(onClickListener);
        settingBackBtn.setOnClickListener(onClickListener);
        setWeiBoBtn.setOnClickListener(onClickListener);
        aboutUsBtn.setOnClickListener(onClickListener);
    }
    //创建ClearDialog方法
    public void createClearDialog(){
        layoutInflater=LayoutInflater.from(this);
        builder=new AlertDialog.Builder(this);
        View view=layoutInflater.inflate(R.layout.dialog_clear_cache,null);
        //给确认和取消设置监听
        yesBtn= (Button) view.findViewById(R.id.yes);
        noBtn= (Button) view.findViewById(R.id.no);
        yesBtn.setOnClickListener(onClickListener);
        noBtn.setOnClickListener(onClickListener);
        builder.setView(view);
        alertDialog=builder.create();
        Window window=alertDialog.getWindow();
        WindowManager.LayoutParams ip=window.getAttributes();
        window.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL);
        window.setAttributes(ip);
        alertDialog.show();
    }
    //创建ExitDialog方法
    public void createExitDialog(){
        layoutInflater=LayoutInflater.from(this);
        builder=new AlertDialog.Builder(this);
        View view=layoutInflater.inflate(R.layout.dialog_log_off,null);
        //给确认和取消设置监听
        exitBtn= (TextView) view.findViewById(R.id.exit_btn);
        canceBtn= (Button) view.findViewById(R.id.cance_btn);
        exitBtn.setOnClickListener(onClickListener);
        canceBtn.setOnClickListener(onClickListener);
        builder.setView(view);
        alertDialog=builder.create();
        Window window=alertDialog.getWindow();
        WindowManager.LayoutParams ip=window.getAttributes();
        window.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL);
        window.setAttributes(ip);
        alertDialog.show();
    }
    //创建字体设置弹出框设置
    public void createFontDialog(){
        layoutInflater=LayoutInflater.from(this);
        builder=new AlertDialog.Builder(this);
        View fontView=layoutInflater.inflate(R.layout.dialog_set_font,null);
        xiaohao=(TextView)fontView.findViewById(R.id.font_xiao);
        xiaohao.setOnClickListener(onClickListener);
        biaozhun=(TextView)fontView.findViewById(R.id.font_biaozhun);
        biaozhun.setOnClickListener(onClickListener);
        dahao=(TextView)fontView.findViewById(R.id.font_da);
        dahao.setOnClickListener(onClickListener);
        teda=(TextView)fontView.findViewById(R.id.font_teda);
        teda.setOnClickListener(onClickListener);
        builder.setView(fontView);//设置自定义对话框view视图
        alertDialog=builder.create();//获得一个alertdialog对象
        alertDialog.show();//设置字体弹出框显示
    }
    //设置点击事件监听
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                //清除缓存事件
                case R.id.clear_huancun:
                    /*清除缓存按钮弹出框点击事件*/
                    createClearDialog();
                    break;
                case R.id.yes:
                       /*清除缓存弹出框确认按钮点击事件*/
                    alertDialog.dismiss();
                    Toast.makeText(SettingActivity.this,"恭喜您成功清除缓存",Toast.LENGTH_LONG).show();
                    break;
                case R.id.no:
                    /*清除缓存弹出框取消按钮点击事件*/
                    alertDialog.dismiss();
                    Toast.makeText(SettingActivity.this,"恭喜您成功取消清除缓存",Toast.LENGTH_LONG).show();
                    break;
                //退出事件
                case R.id.exit_text:

                    createExitDialog();
                    break;
                case R.id.exit_btn:
                    /*退出弹出框确认按钮点击事件*/
                    alertDialog.dismiss();
                    intent=new Intent(SettingActivity.this,SetLoginActivity.class);
                    startActivity(intent);
                    break;
                case R.id.cance_btn:
                    /*退出弹出框取消按钮点击事件*/
                    alertDialog.dismiss();
                    Toast.makeText(SettingActivity.this,"恭喜您成功取消退出",Toast.LENGTH_LONG).show();
                    break;
                case R.id.font_setting:
                    /*设置字体弹出框点击事件*/
                    createFontDialog();
                    break;
                case R.id.font_xiao:
                    /*小号字体点击事件*/
                        xiaohao.setBackground(getResources().getDrawable(R.mipmap.gou_true_image));
                        biaozhun.setBackgroundColor(getResources().getColor(R.color.white));
                        dahao.setBackgroundColor(getResources().getColor(R.color.white));
                        teda.setBackgroundColor(getResources().getColor(R.color.white));
                    Toast.makeText(SettingActivity.this,"字体大小设置小号",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.font_biaozhun:
                    /*标准字体点击事件*/
                        biaozhun.setBackground(getResources().getDrawable(R.mipmap.gou_true_image));
                        xiaohao.setBackgroundColor(getResources().getColor(R.color.white));
                        dahao.setBackgroundColor(getResources().getColor(R.color.white));
                        teda.setBackgroundColor(getResources().getColor(R.color.white));
                        Toast.makeText(SettingActivity.this,"字体大小设置为标准",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.font_da:
                      /*设置大字体监听*/
                        dahao.setBackground(getResources().getDrawable(R.mipmap.gou_true_image));
                        biaozhun.setBackgroundColor(getResources().getColor(R.color.white));
                        xiaohao.setBackgroundColor(getResources().getColor(R.color.white));
                        teda.setBackgroundColor(getResources().getColor(R.color.white));
                    Toast.makeText(SettingActivity.this,"字体大小设置为大号",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.font_teda:
                    /*设置特大字体监听*/
                        teda.setBackground(getResources().getDrawable(R.mipmap.gou_true_image));
                        biaozhun.setBackgroundColor(getResources().getColor(R.color.white));
                        dahao.setBackgroundColor(getResources().getColor(R.color.white));
                        xiaohao.setBackgroundColor(getResources().getColor(R.color.white));
                    Toast.makeText(SettingActivity.this,"字体大小设置为特大号",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.message_setting_btn:
                    //消息提示按钮监听事件
                    intent=new Intent(SettingActivity.this,MessageHintActivity.class);
                    startActivity(intent);
                    break;
                case R.id.search_back_btn:
                    //设置页面返回按钮点击监听事件，当点击按钮时，结束当前Activity
                    finish();
                    break;
                case R.id.push_message_btn:
                    /*消息推送按钮监听事件*/
                    break;
                case R.id.saving_flow_btn:
                    /*节省流量按钮监听事件*/
                    break;
                case R.id.volume_btn_to_Page:
                    /*设置音量键翻页按钮监听事件*/
                    break;
                case R.id.set_weiBo_btn:
                    /*绑定微博按钮事件*/
                    intent=new Intent(SettingActivity.this,SetWeiboActivity.class);
                    startActivity(intent);
                    break;
                case R.id.about_us_btn:
                    intent=new Intent(SettingActivity.this,AboutUsActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
