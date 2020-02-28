package com.example.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.dreamcatcherapp.databinding.FragmentDreamInfoInputOneBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class DreamInfoInputOneFragment extends Fragment {

    private FragmentDreamInfoInputOneBinding binding;


    public DreamInfoInputOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDreamInfoInputOneBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[PEOPLE BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//


        //---------------------------SWITCHING PEOPLE BUTTON ON---------------------------//

        binding.btnPeopleOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.relPeopleExpanded.getVisibility() == View.VISIBLE) {
                    binding.relPeopleExpanded.setVisibility(View.GONE);
                    binding.relPeopleClosed.setVisibility(View.VISIBLE);
                } else {
                    binding.relPeopleExpanded.setVisibility(View.VISIBLE);
                    binding.relPeopleClosed.setVisibility(View.GONE);
                }
            }
        });
        //---------------------------SWITCHING PEOPLE BUTTON OFF---------------------------//

        binding.btnPeopleOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.relPeopleClosed.getVisibility() == View.VISIBLE) {
                    binding.relPeopleClosed.setVisibility(View.GONE);
                    binding.relPeopleExpanded.setVisibility(View.VISIBLE);
                } else {
                    binding.relPeopleClosed.setVisibility(View.VISIBLE);
                    binding.relPeopleExpanded.setVisibility(View.GONE);
                }
            }
        });

        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[FEELINGS BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //---------------------------SWITCHING POSITIVE BUTTON ON---------------------------//
        binding.linPositiveOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (binding.linPositiveOn.getVisibility() == View.VISIBLE) {
                    binding.linPositiveOn.setVisibility(View.INVISIBLE);
                    binding.linPositiveOff.setVisibility(View.VISIBLE);
                } else {
                    binding.linPositiveOn.setVisibility(View.VISIBLE);
                    binding.linNeutralOn.setVisibility(View.INVISIBLE);
                    binding.linNeutralOff.setVisibility(View.VISIBLE);
                    binding.linNegativeOn.setVisibility(View.INVISIBLE);
                    binding.linNegativeOff.setVisibility(View.VISIBLE);
                    binding.linPositiveOff.setVisibility(View.INVISIBLE);
                }

            }
        });

        //---------------------------SWITCHING POSITIVE BUTTON OFF---------------------------//
        binding.linPositiveOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.linPositiveOff.getVisibility() == View.VISIBLE) {
                    binding.linPositiveOff.setVisibility(View.INVISIBLE);
                    binding.linPositiveOn.setVisibility(View.VISIBLE);
                } else {
                    binding.linPositiveOff.setVisibility(View.VISIBLE);
                    binding.linPositiveOn.setVisibility(View.INVISIBLE);
                    binding.linNegativeOff.setVisibility(View.VISIBLE);
                    binding.linNeutralOff.setVisibility(View.VISIBLE);
                }
            }
        });

        //---------------------------SWITCHING NEUTRAL BUTTON ON---------------------------//

        binding.linNeutralOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.linNeutralOn.getVisibility() == View.VISIBLE) {
                    binding.linNeutralOn.setVisibility(View.INVISIBLE);
                    binding.linNeutralOff.setVisibility(View.VISIBLE);
                } else {
                    binding.linNeutralOn.setVisibility(View.VISIBLE);
                    binding.linPositiveOn.setVisibility(View.INVISIBLE);
                    binding.linPositiveOff.setVisibility(View.VISIBLE);
                    binding.linNegativeOn.setVisibility(View.INVISIBLE);
                    binding.linNegativeOff.setVisibility(View.VISIBLE);
                    binding.linNeutralOff.setVisibility(View.INVISIBLE);
                }
            }
        });
        //---------------------------SWITCHING NEUTRAL BUTTON OFF---------------------------//

        binding.linNeutralOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.linNeutralOff.getVisibility() == View.VISIBLE) {
                    binding.linNeutralOff.setVisibility(View.INVISIBLE);
                    binding.linNeutralOn.setVisibility(View.VISIBLE);
                } else {
                    binding.linNeutralOff.setVisibility(View.VISIBLE);
                    binding.linNeutralOn.setVisibility(View.INVISIBLE);
                    binding.linNegativeOff.setVisibility(View.VISIBLE);
                    binding.linPositiveOff.setVisibility(View.VISIBLE);
                }
            }
        });

        //---------------------------SWITCHING NEGATIVE BUTTON ON---------------------------//
        binding.linNegativeOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.linNegativeOn.getVisibility() == View.VISIBLE) {
                    binding.linNegativeOn.setVisibility(View.INVISIBLE);
                    binding.linNegativeOff.setVisibility(View.VISIBLE);
                } else {
                    binding.linNegativeOn.setVisibility(View.VISIBLE);
                    binding.linPositiveOn.setVisibility(View.INVISIBLE);
                    binding.linPositiveOff.setVisibility(View.VISIBLE);
                    binding.linNeutralOn.setVisibility(View.INVISIBLE);
                    binding.linNeutralOff.setVisibility(View.VISIBLE);
                    binding.linNegativeOff.setVisibility(View.INVISIBLE);
                }
            }
        });

        //---------------------------SWITCHING NEGATIVE BUTTON Off---------------------------//
        binding.linNegativeOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.linNegativeOff.getVisibility() == View.VISIBLE) {
                    binding.linNegativeOff.setVisibility(View.INVISIBLE);
                    binding.linNegativeOn.setVisibility(View.VISIBLE);
                } else {
                    binding.linNegativeOff.setVisibility(View.VISIBLE);
                    binding.linNegativeOn.setVisibility(View.INVISIBLE);
                    binding.linPositiveOff.setVisibility(View.VISIBLE);
                    binding.linNeutralOff.setVisibility(View.VISIBLE);
                }
            }
        });

        return view;


    }
}
