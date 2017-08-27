package com.example.duzeming.demo.image.deal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.duzeming.demo.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void btnPrimaryColor(View view) {
        startActivity(new Intent(this, MeiTuActivity.class));

    }

    public void btnXiuXiu(View view) {
        startActivity(new Intent(this, XiuXIuActivity.class));
    }

    public void btnPixelEffect(View view) {
        startActivity(new Intent(this, PixelEffectActivity.class));
    }

    public void btnMatrix(View view) {
        startActivity(new Intent(this, ImageMatrixActivity.class));
    }

    public void btnRound(View view) {
        startActivity(new Intent(this, RoundActivity.class));
    }

    public void btnShader(View view) {
        startActivity(new Intent(this, BitmapShaderActivity.class));
    }
    public void btnReflect(View view) {
        startActivity(new Intent(this, ReflectActivity.class));
    }
    public void btnMesh(View view) {
        startActivity(new Intent(this, MeshActivity.class));
    }
}
