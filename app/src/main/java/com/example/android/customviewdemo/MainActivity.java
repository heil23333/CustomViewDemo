package com.example.android.customviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CustomOvalView customOvalView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customOvalView = findViewById(R.id.customOval);
        findViewById(R.id.changeColor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customOvalView.setColor(customOvalView.getColor() + 10);
            }
        });
        findViewById(R.id.changeHeight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customOvalView.setHeight(150);
            }
        });
        customOvalView.setCustomOnClickListener(new CustomOvalView.CustomOnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "点击", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view) {
                Toast.makeText(MainActivity.this, "长按", Toast.LENGTH_LONG).show();
            }
        });
        customOvalView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
