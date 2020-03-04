package com.phrenologue.dreamcatcherapp.Ui.costumeFont;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class MoonTextView extends AppCompatTextView {
    public MoonTextView(Context context) {
        super(context);
        setFont(context);
    }

    public MoonTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public MoonTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }

    private void setFont(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/sofiapro-light.otf");
        setTypeface(typeface);
    }

}
