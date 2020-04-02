package com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.phrenologue.dreamcatcherapp.databinding.FragmentQuestionTenBinding;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionTenFragment extends Fragment {

    private FragmentQuestionTenBinding binding;

    public QuestionTenFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentQuestionTenBinding.inflate(inflater, container, false);
        View view= binding.getRoot();

        binding.questionTen.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionTenTitle.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionTen.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);

        return view;
    }
}
