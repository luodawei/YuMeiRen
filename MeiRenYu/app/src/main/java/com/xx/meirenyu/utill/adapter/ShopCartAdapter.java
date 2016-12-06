package com.xx.meirenyu.utill.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xx.meirenyu.utill.model.ShopCart;
import com.yss.yumeiren.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/5.
 */

public class ShopCartAdapter extends BaseAdapter {
    List<ShopCart> list;
    Context context;
    LayoutInflater inflater;
    boolean isCheck=true;
    LinearLayout shopCartLaout1;
    LinearLayout shopCartEdit1;
    public ShopCartAdapter(Context context,List<ShopCart> list,boolean isCheck){
        this.context=context;
        this.list=list;
        this.isCheck=isCheck;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler viewHodler;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.activity_my_shop_cart_lv_item,null);
            viewHodler=new ViewHodler();
            viewHodler.checkBox=(CheckBox)convertView.findViewById(R.id.chance_shop);
            viewHodler.shopImg=(ImageView)convertView.findViewById(R.id.shop_img);
            viewHodler.shopName=(TextView)convertView.findViewById(R.id.shop_name);
            viewHodler.shopDescroble=(TextView)convertView.findViewById(R.id.shop_size);
            viewHodler.shopPrice=(TextView)convertView.findViewById(R.id.shop_price);
            viewHodler.shopNumber=(TextView)convertView.findViewById(R.id.shop_number);
            viewHodler.changeShopNumber=(TextView)convertView.findViewById(R.id.change_shop_number);
            viewHodler.changeShopSize=(TextView)convertView.findViewById(R.id.change_shop_size);
            convertView.setTag(viewHodler);
        }
        viewHodler =(ViewHodler)convertView.getTag();
        ShopCart shopCart=list.get(position);
        viewHodler.shopImg.setImageResource(shopCart.getShopImg());
        viewHodler.shopName.setText(shopCart.getTitle());
        viewHodler.shopDescroble.setText(shopCart.getContext());
        viewHodler.shopNumber.setText("X"+shopCart.getGoodsnum());
        viewHodler.shopPrice.setText("￥:"+shopCart.getGoodsprice());
        viewHodler.changeShopNumber.setText(shopCart.getGoodsnum()+"");
        viewHodler.changeShopSize.setText(shopCart.getContext());
        viewHodler.checkBox.setChecked(shopCart.isCheckBox());
        shopCartLaout1= (LinearLayout) convertView.findViewById(R.id.shop_cart_layout);
        shopCartEdit1= (LinearLayout) convertView.findViewById(R.id.shop_cart_edit);
        if (isCheck){
            shopCartLaout1.setVisibility(View.VISIBLE);
            shopCartEdit1.setVisibility(View.GONE);
        }else{
            shopCartLaout1.setVisibility(View.GONE);
            shopCartEdit1.setVisibility(View.VISIBLE);
        }
        return convertView;
    }

    public class ViewHodler{
        CheckBox checkBox;
        ImageView shopImg;
        TextView shopName;
        TextView shopDescroble;
        TextView shopPrice;
        TextView shopNumber;
        TextView changeShopNumber;
        TextView changeShopSize;
    }
}
