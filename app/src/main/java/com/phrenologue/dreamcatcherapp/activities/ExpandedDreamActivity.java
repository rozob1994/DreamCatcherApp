package com.phrenologue.dreamcatcherapp.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.ActivityExpandedDreamBinding;
import com.phrenologue.dreamcatcherapp.managersAndFilters.SharedPreferencesManager;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Sleep;
import com.phrenologue.dreamcatcherapp.presenters.DreamExpandedPresenter;
import com.phrenologue.dreamcatcherapp.presenters.StatsPresenter;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONException;
import org.json.JSONObject;

import maes.tech.intentanim.CustomIntent;

public class ExpandedDreamActivity extends AppCompatActivity {
    SharedPreferencesManager spManager;
    Dream dream;
    Sleep sleep;
    DreamExpandedPresenter presenter;
    boolean clicked;
    private ActivityExpandedDreamBinding binding;
    private SharedPreferences sp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExpandedDreamBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        dream = Dream.getInstance();
        sleep = Sleep.getInstance();
        spManager = new SharedPreferencesManager();
        presenter = new DreamExpandedPresenter();
        sp2 = getSharedPreferences("dreamToLucidityQuestionnaire", Context.MODE_PRIVATE);

        int postId = getIntent().getIntExtra("postId", 0);
        int sleepTime = getIntent().getIntExtra("sleepTime", 0);

        SharedPreferences sp = getSharedPreferences("loadedSleepProps", MODE_PRIVATE);

        sp.edit().putInt("sleepTime", sleepTime).apply();

        String dateLoaded = getIntent().getStringExtra("date");

        sleep.setTime(sp.getInt("sleepTime", 0));

        clicked = false;

        dream.setPostId(postId);

        StatsPresenter.drawSingleLucidityLevel(binding.pieChart, postId, binding.txtPercentage,
                binding.noDataRel, binding.txtPercentage);

        presenter.retrievePeople(getApplicationContext(), postId, spManager, binding.loadingBg,
                binding.progressBar, binding.nameOne, binding.nameTwo, binding.nameThree,
                binding.nameFour, binding.nameFive, binding.nameSix, binding.nameSeven,
                binding.nameEight, binding.nameNine, binding.nameTen);
        presenter.retrieveDream(getApplicationContext(), postId, binding.mood, binding.color,
                binding.dreamsPackageInterpretation, binding.dreamsPackageTitle,
                binding.dreamsPackageDescription, binding.sound, binding.titleDate, dateLoaded,
                spManager, binding.loadingBg, binding.progressBar);
        presenter.retrieveSleep(getApplicationContext(), postId, spManager, binding.dayTime,
                binding.activity, binding.food, binding.loadingBg, binding.progressBar);

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

        binding.btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp2.edit().putBoolean("fromDream", true).apply();
                Intent intent = new Intent(getApplicationContext(), LucidDreamingQuestionnaireActivity.class);
                startActivity(intent);
                finish();
            }
        });


        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewThread thread = new NewThread();
                thread.start();
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
    class NewThread extends Thread {
        @Override
        public void run() {
            ApiPostCaller apiPostCaller = new ApiPostCaller();
            apiPostCaller.delDream(new IResponseMessage() {
                @Override
                public void onSuccess(Object response) throws JSONException {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    boolean status = jsonObject.getBoolean("status");
                    if (status) {
                        Intent intent = new Intent(getApplicationContext(), DreamsPackagesActivity.class);
                        startActivity(intent);
                        Toast.makeText(ExpandedDreamActivity.this, "Dream was Successfully deleted!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(String errorMessage) {

                }
            });
        }
    }




}

