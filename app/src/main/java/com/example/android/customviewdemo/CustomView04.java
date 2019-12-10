package com.example.android.customviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class CustomView04 extends View {
    Paint paint = new Paint();
    public CustomView04(Context context) {
        super(context);
    }

    public CustomView04(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRoundRect(100, 100, 200, 200, 50, 50, paint);
    }
}
