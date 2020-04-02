package com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.phrenologue.dreamcatcherapp.databinding.FragmentQuestionFifteenBinding;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFifteenFragment extends Fragment {

    private FragmentQuestionFifteenBinding binding;

    public QuestionFifteenFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentQuestionFifteenBinding.inflate(inflater, container, false);
        View view= binding.getRoot();

        binding.questionFifteen.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionFifteenTitle.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionFifteen.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);

        return view;
    }
}
