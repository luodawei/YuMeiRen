package com.xx.meirenyu.utill.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;

import com.xx.meirenyu.activity.SetLoginActivity;
import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/12/8.
 */

public class NoLoginDialog {
    Context context;
    public NoLoginDialog(Context context){
        this.context=context;
    }
    public void loginDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle("提示")
                .setIcon(R.mipmap.jinggao)
                .setMessage("您还未登录,是否立即登陆")
                .setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(context, SetLoginActivity.class);
                        context.startActivity(intent);
                    }
                }).setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
}
