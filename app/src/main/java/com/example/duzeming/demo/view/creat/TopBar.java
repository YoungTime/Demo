package com.example.duzeming.demo.view.creat;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.duzeming.demo.R;

/**
 * Created by DuZeming on 2017/8/18.
 */
public class TopBar extends RelativeLayout {

    private Button leftButton;
    private Button rightButton;
    private TextView title;

    private int leftTextColor;
    private Drawable leftTextBackground;
    private String leftText;

    private int rightTextColor;
    private Drawable rightTextBackground;
    private String rightText;

    private float titleTextSize;
    private int titleTextColor;
    private String titleText;

    private LayoutParams leftParams;
    private LayoutParams rightParams;
    private LayoutParams titleParams;
    private topClickListener listener;

    /**自定义一个接口设置自定义View的点击事件*/
    public interface topClickListener{
        public void leftClick();
        public void rightClick();
    }

    /**打开点击事件的方法*/
    public void setOnTopBarClickListener(topClickListener listener){
        this.listener = listener;
    }

    /**添加自定义属性需要AttributeSet属性 */
    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        /**扫描atts.xml里面的所有自定义属性 */
        TypedArray array =context.obtainStyledAttributes(attrs, R.styleable.TopBar);

        /**获取所有自定义属性并提出 */
        leftTextColor = array.getColor(R.styleable.TopBar_leftTextColor,0);
        leftTextBackground =array.getDrawable(R.styleable.TopBar_leftBackGround);
        leftText = array.getString(R.styleable.TopBar_leftText);

        rightTextColor = array.getColor(R.styleable.TopBar_rightTextColor, 0);
        rightTextBackground =array.getDrawable(R.styleable.TopBar_rightBackGround);
        rightText = array.getString(R.styleable.TopBar_rightText);

        titleText = array.getString(R.styleable.TopBar_title);
        titleTextColor = array.getColor(R.styleable.TopBar_titleTextColor, 0);
        titleTextSize = array.getDimensionPixelSize(R.styleable.TopBar_titleTextSize, 0);

        /**释放TypeArray，防止浪费 */
        array.recycle();

        /**新建自定义View里面组合控件*/
        leftButton = new Button(context);
        rightButton = new Button(context);
        title = new TextView(context);

        /**为每个控件赋予属性 */
        leftButton.setText(leftText);
        leftButton.setTextColor(leftTextColor);
        leftButton.setBackground(leftTextBackground);

        rightButton.setText(rightText);
        rightButton.setTextColor(rightTextColor);
        rightButton.setBackground(rightTextBackground);

        title.setText(titleText);
        title.setTextColor(titleTextColor);
        title.setTextSize(titleTextSize);
        title.setGravity(Gravity.CENTER);

        /**设置整个自定义View的背景，此方法适用于API>=19 */
        setBackgroundColor(0xfff59563);

        /**为每个控件赋予位置，大小，并添加到自定义View上*/
        leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);

        addView(leftButton, leftParams);

        rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);

        addView(rightButton, rightParams);

        titleParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);

        addView(title, titleParams);

        /**每个控件的点击事件 */
        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.leftClick();
            }
        });
        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.rightClick();
            }
        });
    }

    /**静态方法控件是否显示 */
    public void textIsVisable(Boolean flag){
        if (flag){
            title.setVisibility(View.VISIBLE);
        }else {
            title.setVisibility(View.GONE);
        }
    }
}
