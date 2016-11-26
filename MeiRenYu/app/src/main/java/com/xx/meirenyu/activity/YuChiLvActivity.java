package com.xx.meirenyu.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.xx.meirenyu.utill.adapter.YuChiListViewAdapter;
import com.yss.yumeiren.R;

/**
 * Created by Administrator on 2016/11/26.
 */
public class YuChiLvActivity extends Activity {
    ImageView btnMenu;
    ListView yuChiListView;
    PopupWindow popupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yu_chi_lv);
        yuChiListView = (ListView) findViewById(R.id.yu_chi_list_view);
        btnMenu = (ImageView) findViewById(R.id.btn_menu);
        yuChiListView.setAdapter(new YuChiListViewAdapter(this));

        createPopupWindow();
        btnMenu.setOnClickListener(getOnClickListener());
    }
    public void createPopupWindow(){
        View popupView = getLayoutInflater().inflate(R.layout.yu_chi_popub_view,null);
        TextView btnHost = (TextView) popupView.findViewById(R.id.btn_only_see_host);
        TextView btnShare = (TextView) popupView.findViewById(R.id.btn_share);
        TextView btnAddToBlacklist = (TextView) popupView.findViewById(R.id.btn_add_to_blacklist);
        TextView btnReport = (TextView) popupView.findViewById(R.id.btn_report);
        btnHost.setOnClickListener(getOnClickListener());
        btnShare.setOnClickListener(getOnClickListener());
        btnAddToBlacklist.setOnClickListener(getOnClickListener());
        btnReport.setOnClickListener(getOnClickListener());
        popupWindow = new PopupWindow(popupView,300, ViewGroup.LayoutParams.WRAP_CONTENT,true);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
    }

    /**
     * 获得OnClickListener对象
     * @return
     */
    public View.OnClickListener getOnClickListener(){
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_menu:
                        popupWindow.showAsDropDown(v);
                        break;
                    case R.id.btn_only_see_host:
                        popupWindow.dismiss();
                        break;
                    case R.id.btn_share:
                        popupWindow.dismiss();
                        break;
                    case R.id.btn_add_to_blacklist:
                        creatAlertDialog();
                        popupWindow.dismiss();
                        break;
                    case R.id.btn_report:
                        popupWindow.dismiss();
                        break;
                }
            }
        };
        return onClickListener;
    }
    public void creatAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("加入黑名单");
        builder.setMessage("加入黑名单，你将不再收到对方的消息，并且你们相互看不到对方的动态及更新");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create();
        builder.show();
    }
}
