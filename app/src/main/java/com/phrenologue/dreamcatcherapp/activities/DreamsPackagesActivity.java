package com.phrenologue.dreamcatcherapp.activities;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.phrenologue.dreamcatcherapp.constants.PersianFont;
import com.phrenologue.dreamcatcherapp.databinding.ActivityDreamsPackagesBinding;
import com.phrenologue.dreamcatcherapp.managersAndFilters.IntentManager;
import com.phrenologue.dreamcatcherapp.managersAndFilters.SharedPreferencesManager;
import com.phrenologue.dreamcatcherapp.presenters.DreamsPresenter;
import com.phrenologue.dreamcatcherapp.presenters.presenterInterfaces.IDreamPackagesView;
import com.phrenologue.dreamcatcherapp.ui.costumeFont.MoonTextView;

import java.util.Locale;

public class DreamsPackagesActivity extends AppCompatActivity implements IDreamPackagesView {
    private ActivityDreamsPackagesBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDreamsPackagesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        SharedPreferences languagePrefs = getSharedPreferences("languages", MODE_PRIVATE);
        String languageToLoad = languagePrefs.getString("language", "en");
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        RecyclerView dreamsRecycler = binding.dreamsRecycler;
        MoonTextView dreamCount = binding.titleDreamsCount;
        DreamsPresenter presenter = new DreamsPresenter(this);
        boolean languageChanged = presenter.onLanguageChanged(languagePrefs);
        presenter.getDescription(getApplicationContext(),
                binding.loadingBg, dreamsRecycler, dreamCount);
        presenter.setLevel();
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentManager.goToProfile(DreamsPackagesActivity.this);
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

    @Override
    public void setLevelView(String folder, String json) {
        binding.levelAnimation.setImageAssetsFolder(folder);
        binding.levelAnimation.setAnimation(json);

    }

    @Override
    public void onLanguageChanged() {
        this.recreate();
    }

    @Override
    public void setPersianTypeFace() {
        Typeface title = Typeface.createFromAsset(getAssets(), PersianFont.title);
        binding.dreamsHeader.setTypeface(title);
    }
}
