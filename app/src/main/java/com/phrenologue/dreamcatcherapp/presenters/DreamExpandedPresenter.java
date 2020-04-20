package com.phrenologue.dreamcatcherapp.presenters;

import android.content.Context;
import android.util.Log;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.activities.viewInterfaces.IDreamExpandedView;
import com.phrenologue.dreamcatcherapp.managersAndFilters.SharedPreferencesManager;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamChecklist;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamDate;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamPeople;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamSound;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Sleep;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DreamExpandedPresenter {
    private IDreamExpandedView iDreamExpandedView;
    private Sleep sleep = Sleep.getInstance();
    private DreamPeople people = DreamPeople.getInstance();
    private DreamChecklist checklist = DreamChecklist.getInstance();
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
                              int postId,
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

                setDreamPropertiesToViews(dateLoaded);

                spManager.saveDreamToSp(context, Dream.getInstance(), DreamDate.getInstance());

            }

            @Override
            public void onFailure(String errorMessage) {
                iDreamExpandedView.hideProgressBar();
            }
        });
    }

    private void setMoodToImageView() {
        if (checklist.getExperience() == 0) {
            iDreamExpandedView.setMoodView(R.drawable.ic_sad_emoji);
        } else if (checklist.getExperience() == 1) {
            iDreamExpandedView.setMoodView(R.drawable.ic_poker_face_emoji);
        } else if (checklist.getExperience() == 2) {
            iDreamExpandedView.setMoodView(R.drawable.ic_happy_emoji);
        } else {
            iDreamExpandedView.hideMood();
        }
    }

    private void setColorToImageView() {
        if (checklist.getGrayScale() == 2) {
            iDreamExpandedView.setColorView(R.drawable.ic_colorful);
        } else {
            iDreamExpandedView.setColorView(R.drawable.ic_grayscale);
        }
    }

    private void setSoundToImageView() {
        DreamSound sound = DreamSound.getInstance();
        int soundInt = sound.getSound();
        if (soundInt == 1) {
            iDreamExpandedView.setMusicalView(R.drawable.ic_musical);
        } else {
            iDreamExpandedView.setMusicalView(R.drawable.ic_non_musical);
        }


    }

    private void setDate(String dateLoaded) {
        iDreamExpandedView.setDateText(dateLoaded);
    }

    private void setDreamPropertiesToViews(String dateLoaded) {
        setMoodToImageView();
        setColorToImageView();
        iDreamExpandedView.setInterpretationText();
        iDreamExpandedView.setTitleText();
        iDreamExpandedView.setContentText();
        setSoundToImageView();
        setDate(dateLoaded);
    }

    public void retrieveSleep(Context context, int postId, SharedPreferencesManager spManager) {
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

                setSleepPropsToViews();
            }

            @Override
            public void onFailure(String errorMessage) {
                iDreamExpandedView.hideProgressBar();
            }
        });
    }

    private void setSleepPropsToViews() {
        setSleepTimeToView();
        setPhysicalActivityToView();
        setFoodToView();
    }

    private void setSleepTimeToView() {
        if (sleep.getTime() == 1) {
            iDreamExpandedView.setSleepTimeView(R.drawable.ic_day_symbol);
        } else if (sleep.getTime() == 2) {
            iDreamExpandedView.setSleepTimeView(R.drawable.ic_night_symbol);
        } else {
            iDreamExpandedView.hideSleepTime();
        }
    }

    private void setPhysicalActivityToView() {
        if (sleep.getPhysicalActivity() == 0) {
            iDreamExpandedView.setPhysicalView(R.drawable.stick_figure_1);
        } else if (sleep.getPhysicalActivity() == 1) {
            iDreamExpandedView.setPhysicalView(R.drawable.stick_figure_2);
        } else if (sleep.getPhysicalActivity() == 2) {
            iDreamExpandedView.setPhysicalView(R.drawable.stick_figure_3);
        } else if (sleep.getPhysicalActivity() == 3) {
            iDreamExpandedView.setPhysicalView(R.drawable.stick_figure_4);
        }
    }

    private void setFoodToView() {
        if (sleep.getFoodConsumption() == 0) {
            iDreamExpandedView.setFoodView(R.drawable.apple);
        } else if (sleep.getFoodConsumption() == 1) {
            iDreamExpandedView.setFoodView(R.drawable.steak);
        } else if (sleep.getFoodConsumption() == 2) {
            iDreamExpandedView.setFoodView(R.drawable.hamburger_drink);
        }
    }
}
