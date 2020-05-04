package com.catchydreams.dreamcatcher.presenters;

import android.content.SharedPreferences;

import com.catchydreams.dreamcatcher.activities.viewInterfaces.IDreamChoosingView;
import com.catchydreams.dreamcatcher.database.Database;
import com.catchydreams.dreamcatcher.interactors.DreamChoosingInteractor;
import com.catchydreams.dreamcatcher.presenters.presenterInterfaces.IDreamChoosingPresenter;

public class DreamChoosingPresenter implements IDreamChoosingPresenter {
    IDreamChoosingView iDreamChoosingView;
    DreamChoosingInteractor interactor = new DreamChoosingInteractor(this);
    public DreamChoosingPresenter(IDreamChoosingView iDreamChoosingView){
        this.iDreamChoosingView = iDreamChoosingView;
    }

    public void getDescription() {
        interactor.getDreamDescription();
    }

    public void setLanguage(SharedPreferences languagePrefs) {
        String language = languagePrefs.getString("language", "en");
        if (language.equals("fa")) {
            iDreamChoosingView.setPersianTypeFace();
        }
    }

    @Override
    public void loading() {
        iDreamChoosingView.showProgressBar();
    }

    @Override
    public void onSuccess() {
        iDreamChoosingView.hideProgressBar();
        iDreamChoosingView.onSuccess();
    }

    @Override
    public void onFailure() {
        iDreamChoosingView.hideProgressBar();
        iDreamChoosingView.onError();
    }
}
