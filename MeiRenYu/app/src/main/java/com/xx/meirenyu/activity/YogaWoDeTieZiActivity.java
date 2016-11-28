package com.xx.meirenyu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xx.meirenyu.utill.adapter.CallMeListAdapter;
import com.xx.meirenyu.utill.adapter.MyPostListAdapter;
import com.xx.meirenyu.utill.adapter.RespondListAdapter;
import com.yss.yumeiren.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */
public class YogaWoDeTieZiActivity extends Activity {
    TextView btnMyPost;
    TextView btnCallMe;
    TextView btnRespond;

    List<View> pagerViewList;
    ViewPager tieziViewPager;
    PagerAdapter tieziPagerAdapter;
    View myPostPager;
    View callMePager;
    View respondPager;
    ImageView back_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_wodetiezi);
        tieziViewPager = (ViewPager) findViewById(R.id.my_post_view_pager);
        btnMyPost = (TextView) findViewById(R.id.btn_my_post);
        btnCallMe = (TextView) findViewById(R.id.btn_call_me);
        btnRespond = (TextView) findViewById(R.id.btn_respond);
        back_btn = (ImageView) findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setListViewItem();
        getData();
        tieziPagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return pagerViewList.size();
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = pagerViewList.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(pagerViewList.get(position));
            }
        };
        tieziViewPager.setAdapter(tieziPagerAdapter);
        tieziViewPager.addOnPageChangeListener(getOnPageChangeListener());
        btnMyPost.setOnClickListener(getOnClickListener());
        btnCallMe.setOnClickListener(getOnClickListener());
        btnRespond.setOnClickListener(getOnClickListener());
    }
    public ViewPager.OnPageChangeListener getOnPageChangeListener(){
        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetBtn();
                switch (position){
                    case 0:
                        btnMyPost.setTextColor(getResources().getColor(R.color.meirenyu_bg_green));
                        break;
                    case 1:
                        btnCallMe.setTextColor(getResources().getColor(R.color.meirenyu_bg_green));
                        break;
                    case 2:
                        btnRespond.setTextColor(getResources().getColor(R.color.meirenyu_bg_green));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
        return onPageChangeListener;
    }
    public View.OnClickListener getOnClickListener(){
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBtn();
                switch (v.getId()){
                    case R.id.btn_my_post:
                        btnMyPost.setTextColor(getResources().getColor(R.color.meirenyu_bg_green));
                        tieziViewPager.setCurrentItem(0);
                        break;
                    case R.id.btn_call_me:
                        btnCallMe.setTextColor(getResources().getColor(R.color.meirenyu_bg_green));
                        tieziViewPager.setCurrentItem(1);
                        break;
                    case R.id.btn_respond:
                        btnRespond.setTextColor(getResources().getColor(R.color.meirenyu_bg_green));
                        tieziViewPager.setCurrentItem(2);
                        break;
                }
            }
        };
        return onClickListener;
    }

    /**
     * 将所有按钮颜色设置为黑色
     */
    public void resetBtn(){
        btnMyPost.setTextColor(getResources().getColor(R.color.black));
        btnCallMe.setTextColor(getResources().getColor(R.color.black));
        btnRespond.setTextColor(getResources().getColor(R.color.black));
    }

    /**
     * 为ListView设置item
     */
    public void setListViewItem(){
        LayoutInflater inflater = LayoutInflater.from(this);
        myPostPager = inflater.inflate(R.layout.my_post_pager,null);
        ListView myPostList = (ListView) myPostPager.findViewById(R.id.my_post_list);
        myPostList.setAdapter(new MyPostListAdapter(YogaWoDeTieZiActivity.this));

        callMePager = inflater.inflate(R.layout.call_me_pager,null);
        ListView callMeList = (ListView) callMePager.findViewById(R.id.call_me_list);
        callMeList.setAdapter(new CallMeListAdapter(YogaWoDeTieZiActivity.this));

        respondPager = inflater.inflate(R.layout.respond_pager,null);
        ListView respondList = (ListView) respondPager.findViewById(R.id.respond_list);
        respondList.setAdapter(new RespondListAdapter(YogaWoDeTieZiActivity.this));
    }

    public void getData(){
        pagerViewList = new ArrayList<View>();
        pagerViewList.add(myPostPager);
        pagerViewList.add(callMePager);
        pagerViewList.add(respondPager);
    }

}
