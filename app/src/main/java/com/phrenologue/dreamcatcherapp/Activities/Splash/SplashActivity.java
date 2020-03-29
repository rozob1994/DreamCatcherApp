package com.phrenologue.dreamcatcherapp.Activities.Splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.Activities.Login.LoginActivity;
import com.phrenologue.dreamcatcherapp.Activities.ProfileActivity;
import com.phrenologue.dreamcatcherapp.databinding.ActivitySplashBinding;

import maes.tech.intentanim.CustomIntent;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySplashBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, 10000);


        binding.splash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
                CustomIntent.customType(SplashActivity.this, "fadein-to-fadeout");

            }
        });

    }
}
