package com.example.lenovo.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by lenovo on 2017/9/25.
 */

public class SActivity extends Activity {
    private Button bt;
    private String content="你好";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sactivity);
        /*
        *第二个什么时候给第一个页面回传数据
        * 回传到第一个页面实际上是一个Intent对象
        */
        bt= (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data=new Intent();
                data.putExtra("data",content);
                setResult(2,data);
                //结束当前页面
                finish();
            }
        });
    }
}
