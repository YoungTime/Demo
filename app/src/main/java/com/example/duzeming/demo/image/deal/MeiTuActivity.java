package com.example.duzeming.demo.image.deal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.example.duzeming.demo.R;

public class MeiTuActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private ImageView mImageView;
    private SeekBar huSeekBar;
    private SeekBar saSeekBar;
    private SeekBar lumSeekBar;

    private static int MAX_VALUE = 255;//设置SeekBar的最大值
    private static int MID_VALUE = 127;//设置SeekBar的中间值

    private float mHu,mSa,mLum;

    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mei_tu);

        /**设置传入的图片*/
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.car3);

        mImageView = (ImageView) findViewById(R.id.iv_meiTu);
        huSeekBar= (SeekBar) findViewById(R.id.sb_hu);
        saSeekBar= (SeekBar) findViewById(R.id.sb_sa);
        lumSeekBar= (SeekBar) findViewById(R.id.sb_lum);

        huSeekBar.setOnSeekBarChangeListener(this);
        saSeekBar.setOnSeekBarChangeListener(this);
        lumSeekBar.setOnSeekBarChangeListener(this);

        /**为三个SeekBar初始化最大值 */
        huSeekBar.setMax(MAX_VALUE);
        saSeekBar.setMax(MAX_VALUE);
        lumSeekBar.setMax(MAX_VALUE);

        /**为三个SeekBar设置光标的初始位置 */
        huSeekBar.setProgress(MID_VALUE);
        saSeekBar.setProgress(MID_VALUE);
        lumSeekBar.setProgress(MID_VALUE);

        mImageView.setImageBitmap(bitmap);
    }

    /**设置SeekBar光标改变事件 */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()){
            case R.id.sb_hu:
                mHu = (progress - MID_VALUE)*1.0f/MID_VALUE*180;
                break;
            case R.id.sb_sa:
                mSa = (progress*1.0f)/MID_VALUE;
                break;
            case R.id.sb_lum:
                mLum = progress*1.0f/MID_VALUE;
                break;
            default:
                break;
        }

        /**光标改变时传入的值，将其显示在图片上 */
        mImageView.setImageBitmap(ImageHelper.handImageEffect(bitmap, mHu, mSa, mLum));
        
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}
}
