package com.example.android.customviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomView03 extends View {
    Paint paint = new Paint();
    public CustomView03(Context context) {
        super(context);
    }

    public CustomView03(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.CYAN);
        //Paint的默认样式是FILL
        canvas.drawRect(100, 100, 200, 200, paint);
        paint.setStrokeWidth(30);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(250, 100, 350, 200, paint);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawRect(400, 100, 500, 200, paint);
    }
}
