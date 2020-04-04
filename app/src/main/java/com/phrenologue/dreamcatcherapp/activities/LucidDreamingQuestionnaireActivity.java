package com.phrenologue.dreamcatcherapp.activities;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Adapters.QuestionnaireAdapter;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.QuestionOneFragment;
import com.phrenologue.dreamcatcherapp.databinding.ActivityLucidDreamingQuestionnaireBinding;

public class LucidDreamingQuestionnaireActivity extends FragmentActivity {

    private ActivityLucidDreamingQuestionnaireBinding binding;
    QuestionnaireAdapter adapter;
    private ViewPager mPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityLucidDreamingQuestionnaireBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();
        setContentView(view);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
// Replace the contents of the container with the new fragment
        ft.replace(R.id.your_placeholder, new QuestionOneFragment());
// or ft.add(R.id.your_placeholder, new FooFragment());
// Complete the changes added above
        ft.commit();
        //adapter= new QuestionnaireAdapter(getSupportFragmentManager());
        //mPager = binding.questionsVp;
        //mPager.setAdapter(adapter);

    }
    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }
}
