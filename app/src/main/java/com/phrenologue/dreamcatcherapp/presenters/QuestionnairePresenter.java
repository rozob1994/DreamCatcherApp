package com.phrenologue.dreamcatcherapp.presenters;

import android.view.View;

import androidx.appcompat.widget.AppCompatCheckBox;

import com.phrenologue.dreamcatcherapp.parameters.QuestionnaireEntry;

public class QuestionnairePresenter {

    public QuestionnairePresenter(){}

    public void saveAns(int qNumber, AppCompatCheckBox yesBtn, AppCompatCheckBox notSureBtn,
                        AppCompatCheckBox noBtn){

        QuestionnaireEntry entry = QuestionnaireEntry.getInstance();

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notSureBtn.setChecked(false);
                noBtn.setChecked(false);
                entry.setAns(qNumber,2);
            }
        });

        notSureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yesBtn.setChecked(false);
                noBtn.setChecked(false);
                entry.setAns(qNumber,1);
            }
        });

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yesBtn.setChecked(false);
                notSureBtn.setChecked(false);
                entry.setAns(qNumber,0);
            }
        });
    }

}
