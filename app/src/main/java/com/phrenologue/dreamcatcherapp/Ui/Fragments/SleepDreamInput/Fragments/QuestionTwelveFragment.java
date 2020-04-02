package com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.phrenologue.dreamcatcherapp.databinding.FragmentQuestionTwelveBinding;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionTwelveFragment extends Fragment {

    private FragmentQuestionTwelveBinding binding;

    public QuestionTwelveFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentQuestionTwelveBinding.inflate(inflater, container, false);
        View view= binding.getRoot();

        binding.questionTwelve.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionTwelveTitle.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionTwelve.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);

        return view;
    }
}
