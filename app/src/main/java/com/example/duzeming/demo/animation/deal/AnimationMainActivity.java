package com.example.duzeming.demo.animation.deal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.duzeming.demo.R;

public class AnimationMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_main);
    }

    public void btnStartAnimation(View view){
        startActivity(new Intent(this, StartAnimationActivity.class));
    }
    public void btnSecondAnimation(View view){
        startActivity(new Intent(this,SecondAnimationActivity.class));
    }
    public void btnValueAnimation(View view){
        startActivity(new Intent(this,ValueAnimationActivity.class));
    }
}
