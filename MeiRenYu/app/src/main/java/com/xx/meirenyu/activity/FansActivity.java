package com.xx.meirenyu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import com.xx.meirenyu.utill.adapter.FansListViewAdapter;
import com.xx.meirenyu.utill.model.FansItemModel;
import com.yss.yumeiren.R;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Administrator on 2016/11/26.
 */

public class FansActivity extends Activity{
    ImageView backBtn;
    ListView fansListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fans_lv);
        backBtn= (ImageView) findViewById(R.id.back_btn);
        fansListView= (ListView) findViewById(R.id.fans_lv);
        List<FansItemModel> list=getFansData();
        FansListViewAdapter fansListViewAdapter=new FansListViewAdapter(this,list);
        fansListView.setAdapter(fansListViewAdapter);
    }
    List<FansItemModel> list=new ArrayList<FansItemModel>();
    //获取数据
    public List<FansItemModel> getFansData(){
        for (int i=0;i<10;i++){
            FansItemModel fansModel=new FansItemModel();
            fansModel.setMessageNumber(i);
            //设置消息显示
            if (fansModel.getMessageNumber()>0){
                fansModel.setHaveMesage(true);
            }
            fansModel.setUserImg(R.id.friend_nickname);
            fansModel.setUserName("海绵宝宝"+i);
            if (i>5){
                //设置性别女
                fansModel.setSsex(false);
            }else {
                //设置性别男
                fansModel.setSsex(true);
            }
            fansModel.setUserQianMing("我用技术，我为我自己带盐"+i);
            list.add(fansModel);
        }
        return list;
    }
}
