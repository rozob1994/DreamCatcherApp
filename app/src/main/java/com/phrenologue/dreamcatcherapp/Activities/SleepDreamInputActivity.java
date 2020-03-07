package com.phrenologue.dreamcatcherapp.Activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Adapters.SleepDreamInputAdapter;
import com.phrenologue.dreamcatcherapp.databinding.ActivitySleepDreamInputBinding;

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
