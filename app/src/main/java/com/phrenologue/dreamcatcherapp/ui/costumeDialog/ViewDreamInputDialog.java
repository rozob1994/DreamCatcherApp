package com.phrenologue.dreamcatcherapp.ui.costumeDialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;

import androidx.appcompat.widget.AppCompatButton;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.activities.DreamsPackagesActivity;
import com.phrenologue.dreamcatcherapp.activities.LucidDreamingQuestionnaireActivity;
import com.phrenologue.dreamcatcherapp.parameters.QuestionnaireEntry;

public class ViewDreamInputDialog {

    private Context context;
    SharedPreferences sp;

    public void showDialog(Activity activity, Context context, String msg) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dream_input_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        this.context = context;

        sp = context.getSharedPreferences("dreamChoosing", Context.MODE_PRIVATE);
        QuestionnaireEntry entry = QuestionnaireEntry.getInstance();
        int res = Math.round(entry.getResultPercentage());
        String result = "%" + res + "";

        AppCompatButton yesButton = dialog.findViewById(R.id.btn_yes);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LucidDreamingQuestionnaireActivity.class);
                context.startActivity(intent);
            }
        });

        AppCompatButton noButton = dialog.findViewById(R.id.btn_no);
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DreamsPackagesActivity.class);
                context.startActivity(intent);
            }
        });
        dialog.show();
    }


}
