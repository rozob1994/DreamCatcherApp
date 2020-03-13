package com.phrenologue.dreamcatcherapp.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.ActivityLevelsBinding;

public class LevelsActivity extends AppCompatActivity {

    private ActivityLevelsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        binding=ActivityLevelsBinding.inflate(getLayoutInflater());





    }
}
