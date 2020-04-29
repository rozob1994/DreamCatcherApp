package com.catchydreams.dreamcatcher.ui.customDialog.dialogViews;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;

import androidx.appcompat.widget.AppCompatButton;

import com.catchydreams.dreamcatcher.R;
import com.catchydreams.dreamcatcher.activities.DreamsPackagesActivity;
import com.catchydreams.dreamcatcher.activities.LucidDreamingQuestionnaireActivity;
import com.catchydreams.dreamcatcher.constants.PersianFont;
import com.catchydreams.dreamcatcher.parameters.QuestionnaireEntry;
import com.catchydreams.dreamcatcher.parameters.postParameters.majorParameters.Dream;
import com.catchydreams.dreamcatcher.parameters.postParameters.majorParameters.Sleep;
import com.catchydreams.dreamcatcher.ui.customFont.MoonTextView;

public class ViewDreamInputDialog {

    private Context context;
    private SharedPreferences sp, sp2, languagePrefs;


    public void showDialog(Activity activity, Context context, SharedPreferences.Editor dreamPref,
                           SharedPreferences.Editor dreamPrefTwo) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dream_input_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        this.context = context;
        AppCompatButton btnYes = dialog.findViewById(R.id.btn_yes);
        AppCompatButton btnNo = dialog.findViewById(R.id.btn_no);
        sp = context.getSharedPreferences("dreamChoosing", Context.MODE_PRIVATE);
        sp2 = context.getSharedPreferences("dreamToLucidityQuestionnaire", Context.MODE_PRIVATE);
        languagePrefs = context.getSharedPreferences("languages", Context.MODE_PRIVATE);
        QuestionnaireEntry entry = QuestionnaireEntry.getInstance();
        int res = Math.round(entry.getResultPercentage());
        String result = "%" + res + "";
        String language = languagePrefs.getString("language", "en");
        if (language.equals("fa")) {
            Typeface text = Typeface.createFromAsset(context.getAssets(), PersianFont.subTitle);
            Typeface btnText = Typeface.createFromAsset(context.getAssets(), PersianFont.title);
            MoonTextView percentage = dialog.findViewById(R.id.txt_percentage);
            percentage.setTypeface(text);
            btnYes.setTypeface(btnText);
            btnYes.setTextSize(PersianFont.normalLarge);
            btnNo.setTypeface(btnText);
            btnNo.setTextSize(PersianFont.normalLarge);
        }

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp2.edit().putBoolean("fromDream", true).apply();
                Intent intent = new Intent(context, LucidDreamingQuestionnaireActivity.class);
                context.startActivity(intent);
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dreamPref.clear().apply();
                dreamPrefTwo.clear().apply();
                Dream.delDream();
                Sleep.delSleep();
                Intent intent = new Intent(context, DreamsPackagesActivity.class);
                context.startActivity(intent);
            }
        });
        dialog.show();
    }

}
