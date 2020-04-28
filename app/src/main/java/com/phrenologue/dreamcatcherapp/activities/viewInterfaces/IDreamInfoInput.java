package com.phrenologue.dreamcatcherapp.activities.viewInterfaces;

import androidx.appcompat.widget.AppCompatEditText;

import com.phrenologue.dreamcatcherapp.ui.customFont.MoonTextView;

public interface IDreamInfoInput {
    void setPersianTypeFace();
    void setTitleFonts(MoonTextView title);
    void setHintFonts(MoonTextView hint);
    void setSubscriptFonts(MoonTextView subscript);
    void setEditTextHintFonts(AppCompatEditText editTextHint);
}
