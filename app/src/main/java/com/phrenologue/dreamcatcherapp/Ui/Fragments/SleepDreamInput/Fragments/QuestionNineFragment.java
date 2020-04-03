package com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments;

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
import com.phrenologue.dreamcatcherapp.databinding.FragmentQuestionNineBinding;
import com.phrenologue.dreamcatcherapp.presenters.QuestionnairePresenter;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionNineFragment extends Fragment {

    private FragmentQuestionNineBinding binding;
    private AppCompatCheckBox yesBtn, notSureBtn, noBtn;
    private int questionNo;
    private QuestionnairePresenter presenter;

    public QuestionNineFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentQuestionNineBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        presenter = new QuestionnairePresenter();
        yesBtn = binding.checkboxYesBtn;
        notSureBtn = binding.checkboxNotSureBtn;
        noBtn = binding.checkboxNoBtn;
        questionNo = 9;

        presenter.saveAns(questionNo,yesBtn,notSureBtn,noBtn);

        binding.questionNine.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionNineTitle.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionNine.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
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

        binding.btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();;
                QuestionEightFragment fragment = new QuestionEightFragment();
                transaction.replace(R.id.your_placeholder, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                container.removeAllViews();
            }
        });

        return view;
    }
}
