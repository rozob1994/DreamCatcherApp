package com.phrenologue.dreamcatcherapp.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.phrenologue.dreamcatcherapp.databinding.ActivityDreamsPackagesBinding;
import com.phrenologue.dreamcatcherapp.managersAndFilters.IntentManager;
import com.phrenologue.dreamcatcherapp.managersAndFilters.SharedPreferencesManager;
import com.phrenologue.dreamcatcherapp.presenters.DreamsPresenter;
import com.phrenologue.dreamcatcherapp.presenters.ProfilePresenter;
import com.phrenologue.dreamcatcherapp.ui.costumeFont.MoonTextView;

public class DreamsPackagesActivity extends AppCompatActivity {
    private ActivityDreamsPackagesBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDreamsPackagesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        LottieAnimationView levelAnim = binding.levelAnimation;
        RecyclerView dreamsRecycler = binding.dreamsRecycler;
        MoonTextView dreamCount = binding.titleDreamsCount;
        DreamsPresenter presenter = new DreamsPresenter(this);
        presenter.getDescription(getApplicationContext(),
                binding.loadingBg, dreamsRecycler, dreamCount);
        ProfilePresenter.setLevel(levelAnim, binding.titleDreamHours);
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentManager.goToProfile(getApplicationContext());
            }
        });

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferencesManager.clearDreamSleepQuest(getApplicationContext());
                IntentManager.goToSleepDreamInput(DreamsPackagesActivity.this);
            }
        });
    }


    @Override
    public void onBackPressed() {
        IntentManager.goToProfile(DreamsPackagesActivity.this);
    }

}
