package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yss.yumeiren.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/18.
 */
public class GoodsSearchActivity extends Activity {
    private TextView searchHotBtn;//热门搜索按钮
    private TextView searchHistoryBtn;//历史搜索切换按钮
    private LinearLayout hotSearchCaiDan;//热门搜索菜单框
    private LinearLayout historySearchCaiDan;//历史搜索菜单框
    private EditText searchEditText;//搜索框
    private LinearLayout historyMenuLayout;//添加历史搜索菜单页面
    private ArrayList<String> historyMenuArrarList;//存放输入框输入内容的集合
    private LinearLayout editLayoutFocusable;//搜索栏父控件，用于多去输入框焦点
    private int historyNumber=1;
    private String str;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_search);
        context=this;
        /*初始化*/
        searchHotBtn= (TextView) findViewById(R.id.search_hot);
        searchHistoryBtn= (TextView) findViewById(R.id.search_history);
        hotSearchCaiDan= (LinearLayout) findViewById(R.id.hot_search_caidan);
        historySearchCaiDan= (LinearLayout) findViewById(R.id.history_search_caidan);
        searchEditText= (EditText) findViewById(R.id.search_edit_text);
        historyMenuLayout= (LinearLayout) findViewById(R.id.history_menu_layout);

        historyMenuArrarList=new ArrayList<String>();
        str=searchEditText.getText().toString();
        historyMenuArrarList.add(str);
        //设置监听
        searchHotBtn.setOnClickListener(onClickListener);
        searchHistoryBtn.setOnClickListener(onClickListener);
    }
    //创建Textview的方法，用来显示输入框输入过的内容
    public void createSearchMenu(){
        for(int i=0;i<historyMenuArrarList.size();i++){
            TextView historyMenuText=new TextView(this);
            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            layoutParams.setMargins(0,15,0,0);
            historyMenuText.setPadding(10,8,10,8);
            historyMenuText.setLayoutParams(layoutParams);
            historyMenuText.setText(historyMenuArrarList.get(i));
            historyMenuText.setGravity(Gravity.CENTER);
            historyMenuText.setBackgroundResource(R.drawable.search_tishi_style);
            historyMenuText.setTextColor(getResources().getColor(R.color.white));
            historyMenuText.setTextSize(15);
            historyMenuLayout.addView(historyMenuText);
        }
    }

    //点击监听事件
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_hot:
                /*点击切换热门搜索菜单框*/
                searchHotBtn.setBackgroundColor(getResources().getColor(R.color.head_green));
                hotSearchCaiDan.setVisibility(View.VISIBLE);
                searchHistoryBtn.setBackgroundColor(getResources().getColor(R.color.search_bar_false_bg));
                historySearchCaiDan.setVisibility(View.GONE);
                break;
            case R.id.search_history:
                /*点击切换历史搜索菜单框*/
                searchHotBtn.setBackgroundColor(getResources().getColor(R.color.search_bar_false_bg));
                hotSearchCaiDan.setVisibility(View.GONE);
                searchHistoryBtn.setBackgroundColor(getResources().getColor(R.color.head_green));
                historySearchCaiDan.setVisibility(View.VISIBLE);
                break;
        }
        }
    };
}
