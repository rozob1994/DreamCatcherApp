package com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.FragmentQuestionOneBinding;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionOneFragment extends Fragment {

    private FragmentQuestionOneBinding binding;

    public QuestionOneFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQuestionOneBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.questionOne.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionOneTitle.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionOne.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                QuestionTwoFragment fragment = new QuestionTwoFragment();
                transaction.replace(R.id.questions_vp, fragment);
                transaction.commit();
                container.removeAllViews();
            }
        });

        return view;

    }
}
