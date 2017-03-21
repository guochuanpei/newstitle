package com.bwie.newstitle.customview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwie.newstitle.R;

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


public class MyRelativeLayout extends RelativeLayout {

    private ImageView mView_btn;

    public MyRelativeLayout(Context context) {
        this(context, null);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = View.inflate(context, R.layout.titlebar, this);
        mView_btn = (ImageView) view.findViewById(R.id.view_btn);
        TextView view_text = (TextView) view.findViewById(R.id.view_text);
        ImageView view_iv = (ImageView) view.findViewById(R.id.view_iv);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyRelativeLayout);
        if (typedArray != null) {
            String string = typedArray.getString(R.styleable.MyRelativeLayout_titlebar_name);
            view_text.setText(string);
            float dimension = typedArray.getDimension(R.styleable.MyRelativeLayout_titlebar_name_size, 10);
            view_text.setTextSize(dimension);
            Drawable drawable = typedArray.getDrawable(R.styleable.MyRelativeLayout_right_iv);
            view_iv.setImageDrawable(drawable);
        }
        typedArray.recycle();
    }

    //向外暴露方法实现按钮监听
    public void OnClickleftBtn(OnClickListener onClickListener) {
        mView_btn.setOnClickListener(onClickListener);
    }

}
