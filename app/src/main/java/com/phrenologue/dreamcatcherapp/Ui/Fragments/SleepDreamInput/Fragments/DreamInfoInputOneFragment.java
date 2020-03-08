package com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.FragmentDreamInfoInputOneBinding;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamChecklist;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamLucidity;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamPeople;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamSound;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;

/**
 * A simple {@link Fragment} subclass.
 */
public class DreamInfoInputOneFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {

    private FragmentDreamInfoInputOneBinding binding;
    Dream dream;
    DreamPeople people;
    DreamSound sound;
    DreamChecklist checklist;
    DreamLucidity lucidity;
    private SeekBar experience;
    private SeekBar lucidityLevel;

    public DreamInfoInputOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDreamInfoInputOneBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        dream = Dream.getInstance(); // Getting an instance of Dream.class for storing data.
        people = DreamPeople.getInstance();
        sound = DreamSound.getInstance();
        checklist = DreamChecklist.getInstance();
        lucidity = DreamLucidity.getInstance();
        experience = binding.sliderMood;
        lucidityLevel = binding.sliderLucidity;
        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[MOOD SEEK BAR]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        experience.setOnSeekBarChangeListener(this);
        experience.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                checklist.setExperience(progress);
                seekBar.setMax(9);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[PEOPLE BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //---------------------------SWITCHING PEOPLE BUTTON ON---------------------------//

        binding.btnPeopleOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.setExistent(1);
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
                people.setExistent(0);
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
                sound.setSound(1);
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
                sound.setSound(0);
                if (binding.relSoundsClosed.getVisibility() == View.VISIBLE) {
                    binding.relSoundsClosed.setVisibility(View.GONE);
                    binding.relSoundsExpanded.setVisibility(View.VISIBLE);
                } else {
                    binding.relSoundsClosed.setVisibility(View.VISIBLE);
                    binding.relSoundsExpanded.setVisibility(View.GONE);
                }
            }
        });

//************************************************************************************************************************************//
//************************************************************************************************************************************//
//************************************************************************************************************************************//
//************************************************************************************************************************************//
        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[FEELINGS BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //---------------------------SWITCHING POSITIVE BUTTON ON---------------------------//

        binding.linPositiveOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.setImpression(3); // storing positive feelings.
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
                people.setImpression(0);
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
                people.setImpression(2);
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
                people.setImpression(0);
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
                people.setImpression(1);
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
                people.setImpression(0);
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
                checklist.setGrayScale(2);
                if (binding.linColorfulOn.getVisibility() == View.VISIBLE) {
                    binding.linColorfulOn.setVisibility(View.INVISIBLE);
                    binding.linColorfulOff.setVisibility(View.VISIBLE);
                } else {
                    binding.linColorfulOn.setVisibility(View.VISIBLE);
                    binding.linGrayscaleOn.setVisibility(View.INVISIBLE);
                    binding.linGrayscaleOff.setVisibility(View.VISIBLE);
                    binding.linColorfulOff.setVisibility(View.INVISIBLE);
                    binding.relColorOff.setBackgroundResource(R.drawable.bg_invisible);
                }
            }
        });

        //---------------------------SWITCHING COLORFUL BUTTON OFF---------------------------//

        binding.linColorfulOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checklist.setGrayScale(0);
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
                checklist.setGrayScale(1);
                if (binding.linGrayscaleOn.getVisibility() == View.VISIBLE) {
                    binding.linGrayscaleOn.setVisibility(View.INVISIBLE);
                    binding.linGrayscaleOff.setVisibility(View.VISIBLE);
                } else {
                    binding.linGrayscaleOn.setVisibility(View.VISIBLE);
                    binding.linColorfulOn.setVisibility(View.INVISIBLE);
                    binding.linColorfulOff.setVisibility(View.VISIBLE);
                    binding.linGrayscaleOff.setVisibility(View.INVISIBLE);
                    binding.relColorOff.setBackgroundResource(R.drawable.bg_invisible);
                }
            }
        });

        //---------------------------SWITCHING GRAYSCALE BUTTON OFF---------------------------//

        binding.linGrayscaleOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checklist.setGrayScale(0);
                if (binding.linGrayscaleOff.getVisibility() == View.VISIBLE) {
                    binding.linGrayscaleOff.setVisibility(View.INVISIBLE);
                    binding.linGrayscaleOn.setVisibility(View.VISIBLE);
                } else {
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
                sound.setMusical(2);
                if (binding.linBtnMusicalOn.getVisibility() == View.VISIBLE) {
                    binding.linBtnMusicalOn.setVisibility(View.INVISIBLE);
                    binding.linBtnMusicalOff.setVisibility(View.VISIBLE);
                } else {
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
                sound.setMusical(0);
                if (binding.linBtnMusicalOff.getVisibility() == View.VISIBLE) {
                    binding.linBtnMusicalOff.setVisibility(View.INVISIBLE);
                    binding.linBtnMusicalOn.setVisibility(View.VISIBLE);
                } else {
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
                sound.setMusical(1);
                if (binding.linBtnNonMusicalOn.getVisibility() == View.VISIBLE) {
                    binding.linBtnNonMusicalOn.setVisibility(View.INVISIBLE);
                    binding.linBtnNonMusicalOff.setVisibility(View.VISIBLE);
                } else {
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
                sound.setMusical(0);
                if (binding.linBtnNonMusicalOff.getVisibility() == View.VISIBLE) {
                    binding.linBtnNonMusicalOff.setVisibility(View.INVISIBLE);
                    binding.linBtnNonMusicalOn.setVisibility(View.VISIBLE);
                } else {
                    binding.linBtnNonMusicalOff.setVisibility(View.VISIBLE);
                    binding.linBtnNonMusicalOn.setVisibility(View.INVISIBLE);
                    binding.linBtnMusicalOff.setVisibility(View.VISIBLE);
                }
            }
        });

        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[LUCIDITY LEVEL]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        lucidityLevel.setOnSeekBarChangeListener(this);
        lucidityLevel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lucidity.setLucidityLevel(progress);
                seekBar.setMax(9);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[BUTTONS]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //---------------------------------PREVIOUS BUTTON HIT----------------------------------//

        binding.prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dream.delDream();
                checklist.setRemembered(0);
                dream.setDreamChecklist(checklist);
                FragmentManager fm = getFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                SleepInfoInputFragment fragment = new SleepInfoInputFragment();
                transaction.replace(R.id.dream_adding_frame, fragment);
                transaction.commit();
                container.removeAllViews();
            }
        });

        //---------------------------------NEXT BUTTON HIT----------------------------------//

        binding.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.setName(binding.edtTxtNames.getText().toString());
                dream.setDreamPeople(people);
                dream.setDreamChecklist(checklist);
                dream.setDreamSound(sound);
                dream.setDreamLucidity(lucidity);
                FragmentManager fm = getFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                DreamInfoInputTwoFragment fragment = new DreamInfoInputTwoFragment();
                transaction.replace(R.id.dream_adding_frame, fragment);
                transaction.commit();
                container.removeAllViews();
            }
        });

        return view;

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar == experience) {
            checklist.setExperience(progress);
        } else if (seekBar == lucidityLevel) {
            lucidity.setLucidityLevel(progress);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
