package com.example.duzeming.demo.animation.deal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.duzeming.demo.R;

public class StartAnimationActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_animation);
         imageView = (ImageView) findViewById(R.id.iv_startAnimation);

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        params.setMargins(-100,-100,getWindowManager().getDefaultDisplay().getWidth()+100,
                getWindowManager().getDefaultDisplay().getHeight()+100);
        imageView.setLayoutParams(params);
    }

    public void btnStartAnimationMove(View view){

        /**系统动画 */
//        /**设置平移动画 */
//        TranslateAnimation animation = new TranslateAnimation(0,500,0,0);
//        /**设置动画时间 */
//        animation.setDuration(1000);
//        /** 设置动画结束后保留在原地 */
//        animation.setFillAfter(true);

//        assert imageView != null;
//        /** 开始动画 */
//        imageView.startAnimation(animation);
//        System.out.println("一运行");

        /**属性动画 */
//        ObjectAnimator.ofFloat(imageView,"rotation",0f,360f).setDuration(1000).start();
//        ObjectAnimator.ofFloat(imageView,"translationX",0f,200f).setDuration(1000).start();
//        ObjectAnimator.ofFloat(imageView,"translationY",0f,200f).setDuration(1000).start();

        /**与上面实现效果一样，不过下面优化了 */
//        PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("rotation",0f,360f);
//        PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("translationX",0f,360f);
//        PropertyValuesHolder holder3 = PropertyValuesHolder.ofFloat("translationY",0f,360f);
//        ObjectAnimator.ofPropertyValuesHolder(imageView,holder1,holder2,holder3).setDuration(1000).start();

        /**AnimatorSet方法 */
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "rotation", -200f, 360f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView, "translationX", -200f, 360f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView, "translationY", 0f, 360f);

        /**动画监听 */
        animator1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(StartAnimationActivity.this,"动画结束",Toast.LENGTH_SHORT).show();
            }
        });
        /**动画监听 */
//        animator1.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//                Toast.makeText(StartAnimationActivity.this,"动画开始",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                Toast.makeText(StartAnimationActivity.this,"动画结束",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        });

        AnimatorSet set = new AnimatorSet();
        /**同时进行 */
//        set.playTogether(animator1,animator2,animator3);
        /**顺序进行 */
//        set.playSequentially(animator1,animator2,animator3);
        /**先后进行 */
        set.play(animator2).with(animator3);
        set.play(animator1).after(animator2);
        set.setDuration(1000).start();


    }
}
