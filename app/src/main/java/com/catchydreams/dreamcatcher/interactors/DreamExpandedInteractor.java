package com.catchydreams.dreamcatcher.interactors;

import android.content.SharedPreferences;

import com.catchydreams.dreamcatcher.managersAndFilters.ISharedPreferencesManager;
import com.catchydreams.dreamcatcher.managersAndFilters.SharedPreferencesManager;
import com.catchydreams.dreamcatcher.parameters.IResponseMessage;
import com.catchydreams.dreamcatcher.parameters.postParameters.dreamParameters.DreamPeople;
import com.catchydreams.dreamcatcher.parameters.postParameters.majorParameters.Dream;
import com.catchydreams.dreamcatcher.parameters.postParameters.majorParameters.Sleep;
import com.catchydreams.dreamcatcher.presenters.presenterInterfaces.IDreamExpandedPresenter;
import com.catchydreams.dreamcatcher.webservice.ApiPostCaller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DreamExpandedInteractor {
    private IDreamExpandedPresenter iPresenter;
    private ApiPostCaller apiPostCaller = new ApiPostCaller();
    private ISharedPreferencesManager iSharedPreferencesManager = new SharedPreferencesManager();
    public DreamExpandedInteractor(IDreamExpandedPresenter iPresenter) {
        this.iPresenter = iPresenter;
    }

    public void getPost(int postId, String dateLoaded, SharedPreferences sleepSp,
                        SharedPreferences dreamSp, SharedPreferences dreamSpTwo,
                        SharedPreferences languagePrefs) {
        apiPostCaller.getSleepProps(postId, new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                setSleep(response);
                apiPostCaller.getDreamProps(postId, new IResponseMessage() {
                    @Override
                    public void onSuccess(Object response) throws JSONException {
                        setDream(response);
                        apiPostCaller.getPeopleProps(postId, new IResponseMessage() {
                            @Override
                            public void onSuccess(Object response) throws JSONException {
                                iPresenter.onSleepRetrieved();
                                iPresenter.onDreamRetrieved(dateLoaded);
                                setPeople(response);
                                iPresenter.onPeopleRetrieved();
                                apiPostCaller.getQResult(postId, new IResponseMessage() {
                                    @Override
                                    public void onSuccess(Object response) throws JSONException {
                                        cachePost(sleepSp, dreamSp, dreamSpTwo);
                                        JSONObject jsonObject = new JSONObject(response.toString());
                                        JSONArray jsonArray = jsonObject.getJSONArray("0");
                                        boolean status = jsonObject.getBoolean("status");
                                        if (status) {
                                            int result = jsonArray.getJSONObject(0).getInt("result");
                                            iPresenter.checkLucidity(result, languagePrefs);
                                        } else {
                                            iPresenter.onError();
                                        }
                                    }

                                    @Override
                                    public void onFailure(String errorMessage) {
                                        iPresenter.onError();
                                    }
                                });
                            }

                            @Override
                            public void onFailure(String errorMessage) {
                                iPresenter.onError();
                            }
                        });
                    }

                    @Override
                    public void onFailure(String errorMessage) {
                        iPresenter.onError();
                    }
                });
            }

            @Override
            public void onFailure(String errorMessage) {
                iPresenter.onError();
            }
        });
    }

    public void cachePost(SharedPreferences sleepSp, SharedPreferences dreamSp,
                          SharedPreferences dreamSpTwo){
        iSharedPreferencesManager.saveSleep(sleepSp);
        iSharedPreferencesManager.saveDream(dreamSp, dreamSpTwo);
        iSharedPreferencesManager.savePeople(dreamSp);
    };

    private void setSleep(Object response) throws JSONException {
        JSONArray jsonArray = new JSONArray(response.toString());
        JSONObject jsonObject = jsonArray.getJSONObject(0);

        Sleep.setSleepProps(jsonObject.getInt("sleepTime"),
                jsonObject.getInt("sleepPhysicalActivity"),
                jsonObject.getInt("sleepFoodConsumption"));
    }

    private void setDream(Object response) throws JSONException {
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
    }

    private void setPeople(Object response) throws JSONException {
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

        for (int i = 0; i < 10; i++) {
            if (impressions.get(i) != null) {
                people.setImpression(i, impressions.get(i));
            }

        }

        for (int i = 0; i < 10; i++) {
            people.setName(i, names.get(i));
        }
    }

}
