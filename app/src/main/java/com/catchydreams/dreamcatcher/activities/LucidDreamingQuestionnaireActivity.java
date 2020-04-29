package com.catchydreams.dreamcatcher.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.catchydreams.dreamcatcher.R;
import com.catchydreams.dreamcatcher.activities.viewInterfaces.IQuestionnaire;
import com.catchydreams.dreamcatcher.databinding.ActivityLucidDreamingQuestionnaireBinding;
import com.catchydreams.dreamcatcher.presenters.QuestionnairePresenter;
import com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionOneFragment;

import java.util.Locale;

import maes.tech.intentanim.CustomIntent;

public class LucidDreamingQuestionnaireActivity extends FragmentActivity implements IQuestionnaire {

    private ActivityLucidDreamingQuestionnaireBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityLucidDreamingQuestionnaireBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();
        setContentView(view);
        SharedPreferences languagePrefs = getSharedPreferences("languages", MODE_PRIVATE);
        String languageToLoad = languagePrefs.getString("language", "en");
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());

        QuestionnairePresenter presenter = new QuestionnairePresenter(this);
        Intent intent = getIntent();
        boolean changed = intent.getBooleanExtra("languageChanged", false);
        boolean languageChanged = presenter.onLanguageChanged(changed);

        presenter.setTypeFace(languagePrefs);

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

    @Override
    public void setPersianTypeFace() {
        Typeface fontTitle = Typeface.createFromAsset(this.getAssets(), "fonts/kalameh_black.ttf");
        Typeface fontSubTitle = Typeface.createFromAsset(this.getAssets(), "fonts/kalameh_bold.ttf");

        binding.hintQuestionnaire.setTypeface(fontSubTitle);
        binding.hintQuestionnaire.setTextSize(20f);
    }

    @Override
    public void setPersianFontSize() {

    }

    @Override
    public void setEnglishTypeFace() {

    }

    @Override
    public void onLanguageChanged() {
        this.recreate();
    }
}
