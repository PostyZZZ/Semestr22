package com.example.semestr22;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textViewHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textViewHello = findViewById(R.id.textViewHello);

        Animation helloAnimation = AnimationUtils.loadAnimation(this, R.anim.text_appear_animation);
        textViewHello.startAnimation(helloAnimation);

        Animation buttonAnimation = AnimationUtils.loadAnimation(this, R.anim.button_appear_animation);
        button.startAnimation(buttonAnimation);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Animation helloAnimation = AnimationUtils.loadAnimation(this, R.anim.text_appear_animation);
        textViewHello.startAnimation(helloAnimation);


        Animation buttonAnimation = AnimationUtils.loadAnimation(this, R.anim.button_appear_animation);
        button.startAnimation(buttonAnimation);
    }
}
