package com.phrenologue.dreamcatcherapp.presenters;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.phrenologue.dreamcatcherapp.activities.Adapter.DreamsPackagesActivityAdapter;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.presenters.presenterInterfaces.IDreamPackagesView;
import com.phrenologue.dreamcatcherapp.ui.costumeFont.MoonTextView;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class DreamsPresenter {
    private Context context;
    private IDreamPackagesView iDreamPackagesView;

    public DreamsPresenter(IDreamPackagesView iDreamPackagesView) {

        this.iDreamPackagesView = iDreamPackagesView;
    }

    public void getDescription(Context context,
                               RelativeLayout loadingBg, RecyclerView dreamsRecycler,
                               MoonTextView dreamCount) {

        iDreamPackagesView.showProgressBar();
        ApiPostCaller postCaller = new ApiPostCaller();
        postCaller.getDreamDescription(new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                iDreamPackagesView.hideProgressBar();
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
                DreamsPackagesActivityAdapter adapter = new DreamsPackagesActivityAdapter(context,
                         postIds, sleepTimes, experiences, days, months, years, titles, contents);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
                dreamsRecycler.setLayoutManager(layoutManager);
                dreamsRecycler.setAdapter(adapter);
                dreamCount.setText("Dream Count: " + postIds.size() + "");
            }

            @Override
            public void onFailure(String errorMessage) {
                iDreamPackagesView.hideProgressBar();
                iDreamPackagesView.onError();
            }

        });

    }


    private void setLoadingVisible(RelativeLayout loadingBg) {
        loadingBg.setVisibility(View.VISIBLE);
        loadingBg.setAlpha(0.5f);
    }
}
