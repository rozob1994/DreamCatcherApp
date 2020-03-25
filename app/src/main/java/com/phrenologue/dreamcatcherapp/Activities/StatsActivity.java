package com.phrenologue.dreamcatcherapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.phrenologue.dreamcatcherapp.databinding.ActivityStatsBinding;
import com.phrenologue.dreamcatcherapp.presenters.StatsPresenter;

import maes.tech.intentanim.CustomIntent;

public class StatsActivity extends AppCompatActivity {
    private ActivityStatsBinding binding;
    private PieChart rememberedChart, soundChart, musicalChart, colorfulChart, moodChart,
            lucidityChart;
    private LineChart dailyMoodChart;
    private StatsPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStatsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        rememberedChart = binding.pieChart;
        dailyMoodChart = binding.lineChart;
        soundChart = binding.pieChartTwo;
        musicalChart = binding.pieChartThree;
        colorfulChart = binding.pieChartFour;
        moodChart = binding.pieChartFive;
        lucidityChart = binding.pieChartSix;
        presenter = new StatsPresenter();

        presenter.drawDreamRememberedPercent(rememberedChart);
        presenter.drawDailyMood(dailyMoodChart);
        presenter.drawSoundPercent(soundChart);
        presenter.drawMusicalPercent(musicalChart);
        presenter.drawColorfulPercent(colorfulChart);
        presenter.drawMoodPercent(moodChart);
        presenter.drawLucidityPercent(lucidityChart);

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
                CustomIntent.customType(StatsActivity.this,"fadein-to-fadeout");
            }
        });
    }


    @Override
    public void onBackPressed() { }
}
