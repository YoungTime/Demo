package com.example.duzeming.demo.image.deal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.example.duzeming.demo.R;

public class XiuXIuActivity extends AppCompatActivity {

    private ImageView mImageView;
    private GridLayout mGroup;
    private Bitmap bitmap;
    private int mEtWidth,mEtHeight;

    /**设置20个EditText的数组*/
    private EditText[] mEts = new EditText[20];

    /**设置20个ColorMatrix的数组，值从EditText中取出*/
    private float[] mColorMatrix = new float[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiu_xiu);

        /**设置传入的图片*/
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.a);

        mImageView= (ImageView) findViewById(R.id.imageView);
        /**用4行、5列的GridLayout来表示颜色矩阵*/
        mGroup= (GridLayout) findViewById(R.id.group);

        mImageView.setImageBitmap(bitmap);

        /**直接在onCreate方法中获取不到，为0，因为控件还没有绘制完成。*/
        mGroup.post(new Runnable() {
            @Override
            public void run() {
                mEtWidth = mGroup.getWidth() / 5;//单个值的宽
                mEtHeight = mGroup.getHeight() / 4;//单个值的高
                addEts();
                initMatrix();
            }
        });
    }

    /**设置改变颜色按钮的点击事件*/
    public void btnChange(View view){
        getMatrix();//获取20个矩阵的值
        setImageMatrix();//按照矩阵修改画像
    }

    public void btnReset(View view){
        initMatrix();//初始化矩阵
        getMatrix();//传入颜色矩阵
        setImageMatrix();//作画
    }

    /**获取20个EditText中的值*/
    private void getMatrix(){
        for (int i = 0; i < 20; i++){
            mColorMatrix[i] = Float.valueOf(mEts[i].getText().toString());//将String类型的转换成float
        }
    }

    /**将矩阵中的值在图片中展现出来*/
    private void setImageMatrix(){

        /**无法在传入的Bitmap上做修改，需新建一个，宽高为传入Bitmap的宽高*/
        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);

        ColorMatrix colorMatrix = new ColorMatrix();

        /**将数字矩阵的值传入颜色矩阵*/
        colorMatrix.set(mColorMatrix);

        /**创建画纸和画笔*/
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        /**将ColorMatrix传入Paint形成一支特殊的画笔*/
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        /**将传入的Bitmap和颜色矩阵画入新建的Bitmap*/
        canvas.drawBitmap(bitmap,0,0,paint);
        /**刷新ImageView*/
        mImageView.setImageBitmap(bmp);

    }

    /**动态添加20个EditText*/
    private void addEts(){
        for (int i = 0; i < 20; i++){
            EditText editText = new EditText(XiuXIuActivity.this);
            mEts[i] = editText;
            mGroup.addView(editText,mEtWidth,mEtHeight);
        }
    }

    /**给20个EditText设置文本内容*/
    private void initMatrix(){
        for (int i = 0; i < 20; i++){
            if (i % 6 == 0){
                mEts[i].setText("1");
            }else{
                mEts[i].setText("0");
            }
        }
    }
}
