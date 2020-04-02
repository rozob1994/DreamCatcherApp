package com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.phrenologue.dreamcatcherapp.databinding.FragmentQuestionSixBinding;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionSixFragment extends Fragment {

    private FragmentQuestionSixBinding binding;

    public QuestionSixFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentQuestionSixBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        binding.questionSix.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionSixTitle.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionSix.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);

        return view;
    }
}
