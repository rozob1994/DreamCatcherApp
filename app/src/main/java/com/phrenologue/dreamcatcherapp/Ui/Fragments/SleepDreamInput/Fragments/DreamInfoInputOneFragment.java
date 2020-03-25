package com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.phrenologue.dreamcatcherapp.Activities.EditDreamInputActivity;
import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.FragmentDreamInfoInputOneBinding;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamChecklist;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamLucidity;
import com.phrenologue.dreamcatcherapp.presenters.DreamInputPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class DreamInfoInputOneFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {

    private FragmentDreamInfoInputOneBinding binding;
    DreamInputPresenter presenter;
    private SeekBar experience;
    private SeekBar lucidityLevel;
    LinearLayout positiveBtnOn, positiveBtnOff, neutralBtnOn, neutralBtnOff, negativeBtnOn,
            negativeBtnOff, colorOn, colorOff, grayOn, grayOff, museOn, museOff, nonMuseOn,
            nonMuseOff;
    RelativeLayout peopleExpanded, peopleClosed, soundsExpanded, soundsClosed, colorfulOff;

    public DreamInfoInputOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDreamInfoInputOneBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        presenter = new DreamInputPresenter();
        experience = binding.sliderMood;
        peopleExpanded = binding.relPeopleExpanded;
        peopleClosed = binding.relPeopleClosed;
        soundsExpanded = binding.relSoundsExpanded;
        soundsClosed = binding.relSoundsClosed;
        lucidityLevel = binding.sliderLucidity;
        positiveBtnOn = binding.linPositiveOn;
        positiveBtnOff = binding.linPositiveOff;
        neutralBtnOn = binding.linNeutralOn;
        neutralBtnOff = binding.linNeutralOff;
        negativeBtnOn = binding.linNegativeOn;
        negativeBtnOff = binding.linNegativeOff;
        colorOn = binding.linColorfulOn;
        colorOff = binding.linColorfulOff;
        grayOn = binding.linGrayscaleOn;
        grayOff = binding.linGrayscaleOff;
        colorfulOff = binding.relColorOff;
        museOn = binding.linBtnMusicalOn;
        museOff = binding.linBtnMusicalOff;
        nonMuseOn = binding.linBtnNonMusicalOn;
        nonMuseOff = binding.linBtnNonMusicalOff;
        if (getContext().getClass()== EditDreamInputActivity.class){
            binding.prevBtn.setVisibility(View.GONE);
        }
        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[MOOD SEEK BAR]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        experience.setOnSeekBarChangeListener(this);
        presenter.setMoodSeekBar(experience);

        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[PEOPLE BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //---------------------------SWITCHING PEOPLE BUTTON ON---------------------------//

        binding.btnPeopleOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setPeopleBtnOn(peopleExpanded, peopleClosed);
            }
        });
        //---------------------------SWITCHING PEOPLE BUTTON OFF---------------------------//

        binding.btnPeopleOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setPeopleBtnOff(peopleExpanded, peopleClosed);
            }
        });


        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[SOUNDS BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //---------------------------SWITCHING SOUNDS BUTTON On---------------------------//

        binding.btnSoundsOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setSoundBtnOn(soundsExpanded, soundsClosed);
            }
        });
        //---------------------------SWITCHING SOUNDS BUTTON OFF---------------------------//

        binding.btnSoundsOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setSoundBtnOff(peopleExpanded, peopleClosed);
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
                presenter.setPositiveBtnOn(positiveBtnOn, positiveBtnOff, neutralBtnOn,
                        neutralBtnOff, negativeBtnOn, negativeBtnOff);
            }
        });

        //---------------------------SWITCHING POSITIVE BUTTON OFF---------------------------//
        binding.linPositiveOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setPositiveBtnOff(positiveBtnOn, positiveBtnOff, neutralBtnOff,
                        negativeBtnOff);
            }
        });

        //---------------------------SWITCHING NEUTRAL BUTTON ON---------------------------//

        binding.linNeutralOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setNeutralBtnOn(positiveBtnOn, positiveBtnOff, neutralBtnOn, neutralBtnOff,
                        negativeBtnOn, negativeBtnOff);
            }
        });
        //---------------------------SWITCHING NEUTRAL BUTTON OFF---------------------------//

        binding.linNeutralOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setNeutralBtnOff(positiveBtnOff, neutralBtnOn, neutralBtnOff,
                        negativeBtnOff);
            }
        });

        //---------------------------SWITCHING NEGATIVE BUTTON ON---------------------------//
        binding.linNegativeOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setNegativeBtnOn(positiveBtnOn, positiveBtnOff, neutralBtnOn, neutralBtnOff,
                        negativeBtnOn, negativeBtnOff);
            }
        });

        //---------------------------SWITCHING NEGATIVE BUTTON Off---------------------------//
        binding.linNegativeOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setNegativeBtnOff(positiveBtnOff, neutralBtnOff, negativeBtnOn,
                        negativeBtnOff);
            }
        });

        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[COLOR BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//


        //---------------------------SWITCHING COLORFUL BUTTON ON---------------------------//

        binding.linColorfulOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setColorfulBtnOn(colorOn, colorOff, grayOn, grayOff, colorfulOff);

            }
        });

        //---------------------------SWITCHING COLORFUL BUTTON OFF---------------------------//

        binding.linColorfulOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setColorfulBtnOff(colorOn, colorOff, grayOff);
            }
        });

        //---------------------------SWITCHING GRAYSCALE BUTTON ON---------------------------//

        binding.linGrayscaleOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setGrayScaleBtnOn(colorOn, colorOff, grayOn, grayOff, colorfulOff);
            }
        });

        //---------------------------SWITCHING GRAYSCALE BUTTON OFF---------------------------//

        binding.linGrayscaleOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setGrayScaleBtnOff(colorOff, grayOn, grayOff);
            }
        });


        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[MUSICAL BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //---------------------------SWITCHING MUSICAL BUTTON ON---------------------------//

        binding.linBtnMusicalOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setMusicalBtnOn(museOn, museOff, nonMuseOn, nonMuseOff);
            }
        });

        //---------------------------SWITCHING MUSICAL BUTTON OFF---------------------------//

        binding.linBtnMusicalOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setMusicalBtnOff(museOn, museOff, nonMuseOff);
            }
        });

        //---------------------------SWITCHING NON-MUSICAL BUTTON ON---------------------------//

        binding.linBtnNonMusicalOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setNonMusicalBtnOn(museOn, museOff, nonMuseOn, nonMuseOff);
            }
        });

        //---------------------------SWITCHING NON-MUSICAL BUTTON OFF---------------------------//

        binding.linBtnNonMusicalOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setNonMusicalBtnOff(museOff, nonMuseOn, nonMuseOff);
            }
        });

        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[LUCIDITY LEVEL]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        lucidityLevel.setOnSeekBarChangeListener(this);
        presenter.setLuciditySeekBar(lucidityLevel);

        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[BUTTONS]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //---------------------------------PREVIOUS BUTTON HIT----------------------------------//

        binding.prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.cancelDreamInput();
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
                presenter.saveHalfWayDream(binding.edtTxtNames);

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
            DreamChecklist checklist = DreamChecklist.getInstance();
            checklist.setExperience(progress);
        } else if (seekBar == lucidityLevel) {
            DreamLucidity lucidity = DreamLucidity.getInstance();
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
