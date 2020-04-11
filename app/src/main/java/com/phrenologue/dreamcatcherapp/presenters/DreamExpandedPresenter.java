package com.phrenologue.dreamcatcherapp.presenters;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatImageView;

import com.phrenologue.dreamcatcherapp.R;
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
    public DreamExpandedPresenter() {}

    public void retrievePeople(Context context, int postId, SharedPreferencesManager spManager,
                               RelativeLayout loadingBg, ProgressBar progressBar,
                               MoonTextView nameOne, MoonTextView nameTwo, MoonTextView nameThree,
                               MoonTextView nameFour, MoonTextView nameFive, MoonTextView nameSix,
                               MoonTextView nameSeven, MoonTextView nameEight,
                               MoonTextView nameNine, MoonTextView nameTen){
        setLoadingVisible(loadingBg, progressBar);
        ApiPostCaller apiPostCaller = new ApiPostCaller();
        apiPostCaller.getPeopleProps(postId, new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                setLoadingInvisible(loadingBg, progressBar);
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

                setPeopleToViews(nameOne, nameTwo, nameThree,
                        nameFour, nameFive, nameSix,
                        nameSeven, nameEight,
                        nameNine, nameTen, context);

                spManager.savePeopleToSp(context, people);
            }

            @Override
            public void onFailure(String errorMessage) {
                setLoadingInvisible(loadingBg, progressBar);
            }
        });
    }

    private void setLoadingVisible(RelativeLayout loadingBg, ProgressBar progressBar) {
        loadingBg.setVisibility(View.VISIBLE);
        loadingBg.setAlpha(0.95f);
        progressBar.setVisibility(View.VISIBLE);
    }

    private void setLoadingInvisible(RelativeLayout loadingBg, ProgressBar progressBar) {
        loadingBg.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
    }

    private void setPeopleToViews(MoonTextView nameOne, MoonTextView nameTwo, MoonTextView nameThree,
                                  MoonTextView nameFour, MoonTextView nameFive, MoonTextView nameSix,
                                  MoonTextView nameSeven, MoonTextView nameEight,
                                  MoonTextView nameNine, MoonTextView nameTen, Context context) {
        DreamPeople people = DreamPeople.getInstance();
        for (int i = 0; i < 10; i++) {
            String name = people.getName(i);
            Integer impression = people.getImpression(i);
            switch (i) {
                case 0:
                    if (!name.equals("")) {
                        nameOne.setText(name);
                    }
                    if (impression > 0) {
                        switch (impression) {
                            case 1:
                                nameOne.setBackground(context.getResources().getDrawable(R.drawable.bg_simple));
                                nameOne.setBackgroundColor(context.getResources().getColor(R.color.day_light));
                                break;
                            case 2:
                                nameOne.setBackgroundColor(context.getResources().getColor(R.color.purple));
                                break;
                            case 3:
                                nameOne.setBackgroundColor(context.getResources().getColor(R.color.txt_glow));
                                break;
                        }
                    }
                    break;
                case 1:
                    if (!name.equals("")) {
                        nameTwo.setText(name);
                    }
                    if (impression > 0) {
                        switch (impression) {
                            case 1:
                                nameTwo.setBackgroundColor(context.getResources().getColor(R.color.red));
                                break;
                            case 2:
                                nameTwo.setBackgroundColor(context.getResources().getColor(R.color.purple));
                                break;
                            case 3:
                                nameTwo.setBackgroundColor(context.getResources().getColor(R.color.txt_glow));
                                break;
                        }
                    }
                    break;
                case 2:
                    if (!name.equals("")) {
                        nameThree.setText(name);
                    }
                    if (impression > 0) {
                        switch (impression) {
                            case 1:
                                nameThree.setBackgroundColor(context.getResources().getColor(R.color.red));
                                break;
                            case 2:
                                nameThree.setBackgroundColor(context.getResources().getColor(R.color.purple));
                                break;
                            case 3:
                                nameThree.setBackgroundColor(context.getResources().getColor(R.color.txt_glow));
                                break;
                        }
                    }
                    break;
                case 3:
                    if (!name.equals("")) {
                        nameFour.setText(name);
                    }
                    if (impression > 0) {
                        switch (impression) {
                            case 1:
                                nameFour.setBackgroundColor(context.getResources().getColor(R.color.red));
                                break;
                            case 2:
                                nameFour.setBackgroundColor(context.getResources().getColor(R.color.purple));
                                break;
                            case 3:
                                nameFour.setBackgroundColor(context.getResources().getColor(R.color.txt_glow));
                                break;
                        }
                    }
                    break;
                case 4:
                    if (!name.equals("")) {
                        nameFive.setText(name);
                    }
                    if (impression > 0) {
                        switch (impression) {
                            case 1:
                                nameFive.setBackgroundColor(context.getResources().getColor(R.color.red));
                                break;
                            case 2:
                                nameFive.setBackgroundColor(context.getResources().getColor(R.color.purple));
                                break;
                            case 3:
                                nameFive.setBackgroundColor(context.getResources().getColor(R.color.txt_glow));
                                break;
                        }
                    }
                    break;
                case 5:
                    if (!name.equals("")) {
                        nameSix.setText(name);
                    }
                    if (impression > 0) {
                        switch (impression) {
                            case 1:
                                nameSix.setBackgroundColor(context.getResources().getColor(R.color.red));
                                break;
                            case 2:
                                nameSix.setBackgroundColor(context.getResources().getColor(R.color.purple));
                                break;
                            case 3:
                                nameSix.setBackgroundColor(context.getResources().getColor(R.color.txt_glow));
                                break;
                        }
                    }
                    break;
                case 6:
                    if (!name.equals("")) {
                        nameSeven.setText(name);
                    }
                    if (impression > 0) {
                        switch (impression) {
                            case 1:
                                nameSeven.setBackgroundColor(context.getResources().getColor(R.color.red));
                                break;
                            case 2:
                                nameSeven.setBackgroundColor(context.getResources().getColor(R.color.purple));
                                break;
                            case 3:
                                nameSeven.setBackgroundColor(context.getResources().getColor(R.color.txt_glow));
                                break;
                        }
                    }
                    break;
                case 7:
                    if (!name.equals("")) {
                        nameEight.setText(name);
                    }
                    if (impression > 0) {
                        switch (impression) {
                            case 1:
                                nameEight.setBackgroundColor(context.getResources().getColor(R.color.red));
                                break;
                            case 2:
                                nameEight.setBackgroundColor(context.getResources().getColor(R.color.purple));
                                break;
                            case 3:
                                nameEight.setBackgroundColor(context.getResources().getColor(R.color.txt_glow));
                                break;
                        }
                    }
                    break;
                case 8:
                    if (!name.equals("")) {
                        nameNine.setText(name);
                    }
                    if (impression > 0) {
                        switch (impression) {
                            case 1:
                                nameNine.setBackgroundColor(context.getResources().getColor(R.color.red));
                                break;
                            case 2:
                                nameNine.setBackgroundColor(context.getResources().getColor(R.color.purple));
                                break;
                            case 3:
                                nameNine.setBackgroundColor(context.getResources().getColor(R.color.txt_glow));
                                break;
                        }
                    }
                    break;
                case 9:
                    if (!name.equals("")) {
                        nameTen.setText(name);
                    }
                    if (impression > 0) {
                        switch (impression) {
                            case 1:
                                nameTen.setBackgroundColor(context.getResources().getColor(R.color.red));
                                break;
                            case 2:
                                nameTen.setBackgroundColor(context.getResources().getColor(R.color.purple));
                                break;
                            case 3:
                                nameTen.setBackgroundColor(context.getResources().getColor(R.color.txt_glow));
                                break;
                        }
                    }
                    break;
            }
        }
    }

    public void retrieveDream(Context context,
                              int postId, AppCompatImageView mood, AppCompatImageView color,
                              MoonTextView dreamsPackageInterpretation,
                              MoonTextView dreamsPackageTitle, MoonTextView dreamsPackageDescription,
                              AppCompatImageView soundImg, MoonTextView titleDate,
                              String dateLoaded, SharedPreferencesManager spManager,
                              RelativeLayout loadingBg, ProgressBar progressBar) {

        setLoadingVisible(loadingBg, progressBar);
        ApiPostCaller apiPostCaller = new ApiPostCaller();
        apiPostCaller.getDreamProps(postId, new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                setLoadingInvisible(loadingBg, progressBar);
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
                loadingBg.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void setMoodToImageView(AppCompatImageView mood) {
        DreamChecklist checklist = DreamChecklist.getInstance();
        if (checklist.getExperience() == 0) {
            mood.setImageResource(R.drawable.ic_sad_emoji);
        } else if (checklist.getExperience() == 1) {
            mood.setImageResource(R.drawable.ic_poker_face_emoji);
        } else if (checklist.getExperience() == 2) {
            mood.setImageResource(R.drawable.ic_happy_emoji);
        }
    }

    private void setColorToImageView(AppCompatImageView color) {
        DreamChecklist checklist = DreamChecklist.getInstance();
        if (checklist.getGrayScale() == 1) {
            color.setImageResource(R.drawable.ic_grayscale);

        } else if (checklist.getGrayScale()==2) {
            color.setImageResource(R.drawable.ic_colorful);
        }
    }

    private void setSoundToImageView(AppCompatImageView soundImg) {
        DreamSound sound = DreamSound.getInstance();
        int soundInt = sound.getSound();
        switch (soundInt) {
            case 0:
            case 1:
                soundImg.setImageResource(R.drawable.ic_non_musical);
                break;
            case 2:
                soundImg.setImageResource(R.drawable.ic_musical);
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
        setMoodToImageView(mood);
        setColorToImageView(color);
        setInterpretationToTextView(dreamsPackageInterpretation);
        setTitleAndContentToTxtView(dreamsPackageTitle, dreamsPackageDescription);
        setSoundToImageView(soundImg);
        setDate(titleDate, dateLoaded);
    }

    public void retrieveSleep(Context context, int postId, SharedPreferencesManager spManager,
                              AppCompatImageView dayTime, AppCompatImageView activity,
                              AppCompatImageView food,
                              RelativeLayout loadingBg, ProgressBar progressBar) {
        setLoadingVisible(loadingBg, progressBar);
        ApiPostCaller apiPostCaller = new ApiPostCaller();
        apiPostCaller.getSleepProps(postId, new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                setLoadingInvisible(loadingBg, progressBar);

                JSONArray jsonArray = new JSONArray(response.toString());
                JSONObject jsonObject = jsonArray.getJSONObject(0);

                Sleep.setSleepProps(jsonObject.getInt("sleepTime"),
                        jsonObject.getInt("sleepPhysicalActivity"),
                        jsonObject.getInt("sleepFoodConsumption"));

                spManager.saveSleepToSp(context);

                setSleepPropsToViews(dayTime, activity, food);
            }

            @Override
            public void onFailure(String errorMessage) {
                setLoadingInvisible(loadingBg, progressBar);
            }
        });
    }

    private void setSleepPropsToViews(AppCompatImageView dayTime, AppCompatImageView activity,
                                      AppCompatImageView food) {
        setSleepTimeToView(dayTime);
        setPhysicalActivityToView(activity);
        setFoodToView(food);
    }

    private void setSleepTimeToView(AppCompatImageView dayTime) {
        Sleep sleep = Sleep.getInstance();
        if (sleep.getTime() == 1) {
            dayTime.setImageResource(R.drawable.ic_day_symbol);
        } else if (sleep.getTime() == 2) {
            dayTime.setImageResource(R.drawable.ic_night_symbol);
            dayTime.setColorFilter(R.color.txt_glow);
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
