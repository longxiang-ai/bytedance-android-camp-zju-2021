package com.example.chapter3.demo.animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chapter3.demo.R;

public class FrameAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);
        setTitle(getResources().getString(R.string.frame_animation_activity));
        ImageView imageView = findViewById(R.id.image_frame);
        imageView.setBackgroundResource(R.drawable.anim_list);
        AnimationDrawable drawable = (AnimationDrawable) imageView.getBackground();
        drawable.start();
    }
}
