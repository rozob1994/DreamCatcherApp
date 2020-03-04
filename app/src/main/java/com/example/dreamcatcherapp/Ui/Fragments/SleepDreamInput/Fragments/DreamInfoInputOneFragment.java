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


        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[SOUNDS BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //---------------------------SWITCHING SOUNDS BUTTON On---------------------------//

        binding.btnSoundsOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.relSoundsExpanded.getVisibility() == View.VISIBLE) {
                    binding.relSoundsExpanded.setVisibility(View.GONE);
                    binding.relSoundsClosed.setVisibility(View.VISIBLE);
                } else {
                    binding.relSoundsExpanded.setVisibility(View.VISIBLE);
                    binding.relSoundsClosed.setVisibility(View.GONE);
                }
            }
        });
        //---------------------------SWITCHING SOUNDS BUTTON OFF---------------------------//

        binding.btnSoundsOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.relSoundsClosed.getVisibility() == View.VISIBLE) {
                    binding.relSoundsClosed.setVisibility(View.GONE);
                    binding.relSoundsExpanded.setVisibility(View.VISIBLE);
                } else {
                    binding.relSoundsClosed.setVisibility(View.VISIBLE);
                    binding.relSoundsExpanded.setVisibility(View.GONE);
                }
            }
        });

        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[FEELINGS BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

//************************************************************************************************************************************//
//************************************************************************************************************************************//
//************************************************************************************************************************************//
//************************************************************************************************************************************//

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

        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[COLOR BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//


        //---------------------------SWITCHING COLORFUL BUTTON ON---------------------------//

        binding.linColorfulOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.linColorfulOn.getVisibility() == View.VISIBLE) {
                    binding.linColorfulOn.setVisibility(View.INVISIBLE);
                    binding.linColorfulOff.setVisibility(View.VISIBLE);
                } else {
                    binding.linColorfulOn.setVisibility(View.VISIBLE);
                    binding.linGrayscaleOn.setVisibility(View.INVISIBLE);
                    binding.linGrayscaleOff.setVisibility(View.VISIBLE);
                    binding.linColorfulOff.setVisibility(View.INVISIBLE);
                }
            }
        });

        //---------------------------SWITCHING COLORFUL BUTTON OFF---------------------------//

        binding.linColorfulOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.linColorfulOff.getVisibility() == View.VISIBLE) {
                    binding.linColorfulOff.setVisibility(View.INVISIBLE);
                    binding.linColorfulOn.setVisibility(View.VISIBLE);
                } else {
                    binding.linColorfulOff.setVisibility(View.VISIBLE);
                    binding.linColorfulOn.setVisibility(View.INVISIBLE);
                    binding.linGrayscaleOff.setVisibility(View.VISIBLE);
                }
            }
        });

        //---------------------------SWITCHING GRAYSCALE BUTTON ON---------------------------//

        binding.linGrayscaleOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.linGrayscaleOn.getVisibility() == View.VISIBLE) {
                    binding.linGrayscaleOn.setVisibility(View.INVISIBLE);
                    binding.linGrayscaleOff.setVisibility(View.VISIBLE);
                } else {
                    binding.linGrayscaleOn.setVisibility(View.VISIBLE);
                    binding.linColorfulOn.setVisibility(View.INVISIBLE);
                    binding.linColorfulOff.setVisibility(View.VISIBLE);
                    binding.linGrayscaleOff.setVisibility(View.INVISIBLE);
                }
            }
        });

        //---------------------------SWITCHING GRAYSCALE BUTTON OFF---------------------------//

        binding.linGrayscaleOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.linGrayscaleOff.getVisibility() == View.VISIBLE) {
                    binding.linGrayscaleOff.setVisibility(View.INVISIBLE);
                    binding.linGrayscaleOn.setVisibility(View.VISIBLE);
                }else {
                    binding.linGrayscaleOff.setVisibility(View.VISIBLE);
                    binding.linGrayscaleOn.setVisibility(View.INVISIBLE);
                    binding.linColorfulOff.setVisibility(View.VISIBLE);
                }
            }
        });


        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[MUSICAL BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //---------------------------SWITCHING MUSICAL BUTTON ON---------------------------//

        binding.linBtnMusicalOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.linBtnMusicalOn.getVisibility()==View.VISIBLE){
                    binding.linBtnMusicalOn.setVisibility(View.INVISIBLE);
                    binding.linBtnMusicalOff.setVisibility(View.VISIBLE);
                }else {
                    binding.linBtnMusicalOn.setVisibility(View.VISIBLE);
                    binding.linBtnNonMusicalOn.setVisibility(View.INVISIBLE);
                    binding.linBtnMusicalOff.setVisibility(View.INVISIBLE);
                    binding.linBtnNonMusicalOff.setVisibility(View.VISIBLE);
                }
            }
        });

        //---------------------------SWITCHING MUSICAL BUTTON OFF---------------------------//

        binding.linBtnMusicalOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.linBtnMusicalOff.getVisibility()==View.VISIBLE){
                    binding.linBtnMusicalOff.setVisibility(View.INVISIBLE);
                    binding.linBtnMusicalOn.setVisibility(View.VISIBLE);
                }else {
                    binding.linBtnMusicalOff.setVisibility(View.VISIBLE);
                    binding.linBtnMusicalOn.setVisibility(View.INVISIBLE);
                    binding.linBtnNonMusicalOff.setVisibility(View.VISIBLE);
                }
            }
        });

        //---------------------------SWITCHING NON-MUSICAL BUTTON ON---------------------------//

        binding.linBtnNonMusicalOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.linBtnNonMusicalOn.getVisibility()==View.VISIBLE){
                    binding.linBtnNonMusicalOn.setVisibility(View.INVISIBLE);
                    binding.linBtnNonMusicalOff.setVisibility(View.VISIBLE);
                }else {
                    binding.linBtnNonMusicalOn.setVisibility(View.VISIBLE);
                    binding.linBtnMusicalOn.setVisibility(View.INVISIBLE);
                    binding.linBtnMusicalOff.setVisibility(View.VISIBLE);
                    binding.linBtnNonMusicalOff.setVisibility(View.INVISIBLE);
                }
            }
        });

        //---------------------------SWITCHING NON-MUSICAL BUTTON OFF---------------------------//

        binding.linBtnNonMusicalOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.linBtnNonMusicalOff.getVisibility()==View.VISIBLE){
                    binding.linBtnNonMusicalOff.setVisibility(View.INVISIBLE);
                    binding.linBtnNonMusicalOn.setVisibility(View.VISIBLE);
                }else {
                    binding.linBtnNonMusicalOff.setVisibility(View.VISIBLE);
                    binding.linBtnNonMusicalOn.setVisibility(View.INVISIBLE);
                    binding.linBtnMusicalOff.setVisibility(View.VISIBLE);
                }
            }
        });

        return view;

    }
}
