package com.example.dreamcatcherapp.Activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.dreamcatcherapp.R;
import com.example.dreamcatcherapp.Ui.Fragments.ProfilePackages.Fragments.DreamsPackagesFragment;
import com.example.dreamcatcherapp.Ui.Fragments.ProfilePackages.Fragments.StatsPackagesFragment;
import com.example.dreamcatcherapp.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        binding= ActivityProfileBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();
        setContentView(view);

        binding.btnDreams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_dreams_stats, new DreamsPackagesFragment());
                transaction.commit();
            }
        });

        binding.btnStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_dreams_stats, new StatsPackagesFragment());
                transaction.commit();
            }
        });
    }
}
