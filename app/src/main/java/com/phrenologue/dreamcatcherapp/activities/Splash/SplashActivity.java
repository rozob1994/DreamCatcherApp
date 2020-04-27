package com.phrenologue.dreamcatcherapp.activities.Splash;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.activities.Login.LoginActivity;
import com.phrenologue.dreamcatcherapp.activities.ProfileActivity;
import com.phrenologue.dreamcatcherapp.databinding.ActivitySplashBinding;
import com.phrenologue.dreamcatcherapp.managersAndFilters.LocaleManager;

import java.util.Locale;

import maes.tech.intentanim.CustomIntent;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;
    boolean clickState = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySplashBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        LocaleManager.getLanguage(getApplicationContext());
        LocaleManager.setLocale(getApplicationContext(), LocaleManager.getLanguage(getApplicationContext()));
        setLocale();




        if (clickState){
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            }, 10000);

        } else {

            binding.splash.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickState = true;
                    Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(intent);
                    CustomIntent.customType(SplashActivity.this, "fadein-to-fadeout");
                    finish();
                }
            });
        }


    }

    private void setLocale() {
        Locale locale = new Locale(LocaleManager.getLanguage(getApplicationContext()));
        Locale.setDefault(locale);

        Configuration configuration = getApplicationContext().getResources().getConfiguration();
        configuration.setLocale(locale);
        configuration.setLayoutDirection(locale);
    }
}
