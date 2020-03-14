package com.phrenologue.dreamcatcherapp.Activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.phrenologue.dreamcatcherapp.Activities.Adapter.DreamsPackagesActivityAdapter;
import com.phrenologue.dreamcatcherapp.databinding.ActivityTestBinding;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class test extends AppCompatActivity {
    ActivityTestBinding binding;
    RecyclerView recyclerView;
    List<String> titles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        recyclerView = binding.dreamsRecycler;
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

                DreamsPackagesActivityAdapter adapter = new DreamsPackagesActivityAdapter(getApplicationContext(),titles);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(String errorMessage) {

            }

        });


    }
}
