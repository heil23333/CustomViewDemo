package com.example.android.customviewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class CustomLinearLayout2 extends LinearLayout {
    public CustomLinearLayout2(Context context) {
        super(context);
    }

    public CustomLinearLayout2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        System.out.println("hl--CustomLinearLayout2-----dispatchTouchEvent");
//        return false;
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        System.out.println("hl--CustomLinearLayout2-----onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("hl--CustomLinearLayout2-----onTouchEvent");
//        return false;
        return super.onTouchEvent(event);
    }
}
