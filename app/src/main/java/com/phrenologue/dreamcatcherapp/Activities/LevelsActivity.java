package com.phrenologue.dreamcatcherapp.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.ActivityLevelsBinding;

import maes.tech.intentanim.CustomIntent;

public class LevelsActivity extends AppCompatActivity {

    private ActivityLevelsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        binding=ActivityLevelsBinding.inflate(getLayoutInflater());

    }


    @Override
    public void onBackPressed() {
        Intent intent= new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);
        CustomIntent.customType(LevelsActivity.this,"fadein-to-fadeout");
        super.onBackPressed();
    }
}
