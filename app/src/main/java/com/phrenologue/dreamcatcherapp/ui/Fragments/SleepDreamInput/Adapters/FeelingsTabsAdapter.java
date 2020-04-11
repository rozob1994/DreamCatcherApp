package com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.people.NegativeFeelingFragment;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.people.NeutralFeelingFragment;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.people.PositiveFeelingFragment;

public class FeelingsTabsAdapter extends FragmentStatePagerAdapter {

    int tabsCount;

    public FeelingsTabsAdapter(@NonNull FragmentManager fm, int tabsCount) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.tabsCount=tabsCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:

                PositiveFeelingFragment positiveFeelingFragment = new PositiveFeelingFragment();
                return positiveFeelingFragment;

            case 1:

                NeutralFeelingFragment neutralFeelingFragment = new NeutralFeelingFragment();
                return neutralFeelingFragment;

            case 2:

                NegativeFeelingFragment negativeFeelingFragment = new NegativeFeelingFragment();
                return negativeFeelingFragment;

            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return tabsCount;
    }
}
