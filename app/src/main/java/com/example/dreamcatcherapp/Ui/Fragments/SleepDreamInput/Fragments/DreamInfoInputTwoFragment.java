package com.example.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.fragment.app.Fragment;

import com.example.dreamcatcherapp.R;
import com.example.dreamcatcherapp.databinding.FragmentDreamInfoInputTwoBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class DreamInfoInputTwoFragment extends Fragment implements Animation.AnimationListener {


    private FragmentDreamInfoInputTwoBinding binding;
    Animation fade_in;
    final int[] state = {0};

    public DreamInfoInputTwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDreamInfoInputTwoBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        fade_in = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);
        fade_in.setAnimationListener(this);


        binding.buttonTagsOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (state[0] == 1) {
                    binding.buttonTagsOff.setBackgroundResource(R.drawable.button_tags_off);
                    state[0] = 0;

                } else {
                    binding.buttonTagsOff.setBackgroundResource(R.drawable.button_tags_pushed);
                    state[0] = 1;

                }
            }
        });

        return view;
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
