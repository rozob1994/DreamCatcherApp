package com.phrenologue.dreamcatcherapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Adapters.SleepDreamInputAdapter;
import com.phrenologue.dreamcatcherapp.databinding.ActivitySleepDreamInputBinding;

public class SleepDreamInputActivity extends AppCompatActivity {
    private boolean doubleBackToExitPressedOnce = false;
    private ActivitySleepDreamInputBinding binding;
    SleepDreamInputAdapter adapter;
    SharedPreferences sleepSp, dreamSp, dreamTwoSp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySleepDreamInputBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();
        setContentView(view);

        adapter= new SleepDreamInputAdapter(getSupportFragmentManager());
        binding.sleepDreamInputVp.setAdapter(adapter);
    }
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory( Intent.CATEGORY_HOME );
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
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
