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

        // Найти ImageView
        ImageView imageView = findViewById(R.id.imageView);

        // Запустить анимацию на второй активити
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.image_rotate_animation);
        imageView.startAnimation(animation);

        // Найти кнопку "назад"
        Button backButton = findViewById(R.id.backButton);

        // Запустить анимацию кнопки "назад" с задержкой в одну секунду
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation buttonAnimation = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.button_appear_animation);
                backButton.startAnimation(buttonAnimation);
                // Сделать кнопку видимой после анимации
                backButton.setVisibility(View.VISIBLE);
            }
        }, 1000); // Запустить анимацию кнопки через 1 секунду

        // Обработчик клика для кнопки "назад"
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Закрыть текущую активити с эффектом "слайд влево"
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }
}