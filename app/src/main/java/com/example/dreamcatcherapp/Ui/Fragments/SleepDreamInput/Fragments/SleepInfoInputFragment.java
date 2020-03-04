package com.example.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dreamcatcherapp.Activities.ProfileActivity;
import com.example.dreamcatcherapp.R;
import com.example.dreamcatcherapp.databinding.FragmentSleepInfoInputBinding;

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
        binding= FragmentSleepInfoInputBinding.inflate(inflater,container,false);
        View view= binding.getRoot();


        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[DAY BUTTON CODE]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        //---------------------------SWITCHING DAY BUTTON ON---------------------------//

        binding.linDayOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.linDayOn.getVisibility()==View.VISIBLE){
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
                if(binding.linDayOff.getVisibility()==View.VISIBLE){
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
                if (binding.linNightOn.getVisibility()==View.VISIBLE){
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
                if(binding.linNightOff.getVisibility()==View.VISIBLE){
                    binding.linNightOff.setVisibility(View.INVISIBLE);
                    binding.linNightOn.setVisibility(View.VISIBLE);
                } else {
                    binding.linNightOff.setVisibility(View.VISIBLE);
                    binding.linNightOn.setVisibility(View.INVISIBLE);
                    binding.linDayOff.setVisibility(View.VISIBLE);
                }
            }
        });

        binding.btnDidntHaveADream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
