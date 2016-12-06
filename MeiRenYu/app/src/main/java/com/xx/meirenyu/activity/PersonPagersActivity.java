package com.xx.meirenyu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;

import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/12/6.
 */

public class PersonPagersActivity extends Activity {
    LayoutInflater inflater;//视图转换器
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_pagers_lv);
        inflater=LayoutInflater.from(this);

    }
}
