package com.example.chapter2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UIActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "TAG";
    private Button btn_add_text;
    private LinearLayout ll_container;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        Log.i(TAG, "UIActivity onCreate");
        initView();
    }

    private void initView() {
        findViewById(R.id.iv_img).setOnClickListener(this);
        btn_add_text = findViewById(R.id.btn_add_text);
        btn_add_text.setOnClickListener(this);
        ll_container = findViewById(R.id.ll_container);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "UIActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "UIActivity onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "UIActivity onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "UIActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "UIActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "UIActivity onDestroy");
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.iv_img:
               Toast.makeText(UIActivity.this, "Click Img", Toast.LENGTH_LONG).show();
               break;
           case R.id.btn_add_text:
               count ++;
               TextView tv = new TextView(UIActivity.this);
               tv.setText("动态添加控件" + count);
               ll_container.addView(tv);
               break;
       }
    }
}