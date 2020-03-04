package com.phrenologue.dreamcatcherapp.Ui.Fragments.ProfilePackages.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.phrenologue.dreamcatcherapp.databinding.FragmentStatsBinding;
import com.phrenologue.dreamcatcherapp.Ui.Fragments.ProfilePackages.Adapter.StatsPackagesFragmentAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class StatsPackagesFragment extends Fragment {

    public StatsPackagesFragment() {

    }
    private FragmentStatsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentStatsBinding.inflate(inflater, container, false);
        View view= binding.getRoot();

        StatsPackagesFragmentAdapter adapter= new StatsPackagesFragmentAdapter(getContext(), null);
        binding.statsRecycler.setAdapter(adapter);


        return view;
    }

}
