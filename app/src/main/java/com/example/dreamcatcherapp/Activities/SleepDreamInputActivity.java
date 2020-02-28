package com.example.dreamcatcherapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Adapters.SleepDreamInputAdapter;
import com.example.dreamcatcherapp.databinding.ActivitySleepDreamInputBinding;

public class SleepDreamInputActivity extends AppCompatActivity {

    private ActivitySleepDreamInputBinding binding;
    SleepDreamInputAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySleepDreamInputBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();
        setContentView(view);

        adapter= new SleepDreamInputAdapter(getSupportFragmentManager());
        binding.sleepDreamInputVp.setAdapter(adapter);
    }
}
