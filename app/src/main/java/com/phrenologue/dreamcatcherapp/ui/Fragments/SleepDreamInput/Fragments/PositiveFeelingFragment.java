package com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.phrenologue.dreamcatcherapp.databinding.FragmentPositiveFeelingBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class PositiveFeelingFragment extends Fragment {

    private FragmentPositiveFeelingBinding binding;

    public PositiveFeelingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentPositiveFeelingBinding.inflate(inflater, container, false);
        View view= binding.getRoot();



        return view;
    }
}
