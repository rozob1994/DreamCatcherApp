package com.phrenologue.dreamcatcherapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.phrenologue.dreamcatcherapp.Ui.costumeFont.MoonTextView;
import com.phrenologue.dreamcatcherapp.databinding.ActivityDreamsPackagesBinding;
import com.phrenologue.dreamcatcherapp.presenters.DreamsPresenter;

import java.util.List;

import maes.tech.intentanim.CustomIntent;

public class DreamsPackagesActivity extends AppCompatActivity {
    private ActivityDreamsPackagesBinding binding;
    private List<String> titles;
    private List<String> contents;
    private DreamsPresenter presenter;
    private RecyclerView dreamsRecycler;
    private MoonTextView dreamCount;
    private MoonTextView dreamHours;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDreamsPackagesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        dreamsRecycler = binding.dreamsRecycler;
        dreamCount = binding.titleDreamsCount;
        dreamHours = binding.titleDreamHours;
        presenter = new DreamsPresenter(this);
        presenter.getDescription(getApplicationContext(),
                binding.loadingBg, dreamsRecycler,dreamCount);

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
                CustomIntent.customType(DreamsPackagesActivity.this,"fadein-to-fadeout");
                finish();
            }
        });

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), SleepDreamInputActivity.class);
                startActivity(intent);
                CustomIntent.customType(DreamsPackagesActivity.this,"fadein-to-fadeout");
            }
        });
    }


    @Override
    public void onBackPressed() {
        Intent intent= new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);
        CustomIntent.customType(DreamsPackagesActivity.this,"fadein-to-fadeout");
        finish();
    }

}
