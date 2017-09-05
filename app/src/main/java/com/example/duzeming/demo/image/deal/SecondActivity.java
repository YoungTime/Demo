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

    /**色掉转换 */
    public void btnPrimaryColor(View view) {
        startActivity(new Intent(this, MeiTuActivity.class));
    }
    /**颜色矩阵 */
    public void btnXiuXiu(View view) {
        startActivity(new Intent(this, XiuXIuActivity.class));
    }
    /**底片效果 */
    public void btnPixelEffect(View view) {
        startActivity(new Intent(this, PixelEffectActivity.class));
    }

    /**图片形状矩阵转换 */
    public void btnMatrix(View view) {
        startActivity(new Intent(this, ImageMatrixActivity.class));
    }
    /**图片遮盖 */
    public void btnRound(View view) {
        startActivity(new Intent(this, RoundActivity.class));
    }
    /**渡模式 */
    public void btnShader(View view) {
        startActivity(new Intent(this, BitmapShaderActivity.class));
    }
    /**实线图片倒影 */
    public void btnReflect(View view) {
        startActivity(new Intent(this, ReflectActivity.class));
    }
    /**像素快 */
    public void btnMesh(View view) {
        startActivity(new Intent(this, MeshActivity.class));
    }
}
