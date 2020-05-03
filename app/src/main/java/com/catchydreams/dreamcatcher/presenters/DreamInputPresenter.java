package com.catchydreams.dreamcatcher.presenters;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import com.catchydreams.dreamcatcher.R;
import com.catchydreams.dreamcatcher.activities.viewInterfaces.IDreamInfoInput;
import com.catchydreams.dreamcatcher.constants.ConnectionChecker;
import com.catchydreams.dreamcatcher.database.Database;
import com.catchydreams.dreamcatcher.database.posts.PostsEntity;
import com.catchydreams.dreamcatcher.managersAndFilters.IConnectionChecker;
import com.catchydreams.dreamcatcher.managersAndFilters.SharedPreferencesManager;
import com.catchydreams.dreamcatcher.parameters.IResponseMessage;
import com.catchydreams.dreamcatcher.parameters.Users;
import com.catchydreams.dreamcatcher.parameters.dateParameters.parameters.Date;
import com.catchydreams.dreamcatcher.parameters.postParameters.dreamParameters.DreamChecklist;
import com.catchydreams.dreamcatcher.parameters.postParameters.dreamParameters.DreamDescription;
import com.catchydreams.dreamcatcher.parameters.postParameters.dreamParameters.DreamInterpretation;
import com.catchydreams.dreamcatcher.parameters.postParameters.dreamParameters.DreamLucidity;
import com.catchydreams.dreamcatcher.parameters.postParameters.dreamParameters.DreamPeople;
import com.catchydreams.dreamcatcher.parameters.postParameters.dreamParameters.DreamSound;
import com.catchydreams.dreamcatcher.parameters.postParameters.majorParameters.Dream;
import com.catchydreams.dreamcatcher.ui.customDialog.dialogViews.ViewDreamInputDialog;
import com.catchydreams.dreamcatcher.ui.customFont.MoonTextView;
import com.catchydreams.dreamcatcher.webservice.ApiPostCaller;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DreamInputPresenter {
    Dream dream;
    DreamChecklist checklist;
    DreamPeople people;
    DreamSound sound;
    DreamLucidity lucidity;
    DreamDescription description;
    Date date;
    IDreamInfoInput iDreamInfoInput;
    String newNames;
    public DreamInputPresenter(IDreamInfoInput iDreamInfoInput) {
        this.iDreamInfoInput = iDreamInfoInput;
    }

    public void setTitleFonts(List<MoonTextView> titles) {
        for (int i = 0; i < titles.size(); i++) {
            iDreamInfoInput.setTitleFonts(titles.get(i));
        }
    }

    public void splitNames(SharedPreferences languagePrefs, SharedPreferences.Editor dreamPrefsEditor,
                           Context context, AppCompatEditText peopleNames,
                           List<AppCompatTextView> namesHints,
                           List<RelativeLayout> feelingsOnLayouts,
                           List<RelativeLayout> feelingsOffLayouts,
                           List<LinearLayout> positiveBtnsOn,
                           List<LinearLayout> positiveBtnsOff,
                           List<LinearLayout> neutralBtnsOn,
                           List<LinearLayout> neutralBtnsOff,
                           List<LinearLayout> negativeBtnsOn,
                           List<LinearLayout> negativeBtnsOff){
        String language = languagePrefs.getString("language", "en");
        if (language.equals("en")){
            makeEngPeopleWork(dreamPrefsEditor, context, peopleNames, namesHints, feelingsOnLayouts,
                    feelingsOffLayouts, positiveBtnsOn, positiveBtnsOff, neutralBtnsOn,
                    neutralBtnsOff, negativeBtnsOn, negativeBtnsOff);
        } else if (language.equals("fa")) {
            makePerPeopleWork(dreamPrefsEditor, context, peopleNames, namesHints, feelingsOnLayouts,
                    feelingsOffLayouts, positiveBtnsOn, positiveBtnsOff, neutralBtnsOn,
                    neutralBtnsOff, negativeBtnsOn, negativeBtnsOff);
        }
    }

    public void setHintFonts(List<MoonTextView> hints) {
        for (int i = 0; i < hints.size(); i++) {
            iDreamInfoInput.setHintFonts(hints.get(i));
        }
    }

    public void setSubscriptFonts(List<MoonTextView> subscripts) {
        for (int i = 0; i < subscripts.size(); i++) {
            iDreamInfoInput.setSubscriptFonts(subscripts.get(i));
        }
    }

    public void setEditTextFonts(List<AppCompatEditText> hints) {
        for (int i = 0; i < hints.size(); i++) {
            iDreamInfoInput.setEditTextHintFonts(hints.get(i));
        }
    }

    public void setPersianTypeFace(SharedPreferences sharedPreferences) {
        String language = sharedPreferences.getString("language", "");
        if (language.equals("fa")) {
            iDreamInfoInput.setPersianTypeFace();
        }
    }

    public void setMoodSeekBar(SharedPreferences.Editor dreamPrefEditor, SeekBar experience,
                               Context context) {
        checklist = DreamChecklist.getInstance();
        experience.setMax(2);
        experience.setPadding(56, 0, 56, 0);
        experience.setThumbOffset(16);
        experience.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                checklist.setExperience(progress);
                dreamPrefEditor.putBoolean("hasMood", true).apply();
                dreamPrefEditor.putInt("mood", progress).apply();
                if (progress == 0) {
                    experience.setThumb(context.getResources().getDrawable(R.drawable.ic_sad_emoji));

                } else if (progress == 1) {
                    experience.setThumb(context.getResources().getDrawable(R.drawable.ic_poker_face_emoji));

                } else if (progress == 2) {
                    experience.setThumb(context.getResources().getDrawable(R.drawable.ic_happy_emoji));

                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void makeFeelingVisible(AppCompatTextView textView, RelativeLayout feelingsOn,
                                   RelativeLayout feelingsOff) {
        textView.setVisibility(View.VISIBLE);
        feelingsOn.setVisibility(View.VISIBLE);
        feelingsOff.setVisibility(View.VISIBLE);
    }

    private void makeExcessiveFeelingsInvisible(AppCompatTextView textView, RelativeLayout feelingsOn,
                                                RelativeLayout feelingsOff) {
        textView.setVisibility(View.GONE);
        feelingsOn.setVisibility(View.GONE);
        feelingsOff.setVisibility(View.GONE);
    }

    public void makeEngPeopleWork(SharedPreferences.Editor dreamPrefsEditor,
                               Context context, AppCompatEditText peopleNames,
                               List<AppCompatTextView> namesHints,
                               List<RelativeLayout> feelingsOnLayouts,
                               List<RelativeLayout> feelingsOffLayouts,
                               List<LinearLayout> positiveBtnsOn,
                               List<LinearLayout> positiveBtnsOff,
                               List<LinearLayout> neutralBtnsOn,
                               List<LinearLayout> neutralBtnsOff,
                               List<LinearLayout> negativeBtnsOn,
                               List<LinearLayout> negativeBtnsOff) {
        peopleNames.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (!s.toString().equals("")) {
                    String string = s.toString();
                    List<String> namesList = Arrays.asList(string.split(","));
                    String hint = context.getString(R.string.hint_feelings);
                    for (int i = 0; i < namesList.size(); i++) {
                        if (i < 10) {
                            DreamPeople people = DreamPeople.getInstance();
                            people.setName(i, namesList.get(i));
                            Dream dream = Dream.getInstance();
                            dream.setDreamPeople(people);

                            makeFeelingVisible(namesHints.get(i), feelingsOnLayouts.get(i),
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
                                    setPositiveBtnOn(dreamPrefsEditor, positiveBtnsOn.get(finalI),
                                            positiveBtnsOff.get(finalI), neutralBtnsOn.get(finalI),
                                            neutralBtnsOff.get(finalI), negativeBtnsOn.get(finalI),
                                            negativeBtnsOff.get(finalI));
                                }
                            });
                            positiveBtnsOn.get(i).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    setPositiveBtnOff(dreamPrefsEditor, positiveBtnsOn.get(finalI),
                                            positiveBtnsOff.get(finalI), neutralBtnsOff.get(finalI),
                                            negativeBtnsOff.get(finalI));
                                }
                            });
                            neutralBtnsOff.get(i).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    setNeutralBtnOn(dreamPrefsEditor, positiveBtnsOn.get(finalI),
                                            positiveBtnsOff.get(finalI), neutralBtnsOn.get(finalI),
                                            neutralBtnsOff.get(finalI), negativeBtnsOn.get(finalI),
                                            negativeBtnsOff.get(finalI));
                                }
                            });
                            neutralBtnsOn.get(i).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    setNeutralBtnOff(dreamPrefsEditor, positiveBtnsOff.get(finalI),
                                            neutralBtnsOn.get(finalI), neutralBtnsOff.get(finalI),
                                            negativeBtnsOff.get(finalI));
                                }
                            });
                            negativeBtnsOff.get(i).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    setNegativeBtnOn(dreamPrefsEditor, positiveBtnsOn.get(finalI),
                                            positiveBtnsOff.get(finalI), neutralBtnsOn.get(finalI),
                                            neutralBtnsOff.get(finalI), negativeBtnsOn.get(finalI),
                                            negativeBtnsOff.get(finalI));
                                }
                            });
                            negativeBtnsOn.get(i).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    setNegativeBtnOff(dreamPrefsEditor, positiveBtnsOff.get(finalI),
                                            neutralBtnsOff.get(finalI), negativeBtnsOn.get(finalI),
                                            negativeBtnsOff.get(finalI));
                                }
                            });

                        }
                    }
                    DreamPeople.getInstance().setPeopleCount(namesList.size());
                }

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String string = s.toString();
                List<String> namesList = Arrays.asList(string.split(","));
                int prevCount = DreamPeople.getInstance().getCount();
                if (namesList.size() < prevCount) {
                    Log.e("","");
                    List<Integer> disposables = new ArrayList<>();
                    for (int i = 0; i <= prevCount; i++) {
                        if (i >= namesList.size()){
                            disposables.add(i);
                        }
                    }
                    for (int i = 0; i < disposables.size();i++){
                        int disposable = disposables.get(i);
                        makeExcessiveFeelingsInvisible(namesHints.get(disposable),
                                feelingsOnLayouts.get(disposable), feelingsOffLayouts.get(disposable));
                        Log.e("","");
                    }
                    DreamPeople.delPeople();
                }

                String hint = context.getString(R.string.hint_feelings);
                for (int i = 0; i < namesList.size(); i++) {
                    if (i < 10) {

                        DreamPeople people = DreamPeople.getInstance();
                        people.setName(i, namesList.get(i));
                        Dream dream = Dream.getInstance();
                        dream.setDreamPeople(people);

                        makeFeelingVisible(namesHints.get(i), feelingsOnLayouts.get(i),
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
                                setPositiveBtnOn(dreamPrefsEditor, positiveBtnsOn.get(finalI),
                                        positiveBtnsOff.get(finalI), neutralBtnsOn.get(finalI),
                                        neutralBtnsOff.get(finalI), negativeBtnsOn.get(finalI),
                                        negativeBtnsOff.get(finalI));
                            }
                        });
                        positiveBtnsOn.get(i).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setPositiveBtnOff(dreamPrefsEditor, positiveBtnsOn.get(finalI),
                                        positiveBtnsOff.get(finalI), neutralBtnsOff.get(finalI),
                                        negativeBtnsOff.get(finalI));
                            }
                        });
                        neutralBtnsOff.get(i).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setNeutralBtnOn(dreamPrefsEditor, positiveBtnsOn.get(finalI),
                                        positiveBtnsOff.get(finalI), neutralBtnsOn.get(finalI),
                                        neutralBtnsOff.get(finalI), negativeBtnsOn.get(finalI),
                                        negativeBtnsOff.get(finalI));
                            }
                        });
                        neutralBtnsOn.get(i).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setNeutralBtnOff(dreamPrefsEditor, positiveBtnsOff.get(finalI),
                                        neutralBtnsOn.get(finalI), neutralBtnsOff.get(finalI),
                                        negativeBtnsOff.get(finalI));
                            }
                        });
                        negativeBtnsOff.get(i).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setNegativeBtnOn(dreamPrefsEditor, positiveBtnsOn.get(finalI),
                                        positiveBtnsOff.get(finalI), neutralBtnsOn.get(finalI),
                                        neutralBtnsOff.get(finalI), negativeBtnsOn.get(finalI),
                                        negativeBtnsOff.get(finalI));
                            }
                        });
                        negativeBtnsOn.get(i).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setNegativeBtnOff(dreamPrefsEditor, positiveBtnsOff.get(finalI),
                                        neutralBtnsOff.get(finalI), negativeBtnsOn.get(finalI),
                                        negativeBtnsOff.get(finalI));
                            }
                        });

                    }
                }
            }
        });
    }

    public void makePerPeopleWork(SharedPreferences.Editor dreamPrefsEditor,
                               Context context, AppCompatEditText peopleNames,
                               List<AppCompatTextView> namesHints,
                               List<RelativeLayout> feelingsOnLayouts,
                               List<RelativeLayout> feelingsOffLayouts,
                               List<LinearLayout> positiveBtnsOn,
                               List<LinearLayout> positiveBtnsOff,
                               List<LinearLayout> neutralBtnsOn,
                               List<LinearLayout> neutralBtnsOff,
                               List<LinearLayout> negativeBtnsOn,
                               List<LinearLayout> negativeBtnsOff) {
        peopleNames.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (!s.toString().equals("")) {
                    String string = s.toString();
                    List<String> namesList = Arrays.asList(string.split(" "));
                    Log.e("","");
                    String hint = context.getString(R.string.hint_feelings);
                    DreamPeople.getInstance().setPeopleCount(namesList.size());
                    for (int i = 0; i < namesList.size(); i++) {
                        if (i < 10) {
                            DreamPeople people = DreamPeople.getInstance();
                            people.setName(i, namesList.get(i));
                            Log.e("","");
                            Dream dream = Dream.getInstance();
                            dream.setDreamPeople(people);

                            makeFeelingVisible(namesHints.get(i), feelingsOnLayouts.get(i),
                                    feelingsOffLayouts.get(i));

                            String indexedHint = hint.replace("اون‌", namesList.get(i));

                            int nameLength = namesList.get(i).length();
                            SpannableString ss = new SpannableString(indexedHint);
                            ForegroundColorSpan fcs = new ForegroundColorSpan(Color.CYAN);
                            ss.setSpan(fcs, 15, 15 + nameLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                            namesHints.get(i).setText(ss);
                            int finalI = i;
                            positiveBtnsOff.get(i).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    setPositiveBtnOn(dreamPrefsEditor, positiveBtnsOn.get(finalI),
                                            positiveBtnsOff.get(finalI), neutralBtnsOn.get(finalI),
                                            neutralBtnsOff.get(finalI), negativeBtnsOn.get(finalI),
                                            negativeBtnsOff.get(finalI));
                                }
                            });
                            positiveBtnsOn.get(i).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    setPositiveBtnOff(dreamPrefsEditor, positiveBtnsOn.get(finalI),
                                            positiveBtnsOff.get(finalI), neutralBtnsOff.get(finalI),
                                            negativeBtnsOff.get(finalI));
                                }
                            });
                            neutralBtnsOff.get(i).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    setNeutralBtnOn(dreamPrefsEditor, positiveBtnsOn.get(finalI),
                                            positiveBtnsOff.get(finalI), neutralBtnsOn.get(finalI),
                                            neutralBtnsOff.get(finalI), negativeBtnsOn.get(finalI),
                                            negativeBtnsOff.get(finalI));
                                }
                            });
                            neutralBtnsOn.get(i).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    setNeutralBtnOff(dreamPrefsEditor, positiveBtnsOff.get(finalI),
                                            neutralBtnsOn.get(finalI), neutralBtnsOff.get(finalI),
                                            negativeBtnsOff.get(finalI));
                                }
                            });
                            negativeBtnsOff.get(i).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    setNegativeBtnOn(dreamPrefsEditor, positiveBtnsOn.get(finalI),
                                            positiveBtnsOff.get(finalI), neutralBtnsOn.get(finalI),
                                            neutralBtnsOff.get(finalI), negativeBtnsOn.get(finalI),
                                            negativeBtnsOff.get(finalI));
                                }
                            });
                            negativeBtnsOn.get(i).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    setNegativeBtnOff(dreamPrefsEditor, positiveBtnsOff.get(finalI),
                                            neutralBtnsOff.get(finalI), negativeBtnsOn.get(finalI),
                                            negativeBtnsOff.get(finalI));
                                }
                            });

                        }
                    }

                }

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String string = s.toString();
                List<String> namesList = Arrays.asList(string.split(" "));
                int prevCount = DreamPeople.getInstance().getCount();
                if (namesList.size() < prevCount) {
                    Log.e("","");
                    List<Integer> disposables = new ArrayList<>();
                    for (int i = 0; i <= prevCount; i++) {
                        if (i >= namesList.size()){
                            disposables.add(i);
                        }
                    }
                    for (int i = 0; i < disposables.size();i++){
                        int disposable = disposables.get(i);
                        if (disposable < namesHints.size()){
                            makeExcessiveFeelingsInvisible(namesHints.get(disposable),
                                    feelingsOnLayouts.get(disposable), feelingsOffLayouts.get(disposable));
                        }
                    }
                    DreamPeople.delPeople();
                }
                String hint = context.getString(R.string.hint_feelings);
                for (int i = 0; i < namesList.size(); i++) {
                    if (i < 10) {
                        DreamPeople people = DreamPeople.getInstance();
                        people.setName(i, namesList.get(i));
                        Dream dream = Dream.getInstance();
                        dream.setDreamPeople(people);

                        makeFeelingVisible(namesHints.get(i), feelingsOnLayouts.get(i),
                                feelingsOffLayouts.get(i));

                        String indexedHint = hint.replace("اون", namesList.get(i));

                        int nameLength = namesList.get(i).length();
                        SpannableString ss = new SpannableString(indexedHint);
                        ForegroundColorSpan fcs = new ForegroundColorSpan(Color.CYAN);
                        ss.setSpan(fcs, 15, 15 + nameLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        namesHints.get(i).setText(ss);
                        int finalI = i;
                        positiveBtnsOff.get(i).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setPositiveBtnOn(dreamPrefsEditor, positiveBtnsOn.get(finalI),
                                        positiveBtnsOff.get(finalI), neutralBtnsOn.get(finalI),
                                        neutralBtnsOff.get(finalI), negativeBtnsOn.get(finalI),
                                        negativeBtnsOff.get(finalI));
                            }
                        });
                        positiveBtnsOn.get(i).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setPositiveBtnOff(dreamPrefsEditor, positiveBtnsOn.get(finalI),
                                        positiveBtnsOff.get(finalI), neutralBtnsOff.get(finalI),
                                        negativeBtnsOff.get(finalI));
                            }
                        });
                        neutralBtnsOff.get(i).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setNeutralBtnOn(dreamPrefsEditor, positiveBtnsOn.get(finalI),
                                        positiveBtnsOff.get(finalI), neutralBtnsOn.get(finalI),
                                        neutralBtnsOff.get(finalI), negativeBtnsOn.get(finalI),
                                        negativeBtnsOff.get(finalI));
                            }
                        });
                        neutralBtnsOn.get(i).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setNeutralBtnOff(dreamPrefsEditor, positiveBtnsOff.get(finalI),
                                        neutralBtnsOn.get(finalI), neutralBtnsOff.get(finalI),
                                        negativeBtnsOff.get(finalI));
                            }
                        });
                        negativeBtnsOff.get(i).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setNegativeBtnOn(dreamPrefsEditor, positiveBtnsOn.get(finalI),
                                        positiveBtnsOff.get(finalI), neutralBtnsOn.get(finalI),
                                        neutralBtnsOff.get(finalI), negativeBtnsOn.get(finalI),
                                        negativeBtnsOff.get(finalI));
                            }
                        });
                        negativeBtnsOn.get(i).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setNegativeBtnOff(dreamPrefsEditor, positiveBtnsOff.get(finalI),
                                        neutralBtnsOff.get(finalI), negativeBtnsOn.get(finalI),
                                        negativeBtnsOff.get(finalI));
                            }
                        });

                    }
                }
            }
        }
        );

    }

    public void loadPeople(SharedPreferences dreamPrefs, SharedPreferences.Editor dreamPrefsEditor,
                           AppCompatEditText peopleNames,
                           List<AppCompatTextView> namesHints,
                           List<RelativeLayout> feelingsOnLayouts,
                           List<RelativeLayout> feelingsOffLayouts,
                           List<LinearLayout> positiveBtnsOn,
                           List<LinearLayout> positiveBtnsOff,
                           List<LinearLayout> neutralBtnsOn,
                           List<LinearLayout> neutralBtnsOff,
                           List<LinearLayout> negativeBtnsOn,
                           List<LinearLayout> negativeBtnsOff, String language) {

        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                if (dreamPrefs.getBoolean("hasName" + i + "", false)) {
                    String name = people.getName(i);
                    peopleNames.setText(name);
                }
            } else {
                if (!people.getName(i).equals("")) {
                    String name = people.getName(i);
                    String loadedNames = peopleNames.getText().toString();
                    if (language.equals("en")){
                        newNames = loadedNames + ", " + name;
                    } else if (language.equals("fa")){
                        newNames = loadedNames + " " + name;
                    }

                    peopleNames.setText(newNames);
                }
            }

            if (people.getImpression(i) > 0) {
                int impression = people.getImpression(i);
                namesHints.get(i).setVisibility(View.VISIBLE);
                feelingsOnLayouts.get(i).setVisibility(View.VISIBLE);
                feelingsOffLayouts.get(i).setVisibility(View.VISIBLE);
                switch (impression) {
                    case 1:
                        setNegativeBtnOn(dreamPrefsEditor, positiveBtnsOn.get(i),
                                positiveBtnsOff.get(i), neutralBtnsOn.get(i),
                                neutralBtnsOff.get(i), negativeBtnsOn.get(i),
                                negativeBtnsOff.get(i));
                        break;
                    case 2:
                        setNeutralBtnOn(dreamPrefsEditor, positiveBtnsOn.get(i),
                                positiveBtnsOff.get(i), neutralBtnsOn.get(i),
                                neutralBtnsOff.get(i), negativeBtnsOn.get(i),
                                negativeBtnsOff.get(i));
                        break;
                    case 3:
                        setPositiveBtnOn(dreamPrefsEditor, positiveBtnsOn.get(i),
                                positiveBtnsOff.get(i), neutralBtnsOn.get(i),
                                neutralBtnsOff.get(i), negativeBtnsOn.get(i),
                                negativeBtnsOff.get(i));
                        break;
                }
            }
        }
    }

    public void setPeopleBtnOn(SharedPreferences.Editor dreamPrefEditor,
                               RelativeLayout peopleExpanded, RelativeLayout peopleClosed) {
        people = DreamPeople.getInstance();
        people.setExistent(1);
        dreamPrefEditor.putBoolean("hasPeople", true).apply();
        if (peopleExpanded.getVisibility() == View.VISIBLE) {
            peopleExpanded.setVisibility(View.GONE);
            peopleClosed.setVisibility(View.VISIBLE);
        } else {
            peopleExpanded.setVisibility(View.VISIBLE);
            peopleClosed.setVisibility(View.GONE);
        }

    }

    public void setPeopleBtnOff(SharedPreferences.Editor dreamPrefEditor,
                                RelativeLayout peopleExpanded, RelativeLayout peopleClosed) {
        people = DreamPeople.getInstance();
        people.setExistent(0);
        dreamPrefEditor.putBoolean("hasPeople", false).apply();
        if (peopleClosed.getVisibility() == View.VISIBLE) {
            peopleClosed.setVisibility(View.GONE);
            peopleExpanded.setVisibility(View.VISIBLE);
        } else {
            peopleClosed.setVisibility(View.VISIBLE);
            peopleExpanded.setVisibility(View.GONE);
        }
    }

    public void setSoundBtnOn(SharedPreferences.Editor dreamPrefEditor,
                              RelativeLayout soundsExpanded, RelativeLayout soundsClosed) {
        sound = DreamSound.getInstance();
        sound.setSound(1);
        dreamPrefEditor.putBoolean("hasSound", true).apply();
        if (soundsExpanded.getVisibility() == View.VISIBLE) {
            soundsExpanded.setVisibility(View.GONE);
            soundsClosed.setVisibility(View.VISIBLE);
        } else {
            soundsExpanded.setVisibility(View.VISIBLE);
            soundsClosed.setVisibility(View.GONE);
        }
    }

    public void setSoundBtnOff(SharedPreferences.Editor dreamPrefEditor,
                               RelativeLayout soundsExpanded, RelativeLayout soundsClosed) {
        sound = DreamSound.getInstance();
        sound.setSound(0);
        dreamPrefEditor.putBoolean("hasSound", false).apply();
        if (soundsClosed.getVisibility() == View.VISIBLE) {
            soundsClosed.setVisibility(View.GONE);
            soundsExpanded.setVisibility(View.VISIBLE);
        } else {
            soundsClosed.setVisibility(View.VISIBLE);
            soundsExpanded.setVisibility(View.GONE);
        }
    }

    public void setPositiveBtnOn(SharedPreferences.Editor dreamPrefEditor,
                                 LinearLayout positiveOn, LinearLayout positiveOff,
                                 LinearLayout neutralOn, LinearLayout neutralOff,
                                 LinearLayout negativeOn, LinearLayout negativeOff) {
        people = DreamPeople.getInstance();

        /**dreamPrefEditor.putBoolean("hasImpression", true).apply();
         dreamPrefEditor.putInt("impression", 3).apply();**/
        if (positiveOn.getVisibility() == View.VISIBLE) {
            positiveOn.setVisibility(View.INVISIBLE);
            positiveOff.setVisibility(View.VISIBLE);
        } else {
            positiveOn.setVisibility(View.VISIBLE);
            neutralOn.setVisibility(View.INVISIBLE);
            neutralOff.setVisibility(View.VISIBLE);
            negativeOn.setVisibility(View.INVISIBLE);
            negativeOff.setVisibility(View.VISIBLE);
            positiveOff.setVisibility(View.INVISIBLE);
        }
    }

    public void setPositiveBtnOff(SharedPreferences.Editor dreamPrefEditor,
                                  LinearLayout positiveOn, LinearLayout positiveOff,
                                  LinearLayout neutralOff, LinearLayout negativeOff) {
        people = DreamPeople.getInstance();

        /**dreamPrefEditor.putBoolean("hasImpression", false).apply();
         dreamPrefEditor.putInt("impression", 0).apply();**/
        if (positiveOff.getVisibility() == View.VISIBLE) {
            positiveOff.setVisibility(View.INVISIBLE);
            positiveOn.setVisibility(View.VISIBLE);
        } else {
            positiveOff.setVisibility(View.VISIBLE);
            positiveOn.setVisibility(View.INVISIBLE);
            negativeOff.setVisibility(View.VISIBLE);
            neutralOff.setVisibility(View.VISIBLE);
        }
    }

    public void setNeutralBtnOn(SharedPreferences.Editor dreamPrefEditor,
                                LinearLayout positiveOn, LinearLayout positiveOff,
                                LinearLayout neutralOn, LinearLayout neutralOff,
                                LinearLayout negativeOn, LinearLayout negativeOff) {
        people = DreamPeople.getInstance();
        /**dreamPrefEditor.putBoolean("hasImpression", true).apply();
         dreamPrefEditor.putInt("impression", 2).apply();**/
        if (neutralOn.getVisibility() == View.VISIBLE) {
            neutralOn.setVisibility(View.INVISIBLE);
            neutralOff.setVisibility(View.VISIBLE);
        } else {
            neutralOn.setVisibility(View.VISIBLE);
            positiveOn.setVisibility(View.INVISIBLE);
            positiveOff.setVisibility(View.VISIBLE);
            negativeOn.setVisibility(View.INVISIBLE);
            negativeOff.setVisibility(View.VISIBLE);
            neutralOff.setVisibility(View.INVISIBLE);
        }
    }

    public void setNeutralBtnOff(SharedPreferences.Editor dreamPrefEditor,
                                 LinearLayout positiveOff, LinearLayout neutralOn,
                                 LinearLayout neutralOff, LinearLayout negativeOff) {
        people = DreamPeople.getInstance();
        dreamPrefEditor.putBoolean("hasImpression", false).apply();
        dreamPrefEditor.putInt("impression", 0).apply();
        if (neutralOff.getVisibility() == View.VISIBLE) {
            neutralOff.setVisibility(View.INVISIBLE);
            neutralOn.setVisibility(View.VISIBLE);
        } else {
            neutralOff.setVisibility(View.VISIBLE);
            neutralOn.setVisibility(View.INVISIBLE);
            negativeOff.setVisibility(View.VISIBLE);
            positiveOff.setVisibility(View.VISIBLE);
        }
    }

    public void setNegativeBtnOn(SharedPreferences.Editor dreamPrefEditor,
                                 LinearLayout positiveOn, LinearLayout positiveOff,
                                 LinearLayout neutralOn, LinearLayout neutralOff,
                                 LinearLayout negativeOn, LinearLayout negativeOff) {
        people = DreamPeople.getInstance();
        if (negativeOn.getVisibility() == View.VISIBLE) {
            negativeOn.setVisibility(View.INVISIBLE);
            negativeOff.setVisibility(View.VISIBLE);
        } else {
            negativeOn.setVisibility(View.VISIBLE);
            positiveOn.setVisibility(View.INVISIBLE);
            positiveOff.setVisibility(View.VISIBLE);
            neutralOn.setVisibility(View.INVISIBLE);
            neutralOff.setVisibility(View.VISIBLE);
            negativeOff.setVisibility(View.INVISIBLE);
        }
    }

    public void setNegativeBtnOff(SharedPreferences.Editor dreamPrefEditor,
                                  LinearLayout positiveOff, LinearLayout neutralOff,
                                  LinearLayout negativeOn, LinearLayout negativeOff) {
        people = DreamPeople.getInstance();
        dreamPrefEditor.putBoolean("hasImpression", false).apply();
        dreamPrefEditor.putInt("impression", 0).apply();
        if (negativeOff.getVisibility() == View.VISIBLE) {
            negativeOff.setVisibility(View.INVISIBLE);
            negativeOn.setVisibility(View.VISIBLE);
        } else {
            negativeOff.setVisibility(View.VISIBLE);
            negativeOn.setVisibility(View.INVISIBLE);
            positiveOff.setVisibility(View.VISIBLE);
            neutralOff.setVisibility(View.VISIBLE);
        }
    }

    public void setColorfulBtnOn(SharedPreferences.Editor dreamPrefEditor,
                                 LinearLayout colorOn, LinearLayout colorOff,
                                 LinearLayout grayOn, LinearLayout grayOff,
                                 RelativeLayout colorfulOff) {
        checklist = DreamChecklist.getInstance();
        checklist.setGrayScale(2);
        dreamPrefEditor.putBoolean("hasColor", true).apply();
        dreamPrefEditor.putBoolean("hasGray", false).apply();
        if (colorOn.getVisibility() == View.VISIBLE) {
            colorOn.setVisibility(View.INVISIBLE);
            colorOff.setVisibility(View.VISIBLE);
        } else {
            colorOn.setVisibility(View.VISIBLE);
            grayOn.setVisibility(View.INVISIBLE);
            grayOff.setVisibility(View.VISIBLE);
            colorOff.setVisibility(View.INVISIBLE);
            colorfulOff.setBackgroundResource(R.drawable.bg_invisible);
        }
    }

    public void setColorfulBtnOff(SharedPreferences.Editor dreamPrefEditor,
                                  LinearLayout colorOn, LinearLayout colorOff, LinearLayout grayOff) {
        checklist = DreamChecklist.getInstance();
        checklist.setGrayScale(0);
        dreamPrefEditor.putBoolean("hasColor", false).apply();
        if (colorOff.getVisibility() == View.VISIBLE) {
            colorOff.setVisibility(View.INVISIBLE);
            colorOn.setVisibility(View.VISIBLE);
        } else {
            colorOff.setVisibility(View.VISIBLE);
            colorOn.setVisibility(View.INVISIBLE);
            grayOff.setVisibility(View.VISIBLE);

        }
    }

    public void setGrayScaleBtnOn(SharedPreferences.Editor dreamPrefEditor,
                                  LinearLayout colorOn, LinearLayout colorOff,
                                  LinearLayout grayOn, LinearLayout grayOff, RelativeLayout colorfulOff) {
        checklist = DreamChecklist.getInstance();
        checklist.setGrayScale(1);
        dreamPrefEditor.putBoolean("hasGray", true).apply();
        dreamPrefEditor.putBoolean("hasColor", false).apply();
        if (grayOn.getVisibility() == View.VISIBLE) {
            grayOn.setVisibility(View.INVISIBLE);
            grayOff.setVisibility(View.VISIBLE);
        } else {
            grayOn.setVisibility(View.VISIBLE);
            colorOn.setVisibility(View.INVISIBLE);
            colorOff.setVisibility(View.VISIBLE);
            grayOff.setVisibility(View.INVISIBLE);
            colorfulOff.setBackgroundResource(R.drawable.bg_invisible);
        }
    }

    public void setGrayScaleBtnOff(SharedPreferences.Editor dreamPrefEditor, LinearLayout colorOff,
                                   LinearLayout grayOn, LinearLayout grayOff) {
        checklist = DreamChecklist.getInstance();
        checklist.setGrayScale(0);
        dreamPrefEditor.putBoolean("hasGray", false).apply();
        if (grayOff.getVisibility() == View.VISIBLE) {
            grayOff.setVisibility(View.INVISIBLE);
            grayOn.setVisibility(View.VISIBLE);
        } else {
            grayOff.setVisibility(View.VISIBLE);
            grayOn.setVisibility(View.INVISIBLE);
            colorOff.setVisibility(View.VISIBLE);
        }
    }

    public void setMusicalBtnOn(SharedPreferences.Editor dreamPrefEditor,
                                LinearLayout museOn, LinearLayout museOff,
                                LinearLayout nonMuseOn, LinearLayout nonMuseOff) {
        sound = DreamSound.getInstance();
        sound.setMusical(2);
        dreamPrefEditor.putBoolean("hasMusic", true).apply();
        dreamPrefEditor.putBoolean("hasNonMusic", false).apply();
        if (museOn.getVisibility() == View.VISIBLE) {
            museOn.setVisibility(View.INVISIBLE);
            museOff.setVisibility(View.VISIBLE);
        } else {
            museOn.setVisibility(View.VISIBLE);
            nonMuseOn.setVisibility(View.INVISIBLE);
            museOff.setVisibility(View.INVISIBLE);
            nonMuseOff.setVisibility(View.VISIBLE);
        }
    }

    public void setMusicalBtnOff(SharedPreferences.Editor dreamPrefEditor,
                                 LinearLayout museOn, LinearLayout museOff,
                                 LinearLayout nonMuseOff) {
        sound = DreamSound.getInstance();
        sound.setMusical(0);
        dreamPrefEditor.putBoolean("hasMusic", false).apply();
        if (museOff.getVisibility() == View.VISIBLE) {
            museOff.setVisibility(View.INVISIBLE);
            museOn.setVisibility(View.VISIBLE);
        } else {
            museOff.setVisibility(View.VISIBLE);
            museOn.setVisibility(View.INVISIBLE);
            nonMuseOff.setVisibility(View.VISIBLE);
        }
    }

    public void setNonMusicalBtnOn(SharedPreferences.Editor dreamPrefEditor,
                                   LinearLayout museOn, LinearLayout museOff,
                                   LinearLayout nonMuseOn, LinearLayout nonMuseOff) {
        sound = DreamSound.getInstance();
        sound.setMusical(1);
        dreamPrefEditor.putBoolean("hasNonMusic", true).apply();
        dreamPrefEditor.putBoolean("hasMusic", false).apply();
        if (nonMuseOn.getVisibility() == View.VISIBLE) {
            nonMuseOn.setVisibility(View.INVISIBLE);
            nonMuseOff.setVisibility(View.VISIBLE);
        } else {
            nonMuseOn.setVisibility(View.VISIBLE);
            museOn.setVisibility(View.INVISIBLE);
            museOff.setVisibility(View.VISIBLE);
            nonMuseOff.setVisibility(View.INVISIBLE);
        }
    }

    public void setNonMusicalBtnOff(SharedPreferences.Editor dreamPrefEditor, LinearLayout museOff,
                                    LinearLayout nonMuseOn, LinearLayout nonMuseOff) {
        sound = DreamSound.getInstance();
        sound.setMusical(0);
        dreamPrefEditor.putBoolean("hasNonMusic", false).apply();
        if (nonMuseOff.getVisibility() == View.VISIBLE) {
            nonMuseOff.setVisibility(View.INVISIBLE);
            nonMuseOn.setVisibility(View.VISIBLE);
        } else {
            nonMuseOff.setVisibility(View.VISIBLE);
            nonMuseOn.setVisibility(View.INVISIBLE);
            museOff.setVisibility(View.VISIBLE);
        }
    }

    public void setTextListener(String textTitle, AppCompatEditText text, SharedPreferences sp) {
        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                sp.edit().putBoolean(textTitle + "Exists", true).apply();
                sp.edit().putString(textTitle, s.toString()).apply();
            }
        });
    }

    public void saveSpinnerIndex(String title, Spinner spinner, SharedPreferences sp) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sp.edit().putBoolean(title + "Exists", true).apply();
                sp.edit().putInt(title, position).apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void saveHalfWayDream(AppCompatEditText edtTxtNames,
                                 LinearLayout positiveOn,
                                 LinearLayout positiveOn2,
                                 LinearLayout positiveOn3,
                                 LinearLayout positiveOn4,
                                 LinearLayout positiveOn5,
                                 LinearLayout positiveOn6,
                                 LinearLayout positiveOn7,
                                 LinearLayout positiveOn8,
                                 LinearLayout positiveOn9,
                                 LinearLayout positiveOn10,
                                 LinearLayout neutralOn,
                                 LinearLayout neutralOn2,
                                 LinearLayout neutralOn3,
                                 LinearLayout neutralOn4,
                                 LinearLayout neutralOn5,
                                 LinearLayout neutralOn6,
                                 LinearLayout neutralOn7,
                                 LinearLayout neutralOn8,
                                 LinearLayout neutralOn9,
                                 LinearLayout neutralOn10,
                                 LinearLayout negativeOn,
                                 LinearLayout negativeOn2,
                                 LinearLayout negativeOn3,
                                 LinearLayout negativeOn4,
                                 LinearLayout negativeOn5,
                                 LinearLayout negativeOn6,
                                 LinearLayout negativeOn7,
                                 LinearLayout negativeOn8,
                                 LinearLayout negativeOn9,
                                 LinearLayout negativeOn10,
                                 AppCompatTextView hintFeelings,
                                 AppCompatTextView hintFeelings2,
                                 AppCompatTextView hintFeelings3,
                                 AppCompatTextView hintFeelings4,
                                 AppCompatTextView hintFeelings5,
                                 AppCompatTextView hintFeelings6,
                                 AppCompatTextView hintFeelings7,
                                 AppCompatTextView hintFeelings8,
                                 AppCompatTextView hintFeelings9,
                                 AppCompatTextView hintFeelings10) {
        dream = Dream.getInstance();
        checklist = DreamChecklist.getInstance();
        sound = DreamSound.getInstance();
        lucidity = DreamLucidity.getInstance();
        String string = edtTxtNames.getText().toString();
        List<String> namesList = Arrays.asList(string.split(","));
        setImpressions(positiveOn, positiveOn2, positiveOn3, positiveOn4, positiveOn5, positiveOn6,
                positiveOn7, positiveOn8, positiveOn9, positiveOn10, neutralOn, neutralOn2, neutralOn3,
                neutralOn4, neutralOn5, neutralOn6, neutralOn7, neutralOn8, neutralOn9, neutralOn10,
                negativeOn, negativeOn2, negativeOn3, negativeOn4, negativeOn5, negativeOn6, negativeOn7,
                negativeOn8, negativeOn9, negativeOn10, hintFeelings, hintFeelings2, hintFeelings3,
                hintFeelings4, hintFeelings5, hintFeelings6, hintFeelings7, hintFeelings8,
                hintFeelings9, hintFeelings10);
        dream.setDreamPeople(people);
        dream.setDreamChecklist(checklist);
        dream.setDreamSound(sound);
        dream.setDreamLucidity(lucidity);
    }

    private void setNamesList(List<String> namesList) {
        DreamPeople people = DreamPeople.getInstance();
        for (int i = 0; i < namesList.size(); i++) {
            people.setName(i, namesList.get(i));
        }
        Dream dream = Dream.getInstance();
        dream.setDreamPeople(people);
    }

    private void setImpressions(LinearLayout positiveOn,
                                LinearLayout positiveOn2,
                                LinearLayout positiveOn3,
                                LinearLayout positiveOn4,
                                LinearLayout positiveOn5,
                                LinearLayout positiveOn6,
                                LinearLayout positiveOn7,
                                LinearLayout positiveOn8,
                                LinearLayout positiveOn9,
                                LinearLayout positiveOn10,
                                LinearLayout neutralOn,
                                LinearLayout neutralOn2,
                                LinearLayout neutralOn3,
                                LinearLayout neutralOn4,
                                LinearLayout neutralOn5,
                                LinearLayout neutralOn6,
                                LinearLayout neutralOn7,
                                LinearLayout neutralOn8,
                                LinearLayout neutralOn9,
                                LinearLayout neutralOn10,
                                LinearLayout negativeOn,
                                LinearLayout negativeOn2,
                                LinearLayout negativeOn3,
                                LinearLayout negativeOn4,
                                LinearLayout negativeOn5,
                                LinearLayout negativeOn6,
                                LinearLayout negativeOn7,
                                LinearLayout negativeOn8,
                                LinearLayout negativeOn9,
                                LinearLayout negativeOn10,
                                AppCompatTextView hintFeelings,
                                AppCompatTextView hintFeelings2,
                                AppCompatTextView hintFeelings3,
                                AppCompatTextView hintFeelings4,
                                AppCompatTextView hintFeelings5,
                                AppCompatTextView hintFeelings6,
                                AppCompatTextView hintFeelings7,
                                AppCompatTextView hintFeelings8,
                                AppCompatTextView hintFeelings9,
                                AppCompatTextView hintFeelings10
    ) {
        List<AppCompatTextView> hintFeelingsList = Arrays.asList(hintFeelings, hintFeelings2,
                hintFeelings3, hintFeelings4, hintFeelings5, hintFeelings6, hintFeelings7,
                hintFeelings8, hintFeelings9, hintFeelings10);

        List<LinearLayout> positBtnsOn = Arrays.asList(positiveOn, positiveOn2, positiveOn3, positiveOn4,
                positiveOn5, positiveOn6, positiveOn7, positiveOn8, positiveOn9, positiveOn10);

        List<LinearLayout> neutralBtnsOn = Arrays.asList(neutralOn, neutralOn2, neutralOn3,
                neutralOn4, neutralOn5, neutralOn6, neutralOn7, neutralOn8, neutralOn9, neutralOn10);

        List<LinearLayout> negativeBtnsOn = Arrays.asList(negativeOn, negativeOn2, negativeOn3,
                negativeOn4, negativeOn5, negativeOn6, negativeOn7,
                negativeOn8, negativeOn9, negativeOn10);
        DreamPeople people = DreamPeople.getInstance();
        Dream dream = Dream.getInstance();
        for (int i = 0; i < hintFeelingsList.size(); i++) {
            if (hintFeelingsList.get(i).getVisibility() == View.VISIBLE) {
                if (positBtnsOn.get(i).getVisibility() == View.VISIBLE) {
                    people.setImpression(i, 3);
                } else if (neutralBtnsOn.get(i).getVisibility() == View.VISIBLE) {
                    people.setImpression(i, 2);
                } else if (negativeBtnsOn.get(i).getVisibility() == View.VISIBLE) {
                    people.setImpression(i, 1);
                }
            }
        }
        dream.setDreamPeople(people);


    }

    public void saveCompleteDream(IConnectionChecker connectionChecker, Activity activity, Context context, AppCompatEditText interpretation,
                                  AppCompatEditText title, AppCompatEditText content,
                                  Spinner daySp, Spinner monthSp, Spinner yearSp,
                                  SharedPreferences.Editor dreamPref, SharedPreferences.Editor dreamPrefTwo) {
        ConnectionChecker connection = new ConnectionChecker(connectionChecker);
        date = Date.getInstance();
        description = DreamDescription.getInstance();
        DreamInterpretation dreamInterpretation = DreamInterpretation.getInstance();
        dream = Dream.getInstance();
        description.setTitle(title.getText().toString());
        description.setContent(content.getText().toString());
        dream.setDreamDescription(description);
        dreamInterpretation.setInterpretation(interpretation.getText().toString());
        dream.setDreamInterpretation(dreamInterpretation);
        int day = Integer.parseInt(daySp.getSelectedItem().toString());
        String month = monthSp.getSelectedItem().toString();
        String year = yearSp.getSelectedItem().toString();
        date.setCustomDay(year, month, day);
        Database db = Database.getInstance(context);
        PostsEntity post = new PostsEntity();

        ApiPostCaller postCaller = new ApiPostCaller();
        if (SharedPreferencesManager.dreamIsLoaded(context)) {
            db.postDao().updatePost(post);
            Users.getInstance().setConnected(false);
            postCaller.editDream(new IResponseMessage() {
                @Override
                public void onSuccess(Object response) throws JSONException {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    boolean status = jsonObject.getBoolean("status");
                    if (status) {
                        postCaller.editPeople(new IResponseMessage() {
                            @Override
                            public void onSuccess(Object response) throws JSONException {
                                JSONObject jsonObject1 = new JSONObject(response.toString());
                                boolean status = jsonObject1.getBoolean("status");
                                if (status) {
                                    postCaller.addDateToSleep(new IResponseMessage() {
                                        @Override
                                        public void onSuccess(Object response) throws JSONException {
                                            Users.getInstance().setConnected(true);
                                            JSONObject jsonObject1 = new JSONObject(response.toString());
                                            boolean status1 = jsonObject1.getBoolean("status");
                                            if (status1) {
                                                ViewDreamInputDialog dialog = new ViewDreamInputDialog();
                                                dialog.showDialog(activity, context, dreamPref,
                                                        dreamPrefTwo);
                                            } else {
                                                iDreamInfoInput.onError();
                                            }
                                        }

                                        @Override
                                        public void onFailure(String errorMessage) {
                                            iDreamInfoInput.onError();
                                        }
                                    });
                                }
                            }

                            @Override
                            public void onFailure(String errorMessage) {
                                iDreamInfoInput.onError();
                            }
                        });


                    } else {
                        iDreamInfoInput.onError();
                    }
                }

                @Override
                public void onFailure(String errorMessage) {
                    iDreamInfoInput.onError();
                }
            });
        } else {
            db.postDao().post(post);
            Users.getInstance().setConnected(false);
            ViewDreamInputDialog dialog = new ViewDreamInputDialog();
            dialog.showDialog(activity, context, dreamPref,
                    dreamPrefTwo);
            postCaller.postPeople(new IResponseMessage() {
                @Override
                public void onSuccess(Object response) throws JSONException {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    boolean status = jsonObject.getBoolean("status");
                    if (status) {
                        DreamPeople.delPeople();
                        postCaller.saveDreamSeparately(new IResponseMessage() {
                            @Override
                            public void onSuccess(Object response) throws JSONException {
                                JSONObject jsonObject = new JSONObject(response.toString());
                                boolean status = jsonObject.getBoolean("status");
                                if (status) {
                                    postCaller.addDateToSleep(new IResponseMessage() {
                                        @Override
                                        public void onSuccess(Object response) throws JSONException {
                                            Users.getInstance().setConnected(true);
                                            JSONObject jsonObject1 = new JSONObject(response.toString());
                                            boolean status1 = jsonObject1.getBoolean("status");
                                            if (status1) {

                                            } else {
                                                iDreamInfoInput.onError();
                                            }
                                        }

                                        @Override
                                        public void onFailure(String errorMessage) {
                                            iDreamInfoInput.onError();
                                        }
                                    });

                                } else {
                                    iDreamInfoInput.onError();
                                }
                            }

                            @Override
                            public void onFailure(String errorMessage) {
                                iDreamInfoInput.onError();
                            }
                        });
                    }
                }

                @Override
                public void onFailure(String errorMessage) {
                    iDreamInfoInput.onError();
                }
            });

        }
        connection.checkConnection();
    }

    private void setLoadingVisible(RelativeLayout loadingBg) {
        loadingBg.setVisibility(View.VISIBLE);
        loadingBg.setAlpha(0.5f);
    }


}
