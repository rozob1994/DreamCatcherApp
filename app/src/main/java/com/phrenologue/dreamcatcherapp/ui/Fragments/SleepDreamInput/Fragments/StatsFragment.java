package com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.phrenologue.dreamcatcherapp.databinding.FragmentStatsBinding;
import com.phrenologue.dreamcatcherapp.presenters.StatsPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class StatsFragment extends Fragment {


    private FragmentStatsBinding binding;
    private PieChart rememberedChart, soundChart, musicalChart, colorfulChart, moodChart,
            lucidityChart;
    private LineChart dailyMoodChart;
    private StatsPresenter presenter;

    public StatsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentStatsBinding.inflate(inflater, container, false);
        View view= binding.getRoot();

        rememberedChart = binding.pieChart;
        dailyMoodChart = binding.lineChart;
        soundChart = binding.pieChartTwo;
        musicalChart = binding.pieChartThree;
        colorfulChart = binding.pieChartFour;
        moodChart = binding.pieChartFive;
        lucidityChart = binding.pieChartSix;
        presenter = new StatsPresenter();
        presenter.drawDreamRememberedPercent(container.getContext(),rememberedChart);
        presenter.drawDailyMood(dailyMoodChart);
        presenter.drawSoundPercent(soundChart);
        presenter.drawMusicalPercent(musicalChart);
        presenter.drawColorfulPercent(colorfulChart);
        presenter.drawMoodPercent(moodChart);
        presenter.drawLucidityPercent(lucidityChart);



        return view;
        }

    }
