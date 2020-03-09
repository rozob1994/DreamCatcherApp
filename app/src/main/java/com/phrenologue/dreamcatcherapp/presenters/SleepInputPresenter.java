package com.phrenologue.dreamcatcherapp.presenters;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import androidx.appcompat.widget.AppCompatEditText;

import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.OperationResults;
import com.phrenologue.dreamcatcherapp.parameters.dateParameters.parameters.Date;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamChecklist;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Sleep;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONException;
import org.json.JSONObject;

public class SleepInputPresenter {
    public Sleep sleep;
    public Dream dream;
    public Date date;
    public DreamChecklist checklist;
    ApiPostCaller postCaller;
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

    public boolean saveSleepAndContinue(AppCompatEditText edtHours, AppCompatEditText edtMinutes){
        sleep = Sleep.getInstance();
        dream = Dream.getInstance();
        checklist = DreamChecklist.getInstance();

        String duration = edtHours.getText().toString() + " Hours, " +
                edtMinutes.getText().toString() + " Minutes.";
        sleep.setDuration(duration);
        checklist.setRemembered(1);
        dream.setDreamChecklist(checklist);
        dream.setPostId(sleep.generatePostId());
        postCaller = new ApiPostCaller();
        OperationResults results = OperationResults.getInstance();
        postCaller.saveSleepSeparately(new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                JSONObject jsonObject = new JSONObject(response.toString());
                boolean status = jsonObject.getBoolean("status");
                if (status) {
                    results.setStatus(true);
                } else {
                    results.setStatus(false);
                }
            }
            @Override
            public void onFailure(String errorMessage) {
                results.setStatus(false);
            }
        });
        return results.isStatus();
    }
    public boolean saveSleepAndGo(AppCompatEditText edtHours, AppCompatEditText edtMinutes){
        sleep = Sleep.getInstance();
        dream = Dream.getInstance();
        date = Date.getInstance();
        checklist = DreamChecklist.getInstance();
        String duration = edtHours.getText().toString() + " Hours " +
                edtMinutes.getText().toString() + " Min. "; // Storing sleep duration as a single string.
        sleep.setDuration(duration); // Storing sleep duration in the instance of Sleep.class.
        sleep.generatePostId();
        checklist.setRemembered(0);
        dream.setDreamChecklist(checklist);
        date.setDateToday(); // Setting today's date in our instance of date.
        OperationResults results = OperationResults.getInstance();
        postCaller = new ApiPostCaller();
        postCaller.saveSleepSeparately(new IResponseMessage() { // Saving the sleep input.
            @Override
            public void onSuccess(Object response) throws JSONException {
                JSONObject jsonObject = new JSONObject(response.toString()); // Getting a JSONObject to store the response from the server in a string.
                boolean status = jsonObject.getBoolean("status"); // Getting the result of the savePost method as a boolean (true/false).
                Log.e("", "");
                if (status) {
                    results.setStatus(true);
                    Sleep.delSleep(); // Deleting the sleep instance, since the user doesn't want to add more info about it.

                } else {
                    results.setStatus(false);
                }

            }

            @Override
            public void onFailure(String errorMessage) { // In case of connection error.
                results.setStatus(false);

            }
        });
        return results.isStatus();
    }

}
