package com.phrenologue.dreamcatcherapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.ActivityLucidDreamingQuestionnaireBinding;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionOneFragment;

import maes.tech.intentanim.CustomIntent;

public class LucidDreamingQuestionnaireActivity extends FragmentActivity {

    private ActivityLucidDreamingQuestionnaireBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityLucidDreamingQuestionnaireBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();
        setContentView(view);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.your_placeholder, new QuestionOneFragment());

        ft.commit();


        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
                CustomIntent.customType(LucidDreamingQuestionnaireActivity.this,"fadein-to-fadeout");
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        SharedPreferences sp = getSharedPreferences("questionnaire", MODE_PRIVATE);
        sp.edit().clear().apply();
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);
        CustomIntent.customType(LucidDreamingQuestionnaireActivity.this, "fadein-to-fadeout");
        finish();
    }
}
