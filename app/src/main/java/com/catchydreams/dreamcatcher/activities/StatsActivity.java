package com.catchydreams.dreamcatcher.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.catchydreams.dreamcatcher.activities.profile.ProfileActivity;
import com.google.android.material.tabs.TabLayout;
import com.catchydreams.dreamcatcher.databinding.ActivityStatsBinding;
import com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Adapters.StatsTabsAdapter;

import maes.tech.intentanim.CustomIntent;

public class StatsActivity extends AppCompatActivity {
    private ActivityStatsBinding binding;
    private StatsTabsAdapter statsTabsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStatsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
                CustomIntent.customType(StatsActivity.this,"fadein-to-fadeout");
                finish();
            }
        });

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Charts"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("People"));
        binding.tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        statsTabsAdapter= new StatsTabsAdapter(getSupportFragmentManager(),binding.tabLayout.getTabCount());
        binding.viewPager.setAdapter(statsTabsAdapter);
        binding.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout));
        binding.tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent= new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);
        CustomIntent.customType(StatsActivity.this,"fadein-to-fadeout");
        finish();
    }
}
