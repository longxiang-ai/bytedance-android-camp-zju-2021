package com.bytedance.camp.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final int MSG_START_DOWNLOAD = 0;
    public static final int MSG_DOWNLOAD_SUCCESS = 1;
    public static final int MSG_DOWNLOAD_FAIL = 2;
    private TextView tvContent;
    private TextView tvClick;

    public static void startMainActvity(AppCompatActivity activity){
        Intent intent = new Intent(activity , MainActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvContent = findViewById(R.id.tvContent);
        tvClick = findViewById(R.id.tvDownTest);
        tvClick.setOnClickListener(this);

    }

    @SuppressLint("HandlerLeak")
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_START_DOWNLOAD:
                    tvContent.setText("开始下载");
                    break;
                case MSG_DOWNLOAD_SUCCESS:
                    tvContent.setText("下载成功");
                    break;
                case MSG_DOWNLOAD_FAIL:
                    tvContent.setText("下载失败");
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvDownTest:
//                 new DownloadThread("http://www.xxx.mp4").start();

                new DownloadTask(tvContent).execute("http://www.xxx.mp4");
                break;
            default:
                break;
        }
    }

    private class DownloadThread extends Thread {
        private String videoId;

        public DownloadThread(String videoId) {
            this.videoId = videoId;
        }

        @Override
        public void run() {
            mHandler.sendMessage(Message.obtain(mHandler, MSG_START_DOWNLOAD));
            try {
                download(videoId);
                mHandler.sendMessage(Message.obtain(mHandler, MSG_DOWNLOAD_SUCCESS));
            } catch (Exception e) {
                mHandler.sendMessage(Message.obtain(mHandler, MSG_DOWNLOAD_FAIL));
            }
        }
    }

    private void download(String videoId) {
        // 后台下载...
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
