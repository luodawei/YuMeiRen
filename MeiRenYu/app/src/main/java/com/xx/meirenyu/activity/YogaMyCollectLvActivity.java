package com.xx.meirenyu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.xx.meirenyu.utill.adapter.MyCollectAdapter;
import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/11/27.
 */
public class YogaMyCollectLvActivity extends Activity{
    ListView myCollectList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_my_collect_lv);
        myCollectList = (ListView) findViewById(R.id.yoga_my_collect_listview);
        myCollectList.setAdapter(new MyCollectAdapter(YogaMyCollectLvActivity.this));
    }
}
