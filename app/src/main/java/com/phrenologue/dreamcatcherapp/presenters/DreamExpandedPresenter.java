package com.phrenologue.dreamcatcherapp.presenters;

import android.content.SharedPreferences;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.activities.viewInterfaces.IDreamExpandedView;
import com.phrenologue.dreamcatcherapp.interactors.DreamExpandedInteractor;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamChecklist;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamPeople;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamSound;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Sleep;
import com.phrenologue.dreamcatcherapp.presenters.presenterInterfaces.IDreamExpandedPresenter;

public class DreamExpandedPresenter implements IDreamExpandedPresenter {
    private IDreamExpandedView iDreamExpandedView;
    private DreamExpandedInteractor interactor = new DreamExpandedInteractor(this);
    private Sleep sleep = Sleep.getInstance();
    private DreamPeople people = DreamPeople.getInstance();
    private DreamChecklist checklist = DreamChecklist.getInstance();

    public DreamExpandedPresenter(IDreamExpandedView iDreamExpandedView) {
        this.iDreamExpandedView = iDreamExpandedView;
    }

    public void loadPost(int postId, String dateLoaded) {
        iDreamExpandedView.showProgressBar();
        interactor.getPost(postId, dateLoaded);
    }

    public void savePostToSp(SharedPreferences sleepSp, SharedPreferences dreamSp,
                             SharedPreferences dreamSpTwo, SharedPreferences peopleSp) {
        interactor.cachePost(sleepSp, dreamSp, dreamSpTwo, peopleSp);
    }


    public void setPeopleToViews() {
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

    private void setMoodToImageView() {
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

    private void setColorToImageView() {
        if (checklist.getGrayScale() == 2) {
            iDreamExpandedView.setColorView(R.drawable.ic_colorful);
        } else {
            iDreamExpandedView.setColorView(R.drawable.ic_grayscale);
        }
    }

    private void setSoundToImageView() {
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

    private void setDreamPropertiesToViews(String dateLoaded) {
        setMoodToImageView();
        setColorToImageView();
        iDreamExpandedView.setInterpretationText();
        iDreamExpandedView.setTitleText();
        iDreamExpandedView.setContentText();
        setSoundToImageView();
        setDate(dateLoaded);
    }

    private void setSleepPropsToViews() {
        setSleepTimeToView();
        setPhysicalActivityToView();
        setFoodToView();
    }

    private void setSleepTimeToView() {
        if (sleep.getTime() == 1) {
            iDreamExpandedView.setSleepTimeView(R.drawable.ic_day_symbol);
        } else if (sleep.getTime() == 2) {
            iDreamExpandedView.setSleepTimeView(R.drawable.ic_night_symbol);
        } else {
            iDreamExpandedView.hideSleepTime();
        }
    }

    private void setPhysicalActivityToView() {
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

    private void setFoodToView() {
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
        setSleepPropsToViews();
    }

    @Override
    public void onSleepError() {
        iDreamExpandedView.onError();
    }

    @Override
    public void onDreamRetrieved(String dateLoaded) {
        setDreamPropertiesToViews(dateLoaded);

    }

    @Override
    public void onDreamError() {
        iDreamExpandedView.onError();
    }

    @Override
    public void onPeopleRetrieved() {
        iDreamExpandedView.hideProgressBar();
        setPeopleToViews();
    }

    @Override
    public void onPeopleError() {
        iDreamExpandedView.onError();
    }

}
