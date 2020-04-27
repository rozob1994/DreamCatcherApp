package com.phrenologue.dreamcatcherapp.presenters;

import android.content.SharedPreferences;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.activities.viewInterfaces.IProfileView;
import com.phrenologue.dreamcatcherapp.parameters.Users;

public class ProfilePresenter {
    IProfileView iProfileView;

    public ProfilePresenter(IProfileView iProfileView) {
        this.iProfileView = iProfileView;
    }

    public void setTypeFace(SharedPreferences languagePrefs) {
        String language = languagePrefs.getString("language", "");
        if (language.equals("fa")){
            iProfileView.setTypeFace();
        }
    }

    public void checkLanguageChanged(SharedPreferences languagePrefs) {
        boolean changed = languagePrefs.getBoolean("justChanged", false);
        if (changed) {
            iProfileView.onLanguageChanged();
            languagePrefs.edit().putBoolean("justChanged", false).apply();
        }

    }

    public void setLevel() {
        Users user = Users.getInstance();
        int level = user.getLevel();
        switch (level) {
            case 1:
                iProfileView.setLevelView("images/level_one", "level1.json",
                        R.string.LevelOneTitle);

                break;
            case 2:
                iProfileView.setLevelView("images/level_two", "level2.json",
                        R.string.LevelTwoTitle);
                break;
            case 3:
                iProfileView.setLevelView("images/level_three", "level3.json",
                        R.string.LevelThreeTitle);
                break;
            case 4:
                iProfileView.setLevelView("images/level_four", "level4.json",
                        R.string.LevelFourTitle);
                break;
            case 5:
                iProfileView.setLevelView("images/level_five", "level5.json",
                        R.string.LevelFiveTitle);
                break;
            case 6:
                iProfileView.setLevelView("images/level_six", "level6.json",
                        R.string.LevelSixTitle);
                break;
            case 7:
                iProfileView.setLevelView("images/level_seven", "level7.json",
                        R.string.LevelSevenTitle);
                break;
            case 8:
                iProfileView.setLevelView("images/level_eight", "level8.json",
                        R.string.LevelEightTitle);
                break;
            case 9:
                iProfileView.setLevelView("images/level_nine", "level9.json",
                        R.string.LevelNineTitle);
                break;
            case 10:
                iProfileView.setLevelView("images/level_ten", "level10.json",
                        R.string.LevelTenTitle);
                break;
        }

    }

}
