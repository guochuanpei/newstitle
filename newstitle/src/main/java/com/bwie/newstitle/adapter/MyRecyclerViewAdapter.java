package com.bwie.newstitle.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.newstitle.R;
import com.bwie.newstitle.bean.ContentBean;
import com.bwie.newstitle.bean.Recommended;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.pnikosis.materialishprogress.ProgressWheel;

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


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private List<ContentBean.DataBean> mDataBeen;
    private Context mContext;
    private int LARGE_PIC = 2;
    private int ONLY_TEXT = 0;
    private int RIGHT_PIC = 1;
    private int THREE_PIC = 3;
    private int VIDEO = 4;
    private final ImageLoader mImageLoader;
    private OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener = null;
    private static final int TYPE_FOOTER = 5;  //底部FootView

    public MyRecyclerViewAdapter(List<ContentBean.DataBean> dataBeen, Context context) {
        mDataBeen = dataBeen;
        mContext = context;
        mImageLoader = ImageLoader.getInstance();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == ONLY_TEXT) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.itemone, parent, false);
            view.setOnClickListener(this);
            return new MyViewHolder(view);
        } else if (viewType == RIGHT_PIC) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.itemtwo, parent, false);
            view.setOnClickListener(this);
            return new MyViewHolder1(view);
        } else if (viewType == LARGE_PIC) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.itemthree, parent, false);
            view.setOnClickListener(this);
            return new MyViewHolder2(view);
        } else if (viewType == THREE_PIC) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.itemfour, parent, false);
            view.setOnClickListener(this);
            return new MyViewHolder3(view);
        } else if (viewType == VIDEO) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.itemfive, parent, false);
            view.setOnClickListener(this);
            return new MyViewHolder4(view);
        } else if (viewType == TYPE_FOOTER) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_foot, parent, false);
            return new FootViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            //只有一行文字
            ((MyViewHolder) holder).mItemone_title_tv.setText(mDataBeen.get(position).getTitle());
            ((MyViewHolder) holder).mItemone_source.setText(mDataBeen.get(position).getSource());
            ((MyViewHolder) holder).mItemone_pinglun.setText(mDataBeen.get(position).getComment_count() + "评论");
            holder.itemView.setTag(mDataBeen.get(position).getUrl());
        } else if (holder instanceof MyViewHolder1) {
            // 右边有一张图片
            ((MyViewHolder1) holder).itemtwo_title_tv.setText(mDataBeen.get(position).getTitle());
            ((MyViewHolder1) holder).itemtwo_source.setText(mDataBeen.get(position).getSource());
            ((MyViewHolder1) holder).itemtwo_pinglun.setText(mDataBeen.get(position).getComment_count() + "评论");
            mImageLoader.displayImage(mDataBeen.get(position).getMiddle_image().getUrl(), ((MyViewHolder1) holder).itemtwo_iv);
            holder.itemView.setTag(mDataBeen.get(position).getUrl());
        } else if (holder instanceof MyViewHolder2) {
            //一张大图
            ((MyViewHolder2) holder).itemthree_tv.setText(mDataBeen.get(position).getTitle());
            ((MyViewHolder2) holder).itemthree_source.setText(mDataBeen.get(position).getSource());
            ((MyViewHolder2) holder).itemthree_pinglun.setText(mDataBeen.get(position).getComment_count() + "评论");
            mImageLoader.displayImage(mDataBeen.get(position).getLarge_image_list().get(0).getUrl(), ((MyViewHolder2) holder).itemthree_iv);
            holder.itemView.setTag(mDataBeen.get(position).getUrl());
        } else if (holder instanceof MyViewHolder3) {
            //三张图片
            ((MyViewHolder3) holder).itemfour_tv.setText(mDataBeen.get(position).getTitle());
            ((MyViewHolder3) holder).itemfour_source.setText(mDataBeen.get(position).getSource());
            ((MyViewHolder3) holder).itemfour_pinglun.setText(mDataBeen.get(position).getComment_count() + "评论");
            mImageLoader.displayImage(mDataBeen.get(position).getImage_list().get(0).getUrl(), ((MyViewHolder3) holder).itemfour_iv1);
            Log.i("TAG", "============================" + mDataBeen.get(position).getImage_list().size() + mDataBeen.get(position).getImage_list().get(0).getUrl());
            mImageLoader.displayImage(mDataBeen.get(position).getImage_list().get(1).getUrl(), ((MyViewHolder3) holder).itemfour_iv2);
            mImageLoader.displayImage(mDataBeen.get(position).getImage_list().get(2).getUrl(), ((MyViewHolder3) holder).itemfour_iv3);
            holder.itemView.setTag(mDataBeen.get(position).getUrl());
        } else if (holder instanceof MyViewHolder4) {
            //大图是视频的
            ((MyViewHolder4) holder).itemfive_tv.setText(mDataBeen.get(position).getTitle());
            ((MyViewHolder4) holder).itemfive_source.setText(mDataBeen.get(position).getSource());
            ((MyViewHolder4) holder).itemfive_pinglun.setText(mDataBeen.get(position).getComment_count() + "评论");
            mImageLoader.displayImage(mDataBeen.get(position).getLarge_image_list().get(0).getUrl(), ((MyViewHolder4) holder).itemfive_iv1);
            holder.itemView.setTag(mDataBeen.get(position).getUrl());
        } else if (holder instanceof FootViewHolder) {
            // ((FootViewHolder) holder).mProgress_wheel.setBarColor(Color.RED);
            Toast.makeText(mContext, "走了这个方法", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return mDataBeen.size() + 1;
    }

    @Override
    public void onClick(View v) {
        //将点击事件传出去
        if (mOnRecyclerViewItemClickListener != null) {
            mOnRecyclerViewItemClickListener.onItemClick(v, (String) v.getTag());
        }
    }

    //暴露在外面的调用方法
    public void setOnItemClickListener(OnRecyclerViewItemClickListener onItemClickListener) {
        this.mOnRecyclerViewItemClickListener = onItemClickListener;
    }

    //第一种ViewHolder
    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView mItemone_title_tv;
        private final TextView mItemone_source;
        private final TextView mItemone_pinglun;

        public MyViewHolder(View itemView) {
            super(itemView);
            //只有一行文字
            mItemone_title_tv = (TextView) itemView.findViewById(R.id.itemone_title_tv);
            mItemone_source = (TextView) itemView.findViewById(R.id.itemone_source);
            mItemone_pinglun = (TextView) itemView.findViewById(R.id.itemone_pinglun);
        }
    }


    //第二种ViewHolder
    public class MyViewHolder1 extends RecyclerView.ViewHolder {


        private final TextView itemtwo_title_tv;
        private final TextView itemtwo_source;
        private final TextView itemtwo_pinglun;
        private final ImageView itemtwo_iv;

        public MyViewHolder1(View itemView) {
            super(itemView);
            //右边有一张图片
            itemtwo_title_tv = (TextView) itemView.findViewById(R.id.itemtwo_title_tv);
            itemtwo_source = (TextView) itemView.findViewById(R.id.itemtwo_source);
            itemtwo_pinglun = (TextView) itemView.findViewById(R.id.itemtwo_pinglun);
            itemtwo_iv = (ImageView) itemView.findViewById(R.id.itemtwo_iv);
        }
    }

    //第三种ViewHolder
    public class MyViewHolder2 extends RecyclerView.ViewHolder {


        private final TextView itemthree_tv;
        private final TextView itemthree_source;
        private final TextView itemthree_pinglun;
        private final ImageView itemthree_iv;

        public MyViewHolder2(View itemView) {
            super(itemView);
            //一张大图
            itemthree_tv = (TextView) itemView.findViewById(R.id.itemthree_tv);
            itemthree_source = (TextView) itemView.findViewById(R.id.itemthree_source);
            itemthree_pinglun = (TextView) itemView.findViewById(R.id.itemthree_pinglun);
            itemthree_iv = (ImageView) itemView.findViewById(R.id.itemthree_iv);
        }
    }

    //第四种ViewHolder
    public class MyViewHolder3 extends RecyclerView.ViewHolder {


        private final TextView itemfour_tv;
        private final TextView itemfour_source;
        private final TextView itemfour_pinglun;
        private final ImageView itemfour_iv1;
        private final ImageView itemfour_iv2;
        private final ImageView itemfour_iv3;

        public MyViewHolder3(View itemView) {
            super(itemView);
            //三张图片
            itemfour_tv = (TextView) itemView.findViewById(R.id.itemfour_tv);
            itemfour_source = (TextView) itemView.findViewById(R.id.itemfour_source);
            itemfour_pinglun = (TextView) itemView.findViewById(R.id.itemfour_pinglun);
            itemfour_iv1 = (ImageView) itemView.findViewById(R.id.itemfour_iv1);
            itemfour_iv2 = (ImageView) itemView.findViewById(R.id.itemfour_iv2);
            itemfour_iv3 = (ImageView) itemView.findViewById(R.id.itemfour_iv3);
        }
    }

    //第五种ViewHolder
    public class MyViewHolder4 extends RecyclerView.ViewHolder {


        private final TextView itemfive_tv;
        private final TextView itemfive_source;
        private final TextView itemfive_pinglun;
        private final ImageView itemfive_iv1;

        public MyViewHolder4(View itemView) {
            super(itemView);
            //两张图片
            itemfive_tv = (TextView) itemView.findViewById(R.id.itemfive_tv);
            itemfive_source = (TextView) itemView.findViewById(R.id.itemfive_source);
            itemfive_pinglun = (TextView) itemView.findViewById(R.id.itemfive_pinglun);
            itemfive_iv1 = (ImageView) itemView.findViewById(R.id.itemfive_iv1);
        }
    }

    public static class FootViewHolder extends RecyclerView.ViewHolder {

        private final ProgressWheel mProgress_wheel;

        public FootViewHolder(View itemView) {
            super(itemView);
            mProgress_wheel = (ProgressWheel) itemView.findViewById(R.id.progress_wheel);
        }
    }

    @Override
    public int getItemViewType(int position) {

        //if (mDataBeen.get(position).isHas_image()) {

        if (mDataBeen.get(position).getLarge_image_list() != null
                && mDataBeen.get(position).getLarge_image_list().size() > 0) {
            return LARGE_PIC;
        }
        if ((mDataBeen.get(position).getImage_list() != null && mDataBeen.get(position).getImage_list().size() > 2)) {
            return THREE_PIC;
        }
        if (!TextUtils.isEmpty(mDataBeen.get(position).getMiddle_image().getUrl())) {
            return RIGHT_PIC;
        }
        if (mDataBeen.get(position).isHas_video()) {
            return VIDEO;
        }
        if (!mDataBeen.get(position).isHas_video() && !mDataBeen.get(position).isHas_image()) {
            return ONLY_TEXT;
        }
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        }
        return 0;
    }

    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, String data);
    }

    public void additem(List<ContentBean.DataBean> list) {
        list.addAll(mDataBeen);
        mDataBeen.removeAll(mDataBeen);
        mDataBeen.addAll(list);
        notifyDataSetChanged();
    }

    public void addMoreItem(List<ContentBean.DataBean> list) {
        mDataBeen.addAll(list);
        notifyDataSetChanged();
    }
}
