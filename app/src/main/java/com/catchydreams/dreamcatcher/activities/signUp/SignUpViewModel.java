package com.catchydreams.dreamcatcher.activities.signUp;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.catchydreams.dreamcatcher.activities.profile.ProfileActivity;
import com.catchydreams.dreamcatcher.database.user.UserEntity;

public class SignUpViewModel extends AndroidViewModel implements ISignUpViewModel {
    private SignUpRepository repository;
    private LiveData<UserEntity> userEntity;
    private Application application;
    public SignUpViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
        repository = new SignUpRepository(application, this);
    }

    public LiveData<UserEntity> getUserEntity(int uid){
        this.userEntity = repository.getUserEntity(uid);
        return this.userEntity;
    }


    public void register(UserEntity userEntity) {
        repository.register(userEntity);
    }
    @Override
    public void onSuccess() {
        Intent intent = new Intent(application, ProfileActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        application.startActivity(intent);
    }

    @Override
    public void onFailure() {

    }
}
