package com.example.semestr22;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ImageView imageView = findViewById(R.id.imageView);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.image_rotate_animation);
        imageView.startAnimation(animation);

        Button backButton = findViewById(R.id.backButton);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation buttonAnimation = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.button_appear_animation);
                backButton.startAnimation(buttonAnimation);
                backButton.setVisibility(View.VISIBLE);
            }
        }, 1000);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }
}