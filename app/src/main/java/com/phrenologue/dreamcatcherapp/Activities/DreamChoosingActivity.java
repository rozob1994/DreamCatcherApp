package com.phrenologue.dreamcatcherapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.phrenologue.dreamcatcherapp.Ui.costumeFont.MoonTextView;
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
        presenter.getDescription(getApplicationContext(),
                binding.loadingBg, dreamsRecycler, dreamCount);

        binding.btnAddDream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SleepDreamInputActivity.class);
                startActivity(intent);
                CustomIntent.customType(DreamChoosingActivity.this, "fadein-to-fadeout");
            }
        });
    }
}
