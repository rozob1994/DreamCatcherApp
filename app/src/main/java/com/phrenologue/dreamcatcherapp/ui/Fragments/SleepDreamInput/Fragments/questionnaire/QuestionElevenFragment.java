package com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.questionnaire;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.activities.viewInterfaces.IQuestionnaire;
import com.phrenologue.dreamcatcherapp.constants.PersianFont;
import com.phrenologue.dreamcatcherapp.databinding.FragmentQuestionElevenBinding;
import com.phrenologue.dreamcatcherapp.presenters.QuestionnairePresenter;

import java.util.Objects;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionElevenFragment extends Fragment implements IQuestionnaire {

    private FragmentQuestionElevenBinding binding;
    private AppCompatCheckBox yesBtn, notSureBtn, noBtn;
    private int questionNo;
    private QuestionnairePresenter presenter;

    public QuestionElevenFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentQuestionElevenBinding.inflate(inflater,container,false);
        View view= binding.getRoot();

        SharedPreferences sp = Objects.requireNonNull(getContext()).getSharedPreferences("questionnaire",
                Context.MODE_PRIVATE);
        presenter = new QuestionnairePresenter(this);
        yesBtn = binding.checkboxYesBtn;
        notSureBtn = binding.checkboxNotSureBtn;
        noBtn = binding.checkboxNoBtn;
        questionNo = 11;
        SharedPreferences languagePrefs = getContext().getSharedPreferences("languages", Context.MODE_PRIVATE);
        presenter.setTypeFace(languagePrefs);
        if (sp.getBoolean("hasAns" + questionNo + "", false)) {
            presenter.loadAns(sp, questionNo, yesBtn, notSureBtn, noBtn);
        }

        presenter.saveAns(sp, questionNo,yesBtn,notSureBtn,noBtn);

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();;
                QuestionTwelveFragment fragment = new QuestionTwelveFragment();
                transaction.replace(R.id.your_placeholder, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                container.removeAllViews();
            }
        });

        binding.btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();;
                QuestionTenFragment fragment = new QuestionTenFragment();
                transaction.replace(R.id.your_placeholder, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                container.removeAllViews();
            }
        });

        return view;
    }

    @Override
    public void setPersianTypeFace() {
        Typeface fontTitle = Typeface.createFromAsset(getContext().getAssets(), PersianFont.title);
        Typeface fontSubTitle = Typeface.createFromAsset(getContext().getAssets(), PersianFont.subTitle);
        binding.questionElevenTitle.setTypeface(fontTitle);
        binding.questionEleven.setTypeface(fontSubTitle);
        binding.checkboxYesBtn.setTypeface(fontTitle);
        binding.checkboxNoBtn.setTypeface(fontTitle);
        binding.checkboxNotSureBtn.setTypeface(fontTitle);
        binding.btnNext.setTypeface(fontTitle);
        binding.btnPrev.setTypeface(fontTitle);
    }

    @Override
    public void setPersianFontSize() {
        binding.questionElevenTitle.setTextSize(PersianFont.large);
        binding.questionEleven.setTextSize(PersianFont.normalLarge);
        binding.checkboxYesBtn.setTextSize(PersianFont.normal);
        binding.checkboxNoBtn.setTextSize(PersianFont.normal);
        binding.checkboxNotSureBtn.setTextSize(PersianFont.normal);
        binding.btnNext.setTextSize(PersianFont.normal);
        binding.btnPrev.setTextSize(PersianFont.normal);
    }

    @Override
    public void setEnglishTypeFace() {
        binding.questionEleven.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionElevenTitle.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionEleven.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
    }

    @Override
    public void onLanguageChanged() {

    }
}
