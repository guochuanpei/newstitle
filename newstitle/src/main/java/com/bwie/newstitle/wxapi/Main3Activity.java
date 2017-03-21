package com.bwie.newstitle.wxapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.newstitle.R;
import com.bwie.newstitle.adapter.ItemTouchHelperCallback;
import com.bwie.newstitle.adapter.MyAdapter;
import com.bwie.newstitle.adapter.MyAdapter_two;
import com.bwie.newstitle.adapter.SpaceItemDecoration;
import com.bwie.newstitle.fragment.Fragment1;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private TextView mFinish;
    private RecyclerView mRecycleSelected;
    private RecyclerView mRecycleUnSelected;
    private ArrayList<String> mSelectedDatas;
    private ArrayList<String> mUnselectedDatas;
    private MyAdapter_two mMyAdapter_two;
    private MyAdapter mMyAdapter;
    private ItemTouchHelper mItemTouchHelper;
    private boolean isDeleteIconsShow = false;
    private ArrayList<String> mList;
    private ImageView mMain3_iv;
    private TextView mHideorshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent = getIntent();
        mList = intent.getStringArrayListExtra("key");
        initData();
        initViews();
        initEvent();
    }

    public boolean isDeleteIconsShow() {
        return isDeleteIconsShow;
    }

    //获取资源ID
    private void initViews() {
        mFinish = (TextView) findViewById(R.id.finish);
        mRecycleSelected = (RecyclerView) findViewById(R.id.top_recycler);
        mRecycleUnSelected = (RecyclerView) findViewById(R.id.bottom_recycler);
        //第一个RecyclerView的初始化
        mRecycleSelected.setLayoutManager(new GridLayoutManager(this, 4));
        mMyAdapter = new MyAdapter(mSelectedDatas, this);
        mRecycleSelected.setAdapter(mMyAdapter);
        //调用此方法来对子item项进行修饰
        mRecycleSelected.addItemDecoration(new SpaceItemDecoration(8));
        //第二个RecyclerView的初始化
        mRecycleUnSelected.setLayoutManager(new GridLayoutManager(this, 4));
        mMyAdapter_two = new MyAdapter_two(this, mUnselectedDatas);
        mRecycleUnSelected.setAdapter(mMyAdapter_two);
        mRecycleUnSelected.addItemDecoration(new SpaceItemDecoration(8));
        mMain3_iv = (ImageView) findViewById(R.id.main3_iv);
        mMain3_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mHideorshow = (TextView) findViewById(R.id.hideorshow);
    }

    private void initData() {
        mSelectedDatas = new ArrayList<String>();
        mSelectedDatas.addAll(mList);
        mUnselectedDatas = new ArrayList<String>();
        for (int i = 0; i < Fragment1.mData.size(); i++) {
            mUnselectedDatas.add(Fragment1.mData.get(i).getName());
        }
    }

    private void initEvent() {
        //实例化ItemTouchHelperCallback,与回调接口有关可以结合MainActivity,MyAdapter,ItemTouchHelperCallback一起理解
        ItemTouchHelperCallback callback = new ItemTouchHelperCallback(mMyAdapter);
        //ItemTouchHelper item项触摸帮助类不理解的可以自主学习
        mItemTouchHelper = new ItemTouchHelper(callback);
        //绑定RecyclerView
        mItemTouchHelper.attachToRecyclerView(mRecycleSelected);
        //MyAdapter里的公共构造方法
        mMyAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            //点击监听
            @Override
            public void onItemClickListener(MyAdapter.MyViewHolder viewHolder, int pos) {
                if (!isDeleteIconsShow) {
                    Toast.makeText(Main3Activity.this, mSelectedDatas.get(pos), Toast.LENGTH_SHORT).show();
                }
            }

            //长按item监听
            @Override
            public void onItemLongClickListener(MyAdapter.MyViewHolder viewHolder, int pos) {
                if (!isDeleteIconsShow) {
                    showAllDeleteIcons();
                    mFinish.setText("  完成  ");
                    mHideorshow.setVisibility(View.VISIBLE);
                }
            }
        });
        //点击切换栏目就隐藏所有小叉号
        mFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideAllDeleteIcons();
                mFinish.setVisibility(View.INVISIBLE);
                mHideorshow.setVisibility(View.INVISIBLE);
            }
        });
        //点击删除item,跟下面的同理
        mMyAdapter.setOnDeleteIconClickListener(new MyAdapter.OnDeleteIconClickListener() {
            @Override
            public void onDeleteIconClick(int pos) {
                mMyAdapter_two.addData(mSelectedDatas.get(pos), mUnselectedDatas.size());
                mMyAdapter.removeData(pos);
            }
        });
        //点击下面的RecyclerView时点那个item就把那个item添加到上面的RecyclerView中去,并且删除下面的RecyclerView中相应的item项
        mMyAdapter_two.setOnitemClickListener(new MyAdapter_two.OnItemClickListener() {
            @Override
            public void onItemClick(MyAdapter_two.ViewHolder holder, int pos) {
                mMyAdapter.addData(mUnselectedDatas.get(pos), mSelectedDatas.size());
                mMyAdapter_two.removeData(pos);
            }
        });
    }

    private void showAllDeleteIcons() {
        //与hideAllDeleteIcons同理
        int count = mRecycleSelected.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = mRecycleSelected.getChildAt(i);
            ImageView delete = (ImageView) child.findViewById(R.id.delelte);
            delete.setVisibility(View.VISIBLE);
        }
        isDeleteIconsShow = true;
    }

    /**
     * 隐藏所有的删除图标
     */
    private void hideAllDeleteIcons() {
        //获得此RecyclerView的所有子条目
        int count = mRecycleSelected.getChildCount();
        for (int i = 0; i < count; i++) {
            //获得子布局
            View child = mRecycleSelected.getChildAt(i);
            //找到小叉号图片的ID
            ImageView delete = (ImageView) child.findViewById(R.id.delelte);
            //设置不可见
            delete.setVisibility(View.INVISIBLE);
        }
        //将isDeleteIconsShow重新赋值
        isDeleteIconsShow = false;
    }
}
