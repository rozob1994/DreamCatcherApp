package com.phrenologue.dreamcatcherapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.ActivityLevelsBinding;

import maes.tech.intentanim.CustomIntent;

public class LevelsActivity extends AppCompatActivity {

    private ActivityLevelsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        binding=ActivityLevelsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnBackToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.btnBackToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
                CustomIntent.customType(LevelsActivity.this,"fadein-to-fadeout");
                finish();
            }
        });

        binding.levelOne.setOnClickListener(new View.OnClickListener() {
            boolean isAnimated=false;
            @Override
            public void onClick(View v) {
                if (!isAnimated){
                    binding.levelOne.playAnimation();
                    binding.levelTwo.pauseAnimation();
                    binding.levelThree.pauseAnimation();
                    binding.levelFour.pauseAnimation();
                    binding.levelFive.pauseAnimation();
                    binding.levelSix.pauseAnimation();
                    binding.levelSeven.pauseAnimation();
                    binding.levelEight.pauseAnimation();
                    binding.levelNine.pauseAnimation();
                    binding.levelTen.pauseAnimation();
                    isAnimated=true;
                } else {
                    binding.levelOne.pauseAnimation();
                    isAnimated=false;
                }
            }
        });

        binding.levelTwo.setOnClickListener(new View.OnClickListener() {
            boolean isAnimated=false;
            @Override
            public void onClick(View v) {
                if (!isAnimated){
                    binding.levelTwo.playAnimation();
                    binding.levelThree.pauseAnimation();
                    binding.levelFour.pauseAnimation();
                    binding.levelFive.pauseAnimation();
                    binding.levelSix.pauseAnimation();
                    binding.levelSeven.pauseAnimation();
                    binding.levelEight.pauseAnimation();
                    binding.levelNine.pauseAnimation();
                    binding.levelTen.pauseAnimation();
                    binding.levelOne.pauseAnimation();
                    isAnimated=true;
                } else {
                    binding.levelTwo.pauseAnimation();
                    isAnimated=false;
                }
            }
        });

        binding.levelThree.setOnClickListener(new View.OnClickListener() {
            boolean isAnimated=false;
            @Override
            public void onClick(View v) {
                if (!isAnimated){
                    binding.levelThree.playAnimation();
                    binding.levelFour.pauseAnimation();
                    binding.levelFive.pauseAnimation();
                    binding.levelSix.pauseAnimation();
                    binding.levelSeven.pauseAnimation();
                    binding.levelEight.pauseAnimation();
                    binding.levelNine.pauseAnimation();
                    binding.levelTen.pauseAnimation();
                    binding.levelTwo.pauseAnimation();
                    binding.levelOne.pauseAnimation();
                    isAnimated=true;
                } else {
                    binding.levelThree.pauseAnimation();
                    isAnimated=false;
                }
            }
        });

        binding.levelFour.setOnClickListener(new View.OnClickListener() {
            boolean isAnimated=false;
            @Override
            public void onClick(View v) {
                if (!isAnimated){
                    binding.levelFour.playAnimation();
                    binding.levelFive.pauseAnimation();
                    binding.levelSix.pauseAnimation();
                    binding.levelSeven.pauseAnimation();
                    binding.levelEight.pauseAnimation();
                    binding.levelNine.pauseAnimation();
                    binding.levelTen.pauseAnimation();
                    binding.levelThree.pauseAnimation();
                    binding.levelTwo.pauseAnimation();
                    binding.levelOne.pauseAnimation();
                    isAnimated=true;
                } else {
                    binding.levelFour.pauseAnimation();
                    isAnimated=false;
                }
            }
        });

        binding.levelFive.setOnClickListener(new View.OnClickListener() {
            boolean isAnimated=false;
            @Override
            public void onClick(View v) {
                if (!isAnimated){
                    binding.levelFive.playAnimation();
                    binding.levelSix.pauseAnimation();
                    binding.levelSeven.pauseAnimation();
                    binding.levelEight.pauseAnimation();
                    binding.levelNine.pauseAnimation();
                    binding.levelTen.pauseAnimation();
                    binding.levelFour.pauseAnimation();
                    binding.levelThree.pauseAnimation();
                    binding.levelTwo.pauseAnimation();
                    binding.levelOne.pauseAnimation();
                    isAnimated=true;
                } else {
                    binding.levelFive.pauseAnimation();
                    isAnimated=false;
                }
            }
        });

        binding.levelSix.setOnClickListener(new View.OnClickListener() {
            boolean isAnimated=false;
            @Override
            public void onClick(View v) {
                if (!isAnimated){
                    binding.levelSix.playAnimation();
                    binding.levelSeven.pauseAnimation();
                    binding.levelEight.pauseAnimation();
                    binding.levelNine.pauseAnimation();
                    binding.levelTen.pauseAnimation();
                    binding.levelFive.pauseAnimation();
                    binding.levelFour.pauseAnimation();
                    binding.levelThree.pauseAnimation();
                    binding.levelTwo.pauseAnimation();
                    binding.levelOne.pauseAnimation();
                    isAnimated=true;
                } else {
                    binding.levelSix.pauseAnimation();
                    isAnimated=false;
                }
            }
        });

        binding.levelSeven.setOnClickListener(new View.OnClickListener() {
            boolean isAnimated=false;
            @Override
            public void onClick(View v) {
                if (!isAnimated){
                    binding.levelSeven.playAnimation();
                    binding.levelEight.pauseAnimation();
                    binding.levelNine.pauseAnimation();
                    binding.levelTen.pauseAnimation();
                    binding.levelSix.pauseAnimation();
                    binding.levelFive.pauseAnimation();
                    binding.levelFour.pauseAnimation();
                    binding.levelThree.pauseAnimation();
                    binding.levelTwo.pauseAnimation();
                    binding.levelOne.pauseAnimation();
                    isAnimated=true;
                } else {
                    binding.levelSeven.pauseAnimation();
                    isAnimated=false;
                }
            }
        });

        binding.levelEight.setOnClickListener(new View.OnClickListener() {
            boolean isAnimated=false;
            @Override
            public void onClick(View v) {
                if (!isAnimated){
                    binding.levelEight.playAnimation();
                    binding.levelNine.pauseAnimation();
                    binding.levelTen.pauseAnimation();
                    binding.levelSeven.pauseAnimation();
                    binding.levelSix.pauseAnimation();
                    binding.levelFive.pauseAnimation();
                    binding.levelFour.pauseAnimation();
                    binding.levelThree.pauseAnimation();
                    binding.levelTwo.pauseAnimation();
                    binding.levelOne.pauseAnimation();
                    isAnimated=true;
                } else {
                    binding.levelEight.pauseAnimation();
                    isAnimated=false;
                }
            }
        });

        binding.levelNine.setOnClickListener(new View.OnClickListener() {
            boolean isAnimated=false;
            @Override
            public void onClick(View v) {
                if (!isAnimated){
                    binding.levelNine.playAnimation();
                    binding.levelTen.pauseAnimation();
                    binding.levelEight.pauseAnimation();
                    binding.levelSeven.pauseAnimation();
                    binding.levelSix.pauseAnimation();
                    binding.levelFive.pauseAnimation();
                    binding.levelFour.pauseAnimation();
                    binding.levelThree.pauseAnimation();
                    binding.levelTwo.pauseAnimation();
                    binding.levelOne.pauseAnimation();
                    isAnimated=true;
                } else {
                    binding.levelNine.pauseAnimation();
                    isAnimated=false;
                }
            }
        });

        binding.levelTen.setOnClickListener(new View.OnClickListener() {
            boolean isAnimated=false;
            @Override
            public void onClick(View v) {
                if (!isAnimated){
                    binding.levelTen.playAnimation();
                    binding.levelNine.pauseAnimation();
                    binding.levelEight.pauseAnimation();
                    binding.levelSeven.pauseAnimation();
                    binding.levelSix.pauseAnimation();
                    binding.levelFive.pauseAnimation();
                    binding.levelFour.pauseAnimation();
                    binding.levelThree.pauseAnimation();
                    binding.levelTwo.pauseAnimation();
                    binding.levelOne.pauseAnimation();
                    isAnimated=true;
                } else {
                    binding.levelTen.pauseAnimation();
                    isAnimated=false;
                }
            }
        });
    }


    @Override
    public void onBackPressed() {
        Intent intent= new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);
        CustomIntent.customType(LevelsActivity.this,"fadein-to-fadeout");
        finish();
    }
}
