package com.bwie.newstitle.adapter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.bwie.newstitle.bean.MyTitle;
import com.bwie.newstitle.fragment.Fragment1_frag;
import com.bwie.newstitle.utils.Utils;

import java.util.Date;
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


public class MyFragmentstatePageAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> list;
    private List<String> strings;
    private List<String> strings2;

    public MyFragmentstatePageAdapter(FragmentManager fm, List<Fragment> list, List<String> strings2, List<String> strings) {
        super(fm);
        this.list = list;
        this.strings2 = strings2;
        this.strings = strings;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        Fragment1_frag fragment = (Fragment1_frag) list.get(position);
        Bundle bundle = new Bundle();
        bundle.putString("key", strings2.get(position));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 15;
    }
}
