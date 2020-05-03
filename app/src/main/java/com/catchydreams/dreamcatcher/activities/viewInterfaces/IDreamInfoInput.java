package com.catchydreams.dreamcatcher.activities.viewInterfaces;

import androidx.appcompat.widget.AppCompatEditText;

import com.catchydreams.dreamcatcher.ui.customFont.MoonTextView;

public interface IDreamInfoInput {
    void setPersianTypeFace();
    void setTitleFonts(MoonTextView title);
    void setHintFonts(MoonTextView hint);
    void setSubscriptFonts(MoonTextView subscript);
    void setEditTextHintFonts(AppCompatEditText editTextHint);
    void onError();
}
