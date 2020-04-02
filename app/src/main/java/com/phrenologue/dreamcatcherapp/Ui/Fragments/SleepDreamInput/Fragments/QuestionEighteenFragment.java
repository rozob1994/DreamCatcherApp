package com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionEighteenFragment extends Fragment {

    private com.phrenologue.dreamcatcherapp.databinding.FragmentQuestionEighteenBinding binding;

    public QuestionEighteenFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= com.phrenologue.dreamcatcherapp.databinding.FragmentQuestionEighteenBinding.inflate(inflater, container, false);
        View view= binding.getRoot();

        binding.questionEighteen.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionEighteenTitle.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionEighteen.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);

        return view;
    }
}
