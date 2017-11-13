package com.example.lenovo.intent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by lenovo on 2017/9/25.
 */

public class FActivity extends Activity {
    private Button bt1;
    private Button bt2;
    private Context mContext;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factivity);
        /*
        *通过点击bt1实现页面之间的跳转
         * 1.startActivity的方式实现跳转
         * 1>初始化Intent
        */
        mContext=this;
        tv= (TextView) findViewById(R.id.textView);
        bt1=(Button)findViewById(R.id.button1_first);
        bt2=(Button)findViewById(R.id.button2_second);

        //注册点击事件
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /*
            *第一个参数:上下文对象this
             * 第二个参数：目标文件
            */
                Intent intent=new Intent(mContext,SActivity.class);//初始化一个意图，通过 startActivity来实现页面之间的跳转
                startActivity(intent);

            }
        });
        /*
        *通过startActivityForresult(有返回数据的跳转)
        */
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,SActivity.class);
                /*
                *第一个参数是Intent 对象
                 * 第二个参数是请求的一个标志
                */
                startActivityForResult(intent,1);
            }
        });
    }
    /*
    *t通过 startActivityForresult跳转，接收返回数据的方法
    * requestCode：请求的标识
    * resultCode：第二个页面返回的标识
    * data：第二个页面回传的数据
    */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

       if(requestCode==1&&resultCode==2){
            String content=data.getStringExtra("data");
           tv.setText(content);
        }
    }
}
