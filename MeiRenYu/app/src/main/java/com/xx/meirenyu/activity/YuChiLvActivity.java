package com.xx.meirenyu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.xx.meirenyu.utill.adapter.YuChiListViewAdapter;
import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/11/26.
 */
public class YuChiLvActivity extends Activity {

    ListView yuChiListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yu_chi_lv);
        yuChiListView = (ListView) findViewById(R.id.yu_chi_list_view);
        yuChiListView.setAdapter(new YuChiListViewAdapter(this));
    }
}
