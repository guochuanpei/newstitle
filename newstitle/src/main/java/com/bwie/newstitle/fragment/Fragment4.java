package com.bwie.newstitle.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.newstitle.Main2Activity;
import com.bwie.newstitle.MainActivity;
import com.bwie.newstitle.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.logging.Logger;

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


public class Fragment4 extends Fragment implements View.OnClickListener {

    private View view;
    private ImageView mF4_phone;
    private ImageView mF4_wechat;
    private ImageView mF4_qq;
    private String scope = "all";
    private TextView mTt;
    public static RelativeLayout mF4_hide_r;
    public static RoundedImageView mIv_pwd_login;
    public static TextView mF4_name_tv;
    public static RelativeLayout mF4_show_r;
    private RelativeLayout mF4_r3;
    public static FrameLayout mFl1;
    public static FrameLayout mFl2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.f4, null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }

    //获取资源ID
    private void initViews() {
        mF4_r3 = (RelativeLayout) view.findViewById(R.id.f4_r3);
        mF4_phone = (ImageView) view.findViewById(R.id.f4_phone);//电话
        mF4_wechat = (ImageView) view.findViewById(R.id.f4_wechat);//微信
        mF4_qq = (ImageView) view.findViewById(R.id.f4_qq);//QQ登录按钮
        mFl1 = (FrameLayout) view.findViewById(R.id.fl1);
        mFl2 = (FrameLayout) view.findViewById(R.id.fl2);
        mF4_phone.setOnClickListener(this);
        mF4_wechat.setOnClickListener(this);
        mF4_qq.setOnClickListener(this);
        mF4_r3.setOnClickListener(this);
        mTt = (TextView) view.findViewById(R.id.ttttt);
        mF4_hide_r = (RelativeLayout) view.findViewById(R.id.f4_hide_r);
        mF4_show_r = (RelativeLayout) view.findViewById(R.id.f4_show_r);
        mIv_pwd_login = (RoundedImageView) view.findViewById(R.id.iv_pwd_login);
        mF4_name_tv = (TextView) view.findViewById(R.id.f4_name_tv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.f4_phone:

                break;
            case R.id.f4_wechat:

                break;
            case R.id.f4_qq:
                Toast.makeText(getActivity(), "点了哈哈哈", Toast.LENGTH_SHORT).show();
                if (!MainActivity.mTencent.isSessionValid()) {
                    MainActivity.mTencent.login(getActivity(), scope, MainActivity.loginListener);
                }

                break;
            case R.id.f4_r3:
                Intent intent = new Intent(getActivity(), Main2Activity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}