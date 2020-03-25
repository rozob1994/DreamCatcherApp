package com.phrenologue.dreamcatcherapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.phrenologue.dreamcatcherapp.Ui.costumeFont.MoonTextView;
import com.phrenologue.dreamcatcherapp.databinding.ActivityDreamsPackagesBinding;
import com.phrenologue.dreamcatcherapp.presenters.DreamsPresenter;

public class DreamsPackagesActivity extends AppCompatActivity {
    private ActivityDreamsPackagesBinding binding;
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

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getApplicationContext(), SleepDreamInputActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() { }

}
