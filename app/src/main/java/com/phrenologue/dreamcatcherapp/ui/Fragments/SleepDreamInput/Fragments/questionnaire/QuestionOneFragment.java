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
import com.phrenologue.dreamcatcherapp.databinding.FragmentQuestionOneBinding;
import com.phrenologue.dreamcatcherapp.presenters.QuestionnairePresenter;

import java.util.Objects;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionOneFragment extends Fragment implements IQuestionnaire {

    private FragmentQuestionOneBinding binding;
    private AppCompatCheckBox yesBtn, notSureBtn, noBtn;
    private int questionNo;
    private QuestionnairePresenter presenter;



    public QuestionOneFragment() {
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQuestionOneBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        SharedPreferences sp = Objects.requireNonNull(getContext()).getSharedPreferences("questionnaire",
                Context.MODE_PRIVATE);
        SharedPreferences languagePrefs = getContext().getSharedPreferences("languages",
                Context.MODE_PRIVATE);
        presenter = new QuestionnairePresenter(this);
        presenter.setTypeFace(languagePrefs);
        yesBtn = binding.checkboxYesBtn;
        notSureBtn = binding.checkboxNotSureBtn;
        noBtn = binding.checkboxNoBtn;
        questionNo = 1;

        if (sp.getBoolean("hasAns" + questionNo + "", false)) {
            presenter.loadAns(sp, questionNo, yesBtn, notSureBtn, noBtn);
        }

        presenter.saveAns(sp, questionNo, yesBtn, notSureBtn, noBtn);




        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ;
                QuestionTwoFragment fragment = new QuestionTwoFragment();
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
        Typeface fontTitle = Typeface.createFromAsset(getContext().getAssets(), "fonts/kalameh_black.ttf");
        Typeface fontSubTitle = Typeface.createFromAsset(getContext().getAssets(), "fonts/kalameh_bold.ttf");
        binding.questionOneTitle.setTypeface(fontTitle);
        binding.questionOne.setTypeface(fontSubTitle);
        binding.checkboxYesBtn.setTypeface(fontSubTitle);
        binding.checkboxNoBtn.setTypeface(fontSubTitle);
        binding.checkboxNotSureBtn.setTypeface(fontSubTitle);
        binding.btnNext.setTypeface(fontTitle);
    }

    @Override
    public void setEnglishTypeFace() {
        binding.questionOne.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionOneTitle.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionOne.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
    }
}
