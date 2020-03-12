package com.phrenologue.dreamcatcherapp.presenters;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;

import androidx.appcompat.widget.AppCompatEditText;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.OperationResults;
import com.phrenologue.dreamcatcherapp.parameters.dateParameters.parameters.Date;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamChecklist;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamDescription;
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

    public void setMoodSeekBar(SeekBar experience) {
        checklist = DreamChecklist.getInstance();
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
    }

    public void setPeopleBtnOn(RelativeLayout peopleExpanded, RelativeLayout peopleClosed) {
        people = DreamPeople.getInstance();
        people.setExistent(1);
        if (peopleExpanded.getVisibility() == View.VISIBLE) {
            peopleExpanded.setVisibility(View.GONE);
            peopleClosed.setVisibility(View.VISIBLE);
        } else {
            peopleExpanded.setVisibility(View.VISIBLE);
            peopleClosed.setVisibility(View.GONE);
        }

    }

    public void setPeopleBtnOff(RelativeLayout peopleExpanded, RelativeLayout peopleClosed) {
        people = DreamPeople.getInstance();
        people.setExistent(0);
        if (peopleClosed.getVisibility() == View.VISIBLE) {
            peopleClosed.setVisibility(View.GONE);
            peopleExpanded.setVisibility(View.VISIBLE);
        } else {
            peopleClosed.setVisibility(View.VISIBLE);
            peopleExpanded.setVisibility(View.GONE);
        }
    }

    public void setSoundBtnOn(RelativeLayout soundsExpanded, RelativeLayout soundsClosed) {
        sound = DreamSound.getInstance();
        sound.setSound(1);
        if (soundsExpanded.getVisibility() == View.VISIBLE) {
            soundsExpanded.setVisibility(View.GONE);
            soundsClosed.setVisibility(View.VISIBLE);
        } else {
            soundsExpanded.setVisibility(View.VISIBLE);
            soundsClosed.setVisibility(View.GONE);
        }
    }

    public void setSoundBtnOff(RelativeLayout soundsExpanded, RelativeLayout soundsClosed) {
        sound = DreamSound.getInstance();
        sound.setSound(0);
        if (soundsClosed.getVisibility() == View.VISIBLE) {
            soundsClosed.setVisibility(View.GONE);
            soundsExpanded.setVisibility(View.VISIBLE);
        } else {
            soundsClosed.setVisibility(View.VISIBLE);
            soundsExpanded.setVisibility(View.GONE);
        }
    }

    public void setPositiveBtnOn(LinearLayout positiveOn, LinearLayout positiveOff,
                                 LinearLayout neutralOn, LinearLayout neutralOff,
                                 LinearLayout negativeOn, LinearLayout negativeOff) {
        people = DreamPeople.getInstance();
        people.setImpression(3);
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

    public void setPositiveBtnOff(LinearLayout positiveOn, LinearLayout positiveOff,
                                  LinearLayout neutralOff, LinearLayout negativeOff) {
        people = DreamPeople.getInstance();
        people.setImpression(0);
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

    public void setNeutralBtnOn(LinearLayout positiveOn, LinearLayout positiveOff,
                                LinearLayout neutralOn, LinearLayout neutralOff,
                                LinearLayout negativeOn, LinearLayout negativeOff) {
        people = DreamPeople.getInstance();
        people.setImpression(2);
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

    public void setNeutralBtnOff(LinearLayout positiveOff, LinearLayout neutralOn,
                                 LinearLayout neutralOff, LinearLayout negativeOff) {
        people = DreamPeople.getInstance();
        people.setImpression(0);
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

    public void setNegativeBtnOn(LinearLayout positiveOn, LinearLayout positiveOff,
                                 LinearLayout neutralOn, LinearLayout neutralOff,
                                 LinearLayout negativeOn, LinearLayout negativeOff) {
        people = DreamPeople.getInstance();
        people.setImpression(1);
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

    public void setNegativeBtnOff(LinearLayout positiveOff, LinearLayout neutralOff,
                                  LinearLayout negativeOn, LinearLayout negativeOff) {
        people = DreamPeople.getInstance();
        people.setImpression(0);
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

    public void setColorfulBtnOn(LinearLayout colorOn, LinearLayout colorOff,
                                 LinearLayout grayOn, LinearLayout grayOff,
                                 RelativeLayout colorfulOff) {
        checklist = DreamChecklist.getInstance();
        checklist.setGrayScale(2);
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

    public void setColorfulBtnOff(LinearLayout colorOn, LinearLayout colorOff, LinearLayout grayOff) {
        checklist = DreamChecklist.getInstance();
        checklist.setGrayScale(0);
        if (colorOff.getVisibility() == View.VISIBLE) {
            colorOff.setVisibility(View.INVISIBLE);
            colorOn.setVisibility(View.VISIBLE);
        } else {
            colorOff.setVisibility(View.VISIBLE);
            colorOn.setVisibility(View.INVISIBLE);
            grayOff.setVisibility(View.VISIBLE);

        }
    }

    public void setGrayScaleBtnOn(LinearLayout colorOn, LinearLayout colorOff,
                                  LinearLayout grayOn, LinearLayout grayOff, RelativeLayout colorfulOff) {
        checklist = DreamChecklist.getInstance();
        checklist.setGrayScale(1);
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

    public void setGrayScaleBtnOff(LinearLayout colorOff,
                                   LinearLayout grayOn, LinearLayout grayOff) {
        checklist = DreamChecklist.getInstance();
        checklist.setGrayScale(0);
        if (grayOff.getVisibility() == View.VISIBLE) {
            grayOff.setVisibility(View.INVISIBLE);
            grayOn.setVisibility(View.VISIBLE);
        } else {
            grayOff.setVisibility(View.VISIBLE);
            grayOn.setVisibility(View.INVISIBLE);
            colorOff.setVisibility(View.VISIBLE);
        }
    }

    public void setMusicalBtnOn(LinearLayout museOn, LinearLayout museOff,
                                LinearLayout nonMuseOn, LinearLayout nonMuseOff) {
        sound = DreamSound.getInstance();
        sound.setMusical(2);
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

    public void setMusicalBtnOff(LinearLayout museOn, LinearLayout museOff,
                                 LinearLayout nonMuseOff) {
        sound = DreamSound.getInstance();
        sound.setMusical(0);
        if (museOff.getVisibility() == View.VISIBLE) {
            museOff.setVisibility(View.INVISIBLE);
            museOn.setVisibility(View.VISIBLE);
        } else {
            museOff.setVisibility(View.VISIBLE);
            museOn.setVisibility(View.INVISIBLE);
            nonMuseOff.setVisibility(View.VISIBLE);
        }
    }

    public void setNonMusicalBtnOn(LinearLayout museOn, LinearLayout museOff,
                                   LinearLayout nonMuseOn, LinearLayout nonMuseOff) {
        sound = DreamSound.getInstance();
        sound.setMusical(1);
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

    public void setNonMusicalBtnOff(LinearLayout museOff,
                                    LinearLayout nonMuseOn, LinearLayout nonMuseOff) {
        sound = DreamSound.getInstance();
        sound.setMusical(0);
        if (nonMuseOff.getVisibility() == View.VISIBLE) {
            nonMuseOff.setVisibility(View.INVISIBLE);
            nonMuseOn.setVisibility(View.VISIBLE);
        } else {
            nonMuseOff.setVisibility(View.VISIBLE);
            nonMuseOn.setVisibility(View.INVISIBLE);
            museOff.setVisibility(View.VISIBLE);
        }
    }


    public void setLuciditySeekBar(SeekBar lucidityLevel) {
        lucidity = DreamLucidity.getInstance();
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
    }

    public void cancelDreamInput() {
        checklist = DreamChecklist.getInstance();
        dream = Dream.getInstance();
        Dream.delDream();
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

    public boolean saveCompleteDream(AppCompatEditText title, AppCompatEditText content,
                                  Spinner daySp, Spinner monthSp, Spinner yearSp) {
        date = Date.getInstance();
        description = DreamDescription.getInstance();
        dream = Dream.getInstance();
        description.setTitle(title.getText().toString());
        description.setContent(content.getText().toString());
        dream.setDreamDescription(description);
        int day = Integer.parseInt(daySp.getSelectedItem().toString());
        String month = monthSp.getSelectedItem().toString();
        String year = yearSp.getSelectedItem().toString();
        date.setCustomDay(year, month, day);
        ApiPostCaller postCaller = new ApiPostCaller();
        OperationResults results = OperationResults.getInstance();
        postCaller.saveDreamSeparately(new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                JSONObject jsonObject = new JSONObject(response.toString());
                boolean status = jsonObject.getBoolean("status");
                Log.e("", "");
                if (status) {
                    postCaller.addDateToSleep(new IResponseMessage() {
                        @Override
                        public void onSuccess(Object response) throws JSONException {
                            JSONObject jsonObject1 = new JSONObject(response.toString());
                            boolean status1 = jsonObject1.getBoolean("status");
                            Log.e("","");
                            if (status1) {
                                results.setStatus(true);
                                Dream.delDream();
                                Sleep.delSleep();
                            }
                        }

                        @Override
                        public void onFailure(String errorMessage) {
                            Log.e("","");
                            results.setStatus(false);
                        }
                    });

                    Log.e("", "");

                } else {

                }
            }

            @Override
            public void onFailure(String errorMessage) {
                results.setStatus(false);
                Log.e("","");

            }
        });
        return results.isStatus();
    }


}
