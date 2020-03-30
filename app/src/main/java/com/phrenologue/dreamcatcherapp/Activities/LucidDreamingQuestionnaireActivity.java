package com.phrenologue.dreamcatcherapp.Activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Adapters.QuestionnaireAdapter;
import com.phrenologue.dreamcatcherapp.databinding.ActivityLucidDreamingQuestionnaireBinding;

public class LucidDreamingQuestionnaireActivity extends AppCompatActivity {

    private ActivityLucidDreamingQuestionnaireBinding binding;
    QuestionnaireAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityLucidDreamingQuestionnaireBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();
        setContentView(view);

        adapter= new QuestionnaireAdapter(getSupportFragmentManager());
        binding.QuestionsVp.setAdapter(adapter);

    }
}
