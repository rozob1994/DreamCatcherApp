package com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments.QuestionEighteenFragment;
import com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments.QuestionElevenFragment;
import com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments.QuestionFifteenFragment;
import com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments.QuestionFiveFragment;
import com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments.QuestionFourFragment;
import com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments.QuestionFourteenFragment;
import com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments.QuestionNineFragment;
import com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments.QuestionNineteenFragment;
import com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments.QuestionOneFragment;
import com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments.QuestionSevenFragment;
import com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments.QuestionSeventeenFragment;
import com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments.QuestionSixFragment;
import com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments.QuestionSixteenFragment;
import com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments.QuestionTenFragment;
import com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments.QuestionThirteenFragment;
import com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments.QuestionThreeFragment;
import com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments.QuestionTwelveFragment;
import com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments.QuestionTwoFragment;

import java.util.ArrayList;
import java.util.List;

public class QuestionnaireAdapter extends FragmentStatePagerAdapter {


    List<Fragment> fragmentList;
    public QuestionnaireAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        fragmentList= new ArrayList<>();
        fragmentList.add(new QuestionOneFragment());
        fragmentList.add(new QuestionTwoFragment());
        fragmentList.add(new QuestionThreeFragment());
        fragmentList.add(new QuestionFourFragment());
        fragmentList.add(new QuestionFiveFragment());
        fragmentList.add(new QuestionSixFragment());
        fragmentList.add(new QuestionSevenFragment());
        fragmentList.add(new QuestionEighteenFragment());
        fragmentList.add(new QuestionNineFragment());
        fragmentList.add(new QuestionTenFragment());
        fragmentList.add(new QuestionElevenFragment());
        fragmentList.add(new QuestionTwelveFragment());
        fragmentList.add(new QuestionThirteenFragment());
        fragmentList.add(new QuestionFourteenFragment());
        fragmentList.add(new QuestionFifteenFragment());
        fragmentList.add(new QuestionSixteenFragment());
        fragmentList.add(new QuestionSeventeenFragment());
        fragmentList.add(new QuestionEighteenFragment());
        fragmentList.add(new QuestionNineteenFragment());

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}