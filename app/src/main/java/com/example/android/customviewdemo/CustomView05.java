package com.example.android.customviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomView05 extends View {
    Paint paint = new Paint();
    public CustomView05(Context context) {
        super(context);
    }

    public CustomView05(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.CYAN);
        canvas.drawArc(300, 100, 600, 200, -110, 110, true, paint);
        paint.setAntiAlias(true);//开启抗锯齿
        canvas.drawArc(300, 100, 600, 200, 20, 140, false, paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(300, 100, 600, 200, -180, 60, false, paint);
    }
}
