package com.example.android.customviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomView02 extends View {
    Paint paint = new Paint();

    public CustomView02(Context context) {
        super(context);
    }

    public CustomView02(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPoint(100, 100,paint);//默认width为1px
        //设置画笔的粗细，单位为px(如没有特殊说明，单位都是px)
        paint.setStrokeWidth(50);
        canvas.drawPoint(200, 100,paint);
        paint.setColor(Color.CYAN);
        paint.setStrokeCap(Paint.Cap.ROUND);//圆角，BUTT和SQUARE都为方角
        canvas.drawPoint(300, 100,paint);
        paint.setColor(Color.GREEN);
        float[] points = {400, 100, 500, 100, 600, 100, 700, 100};
        canvas.drawPoints(points, paint);
    }
}
