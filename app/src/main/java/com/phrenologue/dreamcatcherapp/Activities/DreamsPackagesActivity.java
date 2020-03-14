package com.phrenologue.dreamcatcherapp.Activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.phrenologue.dreamcatcherapp.Activities.Adapter.DreamsPackagesActivityAdapter;
import com.phrenologue.dreamcatcherapp.databinding.ActivityDreamsPackagesBinding;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.presenters.DreamsPresenter;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class DreamsPackagesActivity extends AppCompatActivity {
    private ActivityDreamsPackagesBinding binding;
    List<String> titles;
    private DreamsPresenter presenter;
    private RecyclerView dreamsRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDreamsPackagesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        dreamsRecycler = binding.dreamsRecycler;
        ApiPostCaller postCaller = new ApiPostCaller();
        postCaller.getDreamDescription(new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {

                JSONArray jsonArray = new JSONArray(response.toString());

                ArrayList<JSONArray> jsonArrays = new ArrayList();

                for (int i = 0; i < jsonArray.length(); i++) {
                    jsonArrays.add(jsonArray.getJSONArray(i));
                }
                titles = new ArrayList<String>();
                ArrayList<String> dreamContents = new ArrayList<String>();
                Log.e("", "");
                for (int j = 0; j < jsonArrays.size(); j++) {
                    titles.add(jsonArrays.get(j).getString(0));
                    dreamContents.add(jsonArrays.get(j).getString(1));
                }

                DreamsPackagesActivityAdapter adapter = new DreamsPackagesActivityAdapter(getApplicationContext(), titles);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                dreamsRecycler.setLayoutManager(layoutManager);
                dreamsRecycler.setAdapter(adapter);
            }

            @Override
            public void onFailure(String errorMessage) {

            }

        });


    }


}
