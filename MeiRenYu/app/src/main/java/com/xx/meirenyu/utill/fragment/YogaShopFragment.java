package com.xx.meirenyu.utill.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.xx.meirenyu.activity.GoodsSearchActivity;
import com.xx.meirenyu.activity.MyOrderActivity;
import com.xx.meirenyu.activity.OnlineServiceActivity;
import com.xx.meirenyu.activity.ShopCartJieSuanActivity;
import com.xx.meirenyu.activity.YogaClothesActivity;
import com.xx.meirenyu.activity.YogaCushionActivity;
import com.xx.meirenyu.activity.YogaHomeActivity;
import com.xx.meirenyu.activity.YogaOtherShopActivity;
import com.xx.meirenyu.utill.adapter.YogaShowGridViewAdapter;
import com.xx.meirenyu.utill.model.YogaShopGridViewModel;
import com.yss.yumeiren.R;

import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/26.
 */
public class YogaShopFragment extends Fragment {
    Activity myActivity;
    ImageView shop_cart;
    ImageView online_service;
    View view;
    TextView shopEdit;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    ArrayList<ImageView> list=new ArrayList<ImageView>();
    ViewPager viewPager;
    int [] img={R.mipmap.tu1,R.mipmap.tu5,R.mipmap.tu3,R.mipmap.tu2};
    RadioGroup radioGroup;
    List<RadioButton> buttonList=new ArrayList<RadioButton>();
    public AMapLocationClient mLocationClient=null;
    //声明定位监听
    public AMapLocationClientOption mapLocationClientOption=null;
   // GridView gridView;
    //List<YogaShopGridViewModel> list=new ArrayList<YogaShopGridViewModel>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setGridView();

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myActivity = getActivity();
        view = inflater.inflate(R.layout.fragment_yoga_shop,null);
        shop_cart = (ImageView) view.findViewById(R.id.shop_cart);
        online_service = (ImageView) view.findViewById(R.id.online_service);
        textView1= (TextView) view.findViewById(R.id.textView1);
        textView2= (TextView) view.findViewById(R.id.textView2);
        textView3= (TextView) view.findViewById(R.id.textView3);
        shopEdit= (TextView) view.findViewById(R.id.shop_edit);
        viewPager= (ViewPager) view.findViewById(R.id.shop_view_viewpager);
        radioGroup= (RadioGroup) view.findViewById(R.id.shop_img_radio);
        List<ImageView> list=data();
        createRadioButton();
        radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
        shop_cart.setOnClickListener(onClickListener);
        online_service.setOnClickListener(onClickListener);
        textView1.setOnClickListener(onClickListener);
        textView2.setOnClickListener(onClickListener);
        textView3.setOnClickListener(onClickListener);
        shopEdit.setOnClickListener(onClickListener);
        viewPager.setAdapter(new myPagerAdapter(myActivity,list));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
            buttonList.get(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;

        }
    public List<ImageView> data(){
    for (int i=0;i<img.length;i++){
        ImageView imageView=new ImageView(myActivity);
        ViewGroup.LayoutParams layoutParams=new ViewGroup.LayoutParams(1,1);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(img[i]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        list.add(imageView);
        }
    return list;
    }

    public void createRadioButton(){
        for (int i=0;i<img.length;i++){
            RadioButton radioButton=new RadioButton(myActivity);
            RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(20,20);
            layoutParams.setMargins(10,0,10,0);
            if (i==0){
                radioButton.setChecked(true);
            }
            radioButton.setLayoutParams(layoutParams);
            radioButton.setButtonDrawable(null);
            radioButton.setBackgroundResource(R.drawable.shop_viewpager_btn);
            radioButton.setId(i);
            radioGroup.addView(radioButton);
            buttonList.add(radioButton);
        }
    }
    RadioGroup.OnCheckedChangeListener onCheckedChangeListener=new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
              viewPager.setCurrentItem(checkedId);
        }
    };
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()) {
                case R.id.shop_cart:
                    intent = new Intent(myActivity, ShopCartJieSuanActivity.class);
                    startActivity(intent);
                    break;
                case R.id.online_service:
                    intent = new Intent(myActivity, OnlineServiceActivity.class);
                    startActivity(intent);
                    break;
                case R.id.textView1:
                    intent = new Intent(myActivity,YogaCushionActivity.class);
                    intent.putExtra("yoga_type",textView1.getText().toString());
                    startActivity(intent);
                    break;
                case R.id.textView2:
                    intent = new Intent(myActivity,YogaCushionActivity.class);
                    intent.putExtra("yoga_type",textView2.getText().toString());
                    startActivity(intent);
                    break;
                case R.id.textView3:
                    intent = new Intent(myActivity,YogaCushionActivity.class);
                    intent.putExtra("yoga_type",textView3.getText().toString());
                    startActivity(intent);
                    break;
                case R.id.shop_edit:
                    intent=new Intent(myActivity, GoodsSearchActivity.class);
                    startActivity(intent);
                    break;

            }
        }
    };
    class myPagerAdapter extends PagerAdapter{
        List<ImageView> list;
        Context context;
        public myPagerAdapter(Context context,List<ImageView> list){
            this.context=context;
            this.list=list;
        }
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
        @Override
        public void destroyItem(ViewGroup container, int position,
                                Object object) {
            ((ViewPager) container).removeView(list.get(position));
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            //对ViewPager页号求模取出View列表中要显示的项
            position %= list.size();
            if (position<0){
                position = list.size()+position;
            }
            ImageView view = list.get(position);
            //如果View已经在之前添加到了一个父组件，则必须先remove，否则会抛出IllegalStateException。
            ViewParent vp =view.getParent();
            if (vp!=null){
                ViewGroup parent = (ViewGroup)vp;
                parent.removeView(view);
            }
            container.addView(view);
            //add listeners here if necessary
            return view;
        }
    }

}
