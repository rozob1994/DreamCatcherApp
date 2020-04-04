package com.phrenologue.dreamcatcherapp.presenters;

import com.airbnb.lottie.LottieAnimationView;
import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.parameters.Users;
import com.phrenologue.dreamcatcherapp.ui.costumeFont.MoonTextView;

public class ProfilePresenter {
    public ProfilePresenter(){}

    public void setLevel(LottieAnimationView levelAnim, MoonTextView levelTitle){
        Users user = Users.getInstance();
        int level = user.getLevel();
        switch (level){
            case 1:
                levelAnim.setImageAssetsFolder("images/level_one");
                levelAnim.setAnimation("level1.json");
                levelTitle.setText(R.string.LevelOneTitle);
            case 2:
                levelAnim.setImageAssetsFolder("images/level_two");
                levelAnim.setAnimation("level2.json");
                levelTitle.setText(R.string.LevelTwoTitle);
            case 3:
                levelAnim.setImageAssetsFolder("images/level_three");
                levelAnim.setAnimation("level3.json");
                levelTitle.setText(R.string.LevelThreeTitle);
            case 4:
                levelAnim.setImageAssetsFolder("images/level_four");
                levelAnim.setAnimation("level4.json");
                levelTitle.setText(R.string.LevelFourTitle);
            case 5:
                levelAnim.setImageAssetsFolder("images/level_five");
                levelAnim.setAnimation("level5.json");
                levelTitle.setText(R.string.LevelFiveTitle);
            case 6:
                levelAnim.setImageAssetsFolder("images/level_six");
                levelAnim.setAnimation("level6.json");
                levelTitle.setText(R.string.LevelSixTitle);
            case 7:
                levelAnim.setImageAssetsFolder("images/level_seven");
                levelAnim.setAnimation("level7.json");
                levelTitle.setText(R.string.LevelSevenTitle);
            case 8:
                levelAnim.setImageAssetsFolder("images/level_eight");
                levelAnim.setAnimation("level8.json");
                levelTitle.setText(R.string.LevelEightTitle);
            case 9:
                levelAnim.setImageAssetsFolder("images/level_nine");
                levelAnim.setAnimation("level9.json");
                levelTitle.setText(R.string.LevelNineTitle);
            case 10:
                levelAnim.setImageAssetsFolder("images/level_ten");
                levelAnim.setAnimation("level10.json");
                levelTitle.setText(R.string.LevelTenTitle);
        }
    }
}
