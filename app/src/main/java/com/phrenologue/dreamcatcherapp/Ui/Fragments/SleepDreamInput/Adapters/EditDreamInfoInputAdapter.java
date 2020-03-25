package com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments.DreamInfoInputOneFragment;
import com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments.DreamInfoInputTwoFragment;

import java.util.ArrayList;
import java.util.List;

public class EditDreamInfoInputAdapter extends FragmentStatePagerAdapter {

    DreamInfoInputOneFragment fragment;
    List<Fragment> fragmentList;
    public EditDreamInfoInputAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        fragmentList= new ArrayList<>();
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
