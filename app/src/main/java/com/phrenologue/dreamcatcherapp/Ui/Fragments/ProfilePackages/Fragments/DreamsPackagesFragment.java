package com.phrenologue.dreamcatcherapp.Ui.Fragments.ProfilePackages.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.phrenologue.dreamcatcherapp.Ui.Fragments.ProfilePackages.Adapter.DreamsPackagesFragmentAdapter;
import com.phrenologue.dreamcatcherapp.databinding.FragmentDreamsBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class DreamsPackagesFragment extends Fragment {

    private FragmentDreamsBinding binding;

    public DreamsPackagesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentDreamsBinding.inflate(inflater, container, false);
        View view= binding.getRoot();

        DreamsPackagesFragmentAdapter adapter= new DreamsPackagesFragmentAdapter(getContext(), null);
        binding.dreamsRecycler.setAdapter(adapter);


        return view;
    }

}
