package com.example.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments.DreamInfoInputOneFragment;
import com.example.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments.DreamInfoInputTwoFragment;
import com.example.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments.SleepInfoInputFragment;

import java.util.ArrayList;
import java.util.List;

public class SleepDreamInputAdapter extends FragmentStatePagerAdapter {


    List<Fragment> fragmentList;
    public SleepDreamInputAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        fragmentList= new ArrayList<>();
        fragmentList.add(new SleepInfoInputFragment());
        fragmentList.add(new DreamInfoInputOneFragment());
        fragmentList.add(new DreamInfoInputTwoFragment());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }


    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
