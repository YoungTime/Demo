package com.example.duzeming.demo.image.deal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * Created by DuZeming on 2017/8/20.
 */
public class ImageHelper {

    /**创建方法，四个参数：传入的图片、色调、饱和度、亮度 */
    public static Bitmap handImageEffect(Bitmap bitmap,float hue,float saturation,float lum){

        /**无法在传入的Bitmap上做修改，需新建一个，宽高为传入Bitmap的宽高*/
        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),Bitmap.Config.ARGB_8888);

        /**创建画纸和画笔*/
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        /**创建色调矩阵 */
        ColorMatrix hueMatrix = new ColorMatrix();
        /**设置色调，0代表Red，1代表Green，2代表blue */
        hueMatrix.setRotate(0,hue);
        hueMatrix.setRotate(1,hue);
        hueMatrix.setRotate(2,hue);

        /**创建饱和度矩阵，设置饱和度 */
        ColorMatrix saturationMatrix =new ColorMatrix();
        saturationMatrix.setSaturation(saturation);

        /**创建亮度矩阵，设置亮度 */
        ColorMatrix lumMatrix = new ColorMatrix();
        lumMatrix.setScale(lum,lum,lum,1);

        /**创建图片矩阵，为图片设置色调、饱和度、亮度 */
        ColorMatrix imageMatrix = new ColorMatrix();
        imageMatrix.postConcat(hueMatrix);
        imageMatrix.postConcat(saturationMatrix);
        imageMatrix.postConcat(lumMatrix);

        /**将图片矩阵传入画纸 */
        paint.setColorFilter(new ColorMatrixColorFilter(imageMatrix));
        canvas.drawBitmap(bitmap,0,0,paint);

        return bmp;
    }

    public static Bitmap handleImageNegative(Bitmap bm){

        int width = bm.getWidth();
        int height = bm.getHeight();

        int color; //每个像素的颜色

        int r,g,b,a; //每个像素的R、G、B、A的分量

        /**无法在传入的Bitmap上做修改，需新建一个，宽高为传入Bitmap的宽高*/
        Bitmap bitmap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);

        /**创建像素点的数组，获取图片像素点并将其存入数组 */
        int[] oldPx = new int[width*height];
        bm.getPixels(oldPx,0,width,0,0,width,height);

        /**存储新像素点 */
        int[] newPx = new int[width*height];

        for (int i = 0; i < width * height; i++) {
            color = oldPx[i];

            /**从像素颜色中获取R、G、B、A */
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);

            r = 255 - r;
            g = 255 - g;
            b = 255 - b;

            if (r > 255){
                r = 255;
            }else if (r<0){
                r = 0;
            }
            if (g > 255){
                g = 255;
            }else if (g<0){
                g = 0;
            }
            if (b > 255){
                b = 255;
            }else if (b<0){
                b = 0;
            }

            /**将新的R、G、B存入新的像素数组 */
            newPx[i] = Color.argb(a,r,g,b);
        }

        /**将新的像素数组在图像上显示出来 */
        bitmap.setPixels(newPx,0,width,0,0,width,height);
        return bitmap;
    }
}
