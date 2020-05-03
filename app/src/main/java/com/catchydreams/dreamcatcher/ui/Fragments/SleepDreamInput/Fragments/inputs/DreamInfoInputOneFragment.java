package com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Fragments.inputs;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.catchydreams.dreamcatcher.R;
import com.catchydreams.dreamcatcher.activities.EditDreamInputActivity;
import com.catchydreams.dreamcatcher.activities.viewInterfaces.IDreamInfoInput;
import com.catchydreams.dreamcatcher.constants.PersianFont;
import com.catchydreams.dreamcatcher.databinding.FragmentDreamInfoInputOneBinding;
import com.catchydreams.dreamcatcher.parameters.postParameters.dreamParameters.DreamChecklist;
import com.catchydreams.dreamcatcher.presenters.DreamInputPresenter;
import com.catchydreams.dreamcatcher.ui.customFont.MoonTextView;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class DreamInfoInputOneFragment extends Fragment implements SeekBar.OnSeekBarChangeListener,
        IDreamInfoInput {
    private FragmentDreamInfoInputOneBinding binding;
    private DreamInputPresenter presenter;
    private LinearLayout positiveBtnOn, positiveBtnOn2, positiveBtnOn3, positiveBtnOn4, positiveBtnOn5,
            positiveBtnOn6, positiveBtnOn7, positiveBtnOn8, positiveBtnOn9, positiveBtnOn10,
            neutralBtnOn, neutralBtnOn2, neutralBtnOn3, neutralBtnOn4, neutralBtnOn5, neutralBtnOn6,
            neutralBtnOn7, neutralBtnOn8, neutralBtnOn9, neutralBtnOn10,
            negativeBtnOn, negativeBtnOn2, negativeBtnOn3,
            negativeBtnOn4, negativeBtnOn5, negativeBtnOn6, negativeBtnOn7, negativeBtnOn8,
            negativeBtnOn9, negativeBtnOn10,
             colorOn, colorOff, grayOn, grayOff, museOn, museOff,
            nonMuseOn, nonMuseOff, positiveBtnOff, positiveBtnOff2, positiveBtnOff3, positiveBtnOff4,
            positiveBtnOff5, positiveBtnOff6, positiveBtnOff7, positiveBtnOff8, positiveBtnOff9,
            positiveBtnOff10, neutralBtnOff, neutralBtnOff2, neutralBtnOff3, neutralBtnOff4,
            neutralBtnOff5, neutralBtnOff6, neutralBtnOff7, neutralBtnOff8, neutralBtnOff9,
            neutralBtnOff10, negativeBtnOff, negativeBtnOff2, negativeBtnOff3, negativeBtnOff4,
            negativeBtnOff5, negativeBtnOff6, negativeBtnOff7, negativeBtnOff8, negativeBtnOff9,
            negativeBtnOff10;
    private RelativeLayout peopleExpanded, peopleClosed, soundsExpanded, soundsClosed, colorfulOff,
            feelingsOn1, feelingsOn2, feelingsOn3, feelingsOn4, feelingsOn5, feelingsOn6, feelingsOn7,
            feelingsOn8, feelingsOn9, feelingsOn10, feelingsOff1, feelingsOff2, feelingsOff3,
            feelingsOff4, feelingsOff5, feelingsOff6, feelingsOff7, feelingsOff8, feelingsOff9,
            feelingsOff10;
    private SharedPreferences.Editor dreamPrefsEditor;
    private AppCompatTextView namesHint1, namesHint2, namesHint3, namesHint4, namesHint5, namesHint6, namesHint7,
            namesHint8, namesHint9, namesHint10;


    public DreamInfoInputOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentDreamInfoInputOneBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        presenter = new DreamInputPresenter(this);
        SeekBar experience = binding.sliderMood;
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
        positiveBtnOn2 = binding.linPositiveOn2;
        positiveBtnOn3 = binding.linPositiveOn3;
        positiveBtnOn4 = binding.linPositiveOn4;
        positiveBtnOn5 = binding.linPositiveOn5;
        positiveBtnOn6 = binding.linPositiveOn6;
        positiveBtnOn7 = binding.linPositiveOn7;
        positiveBtnOn8 = binding.linPositiveOn8;
        positiveBtnOn9 = binding.linPositiveOn9;
        positiveBtnOn10 = binding.linPositiveOn10;
        neutralBtnOn = binding.linNeutralOn;
        neutralBtnOn2 = binding.linNeutralOn2;
        neutralBtnOn3 = binding.linNeutralOn3;
        neutralBtnOn4 = binding.linNeutralOn4;
        neutralBtnOn5 = binding.linNeutralOn5;
        neutralBtnOn6 = binding.linNeutralOn6;
        neutralBtnOn7 = binding.linNeutralOn7;
        neutralBtnOn8 = binding.linNeutralOn8;
        neutralBtnOn9 = binding.linNeutralOn9;
        neutralBtnOn10 = binding.linNeutralOn10;
        negativeBtnOn = binding.linNegativeOn;
        negativeBtnOn2 = binding.linNegativeOn2;
        negativeBtnOn3 = binding.linNegativeOn3;
        negativeBtnOn4 = binding.linNegativeOn4;
        negativeBtnOn5 = binding.linNegativeOn5;
        negativeBtnOn6 = binding.linNegativeOn6;
        negativeBtnOn7 = binding.linNegativeOn7;
        negativeBtnOn8 = binding.linNegativeOn8;
        negativeBtnOn9 = binding.linNegativeOn9;
        negativeBtnOn10 = binding.linNegativeOn10;
        positiveBtnOff = binding.linPositiveOff;
        positiveBtnOff2 = binding.linPositiveOff2;
        positiveBtnOff3 = binding.linPositiveOff3;
        positiveBtnOff4 = binding.linPositiveOff4;
        positiveBtnOff5 = binding.linPositiveOff5;
        positiveBtnOff6 = binding.linPositiveOff6;
        positiveBtnOff7 = binding.linPositiveOff7;
        positiveBtnOff8 = binding.linPositiveOff8;
        positiveBtnOff9 = binding.linPositiveOff9;
        positiveBtnOff10 = binding.linPositiveOff10;
        neutralBtnOff = binding.linNeutralOff;
        neutralBtnOff2 = binding.linNeutralOff2;
        neutralBtnOff3 = binding.linNeutralOff3;
        neutralBtnOff4 = binding.linNeutralOff4;
        neutralBtnOff5 = binding.linNeutralOff5;
        neutralBtnOff6 = binding.linNeutralOff6;
        neutralBtnOff7 = binding.linNeutralOff7;
        neutralBtnOff8 = binding.linNeutralOff8;
        neutralBtnOff9 = binding.linNeutralOff9;
        neutralBtnOff10 = binding.linNeutralOff10;
        negativeBtnOff = binding.linNegativeOff;
        negativeBtnOff2 = binding.linNegativeOff2;
        negativeBtnOff3 = binding.linNegativeOff3;
        negativeBtnOff4 = binding.linNegativeOff4;
        negativeBtnOff5 = binding.linNegativeOff5;
        negativeBtnOff6 = binding.linNegativeOff6;
        negativeBtnOff7 = binding.linNegativeOff7;
        negativeBtnOff8 = binding.linNegativeOff8;
        negativeBtnOff9 = binding.linNegativeOff9;
        negativeBtnOff10 = binding.linNegativeOff10;
        colorOn = binding.linColorfulOn;
        colorOff = binding.linColorfulOff;
        grayOn = binding.linGrayscaleOn;
        grayOff = binding.linGrayscaleOff;
        colorfulOff = binding.relColorOff;
        museOn = binding.linBtnMusicalOn;
        museOff = binding.linBtnMusicalOff;
        nonMuseOn = binding.linBtnNonMusicalOn;
        nonMuseOff = binding.linBtnNonMusicalOff;
        AppCompatEditText peopleNames = binding.edtTxtNames;
        AppCompatButton btnPeopleOff = binding.btnPeopleOff;
        AppCompatButton btnPeopleOn = binding.btnPeopleOn;
        AppCompatButton prevBtn = binding.prevBtn;
        AppCompatButton nextBtn = binding.nextBtn;
        AppCompatButton btnSoundsOn = binding.btnSoundsOn;
        AppCompatButton btnSoundsOff = binding.btnSoundsOff;
        SharedPreferences dreamPrefs = Objects.requireNonNull(getContext())
                .getSharedPreferences("dream", Context.MODE_PRIVATE);
        dreamPrefsEditor = dreamPrefs.edit();
        SharedPreferences languagePrefs = getContext().getSharedPreferences("languages",
                Context.MODE_PRIVATE);
        presenter.setPersianTypeFace(languagePrefs);
        if (getContext().getClass() == EditDreamInputActivity.class) {
            prevBtn.setVisibility(View.GONE);
        }
        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[MOOD SEEK BAR]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//
        if (dreamPrefs.getBoolean("hasMood", false)) {
            experience.setProgress(0);
            experience.setMax(2);
            experience.setProgress(dreamPrefs.getInt("mood", 0));
        }
        experience.setOnSeekBarChangeListener(this);
        presenter.setMoodSeekBar(dreamPrefsEditor, experience, getContext());

        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[PEOPLE BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //---------------------------SWITCHING PEOPLE BUTTON ON---------------------------//
        if (dreamPrefs.getBoolean("hasPeople", false)) {
            presenter.setPeopleBtnOn(dreamPrefsEditor, peopleExpanded, peopleClosed);
        }
        btnPeopleOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setPeopleBtnOn(dreamPrefsEditor, peopleExpanded, peopleClosed);
            }
        });
        //---------------------------SWITCHING PEOPLE BUTTON OFF---------------------------//
        btnPeopleOn.setOnClickListener(new View.OnClickListener() {
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
        btnSoundsOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setSoundBtnOn(dreamPrefsEditor, soundsExpanded, soundsClosed);
            }
        });
        //---------------------------SWITCHING SOUNDS BUTTON OFF---------------------------//

        btnSoundsOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setSoundBtnOff(dreamPrefsEditor, soundsExpanded, soundsClosed);
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
        List<LinearLayout> positiveBtnsOn = Arrays.asList(positiveBtnOn, positiveBtnOn2,
                positiveBtnOn3, positiveBtnOn4, positiveBtnOn5,
                positiveBtnOn6, positiveBtnOn7, positiveBtnOn8, positiveBtnOn9,
                positiveBtnOn10);
        List<LinearLayout> positiveBtnsOff = Arrays.asList(positiveBtnOff, positiveBtnOff2,
                positiveBtnOff3, positiveBtnOff4, positiveBtnOff5, positiveBtnOff6, positiveBtnOff7,
                positiveBtnOff8, positiveBtnOff9, positiveBtnOff10);
        List<LinearLayout> neutralBtnsOn = Arrays.asList(neutralBtnOn, neutralBtnOn2,
                neutralBtnOn3, neutralBtnOn4, neutralBtnOn5, neutralBtnOn6,
                neutralBtnOn7, neutralBtnOn8, neutralBtnOn9, neutralBtnOn10);
        List<LinearLayout> neutralBtnsOff = Arrays.asList(neutralBtnOff, neutralBtnOff2,
                neutralBtnOff3, neutralBtnOff4, neutralBtnOff5, neutralBtnOff6, neutralBtnOff7,
                neutralBtnOff8, neutralBtnOff9, neutralBtnOff10);
        List<LinearLayout> negativeBtnsOn = Arrays.asList(negativeBtnOn, negativeBtnOn2,
                negativeBtnOn3, negativeBtnOn4, negativeBtnOn5,
                negativeBtnOn6, negativeBtnOn7, negativeBtnOn8,
                negativeBtnOn9, negativeBtnOn10);
        List<LinearLayout> negativeBtnsOff = Arrays.asList(negativeBtnOff, negativeBtnOff2,
                negativeBtnOff3, negativeBtnOff4, negativeBtnOff5, negativeBtnOff6, negativeBtnOff7,
                negativeBtnOff8, negativeBtnOff9, negativeBtnOff10);


        if (dreamPrefs.getBoolean("hasPeople", false)) {

            presenter.loadPeople(dreamPrefs, dreamPrefsEditor, peopleNames, namesHints,
                    feelingsOnLayouts, feelingsOffLayouts, positiveBtnsOn, positiveBtnsOff,
                    neutralBtnsOn, neutralBtnsOff, negativeBtnsOn, negativeBtnsOff, languagePrefs.getString("language","en"));
        }
        presenter.splitNames(languagePrefs, dreamPrefsEditor, getContext(), peopleNames, namesHints,
                feelingsOnLayouts, feelingsOffLayouts, positiveBtnsOn, positiveBtnsOff,
                neutralBtnsOn, neutralBtnsOff, negativeBtnsOn, negativeBtnsOff);

        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[COLOR BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//


        //---------------------------SWITCHING COLORFUL BUTTON ON---------------------------//
        if (dreamPrefs.getBoolean("hasColor", false)) {
            presenter.setColorfulBtnOn(dreamPrefsEditor, colorOn, colorOff, grayOn, grayOff, colorfulOff);
        }
        colorOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setColorfulBtnOn(dreamPrefsEditor, colorOn, colorOff, grayOn, grayOff, colorfulOff);

            }
        });

        //---------------------------SWITCHING COLORFUL BUTTON OFF---------------------------//

        colorOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setColorfulBtnOff(dreamPrefsEditor, colorOn, colorOff, grayOff);
            }
        });

        //---------------------------SWITCHING GRAYSCALE BUTTON ON---------------------------//
        if (dreamPrefs.getBoolean("hasGray", false)) {
            presenter.setGrayScaleBtnOn(dreamPrefsEditor, colorOn, colorOff, grayOn, grayOff, colorfulOff);
        }
        grayOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setGrayScaleBtnOn(dreamPrefsEditor, colorOn, colorOff, grayOn, grayOff, colorfulOff);
            }
        });

        //---------------------------SWITCHING GRAYSCALE BUTTON OFF---------------------------//

        grayOn.setOnClickListener(new View.OnClickListener() {
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
        museOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setMusicalBtnOn(dreamPrefsEditor, museOn, museOff, nonMuseOn, nonMuseOff);
            }
        });

        //---------------------------SWITCHING MUSICAL BUTTON OFF---------------------------//

        museOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setMusicalBtnOff(dreamPrefsEditor, museOn, museOff, nonMuseOff);
            }
        });

        //---------------------------SWITCHING NON-MUSICAL BUTTON ON---------------------------//
        if (dreamPrefs.getBoolean("hasNonMusic", false)) {
            presenter.setNonMusicalBtnOn(dreamPrefsEditor, museOn, museOff, nonMuseOn, nonMuseOff);
        }
        nonMuseOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setNonMusicalBtnOn(dreamPrefsEditor, museOn, museOff, nonMuseOn, nonMuseOff);
            }
        });

        //---------------------------SWITCHING NON-MUSICAL BUTTON OFF---------------------------//

        nonMuseOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setNonMusicalBtnOff(dreamPrefsEditor, museOff, nonMuseOn, nonMuseOff);
            }
        });

        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[LUCIDITY LEVEL]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[BUTTONS]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //---------------------------------PREVIOUS BUTTON HIT----------------------------------//

        prevBtn.setOnClickListener(new View.OnClickListener() {
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

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.saveHalfWayDream(peopleNames, positiveBtnOn, positiveBtnOn2,
                        positiveBtnOn3, positiveBtnOn4, positiveBtnOn5, positiveBtnOn6, positiveBtnOn7,
                        positiveBtnOn8, positiveBtnOn9, positiveBtnOn10, neutralBtnOn, neutralBtnOn2,
                        neutralBtnOn3, neutralBtnOn4, neutralBtnOn5, neutralBtnOn6, neutralBtnOn7,
                        neutralBtnOn8, neutralBtnOn9, neutralBtnOn10, negativeBtnOn, negativeBtnOn2,
                        negativeBtnOn3, negativeBtnOn4, negativeBtnOn5, negativeBtnOn6, negativeBtnOn7,
                        negativeBtnOn8, negativeBtnOn9, negativeBtnOn10, namesHint1, namesHint2,
                        namesHint3, namesHint4, namesHint5, namesHint6, namesHint7, namesHint8,
                        namesHint9, namesHint10);

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
        DreamChecklist checklist = DreamChecklist.getInstance();
        checklist.setExperience(progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


    @Override
    public void setPersianTypeFace() {
        Typeface fontTitle = Typeface.createFromAsset(getContext().getAssets(), PersianFont.title);

        Typeface fontReg = Typeface.createFromAsset(getContext().getAssets(), PersianFont.regular);

        List<MoonTextView> titles = Arrays.asList(binding.titleDreamInfo, binding.titleMood, binding.titlePeople,
                binding.titleColor, binding.titleFeelings, binding.titleSounds, binding.titleNames,
                binding.titleSoundsOff, binding.titlePeopleExpanded);

        presenter.setTitleFonts(titles);

        List<MoonTextView> hints = Arrays.asList(binding.hintMood, binding.hintPeople, binding.hintPeopleExpanded,
                binding.hintNames, binding.hintFeelings, binding.hintFeelings2, binding.hintFeelings3,
                binding.hintFeelings4, binding.hintFeelings5, binding.hintFeelings6,
                binding.hintFeelings7, binding.hintFeelings8, binding.hintFeelings9,
                binding.hintFeelings10, binding.hintColor, binding.hintSounds, binding.hintSoundsOff,
                binding.hintSoundsTwo);

        presenter.setHintFonts(hints);

        List<MoonTextView> subscripts = Arrays.asList(binding.positive1On,
                binding.positive2On,
                binding.positive3On,
                binding.positive4On,
                binding.positive5On,
                binding.positiveOn6,
                binding.positiveOn7,
                binding.positiveOn8,
                binding.positiveOn9,
                binding.positiveOn10,
                binding.positive1Off,
                binding.positive2Off,
                binding.positive3Off,
                binding.positive4Off,
                binding.positive5Off,
                binding.positiveOff6,
                binding.positiveOff7,
                binding.positiveOff8,
                binding.positiveOff9,
                binding.positiveOff10,
                binding.neutral1On,
                binding.neutral2On,
                binding.neutral3On,
                binding.neutral4On,
                binding.neutral5On,
                binding.neutralOn6,
                binding.neutralOn7,
                binding.neutralOn8,
                binding.neutralOn9,
                binding.neutralOn10,
                binding.neutral1Off,
                binding.neutral2Off,
                binding.neutral3Off,
                binding.neutral4Off,
                binding.neutral5Off,
                binding.neutralOff6,
                binding.neutralOff7,
                binding.neutralOff8,
                binding.neutralOff9,
                binding.neutralOff10,
                binding.negative1On,
                binding.negative2On,
                binding.negative3On,
                binding.negative4On,
                binding.negative5On,
                binding.negativeOn6,
                binding.negativeOn7,
                binding.negativeOn8,
                binding.negativeOn9,
                binding.negativeOn10,
                binding.negative1Off,
                binding.negative2Off,
                binding.negative3Off,
                binding.negative4Off,
                binding.negative5Off,
                binding.negativeOff6,
                binding.negativeOff7,
                binding.negativeOff8,
                binding.negativeOff9,
                binding.negativeOff10, binding.colorful, binding.grayscale, binding.colorfulOff,
                binding.grayscaleOff, binding.musicalOn, binding.musicalOff, binding.nonMusicalOn,
                binding.nonMusicalOff);

        presenter.setSubscriptFonts(subscripts);

        binding.edtTxtNames.setTypeface(fontReg);
        binding.nextBtn.setTypeface(fontTitle);
        binding.prevBtn.setTypeface(fontTitle);
        binding.nextBtn.setTextSize(PersianFont.large);
        binding.prevBtn.setTextSize(PersianFont.large);
    }

    @Override
    public void setTitleFonts(MoonTextView title) {
        Typeface fontTitle = Typeface.createFromAsset(getContext().getAssets(), PersianFont.title);
        title.setTypeface(fontTitle);
        title.setTextSize(PersianFont.normalLarge);
    }

    @Override
    public void setHintFonts(MoonTextView hint) {
        Typeface fontSubTitle = Typeface.createFromAsset(getContext().getAssets(), PersianFont.subTitle);
        hint.setTypeface(fontSubTitle);
        hint.setTextSize(PersianFont.normal);
    }

    @Override
    public void setSubscriptFonts(MoonTextView subscript) {
        Typeface fontReg = Typeface.createFromAsset(getContext().getAssets(), PersianFont.regular);
        subscript.setTypeface(fontReg);
        subscript.setTextSize(PersianFont.normalSmall);
    }

    @Override
    public void setEditTextHintFonts(AppCompatEditText editTextHint) {

    }

}
