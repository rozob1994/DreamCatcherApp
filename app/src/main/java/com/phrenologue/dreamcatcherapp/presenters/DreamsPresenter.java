package com.phrenologue.dreamcatcherapp.presenters;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.phrenologue.dreamcatcherapp.activities.Adapter.DreamsPackagesActivityAdapter;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Post;
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

        setLoadingVisible(loadingBg);
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
                List<Integer> postIds = new ArrayList<>();

                for (int j = 0; j < jsonArrays.size(); j++) {
                    postIds.add(jsonArrays.get(j).getInt(2));
                }
                Post post = new Post();
                List<Post> posts = post.getPosts(postIds);

                DreamsPackagesActivityAdapter adapter = new DreamsPackagesActivityAdapter(context,
                        posts, postIds);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
                dreamsRecycler.setLayoutManager(layoutManager);
                dreamsRecycler.setAdapter(adapter);
                dreamCount.setText("Dream Count: " + posts.size() + "");
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
                List<Integer> postIds = new ArrayList<>();


                for (int j = 0; j < jsonArrays.size(); j++) {
                    postIds.add(jsonArrays.get(j).getInt(2));
                }
                Post post = new Post();
                List<Post> posts = post.getPosts(postIds);
                DreamsPackagesActivityAdapter adapter = new DreamsPackagesActivityAdapter(context,
                        posts, postIds);
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

    private void setLoadingVisible(RelativeLayout loadingBg) {
        loadingBg.setVisibility(View.VISIBLE);
        loadingBg.setAlpha(0.5f);
    }
}
