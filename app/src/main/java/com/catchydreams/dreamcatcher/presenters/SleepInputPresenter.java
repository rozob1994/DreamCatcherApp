package com.catchydreams.dreamcatcher.presenters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatEditText;

import com.catchydreams.dreamcatcher.activities.ProfileActivity;
import com.catchydreams.dreamcatcher.activities.viewInterfaces.ISleepInfoInputFragment;
import com.catchydreams.dreamcatcher.parameters.IResponseMessage;
import com.catchydreams.dreamcatcher.parameters.OperationResults;
import com.catchydreams.dreamcatcher.parameters.dateParameters.parameters.Date;
import com.catchydreams.dreamcatcher.parameters.postParameters.dreamParameters.DreamChecklist;
import com.catchydreams.dreamcatcher.parameters.postParameters.majorParameters.Dream;
import com.catchydreams.dreamcatcher.parameters.postParameters.majorParameters.Sleep;
import com.catchydreams.dreamcatcher.ui.customFont.MoonTextView;
import com.catchydreams.dreamcatcher.webservice.ApiPostCaller;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class SleepInputPresenter {
    ISleepInfoInputFragment iSleepInfoInputFragment;
    public Sleep sleep;
    public Dream dream;
    public Date date;
    public DreamChecklist checklist;
    ApiPostCaller postCaller;
    public SleepInputPresenter(ISleepInfoInputFragment iSleepInfoInputFragment) {
        this.iSleepInfoInputFragment = iSleepInfoInputFragment;
    }

    public void setTitleFonts(List<MoonTextView> titles){
        for (int i = 0; i < titles.size(); i++){
            iSleepInfoInputFragment.setTitleFonts(titles.get(i));
        }
    }

    public void setHintFonts(List<MoonTextView> hints) {
        for (int i = 0; i < hints.size(); i++) {
            iSleepInfoInputFragment.setHintFonts(hints.get(i));
        }
    }

    public void setSubscriptFonts(List<MoonTextView> subscripts) {
        for (int i = 0; i < subscripts.size(); i++){
            iSleepInfoInputFragment.setSubscriptFonts(subscripts.get(i));
        }
    }

    public void setTypeFace(SharedPreferences languagePrefs){
        String language = languagePrefs.getString("language","");
        if (language.equals("fa")){
            iSleepInfoInputFragment.setPersianFont();
        }
    }

    public void setDayBtnOn(SharedPreferences.Editor sleepSp, LinearLayout dayOn, LinearLayout dayOff,
                            LinearLayout nightOn, LinearLayout nightOff) {
        sleep = Sleep.getInstance();
        sleep.setTime(1);
        sleepSp.putBoolean("day", true).apply();
        sleepSp.putBoolean("night", false).apply();
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

    public void setDayBtnOff(SharedPreferences.Editor sleepSp, LinearLayout dayOn, LinearLayout dayOff,
                             LinearLayout nightOff){
        sleep = Sleep.getInstance();
        sleep.setTime(0);
        sleepSp.putBoolean("day", false).apply();
        if (dayOff.getVisibility() == View.VISIBLE) {
            dayOff.setVisibility(View.INVISIBLE);
            dayOn.setVisibility(View.VISIBLE);
        } else {
            dayOff.setVisibility(View.VISIBLE);
            dayOn.setVisibility(View.INVISIBLE);
            nightOff.setVisibility(View.VISIBLE);
        }
    }

    public void setNightBtnOn(SharedPreferences.Editor sleepSp, LinearLayout dayOn, LinearLayout dayOff,
                              LinearLayout nightOn, LinearLayout nightOff){
        sleep = Sleep.getInstance();
        sleep.setTime(2); // Setting sleep's time to night.
        sleepSp.putBoolean("night", true).apply();
        sleepSp.putBoolean("day", false).apply();
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

    public void setNightBtnOff(SharedPreferences.Editor sleepSp,LinearLayout dayOn, LinearLayout dayOff,
                               LinearLayout nightOn, LinearLayout nightOff){
        sleep = Sleep.getInstance();
        sleep.setTime(0); // Deleting sleep's time.
        sleepSp.putBoolean("night", false).apply();
        if (nightOff.getVisibility() == View.VISIBLE) {
            nightOff.setVisibility(View.INVISIBLE);
            nightOn.setVisibility(View.VISIBLE);
        } else {
            nightOff.setVisibility(View.VISIBLE);
            nightOn.setVisibility(View.INVISIBLE);
            dayOff.setVisibility(View.VISIBLE);
        }
    }

    public void setPhysicalActivitySeekBar(SharedPreferences.Editor sleepSp, SeekBar physicalActivity){
        sleep = Sleep.getInstance();
        physicalActivity.setMax(3);
        physicalActivity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sleep.setPhysicalActivity(progress);
                sleepSp.putBoolean("hasPhysicalActivity", true).apply();
                sleepSp.putInt("physicalActivity", progress).apply();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void setFoodConsumptionSeekBar (SharedPreferences.Editor sleepSp, SeekBar foodConsumption){
        sleep = Sleep.getInstance();
        foodConsumption.setMax(2);
        foodConsumption.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sleep.setFoodConsumption(progress);
                sleepSp.putBoolean("hasFoodConsumption", true).apply();
                sleepSp.putInt("foodConsumption", progress).apply();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public boolean saveSleepAndContinue(RelativeLayout loadingBg, Context context,
                                        AppCompatEditText edtHours, AppCompatEditText edtMinutes){
        loadingBg.setVisibility(View.VISIBLE);
        loadingBg.setAlpha(0.5f);
        sleep = Sleep.getInstance();
        dream = Dream.getInstance();
        checklist = DreamChecklist.getInstance();

        String duration = edtHours.getText().toString() + " Hours, " +
                edtMinutes.getText().toString() + " Minutes.";
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
                    loadingBg.setVisibility(View.GONE);
                    results.setStatus(false);
                }
            }
            @Override
            public void onFailure(String errorMessage) {
                loadingBg.setVisibility(View.GONE);
                results.setStatus(false);
            }
        },1);
        return results.isStatus();
    }
    public void saveSleepAndGo(AppCompatEditText edtHours, AppCompatEditText edtMinutes,
                                  RelativeLayout loadingBg, Context context){
        loadingBg.setVisibility(View.VISIBLE);
        loadingBg.setAlpha(0.5f);
        sleep = Sleep.getInstance();
        dream = Dream.getInstance();
        date = Date.getInstance();
        checklist = DreamChecklist.getInstance();
        String duration;
        if ((!edtHours.getText().toString().equals(""))&&(!edtMinutes.getText().toString().equals(""))){
            int hour = Integer.parseInt(edtHours.getText().toString());
            int min = Integer.parseInt(edtMinutes.getText().toString());
            duration = Integer.toString(hour*6+min);
        } else {
            duration = "";
        }

        sleep.generatePostId();
        dream.setDreamChecklist(checklist);
        date.setDateToday(); // Setting today's date in our instance of date.
        postCaller = new ApiPostCaller();
        postCaller.saveSleepSeparately(new IResponseMessage() { // Saving the sleep input.
            @Override
            public void onSuccess(Object response) throws JSONException {
                JSONObject jsonObject = new JSONObject(response.toString()); // Getting a JSONObject to store the response from the server in a string.
                boolean status = jsonObject.getBoolean("status"); // Getting the result of the savePost method as a boolean (true/false).
                Log.e("", "");
                if (status) {
                    Intent intent = new Intent(context, ProfileActivity.class);
                    context.startActivity(intent);
                    Sleep.delSleep(); // Deleting the sleep instance, since the user doesn't want to add more info about it.

                } else {
                    loadingBg.setVisibility(View.GONE);
                    Toast.makeText(context,"Error", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(String errorMessage) { // In case of connection error.
                loadingBg.setVisibility(View.GONE);
                Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show();
            }
        }, 0);
    }

}
