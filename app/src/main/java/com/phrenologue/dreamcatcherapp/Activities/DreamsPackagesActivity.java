package com.phrenologue.dreamcatcherapp.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.Activities.Adapter.DreamsPackagesActivityAdapter;
import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.ActivityDreamsPackagesBinding;

public class DreamsPackagesActivity extends AppCompatActivity {

    private ActivityDreamsPackagesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dreams_packages);
        binding= ActivityDreamsPackagesBinding.inflate(getLayoutInflater());

        DreamsPackagesActivityAdapter adapter= new DreamsPackagesActivityAdapter(getApplicationContext(), null);
        binding.dreamsRecycler.setAdapter(adapter);


    }
}
