package com.catchydreams.dreamcatcher.activities;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
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
import com.catchydreams.dreamcatcher.parameters.Users;
import com.catchydreams.dreamcatcher.presenters.DreamsPresenter;
import com.catchydreams.dreamcatcher.presenters.presenterInterfaces.IDreamPackagesView;

import java.util.Locale;

public class DreamsPackagesActivity extends AppCompatActivity implements IDreamPackagesView {
    private ActivityDreamsPackagesBinding binding;
    SharedPreferences kill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        kill = getSharedPreferences("kill", MODE_PRIVATE);
        if (kill.getBoolean("isKilled", false)){
            onRestoreInstanceState(savedInstanceState);
            kill.edit().putBoolean("isKilled", false).apply();
        }

        binding = ActivityDreamsPackagesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        if (RefreshChecker.getInstance().isStarted()) {
            recreate();
            RefreshChecker.getInstance().setStarted(false);
        }

        SharedPreferences languagePrefs = getSharedPreferences("languages", MODE_PRIVATE);
        String languageToLoad = languagePrefs.getString("language", "en");
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

    @Override
    public void onRestart() {

        super.onRestart();
    }

    @Override
    public void onDestroy() {
        kill = getSharedPreferences("kill", MODE_PRIVATE);
        kill.edit().putBoolean("isKilled", true).apply();
        super.onDestroy();

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.clear();
        savedInstanceState.putInt("uid", Users.getInstance().getUid());
        savedInstanceState.putInt("level", Users.getInstance().getLevel());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Users.getInstance().setUid(savedInstanceState.getInt("uid"));
        Users.getInstance().setLevel(savedInstanceState.getInt("level"));
    }

}
