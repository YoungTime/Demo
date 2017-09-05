package com.example.duzeming.demo.animation.deal;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.duzeming.demo.R;

public class ValueAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animation);

    }
    public void btnValueAnimation(View view){
        final Button button = (Button) view;
        ValueAnimator animator = ValueAnimator.ofInt(0,100);
        animator.setDuration(5000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer value = (Integer) animation.getAnimatedValue();
                button.setText(""+value);

            }
        });
        animator.start();

//        ValueAnimator animator = ValueAnimator.ofObject(new TypeEvaluator<PointF>() {
//            @Override
//            public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
//                float x = (endValue.x - startValue.x)*fraction;
//                float y = (endValue.y - startValue.y)*fraction;
//                return null;
//            }
////            new PointF(1,1),new PointF(300,300);
//
//        });
    }
}
