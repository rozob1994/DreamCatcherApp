package com.phrenologue.dreamcatcherapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Adapters.EditDreamInfoInputAdapter;
import com.phrenologue.dreamcatcherapp.databinding.ActivityEditDreamInputBinding;

public class EditDreamInputActivity extends AppCompatActivity {
    private boolean doubleBackToExitPressedOnce = false;
    private ActivityEditDreamInputBinding binding;
    EditDreamInfoInputAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_dream_input);
        binding= ActivityEditDreamInputBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        adapter= new EditDreamInfoInputAdapter(getSupportFragmentManager());
        binding.sleepDreamInputVp.setAdapter(adapter);
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
