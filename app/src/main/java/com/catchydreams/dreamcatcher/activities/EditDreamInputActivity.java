package com.catchydreams.dreamcatcher.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.catchydreams.dreamcatcher.R;
import com.catchydreams.dreamcatcher.databinding.ActivityEditDreamInputBinding;
import com.catchydreams.dreamcatcher.parameters.postParameters.majorParameters.Dream;
import com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Adapters.EditDreamInfoInputAdapter;

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
        Dream dream = Dream.getInstance();
        int postId = dream.getPostId();
        Intent intent = new Intent(getApplicationContext(), ExpandedDreamActivity.class);
        intent.putExtra("postId", postId);
        startActivity(intent);
        finish();

}}
