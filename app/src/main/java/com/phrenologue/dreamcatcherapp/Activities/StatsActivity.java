package com.phrenologue.dreamcatcherapp.Activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.phrenologue.dreamcatcherapp.databinding.ActivityStatsBinding;
import com.phrenologue.dreamcatcherapp.presenters.StatsPresenter;

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

    }
}
