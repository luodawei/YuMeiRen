package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.yss.yumeiren.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by David on 2016/10/25.
 * 我的朋友列表页面
 */

public class MyFriendsActivity extends Activity {
    List<HashMap<String,Object>> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_friends_lv);
        ListView myFriendList = (ListView)findViewById(R.id.my_friend_list);
        list=getData();
        String[] from = {"portrait","nickname","content","time","num"};
        int[] to = {R.id.portrait,R.id.friend_nickname,R.id.chat_content,R.id.chat_time,R.id.message_num};
        myFriendList.setAdapter(new SimpleAdapter(MyFriendsActivity.this,list,R.layout.my_friends_lv_item,from,to));
        myFriendList.setOnItemClickListener(onItemClickListener);
        myFriendList.setAdapter(new SimpleAdapter(MyFriendsActivity.this,list,R.layout.my_friends_lv_item,from,to));
    }
    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position){
                case 0:
                    Intent intent = new Intent(MyFriendsActivity.this,ChatPageActivity.class);
                    startActivity(intent);
                    break;
                case 1:
                    Intent intent1 = new Intent(MyFriendsActivity.this,ChatPageActivity.class);
                    startActivity(intent1);
                    break;
                case 2:
                    Intent intent2 = new Intent(MyFriendsActivity.this,ChatPageActivity.class);
                    startActivity(intent2);
                    break;
                case 3:
                    Intent intent3 = new Intent(MyFriendsActivity.this,ChatPageActivity.class);
                    startActivity(intent3);
                    break;
                case 4:
                    Intent intent4 = new Intent(MyFriendsActivity.this,ChatPageActivity.class);
                    startActivity(intent4);
                    break;
                case 5:
                    Intent intent5 = new Intent(MyFriendsActivity.this,ChatPageActivity.class);
                    startActivity(intent5);
                    break;
            }
        }
    };
    public List<HashMap<String,Object>> getData(){
        List<HashMap<String,Object>> list = new ArrayList<HashMap<String, Object>>();
        for (int i=0;i<12;i++){
            HashMap<String,Object> map = new HashMap<String,Object>();
            map.put("portrait",R.mipmap.ic_launcher);
            map.put("nickname","异域至尊");
            map.put("content","你的八块腹肌练得怎么样了？");
            map.put("time","19:12");
            map.put("num","95");
            list.add(map);
        }
        return list;
    }
}
