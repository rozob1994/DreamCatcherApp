package com.catchydreams.dreamcatcher.presenters;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.catchydreams.dreamcatcher.activities.Adapter.DreamsPackagesActivityAdapter;
import com.catchydreams.dreamcatcher.constants.ConnectionChecker;
import com.catchydreams.dreamcatcher.database.posts.PostsEntity;
import com.catchydreams.dreamcatcher.managersAndFilters.FormatHelper;
import com.catchydreams.dreamcatcher.managersAndFilters.IConnectionChecker;
import com.catchydreams.dreamcatcher.parameters.IResponseMessage;
import com.catchydreams.dreamcatcher.parameters.Users;
import com.catchydreams.dreamcatcher.presenters.presenterInterfaces.IDreamPackagesView;
import com.catchydreams.dreamcatcher.webservice.ApiPostCaller;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class DreamsPresenter {
    List<PostsEntity> posts;
    private IDreamPackagesView iDreamPackagesView;

    public DreamsPresenter(IDreamPackagesView iDreamPackagesView) {

        this.iDreamPackagesView = iDreamPackagesView;
    }

    public boolean onLanguageChanged(SharedPreferences languagePrefs) {
        boolean changed = languagePrefs.getBoolean("packagesLanguageChanged", false);
        String language = languagePrefs.getString("language", "en");
        if (language.equals("fa")){
            iDreamPackagesView.setPersianTypeFace();
        }
        if (changed) {
            iDreamPackagesView.onLanguageChanged();
            languagePrefs.edit().putBoolean("packagesLanguageChanged", false).apply();
            return true;
        } else {
            return false;
        }

    }

    public void getDescription(IConnectionChecker connection, Context context, RecyclerView dreamsRecycler) {
        ConnectionChecker connectionChecker = new ConnectionChecker(connection);
        Users.getInstance().setConnected(false);
        SharedPreferences languagePrefs = context.getSharedPreferences("languages",
                Context.MODE_PRIVATE);
        String language = languagePrefs.getString("language", "en");
        iDreamPackagesView.showProgressBar();
        ApiPostCaller postCaller = new ApiPostCaller();
        postCaller.getDreamDescription(new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                Users.getInstance().setConnected(true);
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
                if (language.equals("en")) {
                    iDreamPackagesView.setEngDreamCount(postIds.size());;
                } else if (language.equals("fa")) {
                    String engCount = String.valueOf(postIds.size());
                    String perCount = FormatHelper.toPersianNumber(engCount);
                    iDreamPackagesView.setPerDreamCount(perCount);
                }

            }

            @Override
            public void onFailure(String errorMessage) {
                Users.getInstance().setConnected(false);
                iDreamPackagesView.hideProgressBar();
            }

        });

        connectionChecker.checkConnection();
    }


    public void setLevel() {
        Users user = Users.getInstance();
        int level = user.getLevel();
        switch (level) {
            case 1:
                iDreamPackagesView.setLevelView("images/level_one", "level1.json");

                break;
            case 2:
                iDreamPackagesView.setLevelView("images/level_two", "level2.json");
                break;
            case 3:
                iDreamPackagesView.setLevelView("images/level_three", "level3.json");
                break;
            case 4:
                iDreamPackagesView.setLevelView("images/level_four", "level4.json");
                break;
            case 5:
                iDreamPackagesView.setLevelView("images/level_five", "level5.json");
                break;
            case 6:
                iDreamPackagesView.setLevelView("images/level_six", "level6.json");
                break;
            case 7:
                iDreamPackagesView.setLevelView("images/level_seven", "level7.json");
                break;
            case 8:
                iDreamPackagesView.setLevelView("images/level_eight", "level8.json");
                break;
            case 9:
                iDreamPackagesView.setLevelView("images/level_nine", "level9.json");
                break;
            case 10:
                iDreamPackagesView.setLevelView("images/level_ten", "level10.json");
                break;
        }

    }
}
