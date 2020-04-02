package com.phrenologue.dreamcatcherapp.Ui.costumeDialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;

import androidx.appcompat.widget.AppCompatButton;

import com.phrenologue.dreamcatcherapp.Activities.DreamChoosingActivity;
import com.phrenologue.dreamcatcherapp.Activities.ProfileActivity;
import com.phrenologue.dreamcatcherapp.R;

public class ViewDialog {

    private Context context;

    public void showDialog(Activity activity, Context context, String msg){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        this.context = context;

        AppCompatButton addButton =dialog.findViewById(R.id.btn_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DreamChoosingActivity.class);
                context.startActivity(intent);
            }
        });
        AppCompatButton returnButton= dialog.findViewById(R.id.btn_return);
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
