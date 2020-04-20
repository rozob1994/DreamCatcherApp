package com.phrenologue.dreamcatcherapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.databinding.ActivitySelectLanguageBinding;
import com.phrenologue.dreamcatcherapp.managersAndFilters.LocaleManager;

public class SelectLanguageActivity extends AppCompatActivity {

    private ActivitySelectLanguageBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySelectLanguageBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();
        setContentView(view);
        LocaleManager localeManager = new LocaleManager();

        binding.radioButtonEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                localeManager.setAppLocale(getApplicationContext(), "en");
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
                finishAffinity();

            }
        });

        binding.radioButtonPersian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                localeManager.setAppLocale(getApplicationContext(), "fa");
                Log.e("","");
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
                finishAffinity();

            }
        });

    }
}
