package com.phrenologue.dreamcatcherapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.activities.viewInterfaces.IProfileView;
import com.phrenologue.dreamcatcherapp.databinding.ActivitySelectLanguageBinding;
import com.phrenologue.dreamcatcherapp.presenters.ProfilePresenter;

import java.util.Locale;

public class SelectLanguageActivity extends AppCompatActivity {

    private ActivitySelectLanguageBinding binding;
    private ProfilePresenter profilePresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectLanguageBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        IProfileView iProfileView = new ProfileActivity();
        /** In khat payini ye folder misaze tooye fazaye majazie sharedpreferences be esme languages
         * ke toosh save mikonim ke preference user chie, mikhad barname english bashe ya farsi. **/

        SharedPreferences sp = getSharedPreferences("languages", MODE_PRIVATE);
        sp.edit().clear().apply();
        binding.radioButtonEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** too in khat payini migim ke age user dokmeye english ro zad, tarjihesh englisie.
                *
                 * putBoolean ke gozashtam baraye ine ke badan age javabesho taqir dad be farsi
                 * in english true namoone.
                 *
                 * SharedPreferences ye folderie ke didi chejuri sakhte mishe o toosh harchi ke
                 * bekhay mitooni put koni.
                 *
                 * Vaqti mikhay chizi tooye in folder bezari, bayad aval benevisi EsmeSharedPreferences.edit().
                 *
                 * Masalan inja man putString gozashtam vali mitoone putInteger bashe ya putBoolean, etc.
                 *
                 * Bad as dasture put tooye parantez esme chizi ke mikhay put koni ro be surate
                 * String minevisi va bad chizi ke mikhay put koni ro mizari:
                 *
                 * Masalan man inja esme Stringi ke mikhastam save konam ro gozashtam language va
                 * valuesh ro ham gozashtam "en".
                 *
                 * Bad az inke put ro neveshti hatman bayad .apply ro bezari vagarna save nemishe.**/
                sp.edit().putBoolean("justChanged", true).apply();
                sp.edit().putBoolean("packagesLanguageChanged", true).apply();
                String languageToLoad  = "en";
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                sp.edit().putString("language", "en").apply();
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
                finishAffinity();

            }
        });

        binding.radioButtonPersian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Inja ham neveshtam ke age user zad ru dokmeye persian, stringe language "fa"
                 * beshe too foldere sharedPreferences.
                 *
                 * Inja niazi nist setLocale koni chon inja inkaro bokoni app tooye activitye badi
                 * yadesh nemimoone ke to inkaro kardi.
                 * **/
                sp.edit().putBoolean("justChanged", true).apply();
                sp.edit().putBoolean("packagesLanguageChanged", true).apply();
                String languageToLoad  = "fa";
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                sp.edit().putString("language", "fa").apply();
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
                finishAffinity();

            }
        });

    }



}
