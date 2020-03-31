package com.phrenologue.dreamcatcherapp.presenters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import com.phrenologue.dreamcatcherapp.Activities.ProfileActivity;
import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.managersAndFilters.SharedPreferencesManager;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.dateParameters.parameters.Date;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamChecklist;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamDescription;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamInterpretation;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamLucidity;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamPeople;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamSound;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Sleep;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONException;
import org.json.JSONObject;

public class DreamInputPresenter {
    Dream dream;
    DreamChecklist checklist;
    DreamPeople people;
    DreamSound sound;
    DreamLucidity lucidity;
    DreamDescription description;
    Date date;

    public DreamInputPresenter() {
    }

    public void setMoodSeekBar(SharedPreferences.Editor dreamPrefEditor, SeekBar experience) {
        checklist = DreamChecklist.getInstance();
        experience.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                checklist.setExperience(progress);
                dreamPrefEditor.putBoolean("hasMood", true).apply();
                dreamPrefEditor.putInt("mood", progress).apply();
                seekBar.setMax(9);
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
                                   RelativeLayout feelingsOff){
        textView.setVisibility(View.VISIBLE);
        feelingsOn.setVisibility(View.VISIBLE);
        feelingsOff.setVisibility(View.VISIBLE);
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
        people.setImpression(3);
        dreamPrefEditor.putBoolean("hasImpression", true).apply();
        dreamPrefEditor.putInt("impression", 3).apply();
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
        people.setImpression(0);
        dreamPrefEditor.putBoolean("hasImpression", false).apply();
        dreamPrefEditor.putInt("impression", 0).apply();
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
        people.setImpression(2);
        dreamPrefEditor.putBoolean("hasImpression", true).apply();
        dreamPrefEditor.putInt("impression", 2).apply();
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
        people.setImpression(0);
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
        people.setImpression(1);
        dreamPrefEditor.putBoolean("hasImpression", true).apply();
        dreamPrefEditor.putInt("impression", 1).apply();
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
        people.setImpression(0);
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


    public void setLuciditySeekBar(SharedPreferences.Editor dreamPrefEditor, SeekBar lucidityLevel) {
        lucidity = DreamLucidity.getInstance();
        lucidityLevel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lucidity.setLucidityLevel(progress);
                dreamPrefEditor.putBoolean("hasLucidity", true).apply();
                dreamPrefEditor.putInt("lucidity", progress).apply();
                seekBar.setMax(3);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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
                sp.edit().putBoolean(textTitle+"Exists", true).apply();;
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

    public void cancelDreamInput(SharedPreferences.Editor dreamPrefEditor,
                                 SharedPreferences.Editor dreamPrefEditorTwo) {
        checklist = DreamChecklist.getInstance();
        dream = Dream.getInstance();
        Dream.delDream();
        dreamPrefEditor.clear().apply();
        checklist.setRemembered(0);
        dream.setDreamChecklist(checklist);
    }

    public void saveHalfWayDream(AppCompatEditText edtTxtNames) {
        people = DreamPeople.getInstance();
        dream = Dream.getInstance();
        checklist = DreamChecklist.getInstance();
        sound = DreamSound.getInstance();
        lucidity = DreamLucidity.getInstance();

        people.setName(edtTxtNames.getText().toString());
        dream.setDreamPeople(people);
        dream.setDreamChecklist(checklist);
        dream.setDreamSound(sound);
        dream.setDreamLucidity(lucidity);
    }

    public void saveCompleteDream(Context context, AppCompatEditText interpretation,
                                  AppCompatEditText title, AppCompatEditText content,
                                  Spinner daySp, Spinner monthSp, Spinner yearSp, RelativeLayout loadingBg,
                                  SharedPreferences.Editor dreamPref, SharedPreferences.Editor dreamPrefTwo) {
        loadingBg.setVisibility(View.VISIBLE);
        loadingBg.setAlpha(0.5f);
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
        ApiPostCaller postCaller = new ApiPostCaller();
        if (SharedPreferencesManager.dreamIsLoaded(context)){
            postCaller.editDream(new IResponseMessage() {
                @Override
                public void onSuccess(Object response) throws JSONException {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    boolean status = jsonObject.getBoolean("status");
                    if (status) {
                        postCaller.addDateToSleep(new IResponseMessage() {
                            @Override
                            public void onSuccess(Object response) throws JSONException {
                                JSONObject jsonObject1 = new JSONObject(response.toString());
                                boolean status1 = jsonObject1.getBoolean("status");
                                if (status1) {
                                    dreamPref.clear().apply();
                                    dreamPrefTwo.clear().apply();
                                    Dream.delDream();
                                    Sleep.delSleep();
                                    Intent intent = new Intent(context, ProfileActivity.class);
                                    context.startActivity(intent);
                                } else {
                                    loadingBg.setVisibility(View.GONE);
                                    Toast.makeText(context, "Error.", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(String errorMessage) {
                                loadingBg.setVisibility(View.GONE);
                                Toast.makeText(context, "Error.", Toast.LENGTH_LONG).show();
                            }
                        });

                    } else {
                        loadingBg.setVisibility(View.GONE);
                        Toast.makeText(context, "Error.", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(String errorMessage) {
                    loadingBg.setVisibility(View.GONE);
                    Toast.makeText(context, "Error!", Toast.LENGTH_LONG).show();
                }
            });
        } else {
            postCaller.saveDreamSeparately(new IResponseMessage() {
                @Override
                public void onSuccess(Object response) throws JSONException {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    boolean status = jsonObject.getBoolean("status");
                    if (status) {
                        postCaller.addDateToSleep(new IResponseMessage() {
                            @Override
                            public void onSuccess(Object response) throws JSONException {
                                JSONObject jsonObject1 = new JSONObject(response.toString());
                                boolean status1 = jsonObject1.getBoolean("status");
                                if (status1) {
                                    dreamPref.clear().apply();
                                    dreamPrefTwo.clear().apply();
                                    Dream.delDream();
                                    Sleep.delSleep();
                                    Intent intent = new Intent(context, ProfileActivity.class);
                                    context.startActivity(intent);
                                } else {
                                    loadingBg.setVisibility(View.GONE);
                                    Toast.makeText(context, "Error.", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(String errorMessage) {
                                loadingBg.setVisibility(View.GONE);
                                Toast.makeText(context, "Error.", Toast.LENGTH_LONG).show();
                            }
                        });

                    } else {
                        loadingBg.setVisibility(View.GONE);
                        Toast.makeText(context, "Error.", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(String errorMessage) {
                    loadingBg.setVisibility(View.GONE);
                    Toast.makeText(context, "Error!", Toast.LENGTH_LONG).show();
                }
            });
        }

    }




}
