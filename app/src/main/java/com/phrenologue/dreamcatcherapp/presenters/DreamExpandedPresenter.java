package com.phrenologue.dreamcatcherapp.presenters;

import android.content.Context;
import android.util.Log;

import androidx.appcompat.widget.AppCompatImageView;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.managersAndFilters.SharedPreferencesManager;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamChecklist;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamDate;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamDescription;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamInterpretation;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamLucidity;
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

    public void retrievePeople(Context context, int postId, SharedPreferencesManager spManager){
        ApiPostCaller apiPostCaller = new ApiPostCaller();
        apiPostCaller.getPeopleProps(postId, new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
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

                spManager.savePeopleToSp(context, people);
            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });
    }

    public void retrieveDream(Context context,
                              int postId, AppCompatImageView mood, AppCompatImageView color,
                              MoonTextView dreamsPackageInterpretation,
                              MoonTextView dreamsPackageTitle, MoonTextView dreamsPackageDescription,
                              AppCompatImageView soundImg, MoonTextView titleDate,
                              String dateLoaded, SharedPreferencesManager spManager) {
        DreamPeople people = DreamPeople.getInstance();
        DreamChecklist checklist = DreamChecklist.getInstance();
        DreamDate date = DreamDate.getInstance();
        DreamInterpretation interpretation = DreamInterpretation.getInstance();
        DreamDescription description = DreamDescription.getInstance();
        DreamSound sound = DreamSound.getInstance();
        DreamLucidity lucidity = DreamLucidity.getInstance();
        Dream dream = Dream.getInstance();
        ApiPostCaller apiPostCaller = new ApiPostCaller();
        apiPostCaller.getDreamProps(postId, new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                JSONArray jsonArray = new JSONArray(response.toString());
                JSONObject jsonObject = jsonArray.getJSONObject(0);

                people.setExistent(jsonObject.getInt("dreamPeopleExist"));

                checklist.setExperience(jsonObject.getInt("dreamExperience"));

                if (checklist.getExperience() == 0) {
                    mood.setImageResource(R.drawable.ic_sad_emoji);
                } else if (checklist.getExperience() == 1) {
                    mood.setImageResource(R.drawable.ic_poker_face_emoji);
                } else if (checklist.getExperience() == 2) {
                    mood.setImageResource(R.drawable.ic_happy_emoji);
                }

                checklist.setGrayScale(jsonObject.getInt("dreamGrayScale"));
                if (checklist.getGrayScale() == 1) {
                    color.setImageResource(R.drawable.button_grayscale_on);
                }

                date.setDayOfMonth(jsonObject.getInt("dayOfMonth"));
                date.setMonth(jsonObject.getInt("month"));
                date.setYear(jsonObject.getInt("year"));

                interpretation.setInterpretation(jsonObject.getString("interpretation"));
                dreamsPackageInterpretation.setText(interpretation.getInterpretation());

                description.setTitle(jsonObject.getString("dreamTitle"));
                description.setContent(jsonObject.getString("dreamContent"));
                dreamsPackageTitle.setText(description.getTitle());
                dreamsPackageDescription.setText(description.getContent());

                sound.setSound(jsonObject.getInt("dreamSound"));
                sound.setMusical(jsonObject.getInt("dreamMusical"));
                if (sound.getSound() == 0) {
                    soundImg.setImageResource(R.drawable.button_non_musical_on);
                }
                titleDate.setText(dateLoaded);

                lucidity.setLucidityLevel(jsonObject.getInt("dreamLucidityLevel"));

                dream.setDreamPeople(people);
                dream.setDreamChecklist(checklist);
                dream.setDreamInterpretation(interpretation);
                dream.setDreamDescription(description);
                dream.setDreamSound(sound);
                dream.setDreamLucidity(lucidity);


                spManager.saveDreamToSp(context, dream, date);

                dreamsPackageTitle.setText(description.getTitle());
                dreamsPackageDescription.setText(description.getContent());
            }

            @Override
            public void onFailure(String errorMessage) {
                Log.e("", "");
            }
        });
    }

    public void retrieveSleep(Context context, int postId, SharedPreferencesManager spManager,
                              AppCompatImageView dayTime, AppCompatImageView activity,
                              AppCompatImageView food) {
        ApiPostCaller apiPostCaller = new ApiPostCaller();
        apiPostCaller.getSleepProps(postId, new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                JSONArray jsonArray = new JSONArray(response.toString());
                JSONObject jsonObject = jsonArray.getJSONObject(0);

                Sleep sleep = Sleep.getInstance();

                sleep.setTime(jsonObject.getInt("sleepTime"));
                sleep.setFoodConsumption(jsonObject.getInt("sleepFoodConsumption"));
                sleep.setPhysicalActivity(jsonObject.getInt("sleepPhysicalActivity"));

                spManager.saveSleepToSp(context);

                if (sleep.getTime() == 1) {
                    dayTime.setImageResource(R.drawable.ic_day_symbol);
                } else if (sleep.getTime() == 2) {
                    dayTime.setImageResource(R.drawable.ic_night_symbol);
                }

                if (sleep.getPhysicalActivity() == 0) {
                    activity.setImageResource(R.drawable.stick_figure_1);
                } else if (sleep.getPhysicalActivity() == 1) {
                    activity.setImageResource(R.drawable.stick_figure_2);
                } else if (sleep.getPhysicalActivity() == 2) {
                    activity.setImageResource(R.drawable.stick_figure_3);
                } else if (sleep.getPhysicalActivity() == 3) {
                    activity.setImageResource(R.drawable.stick_figure_4);
                }

                if (sleep.getFoodConsumption() == 0) {
                    food.setImageResource(R.drawable.apple);
                } else if (sleep.getFoodConsumption() == 1) {
                    food.setImageResource(R.drawable.steak);
                } else if (sleep.getFoodConsumption() == 2) {
                    food.setImageResource(R.drawable.hamburger_drink);
                }
            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });
    }
}
