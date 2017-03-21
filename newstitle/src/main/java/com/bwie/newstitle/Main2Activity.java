package com.bwie.newstitle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bwie.newstitle.customview.MyRelativeLayout;
import com.bwie.newstitle.fragment.Fragment4;

public class Main2Activity extends AppCompatActivity {

    private MyRelativeLayout mMyRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mMyRelativeLayout = (MyRelativeLayout) findViewById(R.id.myRelativeLayout);
        mMyRelativeLayout.OnClickleftBtn(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "哈哈哈哈", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
