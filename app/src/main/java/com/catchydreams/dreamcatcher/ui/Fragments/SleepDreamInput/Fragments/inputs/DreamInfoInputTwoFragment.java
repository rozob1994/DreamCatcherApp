package com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Fragments.inputs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.catchydreams.dreamcatcher.R;
import com.catchydreams.dreamcatcher.activities.DreamsPackagesActivity;
import com.catchydreams.dreamcatcher.activities.viewInterfaces.IDreamInfoInput;
import com.catchydreams.dreamcatcher.constants.PersianFont;
import com.catchydreams.dreamcatcher.database.Database;
import com.catchydreams.dreamcatcher.database.user.UserEntity;
import com.catchydreams.dreamcatcher.databinding.FragmentDreamInfoInputTwoBinding;
import com.catchydreams.dreamcatcher.parameters.Users;
import com.catchydreams.dreamcatcher.parameters.dateParameters.parameters.Date;
import com.catchydreams.dreamcatcher.presenters.DreamInputPresenter;
import com.catchydreams.dreamcatcher.ui.customFont.MoonTextView;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import maes.tech.intentanim.CustomIntent;

/**
 * A simple {@link Fragment} subclass.
 */
public class DreamInfoInputTwoFragment extends Fragment implements IDreamInfoInput {

    DreamInputPresenter presenter;
    private FragmentDreamInfoInputTwoBinding binding;
    AppCompatEditText title, content, interpretation;
    Spinner day, month, year;
    SharedPreferences sleepPrefs, dreamOne, dreamTwo, dreamToLuciditySp;

    public DreamInfoInputTwoFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDreamInfoInputTwoBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        presenter = new DreamInputPresenter(this);
        title = binding.edtTextTitle;
        content = binding.edtTxtContent;
        interpretation = binding.edtTxtInterpretation;
        day = binding.spinnerDay;
        month = binding.spinnerMonth;
        year = binding.spinnerYear;
        sleepPrefs = getContext().getSharedPreferences("sleep", Context.MODE_PRIVATE);
        dreamOne = getContext().getSharedPreferences("dream", Context.MODE_PRIVATE);
        dreamTwo = getContext().getSharedPreferences("dreamTwo", Context.MODE_PRIVATE);
        dreamToLuciditySp = getContext().getSharedPreferences("dreamToLucidityQuestionnaire",
                Context.MODE_PRIVATE);
        SharedPreferences languagePrefs = getContext().getSharedPreferences("languages",
                Context.MODE_PRIVATE);
        presenter.setPersianTypeFace(languagePrefs);
        String dateStr = Calendar.getInstance().getTime().toString();
        List<String> dateProps = Arrays.asList(dateStr.split(" "));
        int dayInt = Integer.parseInt(dateProps.get(2));
        Integer monthInt = Date.monthStrToInt(dateProps.get(1));

        if (dreamTwo.getBoolean("descriptionTitleExists", false)) {
            title.setText(dreamTwo.getString("descriptionTitle", ""));
        }

        if (dreamTwo.getBoolean("descriptionExists", false)) {
            content.setText(dreamTwo.getString("description", ""));
        }

        if (dreamTwo.getBoolean("interpretationExists", false)) {
            interpretation.setText(dreamTwo.getString("interpretation", ""));
        }

        if (dreamTwo.getBoolean("dayIndExists", false)) {
            day.setSelection(dreamTwo.getInt("dayInd", 0));
        } else {
            day.setSelection(dayInt-1);
        }

        if (dreamTwo.getBoolean("monthIndExists", false)) {
            month.setSelection(dreamTwo.getInt("monthInd", 0));
        } else {
            month.setSelection(monthInt-1);
        }

        if (dreamTwo.getBoolean("yearIndExists", false)) {
            year.setSelection(dreamTwo.getInt("yearInd", 0));
        } else {
            year.setSelection(year.getFirstVisiblePosition());
        }
        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[BUTTON]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//
        presenter.setTextListener("descriptionTitle", title, dreamTwo);
        presenter.setTextListener("description", content, dreamTwo);
        presenter.setTextListener("interpretation", interpretation, dreamTwo);

        presenter.saveSpinnerIndex("dayInd", day, dreamTwo);
        presenter.saveSpinnerIndex("monthInd", month, dreamTwo);
        Log.e("","");
        presenter.saveSpinnerIndex("yearInd", year, dreamTwo);


        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences databasePrefs = getContext().getSharedPreferences("database", Context.MODE_PRIVATE);
                databasePrefs.edit().putBoolean("changed", true).apply();
                dreamToLuciditySp.edit().putBoolean("fromDream", false).apply();
                Users user = Users.getInstance();
                user.checkSetLevelChange(getContext());
                if(user.isLevelChanged()) {
                    Database db = Database.getInstance(getContext());
                    db.userDao().updateUser(new UserEntity(languagePrefs.getString("language","en")));
                }

                sleepPrefs.edit().clear().apply();
                presenter.saveCompleteDream(getActivity(), getContext(), interpretation,
                        title, content, day, month, year,
                        dreamOne.edit(), dreamTwo.edit());


            }
        });

        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sleepPrefs.edit().clear().apply();
                dreamOne.edit().clear().apply();
                dreamTwo.edit().clear().apply();
                Intent intent = new Intent(v.getContext(), DreamsPackagesActivity.class);
                startActivity(intent);
                CustomIntent.customType(getContext(), "fadein-to-fadeout");

            }
        });

        binding.prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                DreamInfoInputOneFragment fragment = new DreamInfoInputOneFragment();
                transaction.replace(R.id.dream_adding_frame, fragment);
                transaction.commit();
                container.removeAllViews();
            }
        });

        return view;
    }

    @Override
    public void setPersianTypeFace() {
        Typeface fontTitle = Typeface.createFromAsset(getContext().getAssets(), PersianFont.title);



        List<MoonTextView> titles = Arrays.asList(binding.titleDreamInfo, binding.titleDate,
                binding.titleSub, binding.descriptionTitle,
                binding.titleInterpretation);

        presenter.setTitleFonts(titles);

        List<MoonTextView> hints = Arrays.asList(binding.descriptionHint, binding.hintInterpretation);

        presenter.setHintFonts(hints);

        List<AppCompatEditText> editTexts = Arrays.asList(binding.edtTextTitle, binding.edtTxtContent,
                binding.edtTxtInterpretation);

        presenter.setEditTextFonts(editTexts);

        binding.btnSubmit.setTypeface(fontTitle);
        binding.btnSubmit.setTextSize(PersianFont.large);
        binding.prevBtn.setTypeface(fontTitle);
        binding.prevBtn.setTextSize(PersianFont.large);
    }

    @Override
    public void setTitleFonts(MoonTextView title) {
        Typeface fontTitle = Typeface.createFromAsset(getContext().getAssets(), PersianFont.title);
        title.setTypeface(fontTitle);
        title.setTextSize(PersianFont.normalLarge);
    }

    @Override
    public void setHintFonts(MoonTextView hint) {
        Typeface fontSubTitle = Typeface.createFromAsset(getContext().getAssets(), PersianFont.subTitle);
        hint.setTypeface(fontSubTitle);
        hint.setTextSize(PersianFont.normal);
    }

    @Override
    public void setSubscriptFonts(MoonTextView subscript) {

    }

    @Override
    public void setEditTextHintFonts(AppCompatEditText editTextHint) {
        Typeface fontReg = Typeface.createFromAsset(getContext().getAssets(), PersianFont.regular);
        editTextHint.setTypeface(fontReg);
        editTextHint.setTextSize(PersianFont.normal);
    }
}
