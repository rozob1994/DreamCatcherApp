package com.phrenologue.dreamcatcherapp.presenters;

import com.phrenologue.dreamcatcherapp.activities.viewInterfaces.IDreamChoosingView;
import com.phrenologue.dreamcatcherapp.interactors.DreamChoosingInteractor;
import com.phrenologue.dreamcatcherapp.presenters.presenterInterfaces.IDreamChoosingPresenter;

public class DreamChoosingPresenter implements IDreamChoosingPresenter {
    IDreamChoosingView iDreamChoosingView;
    DreamChoosingInteractor interactor = new DreamChoosingInteractor(this);
    public DreamChoosingPresenter(IDreamChoosingView iDreamChoosingView){
        this.iDreamChoosingView = iDreamChoosingView;
    }

    public void getDescription() {
        interactor.getDreamDescription();
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
