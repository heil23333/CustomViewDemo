package com.example.android.customviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class CustomView06 extends View {

    public CustomView06(Context context) {
        super(context);
    }

    public CustomView06(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        Path path = new Path();
        path.addArc(50, 50, 250, 250, -225, 225);
        path.arcTo(250, 50, 450, 250, -180, 225, false);
        path.lineTo(250, 392);
        canvas.drawPath(path, paint);

        paint.setStyle(Paint.Style.STROKE);
        Path path2 = new Path();
        path2.addArc(650, 50, 850, 250, -225, 225);
        path2.arcTo(850, 50, 1050, 250, -180, 225, false);
        path2.lineTo(850, 392);
//        path2.close();//将起点和终点连接起来
        canvas.drawPath(path2, paint);

        paint.setStyle(Paint.Style.FILL);
        Path path3 = new Path();
        path3.addArc(50, 450, 250, 650, -225, 225);
        path3.arcTo(250, 450, 450, 650, -180, 225, true);
        path3.lineTo(250, 792);
        canvas.drawPath(path3, paint);
    }
}
