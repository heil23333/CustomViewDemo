package com.example.android.customviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomImageView extends View {
    int src, background;
    Paint paint = new Paint();
    public CustomImageView(Context context) {
        super(context);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomImageView);
        src = typedArray.getResourceId(R.styleable.CustomImageView_src, R.drawable.ic_launcher_foreground);
        background = typedArray.getColor(R.styleable.CustomImageView_my_background, getResources().getColor(R.color.colorPrimaryDark));
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(background);
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), src), 0, 0, paint);
    }
}
