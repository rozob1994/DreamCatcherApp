package com.catchydreams.dreamcatcher.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.catchydreams.dreamcatcher.constants.PersianFont;
import com.catchydreams.dreamcatcher.databinding.ActivitySelectLanguageBinding;

import java.util.Locale;

public class SelectLanguageActivity extends AppCompatActivity {

    private ActivitySelectLanguageBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectLanguageBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        SharedPreferences sp = getSharedPreferences("languages", MODE_PRIVATE);
        String language = sp.getString("language", "en");
        if (language.equals("fa")){
            Typeface font = Typeface.createFromAsset(getAssets(), PersianFont.title);
            binding.radioButtonPersian.setTypeface(font);
            binding.radioButtonEnglish.setTypeface(font);
            binding.pageTitle.setTypeface(font);
            binding.radioButtonPersian.setTextSize(PersianFont.normal);
            binding.radioButtonEnglish.setTextSize(PersianFont.normal);
        }
        sp.edit().clear().apply();
        binding.radioButtonEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.edit().putBoolean("justChanged", true).apply();
                String languageToLoad  = "en";
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                sp.edit().putString("language", "en").apply();
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
                finishAffinity();

            }
        });

        binding.radioButtonPersian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.edit().putBoolean("justChanged", true).apply();
                String languageToLoad  = "fa";
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                sp.edit().putString("language", "fa").apply();
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
                finishAffinity();

            }
        });

    }



}
