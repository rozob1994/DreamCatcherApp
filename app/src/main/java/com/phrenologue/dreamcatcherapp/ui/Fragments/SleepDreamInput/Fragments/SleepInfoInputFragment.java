package com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.activities.ProfileActivity;
import com.phrenologue.dreamcatcherapp.databinding.FragmentSleepInfoInputBinding;
import com.phrenologue.dreamcatcherapp.managersAndFilters.SharedPreferencesManager;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamChecklist;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Sleep;
import com.phrenologue.dreamcatcherapp.presenters.SleepInputPresenter;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class SleepInfoInputFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {


    private FragmentSleepInfoInputBinding binding;
    private SeekBar physicalActivity;
    private SeekBar foodConsumption;
    private SleepInputPresenter presenter;
    private LinearLayout dayOn, dayOff, nightOn, nightOff;
    private RelativeLayout loadingBg;
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor sleepSp;
    private AppCompatEditText hours, minutes;

    public SleepInfoInputFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSleepInfoInputBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        presenter = new SleepInputPresenter();
        dayOn = binding.linDayOn;
        dayOff = binding.linDayOff;
        nightOff = binding.linNightOff;
        nightOn = binding.linNightOn;
        loadingBg = binding.loadingBg;
        sharedPref = this.getActivity().getSharedPreferences("sleep", Context.MODE_PRIVATE);
        sleepSp = sharedPref.edit();

        physicalActivity = binding.sliderPhysical;
        foodConsumption = binding.sliderFood;




        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[DAY BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //---------------------------SWITCHING DAY BUTTON ON---------------------------//
        if (sharedPref.getBoolean("day", false)) {
            presenter.setDayBtnOn(sleepSp, dayOn, dayOff, nightOn, nightOff);
        } else if (sharedPref.getBoolean("night", false)) {
            presenter.setNightBtnOn(sleepSp, dayOn, dayOff, nightOn, nightOff);
        }
        dayOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setDayBtnOn(sleepSp, dayOn, dayOff, nightOn, nightOff);
            }
        });

        //---------------------------SWITCHING DAY BUTTON OFF---------------------------//

        dayOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setDayBtnOff(sleepSp, dayOn, dayOff, nightOff);
            }
        });

        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[Night BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //---------------------------SWITCHING NIGHT BUTTON ON---------------------------//

        nightOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setNightBtnOn(sleepSp, dayOn, dayOff, nightOn, nightOff);
            }
        });

        //---------------------------SWITCHING NIGHT BUTTON OFF---------------------------//

        nightOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setNightBtnOff(sleepSp, dayOn, dayOff, nightOn, nightOff);
            }
        });
        //---------------------------PHYSICAL ACTIVITY SEEK BAR---------------------------//
        if (sharedPref.getBoolean("hasPhysicalActivity", false)) {
            physicalActivity.setProgress(0);
            physicalActivity.setMax(3);
            physicalActivity.setProgress(sharedPref.getInt("physicalActivity", 2));
            }

        physicalActivity.setOnSeekBarChangeListener(this);
        presenter.setPhysicalActivitySeekBar(sleepSp, physicalActivity);

        //---------------------------FOOD CONSUMPTION SEEK BAR---------------------------//
        if (sharedPref.getBoolean("hasFoodConsumption", false)) {
            foodConsumption.setProgress(0);
            foodConsumption.setMax(2);
            foodConsumption.setProgress(sharedPref.getInt("foodConsumption", 2));
        }
        foodConsumption.setOnSeekBarChangeListener(this);
        presenter.setFoodConsumptionSeekBar(sleepSp, foodConsumption);

        //---------------------------BUTTONS----------------------------------------------//
        binding.btnToDreamInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingBg.setVisibility(View.VISIBLE);
                loadingBg.setAlpha(0.5f);
                Sleep sleep = Sleep.getInstance();
                Dream dream = Dream.getInstance();
                DreamChecklist checklist = DreamChecklist.getInstance();



                dream.setDreamChecklist(checklist);
                dream.setPostId(sleep.generatePostId());
                ApiPostCaller postCaller = new ApiPostCaller();
                postCaller.saveSleepSeparately(new IResponseMessage() {
                    @Override
                    public void onSuccess(Object response) throws JSONException {
                        JSONObject jsonObject = new JSONObject(response.toString());
                        boolean status = jsonObject.getBoolean("status");
                        if (status) {
                            FragmentManager fm = getFragmentManager();
                            FragmentTransaction transaction = fm.beginTransaction();
                            DreamInfoInputOneFragment fragment = new DreamInfoInputOneFragment();
                            transaction.replace(R.id.dream_adding_frame, fragment);
                            transaction.commit();
                            container.removeAllViews();
                        } else {
                            loadingBg.setVisibility(View.GONE);
                            Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(String errorMessage) {
                        loadingBg.setVisibility(View.GONE);
                        Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                },1);
            }
        });

        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferencesManager.clearDreamSleepQuest(getContext());
                Intent intent = new Intent(getContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar == physicalActivity) {
            Sleep.getInstance().setPhysicalActivity(progress);
        } else if (seekBar == foodConsumption) {
            Sleep.getInstance().setFoodConsumption(progress);
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
