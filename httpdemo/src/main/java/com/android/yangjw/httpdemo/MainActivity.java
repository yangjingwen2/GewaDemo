package com.android.yangjw.httpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.x;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        x.view().inject(this);
    }


    public void click(View view) {
        Log.d("demo","-------------------");
//        RequestParams requestParams = new RequestParams("http://apicn.seashellmall.com/product/topics");
//        RequestParams requestParams = new RequestParams("https://www.baidu.com");
//        RequestParams requestParams = new RequestParams("http://hhc-api.vip.com/ad/get_ads_by_user_type?apiKey=e0f3d0be6fb24a6eab244525d8b1537f&appName=huahaicang_android&areaid=1001&channel=MobileAds%3Acbadb924%3A4a6af458&client=android&is_preload=0&marsCid=602ac6c4-c9f3-3b99-af92-480e817a3af8&resolution=768x1184&service_provider=CUCC&timestamp=1456212121&userTag=HHC-A&version=1.6.0&warehouse=VIP_HZ&zoneId=729");
        /*城市定位选择*/
//        RequestParams requestParams = new RequestParams("http://hhc-api.vip.com/neptune/common/area_warehouse/v1?apiKey=e0f3d0be6fb24a6eab244525d8b1537f&marsCid=602ac6c4-c9f3-3b99-af92-480e817a3af8&timestamp=1456217444");
//        requestParams.addHeader("Authorization","OAuth apiSign=11fb8158facb2dcabed3a1b90c66c5cfc1a2e22c");
        /*首页banner*/
//        RequestParams requestParams = new RequestParams("http://hhc-api.vip.com/ad/get_ads_by_user_type?apiKey=e0f3d0be6fb24a6eab244525d8b1537f&appName=huahaicang_android&areaid=1001&channel=MobileAds%3Acbadb924%3A4a6af458&client=android&is_preload=0&marsCid=602ac6c4-c9f3-3b99-af92-480e817a3af8&resolution=768x1184&service_provider=CUCC&timestamp=1456218078&userTag=HHC-A&version=1.6.0&warehouse=VIP_HZ&zoneId=575");
//        requestParams.addHeader("Authorization","OAuth apiSign=60d6165220d8151febb8adb3a0964be3ea7e79f6");
        /*Banner下方的3个*/
//        RequestParams requestParams = new RequestParams("http://hhc-api.vip.com/ad/get_ads_by_user_type?apiKey=e0f3d0be6fb24a6eab244525d8b1537f&appName=huahaicang_android&areaid=1001&channel=MobileAds%3Acbadb924%3A4a6af458&client=android&is_preload=0&marsCid=602ac6c4-c9f3-3b99-af92-480e817a3af8&resolution=768x1184&service_provider=CUCC&timestamp=1456218078&userTag=HHC-A&version=1.6.0&warehouse=VIP_HZ&zoneId=577");
//        requestParams.addHeader("Authorization","OAuth apiSign=383ea759d653e1cea224d105395aaa4d87d2aa00");

        /*早场和晚场*/
//        RequestParams requestParams = new RequestParams("http://hhc-api.vip.com/ad/get_ads_by_user_type?apiKey=e0f3d0be6fb24a6eab244525d8b1537f&appName=huahaicang_android&areaid=1001&channel=MobileAds%3Acbadb924%3A4a6af458&client=android&is_preload=0&marsCid=602ac6c4-c9f3-3b99-af92-480e817a3af8&resolution=768x1184&service_provider=CUCC&timestamp=1456218078&userTag=HHC-A&version=1.6.0&warehouse=VIP_HZ&zoneId=578");
//        requestParams.addHeader("Authorization","OAuth apiSign=05d3adbb6cb5cf3fa31064b5c21e0cd721530325");

        /*列表一*/
//        RequestParams requestParams = new RequestParams("http://hhc-api.vip.com/ad/get_ads_by_user_type?apiKey=e0f3d0be6fb24a6eab244525d8b1537f&appName=huahaicang_android&areaid=1001&channel=MobileAds%3Acbadb924%3A4a6af458&client=android&is_preload=0&marsCid=602ac6c4-c9f3-3b99-af92-480e817a3af8&resolution=768x1184&service_provider=CUCC&timestamp=1456218078&userTag=HHC-A&version=1.6.0&warehouse=VIP_HZ&zoneId=579");
//        requestParams.addHeader("Authorization","OAuth apiSign=710c5e471f8b1003e01038520cbaf581df5022a6");
        /*极有好货和大牌闪购的标题*/
//        RequestParams requestParams = new RequestParams("http://hhc-api.vip.com/ad/get_ads_by_user_type?apiKey=e0f3d0be6fb24a6eab244525d8b1537f&appName=huahaicang_android&areaid=1001&channel=MobileAds%3Acbadb924%3A4a6af458&client=android&is_preload=0&marsCid=602ac6c4-c9f3-3b99-af92-480e817a3af8&resolution=768x1184&service_provider=CUCC&timestamp=1456218078&userTag=HHC-A&version=1.6.0&warehouse=VIP_HZ&zoneId=580");
//        requestParams.addHeader("Authorization","OAuth apiSign=656f3c118250fcdbca60d18de8787fc99e09a3e8");
        /*既有好货内容*/
        RequestParams requestParams = new RequestParams("http://hhc-api.vip.com/ad/get_ads_by_user_type?apiKey=e0f3d0be6fb24a6eab244525d8b1537f&appName=huahaicang_android&areaid=1001&channel=MobileAds%3Acbadb924%3A4a6af458&client=android&is_preload=0&marsCid=602ac6c4-c9f3-3b99-af92-480e817a3af8&resolution=768x1184&service_provider=CUCC&timestamp=1456367347&userTag=HHC-A&version=1.6.0&warehouse=VIP_HZ&zoneId=582");
        requestParams.addHeader("Authorization","OAuth apiSign=86a746cf596ea7648b37e35482ef2339ede6b901");
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("demo", "onSuccess---->>>>" + result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.d("demo", "onError---->>>>" + ex.getMessage());
                ex.printStackTrace();
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.d("demo", "onCancelled---->>>>");
            }

            @Override
            public void onFinished() {
                Log.d("demo", "onFinished---->>>>");
            }
        });

    }
}
