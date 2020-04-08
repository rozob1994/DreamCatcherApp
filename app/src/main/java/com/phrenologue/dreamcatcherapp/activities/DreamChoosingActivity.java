package com.phrenologue.dreamcatcherapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.phrenologue.dreamcatcherapp.managersAndFilters.SharedPreferencesManager;
import com.phrenologue.dreamcatcherapp.ui.costumeFont.MoonTextView;
import com.phrenologue.dreamcatcherapp.databinding.ActivityDreamChoosingBinding;
import com.phrenologue.dreamcatcherapp.presenters.DreamsPresenter;

import maes.tech.intentanim.CustomIntent;

public class DreamChoosingActivity extends AppCompatActivity {

    private ActivityDreamChoosingBinding binding;
    private DreamsPresenter presenter;
    private RecyclerView dreamsRecycler;
    private MoonTextView dreamCount;
    private MoonTextView dreamHours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityDreamChoosingBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        dreamsRecycler = binding.dreamsRecycler;
        presenter = new DreamsPresenter(this);
        presenter.getDescriptionForChoice(getApplicationContext(),
                binding.loadingBg, dreamsRecycler);

        binding.btnAddDream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferencesManager.clearDreamSleepQuest(getApplicationContext());
                Intent intent = new Intent(getApplicationContext(), SleepDreamInputActivity.class);
                startActivity(intent);
                CustomIntent.customType(DreamChoosingActivity.this, "fadein-to-fadeout");
            }
        });
    }
    public void onBackPressed(){
        Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
        startActivity(intent);
    }
}
