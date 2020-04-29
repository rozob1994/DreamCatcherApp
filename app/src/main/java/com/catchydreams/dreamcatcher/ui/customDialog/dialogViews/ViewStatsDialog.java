package com.catchydreams.dreamcatcher.ui.customDialog.dialogViews;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

import com.catchydreams.dreamcatcher.R;
import com.catchydreams.dreamcatcher.constants.PersianFont;
import com.catchydreams.dreamcatcher.ui.customFont.MoonTextView;

public class ViewStatsDialog {

    Context context;

    public void showDialog (Activity activity, Context context){
        this.context=context;

        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog_stats);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        MoonTextView message = dialog.findViewById(R.id.message);
        SharedPreferences languagePrefs = context.getSharedPreferences("languages",
                context.MODE_PRIVATE);
        String language = languagePrefs.getString("language", "en");
        if (language.equals("fa")) {
            Typeface textFont = Typeface.createFromAsset(context.getAssets(), PersianFont.subTitle);
            message.setTypeface(textFont);
        }
    }


}
