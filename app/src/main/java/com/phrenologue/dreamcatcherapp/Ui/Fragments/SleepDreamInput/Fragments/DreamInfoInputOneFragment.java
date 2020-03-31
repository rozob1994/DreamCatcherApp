package com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.phrenologue.dreamcatcherapp.Activities.EditDreamInputActivity;
import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.FragmentDreamInfoInputOneBinding;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamChecklist;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamLucidity;
import com.phrenologue.dreamcatcherapp.presenters.DreamInputPresenter;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DreamInfoInputOneFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {

    private FragmentDreamInfoInputOneBinding binding;
    DreamInputPresenter presenter;
    private SeekBar experience;
    private SeekBar lucidityLevel;
    private AppCompatEditText peopleNames;
    LinearLayout positiveBtnOn, positiveBtnOnTwo, positiveBtnOff, positiveBtnOffTwo, neutralBtnOn,
            neutralBtnOnTwo, neutralBtnOff, neutralBtnOffTwo, negativeBtnOn, negativeBtnOnTwo,
            negativeBtnOff, negativeBtnOffTwo, colorOn, colorOff, grayOn, grayOff, museOn, museOff,
            nonMuseOn, nonMuseOff;
    RelativeLayout peopleExpanded, peopleClosed, soundsExpanded, soundsClosed, colorfulOff,
            feelingsOn1, feelingsOn2, feelingsOn3, feelingsOn4, feelingsOn5, feelingsOn6, feelingsOn7,
            feelingsOn8, feelingsOn9, feelingsOn10, feelingsOff1, feelingsOff2, feelingsOff3,
            feelingsOff4, feelingsOff5, feelingsOff6, feelingsOff7, feelingsOff8, feelingsOff9,
            feelingsOff10;
    SharedPreferences dreamPrefs;
    SharedPreferences.Editor dreamPrefsEditor;
    AppCompatTextView namesHint1, namesHint2, namesHint3, namesHint4, namesHint5, namesHint6, namesHint7,
            namesHint8, namesHint9, namesHint10;


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
        feelingsOn1 = binding.relFeelingsOn;
        feelingsOn2 = binding.relFeelingsOn2;
        feelingsOn3 = binding.relFeelingsOn3;
        feelingsOn4 = binding.relFeelingsOn4;
        feelingsOn5 = binding.relFeelingsOn5;
        feelingsOn6 = binding.relFeelingsOn6;
        feelingsOn7 = binding.relFeelingsOn7;
        feelingsOn8 = binding.relFeelingsOn8;
        feelingsOn9 = binding.relFeelingsOn9;
        feelingsOn10 = binding.relFeelingsOn10;
        feelingsOff1 = binding.relFeelingsOff;
        feelingsOff2 = binding.relFeelingsOff2;
        feelingsOff3 = binding.relFeelingsOff3;
        feelingsOff4 = binding.relFeelingsOff4;
        feelingsOff5 = binding.relFeelingsOff5;
        feelingsOff6 = binding.relFeelingsOff6;
        feelingsOff7 = binding.relFeelingsOff7;
        feelingsOff8 = binding.relFeelingsOff8;
        feelingsOff9 = binding.relFeelingsOff9;
        feelingsOff10 = binding.relFeelingsOff10;
        peopleClosed = binding.relPeopleClosed;
        soundsExpanded = binding.relSoundsExpanded;
        soundsClosed = binding.relSoundsClosed;
        namesHint1 = binding.hintFeelings;
        namesHint2 = binding.hintFeelings2;
        namesHint3 = binding.hintFeelings3;
        namesHint4 = binding.hintFeelings4;
        namesHint5 = binding.hintFeelings5;
        namesHint6 = binding.hintFeelings6;
        namesHint7 = binding.hintFeelings7;
        namesHint8 = binding.hintFeelings8;
        namesHint9 = binding.hintFeelings9;
        namesHint10 = binding.hintFeelings10;
        positiveBtnOn = binding.linPositiveOn;
        positiveBtnOnTwo = binding.linPositiveOn2;
        positiveBtnOff = binding.linPositiveOff;
        positiveBtnOffTwo = binding.linPositiveOff2;
        neutralBtnOn = binding.linNeutralOn;
        neutralBtnOnTwo = binding.linNeutralOn2;
        neutralBtnOff = binding.linNeutralOff;
        neutralBtnOffTwo = binding.linNeutralOff2;
        negativeBtnOn = binding.linNegativeOn;
        negativeBtnOnTwo = binding.linNegativeOn2;
        negativeBtnOff = binding.linNegativeOff;
        negativeBtnOffTwo = binding.linNegativeOff2;
        colorOn = binding.linColorfulOn;
        colorOff = binding.linColorfulOff;
        grayOn = binding.linGrayscaleOn;
        grayOff = binding.linGrayscaleOff;
        colorfulOff = binding.relColorOff;
        museOn = binding.linBtnMusicalOn;
        museOff = binding.linBtnMusicalOff;
        nonMuseOn = binding.linBtnNonMusicalOn;
        nonMuseOff = binding.linBtnNonMusicalOff;
        peopleNames = binding.edtTxtNames;
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
        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[PEOPLE'S NAMES ENTRY]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//
        List<AppCompatTextView> namesHints = Arrays.asList(namesHint1, namesHint2, namesHint3,
                namesHint4, namesHint5, namesHint6, namesHint7, namesHint8, namesHint9, namesHint10);
        List<RelativeLayout> feelingsOnLayouts = Arrays.asList(feelingsOn1, feelingsOn2, feelingsOn3,
                feelingsOn4, feelingsOn5, feelingsOn6, feelingsOn7, feelingsOn8, feelingsOn9,
                feelingsOn10);
        List<RelativeLayout> feelingsOffLayouts = Arrays.asList(feelingsOff1, feelingsOff2, feelingsOff3,
                feelingsOff4, feelingsOff5, feelingsOff6, feelingsOff7, feelingsOff8, feelingsOff9,
                feelingsOff10);
        List<LinearLayout> positiveBtnsOn = Arrays.asList(binding.linPositiveOn, binding.linPositiveOn2,
                binding.linPositiveOn3, binding.linPositiveOff4, binding.linPositiveOn5,
                binding.linPositiveOn6, binding.linPositiveOn7, binding.linPositiveOn8, binding.linPositiveOn9,
                binding.linPositiveOn10);
        List<LinearLayout> positiveBtnsOff = Arrays.asList(binding.linPositiveOff,
                binding.linPositiveOff2, binding.linPositiveOff3, binding.linPositiveOff4,
                binding.linPositiveOff5, binding.linPositiveOff6, binding.linPositiveOff7,
                binding.linPositiveOff8, binding.linPositiveOff9, binding.linPositiveOff10);
        List<LinearLayout> neutralBtnsOn = Arrays.asList(binding.linNeutralOn, binding.linNeutralOn2,
                binding.linNeutralOn3, binding.linNeutralOn4, binding.linNeutralOn5, binding.linNeutralOn6,
                binding.linNeutralOn7, binding.linNeutralOn8, binding.linNeutralOn9, binding.linNeutralOn10);
        List<LinearLayout> neutralBtnsOff = Arrays.asList(binding.linNeutralOff, binding.linNeutralOff2,
                binding.linNeutralOff3, binding.linNeutralOff4, binding.linNeutralOff5,
                binding.linNeutralOff6, binding.linNeutralOff7, binding.linNeutralOff8,
                binding.linNeutralOff9, binding.linNeutralOff10);
        List<LinearLayout> negativeBtnsOn = Arrays.asList(binding.linNegativeOn, binding.linNegativeOn2,
                binding.linNegativeOn3, binding.linNegativeOn4, binding.linNegativeOn5,
                binding.linNegativeOn6, binding.linNegativeOn7, binding.linNegativeOn8,
                binding.linNegativeOn9, binding.linNegativeOn10);
        List<LinearLayout> negativeBtnsOff = Arrays.asList(binding.linNegativeOff, binding.linNegativeOff2,
                binding.linNegativeOff3, binding.linNegativeOff4, binding.linNegativeOff5,
                binding.linNegativeOff6, binding.linNegativeOff7, binding.linNegativeOff8,
                binding.linNegativeOff9, binding.linNegativeOff10);
        peopleNames.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String string = s.toString();
                List<String> namesList = Arrays.asList(string.split(","));
                String hint = getString(R.string.hint_feelings);
                for (int i = 0; i < namesList.size(); i++) {
                    if (i < namesHints.size()) {
                        presenter.makeFeelingVisible(namesHints.get(i), feelingsOnLayouts.get(i),
                                feelingsOffLayouts.get(i));
                        String indexedHint = hint.replace("them", namesList.get(i));
                        int nameLength = namesList.get(i).length();
                        SpannableString ss = new SpannableString(indexedHint);
                        ForegroundColorSpan fcs = new ForegroundColorSpan(Color.CYAN);
                        ss.setSpan(fcs, 58, 58 + nameLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        namesHints.get(i).setText(ss);
                        int finalI = i;
                        positiveBtnsOff.get(i).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                presenter.setPositiveBtnOn(dreamPrefsEditor, positiveBtnsOn.get(finalI),
                                        positiveBtnsOff.get(finalI), neutralBtnsOn.get(finalI),
                                        neutralBtnsOff.get(finalI), negativeBtnsOn.get(finalI),
                                        negativeBtnsOff.get(finalI));
                            }
                        });
                        positiveBtnsOn.get(i).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                presenter.setPositiveBtnOff(dreamPrefsEditor, positiveBtnsOn.get(finalI),
                                        positiveBtnsOff.get(finalI), neutralBtnsOff.get(finalI),
                                        negativeBtnsOff.get(finalI));
                            }
                        });
                        neutralBtnsOff.get(i).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                presenter.setNeutralBtnOn(dreamPrefsEditor, positiveBtnsOn.get(finalI),
                                        positiveBtnsOff.get(finalI), neutralBtnsOn.get(finalI),
                                        neutralBtnsOff.get(finalI), negativeBtnsOn.get(finalI),
                                        negativeBtnsOff.get(finalI));
                            }
                        });
                        neutralBtnsOn.get(i).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                            }
                        });

                    } else {
                        Toast.makeText(getContext(), "You've reached the names limit.",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


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
        if (dreamPrefs.getBoolean("hasLucidity", false)) {
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
