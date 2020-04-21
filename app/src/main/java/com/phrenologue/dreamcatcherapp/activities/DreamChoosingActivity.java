package com.phrenologue.dreamcatcherapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.phrenologue.dreamcatcherapp.activities.viewInterfaces.IDreamChoosingView;
import com.phrenologue.dreamcatcherapp.databinding.ActivityDreamChoosingBinding;
import com.phrenologue.dreamcatcherapp.managersAndFilters.SharedPreferencesManager;
import com.phrenologue.dreamcatcherapp.presenters.DreamsPresenter;

import maes.tech.intentanim.CustomIntent;

public class DreamChoosingActivity extends AppCompatActivity implements IDreamChoosingView {

    private ActivityDreamChoosingBinding binding;
    private DreamsPresenter presenter;
    private RecyclerView dreamsRecycler;

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

    @Override
    public void showProgressBar() {
        binding.loadingBg.setVisibility(View.VISIBLE);
        binding.loadingBg.setAlpha(0.5f);
    }

    @Override
    public void hideProgressBar() {
        binding.loadingBg.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onError() {
        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
    }
}
