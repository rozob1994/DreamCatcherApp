package com.phrenologue.dreamcatcherapp.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.Activities.Adapter.FeedsPackagesAdapter;
import com.phrenologue.dreamcatcherapp.Activities.Login.LoginActivity;
import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.ActivityProfileBinding;
import com.phrenologue.dreamcatcherapp.parameters.Addresses;
import com.phrenologue.dreamcatcherapp.parameters.Users;

import maes.tech.intentanim.CustomIntent;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;
    private SharedPreferences sharedPreferences;
    private SharedPreferences sp2;
    boolean doubleBackToExitPressedOnce = false;
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
        binding.userTitle.setText(Users.getInstance().getEmail());
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        binding.toolbar.setTitle("");
        binding.toolbar.setSubtitle("");

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

                Intent intent= new Intent(getApplicationContext(), SleepDreamInputActivity.class);
                startActivity(intent);
                CustomIntent.customType(ProfileActivity.this,"fadein-to-fadeout");
            }
        });

        FeedsPackagesAdapter adapter = new FeedsPackagesAdapter(getApplicationContext(), null);
        binding.recyclerFeed.setAdapter(adapter);

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

                break;

            case R.id.contact_us:
                Intent intentMail = new Intent(Intent.ACTION_SEND, Uri.parse(Addresses.mail));
                startActivity(Intent.createChooser(intentMail, "Mail Us."));
                break;

            case R.id.website:

                break;

            case R.id.instagram:

                break;

            case R.id.log_out:
                Users.delUser();
                sharedPreferences.edit().putBoolean("logged", false).apply();
                sp2.edit().putBoolean("signedUp", false).apply();
                sharedPreferences.edit().putString("username", "").apply();
                sharedPreferences.edit().putInt("uid", 0).apply();
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
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
