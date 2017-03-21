package com.bwie.newstitle.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.bwie.newstitle.Main4Activity;
import com.bwie.newstitle.R;
import com.bwie.newstitle.adapter.MyRecyclerViewAdapter;
import com.bwie.newstitle.bean.ContentBean;
import com.bwie.newstitle.httprequest.HttpGetData;
import com.bwie.newstitle.httprequest.VolleyInterface;
import com.bwie.newstitle.utils.Utils;
import com.google.gson.Gson;

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


public class Fragment1_frag extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = "Fragment1_frag";
    private View view;
    private MyRecyclerViewAdapter mMyRecyclerViewAdapterter;
    private RecyclerView mF1_f_recycler;
    private String mKey;
    private Gson mGson = new Gson();
    private SwipeRefreshLayout mSwiperefreshlayout;
    private List<ContentBean.DataBean> mData;
    private ContentBean mContentBean;
    private LinearLayoutManager mLinearLayoutManager;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };
    private int mLastVisibleItemPosition;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.f1_f, null);
        mF1_f_recycler = (RecyclerView) view.findViewById(R.id.f1_f_recycler);
        mSwiperefreshlayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefreshlayout);
        //改变加载时的颜色
        mSwiperefreshlayout.setColorSchemeColors(Color.RED, Color.RED);
        //设置初始值大小
        mSwiperefreshlayout.setSize(SwipeRefreshLayout.DEFAULT);
        //设置刷新出现的位置
        mSwiperefreshlayout.setProgressViewEndTarget(false, 200);
        //设置监听
        mSwiperefreshlayout.setOnRefreshListener(this);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mF1_f_recycler.setLayoutManager(mLinearLayoutManager);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mKey = getArguments().getString("key");
        Log.i(TAG, "接收到的key值" + mKey);
        Long time = Utils.getTime();
        String path = Utils.getPath(mKey, time);//得到路径
        Log.i(TAG, "path" + path);

        if (mKey.equals("tuijian")) {
            HttpGetData.RequestGet(getActivity(), Utils.RECOMMENDED, "1234", new VolleyInterface(getActivity(), VolleyInterface.mListener, VolleyInterface.mErrorListener) {
                @Override
                public void onMySuccess(String result) {
                    Log.i(TAG, "Volley第一次请求数据" + result);
                    mContentBean = mGson.fromJson(result, ContentBean.class);
                    mData = mContentBean.getData();
                    mMyRecyclerViewAdapterter = new MyRecyclerViewAdapter(mData, getActivity());
                    mF1_f_recycler.setAdapter(mMyRecyclerViewAdapterter);
                    mMyRecyclerViewAdapterter.setOnItemClickListener(new MyRecyclerViewAdapter.OnRecyclerViewItemClickListener() {
                        @Override
                        public void onItemClick(View view, String data) {
                            Intent intent = new Intent(getActivity(), Main4Activity.class);
                            intent.putExtra("data", data);
                            startActivity(intent);
                        }
                    });
                }

                @Override
                public void onMyError(VolleyError error) {

                }
            });
        } else {
            HttpGetData.RequestGet(getActivity(), Utils.RECOMMENDED, "1234", new VolleyInterface(getActivity(), VolleyInterface.mListener, VolleyInterface.mErrorListener) {
                @Override
                public void onMySuccess(String result) {
                    Log.i(TAG, "Volley第一次请求数据" + result);
                    mContentBean = mGson.fromJson(result, ContentBean.class);
                    mData = mContentBean.getData();
                    Log.i(TAG, "哈哈哈哈哈" + mData.toString());
                    //适配器
                    mMyRecyclerViewAdapterter = new MyRecyclerViewAdapter(mData, getActivity());
                    mF1_f_recycler.setAdapter(mMyRecyclerViewAdapterter);
                    mMyRecyclerViewAdapterter.setOnItemClickListener(new MyRecyclerViewAdapter.OnRecyclerViewItemClickListener() {
                        @Override
                        public void onItemClick(View view, String data) {
                            Intent intent = new Intent(getActivity(), Main4Activity.class);
                            intent.putExtra("data", data);
                            startActivity(intent);
                        }
                    });
                }

                @Override
                public void onMyError(VolleyError error) {

                }
            });
            mF1_f_recycler.setOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    if ( mLastVisibleItemPosition + 1 == mMyRecyclerViewAdapterter.getItemCount()) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                HttpGetData.RequestGet(getActivity(), Utils.RECOMMENDED, "1234", new VolleyInterface(getActivity(), VolleyInterface.mListener, VolleyInterface.mErrorListener) {
                                    @Override
                                    public void onMySuccess(final String result) {
                                        mContentBean = mGson.fromJson(result, ContentBean.class);
                                        List<ContentBean.DataBean> data = mContentBean.getData();
                                        mMyRecyclerViewAdapterter.additem(data);
                                        mMyRecyclerViewAdapterter.addMoreItem(data);
                                    }

                                    @Override
                                    public void onMyError(VolleyError error) {

                                    }
                                });
                            }
                        }, 2500);
                    }
                    Toast.makeText(getActivity(), "走了哈哈哈", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    mLastVisibleItemPosition = mLinearLayoutManager.findLastVisibleItemPosition();
                }
            });
        }
    }

    @Override
    public void onRefresh() {
        mData.clear();
        HttpGetData.RequestGet(getActivity(), Utils.RECOMMENDED, "1234", new VolleyInterface(getActivity(), VolleyInterface.mListener, VolleyInterface.mErrorListener) {
            @Override
            public void onMySuccess(final String result) {
                mContentBean = mGson.fromJson(result, ContentBean.class);
                mData.addAll(mContentBean.getData());
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            Thread.sleep(2000);
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    ContentBean contentBean = mGson.fromJson(result, ContentBean.class);
                                    List<ContentBean.DataBean> data = contentBean.getData();
                                    mData.addAll(data);
                                    Toast.makeText(getActivity(), "刷新成功", Toast.LENGTH_SHORT).show();
                                    mMyRecyclerViewAdapterter.notifyDataSetChanged();
                                    mSwiperefreshlayout.setRefreshing(false);
                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }

            @Override
            public void onMyError(VolleyError error) {

            }
        });
    }
}
