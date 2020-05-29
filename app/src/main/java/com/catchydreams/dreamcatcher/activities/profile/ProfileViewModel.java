package com.catchydreams.dreamcatcher.activities.profile;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.catchydreams.dreamcatcher.database.user.UserEntity;

public class ProfileViewModel extends AndroidViewModel {
    private ProfileRepository repository;
    private LiveData<Boolean> isUploaded;
    public ProfileViewModel(@NonNull Application application) {
        super(application);
        repository = new ProfileRepository(application);
        this.isUploaded = repository.getIsUploaded();
    }

    public void uploadUser(){
        repository.uploadUserFun();
    }

    public LiveData<Boolean> getIsUploaded(){
        return this.isUploaded;
    }

    public void delUser(UserEntity userEntity){
        repository.deleteUser(userEntity);
    }
}
