package com.phrenologue.dreamcatcherapp.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.activities.Login.LoginActivity;
import com.phrenologue.dreamcatcherapp.databinding.ActivityProfileBinding;
import com.phrenologue.dreamcatcherapp.managersAndFilters.SharedPreferencesManager;
import com.phrenologue.dreamcatcherapp.parameters.Addresses;
import com.phrenologue.dreamcatcherapp.parameters.Users;
import com.phrenologue.dreamcatcherapp.presenters.ProfilePresenter;
import com.phrenologue.dreamcatcherapp.ui.costumeFont.MoonTextView;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import maes.tech.intentanim.CustomIntent;

public class ProfileActivity extends AppCompatActivity {

    private BottomSheetBehavior behavior;
    private LinearLayout edt_profile;
    private ActivityProfileBinding binding;
    private SharedPreferences sharedPreferences;
    private SharedPreferences sp2;
    boolean doubleBackToExitPressedOnce = false;
    private ApiPostCaller postCaller;
    private ProfilePresenter presenter;
    private LottieAnimationView levelAnim;
    private MoonTextView levelTitle;
    private AppCompatButton btnCancel;
    private SharedPreferences dreamChoosingOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        sp2 = getSharedPreferences("signUp", MODE_PRIVATE);
        Users user = Users.getInstance();
        user.setUid(sharedPreferences.getInt("uid", 0));
        user.setEmail(sharedPreferences.getString("username", "Nothing Retrieved"));
        user.setLevel(sharedPreferences.getInt("level",0));
        binding.userTitle.setText(user.getEmail());
        postCaller = new ApiPostCaller();
        presenter = new ProfilePresenter();
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        binding.toolbar.setTitle("");
        binding.toolbar.setSubtitle("");
        levelAnim = binding.levelAnimation;
        levelTitle = binding.levelNumber;
        edt_profile=findViewById(R.id.lin_edt_profile);
        behavior= BottomSheetBehavior.from(edt_profile);
        btnCancel= findViewById(R.id.btn_cancel_edt);
        dreamChoosingOff = getSharedPreferences("dreamChoosing", Context.MODE_PRIVATE);
        dreamChoosingOff.edit().clear().apply();

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (behavior.getState()==BottomSheetBehavior.STATE_EXPANDED){

                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });

        //=========================== Determine User's Level =================================
        ProfilePresenter.setLevel(levelAnim, levelTitle);

        Log.e("","");


        binding.levelAnimation.setOnClickListener(new View.OnClickListener() {
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
                Intent intent = new Intent(getApplicationContext(), StatsActivity.class);
                startActivity(intent);
                CustomIntent.customType(ProfileActivity.this, "fadein-to-fadeout");
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
                Intent intent = new Intent(getApplicationContext(), LucidDreamingQuestionnaireActivity.class);
                startActivity(intent);
                CustomIntent.customType(ProfileActivity.this, "fadein-to-fadeout");

            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tabs, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.edit:

                if (behavior.getState()!=BottomSheetBehavior.STATE_EXPANDED){

                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                } else {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }

                break;

            case R.id.contact_us:
                Intent intentMail = new Intent(Intent.ACTION_SEND, Uri.parse(Addresses.mail));
                startActivity(Intent.createChooser(intentMail, "Mail Us."));
                break;

            case R.id.website:
                Intent intentSite = new Intent(Intent.ACTION_VIEW, Uri.parse(Addresses.website));
                startActivity(intentSite);
                break;

            case R.id.instagram:
                Intent intentInsta = new Intent(Intent.ACTION_VIEW, Uri.parse(Addresses.instagram));
                startActivity(intentInsta);
                break;

            case R.id.log_out:
                Users.delUser();
                sharedPreferences.edit().putBoolean("logged", false).apply();
                sp2.edit().putBoolean("signedUp", false).apply();
                sharedPreferences.edit().putString("username", "").apply();
                sharedPreferences.edit().putInt("uid", 0).apply();
                sharedPreferences.edit().putInt("level", 0).apply();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory( Intent.CATEGORY_HOME );
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}
