package com.example.duzeming.demo.image.deal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.example.duzeming.demo.R;

/**
 * Created by DuZeming on 2017/8/24.
 */
public class BitmapShaderView extends View {

    private Bitmap mBitmap;
    private Paint mPaint;
    private BitmapShader shader;

    public BitmapShaderView(Context context) {
        super(context);
    }

    public BitmapShaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BitmapShaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);

        /**CLAM为一种模式，对边缘最后一个像素拉伸*/
        shader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        mPaint.setShader(shader);
        canvas.drawCircle(300,300,150,mPaint);
    }
}
