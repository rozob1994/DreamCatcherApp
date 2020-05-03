package com.catchydreams.dreamcatcher.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.catchydreams.dreamcatcher.R;
import com.catchydreams.dreamcatcher.constants.PersianFont;
import com.catchydreams.dreamcatcher.databinding.ActivityDreamsPackagesBinding;
import com.catchydreams.dreamcatcher.managersAndFilters.IntentManager;
import com.catchydreams.dreamcatcher.managersAndFilters.RefreshChecker;
import com.catchydreams.dreamcatcher.managersAndFilters.SharedPreferencesManager;
import com.catchydreams.dreamcatcher.presenters.DreamsPresenter;
import com.catchydreams.dreamcatcher.presenters.presenterInterfaces.IDreamPackagesView;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;

import java.util.Locale;

public class DreamsPackagesActivity extends AppCompatActivity implements IDreamPackagesView {
    private ActivityDreamsPackagesBinding binding;
    private Typeface tutorialFont, tutorialTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityDreamsPackagesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        SharedPreferences languagePrefs = getSharedPreferences("languages", MODE_PRIVATE);
        String languageToLoad = languagePrefs.getString("language", "en");
        if(savedInstanceState!=null){
            boolean destroyed = savedInstanceState.getBoolean("destroyed");
            if (destroyed) {
                binding.dreamsRecycler.setVisibility(View.GONE);
                binding.reloadDreams.setVisibility(View.VISIBLE);
                binding.btnReload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        }
        Intent intent = getIntent();
        boolean firstLogin = intent.getBooleanExtra("firstLogin", false);
        Log.e("","");
        if (firstLogin) {
            if (languageToLoad.equals("fa")){
                tutorialFont = Typeface.createFromAsset(getAssets(), PersianFont.subTitle);
                tutorialTitle = Typeface.createFromAsset(getAssets(), PersianFont.title);
            } else {
                tutorialFont = Typeface.createFromAsset(getAssets(), "fonts/sofiapro-light.otf");
                tutorialTitle = Typeface.createFromAsset(getAssets(), "fonts/sofiapro-light.otf");
            }
            new TapTargetSequence(this)
                    .targets(
                            TapTarget.forView(findViewById(R.id.level_animation), getString(R.string.avatar), getString(R.string.dreams_packages_tutorial))
                                    .targetRadius(140)
                                    .dimColor(R.color.inactive)
                                    .targetCircleColor(R.color.invisible)
                                    .textColor(android.R.color.black)
                                    .outerCircleColor(R.color.white)
                                    .transparentTarget(true)
                                    .drawShadow(true)
                                    .textTypeface(tutorialFont)
                                    .titleTypeface(tutorialTitle));
        }
        if (RefreshChecker.getInstance().isStarted()) {
            recreate();
            RefreshChecker.getInstance().setStarted(false);
        }


        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        RecyclerView dreamsRecycler = binding.dreamsRecycler;
        DreamsPresenter presenter = new DreamsPresenter(this);
        boolean languageChanged = presenter.onLanguageChanged(languagePrefs);
        presenter.getDescription(getApplicationContext(), dreamsRecycler);
        presenter.setLevel();
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentManager.goToProfile(DreamsPackagesActivity.this);
            }
        });

        binding.levelAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferencesManager.clearDreamSleepQuest(getApplicationContext());
                IntentManager.goToSleepDreamInput(DreamsPackagesActivity.this);
            }
        });
    }

    @Override
    public void onDestroy(){
        getSharedPreferences("destruction", Context.MODE_PRIVATE).edit().putBoolean("destroyed",true).apply();
        super.onDestroy();
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.clear();
        savedInstanceState.putBoolean("destroyed", true);
        super.onSaveInstanceState(savedInstanceState);
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
        Typeface subTitle = Typeface.createFromAsset(getAssets(), PersianFont.subTitle);
        binding.dreamsHeader.setTypeface(title);
        binding.titleDreamsCount.setTypeface(subTitle);
    }

    @Override
    public void setEngDreamCount(int count) {
        String dreamCount = getString(R.string.set_dream_count) + count + "";
        binding.titleDreamsCount.setText(dreamCount);
    }

    @Override
    public void setPerDreamCount(String count) {
        String dreamCount = getString(R.string.set_dream_count) + count;
        binding.titleDreamsCount.setText(dreamCount);
    }

}
