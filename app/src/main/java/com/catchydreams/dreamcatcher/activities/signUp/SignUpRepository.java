package com.catchydreams.dreamcatcher.activities.signUp;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.catchydreams.dreamcatcher.database.Database;
import com.catchydreams.dreamcatcher.database.user.UserDao;
import com.catchydreams.dreamcatcher.database.user.UserEntity;
import com.catchydreams.dreamcatcher.parameters.IResponseMessage;
import com.catchydreams.dreamcatcher.parameters.Users;
import com.catchydreams.dreamcatcher.webservice.ApiCaller;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUpRepository {
    private UserDao userDao;
    private LiveData<UserEntity> userEntity;
    private ISignUpViewModel iSignUpViewModel;
    private LiveData<Boolean> isUploaded;
    SignUpRepository(Application application, ISignUpViewModel iSignUpViewModel) {
        Database database = Database.getInstance(application);
        userDao = database.userDao();
        this.iSignUpViewModel = iSignUpViewModel;
        this.isUploaded = userDao.isUploaded();
    }

    public LiveData<UserEntity> getUserEntity(int uid) {
        this.userEntity = userDao.retrieveUserByUid(uid);
        return userEntity;
    }

    public void register(UserEntity userEntity) {
        RegisterUser register = new RegisterUser(userEntity);
        register.execute();
        UploadUser uploadUser = new UploadUser();
        uploadUser.execute();
    }

    public LiveData<Boolean> isUploaded(){
        return this.isUploaded;
    }

    class RegisterUser extends AsyncTask<Void, Void, UserEntity>{
        private UserEntity userEntity;
        RegisterUser(UserEntity userEntity){
            this.userEntity = userEntity;
        }

        @Override
        protected UserEntity doInBackground(Void... voids) {
            userDao.insertUser(userEntity);
            return userEntity;
        }
        @Override
        protected void onPostExecute(UserEntity userEntity){
            super.onPostExecute(userEntity);
            iSignUpViewModel.onSuccess();
        }

    }
    class UploadUser extends AsyncTask<Void, Void, Void>{

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

}
