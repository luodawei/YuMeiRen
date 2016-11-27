package com.xx.meirenyu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.xx.meirenyu.utill.adapter.OnlineServiceUserMessageAdapter;
import com.xx.meirenyu.utill.model.UserMessageModel;
import com.yss.yumeiren.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.content.Context;
import android.widget.TextView;
/*这个是客服聊天页面的Activity*/

/**
 * Created by Administrator on 2016/10/22.
 * 在线客服页面
 */
public class OnlineServiceActivity extends Activity {
    EditText serviceEdit;
    boolean isServicer = false;//布尔值来判断是谁发的消息
    String[] from = {"userHeadImage", "userMessage"};
    int[] to = {R.id.user_head_image, R.id.message};
    String[] dataStr = {
            "商品名称",
            "请输入关键字",
            "热门搜索",
            "初学者瑜伽服"
    };
    List<String> userMesssage=new ArrayList<String>();
    ImageView search_back_btn;
    ListView serviceMessageListView;
    OnlineServiceUserMessageAdapter onlineServiceUserMessageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_service_lv);
        search_back_btn = (ImageView) findViewById(R.id.back_btn);
        serviceEdit= (EditText) findViewById(R.id.online_service_edit);
        search_back_btn.setOnClickListener(onClickListener);
        serviceMessageListView= (ListView) findViewById(R.id.servicer_listview);
            setOnKey();

    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
         switch (v.getId()){
             case R.id.search_back_btn:
                 finish();
                 break;
         }
        }
    };
    List<UserMessageModel> list = new ArrayList<UserMessageModel>();

    public List<UserMessageModel> getMessageDate() {
        for (int i = 0; i < userMesssage.size(); i++) {
            UserMessageModel m=new UserMessageModel();
           m.setMessage(userMesssage.get(i));
            Log.i("TAG","userMesssage"+userMesssage.get(i));
            list.add(m);
            if (i > 2) {
                isServicer = true;
            }
        }
        return list;
    }
    //设置软盘方法
    public void setOnKey(){
        serviceEdit.setOnKeyListener(onKeyListener);
        serviceEdit.setImeOptions(R.mipmap.send);
        list = getMessageDate();
        onlineServiceUserMessageAdapter=new OnlineServiceUserMessageAdapter(this,list);
        serviceMessageListView.setAdapter(onlineServiceUserMessageAdapter);
    }
    View.OnKeyListener onKeyListener=new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_ENTER){
            InputMethodManager imm=(InputMethodManager)v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm.isActive()){
                    imm.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
                    Log.i("TAG","getApplicationWindowToken"+userMesssage.size());
                    String content=serviceEdit.getText().toString();
                    if (content!=null){
                        userMesssage.add(content);
                    }
                    serviceEdit.setText(null);
                    list.clear();
                    setOnKey();
                }
                return true;
            }
            return false;
        }
    };

    // 监听点击屏幕上任何位置软键盘消失
    public void CloseKeyBoard() {
        serviceEdit.clearFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(serviceEdit.getWindowToken(), 0);

    }
    // 监听点击屏幕上任何位置软键盘消失
    public boolean onTouchEvent(MotionEvent event) {
        CloseKeyBoard();
        return super.onTouchEvent(event);
    }
}
