package com.example.duzeming.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.duzeming.demo.animation.deal.AnimationMainActivity;
import com.example.duzeming.demo.image.deal.SecondActivity;
import com.example.duzeming.demo.image.deal.XiuXIuActivity;
import com.example.duzeming.demo.view.creat.TopBar;

public class MainActivity extends AppCompatActivity{

    private TopBar topBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topBar = (TopBar) findViewById(R.id.topbar_id);

        topBar.setOnTopBarClickListener(new TopBar.topClickListener() {
            @Override
            public void leftClick() {
                Intent intent = new Intent(MainActivity.this,XiuXIuActivity.class);
                startActivity(intent);
            }

            @Override
            public void rightClick() {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        topBar.textIsVisable(false);
    }

    /**动画赏析 */
    public void btnAnimation(View view){
        startActivity(new Intent(this, AnimationMainActivity.class));
    }
}
