package com.bwie.newstitle.httprequest;
//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                           O\  =  /O
//                        ____/`---'\____
//                      .'  \\|     |//  `.
//                     /  \\|||  :  |||//  \
//                    /  _||||| -:- |||||-  \
//                    |   | \\\  -  /// |   |
//                    | \_|  ''\---/''  |   |
//                    \  .-\__  `-`  ___/-. /
//                  ___`. .'  /--.--\  `. . __
//               ."" '<  `.___\_<|>_/___.'  >'"".
//              | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//              \  \ `-.   \_ __\ /__ _/   .-` /  /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//                      佛祖保佑       永无BUG


import android.content.Context;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.bwie.newstitle.imageloader.MyImageLoader;

public class HttpGetData {

    private static StringRequest sStringRequest;

    public static void RequestGet(Context context, String path, String tag, VolleyInterface vif) {
        //防止重复请求
       // MyImageLoader.getHttpQueue().cancelAll(tag);
        sStringRequest = new StringRequest(Request.Method.GET, path, vif.loadingListener(), vif.errorListener());
       // sStringRequest.setTag(tag);
        MyImageLoader.getHttpQueue().add(sStringRequest);
        MyImageLoader.getHttpQueue().start();
    }

}
