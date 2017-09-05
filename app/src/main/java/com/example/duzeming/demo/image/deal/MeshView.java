package com.example.duzeming.demo.image.deal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.example.duzeming.demo.R;

/**
 * Created by DuZeming on 2017/8/26.
 */
public class MeshView extends View {

    /**将图像横竖分为多少格 */
    private int WIDTH = 200;
    private int HEIGHT = 200;
    /**横竖的交点 */
    private int COUNT = (WIDTH + 1)*(HEIGHT + 1);
    /**交点坐标 基数为横坐标，偶数为纵坐标*/
    private float[] verts = new float[COUNT * 2];
    private float[] orig = new float[COUNT * 2];
    private Bitmap mBitmap;
    private float k = 1;

    public MeshView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MeshView(Context context) {
        super(context);
        initView();
    }

    public MeshView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();

    }

    private void initView(){
        int index = 0;
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a);
        float bmWidth = mBitmap.getWidth();
        float bmHeight = mBitmap.getHeight();

        /**找出每个交点的坐标 */
        for (int i = 0; i < HEIGHT + 1; i++) {
            float fy = bmHeight * i/HEIGHT;
            for (int j = 0; j < WIDTH + 1; j++) {
                float fx = bmWidth *j/WIDTH;
                orig[index*2]=verts[index*2]=fx;
                orig[index*2 +1]=verts[index*2 +1]=fy;
                index+=1;
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < HEIGHT + 1; i++) {
            for (int j = 0; j < WIDTH + 1; j++) {
                verts[(i * ( WIDTH+1 ) + j) * 2] +=0;
                /**两个float不可以少,不然得不到效果,k*2*Math.PI为每次重画的转移量,为周期性 */
                float offSetY = (float) Math.sin((float)j/WIDTH*2*Math.PI + k*2*Math.PI);
                verts[(i * ( WIDTH+1 ) + j) * 2 +1] =
                        /**纵坐标为转移量 */
                        orig[(i * ( WIDTH+1 ) + j) * 2 +1] + offSetY*50;
            }
        }
        /**每次重画都改变k值 */
        k+=0.1f;

        canvas.drawBitmapMesh(mBitmap,WIDTH,HEIGHT,verts,0,null,0,null);

        /**重画 */
        invalidate();
    }
}
