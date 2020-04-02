package com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.phrenologue.dreamcatcherapp.databinding.FragmentQuestionThreeBinding;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionThreeFragment extends Fragment {

    private FragmentQuestionThreeBinding binding;

    public QuestionThreeFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentQuestionThreeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.questionThree.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionThreeTitle.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionThree.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);

        return view;
    }
}
