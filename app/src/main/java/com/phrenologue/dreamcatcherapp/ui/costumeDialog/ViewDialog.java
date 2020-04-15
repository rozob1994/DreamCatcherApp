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

import com.phrenologue.dreamcatcherapp.activities.DreamChoosingActivity;
import com.phrenologue.dreamcatcherapp.activities.ExpandedDreamActivity;
import com.phrenologue.dreamcatcherapp.activities.ProfileActivity;
import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;
import com.phrenologue.dreamcatcherapp.ui.costumeFont.MoonTextView;
import com.phrenologue.dreamcatcherapp.parameters.QuestionnaireEntry;

public class ViewDialog {

    private Context context;
    MoonTextView percentage;
    SharedPreferences sp, sp2;

    public void showDialog(Activity activity, Context context, String msg) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        this.context = context;

        percentage = dialog.findViewById(R.id.txt_percentage);
        sp = context.getSharedPreferences("dreamChoosing", Context.MODE_PRIVATE);
        sp2 = context.getSharedPreferences("dreamToLucidityQuestionnaire", Context.MODE_PRIVATE);
        boolean fromDream = sp2.getBoolean("fromDream", false);
        QuestionnaireEntry entry = QuestionnaireEntry.getInstance();
        int res = Math.round(entry.getResultPercentage());
        String result = "%" + res + "";
        percentage.setText(result);
        AppCompatButton addButton = dialog.findViewById(R.id.btn_add);
        if (fromDream) {
            addButton.setText("Back to Dream");
        }
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fromDream){
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
        AppCompatButton returnButton = dialog.findViewById(R.id.btn_return);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProfileActivity.class);
                context.startActivity(intent);
            }
        });
        dialog.show();
    }


}
