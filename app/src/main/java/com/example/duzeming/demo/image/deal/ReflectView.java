package com.example.duzeming.demo.image.deal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.example.duzeming.demo.R;

/**
 * Created by DuZeming on 2017/8/25.
 */
public class ReflectView extends View {

    private Bitmap mBitmap;
    private Bitmap bitmap;
    private Paint mPaint;

    public ReflectView(Context context) {
        super(context);
        initView();
    }

    public ReflectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ReflectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        Matrix matrix = new Matrix();

        /**设置缩放，这样x轴不变，y轴变为相反数，即形成镜像 */
        matrix.setScale(1,-1);
        bitmap = Bitmap.createBitmap(mBitmap,0,0,mBitmap.getWidth(),mBitmap.getHeight(),matrix,true);

        mPaint = new Paint();

        /**五个属性：起始坐标，终点坐标，起始颜色，终点颜色为透明度不同的两种颜色，模式 */
        mPaint.setShader(new LinearGradient(0,mBitmap.getHeight(),0,2*mBitmap.getHeight()
                , 0xdd000000,0x10000000, Shader.TileMode.CLAMP));


    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        canvas.drawBitmap(mBitmap, 0, 0, null);
        canvas.drawBitmap(bitmap,0,mBitmap.getHeight(),null);
        canvas.drawRect(0,mBitmap.getHeight(),mBitmap.getWidth(),mBitmap.getHeight()*2,mPaint);
    }
}
