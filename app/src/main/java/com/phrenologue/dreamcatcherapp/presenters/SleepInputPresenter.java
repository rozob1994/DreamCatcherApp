package com.phrenologue.dreamcatcherapp.presenters;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Sleep;

public class SleepInputPresenter {
    public Sleep sleep;

    public SleepInputPresenter() {
    }

    public void setDayBtnOn(LinearLayout dayOn, LinearLayout dayOff, LinearLayout nightOn,
                            LinearLayout nightOff) {
        sleep = Sleep.getInstance();
        sleep.setTime(1);
        if (dayOn.getVisibility() == View.VISIBLE) {
            dayOn.setVisibility(View.INVISIBLE);
            dayOff.setVisibility(View.VISIBLE);
        } else {
            dayOn.setVisibility(View.VISIBLE);
            dayOff.setVisibility(View.INVISIBLE);
            nightOn.setVisibility(View.INVISIBLE);
            nightOff.setVisibility(View.VISIBLE);
        }
    }

    public void setDayBtnOff(LinearLayout dayOn, LinearLayout dayOff, LinearLayout nightOff){
        sleep = Sleep.getInstance();
        sleep.setTime(0);
        if (dayOff.getVisibility() == View.VISIBLE) {
            dayOff.setVisibility(View.INVISIBLE);
            dayOn.setVisibility(View.VISIBLE);
        } else {
            dayOff.setVisibility(View.VISIBLE);
            dayOn.setVisibility(View.INVISIBLE);
            nightOff.setVisibility(View.VISIBLE);
        }
    }

    public void setNightBtnOn(LinearLayout dayOn, LinearLayout dayOff, LinearLayout nightOn,
                              LinearLayout nightOff){
        sleep = Sleep.getInstance();
        sleep.setTime(2); // Setting sleep's time to night.
        if (nightOn.getVisibility() == View.VISIBLE) {
            nightOn.setVisibility(View.INVISIBLE);
            nightOff.setVisibility(View.VISIBLE);
        } else {
            nightOn.setVisibility(View.VISIBLE);
            nightOff.setVisibility(View.INVISIBLE);
            dayOn.setVisibility(View.INVISIBLE);
            dayOff.setVisibility(View.VISIBLE);
        }
    }

    public void setNightBtnOff(LinearLayout dayOn, LinearLayout dayOff, LinearLayout nightOn,
                              LinearLayout nightOff){
        sleep = Sleep.getInstance();
        sleep.setTime(0); // Deleting sleep's time.
        if (nightOff.getVisibility() == View.VISIBLE) {
            nightOff.setVisibility(View.INVISIBLE);
            nightOn.setVisibility(View.VISIBLE);
        } else {
            nightOff.setVisibility(View.VISIBLE);
            nightOn.setVisibility(View.INVISIBLE);
            dayOff.setVisibility(View.VISIBLE);
        }
    }

    public void setPhysicalActivitySeekBar(SeekBar physicalActivity){
        sleep = Sleep.getInstance();

        physicalActivity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sleep.setPhysicalActivity(progress);
                seekBar.setMax(9);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void setFoodConsumptionSeekBar (SeekBar foodConsumption){
        sleep = Sleep.getInstance();
        foodConsumption.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sleep.setFoodConsumption(progress);
                seekBar.setMax(9);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void saveSleep(){

    }

}
