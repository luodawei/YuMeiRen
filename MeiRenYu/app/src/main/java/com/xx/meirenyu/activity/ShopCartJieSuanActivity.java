package com.xx.meirenyu.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xx.meirenyu.utill.adapter.ShopCartAdapter;
import com.xx.meirenyu.utill.model.ShopCart;
import com.yss.yumeiren.R;
import com.xx.meirenyu.utill.adapter.ShopCartAdapter.ViewHodler;
import java.util.ArrayList;
import java.util.List;

/**
 * 商城——结算页面
 * Created by Administrator on 2016/11/25.
 */
public class ShopCartJieSuanActivity extends Activity {
    ListView shopCartListView;
    List<ShopCart> list=new ArrayList<ShopCart>();
    CheckBox shopCartEdit;//编辑按钮
    CheckBox sonCheck;//item子项的选择按钮
    TextView totolPrice;//总价
    ImageView shopAdd,shopSub;
    TextView shopNumber,shopPrice,changeShopNumber;
    boolean isCheck=true;
    LayoutInflater inflater;
    View shopCartLayout;
    ShopCartAdapter shopCartAdapter;
    LinearLayout shopCartLayoutBottom,editShopLayoutBottom;
    ShopCart shopCart;
    Context context;
    List<Boolean> booleen=new ArrayList<Boolean>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shop_cart_lv);
        inflater=LayoutInflater.from(this);
        context=this;
        shopCartLayout=inflater.inflate(R.layout.activity_my_shop_cart_lv_item,null);
        shopCartEdit=(CheckBox)findViewById(R.id.shop_cart_editing);
        shopCartListView= (ListView) findViewById(R.id.shop_cart_lv);
        shopCartLayoutBottom= (LinearLayout) findViewById(R.id.shop_cart_layout_bottom);
        editShopLayoutBottom= (LinearLayout) findViewById(R.id.edit_layout_bottom);
        totolPrice= (TextView) findViewById(R.id.totol_price);
        List<ShopCart> list=getData();
        shopCartAdapter=new ShopCartAdapter(this,list,isCheck);
        shopCartListView.setAdapter(shopCartAdapter);
        shopCartEdit.setOnClickListener(onClickListener);
        shopCartListView.setOnItemClickListener(onItemClickListener);
    }
    public List<ShopCart> getData(){
      for (int i=0;i<10;i++){
          shopCart=new ShopCart();
          shopCart.setTitle("能吃的瑜伽垫");
          shopCart.setContext("国际认证安全！");
          shopCart.setGoodsnum(i);
          shopCart.setGoodsprice(50+i);
          shopCart.setCheckBox(false);
          shopCart.setShopImg(R.mipmap.tu3);
          list.add(shopCart);
      }
        return list;
    }
    ListView.OnItemClickListener onItemClickListener =new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
            shopNumber= (TextView) view.findViewById(R.id.shop_number);
            changeShopNumber= (TextView) view.findViewById(R.id.change_shop_number);
            shopAdd= (ImageView) view.findViewById(R.id.shop_add);
            shopSub=(ImageView)view.findViewById(R.id.shop_sub);
            shopCart=list.get(position);
            sonCheck= (CheckBox) view.findViewById(R.id.chance_shop);
            shopAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int num=shopCart.getGoodsnum()+1;
                    shopCart.setGoodsnum(num);
                    shopCartAdapter.notifyDataSetChanged();
                }
            });
            shopSub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(shopCart.getGoodsnum()>1){
                        int num=shopCart.getGoodsnum()-1;
                        shopCart.setGoodsnum(num);
                        shopCartAdapter.notifyDataSetChanged();
                    }else{
                        Toast.makeText(context,"不能再减了",Toast.LENGTH_SHORT).show();
                        shopCartAdapter.notifyDataSetChanged();
                    }
                }
            });

            sonCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    shopCart.setCheckBox(isChecked);
                    totolPrice.setText(tongji()+"");
                    shopCartAdapter.notifyDataSetChanged();
                    Log.i("TAG","shopCart.setCheckBox(sonCheck.isChecked());");
                }
            });
        }
    };
    //按钮点击事件
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.shop_cart_editing:
                    if (isCheck){
                        shopCartLayoutBottom.setVisibility(View.GONE);
                        editShopLayoutBottom.setVisibility(View.VISIBLE);
                        shopCartEdit.setText("完成");
                        isCheck=false;
                    }else{
                        shopCartLayoutBottom.setVisibility(View.VISIBLE);
                        editShopLayoutBottom.setVisibility(View.GONE);
                        isCheck=true;
                        shopCartEdit.setText("编辑");
                    }
                    shopCartAdapter=new ShopCartAdapter(ShopCartJieSuanActivity.this,list,isCheck);
                    shopCartListView.setAdapter(shopCartAdapter);
                    break;
            }
        }
    };
    public double tongji(){
        double mostPrice=0;
        for(ShopCart shop:list){
            if (shop.isCheckBox()){
                mostPrice+=shopCart.getGoodsprice();
            }
        }
        return mostPrice;
    }

}