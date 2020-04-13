package com.phrenologue.dreamcatcherapp.presenters;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.phrenologue.dreamcatcherapp.activities.Adapter.DreamsPackagesActivityAdapter;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.ui.costumeFont.MoonTextView;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class DreamsPresenter {
    private Context context;

    public DreamsPresenter(Context context) {
        this.context = context;
    }

    public void getDescription(Context context,
                               RelativeLayout loadingBg, RecyclerView dreamsRecycler,
                               MoonTextView dreamCount) {
        loadingBg.setVisibility(View.VISIBLE);
        loadingBg.setAlpha(0.5f);
        ApiPostCaller postCaller = new ApiPostCaller();
        postCaller.getDreamDescription(new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                loadingBg.setVisibility(View.GONE);
                JSONArray jsonArray = new JSONArray(response.toString());

                ArrayList<JSONArray> jsonArrays = new ArrayList();

                for (int i = 0; i < jsonArray.length(); i++) {
                    jsonArrays.add(jsonArray.getJSONArray(i));
                }
                List<String> titles = new ArrayList<String>();
                List<String> contents = new ArrayList<String>();
                List<Integer> postIds = new ArrayList<>();
                List<Integer> sounds = new ArrayList<>();
                List<Integer> musics = new ArrayList<>();
                List<Integer> grayScales = new ArrayList<>();
                List<Integer> experiences = new ArrayList<>();
                List<Integer> lucidityLevels = new ArrayList<>();
                List<Integer> days = new ArrayList<>();
                List<Integer> months = new ArrayList<>();
                List<Integer> years = new ArrayList<>();
                List<String> interpretations = new ArrayList<>();
                List<Integer> sleepTimes = new ArrayList<>();


                for (int j = 0; j < jsonArrays.size(); j++) {
                    titles.add(jsonArrays.get(j).getString(1));
                    contents.add(jsonArrays.get(j).getString(0));
                    postIds.add(jsonArrays.get(j).getInt(2));
                    sounds.add(jsonArrays.get(j).getInt(3));
                    musics.add(jsonArrays.get(j).getInt(4));
                    grayScales.add(jsonArrays.get(j).getInt(5));
                    experiences.add(jsonArrays.get(j).getInt(6));
                    //lucidityLevels.add(jsonArrays.get(j).getInt(7));
                    days.add(jsonArrays.get(j).getInt(8));
                    months.add(jsonArrays.get(j).getInt(9));
                    years.add(jsonArrays.get(j).getInt(10));
                    interpretations.add(jsonArrays.get(j).getString(11));
                    sleepTimes.add(jsonArrays.get(j).getInt(12));
                }
                DreamsPackagesActivityAdapter adapter = new DreamsPackagesActivityAdapter(context,
                        titles, contents, postIds, sounds, musics, grayScales, experiences,
                        lucidityLevels, days, months, years, interpretations, sleepTimes);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
                dreamsRecycler.setLayoutManager(layoutManager);
                dreamsRecycler.setAdapter(adapter);
                dreamCount.setText("Dream Count: " + titles.size() + "");
            }

            @Override
            public void onFailure(String errorMessage) {
                loadingBg.setVisibility(View.GONE);
                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
            }

        });

    }

    public void getDescriptionForChoice(Context context,
                                        RelativeLayout loadingBg, RecyclerView dreamsRecycler) {
        loadingBg.setVisibility(View.VISIBLE);
        loadingBg.setAlpha(0.5f);
        ApiPostCaller postCaller = new ApiPostCaller();
        postCaller.getDreamDescription(new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                loadingBg.setVisibility(View.GONE);
                JSONArray jsonArray = new JSONArray(response.toString());

                ArrayList<JSONArray> jsonArrays = new ArrayList();

                for (int i = 0; i < jsonArray.length(); i++) {
                    jsonArrays.add(jsonArray.getJSONArray(i));
                }
                List<String> titles = new ArrayList<String>();
                List<String> contents = new ArrayList<String>();
                List<Integer> postIds = new ArrayList<>();
                List<Integer> sounds = new ArrayList<>();
                List<Integer> musics = new ArrayList<>();
                List<Integer> grayScales = new ArrayList<>();
                List<Integer> experiences = new ArrayList<>();
                List<Integer> lucidityLevels = new ArrayList<>();
                List<Integer> days = new ArrayList<>();
                List<Integer> months = new ArrayList<>();
                List<Integer> years = new ArrayList<>();
                List<String> interpretations = new ArrayList<>();
                List<Integer> sleepTimes = new ArrayList<>();


                for (int j = 0; j < jsonArrays.size(); j++) {
                    titles.add(jsonArrays.get(j).getString(1));
                    contents.add(jsonArrays.get(j).getString(0));
                    postIds.add(jsonArrays.get(j).getInt(2));
                    sounds.add(jsonArrays.get(j).getInt(3));
                    musics.add(jsonArrays.get(j).getInt(4));
                    grayScales.add(jsonArrays.get(j).getInt(5));
                    experiences.add(jsonArrays.get(j).getInt(6));
                    lucidityLevels.add(jsonArrays.get(j).getInt(7));
                    days.add(jsonArrays.get(j).getInt(8));
                    months.add(jsonArrays.get(j).getInt(9));
                    years.add(jsonArrays.get(j).getInt(10));
                    interpretations.add(jsonArrays.get(j).getString(11));
                    sleepTimes.add(jsonArrays.get(j).getInt(12));
                }
                DreamsPackagesActivityAdapter adapter = new DreamsPackagesActivityAdapter(context,
                        titles, contents, postIds, sounds, musics, grayScales, experiences,
                        lucidityLevels, days, months, years, interpretations, sleepTimes);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
                dreamsRecycler.setLayoutManager(layoutManager);
                dreamsRecycler.setAdapter(adapter);
            }

            @Override
            public void onFailure(String errorMessage) {
                loadingBg.setVisibility(View.GONE);
                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
            }

        });

    }
}
