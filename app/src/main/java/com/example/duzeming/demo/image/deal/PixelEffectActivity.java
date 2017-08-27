package com.example.duzeming.demo.image.deal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.duzeming.demo.R;

public class PixelEffectActivity extends AppCompatActivity {

    private ImageView imageView1,imageView2,imageView3,imageView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pixel_effect);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.car7);

        imageView1= (ImageView) findViewById(R.id.image1);
        imageView2= (ImageView) findViewById(R.id.image2);
        imageView3= (ImageView) findViewById(R.id.image3);
        imageView4= (ImageView) findViewById(R.id.image4);

        imageView1.setImageBitmap(bitmap);
        imageView2.setImageBitmap(ImageHelper.handleImageNegative(bitmap));

    }


}
