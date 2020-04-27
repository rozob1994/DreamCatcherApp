package com.phrenologue.dreamcatcherapp.presenters;

import android.content.SharedPreferences;
import android.util.Log;

import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.activities.viewInterfaces.IDreamExpandedView;
import com.phrenologue.dreamcatcherapp.interactors.DreamExpandedInteractor;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamChecklist;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamPeople;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamSound;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Sleep;
import com.phrenologue.dreamcatcherapp.presenters.presenterInterfaces.IDreamExpandedPresenter;
import com.phrenologue.dreamcatcherapp.ui.colorPalette.ColorPalettes;
import com.phrenologue.dreamcatcherapp.ui.costumeFont.MoonTextView;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DreamExpandedPresenter implements IDreamExpandedPresenter {
    private IDreamExpandedView iDreamExpandedView;
    private DreamExpandedInteractor interactor = new DreamExpandedInteractor(this);
    private Sleep sleep = Sleep.getInstance();
    private DreamPeople people = DreamPeople.getInstance();
    private DreamChecklist checklist = DreamChecklist.getInstance();

    public DreamExpandedPresenter(IDreamExpandedView iDreamExpandedView) {
        this.iDreamExpandedView = iDreamExpandedView;
    }

    public void checkLanguage(SharedPreferences languagePrefs){
        String language = languagePrefs.getString("language", "en");
        if (language.equals("fa")){
            iDreamExpandedView.setPersianFont();
        }
    }

    public void setPersianNameFonts(List<MoonTextView> names) {
        for (int i = 0; i < names.size(); i++) {
            iDreamExpandedView.setPersianNameFonts(names.get(i));
        }
    }

    public void loadPost(int postId, String dateLoaded,
                         SharedPreferences sleepSp, SharedPreferences dreamSp,
                         SharedPreferences dreamSpTwo) {
        iDreamExpandedView.showProgressBar();
        interactor.getPost(postId, dateLoaded, sleepSp, dreamSp, dreamSpTwo);
    }

    public static void drawSingleLucidityLevel(IDreamExpandedView iDreamExpandedView, int postId) {
        ApiPostCaller postCaller = new ApiPostCaller();
        postCaller.getQResult(postId, new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {

                JSONObject jsonObject = new JSONObject(response.toString());
                JSONArray jsonArray = jsonObject.getJSONArray("0");






            }

            @Override
            public void onFailure(String errorMessage) {
                Log.e("", "");
            }
        });
    }

    private static PieData createLucidityChart(int result){
        int percentage = singlePercentCalc(result);
        int remainder = 100 - percentage;
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(percentage, "Lucid"));
        entries.add(new PieEntry(remainder, "Not Lucid"));
        PieDataSet dataSet = new PieDataSet(entries, "Lucidity Percentage");
        PieData pieData = new PieData(dataSet);
        dataSet.setColors(ColorPalettes.DREAMS_EXPANDED);
        dataSet.setDrawValues(false);
        return pieData;
    }

    private static int singlePercentCalc(int result) {
        return (int) (((float) result / 38f) * 100);
    }

    private static String singleStrPercentCalc(int result){
        int percentage = singlePercentCalc(result);
        return  "%" + percentage + "" + " Lucid";
    }



    public void peopleViewLogic() {
        int textColor = 0;
        for (int i = 0; i < 9; i++) {
            String name = people.getName(i);
            if (!name.equals("")) {
                Integer impression = people.getImpression(i);
                if (impression > 0) {
                    switch (impression) {
                        case 1:
                            textColor = R.color.txt_glow;
                            break;
                        case 2:
                            textColor = R.color.white;
                            break;
                        case 3:
                            textColor = R.color.day_light;
                            break;
                    }
                }
                iDreamExpandedView.setPeopleView(i, name, textColor);
            }

        }
    }

    private void moodLogic() {
        if (checklist.getExperience() == 0) {
            iDreamExpandedView.setMoodView(R.drawable.ic_sad_emoji);
        } else if (checklist.getExperience() == 1) {
            iDreamExpandedView.setMoodView(R.drawable.ic_poker_face_emoji);
        } else if (checklist.getExperience() == 2) {
            iDreamExpandedView.setMoodView(R.drawable.ic_happy_emoji);
        } else {
            iDreamExpandedView.hideMood();
        }
    }

    private void colorLogic() {
        if (checklist.getGrayScale()!=null){
            if (checklist.getGrayScale() == 2) {
                iDreamExpandedView.setColorView(R.drawable.ic_colorful);
            } else {
                iDreamExpandedView.setColorView(R.drawable.ic_grayscale);
            }
        }

    }

    private void soundLogic() {
        DreamSound sound = DreamSound.getInstance();
        int soundInt = sound.getSound();
        if (soundInt == 1) {
            iDreamExpandedView.setMusicalView(R.drawable.ic_musical);
        } else {
            iDreamExpandedView.setMusicalView(R.drawable.ic_non_musical);
        }


    }

    private void setDate(String dateLoaded) {
        iDreamExpandedView.setDateText(dateLoaded);
    }

    private void dreamLogic(String dateLoaded) {
        moodLogic();
        colorLogic();
        iDreamExpandedView.setInterpretationText();
        iDreamExpandedView.setTitleText();
        iDreamExpandedView.setContentText();
        soundLogic();
        setDate(dateLoaded);
    }

    private void sleepLogic() {
        sleepTimeLogic();
        activityLogic();
        foodLogic();
    }

    private void sleepTimeLogic() {
        if (sleep.getTime() == 1) {
            iDreamExpandedView.setSleepTimeView(R.drawable.ic_day_symbol);
        } else if (sleep.getTime() == 2) {
            iDreamExpandedView.setSleepTimeView(R.drawable.ic_night_symbol);
        } else {
            iDreamExpandedView.hideSleepTime();
        }
    }

    private void activityLogic() {
        if (sleep.getPhysicalActivity() == 0) {
            iDreamExpandedView.setPhysicalView(R.drawable.stick_figure_1);
        } else if (sleep.getPhysicalActivity() == 1) {
            iDreamExpandedView.setPhysicalView(R.drawable.stick_figure_2);
        } else if (sleep.getPhysicalActivity() == 2) {
            iDreamExpandedView.setPhysicalView(R.drawable.stick_figure_3);
        } else if (sleep.getPhysicalActivity() == 3) {
            iDreamExpandedView.setPhysicalView(R.drawable.stick_figure_4);
        }
    }

    private void foodLogic() {
        if (sleep.getFoodConsumption() == 0) {
            iDreamExpandedView.setFoodView(R.drawable.apple);
        } else if (sleep.getFoodConsumption() == 1) {
            iDreamExpandedView.setFoodView(R.drawable.steak);
        } else if (sleep.getFoodConsumption() == 2) {
            iDreamExpandedView.setFoodView(R.drawable.hamburger_drink);
        }
    }

    @Override
    public void onSleepRetrieved() {
        sleepLogic();
    }

    @Override
    public void onDreamRetrieved(String dateLoaded) {
        dreamLogic(dateLoaded);

    }

    @Override
    public void onPeopleRetrieved() {
        iDreamExpandedView.hideProgressBar();
        peopleViewLogic();
    }


    @Override
    public void checkLucidity(int result) {
        if (result == 0) {
            iDreamExpandedView.onNonLucid();
        } else {
            iDreamExpandedView.onLucid();
            iDreamExpandedView.setPercentage(singleStrPercentCalc(result));
            iDreamExpandedView.drawChart(createLucidityChart(result));
        }
    }

    @Override
    public void onError() {
        iDreamExpandedView.onError();
    }


}
