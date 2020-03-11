package com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.phrenologue.dreamcatcherapp.Activities.ProfileActivity;
import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.FragmentSleepInfoInputBinding;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Sleep;
import com.phrenologue.dreamcatcherapp.presenters.SleepInputPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SleepInfoInputFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {


    private FragmentSleepInfoInputBinding binding;
    private SeekBar physicalActivity;
    private SeekBar foodConsumption;
    private SleepInputPresenter presenter;
    private LinearLayout dayOn, dayOff, nightOn, nightOff;


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

        physicalActivity = binding.sliderPhysical;
        foodConsumption = binding.sliderFood;
        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[DAY BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //---------------------------SWITCHING DAY BUTTON ON---------------------------//

        dayOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setDayBtnOn(dayOn, dayOff, nightOn, nightOff);
            }
        });

        //---------------------------SWITCHING DAY BUTTON OFF---------------------------//

        dayOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setDayBtnOff(dayOn, dayOff, nightOff);
            }
        });

        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[Night BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //---------------------------SWITCHING NIGHT BUTTON ON---------------------------//

        nightOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setNightBtnOn(dayOn, dayOff, nightOn, nightOff);
            }
        });

        //---------------------------SWITCHING NIGHT BUTTON OFF---------------------------//

        nightOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setNightBtnOff(dayOn, dayOff, nightOn, nightOff);
            }
        });
        //---------------------------PHYSICAL ACTIVITY SEEK BAR---------------------------//

        physicalActivity.setOnSeekBarChangeListener(this);
        presenter.setPhysicalActivitySeekBar(physicalActivity);

        //---------------------------FOOD CONSUMPTION SEEK BAR---------------------------//

        foodConsumption.setOnSeekBarChangeListener(this);
        presenter.setFoodConsumptionSeekBar(foodConsumption);

        //---------------------------BUTTONS----------------------------------------------//
        binding.btnToDreamInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean sleepSaved = presenter.saveSleepAndContinue(binding.edtHours, binding.edtMinutes);
                if (sleepSaved) {
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction transaction = fm.beginTransaction();
                    DreamInfoInputOneFragment fragment = new DreamInfoInputOneFragment();
                    transaction.replace(R.id.dream_adding_frame, fragment);
                    transaction.commit();
                    container.removeAllViews();
                } else {
                    Toast.makeText(getContext(), "Error",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        binding.btnDidntHaveADream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean sleepSaved = presenter.saveSleepAndGo(binding.edtHours, binding.edtMinutes);
                if (sleepSaved){

                    Intent intent = new Intent(getActivity(), ProfileActivity.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(getContext(), "Error",
                            Toast.LENGTH_LONG).show();
                }

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
