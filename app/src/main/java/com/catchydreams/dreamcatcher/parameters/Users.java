package com.catchydreams.dreamcatcher.parameters;

import android.content.Context;
import android.widget.Toast;

import com.catchydreams.dreamcatcher.parameters.dateParameters.parameters.Date;
import com.catchydreams.dreamcatcher.parameters.postParameters.majorParameters.Dream;
import com.catchydreams.dreamcatcher.parameters.postParameters.majorParameters.Sleep;
import com.catchydreams.dreamcatcher.webservice.ApiCaller;
import com.catchydreams.dreamcatcher.webservice.ApiPostCaller;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

public class Users {
    private static Users instance = null;
    private String email;
    private int uid;
    private int level;
    private boolean connected;
    private int newLevel = 0;
    private boolean levelChanged;
    int gender;
    String username;
    private Dream dream;
    private Sleep sleep;
    private String password;
    private Date date;
    public static int levelTwoScore = 6, levelThreeScore = 18, levelFourScore = 66,
            levelFiveScore = 162, levelSixScore = 354, levelSevenScore = 738, levelEightScore = 1506,
            levelNineScore = 3042, levelTenScore = 6114;


    private Users() {
    }


    public static Users getInstance() {
        if (instance == null) {
            instance = new Users();
        }
        return instance;
    }

    public static void delUser() {
        instance = null;
    }

    public void checkSetLevelChange(Context context) {
        ApiPostCaller postCaller = new ApiPostCaller();
        ApiCaller caller = new ApiCaller();
        postCaller.getDreamSleepQuestCounts(new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                JSONObject jsonObject = new JSONObject(response.toString());
                boolean status = jsonObject.getBoolean("status");
                if (status) {
                    int dreamCount = jsonObject.getInt("dreamCount");
                    int sleepCount = jsonObject.getInt("sleepCount");
                    int questCount = jsonObject.getInt("questCount");
                    int newLevel = calculateGetLevel(dreamCount, sleepCount, questCount);
                    if (newLevel > level) {
                        setLevelChanged(true);
                        setLevel(newLevel);
                        caller.editUserLevel(new IResponseMessage() {
                            @Override
                            public void onSuccess(Object response) throws JSONException {
                                JSONObject jsonObject1 = new JSONObject(response.toString());
                                boolean status = jsonObject1.getBoolean("status");
                                if (status){
                                    Toast.makeText(context, "Congrats, You've Been Promoted!!",
                                            Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(context, "Error",
                                            Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(String errorMessage) {
                                Toast.makeText(context, "Error!",
                                        Toast.LENGTH_LONG).show();
                            }
                        });
                    } else {
                        setLevelChanged(false);
                        caller.editUserLevel(new IResponseMessage() {
                            @Override
                            public void onSuccess(Object response) throws JSONException {
                                JSONObject jsonObject1 = new JSONObject(response.toString());
                                boolean status = jsonObject1.getBoolean("status");
                                if (status) {
                                    Toast.makeText(context,"level ensured",Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(context,"Couldn't update level",Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(String errorMessage) {
                                Toast.makeText(context,"Couldn't update level",Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }
            }

            @Override
            public void onFailure(String errorMessage) {
                Toast.makeText(context, "Error.",
                        Toast.LENGTH_LONG).show();

            }
        });
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Dream getDream() {
        return dream;
    }

    public void setDream(Dream dream) {
        this.dream = dream;
    }

    public Sleep getSleep() {
        return sleep;
    }

    public void setSleep(Sleep sleep) {
        this.sleep = sleep;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUid() {
        return uid;
    }

    public void generateUid() {
        Random rand = new Random();
        int randInt = rand.nextInt(999999999);
        this.uid = randInt;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int calculateGetLevel(int dreamCount, int sleepCount, int lucidityCount) {
        int score = dreamCount + sleepCount + lucidityCount;
        if (score < levelTwoScore) {
            newLevel = 1;
        } else if (score < levelThreeScore) {
            newLevel = 2;
        } else if (score < levelFourScore) {
            newLevel = 3;
        } else if (score < levelFiveScore) {
            newLevel = 4;
        } else if (score < levelSixScore) {
            newLevel = 5;
        } else if (score < levelSevenScore) {
            newLevel = 6;
        } else if (score < levelEightScore) {
            newLevel = 7;
        } else if (score < levelNineScore) {
            newLevel = 8;
        } else if (score < levelTenScore) {
            newLevel = 9;
        } else if (score > levelTenScore) {
            newLevel = 10;
        }
        return newLevel;
    }

    public void calculateSetLevel(int dreamCount, int sleepCount, int lucidityCount) {
        Levels level = Levels.getInstance();
        int score = dreamCount + sleepCount + lucidityCount;
        level.setLevel(score);
        if (score < levelTwoScore) {
            this.level = 1;
        } else if (score < levelThreeScore) {
            this.level = 2;
        } else if (score < levelFourScore) {
            this.level = 3;
        } else if (score < levelFiveScore) {
            this.level = 4;
        } else if (score < levelSixScore) {
            this.level = 5;
        } else if (score < levelSevenScore) {
            this.level = 6;
        } else if (score < levelEightScore) {
            this.level = 7;
        } else if (score < levelNineScore) {
            this.level = 8;
        } else if (score < levelTenScore) {
            this.level = 9;
        } else if (score > levelTenScore) {
            this.level = 10;
        }
    }

    public boolean isLevelChanged() {
        return levelChanged;
    }

    public void setLevelChanged(boolean levelChanged) {
        this.levelChanged = levelChanged;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }
}
