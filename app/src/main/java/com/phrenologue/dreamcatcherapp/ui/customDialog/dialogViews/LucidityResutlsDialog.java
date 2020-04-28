package com.phrenologue.dreamcatcherapp.ui.customDialog.dialogViews;

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

import com.phrenologue.dreamcatcherapp.activities.DreamChoosingActivity;
import com.phrenologue.dreamcatcherapp.activities.ExpandedDreamActivity;
import com.phrenologue.dreamcatcherapp.activities.ProfileActivity;
import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.constants.PersianFont;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;
import com.phrenologue.dreamcatcherapp.ui.customFont.MoonTextView;
import com.phrenologue.dreamcatcherapp.parameters.QuestionnaireEntry;

public class LucidityResutlsDialog {

    private Context context;
    MoonTextView percentage, preResult, warning;
    AppCompatButton back, add;
    SharedPreferences sp, sp2, languagePrefs;

    public void showDialog(Activity activity, Context context, String msg) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        this.context = context;
        percentage = dialog.findViewById(R.id.txt_percentage);
        preResult = dialog.findViewById(R.id.preResult);
        warning = dialog.findViewById(R.id.warning);
        back = dialog.findViewById(R.id.btn_return);
        add = dialog.findViewById(R.id.btn_add);
        languagePrefs = context.getSharedPreferences("languages", Context.MODE_PRIVATE);
        sp = context.getSharedPreferences("dreamChoosing", Context.MODE_PRIVATE);
        sp2 = context.getSharedPreferences("dreamToLucidityQuestionnaire", Context.MODE_PRIVATE);
        boolean fromDream = sp2.getBoolean("fromDream", false);
        QuestionnaireEntry entry = QuestionnaireEntry.getInstance();
        int res = Math.round(entry.getResultPercentage());
        String result = "%" + res + "";
        percentage.setText(result);
        String language = languagePrefs.getString("language", "en");
        if (language.equals("fa")) {
            Typeface textFont = Typeface.createFromAsset(context.getAssets(), PersianFont.subTitle);
            Typeface boldFont = Typeface.createFromAsset(context.getAssets(), PersianFont.title);
            percentage.setTypeface(boldFont);
            preResult.setTypeface(textFont);
            preResult.setTextSize(PersianFont.normalSmall);
            warning.setTypeface(textFont);
            warning.setTextSize(PersianFont.normalSmall);
            back.setTypeface(boldFont);
            back.setTextSize(PersianFont.normalLarge);
            add.setTypeface(boldFont);
            add.setTextSize(PersianFont.normalLarge);
        }
        if (fromDream) {
            add.setText(R.string.back_to_dream);
        }
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fromDream) {
                    sp2.edit().clear().apply();
                    Intent intent = new Intent(context, ExpandedDreamActivity.class);
                    intent.putExtra("postId", Dream.getInstance().getPostId());
                    context.startActivity(intent);
                } else {
                    sp.edit().putBoolean("fromLucidityQuestionnaire", true).apply();
                    Intent intent = new Intent(context, DreamChoosingActivity.class);
                    context.startActivity(intent);
                }

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProfileActivity.class);
                context.startActivity(intent);
            }
        });
        dialog.show();
    }


}
