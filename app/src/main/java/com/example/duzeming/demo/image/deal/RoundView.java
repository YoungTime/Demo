package com.example.duzeming.demo.image.deal;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import com.example.duzeming.demo.R;

/**
 * Created by DuZeming on 2017/8/24.
 */
public class RoundView extends View {

    private Bitmap mBitmap;
    private Bitmap bitmap;
    private Paint mPaint;

    public RoundView(Context context) {
        super(context);
        initView();
    }

    public RoundView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public RoundView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void initView(){
        /**禁用硬件加速，因为Xfermode不支持硬件加速，不禁用可能得不到想要的效果 */
        setLayerType(LAYER_TYPE_SOFTWARE,null);

        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a);
        bitmap = Bitmap.createBitmap(mBitmap.getWidth(), mBitmap.getHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        canvas.drawRoundRect(0,0,mBitmap.getWidth(),mBitmap.getHeight(),50,50,mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(mBitmap,0,0,mPaint);
        //mPaint.setXfermode(null);
            }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap,0,0,null);
    }
}
