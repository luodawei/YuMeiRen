package com.xx.meirenyu.activity;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.yss.yumeiren.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GaoDeActivity extends Activity {
    //声明AMapLocationClient类对象
    Context context;
    TextView code,location,sh1;
    public AMapLocationClient mLocationClient=null;
    //声明定位监听
    public AMapLocationClientOption mapLocationClientOption=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gao_de);
        context=getApplicationContext();
        code= (TextView) findViewById(R.id.request_code);
        location= (TextView) findViewById(R.id.location);
        sh1= (TextView) findViewById(R.id.sh1);
        sh1.setText(sHA1(context));
        Log.i("SHA1",sHA1(context));
        location();
    }
    public AMapLocationListener mapLocationListener=new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (aMapLocation !=null){
                if (aMapLocation.getErrorCode() == 0){
                    //解析类容
                    aMapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                    aMapLocation.getLatitude();//获取纬度
                    aMapLocation.getLongitude();//获取经度
                    aMapLocation.getAccuracy();//获取精度信息
                    aMapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                    aMapLocation.getCountry();//国家信息
                    aMapLocation.getProvince();//省信息
                    aMapLocation.getCity();//城市信息
                    aMapLocation.getDistrict();//城区信息
                    aMapLocation.getStreet();//街道信息
                    aMapLocation.getStreetNum();//街道门牌号信息
                    aMapLocation.getCityCode();//城市编码
                    aMapLocation.getAdCode();//地区编码
                    aMapLocation.getAoiName();//获取当前定位点的AOI信息
                    // 获取定位时间
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = new Date(aMapLocation.getTime());
                    df.format(date);
                    location.setText(""+"获取纬度"+ aMapLocation.getLatitude()+"\n获取经度"+aMapLocation.getLongitude()
                    +"位置："+aMapLocation.getCountry()+aMapLocation.getProvince()+aMapLocation.getProvince()+
                            aMapLocation.getCity()+aMapLocation.getDistrict()+aMapLocation.getStreet()+aMapLocation.getStreetNum()+
                    "获取当前定位点的AOI信息"+ aMapLocation.getAoiName());
                }else {
                    //定位失败打印返回信息
                    code.setText("AmapError"+"location Error, ErrCode:" +aMapLocation.getErrorCode() + ",\n errInfo:" +aMapLocation.getErrorInfo());
                }
            }
        }
    };
    public void location(){
        mLocationClient=new AMapLocationClient(context);
        mapLocationClientOption=new AMapLocationClientOption();
        mLocationClient.setLocationListener(mapLocationListener);
        mapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);//高精度定位
        mapLocationClientOption.setInterval(2000);
        mapLocationClientOption.setNeedAddress(true);//设置连续请求时间间隔
        mapLocationClientOption.setHttpTimeOut(2000);//设置网络请求超时时间
        mLocationClient.setLocationOption(mapLocationClientOption);
        mLocationClient.startLocation();//启动定位
    }

    public String sHA1(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), PackageManager.GET_SIGNATURES);
            byte[] cert = info.signatures[0].toByteArray();
            MessageDigest md = MessageDigest.getInstance("SHA1");
            byte[] publicKey = md.digest(cert);
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < publicKey.length; i++) {
                String appendString = Integer.toHexString(0xFF & publicKey[i])
                        .toUpperCase(Locale.US);
                if (appendString.length() == 1)
                    hexString.append("0");
                hexString.append(appendString);
                hexString.append(":");
            }
           String redult=hexString.toString();
            return redult.substring(0, redult.length()-1);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
