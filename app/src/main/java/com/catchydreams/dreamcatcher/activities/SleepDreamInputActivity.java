package com.catchydreams.dreamcatcher.activities;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.catchydreams.dreamcatcher.databinding.ActivitySleepDreamInputBinding;
import com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Adapters.SleepDreamInputAdapter;

import java.util.Locale;

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
