package com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.people;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;
import com.phrenologue.dreamcatcherapp.databinding.FragmentPeopleBinding;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Adapters.FeelingsTabsAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PeopleFragment extends Fragment {

    private FragmentPeopleBinding binding;

    public PeopleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentPeopleBinding.inflate(inflater,container,false);
        View view= binding.getRoot();


        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Positive"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Neutral"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Negative"));
        binding.tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        FeelingsTabsAdapter feelingsTabsAdapter= new FeelingsTabsAdapter(getChildFragmentManager(), binding.tabLayout.getTabCount());
        binding.viewPager.setAdapter(feelingsTabsAdapter);

        binding.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout));
        binding.tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }
}
