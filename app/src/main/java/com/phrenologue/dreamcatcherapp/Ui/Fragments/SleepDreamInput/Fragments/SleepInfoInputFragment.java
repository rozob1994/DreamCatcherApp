package com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.phrenologue.dreamcatcherapp.Activities.ProfileActivity;
import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.FragmentSleepInfoInputBinding;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.dateParameters.parameters.Date;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamChecklist;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Sleep;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class SleepInfoInputFragment extends Fragment {


    private FragmentSleepInfoInputBinding binding;

    public SleepInfoInputFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSleepInfoInputBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        Sleep sleep = Sleep.getInstance(); // Getting an instance of Sleep.class which is a singleton.
        Dream dream = Dream.getInstance();// Getting an instance of Dream.class to store PostId.
        DreamChecklist dreamChecklist = DreamChecklist.getInstance();
        Date date = Date.getInstance(); // Getting an instance of Date.class to set today's date.
        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[DAY BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //---------------------------SWITCHING DAY BUTTON ON---------------------------//

        binding.linDayOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sleep.setTime(1); // Setting sleep's time to day.
                if (binding.linDayOn.getVisibility() == View.VISIBLE) {
                    binding.linDayOn.setVisibility(View.INVISIBLE);
                    binding.linDayOff.setVisibility(View.VISIBLE);
                } else {
                    binding.linDayOn.setVisibility(View.VISIBLE);
                    binding.linDayOff.setVisibility(View.INVISIBLE);
                    binding.linNightOn.setVisibility(View.INVISIBLE);
                    binding.linNightOff.setVisibility(View.VISIBLE);
                }
            }
        });

        //---------------------------SWITCHING DAY BUTTON OFF---------------------------//

        binding.linDayOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sleep.setTime(0); // Deleting sleep's time.
                if (binding.linDayOff.getVisibility() == View.VISIBLE) {
                    binding.linDayOff.setVisibility(View.INVISIBLE);
                    binding.linDayOn.setVisibility(View.VISIBLE);
                } else {
                    binding.linDayOff.setVisibility(View.VISIBLE);
                    binding.linDayOn.setVisibility(View.INVISIBLE);
                    binding.linNightOff.setVisibility(View.VISIBLE);
                }
            }
        });

        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[Night BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //---------------------------SWITCHING NIGHT BUTTON ON---------------------------//

        binding.linNightOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sleep.setTime(2); // Setting sleep's time to night.
                if (binding.linNightOn.getVisibility() == View.VISIBLE) {
                    binding.linNightOn.setVisibility(View.INVISIBLE);
                    binding.linNightOff.setVisibility(View.VISIBLE);
                } else {
                    binding.linNightOn.setVisibility(View.VISIBLE);
                    binding.linNightOff.setVisibility(View.INVISIBLE);
                    binding.linDayOn.setVisibility(View.INVISIBLE);
                    binding.linDayOff.setVisibility(View.VISIBLE);
                }
            }
        });

        //---------------------------SWITCHING NIGHT BUTTON OFF---------------------------//

        binding.linNightOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sleep.setTime(0); // Deleting sleep's time.
                if (binding.linNightOff.getVisibility() == View.VISIBLE) {
                    binding.linNightOff.setVisibility(View.INVISIBLE);
                    binding.linNightOn.setVisibility(View.VISIBLE);
                } else {
                    binding.linNightOff.setVisibility(View.VISIBLE);
                    binding.linNightOn.setVisibility(View.INVISIBLE);
                    binding.linDayOff.setVisibility(View.VISIBLE);
                }
            }
        });

        binding.btnToDreamInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String duration = binding.edtHours.getText().toString() +" Hours "+
                        binding.edtMinutes.getText().toString() + " Min. "; // Storing sleep duration as a single string, before moving forward to dream input.
                sleep.setDuration(duration); // Storing sleep duration in the instance of Sleep.class, before moving forward to dream input.


            }
        });

        binding.btnDidntHaveADream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String duration = binding.edtHours.getText().toString() +
                        binding.edtMinutes.getText().toString(); // Storing sleep duration as a single string.
                sleep.setDuration(duration); // Storing sleep duration in the instance of Sleep.class.
                dreamChecklist.setRemembered(false);
                dream.setDreamChecklist(dreamChecklist);
                date.setDateToday(); // Setting today's date in our instance of date.
                ApiPostCaller apiCaller = new ApiPostCaller(); // Creating an instance of apiCaller to save the sleep.
                apiCaller.saveSleepSeparately(new IResponseMessage() { // Saving the sleep input.
                    @Override
                    public void onSuccess(Object response) throws JSONException {
                        JSONObject jsonObject = new JSONObject(response.toString()); // Getting a JSONObject to store the response from the server in a string.
                        boolean status = jsonObject.getBoolean("status"); // Getting the result of the savePost method as a boolean (true/false).
                        Log.e("","");
                        if (status) {
                            Toast.makeText(getContext(),getString(R.string.sleepSaved),
                                    Toast.LENGTH_LONG).show();
                            Sleep.delSleep(); // Deleting the sleep instance, since the user doesn't want to add more info about it.
                            Intent intent = new Intent(getActivity(), ProfileActivity.class);
                            startActivity(intent);
                        } else {
                            String msg = jsonObject.getString("message");
                            Toast.makeText(getContext(),msg,Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(String errorMessage) { // In case of connection error.
                        Log.e("","");
                        Toast.makeText(getContext(),"Error saving Sleep! Please try again later",
                                Toast.LENGTH_LONG).show();

                    }
                });


            }
        });

        return view;
    }
}
