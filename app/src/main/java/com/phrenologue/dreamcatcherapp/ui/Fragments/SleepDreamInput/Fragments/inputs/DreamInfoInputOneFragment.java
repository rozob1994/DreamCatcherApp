package com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.inputs;

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

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.activities.EditDreamInputActivity;
import com.phrenologue.dreamcatcherapp.activities.viewInterfaces.IDreamInfoInput;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamChecklist;
import com.phrenologue.dreamcatcherapp.presenters.DreamInputPresenter;
import com.phrenologue.dreamcatcherapp.ui.costumeFont.MoonTextView;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class DreamInfoInputOneFragment extends Fragment implements SeekBar.OnSeekBarChangeListener,
        IDreamInfoInput {

    private DreamInputPresenter presenter;
    private LinearLayout positiveBtnOn;
    private LinearLayout positiveBtnOn2;
    private LinearLayout positiveBtnOn3;
    private LinearLayout positiveBtnOn4;
    private LinearLayout positiveBtnOn5;
    private LinearLayout positiveBtnOn6;
    private LinearLayout positiveBtnOn7;
    private LinearLayout positiveBtnOn8;
    private LinearLayout positiveBtnOn9;
    private LinearLayout positiveBtnOn10;
    private LinearLayout neutralBtnOn;
    private LinearLayout neutralBtnOn2;
    private LinearLayout neutralBtnOn3;
    private LinearLayout neutralBtnOn4;
    private LinearLayout neutralBtnOn5;
    private LinearLayout neutralBtnOn6;
    private LinearLayout neutralBtnOn7;
    private LinearLayout neutralBtnOn8;
    private LinearLayout neutralBtnOn9;
    private LinearLayout neutralBtnOn10;
    private LinearLayout negativeBtnOn;
    private LinearLayout negativeBtnOn2;
    private LinearLayout negativeBtnOn3;
    private LinearLayout negativeBtnOn4;
    private LinearLayout negativeBtnOn5;
    private LinearLayout negativeBtnOn6;
    private LinearLayout negativeBtnOn7;
    private LinearLayout negativeBtnOn8;
    private LinearLayout negativeBtnOn9;
    private LinearLayout negativeBtnOn10;
    private LinearLayout colorOn;
    private LinearLayout colorOff;
    private LinearLayout grayOn;
    private LinearLayout grayOff;
    private LinearLayout museOn;
    private LinearLayout museOff;
    private LinearLayout nonMuseOn;
    private LinearLayout nonMuseOff;
    private LinearLayout positiveBtnOff2;
    private LinearLayout positiveBtnOff3;
    private LinearLayout positiveBtnOff4;
    private LinearLayout positiveBtnOff5;
    private LinearLayout positiveBtnOff6;
    private LinearLayout positiveBtnOff7;
    private LinearLayout positiveBtnOff8;
    private LinearLayout positiveBtnOff9;
    private LinearLayout positiveBtnOff10;
    private LinearLayout neutralBtnOff;
    private LinearLayout neutralBtnOff2;
    private LinearLayout neutralBtnOff3;
    private LinearLayout neutralBtnOff4;
    private LinearLayout neutralBtnOff5;
    private LinearLayout neutralBtnOff6;
    private LinearLayout neutralBtnOff7;
    private LinearLayout neutralBtnOff8;
    private LinearLayout neutralBtnOff9;
    private LinearLayout neutralBtnOff10;
    private LinearLayout negativeBtnOff;
    private LinearLayout negativeBtnOff2;
    private LinearLayout negativeBtnOff3;
    private LinearLayout negativeBtnOff4;
    private LinearLayout negativeBtnOff5;
    private LinearLayout negativeBtnOff6;
    private LinearLayout negativeBtnOff7;
    private LinearLayout negativeBtnOff8;
    private LinearLayout negativeBtnOff9;
    private LinearLayout negativeBtnOff10;
    private RelativeLayout peopleExpanded, peopleClosed, soundsExpanded, soundsClosed, colorfulOff,
            feelingsOn1, feelingsOn2, feelingsOn3, feelingsOn4, feelingsOn5, feelingsOn6, feelingsOn7,
            feelingsOn8, feelingsOn9, feelingsOn10, feelingsOff1, feelingsOff2, feelingsOff3,
            feelingsOff4, feelingsOff5, feelingsOff6, feelingsOff7, feelingsOff8, feelingsOff9,
            feelingsOff10;
    private SharedPreferences.Editor dreamPrefsEditor;
    private AppCompatTextView namesHint1, namesHint2, namesHint3, namesHint4, namesHint5, namesHint6, namesHint7,
            namesHint8, namesHint9, namesHint10;
    private MoonTextView positiveOn, positiveOn2, positiveOn3, positiveOn4;


    public DreamInfoInputOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new DreamInputPresenter(this);
        SeekBar experience = getView().findViewById(R.id.slider_mood);
        peopleExpanded = getView().findViewById(R.id.rel_people_expanded);
        feelingsOn1 = getView().findViewById(R.id.rel_feelings_on);
        feelingsOn2 = getView().findViewById(R.id.rel_feelings_on2);
        feelingsOn3 = getView().findViewById(R.id.rel_feelings_on3);
        feelingsOn4 = getView().findViewById(R.id.rel_feelings_on4);
        feelingsOn5 = getView().findViewById(R.id.rel_feelings_on5);
        feelingsOn6 = getView().findViewById(R.id.rel_feelings_on6);
        feelingsOn7 = getView().findViewById(R.id.rel_feelings_on7);
        feelingsOn8 = getView().findViewById(R.id.rel_feelings_on8);
        feelingsOn9 = getView().findViewById(R.id.rel_feelings_on9);
        feelingsOn10 = getView().findViewById(R.id.rel_feelings_on10);
        peopleClosed = getView().findViewById(R.id.rel_people_closed);
        soundsExpanded = getView().findViewById(R.id.rel_sounds_expanded);
        soundsClosed = getView().findViewById(R.id.rel_sounds_closed);
        namesHint1 = getView().findViewById(R.id.hint_feelings);
        namesHint2 = getView().findViewById(R.id.hint_feelings2);
        namesHint3 = getView().findViewById(R.id.hint_feelings3);
        namesHint4 = getView().findViewById(R.id.hint_feelings4);
        namesHint5 = getView().findViewById(R.id.hint_feelings5);
        namesHint6 = getView().findViewById(R.id.hint_feelings6);
        namesHint7 = getView().findViewById(R.id.hint_feelings7);
        namesHint8 = getView().findViewById(R.id.hint_feelings8);
        namesHint9 = getView().findViewById(R.id.hint_feelings9);
        namesHint10 = getView().findViewById(R.id.hint_feelings10);
        positiveBtnOn = getView().findViewById(R.id.lin_positive_on);
        positiveBtnOn2 = getView().findViewById(R.id.lin_positive_on2);
        positiveBtnOn3 = getView().findViewById(R.id.lin_positive_on3);
        positiveBtnOn4 = getView().findViewById(R.id.lin_positive_on4);
        positiveBtnOn5 = getView().findViewById(R.id.lin_positive_on5);
        positiveBtnOn6 = getView().findViewById(R.id.lin_positive_on6);
        positiveBtnOn7 = getView().findViewById(R.id.lin_positive_on7);
        positiveBtnOn8 = getView().findViewById(R.id.lin_positive_on8);
        positiveBtnOn9 = getView().findViewById(R.id.lin_positive_on9);
        positiveBtnOn10 = getView().findViewById(R.id.lin_positive_on10);
        neutralBtnOn = getView().findViewById(R.id.lin_neutral_on);
        neutralBtnOn2 = getView().findViewById(R.id.lin_neutral_on2);
        neutralBtnOn3 = getView().findViewById(R.id.lin_neutral_on3);
        neutralBtnOn4 = getView().findViewById(R.id.lin_neutral_on4);
        neutralBtnOn5 = getView().findViewById(R.id.lin_neutral_on5);
        neutralBtnOn6 = getView().findViewById(R.id.lin_neutral_on6);
        neutralBtnOn7 = getView().findViewById(R.id.lin_neutral_on7);
        neutralBtnOn8 = getView().findViewById(R.id.lin_neutral_on8);
        neutralBtnOn9 = getView().findViewById(R.id.lin_neutral_on9);
        neutralBtnOn10 = getView().findViewById(R.id.lin_neutral_on10);
        negativeBtnOn = getView().findViewById(R.id.lin_negative_on);
        negativeBtnOn2 = getView().findViewById(R.id.lin_negative_on2);
        negativeBtnOn3 = getView().findViewById(R.id.lin_negative_on3);
        negativeBtnOn4 = getView().findViewById(R.id.lin_negative_on4);
        negativeBtnOn5 = getView().findViewById(R.id.lin_negative_on5);
        negativeBtnOn6 = getView().findViewById(R.id.lin_negative_on6);
        negativeBtnOn7 = getView().findViewById(R.id.lin_negative_on7);
        negativeBtnOn8 = getView().findViewById(R.id.lin_negative_on8);
        negativeBtnOn9 = getView().findViewById(R.id.lin_negative_on9);
        negativeBtnOn10 = getView().findViewById(R.id.lin_negative_on10);
        LinearLayout positiveBtnOff = getView().findViewById(R.id.lin_positive_off);
        positiveBtnOff2 = getView().findViewById(R.id.lin_positive_off2);
        positiveBtnOff3 = getView().findViewById(R.id.lin_positive_off3);
        positiveBtnOff4 = getView().findViewById(R.id.lin_positive_off4);
        positiveBtnOff5 = getView().findViewById(R.id.lin_positive_off5);
        positiveBtnOff6 = getView().findViewById(R.id.lin_positive_off6);
        positiveBtnOff7 = getView().findViewById(R.id.lin_positive_off7);
        positiveBtnOff8 = getView().findViewById(R.id.lin_positive_off8);
        positiveBtnOff9 = getView().findViewById(R.id.lin_positive_off9);
        positiveBtnOff10 = getView().findViewById(R.id.lin_positive_off10);
        neutralBtnOff = getView().findViewById(R.id.lin_neutral_off);
        neutralBtnOff2 = getView().findViewById(R.id.lin_neutral_off2);
        neutralBtnOff3 = getView().findViewById(R.id.lin_neutral_off3);
        neutralBtnOff4 = getView().findViewById(R.id.lin_neutral_off4);
        neutralBtnOff5 = getView().findViewById(R.id.lin_neutral_off5);
        neutralBtnOff6 = getView().findViewById(R.id.lin_neutral_off6);
        neutralBtnOff7 = getView().findViewById(R.id.lin_neutral_off7);
        neutralBtnOff8 = getView().findViewById(R.id.lin_neutral_off8);
        neutralBtnOff9 = getView().findViewById(R.id.lin_neutral_off9);
        neutralBtnOff10 = getView().findViewById(R.id.lin_neutral_off10);
        negativeBtnOff = getView().findViewById(R.id.lin_negative_off);
        negativeBtnOff2 = getView().findViewById(R.id.lin_negative_off2);
        negativeBtnOff3 = getView().findViewById(R.id.lin_negative_off3);
        negativeBtnOff4 = getView().findViewById(R.id.lin_negative_off4);
        negativeBtnOff5 = getView().findViewById(R.id.lin_negative_off5);
        negativeBtnOff6 = getView().findViewById(R.id.lin_negative_off6);
        negativeBtnOff7 = getView().findViewById(R.id.lin_negative_off7);
        negativeBtnOff8 = getView().findViewById(R.id.lin_negative_off8);
        negativeBtnOff9 = getView().findViewById(R.id.lin_negative_off9);
        negativeBtnOff10 = getView().findViewById(R.id.lin_negative_off10);
        colorOn = getView().findViewById(R.id.lin_colorful_on);
        colorOff = getView().findViewById(R.id.lin_colorful_off);
        grayOn = getView().findViewById(R.id.lin_grayscale_on);
        grayOff = getView().findViewById(R.id.lin_grayscale_off);
        colorfulOff = getView().findViewById(R.id.rel_color_off);
        museOn = getView().findViewById(R.id.lin_btn_musical_on);
        museOff = getView().findViewById(R.id.lin_btn_musical_off);
        nonMuseOn = getView().findViewById(R.id.lin_btn_non_musical_on);
        nonMuseOff = getView().findViewById(R.id.lin_btn_non_musical_off);
        AppCompatEditText peopleNames = getView().findViewById(R.id.edt_txt_names);
        AppCompatButton btnPeopleOff = getView().findViewById(R.id.btn_people_off);
        AppCompatButton btnPeopleOn = getView().findViewById(R.id.btn_people_on);
        AppCompatButton prevBtn = getView().findViewById(R.id.prevBtn);
        AppCompatButton nextBtn = getView().findViewById(R.id.nextBtn);
        AppCompatButton btnSoundsOn = getView().findViewById(R.id.btn_sounds_on);
        AppCompatButton btnSoundsOff = getView().findViewById(R.id.btn_sounds_off);
        SharedPreferences dreamPrefs = Objects.requireNonNull(getContext())
                .getSharedPreferences("dream", Context.MODE_PRIVATE);
        dreamPrefsEditor = dreamPrefs.edit();

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

            presenter.makePeopleWork(dreamPrefsEditor, getContext(), peopleNames, namesHints,
                    feelingsOnLayouts, feelingsOffLayouts, positiveBtnsOn, positiveBtnsOff,
                    neutralBtnsOn, neutralBtnsOff, negativeBtnsOn, negativeBtnsOff);

            presenter.loadPeople(dreamPrefs, dreamPrefsEditor, peopleNames, namesHints,
                    feelingsOnLayouts, feelingsOffLayouts, positiveBtnsOn, positiveBtnsOff,
                    neutralBtnsOn, neutralBtnsOff, negativeBtnsOn, negativeBtnsOff);


        }
        presenter.makePeopleWork(dreamPrefsEditor, getContext(), peopleNames, namesHints,
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



        return inflater.inflate(R.layout.fragment_dream_info_input_one,
                container, false);

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
        Typeface fontTitle = Typeface.createFromAsset(getContext().getAssets(), "fonts/kalameh_black.ttf");
        Typeface fontSubTitle = Typeface.createFromAsset(getContext().getAssets(), "fonts/kalameh_bold.ttf");
        Typeface fontReg = Typeface.createFromAsset(getContext().getAssets(), "fonts/kalameh_regular.ttf");
        MoonTextView titleDreamInfo = getView().findViewById(R.id.title_dream_info);
        MoonTextView titleMood = getView().findViewById(R.id.title_mood);
        MoonTextView hintMood = getView().findViewById(R.id.hint_mood);
        MoonTextView titlePeople = getView().findViewById(R.id.title_people);
        MoonTextView hintPeopleExpanded = getView().findViewById(R.id.hint_people_expanded);
        MoonTextView titleNames = getView().findViewById(R.id.title_names);
        MoonTextView hintNames = getView().findViewById(R.id.hint_names);
        MoonTextView edtTxtNames = getView().findViewById(R.id.edt_txt_names);
        MoonTextView titleFeelings = getView().findViewById(R.id.title_feelings);
        MoonTextView hintFeelings = getView().findViewById(R.id.hint_feelings);
        MoonTextView hintFeelings2 = getView().findViewById(R.id.hint_feelings2);
        MoonTextView hintFeelings3 = getView().findViewById(R.id.hint_feelings3);
        MoonTextView hintFeelings4 = getView().findViewById(R.id.hint_feelings4);
        MoonTextView hintFeelings5 = getView().findViewById(R.id.hint_feelings5);
        MoonTextView hintFeelings6 = getView().findViewById(R.id.hint_feelings6);
        MoonTextView hintFeelings7 = getView().findViewById(R.id.hint_feelings7);
        MoonTextView hintFeelings8 = getView().findViewById(R.id.hint_feelings8);
        MoonTextView hintFeelings9 = getView().findViewById(R.id.hint_feelings9);
        MoonTextView hintFeelings10 = getView().findViewById(R.id.hint_feelings10);
        MoonTextView positive1On = getView().findViewById(R.id.positive1_on);
        MoonTextView positive2On = getView().findViewById(R.id.positive2_on);
        MoonTextView positive3On = getView().findViewById(R.id.positive3_on);
        MoonTextView positive4On = getView().findViewById(R.id.positive4_on);
        MoonTextView positive5On = getView().findViewById(R.id.positive5_on);
        MoonTextView positiveOn6 = getView().findViewById(R.id.positive_on6);
        MoonTextView positiveOn7 = getView().findViewById(R.id.positive_on7);
        MoonTextView positiveOn8 = getView().findViewById(R.id.positive_on8);
        MoonTextView positiveOn9 = getView().findViewById(R.id.positive_on9);
        MoonTextView positiveOn10 = getView().findViewById(R.id.positive_on10);
        MoonTextView positive1Off = getView().findViewById(R.id.positive1_off);
        MoonTextView positive2Off = getView().findViewById(R.id.positive2_off);
        MoonTextView positive3Off = getView().findViewById(R.id.positive3_off);
        MoonTextView positive4Off = getView().findViewById(R.id.positive4_off);
        MoonTextView positive5Off = getView().findViewById(R.id.positive5_off);
        MoonTextView positiveOff6 = getView().findViewById(R.id.positive_off6);
        MoonTextView positiveOff7 = getView().findViewById(R.id.positive_off7);
        MoonTextView positiveOff8 = getView().findViewById(R.id.positive_off8);
        MoonTextView positiveOff9 = getView().findViewById(R.id.positive_off9);
        MoonTextView positiveOff10 = getView().findViewById(R.id.positive_off10);
        MoonTextView neutral1On = getView().findViewById(R.id.neutral1_on);
        MoonTextView neutral2On = getView().findViewById(R.id.neutral2_on);
        MoonTextView neutral3On = getView().findViewById(R.id.neutral3_on);
        MoonTextView neutral4On = getView().findViewById(R.id.neutral4_on);
        MoonTextView neutral5On = getView().findViewById(R.id.neutral5_on);
        MoonTextView neutralOn6 = getView().findViewById(R.id.neutral_on6);
        MoonTextView neutralOn7 = getView().findViewById(R.id.neutral_on7);
        MoonTextView neutralOn8 = getView().findViewById(R.id.neutral_on8);
        MoonTextView neutralOn9 = getView().findViewById(R.id.neutral_on9);
        MoonTextView neutralOn10 = getView().findViewById(R.id.neutral_on10);
        MoonTextView neutral1Off = getView().findViewById(R.id.neutral1_off);
        MoonTextView neutral2Off = getView().findViewById(R.id.neutral2_off);
        MoonTextView neutral3Off = getView().findViewById(R.id.neutral3_off);
        MoonTextView neutral4Off = getView().findViewById(R.id.neutral4_off);
        MoonTextView neutral5Off = getView().findViewById(R.id.neutral5_off);
        MoonTextView neutralOff6 = getView().findViewById(R.id.neutral_off6);
        MoonTextView neutralOff7 = getView().findViewById(R.id.neutral_off7);
        MoonTextView neutralOff8 = getView().findViewById(R.id.neutral_off8);
        MoonTextView neutralOff9 = getView().findViewById(R.id.neutral_off9);
        MoonTextView neutralOff10 = getView().findViewById(R.id.neutral_off10);
        MoonTextView negative1On = getView().findViewById(R.id.negative1_on);
        MoonTextView negative2On = getView().findViewById(R.id.negative2_on);
        MoonTextView negative3On = getView().findViewById(R.id.negative3_on);
        MoonTextView negative4On = getView().findViewById(R.id.negative4_on);
        MoonTextView negative5On = getView().findViewById(R.id.negative5_on);
        MoonTextView negativeOn6 = getView().findViewById(R.id.negative_on6);
        MoonTextView negativeOn7 = getView().findViewById(R.id.negative_on7);
        MoonTextView negativeOn8 = getView().findViewById(R.id.negative_on8);
        MoonTextView negativeOn9 = getView().findViewById(R.id.negative_on9);
        MoonTextView negativeOn10 = getView().findViewById(R.id.negative_on10);
        MoonTextView negative1Off = getView().findViewById(R.id.negative1_off);
        MoonTextView negative2Off = getView().findViewById(R.id.negative2_off);
        MoonTextView negative3Off = getView().findViewById(R.id.negative3_off);
        MoonTextView negative4Off = getView().findViewById(R.id.negative4_off);
        MoonTextView negative5Off = getView().findViewById(R.id.negative5_off);
        MoonTextView negativeOff6 = getView().findViewById(R.id.negative_off6);
        MoonTextView negativeOff7 = getView().findViewById(R.id.negative_off7);
        MoonTextView negativeOff8 = getView().findViewById(R.id.negative_off8);
        MoonTextView negativeOff9 = getView().findViewById(R.id.negative_off9);
        MoonTextView negativeOff10 = getView().findViewById(R.id.negative_off10);
        MoonTextView titleColor = getView().findViewById(R.id.title_color);
        MoonTextView hintColor = getView().findViewById(R.id.hint_color);
        MoonTextView colorful = getView().findViewById(R.id.colorful);
        MoonTextView grayscale = getView().findViewById(R.id.grayscale);
        MoonTextView colorfulOff = getView().findViewById(R.id.colorfulOff);
        MoonTextView grayscaleOff = getView().findViewById(R.id.grayscaleOff);
        MoonTextView titleSounds = getView().findViewById(R.id.title_sounds);
        MoonTextView hintSounds = getView().findViewById(R.id.hint_sounds);
        MoonTextView hintSoundsTwo = getView().findViewById(R.id.hint_sounds_two);
        MoonTextView musicalOn = getView().findViewById(R.id.musicalOn);
        MoonTextView nonMusicalOn = getView().findViewById(R.id.nonMusicalOn);
        MoonTextView musicalOff = getView().findViewById(R.id.musicalOff);
        MoonTextView nonMusicalOff = getView().findViewById(R.id.nonMusicalOff);
        MoonTextView titleSoundsOff = getView().findViewById(R.id.title_sounds_off);
        MoonTextView hintSoundsOff = getView().findViewById(R.id.hint_sounds_off);
        AppCompatButton nextBtn = getView().findViewById(R.id.nextBtn);
        AppCompatButton prevBtn = getView().findViewById(R.id.prevBtn);
        titleDreamInfo.setTypeface(fontTitle);
        titleMood.setTypeface(fontTitle);
        hintMood.setTypeface(fontSubTitle);
        titlePeople.setTypeface(fontTitle);
        hintPeopleExpanded.setTypeface(fontSubTitle);
        titleNames.setTypeface(fontTitle);
        hintNames.setTypeface(fontSubTitle);
        edtTxtNames.setTypeface(fontReg);
        titleFeelings.setTypeface(fontTitle);
        hintFeelings.setTypeface(fontSubTitle);
        hintFeelings2.setTypeface(fontSubTitle);
        hintFeelings3.setTypeface(fontSubTitle);
        hintFeelings4.setTypeface(fontSubTitle);
        hintFeelings5.setTypeface(fontSubTitle);
        hintFeelings6.setTypeface(fontSubTitle);
        hintFeelings7.setTypeface(fontSubTitle);
        hintFeelings8.setTypeface(fontSubTitle);
        hintFeelings9.setTypeface(fontSubTitle);
        hintFeelings10.setTypeface(fontSubTitle);
        positive1On.setTypeface(fontReg);
        positive1Off.setTypeface(fontReg);
        positive2On.setTypeface(fontReg);
        positive2Off.setTypeface(fontReg);
        positive3On.setTypeface(fontReg);
        positive3Off.setTypeface(fontReg);
        positive4On.setTypeface(fontReg);
        positive4Off.setTypeface(fontReg);
        positive5On.setTypeface(fontReg);
        positive5Off.setTypeface(fontReg);
        positiveOn6.setTypeface(fontReg);
        positiveOff6.setTypeface(fontReg);
        positiveOn7.setTypeface(fontReg);
        positiveOff7.setTypeface(fontReg);
        positiveOn8.setTypeface(fontReg);
        positiveOff8.setTypeface(fontReg);
        positiveOn9.setTypeface(fontReg);
        positiveOff9.setTypeface(fontReg);
        positiveOn10.setTypeface(fontReg);
        positiveOff10.setTypeface(fontReg);
        neutral1On.setTypeface(fontReg);
        neutral1Off.setTypeface(fontReg);
        neutral2On.setTypeface(fontReg);
        neutral2Off.setTypeface(fontReg);
        neutral3On.setTypeface(fontReg);
        neutral3Off.setTypeface(fontReg);
        neutral4On.setTypeface(fontReg);
        neutral4Off.setTypeface(fontReg);
        neutral5On.setTypeface(fontReg);
        neutral5Off.setTypeface(fontReg);
        neutralOn6.setTypeface(fontReg);
        neutralOff6.setTypeface(fontReg);
        neutralOn7.setTypeface(fontReg);
        neutralOff7.setTypeface(fontReg);
        neutralOn8.setTypeface(fontReg);
        neutralOff8.setTypeface(fontReg);
        neutralOn9.setTypeface(fontReg);
        neutralOff9.setTypeface(fontReg);
        neutralOn10.setTypeface(fontReg);
        neutralOff10.setTypeface(fontReg);
        negative1On.setTypeface(fontReg);
        negative1Off.setTypeface(fontReg);
        negative2On.setTypeface(fontReg);
        negative2Off.setTypeface(fontReg);
        negative3On.setTypeface(fontReg);
        negative3Off.setTypeface(fontReg);
        negative4On.setTypeface(fontReg);
        negative4Off.setTypeface(fontReg);
        negative5On.setTypeface(fontReg);
        negative5Off.setTypeface(fontReg);
        negativeOn6.setTypeface(fontReg);
        negativeOff6.setTypeface(fontReg);
        negativeOn7.setTypeface(fontReg);
        negativeOff7.setTypeface(fontReg);
        negativeOn8.setTypeface(fontReg);
        negativeOff8.setTypeface(fontReg);
        negativeOn9.setTypeface(fontReg);
        negativeOff9.setTypeface(fontReg);
        negativeOn10.setTypeface(fontReg);
        negativeOff10.setTypeface(fontReg);
        titleColor.setTypeface(fontTitle);
        hintColor.setTypeface(fontSubTitle);
        colorful.setTypeface(fontReg);
        grayscale.setTypeface(fontReg);
        colorfulOff.setTypeface(fontReg);
        grayscaleOff.setTypeface(fontReg);
        titleSounds.setTypeface(fontTitle);
        hintSounds.setTypeface(fontSubTitle);
        hintSoundsTwo.setTypeface(fontSubTitle);
        musicalOn.setTypeface(fontReg);
        nonMusicalOn.setTypeface(fontReg);
        musicalOff.setTypeface(fontReg);
        nonMusicalOff.setTypeface(fontReg);
        titleSoundsOff.setTypeface(fontTitle);
        hintSoundsOff.setTypeface(fontSubTitle);
        nextBtn.setTypeface(fontTitle);
        prevBtn.setTypeface(fontTitle);
    }
}
