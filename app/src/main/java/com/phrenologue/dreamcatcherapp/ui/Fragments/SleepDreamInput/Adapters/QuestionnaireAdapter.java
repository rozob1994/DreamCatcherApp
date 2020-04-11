package com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionEightFragment;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionEighteenFragment;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionElevenFragment;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionFifteenFragment;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionFiveFragment;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionFourFragment;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionFourteenFragment;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionNineFragment;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionNineteenFragment;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionOneFragment;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionSevenFragment;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionSeventeenFragment;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionSixFragment;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionSixteenFragment;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionTenFragment;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionThirteenFragment;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionThreeFragment;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionTwelveFragment;
import com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionTwoFragment;

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
        fragmentList.add(new QuestionEightFragment());
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