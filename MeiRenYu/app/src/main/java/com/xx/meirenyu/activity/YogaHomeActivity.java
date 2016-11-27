package com.xx.meirenyu.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.xx.meirenyu.utill.fragment.MineFragment;
import com.xx.meirenyu.utill.fragment.YogaShopFragment;
import com.xx.meirenyu.utill.fragment.YuChiFragment;
import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/11/26.
 */
public class YogaHomeActivity extends Activity {
    Fragment yogaShopFragment;
    Fragment yuChiFragment;
    Fragment mineFragment;
    FragmentManager manager;
    FrameLayout yogaHomeContent;
    RadioGroup yogaHome;

    RadioButton thePool;
    RadioButton theShop;
    RadioButton theMine;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_home);
        yogaHome = (RadioGroup) findViewById(R.id.yoga_home_radio_group);
        yogaHomeContent = (FrameLayout) findViewById(R.id.yoga_home_content);
        manager = getFragmentManager();
        setFragment(1);
        yogaHome.setOnCheckedChangeListener(getOnCheckedChangeListener());
        thePool = (RadioButton) findViewById(R.id.the_pool);
        theShop = (RadioButton) findViewById(R.id.the_shop);
        theMine = (RadioButton) findViewById(R.id.the_mine);
    }
    public RadioGroup.OnCheckedChangeListener getOnCheckedChangeListener(){
        RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                resetBtnState();
                switch (checkedId){
                    case R.id.the_pool:
                        thePool.setTextColor(getResources().getColor(R.color.main_blue));
                        thePool.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.the_pool_green,0,0);
                        setFragment(0);
                        break;
                    case R.id.the_shop:
                        theShop.setTextColor(getResources().getColor(R.color.main_blue));
                        theShop.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.shop_green,0,0);
                        setFragment(1);
                        break;
                    case R.id.the_mine:
                        theMine.setTextColor(getResources().getColor(R.color.main_blue));
                        theMine.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.wode_green,0,0);
                        setFragment(2);
                        break;
                }
            }
        };
        return onCheckedChangeListener;
    }
    public void hideFragment(FragmentTransaction fragmentTransaction){
        if (yuChiFragment != null){
            fragmentTransaction.hide(yuChiFragment);
        }
        if (yogaShopFragment != null){
            fragmentTransaction.hide(yogaShopFragment);
        }
        if (mineFragment != null){
            fragmentTransaction.hide(mineFragment);
        }
    }
    public void setFragment(int index){
        FragmentTransaction transaction = manager.beginTransaction();
        hideFragment(transaction);
        switch (index){
            case 0:
                if (yuChiFragment == null){
                    yuChiFragment = new YuChiFragment();
                    transaction.add(R.id.yoga_home_content,yuChiFragment);
                }else {
                    transaction.show(yuChiFragment);
                }
                break;
            case 1:
                if (yogaShopFragment == null){
                    yogaShopFragment = new YogaShopFragment();
                    transaction.add(R.id.yoga_home_content,yogaShopFragment);
                }else {
                    transaction.show(yogaShopFragment);
                }
                break;
            case 2:
                if (mineFragment == null){
                    mineFragment = new MineFragment();
                    transaction.add(R.id.yoga_home_content,mineFragment);
                }else {
                    transaction.show(mineFragment);
                }
                break;
        }
        transaction.commit();
    }
    public void resetBtnState(){
        thePool.setTextColor(getResources().getColor(R.color.textcolor));
        theShop.setTextColor(getResources().getColor(R.color.textcolor));
        theMine.setTextColor(getResources().getColor(R.color.textcolor));

        thePool.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.thepool,0,0);
        theShop.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.shop,0,0);
        theMine.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.wode,0,0);
    }
}
