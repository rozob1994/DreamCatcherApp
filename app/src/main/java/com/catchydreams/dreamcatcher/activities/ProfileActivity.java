package com.catchydreams.dreamcatcher.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.GravityCompat;
import androidx.core.view.MotionEventCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.catchydreams.dreamcatcher.R;
import com.catchydreams.dreamcatcher.activities.Login.LoginActivity;
import com.catchydreams.dreamcatcher.activities.viewInterfaces.IProfileView;
import com.catchydreams.dreamcatcher.constants.PersianFont;
import com.catchydreams.dreamcatcher.database.Database;
import com.catchydreams.dreamcatcher.database.user.UserEntity;
import com.catchydreams.dreamcatcher.databinding.ActivityProfileBinding;
import com.catchydreams.dreamcatcher.managersAndFilters.IntentManager;
import com.catchydreams.dreamcatcher.managersAndFilters.LocaleManager;
import com.catchydreams.dreamcatcher.managersAndFilters.RefreshChecker;
import com.catchydreams.dreamcatcher.managersAndFilters.SharedPreferencesManager;
import com.catchydreams.dreamcatcher.parameters.Addresses;
import com.catchydreams.dreamcatcher.parameters.Users;
import com.catchydreams.dreamcatcher.presenters.ProfilePresenter;
import com.catchydreams.dreamcatcher.ui.customDialog.dialogViews.ViewStatsDialog;
import com.catchydreams.dreamcatcher.ui.customFont.MoonTextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;

import java.util.Locale;

import maes.tech.intentanim.CustomIntent;

public class ProfileActivity extends AppCompatActivity implements IProfileView {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleManager.onAttach(newBase, "en"));
    }

    private BottomSheetBehavior behavior;
    private ActivityProfileBinding binding;
    private SharedPreferences sharedPreferences;
    private SharedPreferences sp2;
    boolean doubleBackToExitPressedOnce = false;
    private LottieAnimationView levelAnim;
    private MoonTextView levelTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Database db = Database.getInstance(this);
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


        ProfilePresenter presenter = new ProfilePresenter(this);

        boolean languageChanged = presenter.checkLanguageChanged(languagePrefs);

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        sp2 = getSharedPreferences("signUp", MODE_PRIVATE);
        Users user = Users.getInstance();
        user.setUid(sharedPreferences.getInt("uid", 0));
        user.setEmail(sharedPreferences.getString("username", "Nothing Retrieved"));
        user.setLevel(sharedPreferences.getInt("level", 0));
        binding.userTitle.setText(user.getEmail());

        levelAnim = binding.levelAnimation;
        levelTitle = binding.levelNumber;
        LinearLayout edt_profile = findViewById(R.id.lin_edt_profile);
        behavior = BottomSheetBehavior.from(edt_profile);
        AppCompatButton btnCancel = findViewById(R.id.btn_cancel_edt);
        SharedPreferences dreamChoosingOff = getSharedPreferences("dreamChoosing", Context.MODE_PRIVATE);
        dreamChoosingOff.edit().clear().apply();
        presenter.setLevel();
        presenter.setTypeFace(languagePrefs);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {

                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });

        binding.levelAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SleepDreamInputActivity.class);
                startActivity(intent);
            }
        });

        binding.levelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LevelsActivity.class);
                startActivity(intent);
                CustomIntent.customType(ProfileActivity.this, "fadein-to-fadeout");
            }
        });

        binding.btnDreams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DreamsPackagesActivity.class);
                startActivity(intent);
                CustomIntent.customType(ProfileActivity.this, "fadein-to-fadeout");
            }
        });

        binding.btnStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewStatsDialog dialog= new ViewStatsDialog();
                dialog.showDialog(ProfileActivity.this,getApplicationContext());
            }
        });

        binding.btnAddDream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferencesManager.clearDreamSleepQuest(getApplicationContext());
                Intent intent = new Intent(getApplicationContext(), SleepDreamInputActivity.class);
                startActivity(intent);
                CustomIntent.customType(ProfileActivity.this, "fadein-to-fadeout");
            }
        });

        binding.btnAnswerQuestionnaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferencesManager.clearDreamSleepQuest(getApplicationContext());
                IntentManager.goToQuestionnaireFromProfile(getApplicationContext(), languageChanged);
                CustomIntent.customType(ProfileActivity.this, "fadein-to-fadeout");
            }
        });

        binding.navBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.edit:

                        if (behavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                            behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                            binding.drawerLayout.closeDrawers();
                        } else {
                            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                        }

                        break;

                    case R.id.contact_us:
                        Intent intentMail = new Intent(Intent.ACTION_SEND, Uri.parse(Addresses.mail));
                        startActivity(Intent.createChooser(intentMail, "Mail Us."));
                        binding.drawerLayout.closeDrawers();
                        break;

                    case R.id.website:
                        Intent intentSite = new Intent(Intent.ACTION_VIEW, Uri.parse(Addresses.website));
                        startActivity(intentSite);
                        binding.drawerLayout.closeDrawers();
                        break;

                    case R.id.instagram:
                        Intent intentInsta = new Intent(Intent.ACTION_VIEW, Uri.parse(Addresses.instagram));
                        startActivity(intentInsta);
                        binding.drawerLayout.closeDrawers();
                        break;

                    case R.id.log_out:
                        UserEntity userEntity = new UserEntity(user.getUid(), user.getLevel(),
                                user.getEmail(), languagePrefs.getString("language", "en"));
                        db.userDao().deleteUser(userEntity);
                        Users.delUser();
                        sharedPreferences.edit().putBoolean("logged", false).apply();
                        sp2.edit().putBoolean("signedUp", false).apply();
                        sharedPreferences.edit().putString("username", "").apply();
                        sharedPreferences.edit().putInt("uid", 0).apply();
                        sharedPreferences.edit().putInt("level", 0).apply();
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                        binding.drawerLayout.closeDrawers();
                        finish();
                        break;

                    case R.id.language:
                        Intent intentLanguage = new Intent(getApplicationContext(), SelectLanguageActivity.class);
                        startActivity(intentLanguage);
                        binding.drawerLayout.closeDrawers();

                }
                return onOptionsItemSelected(item);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tabs, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory(Intent.CATEGORY_HOME);
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, R.string.press_back_again, Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Intent intent = new Intent(getApplicationContext(), DreamsPackagesActivity.class);
                startActivity(intent);
                return true;
            case MotionEvent.ACTION_POINTER_UP:
                Intent intent1 = new Intent(getApplicationContext(), SleepDreamInputActivity.class);
                startActivity(intent1);
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }

    @Override
    public void setLevelView(String folder, String json, int title) {
        levelAnim.setImageAssetsFolder(folder);
        levelAnim.setAnimation(json);
        levelTitle.setText(title);
    }

    @Override
    public void setTypeFace() {
        Typeface fontTitle = Typeface.createFromAsset(getAssets(), PersianFont.title);
        binding.userTitle.setTypeface(fontTitle);
        binding.levelNumber.setTypeface(fontTitle);
        binding.btnDreams.setTypeface(fontTitle);
        binding.btnStats.setTypeface(fontTitle);
        binding.levelNumber.setTextSize(PersianFont.small);
        binding.btnDreams.setTextSize(PersianFont.large);
        binding.btnStats.setTextSize(PersianFont.large);
    }

    @Override
    public void onLanguageChanged() {
        this.recreate();
    }

    @Override
    public void onRestart() {
        RefreshChecker.getInstance().setStarted(true);
        if (RefreshChecker.getInstance().isStarted()) {
            recreate();
            RefreshChecker.getInstance().setStarted(false);
        }
        super.onRestart();
    }
}
