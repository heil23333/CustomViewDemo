package com.example.android.customviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomOvalView extends View {
    private Paint paint = new Paint();
    private int color;
    private final int defaultWidth = 200, defaultHeight = 100;
    private int width = 200, height = 100;
    private boolean setHeight = false;
    private CustomOnClickListener customOnClickListener;
    public CustomOvalView(Context context) {
        super(context);
    }

    public CustomOvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomOvalView);
        color = typedArray.getInt(R.styleable.CustomOvalView_color, getResources().getColor(R.color.colorAccent));
    }

    public void setCustomOnClickListener(CustomOnClickListener customOnClickListener) {
        this.customOnClickListener = customOnClickListener;
    }

    public int getColor() {
        return color;
    }

    public void setHeight(int height) {
        this.height = height;
        setHeight = true;
        requestLayout();
    }
    public void setColor(int color) {
        this.color = color;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(color);
        canvas.drawOval(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        switch (MeasureSpec.getMode(widthMeasureSpec)) {
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                width = defaultWidth;
                break;
            case MeasureSpec.EXACTLY:
                width = getMeasuredWidth();
                break;
        }
        if (setHeight) {
            setMeasuredDimension(width, height);
            return;
        }
        switch (MeasureSpec.getMode(heightMeasureSpec)) {
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                height = defaultHeight;
                break;
            case MeasureSpec.EXACTLY:
                height = getMeasuredHeight();
                break;
        }
        setMeasuredDimension(width, height);
    }

    private long touchStartTime = 0;
    private float touchX, touchY;
    private boolean isMoved = false;

    @Override
    public boolean performClick() {
        customOnClickListener.onClick(this);
        return super.performClick();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("hl------action=" + getAction(event.getAction()));
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchStartTime = System.currentTimeMillis();
                touchX = event.getX();
                touchY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                if (!isMoved && System.currentTimeMillis() - touchStartTime < 100 && customOnClickListener != null) {
                    performClick();
                }
                resetValue();
                break;
            case MotionEvent.ACTION_MOVE:
                if (Math.abs(touchX - event.getX()) > 2 && Math.abs(touchY - event.getY()) < 2) {
                    isMoved = true;
                    return true;
                }
                if (touchStartTime != 0 && System.currentTimeMillis() - touchStartTime > 1000) {
                    customOnClickListener.onLongClick(this);
                    resetValue();
                }
                break;
            case MotionEvent.ACTION_CANCEL://
                resetValue();
                break;
            default:
                break;
        }
        return true;
    }
    static String getAction(int action) {
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                return "ACTION_DOWN";
            case MotionEvent.ACTION_MOVE:
                return "ACTION_MOVE";
            case MotionEvent.ACTION_UP:
                return "ACTION_UP";
            case MotionEvent.ACTION_CANCEL:
                return "ACTION_CANCEL";
            default:
                return "UNKNOWN_ACTION";
        }
    }

    private void resetValue() {
        touchStartTime = 0;
        touchX = 0;
        touchY = 0;
        isMoved = false;
    }

    interface CustomOnClickListener {
        void onClick(View view);
        void onLongClick(View view);
    }
}
