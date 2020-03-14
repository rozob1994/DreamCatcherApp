package com.phrenologue.dreamcatcherapp.Activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.phrenologue.dreamcatcherapp.Ui.costumeFont.MoonTextView;
import com.phrenologue.dreamcatcherapp.databinding.ActivityDreamsPackagesBinding;
import com.phrenologue.dreamcatcherapp.presenters.DreamsPresenter;

import java.util.List;

public class DreamsPackagesActivity extends AppCompatActivity {
    private ActivityDreamsPackagesBinding binding;
    private List<String> titles;
    private List<String> contents;
    private DreamsPresenter presenter;
    private RecyclerView dreamsRecycler;
    private MoonTextView dreamCount;
    private MoonTextView dreamHours;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDreamsPackagesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        dreamsRecycler = binding.dreamsRecycler;
        dreamCount = binding.titleDreamsCount;
        dreamHours = binding.titleDreamHours;
        presenter = new DreamsPresenter(this);
        presenter.getDescription(dreamsRecycler,dreamCount);

    }


}
