package com.xx.meirenyu.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.xx.meirenyu.utill.fragment.MyOrderAllFragement;
import com.xx.meirenyu.utill.fragment.MyOrderObligationFragement;
import com.xx.meirenyu.utill.fragment.MyOrderReceiveGoodsFragement;
import com.xx.meirenyu.utill.fragment.MyOrderSendGoodsFragment;
import com.yss.yumeiren.R;

/**
 * 商城——我的订单
 * Created by Administrator on 2016/11/25.
 */
public class MyOrderActivity extends Activity {
    ImageView fanhui;
    RadioButton quanbu;
    RadioButton daifukuan;
    RadioButton daifahuo;
    RadioButton daishouhuo;
    RadioGroup radioGroup;
    View quanbu_view;
    View daifukuan_view;
    View daifahuo_view;
    View daishouhuo_view;
    FragmentManager manager;
    MyOrderAllFragement myorderallFragement;
    MyOrderObligationFragement myorderobligationFragement;
    MyOrderSendGoodsFragment myordersendgoodsFragement;
    MyOrderReceiveGoodsFragement myorderreceivegoodsFragement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        fanhui = (ImageView) findViewById(R.id.fanhui);
        quanbu = (RadioButton) findViewById(R.id.quanbu);
        daifukuan = (RadioButton) findViewById(R.id.daifukuan);
        daifahuo = (RadioButton) findViewById(R.id.daifahuo);
        daishouhuo = (RadioButton) findViewById(R.id.daishouhuo);
        radioGroup = (RadioGroup) findViewById(R.id.myorder_radiogroup);
        quanbu_view = findViewById(R.id.quanbu_view);
        daifukuan_view = findViewById(R.id.daifukuan_view);
        daifahuo_view = findViewById(R.id.daifahuo_view);
        daishouhuo_view = findViewById(R.id.daishouhuo_view);
        manager = getFragmentManager();
        setFragment(0);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);


    }

    RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.quanbu:
                    quanbu_view.setVisibility(View.VISIBLE);
                    daifukuan_view.setVisibility(View.INVISIBLE);
                    daifahuo_view.setVisibility(View.INVISIBLE);
                    daishouhuo_view.setVisibility(View.INVISIBLE);
                    setFragment(0);
                    break;
                case R.id.daifukuan:
                    quanbu_view.setVisibility(View.INVISIBLE);
                    daifukuan_view.setVisibility(View.VISIBLE);
                    daifahuo_view.setVisibility(View.INVISIBLE);
                    daishouhuo_view.setVisibility(View.INVISIBLE);
                    setFragment(1);
                    break;
                case R.id.daifahuo:
                    quanbu_view.setVisibility(View.INVISIBLE);
                    daifukuan_view.setVisibility(View.INVISIBLE);
                    daifahuo_view.setVisibility(View.VISIBLE);
                    daishouhuo_view.setVisibility(View.INVISIBLE);
                    setFragment(2);
                    break;
                case R.id.daishouhuo:
                    quanbu_view.setVisibility(View.INVISIBLE);
                    daifukuan_view.setVisibility(View.INVISIBLE);
                    daifahuo_view.setVisibility(View.INVISIBLE);
                    daishouhuo_view.setVisibility(View.VISIBLE);
                    setFragment(3);
                    break;

            }
        }

    };

    public void hideFragment(FragmentTransaction fragmentTransaction) {
        if (myorderallFragement != null) {
            fragmentTransaction.hide(myorderallFragement);
        }
        if (myorderobligationFragement != null) {
            fragmentTransaction.hide(myorderobligationFragement);
        }
        if (myordersendgoodsFragement != null) {
            fragmentTransaction.hide(myordersendgoodsFragement);
        }
        if (myorderreceivegoodsFragement != null) {
            fragmentTransaction.hide(myorderreceivegoodsFragement);
        }
    }

    public void setFragment(int index) {
        FragmentTransaction transaction = manager.beginTransaction();
        hideFragment(transaction);
        switch (index) {
            case 0:
                if (myorderallFragement == null) {
                    myorderallFragement = new MyOrderAllFragement();
                    transaction.add(R.id.my_order_fragement, myorderallFragement);
                } else {
                    transaction.show(myorderallFragement);
                }
                break;
            case 1:
                if (myorderobligationFragement == null) {
                    myorderobligationFragement = new MyOrderObligationFragement();
                    transaction.add(R.id.my_order_fragement, myorderobligationFragement);
                } else {
                    transaction.show(myorderobligationFragement);
                }
                break;
            case 2:
                if (myordersendgoodsFragement == null) {
                    myordersendgoodsFragement = new MyOrderSendGoodsFragment();
                    transaction.add(R.id.my_order_fragement, myordersendgoodsFragement);
                } else {
                    transaction.show(myordersendgoodsFragement);
                }
                break;
            case 3:
                if (myorderreceivegoodsFragement == null) {
                    myorderreceivegoodsFragement = new MyOrderReceiveGoodsFragement();
                    transaction.add(R.id.my_order_fragement, myorderreceivegoodsFragement);
                } else {
                    transaction.show(myorderreceivegoodsFragement);
                }
                break;
        }
        transaction.commit();
    }
}

