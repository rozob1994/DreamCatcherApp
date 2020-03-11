package com.phrenologue.dreamcatcherapp.Activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.phrenologue.dreamcatcherapp.databinding.ActivityStatsBinding;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StatsActivity extends AppCompatActivity {
    private ActivityStatsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStatsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ApiPostCaller postCaller = new ApiPostCaller();
        postCaller.getDreamsDayOfYear(new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                Log.e("","");
                JSONObject jsonObject = new JSONObject(response.toString());
                JSONArray dataJson = new JSONArray();
                Iterator i = jsonObject.keys();
                while (i.hasNext()){
                    String key = i.next().toString();
                    dataJson.put(jsonObject.get(key));
                }
                List<Integer> x = new ArrayList();
                ArrayList xArray = new ArrayList();
                List<Integer> y = new ArrayList();

                for (int j = 3 ; j<dataJson.length();j++){
                    JSONArray entry = dataJson.getJSONArray(j);
                    x.add(Integer.parseInt(entry.getString(0)));
                    xArray.add(Integer.parseInt(entry.getString(0)));
                    y.add(Integer.parseInt(entry.getString(1)));

                }
                ArrayList entries = new ArrayList();
                for (int k = 0; k<x.size();k++){
                    BarEntry entry = new BarEntry(y.get(k),x.get(k));
                    entries.add(entry);
                }
                BarDataSet dataSet = new BarDataSet(entries,"experience");
                BarData data = new BarData(dataSet);
                BarChart chart = binding.barChart;
                chart.setData(data);
                chart.animateXY(2000,2000);
                chart.invalidate();

                Log.e("","");
            }


            @Override
            public void onFailure(String errorMessage) {
                Log.e("","");
            }
        });

    }
}
