package com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionEightFragment;
import com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionEighteenFragment;
import com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionElevenFragment;
import com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionFifteenFragment;
import com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionFiveFragment;
import com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionFourFragment;
import com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionFourteenFragment;
import com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionNineFragment;
import com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionNineteenFragment;
import com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionOneFragment;
import com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionSevenFragment;
import com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionSeventeenFragment;
import com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionSixFragment;
import com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionSixteenFragment;
import com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionTenFragment;
import com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionThirteenFragment;
import com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionThreeFragment;
import com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionTwelveFragment;
import com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Fragments.questionnaire.QuestionTwoFragment;

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