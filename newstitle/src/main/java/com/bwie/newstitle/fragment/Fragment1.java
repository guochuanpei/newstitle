package com.bwie.newstitle.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.bwie.newstitle.R;
import com.bwie.newstitle.adapter.MyFragmentstatePageAdapter;
import com.bwie.newstitle.bean.MyTitle;
import com.bwie.newstitle.httprequest.HttpGetData;
import com.bwie.newstitle.httprequest.VolleyInterface;
import com.bwie.newstitle.utils.Utils;
import com.bwie.newstitle.wxapi.Main3Activity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

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


public class Fragment1 extends Fragment {
    private static final String TAG = "Fragment1";
    private View view;
    private TabLayout f1_tab;
    private ViewPager f1_vp;
    private List<Fragment> list = new ArrayList<>();
    private Gson mGson;
    public static List<MyTitle.DataBeanX.DataBean> mData;
    public ArrayList<String> mBaselist;
    private List<String> mBaselist2;
    private String mString;
    private ImageView mF1_iv_add;
    private MyTitle mMyTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.f1, null);
        f1_tab = (TabLayout) view.findViewById(R.id.f1_tab);
        mGson = new Gson();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getData();
    }

    //获取资源ID
    private void initViews() {
        mF1_iv_add = (ImageView) view.findViewById(R.id.f1_iv_add);
        f1_vp = (ViewPager) view.findViewById(R.id.f1_vp);
        MyFragmentstatePageAdapter myFragmentstatePageAdapter = new MyFragmentstatePageAdapter(getActivity().getSupportFragmentManager(), list, mBaselist2, mBaselist);
        //最多可以预加载3个缓存
        f1_vp.setOffscreenPageLimit(0);
        f1_vp.setAdapter(myFragmentstatePageAdapter);
        f1_tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        f1_tab.setupWithViewPager(f1_vp);
        mF1_iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Main3Activity.class);
                intent.putStringArrayListExtra("key", mBaselist);
                getActivity().startActivity(intent);
            }
        });
    }

    //初始化数据
    private void getData() {
        HttpGetData.RequestGet(getActivity(), Utils.THE_TITLE_INTERFACE, "123", new VolleyInterface(getActivity(), VolleyInterface.mListener, VolleyInterface.mErrorListener) {
            @Override
            public void onMySuccess(String result) {
                Log.i(TAG, "onMySuccess: 哈哈哈哈" + result);
                // mString = result;
                for (int i = 0; i < 15; i++) {
                    Fragment1_frag fragment1_frag = new Fragment1_frag();
                    list.add(fragment1_frag);
                }
                Log.i(TAG, "标题接口" + result);
                mMyTitle = mGson.fromJson(result, MyTitle.class);
                mData = mMyTitle.getData().getData();
                Log.i(TAG, "Bean请求数据" + mData.toString());
                mBaselist = new ArrayList<>();
                mBaselist2 = new ArrayList<>();
                mBaselist.add(0, "推荐");
                mBaselist2.add("tuijian");
                for (int i = 0; i < 15; i++) {
                    mBaselist.add(mData.get(i).getName());
                    mBaselist2.add(mData.get(i).getCategory());
                }
                Log.i(TAG, "getData: " + mData.size());
                initViews();
            }

            @Override
            public void onMyError(VolleyError error) {

            }
        });
        // Log.i(TAG, "onMySuccess: " + mString);

    }
}
