package com.phrenologue.dreamcatcherapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.ActivityExpandedDreamBinding;
import com.phrenologue.dreamcatcherapp.managersAndFilters.SharedPreferencesManager;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamChecklist;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamDate;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamDescription;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamInterpretation;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamLucidity;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamPeople;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamSound;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Sleep;
import com.phrenologue.dreamcatcherapp.presenters.DreamExpandedPresenter;
import com.phrenologue.dreamcatcherapp.presenters.StatsPresenter;

import maes.tech.intentanim.CustomIntent;

public class ExpandedDreamActivity extends AppCompatActivity {
    SharedPreferencesManager spManager;
    Dream dream;
    DreamPeople people;
    DreamChecklist checklist;
    DreamDate date;
    DreamDescription description;
    DreamInterpretation interpretation;
    DreamLucidity lucidity;
    DreamSound sound;
    Sleep sleep;
    DreamExpandedPresenter presenter;
    boolean clicked;
    private ActivityExpandedDreamBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExpandedDreamBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        dream = Dream.getInstance();
        people = DreamPeople.getInstance();
        checklist = DreamChecklist.getInstance();
        date = DreamDate.getInstance();
        description = DreamDescription.getInstance();
        interpretation = DreamInterpretation.getInstance();
        lucidity = DreamLucidity.getInstance();
        sound = DreamSound.getInstance();
        sleep = Sleep.getInstance();
        spManager = new SharedPreferencesManager();
        presenter = new DreamExpandedPresenter();
        int postId = getIntent().getIntExtra("postId", 0);
        int sleepTime = getIntent().getIntExtra("sleepTime", 0);
        SharedPreferences sp = getSharedPreferences("loadedSleepProps", MODE_PRIVATE);
        sp.edit().putInt("sleepTime", sleepTime).apply();
        String dateLoaded = getIntent().getStringExtra("date");
        sleep.setTime(sp.getInt("sleepTime", 0));
        clicked = false;

        dream.setPostId(postId);

        StatsPresenter.drawSingleLucidityLevel(binding.pieChart, postId, binding.txtPercentage,
                binding.noDataRel);

        presenter.retrievePeople(getApplicationContext(), postId, spManager);
        presenter.retrieveDream(getApplicationContext(), postId, binding.mood, binding.color,
                binding.dreamsPackageInterpretation, binding.dreamsPackageTitle,
                binding.dreamsPackageDescription, binding.sound, binding.titleDate, dateLoaded,
                spManager);
        presenter.retrieveSleep(getApplicationContext(), postId, spManager, binding.dayTime,
                binding.activity, binding.food);

        binding.relDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!clicked) {
                    binding.expandableDescription.expand();
                    binding.titleDescription.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.txt_glow));
                    clicked = true;
                } else {
                    binding.expandableDescription.collapse();
                    binding.titleDescription.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.gray));
                    clicked = false;
                }
            }
        });

        binding.relInterpretation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!clicked) {
                    binding.expandableInterpretation.expand();
                    binding.titleInterpretation.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.txt_glow));
                    clicked = true;
                } else {
                    binding.expandableInterpretation.collapse();
                    binding.titleInterpretation.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.gray));
                    clicked = false;
                }
            }
        });

        binding.relPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!clicked) {
                    binding.expandablePeople.expand();
                    binding.titlePeople.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.txt_glow));
                    clicked = true;
                } else {
                    binding.expandablePeople.collapse();
                    binding.titlePeople.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.gray));
                    clicked = false;
                }
            }
        });

        binding.btnEdtDream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), EditDreamInputActivity.class);
                startActivity(intent);
                CustomIntent.customType(ExpandedDreamActivity.this, "fadein-to-fadeout");
                finish();
            }
        });

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.edit().clear().apply();
                Intent intent = new Intent(getApplicationContext(), DreamsPackagesActivity.class);
                startActivity(intent);
                CustomIntent.customType(ExpandedDreamActivity.this, "fadein-to-fadeout");
                finish();
            }
        });
    }
    }
