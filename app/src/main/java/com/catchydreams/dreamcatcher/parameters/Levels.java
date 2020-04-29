package com.catchydreams.dreamcatcher.parameters;

import com.catchydreams.dreamcatcher.R;

public class Levels {
    private static Levels instance = null;
    private int level;
    private String levelFolder;
    private String levelFileName;
    private int levelTitle;

    public static Levels getInstance() {
        if (instance == null) {
            instance = new Levels();
        }
        return instance;
    }

    public static void delLevel() {
        instance = null;
    }

    public int getLevel() {
        return level;
    }

    public String getLevelFolder() {
        return levelFolder;
    }

    public String getLevelFileName() {
        return levelFileName;
    }

    public int getLevelTitle() {
        return levelTitle;
    }

    public void setLevel(int level) {
        this.level = level;
        switch (level) {
            case 1:
                this.levelFolder = "images/level_one";
                this.levelFileName = "level1.json";
                this.levelTitle = R.string.LevelOneTitle;
            case 2:
                this.levelFolder = "images/level_two";
                this.levelFileName = "level2.json";
                this.levelTitle = R.string.LevelTwoTitle;
            case 3:
                this.levelFolder = "images/level_three";
                this.levelFileName = "level3.json";
                this.levelTitle = R.string.LevelThreeTitle;
            case 4:
                this.levelFolder = "images/level_four";
                this.levelFileName = "level4.json";
                this.levelTitle = R.string.LevelFourTitle;
            case 5:
                this.levelFolder = "images/level_five";
                this.levelFileName = "level5.json";
                this.levelTitle = R.string.LevelFiveTitle;
            case 6:
                this.levelFolder = "images/level_six";
                this.levelFileName = "level6.json";
                this.levelTitle = R.string.LevelSixTitle;
            case 7:
                this.levelFolder = "images/level_seven";
                this.levelFileName = "level7.json";
                this.levelTitle = R.string.LevelSevenTitle;
            case 8:
                this.levelFolder = "images/level_eight";
                this.levelFileName = "level8.json";
                this.levelTitle = R.string.LevelEightTitle;
            case 9:
                this.levelFolder = "images/level_nine";
                this.levelFileName = "level9.json";
                this.levelTitle = R.string.LevelNineTitle;
            case 10:
                this.levelFolder = "images/level_ten";
                this.levelFileName = "level10.json";
                this.levelTitle = R.string.LevelTenTitle;
        }
    }
}
