package com.phrenologue.dreamcatcherapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.Activities.Adapter.FeedsPackagesAdapter;
import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.ActivityProfileBinding;
import com.phrenologue.dreamcatcherapp.parameters.Users;

import maes.tech.intentanim.CustomIntent;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        binding= ActivityProfileBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();
        setContentView(view);
        binding.userTitle.setText(Users.getInstance().getEmail());


        binding.levelAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), LevelsActivity.class);
                startActivity(intent);
                CustomIntent.customType(ProfileActivity.this,"fadein-to-fadeout");
            }
        });


        binding.btnDreams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), DreamsPackagesActivity.class);
                startActivity(intent);
            }
        });

        binding.btnStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), StatsActivity.class);
                startActivity(intent);
            }
        });


        FeedsPackagesAdapter adapter= new FeedsPackagesAdapter(getApplicationContext(), null);
        binding.recyclerFeed.setAdapter(adapter);


    }
}
