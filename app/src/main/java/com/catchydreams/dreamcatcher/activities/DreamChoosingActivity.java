package com.catchydreams.dreamcatcher.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.catchydreams.dreamcatcher.activities.Adapter.DreamsPackagesActivityAdapter;
import com.catchydreams.dreamcatcher.activities.viewInterfaces.IDreamChoosingView;
import com.catchydreams.dreamcatcher.constants.PersianFont;
import com.catchydreams.dreamcatcher.databinding.ActivityDreamChoosingBinding;
import com.catchydreams.dreamcatcher.managersAndFilters.SharedPreferencesManager;
import com.catchydreams.dreamcatcher.parameters.postParameters.DreamChoosingItem;
import com.catchydreams.dreamcatcher.presenters.DreamChoosingPresenter;

import maes.tech.intentanim.CustomIntent;

public class DreamChoosingActivity extends AppCompatActivity implements IDreamChoosingView {

    private ActivityDreamChoosingBinding binding;
    private RecyclerView dreamsRecycler;
    private SharedPreferences languagePrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityDreamChoosingBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        languagePrefs = getSharedPreferences("languages", MODE_PRIVATE);

        dreamsRecycler = binding.dreamsRecycler;
        DreamChoosingPresenter presenter = new DreamChoosingPresenter(this);
        presenter.getDescription();
        presenter.setLanguage(languagePrefs);
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
        DreamChoosingItem item = DreamChoosingItem.getInstance();
        DreamsPackagesActivityAdapter adapter = new DreamsPackagesActivityAdapter(getApplicationContext(),
                item.getPostIds(), item.getSleepTimes(), item.getExperiences(), item.getDays(),
                item.getMonths(), item.getYears(), item.getTitles(), item.getContents());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        dreamsRecycler.setLayoutManager(layoutManager);
        dreamsRecycler.setAdapter(adapter);
    }

    @Override
    public void onError() {
        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
    }

    @Override
    public void setPersianTypeFace() {
        Typeface title = Typeface.createFromAsset(getAssets(), PersianFont.title);
        Typeface text = Typeface.createFromAsset(getAssets(), PersianFont.subTitle);
        binding.dreamsTitle.setTypeface(title);
        binding.hintChooseDream.setTypeface(text);
    }
}
