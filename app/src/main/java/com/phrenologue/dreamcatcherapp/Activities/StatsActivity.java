package com.phrenologue.dreamcatcherapp.Activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.phrenologue.dreamcatcherapp.Ui.colorPalette.ColorPalettes;
import com.phrenologue.dreamcatcherapp.databinding.ActivityStatsBinding;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class StatsActivity extends AppCompatActivity {
    private ActivityStatsBinding binding;
    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStatsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        pieChart = binding.pieChart;
        ApiPostCaller postCaller = new ApiPostCaller();
        postCaller.getRemembered(new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                Log.e("", "");
                JSONArray jsonArray = new JSONArray(response.toString());

                ArrayList<Integer> list = new ArrayList();

                for (int i = 0; i < jsonArray.length(); i++) {
                    list.add(jsonArray.getInt(i));
                }

                float countOnes = 0;
                float countZeroes = 0;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) == 0) {
                        countZeroes++;
                    }
                    countOnes++;
                }

                ArrayList<PieEntry> entries = new ArrayList<>();
                entries.add(new PieEntry(countOnes / 100, "Remembered"));
                entries.add(new PieEntry(countZeroes / 100, "Forgotten"));
                PieDataSet pieDataSet = new PieDataSet(entries, "Percent of dreams remembered.");
                pieDataSet.setColors(ColorPalettes.PIECHARTS);
                PieData pieData = new PieData(pieDataSet);
                pieChart.setData(pieData);
                pieChart.animateXY(5000, 5000);
                pieChart.invalidate();
                pieChart.setDrawHoleEnabled(false);

            }

            @Override
            public void onFailure(String errorMessage) {
                Log.e("", "");
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            }
        });
    }
}
