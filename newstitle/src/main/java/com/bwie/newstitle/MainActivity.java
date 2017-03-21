package com.bwie.newstitle;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.newstitle.fragment.Fragment1;
import com.bwie.newstitle.fragment.Fragment2;
import com.bwie.newstitle.fragment.Fragment3;
import com.bwie.newstitle.fragment.Fragment4;
import com.bwie.newstitle.networktype.NetWorkUtil;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout r1;
    private RelativeLayout r2;
    private RelativeLayout r3;
    private RelativeLayout r4;
    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private ImageView iv4;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private Fragment2 mFragment2;
    private Fragment3 mFragment3;
    private Fragment4 mFragment4;
    public static Tencent mTencent;
    public static IUiListener loginListener;
    private IUiListener userInfoListener;
    private static final String APPID = "1105922772";
    private String mNickName;
    private String mMNickName;
    private String mFigureurlQq2;
    private ImageLoader mImageLoader;
    private FragmentTransaction mFragmentTransaction;
    private Fragment1 mFragment11;
    private int mResponse;
    private View mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mView = View.inflate(this, R.layout.activity_main, null);
        setContentView(mView);
        //判断网络是否连接
        if (!NetWorkUtil.isConn(getApplicationContext())) {
            NetWorkUtil.setNetworkMethod(this);
        } else {
            initQqLogin();
            initViews();
            mFragment11 = new Fragment1();
            getSupportFragmentManager().beginTransaction().add(R.id.fl, mFragment11).commit();
        }
    }

    /*获取资源ID*/
    private void initViews() {
        r1 = (RelativeLayout) findViewById(R.id.r1);
        r2 = (RelativeLayout) findViewById(R.id.r2);
        r3 = (RelativeLayout) findViewById(R.id.r3);
        r4 = (RelativeLayout) findViewById(R.id.r4);
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        iv3 = (ImageView) findViewById(R.id.iv3);
        iv4 = (ImageView) findViewById(R.id.iv4);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        r1.setOnClickListener(this);
        r2.setOnClickListener(this);
        r3.setOnClickListener(this);
        r4.setOnClickListener(this);
        iv1.setEnabled(false);
        tv1.setTextColor(Color.RED);
        mImageLoader = ImageLoader.getInstance();
    }

    @Override
    public void onClick(View v) {
        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideorshow(mFragmentTransaction);
        switch (v.getId()) {
            case R.id.r1:
                iv1.setEnabled(false);
                tv1.setTextColor(Color.RED);
                iv2.setEnabled(true);
                tv2.setTextColor(Color.BLACK);
                iv3.setEnabled(true);
                tv3.setTextColor(Color.BLACK);
                iv4.setEnabled(true);
                tv4.setTextColor(Color.BLACK);
                if (mFragment11 == null) {
                    mFragment11 = new Fragment1();
                    mFragmentTransaction.add(R.id.fl, mFragment11);
                } else {
                    mFragmentTransaction.show(mFragment11);
                }
                break;
            case R.id.r2:
                iv1.setEnabled(true);
                tv1.setTextColor(Color.BLACK);
                iv2.setEnabled(false);
                tv2.setTextColor(Color.RED);
                iv3.setEnabled(true);
                tv3.setTextColor(Color.BLACK);
                iv4.setEnabled(true);
                tv4.setTextColor(Color.BLACK);
                if (mFragment2 == null) {
                    mFragment2 = new Fragment2();
                    mFragmentTransaction.add(R.id.fl, mFragment2);
                } else {
                    mFragmentTransaction.show(mFragment2);
                }
                break;
            case R.id.r3:
                iv1.setEnabled(true);
                tv1.setTextColor(Color.BLACK);
                iv2.setEnabled(true);
                tv2.setTextColor(Color.BLACK);
                iv3.setEnabled(false);
                tv3.setTextColor(Color.RED);
                iv4.setEnabled(true);
                tv4.setTextColor(Color.BLACK);
                if (mFragment3 == null) {
                    mFragment3 = new Fragment3();
                    mFragmentTransaction.add(R.id.fl, mFragment3);
                } else {
                    mFragmentTransaction.show(mFragment3);
                }
                break;
            case R.id.r4:
                iv1.setEnabled(true);
                tv1.setTextColor(Color.BLACK);
                iv2.setEnabled(true);
                tv2.setTextColor(Color.BLACK);
                iv3.setEnabled(true);
                tv3.setTextColor(Color.BLACK);
                iv4.setEnabled(false);
                tv4.setTextColor(Color.RED);
                if (mFragment4 == null) {
                    mFragment4 = new Fragment4();
                    mFragmentTransaction.add(R.id.fl, mFragment4);
                } else {
                    mFragmentTransaction.show(mFragment4);
                }
                break;
            default:
                break;
        }
        mFragmentTransaction.commit();
    }

    //利用事务来实现fragment的显示隐藏
    private void hideorshow(FragmentTransaction fragmentTransaction) {
        if (mFragment11 != null) {
            fragmentTransaction.hide(mFragment11);
        }
        if (mFragment2 != null) {
            fragmentTransaction.hide(mFragment2);
        }
        if (mFragment3 != null) {
            fragmentTransaction.hide(mFragment3);
        }
        if (mFragment4 != null) {
            fragmentTransaction.hide(mFragment4);
        }
    }

    //初始化QQ登录分享的需要的资源
    private void initQqLogin() {
        mTencent = Tencent.createInstance(APPID, MainActivity.this);
        //创建QQ登录回调接口
        loginListener = new IUiListener() {
            @Override
            public void onComplete(Object o) {
                //登录成功后回调该方法
                JSONObject jo = (JSONObject) o;
                Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                Log.i("miaojx:", jo.toString());
                String openID;
                try {
                    openID = jo.getString("openid");
                    String accessToken = jo.getString("access_token");
                    String expires = jo.getString("expires_in");
                    mTencent.setOpenId(openID);
                    mTencent.setAccessToken(accessToken, expires);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(UiError uiError) {
                //登录失败后回调该方法
                Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                Log.e("LoginError:", uiError.toString());
            }

            @Override
            public void onCancel() {
                //取消登录后回调该方法
                Toast.makeText(MainActivity.this, "取消登录", Toast.LENGTH_SHORT).show();
            }
        };
        userInfoListener = new IUiListener() {


            @Override
            public void onComplete(Object o) {
                if (o == null) {
                    return;
                }
                try {
                    JSONObject jo = (JSONObject) o;
                    Log.e("JO:", jo.toString());
                    int ret = jo.getInt("ret");
                    mMNickName = jo.getString("nickname");
                    mFigureurlQq2 = jo.getString("figureurl_qq_2");
                    Fragment4.mFl1.setVisibility(View.GONE);
                    Fragment4.mFl2.setVisibility(View.VISIBLE);
                    Fragment4.mF4_name_tv.setText(mMNickName);
                    mImageLoader.displayImage(mFigureurlQq2, Fragment4.mIv_pwd_login);

                    Log.i("TAG", mMNickName);
                    String gender = jo.getString("gender");
                    Toast.makeText(MainActivity.this, "你好，" + mMNickName, Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                }
            }

            @Override
            public void onError(UiError uiError) {
            }

            @Override
            public void onCancel() {
            }
        };
    }

    //QQ登录回调
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_LOGIN) {
            // if (resultCode == -1) {
            // Tencent.onActivityResultData(requestCode, resultCode, data, loginListener);
            Tencent.handleResultData(data, loginListener);
            UserInfo info = new UserInfo(MainActivity.this, mTencent.getQQToken());
            info.getUserInfo(userInfoListener);
            Toast.makeText(MainActivity.this, "走了这个方法", Toast.LENGTH_SHORT).show();
            // }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
