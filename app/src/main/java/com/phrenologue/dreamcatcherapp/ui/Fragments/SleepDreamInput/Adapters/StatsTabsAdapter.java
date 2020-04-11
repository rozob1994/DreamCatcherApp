package com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.people.PeopleFragment;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.StatsFragment;

public class StatsTabsAdapter extends FragmentStatePagerAdapter {

    int tabsCount;

    public StatsTabsAdapter(@NonNull FragmentManager fm, int tabsCount) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.tabsCount= tabsCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:

                StatsFragment statsFragment = new StatsFragment();
                return statsFragment;
            case 1:

                PeopleFragment peopleFragment = new PeopleFragment();
                return peopleFragment;

            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return tabsCount;
    }
}
