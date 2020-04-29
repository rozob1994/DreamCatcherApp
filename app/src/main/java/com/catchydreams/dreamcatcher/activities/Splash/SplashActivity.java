package com.catchydreams.dreamcatcher.activities.Splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.catchydreams.dreamcatcher.activities.Login.LoginActivity;
import com.catchydreams.dreamcatcher.activities.ProfileActivity;
import com.catchydreams.dreamcatcher.databinding.ActivitySplashBinding;
import com.catchydreams.dreamcatcher.managersAndFilters.LocaleManager;
import com.catchydreams.dreamcatcher.parameters.Users;

import java.util.Locale;

import maes.tech.intentanim.CustomIntent;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;
    boolean clickState = false;
    private SharedPreferences sharedPreferences;


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
                    sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                    if (sharedPreferences.getBoolean("logged", false)) {
                        Users user = Users.getInstance();
                        user.setUid(sharedPreferences.getInt("uid", 0));
                        user.setEmail(sharedPreferences.getString("username", ""));
                        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(i);
                        finish();
                    }

                }
            }, 10000);

        } else {

            binding.splash.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickState = true;
                    sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                    if (sharedPreferences.getBoolean("logged", false)) {
                        Users user = Users.getInstance();
                        user.setUid(sharedPreferences.getInt("uid", 0));
                        user.setEmail(sharedPreferences.getString("username", ""));
                        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(i);
                        finish();
                    }
                    CustomIntent.customType(SplashActivity.this, "fadein-to-fadeout");
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
