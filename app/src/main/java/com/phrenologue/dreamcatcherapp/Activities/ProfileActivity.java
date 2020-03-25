package com.phrenologue.dreamcatcherapp.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.Activities.Adapter.FeedsPackagesAdapter;
import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.ActivityProfileBinding;
import com.phrenologue.dreamcatcherapp.parameters.Users;

import maes.tech.intentanim.CustomIntent;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;
    private Toolbar toolbar;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        binding= ActivityProfileBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();
        setContentView(view);
        binding.userTitle.setText(Users.getInstance().getEmail());
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        Users user = Users.getInstance();
        user.setUid(sharedPreferences.getInt("uid", 0));
        user.setEmail(sharedPreferences.getString("username", "Nothing Retrieved"));
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        binding.toolbar.setTitle("");
        binding.toolbar.setSubtitle("");


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
                CustomIntent.customType(ProfileActivity.this,"fadein-to-fadeout");
            }
        });

        binding.btnStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), StatsActivity.class);
                startActivity(intent);
                CustomIntent.customType(ProfileActivity.this,"fadein-to-fadeout");
            }
        });

        FeedsPackagesAdapter adapter= new FeedsPackagesAdapter(getApplicationContext(), null);
        binding.recyclerFeed.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tabs, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
