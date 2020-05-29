package com.catchydreams.dreamcatcher.activities.profile;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.catchydreams.dreamcatcher.activities.signUp.SignUpRepository;
import com.catchydreams.dreamcatcher.database.Database;
import com.catchydreams.dreamcatcher.database.user.UserDao;
import com.catchydreams.dreamcatcher.database.user.UserEntity;
import com.catchydreams.dreamcatcher.parameters.IResponseMessage;
import com.catchydreams.dreamcatcher.parameters.Users;
import com.catchydreams.dreamcatcher.webservice.ApiCaller;

import org.json.JSONException;
import org.json.JSONObject;

public class ProfileRepository {
    private UserDao userDao;
    private LiveData<Boolean> isUploaded;
    private SignUpRepository signUpRepository;
    ProfileRepository(Application application) {
        Database database = Database.getInstance(application);
        userDao = database.userDao();
        isUploaded = userDao.isUploaded();

    }

    public void uploadUserFun(){
        UploadUser uploadUser = new UploadUser();
        uploadUser.execute();
    }

    public void deleteUser(UserEntity userEntity) {
        DeleteUser deleteUser = new DeleteUser(userEntity);
        deleteUser.execute();
    }

    public LiveData<Boolean> getIsUploaded(){
        return this.isUploaded;
    }
    class UploadUser extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            ApiCaller apiCaller = new ApiCaller();
            Users user = Users.getInstance();
            apiCaller.signUp(user.getEmail(), user.getPassword(), user.getUid(), new IResponseMessage() {
                @Override
                public void onSuccess(Object response) throws JSONException {
                    Users.getInstance().setConnected(true);
                    JSONObject jsonObject = new JSONObject(response.toString());
                    boolean status = jsonObject.getBoolean("status");
                    String message = jsonObject.getString("message");
                    Log.e("", "");
                    if (status) {
                        userDao.setUploaded(true, user.getUid());
                    } else {
                        userDao.setUploaded(false, user.getUid());
                    }

                }

                @Override
                public void onFailure(String errorMessage) {
                    Users.getInstance().setConnected(false);
                    userDao.setUploaded(false, user.getUid());
                }

            });
            return null;
        }
    }

    class DeleteUser extends AsyncTask<Void, Void, Void>{
        UserEntity userEntity;
        DeleteUser(UserEntity userEntity){
            this.userEntity = userEntity;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            userDao.deleteUser(userEntity);
            return null;
        }
    }
}
