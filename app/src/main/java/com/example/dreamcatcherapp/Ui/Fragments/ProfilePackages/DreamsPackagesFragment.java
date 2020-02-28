package com.example.dreamcatcherapp.Ui.Fragments.ProfilePackages;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dreamcatcherapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DreamsPackagesFragment extends Fragment {


    public DreamsPackagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dreams, container, false);
    }

}
