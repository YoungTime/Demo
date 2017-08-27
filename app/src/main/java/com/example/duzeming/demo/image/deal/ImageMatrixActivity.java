package com.example.duzeming.demo.image.deal;

import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;

import com.example.duzeming.demo.R;

public class ImageMatrixActivity extends AppCompatActivity {

    private GridLayout gridLayout;
    private ImageMatrixView imageMatrixView;
    private int mEdWith,mEdHeight;
    private float[] mImageMatrix = new float[9];
    private EditText[] mEts = new EditText[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_matrix);

        imageMatrixView = (ImageMatrixView) findViewById(R.id.image_view);
        gridLayout= (GridLayout) findViewById(R.id.gl_group);

        gridLayout.post(new Runnable() {
            @Override
            public void run() {
                mEdHeight = gridLayout.getHeight()/3;
                mEdWith = gridLayout.getWidth()/3;
                addEts();
                initImageMatrix();
            }
        });
    }


    /**添加9个EditText */
    private void addEts() {
        for (int i = 0; i < 9; i++) {
            EditText editText= new EditText(ImageMatrixActivity.this);
            //editText.setGravity(Gravity.CENTER);
            mEts[i] = editText;
            gridLayout.addView(editText,mEdWith,mEdHeight);
        }
    }

    /**初始化矩阵 */
    private void initImageMatrix(){
        for (int i = 0; i < 9; i++) {
            if (i % 4 == 0){
                mEts[i].setText("1");
            }else {
                mEts[i].setText("0");
            }
        }
    }

    /**给EditText赋值 */
    private void getImageMatrix(){
        for (int i = 0; i < 9; i++) {
            EditText editText = mEts[i];
            mImageMatrix[i] = Float.valueOf(editText.getText().toString());
        }
    }

    public void btnChangeTwo(View view){
        getImageMatrix();
        Matrix matrix = new Matrix();
        matrix.setValues(mImageMatrix);
        imageMatrixView.setImageMatrix(matrix);
        imageMatrixView.invalidate(); // 刷新矩阵
    }

    public void btnResetTwo(View view){
        initImageMatrix();
        getImageMatrix();
        Matrix matrix = new Matrix();
        matrix.setValues(mImageMatrix);
        imageMatrixView.setImageMatrix(matrix);
        imageMatrixView.invalidate();
    }
}
