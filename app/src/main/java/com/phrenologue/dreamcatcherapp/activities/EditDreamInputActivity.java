package com.phrenologue.dreamcatcherapp.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Adapters.EditDreamInfoInputAdapter;
import com.phrenologue.dreamcatcherapp.databinding.ActivityEditDreamInputBinding;

public class EditDreamInputActivity extends AppCompatActivity {

    private ActivityEditDreamInputBinding binding;
    EditDreamInfoInputAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_dream_input);
        binding= ActivityEditDreamInputBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        adapter= new EditDreamInfoInputAdapter(getSupportFragmentManager());
        binding.sleepDreamInputVp.setAdapter(adapter);
    }
}
