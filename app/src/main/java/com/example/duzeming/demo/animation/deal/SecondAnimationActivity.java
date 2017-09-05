package com.example.duzeming.demo.animation.deal;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import com.example.duzeming.demo.R;
import java.util.ArrayList;
import java.util.List;


public class SecondAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private int[] res = {R.id.iv_secondAnimationImage1, R.id.iv_secondAnimationImage2,
            R.id.iv_secondAnimationImage3, R.id.iv_secondAnimationImage4, R.id.iv_secondAnimationImage5,
            R.id.iv_secondAnimationImage6, R.id.iv_secondAnimationImage7, R.id.iv_secondAnimationImage8};

    private List<ImageView> imageViewList = new ArrayList<ImageView>();
    private boolean frag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_animation);

        /**添加8个ImageView */
        for (int i = 0; i < res.length; i++) {
            ImageView imageView = (ImageView) findViewById(res[i]);
            imageView.setOnClickListener(this);
            imageViewList.add(imageView);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_secondAnimationImage8:
                if (frag) {
                    startAnim();
                }else {
                    closeAnim();
                }

                break;
            default:
                break;
        }
    }

    private void startAnim() {
        for (int i = 6; i >= 0; i--) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewList.get(i), "translationY", 0f, (i + 1) * 150);
           /**自由落体，反弹效果 */
            animator.setInterpolator(new BounceInterpolator());
            /**开始延时 */
            animator.setStartDelay((i + 1) * 300);
            animator.setDuration(500).start();
            frag = false;
        }
    }

    private void closeAnim() {
        for (int i = 6; i >= 0; i--) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewList.get(i), "translationY", (i + 1) * 150, 0f);
            animator.setInterpolator(new BounceInterpolator());
            animator.setStartDelay((i + 1) * 300);
            animator.setDuration(500).start();
            frag = true;
        }
    }
}
