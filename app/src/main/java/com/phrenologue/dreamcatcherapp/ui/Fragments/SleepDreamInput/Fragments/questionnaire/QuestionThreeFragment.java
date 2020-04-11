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
import com.phrenologue.dreamcatcherapp.databinding.FragmentQuestionThreeBinding;
import com.phrenologue.dreamcatcherapp.presenters.QuestionnairePresenter;

import java.util.Objects;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionThreeFragment extends Fragment {

    private FragmentQuestionThreeBinding binding;
    private AppCompatCheckBox yesBtn, notSureBtn, noBtn;
    private int questionNo;
    private QuestionnairePresenter presenter;

    public QuestionThreeFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentQuestionThreeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        SharedPreferences sp = Objects.requireNonNull(getContext()).getSharedPreferences("questionnaire",
                Context.MODE_PRIVATE);
        presenter = new QuestionnairePresenter();
        yesBtn = binding.checkboxYesBtn;
        notSureBtn = binding.checkboxNotSureBtn;
        noBtn = binding.checkboxNoBtn;
        questionNo = 3;

        if (sp.getBoolean("hasAns" + questionNo + "", false)) {
            presenter.loadAns(sp, questionNo, yesBtn, notSureBtn, noBtn);
        }

        presenter.saveAns(sp, questionNo,yesBtn,notSureBtn,noBtn);

        binding.questionThree.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionThreeTitle.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionThree.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();;
                QuestionFourFragment fragment = new QuestionFourFragment();
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
                QuestionTwoFragment fragment = new QuestionTwoFragment();
                transaction.replace(R.id.your_placeholder, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                container.removeAllViews();
            }
        });

        return view;
    }
}
