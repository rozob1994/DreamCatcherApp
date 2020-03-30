package com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
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
    SharedPreferences dreamPrefs;
    SharedPreferences.Editor dreamPrefsEditor;

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
        dreamPrefs = getContext().getSharedPreferences("dream", Context.MODE_PRIVATE);
        dreamPrefsEditor = dreamPrefs.edit();

        if (getContext().getClass() == EditDreamInputActivity.class) {
            binding.prevBtn.setVisibility(View.GONE);
        }
        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[MOOD SEEK BAR]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//
        if (dreamPrefs.getBoolean("hasMood", false)) {
            experience.setProgress(0);
            experience.setMax(9);
            experience.setProgress(dreamPrefs.getInt("mood", 0));
        }
        experience.setOnSeekBarChangeListener(this);
        presenter.setMoodSeekBar(dreamPrefsEditor, experience);

        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[PEOPLE BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //---------------------------SWITCHING PEOPLE BUTTON ON---------------------------//
        if (dreamPrefs.getBoolean("hasPeople", false)) {
            presenter.setPeopleBtnOn(dreamPrefsEditor, peopleExpanded, peopleClosed);
        }
        binding.btnPeopleOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setPeopleBtnOn(dreamPrefsEditor, peopleExpanded, peopleClosed);
            }
        });
        //---------------------------SWITCHING PEOPLE BUTTON OFF---------------------------//
        binding.btnPeopleOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setPeopleBtnOff(dreamPrefsEditor, peopleExpanded, peopleClosed);
            }
        });


        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[SOUNDS BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //---------------------------SWITCHING SOUNDS BUTTON On---------------------------//
        if (dreamPrefs.getBoolean("hasSound", false)) {
            presenter.setSoundBtnOn(dreamPrefsEditor, soundsExpanded, soundsClosed);
        }
        binding.btnSoundsOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setSoundBtnOn(dreamPrefsEditor, soundsExpanded, soundsClosed);
            }
        });
        //---------------------------SWITCHING SOUNDS BUTTON OFF---------------------------//

        binding.btnSoundsOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setSoundBtnOff(dreamPrefsEditor, peopleExpanded, peopleClosed);
            }
        });

//************************************************************************************************************************************//
//************************************************************************************************************************************//
//************************************************************************************************************************************//
//************************************************************************************************************************************//
        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[FEELINGS BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //---------------------------SWITCHING POSITIVE BUTTON ON---------------------------//
        if (dreamPrefs.getBoolean("hasImpression", false)) {
            int impression = dreamPrefs.getInt("impression", 0);
            if (impression == 3) {
                presenter.setPositiveBtnOn(dreamPrefsEditor, positiveBtnOn, positiveBtnOff,
                        neutralBtnOn, neutralBtnOff, negativeBtnOn, negativeBtnOff);
            } else if (impression == 2) {
                presenter.setNeutralBtnOn(dreamPrefsEditor, positiveBtnOn, positiveBtnOff,
                        neutralBtnOn, neutralBtnOff, negativeBtnOn, negativeBtnOff);
            } else if (impression == 1) {
                presenter.setNegativeBtnOn(dreamPrefsEditor, positiveBtnOn, positiveBtnOff, neutralBtnOn,
                        neutralBtnOff, negativeBtnOn, negativeBtnOff);
            }


        }
        binding.linPositiveOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setPositiveBtnOn(dreamPrefsEditor, positiveBtnOn, positiveBtnOff, neutralBtnOn,
                        neutralBtnOff, negativeBtnOn, negativeBtnOff);
            }
        });

        //---------------------------SWITCHING POSITIVE BUTTON OFF---------------------------//
        binding.linPositiveOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setPositiveBtnOff(dreamPrefsEditor, positiveBtnOn, positiveBtnOff,
                        neutralBtnOff, negativeBtnOff);
            }
        });

        //---------------------------SWITCHING NEUTRAL BUTTON ON---------------------------//

        binding.linNeutralOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setNeutralBtnOn(dreamPrefsEditor, positiveBtnOn, positiveBtnOff, neutralBtnOn,
                        neutralBtnOff, negativeBtnOn, negativeBtnOff);
            }
        });
        //---------------------------SWITCHING NEUTRAL BUTTON OFF---------------------------//

        binding.linNeutralOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setNeutralBtnOff(dreamPrefsEditor, positiveBtnOff, neutralBtnOn, neutralBtnOff,
                        negativeBtnOff);
            }
        });

        //---------------------------SWITCHING NEGATIVE BUTTON ON---------------------------//
        binding.linNegativeOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setNegativeBtnOn(dreamPrefsEditor, positiveBtnOn, positiveBtnOff, neutralBtnOn, neutralBtnOff,
                        negativeBtnOn, negativeBtnOff);
            }
        });

        //---------------------------SWITCHING NEGATIVE BUTTON Off---------------------------//
        binding.linNegativeOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setNegativeBtnOff(dreamPrefsEditor, positiveBtnOff, neutralBtnOff, negativeBtnOn,
                        negativeBtnOff);
            }
        });

        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[COLOR BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//


        //---------------------------SWITCHING COLORFUL BUTTON ON---------------------------//
        if (dreamPrefs.getBoolean("hasColor", false)) {
            presenter.setColorfulBtnOn(dreamPrefsEditor, colorOn, colorOff, grayOn, grayOff, colorfulOff);
        }
        binding.linColorfulOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setColorfulBtnOn(dreamPrefsEditor, colorOn, colorOff, grayOn, grayOff, colorfulOff);

            }
        });

        //---------------------------SWITCHING COLORFUL BUTTON OFF---------------------------//

        binding.linColorfulOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setColorfulBtnOff(dreamPrefsEditor, colorOn, colorOff, grayOff);
            }
        });

        //---------------------------SWITCHING GRAYSCALE BUTTON ON---------------------------//
        if (dreamPrefs.getBoolean("hasGray", false)) {
            presenter.setGrayScaleBtnOn(dreamPrefsEditor, colorOn, colorOff, grayOn, grayOff, colorfulOff);
        }
        binding.linGrayscaleOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setGrayScaleBtnOn(dreamPrefsEditor, colorOn, colorOff, grayOn, grayOff, colorfulOff);
            }
        });

        //---------------------------SWITCHING GRAYSCALE BUTTON OFF---------------------------//

        binding.linGrayscaleOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setGrayScaleBtnOff(dreamPrefsEditor, colorOff, grayOn, grayOff);
            }
        });


        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[MUSICAL BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //---------------------------SWITCHING MUSICAL BUTTON ON---------------------------//
        if (dreamPrefs.getBoolean("hasMusic", false)) {
            presenter.setMusicalBtnOn(dreamPrefsEditor, museOn, museOff, nonMuseOn, nonMuseOff);
        }
        binding.linBtnMusicalOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setMusicalBtnOn(dreamPrefsEditor, museOn, museOff, nonMuseOn, nonMuseOff);
            }
        });

        //---------------------------SWITCHING MUSICAL BUTTON OFF---------------------------//

        binding.linBtnMusicalOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setMusicalBtnOff(dreamPrefsEditor, museOn, museOff, nonMuseOff);
            }
        });

        //---------------------------SWITCHING NON-MUSICAL BUTTON ON---------------------------//
        if (dreamPrefs.getBoolean("hasNonMusic", false)) {
            presenter.setNonMusicalBtnOn(dreamPrefsEditor, museOn, museOff, nonMuseOn, nonMuseOff);
        }
        binding.linBtnNonMusicalOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setNonMusicalBtnOn(dreamPrefsEditor, museOn, museOff, nonMuseOn, nonMuseOff);
            }
        });

        //---------------------------SWITCHING NON-MUSICAL BUTTON OFF---------------------------//

        binding.linBtnNonMusicalOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setNonMusicalBtnOff(dreamPrefsEditor, museOff, nonMuseOn, nonMuseOff);
            }
        });

        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[LUCIDITY LEVEL]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//
        if (dreamPrefs.getBoolean("hasLucidity", false)){
            lucidityLevel.setProgress(0);
            lucidityLevel.setMax(3);
            lucidityLevel.setProgress(dreamPrefs.getInt("lucidity", 0));
        }

        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[BUTTONS]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //---------------------------------PREVIOUS BUTTON HIT----------------------------------//

        binding.prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
