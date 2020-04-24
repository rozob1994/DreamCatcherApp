package com.phrenologue.dreamcatcherapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.databinding.ActivitySleepDreamInputBinding;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Adapters.SleepDreamInputAdapter;

import java.util.Locale;

import maes.tech.intentanim.CustomIntent;

public class SleepDreamInputActivity extends AppCompatActivity {
    private ActivitySleepDreamInputBinding binding;
    SleepDreamInputAdapter adapter;
    SharedPreferences sleepSp, dreamSp, dreamTwoSp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySleepDreamInputBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();
        setContentView(view);

        SharedPreferences languagePrefs = getSharedPreferences("languages", MODE_PRIVATE);
        String languageToLoad = languagePrefs.getString("language", "en");
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());

        adapter= new SleepDreamInputAdapter(getSupportFragmentManager());
        binding.sleepDreamInputVp.setAdapter(adapter);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), DreamsPackagesActivity.class);
        CustomIntent.customType(SleepDreamInputActivity.this,"fadein-to-fadeout");
        finish();
        startActivity(intent);
    }
    protected void onDestroy(){
        super.onDestroy();
        sleepSp = getSharedPreferences("sleep", MODE_PRIVATE);
        dreamSp = getSharedPreferences("dream", MODE_PRIVATE);
        dreamTwoSp = getSharedPreferences("dreamTwo", MODE_PRIVATE);
        sleepSp.edit().clear().apply();
        dreamSp.edit().clear().apply();
        dreamTwoSp.edit().clear().apply();

    }
}
