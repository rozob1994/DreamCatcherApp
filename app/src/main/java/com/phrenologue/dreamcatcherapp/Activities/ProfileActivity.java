package com.phrenologue.dreamcatcherapp.Activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.Ui.Fragments.ProfilePackages.Fragments.DreamsPackagesFragment;
import com.phrenologue.dreamcatcherapp.Ui.Fragments.ProfilePackages.Fragments.StatsPackagesFragment;
import com.phrenologue.dreamcatcherapp.databinding.ActivityProfileBinding;

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
