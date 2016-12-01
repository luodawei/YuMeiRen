package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.xx.meirenyu.utill.adapter.YogaCushionAdapter;
import com.xx.meirenyu.utill.model.YogaCushionModel;
import com.yss.yumeiren.R;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Administrator on 2016/11/27.
 */
public class YogaCushionActivity extends Activity {
    ImageView fanhui2;
    ListView yogaCushionListview;
    TextView yogaName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_cushion);
        fanhui2 = (ImageView) findViewById(R.id.fanhui2);
        yogaName= (TextView) findViewById(R.id.yoga_name);
        setYogaName();
        yogaCushionListview= (ListView) findViewById(R.id.yoga_cushion_listview);
        List<YogaCushionModel> list=getData();
        YogaCushionAdapter adapter=new YogaCushionAdapter(this,list);
        yogaCushionListview.setAdapter(adapter);
        yogaCushionListview.setOnItemClickListener(onItemClickListener);
        fanhui2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    List<YogaCushionModel> list=new ArrayList<YogaCushionModel>();
    public List<YogaCushionModel> getData(){
        for (int i=0;i<10;i++){
            YogaCushionModel yogaCushionModel=new YogaCushionModel();
            yogaCushionModel.setImg(R.mipmap.tu1);
            yogaCushionModel.setImg0(R.mipmap.tu3);
            yogaCushionModel.setYogaCushionPrice("200"+i+"$");
            yogaCushionModel.setYogaCushionPrice0("200"+i+"$");
            yogaCushionModel.setYogaCushionTile("专业瑜伽垫");
            yogaCushionModel.setYogaCushionTile0("专业瑜伽垫");
            list.add(yogaCushionModel);
        }
        return list;
    }
    ListView.OnItemClickListener onItemClickListener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            RelativeLayout v1= (RelativeLayout) view.findViewById(R.id.yoga_cushion_v1);
            v1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(YogaCushionActivity.this,GoodsDetailaActivity.class);
                    startActivity(intent);
                    Toast.makeText(YogaCushionActivity.this,"点击了V1",Toast.LENGTH_SHORT).show();
                }
            });
            RelativeLayout v2= (RelativeLayout) view.findViewById(R.id.yoga_cushion_v2);
            v2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(YogaCushionActivity.this,GoodsDetailaActivity.class);
                    startActivity(intent);
                    Toast.makeText(YogaCushionActivity.this,"点击了V2",Toast.LENGTH_SHORT).show();
                }
            });
        }
    };
    public void setYogaName(){
        Intent intent=getIntent();
        String name=intent.getStringExtra("yoga_type");
        yogaName.setText(name);
    }
}
