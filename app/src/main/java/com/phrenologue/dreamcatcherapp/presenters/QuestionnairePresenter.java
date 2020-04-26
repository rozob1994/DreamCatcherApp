package com.phrenologue.dreamcatcherapp.presenters;

import android.content.SharedPreferences;
import android.view.View;

import androidx.appcompat.widget.AppCompatCheckBox;

import com.phrenologue.dreamcatcherapp.activities.viewInterfaces.IQuestionnaire;
import com.phrenologue.dreamcatcherapp.parameters.QuestionnaireEntry;

public class QuestionnairePresenter {
    private IQuestionnaire iQuestionnaire;
    public QuestionnairePresenter(IQuestionnaire iQuestionnaire) {
        this.iQuestionnaire = iQuestionnaire;
    }

    public void setTypeFace(SharedPreferences languagePrefs) {
        String language = languagePrefs.getString("language", "");
        if (language.equals("fa")){
            iQuestionnaire.setPersianTypeFace();
            iQuestionnaire.setPersianFontSize();
        } else {
            iQuestionnaire.setEnglishTypeFace();
        }
    }

    public void loadAns(SharedPreferences sp, int questionNo, AppCompatCheckBox yesBtn,
                        AppCompatCheckBox notSureBtn,
                        AppCompatCheckBox noBtn) {
        int ans = sp.getInt(questionNo + "", 4);
        switch (ans) {
            case 0:
                noBtn.setChecked(true);
                break;
            case 1:
                notSureBtn.setChecked(true);
                break;
            case 2:
                yesBtn.setChecked(true);
                break;
        }
    }

    public void saveAns(SharedPreferences sp, int qNumber, AppCompatCheckBox yesBtn,
                        AppCompatCheckBox notSureBtn,
                        AppCompatCheckBox noBtn) {

        QuestionnaireEntry entry = QuestionnaireEntry.getInstance();

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.edit().putBoolean("hasAns" + qNumber + "", true).apply(); // Declaring that the question has an answer in shared preferences.
                notSureBtn.setChecked(false);
                noBtn.setChecked(false);
                entry.setAns(qNumber, 2);
                sp.edit().putInt(qNumber + "", 2).apply(); // Saving answers in shared preferences.
            }
        });

        notSureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.edit().putBoolean("hasAns" + qNumber + "", true).apply();
                yesBtn.setChecked(false);
                noBtn.setChecked(false);
                entry.setAns(qNumber, 1);
                sp.edit().putInt(qNumber + "", 1).apply();
            }
        });

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.edit().putBoolean("hasAns" + qNumber + "", true).apply();
                yesBtn.setChecked(false);
                notSureBtn.setChecked(false);
                entry.setAns(qNumber, 0);
                sp.edit().putInt(qNumber + "", 0).apply();
            }
        });
    }

}
