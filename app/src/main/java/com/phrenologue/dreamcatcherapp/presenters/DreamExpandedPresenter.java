package com.phrenologue.dreamcatcherapp.presenters;

import android.content.Context;
import android.util.Log;

import androidx.appcompat.widget.AppCompatImageView;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.activities.viewInterfaces.IDreamExpandedView;
import com.phrenologue.dreamcatcherapp.managersAndFilters.SharedPreferencesManager;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamChecklist;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamDate;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamDescription;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamInterpretation;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamPeople;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamSound;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Sleep;
import com.phrenologue.dreamcatcherapp.ui.costumeFont.MoonTextView;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DreamExpandedPresenter {
    IDreamExpandedView iDreamExpandedView;

    public DreamExpandedPresenter(IDreamExpandedView iDreamExpandedView) {
        this.iDreamExpandedView = iDreamExpandedView;
    }

    public void retrievePeople(Context context, int postId, SharedPreferencesManager spManager) {
        iDreamExpandedView.showProgressBar();
        ApiPostCaller apiPostCaller = new ApiPostCaller();
        apiPostCaller.getPeopleProps(postId, new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                iDreamExpandedView.hideProgressBar();
                DreamPeople people = DreamPeople.getInstance();
                JSONArray jsonArray = new JSONArray(response.toString());
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                ArrayList<Integer> impressions = new ArrayList<>();
                impressions.add(0, jsonObject.getInt("firstImpression"));
                impressions.add(1, jsonObject.getInt("secondImpression"));
                impressions.add(2, jsonObject.getInt("thirdImpression"));
                impressions.add(3, jsonObject.getInt("fourthImpression"));
                impressions.add(4, jsonObject.getInt("fifthImpression"));
                impressions.add(5, jsonObject.getInt("sixthImpression"));
                impressions.add(6, jsonObject.getInt("seventhImpression"));
                impressions.add(7, jsonObject.getInt("eighthImpression"));
                impressions.add(8, jsonObject.getInt("ninthImpression"));
                impressions.add(9, jsonObject.getInt("tenthImpression"));

                ArrayList<String> names = new ArrayList<>();
                names.add(0, jsonObject.getString("firstPerson"));
                names.add(1, jsonObject.getString("secondPerson"));
                names.add(2, jsonObject.getString("thirdPerson"));
                names.add(3, jsonObject.getString("fourthPerson"));
                names.add(4, jsonObject.getString("fifthPerson"));
                names.add(5, jsonObject.getString("sixthPerson"));
                names.add(6, jsonObject.getString("seventhPerson"));
                names.add(7, jsonObject.getString("eighthPerson"));
                names.add(8, jsonObject.getString("ninthPerson"));
                names.add(9, jsonObject.getString("tenthPerson"));
                Log.e("", "");
                for (int i = 0; i < 10; i++) {
                    if (impressions.get(i) != null) {
                        people.setImpression(i, impressions.get(i));
                    }

                }

                for (int i = 0; i < 10; i++) {
                    people.setName(i, names.get(i));
                }

                setPeopleToViews();

                spManager.savePeopleToSp(context, people);
            }

            @Override
            public void onFailure(String errorMessage) {
                iDreamExpandedView.hideProgressBar();
            }
        });
    }


    private void setPeopleToViews() {
        int textColor = 0;
        DreamPeople people = DreamPeople.getInstance();
        for (int i = 0; i < 9; i++) {
            String name = people.getName(i);
            if (!name.equals("")){
                Integer impression = people.getImpression(i);
                if (impression > 0) {
                    switch (impression) {
                        case 1:
                            textColor = R.color.txt_glow;
                            break;
                        case 2:
                            textColor = R.color.white;
                            break;
                        case 3:
                            textColor = R.color.day_light;
                            break;
                    }
                }
                iDreamExpandedView.setPeopleView(i, name, textColor);
            }

        }
    }

    public void retrieveDream(Context context,
                              int postId, AppCompatImageView mood, AppCompatImageView color,
                              MoonTextView dreamsPackageInterpretation,
                              MoonTextView dreamsPackageTitle, MoonTextView dreamsPackageDescription,
                              AppCompatImageView soundImg, MoonTextView titleDate,
                              String dateLoaded, SharedPreferencesManager spManager) {

        iDreamExpandedView.showProgressBar();
        ApiPostCaller apiPostCaller = new ApiPostCaller();
        apiPostCaller.getDreamProps(postId, new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                iDreamExpandedView.hideProgressBar();
                JSONArray jsonArray = new JSONArray(response.toString());
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                Dream.setDreamProperties(jsonObject.getInt("dreamGrayScale"),
                        jsonObject.getInt("dreamExperience"),
                        jsonObject.getInt("dayOfMonth"),
                        jsonObject.getInt("month"),
                        jsonObject.getInt("year"),
                        jsonObject.getString("dreamTitle"),
                        jsonObject.getString("dreamContent"),
                        jsonObject.getString("interpretation"),
                        jsonObject.getInt("dreamLucidityLevel"),
                        jsonObject.getInt("dreamPeopleExist"),
                        jsonObject.getInt("dreamSound"),
                        jsonObject.getInt("dreamMusical"));

                setDreamPropertiesToViews(mood, color, dreamsPackageInterpretation,
                        dreamsPackageTitle, dreamsPackageDescription, soundImg, titleDate,
                        dateLoaded);

                spManager.saveDreamToSp(context, Dream.getInstance(), DreamDate.getInstance());

            }

            @Override
            public void onFailure(String errorMessage) {
                iDreamExpandedView.hideProgressBar();
            }
        });
    }

    private void setMoodToImageView() {
        int drawable;
        DreamChecklist checklist = DreamChecklist.getInstance();
        if (checklist.getExperience() == 0) {
            drawable = R.drawable.ic_sad_emoji;
            iDreamExpandedView.setMoodView(drawable);
        } else if (checklist.getExperience() == 1) {
            drawable = R.drawable.ic_poker_face_emoji;
            iDreamExpandedView.setMoodView(drawable);
        } else if (checklist.getExperience() == 2) {
            drawable = R.drawable.ic_happy_emoji;
            iDreamExpandedView.setMoodView(drawable);
        } else {
            iDreamExpandedView.hideMood();
        }
    }

    private void setColorToImageView(AppCompatImageView color) {
        DreamChecklist checklist = DreamChecklist.getInstance();
        if (checklist.getGrayScale() == 2) {
            color.setImageResource(R.drawable.ic_colorful);
        } else {
            color.setImageResource(R.drawable.ic_grayscale);
        }
    }

    private void setSoundToImageView(AppCompatImageView soundImg) {
        DreamSound sound = DreamSound.getInstance();
        int soundInt = sound.getSound();
        if (soundInt == 1) {
            soundImg.setImageResource(R.drawable.ic_musical);
        } else {
            soundImg.setImageResource(R.drawable.ic_non_musical);
        }


    }

    private void setInterpretationToTextView(MoonTextView dreamsPackageInterpretation) {
        DreamInterpretation interpretation = DreamInterpretation.getInstance();
        dreamsPackageInterpretation.setText(interpretation.getInterpretation());
    }

    private void setTitleAndContentToTxtView(MoonTextView dreamsPackageTitle,
                                             MoonTextView dreamsPackageDescription) {
        DreamDescription description = DreamDescription.getInstance();
        dreamsPackageTitle.setText(description.getTitle());
        dreamsPackageDescription.setText(description.getContent());
    }

    private void setDate(MoonTextView titleDate, String dateLoaded) {
        titleDate.setText(dateLoaded);
    }

    private void setDreamPropertiesToViews(AppCompatImageView mood, AppCompatImageView color,
                                           MoonTextView dreamsPackageInterpretation,
                                           MoonTextView dreamsPackageTitle,
                                           MoonTextView dreamsPackageDescription,
                                           AppCompatImageView soundImg,
                                           MoonTextView titleDate,
                                           String dateLoaded) {
        setMoodToImageView();
        setColorToImageView(color);
        setInterpretationToTextView(dreamsPackageInterpretation);
        setTitleAndContentToTxtView(dreamsPackageTitle, dreamsPackageDescription);
        setSoundToImageView(soundImg);
        setDate(titleDate, dateLoaded);
    }

    public void retrieveSleep(Context context, int postId, SharedPreferencesManager spManager,
                              AppCompatImageView dayTime, AppCompatImageView activity,
                              AppCompatImageView food) {
        iDreamExpandedView.showProgressBar();
        ApiPostCaller apiPostCaller = new ApiPostCaller();
        apiPostCaller.getSleepProps(postId, new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                iDreamExpandedView.hideProgressBar();

                JSONArray jsonArray = new JSONArray(response.toString());
                JSONObject jsonObject = jsonArray.getJSONObject(0);

                Sleep.setSleepProps(jsonObject.getInt("sleepTime"),
                        jsonObject.getInt("sleepPhysicalActivity"),
                        jsonObject.getInt("sleepFoodConsumption"));

                spManager.saveSleepToSp(context);

                setSleepPropsToViews(activity, food);
            }

            @Override
            public void onFailure(String errorMessage) {
                iDreamExpandedView.hideProgressBar();
            }
        });
    }

    private void setSleepPropsToViews(AppCompatImageView activity,
                                      AppCompatImageView food) {
        setSleepTimeToView();
        setPhysicalActivityToView(activity);
        setFoodToView(food);
    }

    private void setSleepTimeToView() {
        Sleep sleep = Sleep.getInstance();
        int drawable;
        if (sleep.getTime() == 1) {
            drawable = R.drawable.ic_day_symbol;
            iDreamExpandedView.setSleepTimeView(drawable);
        } else if (sleep.getTime() == 2) {
            drawable = R.drawable.ic_night_symbol;
            iDreamExpandedView.setSleepTimeView(drawable);
        } else {
            iDreamExpandedView.hideSleepTime();
        }
    }

    private void setPhysicalActivityToView(AppCompatImageView activity) {
        Sleep sleep = Sleep.getInstance();
        if (sleep.getPhysicalActivity() == 0) {
            activity.setImageResource(R.drawable.stick_figure_1);
        } else if (sleep.getPhysicalActivity() == 1) {
            activity.setImageResource(R.drawable.stick_figure_2);
        } else if (sleep.getPhysicalActivity() == 2) {
            activity.setImageResource(R.drawable.stick_figure_3);
        } else if (sleep.getPhysicalActivity() == 3) {
            activity.setImageResource(R.drawable.stick_figure_4);
        }
    }

    private void setFoodToView(AppCompatImageView food) {
        Sleep sleep = Sleep.getInstance();
        if (sleep.getFoodConsumption() == 0) {
            food.setImageResource(R.drawable.apple);
        } else if (sleep.getFoodConsumption() == 1) {
            food.setImageResource(R.drawable.steak);
        } else if (sleep.getFoodConsumption() == 2) {
            food.setImageResource(R.drawable.hamburger_drink);
        }
    }
}
