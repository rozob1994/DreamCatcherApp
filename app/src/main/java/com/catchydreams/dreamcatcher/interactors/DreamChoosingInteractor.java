package com.catchydreams.dreamcatcher.interactors;

import com.catchydreams.dreamcatcher.parameters.IResponseMessage;
import com.catchydreams.dreamcatcher.parameters.postParameters.DreamChoosingItem;
import com.catchydreams.dreamcatcher.presenters.presenterInterfaces.IDreamChoosingPresenter;
import com.catchydreams.dreamcatcher.webservice.ApiPostCaller;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class DreamChoosingInteractor {
    IDreamChoosingPresenter iDreamChoosingPresenter;
    public DreamChoosingInteractor(IDreamChoosingPresenter iDreamChoosingPresenter){
        this.iDreamChoosingPresenter = iDreamChoosingPresenter;
    }
    public void getDreamDescription(){
        iDreamChoosingPresenter.loading();
        ApiPostCaller apiPostCaller = new ApiPostCaller();
        apiPostCaller.getDreamDescription(new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                extractLists(response);
                iDreamChoosingPresenter.onSuccess();
            }

            @Override
            public void onFailure(String errorMessage) {
                iDreamChoosingPresenter.onFailure();
            }
        });
    }

    private void extractLists(Object response) throws JSONException {
        DreamChoosingItem item = DreamChoosingItem.getInstance();

        JSONArray jsonArray = new JSONArray(response.toString());

        ArrayList<JSONArray> jsonArrays = new ArrayList();

        for (int i = 0; i < jsonArray.length(); i++) {
            jsonArrays.add(jsonArray.getJSONArray(i));
        }
        List<Integer> postIds = new ArrayList<>();
        List<Integer> sleepTimes = new ArrayList<>();
        List<Integer> experiences = new ArrayList<>();
        List<Integer> days = new ArrayList<>();
        List<Integer> months = new ArrayList<>();
        List<Integer> years = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        List<String> contents = new ArrayList<>();

        for (int j = 0; j < jsonArrays.size(); j++) {
            postIds.add(jsonArrays.get(j).getInt(2));
            experiences.add(jsonArrays.get(j).getInt(6));
            sleepTimes.add(jsonArrays.get(j).getInt(12));
            days.add(jsonArrays.get(j).getInt(8));
            months.add(jsonArrays.get(j).getInt(9));
            years.add(jsonArrays.get(j).getInt(10));
            titles.add(jsonArrays.get(j).getString(0));
            contents.add(jsonArrays.get(j).getString(1));
        }

        item.setPostIds(postIds);
        item.setSleepTimes(sleepTimes);
        item.setExperiences(experiences);
        item.setDays(days);
        item.setMonths(months);
        item.setYears(years);
        item.setTitles(titles);
        item.setContents(contents);
    }
}
