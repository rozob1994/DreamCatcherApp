package com.catchydreams.dreamcatcher.activities.Login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.catchydreams.dreamcatcher.R;
import com.catchydreams.dreamcatcher.activities.ProfileActivity;
import com.catchydreams.dreamcatcher.activities.Splash.SplashActivity;
import com.catchydreams.dreamcatcher.database.Database;
import com.catchydreams.dreamcatcher.database.user.UserEntity;
import com.catchydreams.dreamcatcher.databinding.ActivityLoginBinding;
import com.catchydreams.dreamcatcher.parameters.IResponseMessage;
import com.catchydreams.dreamcatcher.parameters.Users;
import com.catchydreams.dreamcatcher.presenters.LoginPresenter;
import com.catchydreams.dreamcatcher.webservice.ApiCaller;
import com.catchydreams.dreamcatcher.webservice.ApiPostCaller;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

public class LoginActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private ActivityLoginBinding binding;
    private RelativeLayout loadingBg;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Database db = Database.getInstance(this);
        SharedPreferences languagePrefs = getSharedPreferences("languages", MODE_PRIVATE);
        String languageToLoad = languagePrefs.getString("language", "en");
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        if (sharedPreferences.getBoolean("logged", false)) {
            Users user = Users.getInstance();
            user.setUid(sharedPreferences.getInt("uid", 0));
            user.setEmail(sharedPreferences.getString("username", ""));
            Intent intent = new Intent(getApplicationContext(), SplashActivity.class);
            startActivity(intent);
            finish();
        }
        progressBar = binding.progressBar;
        loadingBg = binding.loadingBg;
        binding.btnLoginAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingBg.setVisibility(View.VISIBLE);
                loadingBg.setAlpha(0.5f);
                progressBar.setVisibility(View.VISIBLE);
                String username = binding.edtTxtUsername.getText().toString();
                String pass = binding.edtTxtPassword.getText().toString();
                ApiCaller apiCaller = new ApiCaller();
                ApiPostCaller postCaller = new ApiPostCaller();
                apiCaller.login(username, pass, new IResponseMessage() {
                    @Override
                    public void onSuccess(Object response) throws JSONException {
                        loadingBg.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        Users user = Users.getInstance();
                        JSONObject jsonObject = new JSONObject(response.toString());
                        boolean status = jsonObject.getBoolean("status");
                        String message = jsonObject.getString("message");
                        if (status) {
                            postCaller.getDreamSleepQuestCounts(new IResponseMessage() {
                                @Override
                                public void onSuccess(Object response) throws JSONException {
                                    JSONObject jsonObject1 = new JSONObject(response.toString());
                                    boolean status = jsonObject.getBoolean("status");
                                    if (status) {

                                        int level = jsonObject.getInt("level");
                                        user.setLevel(level);
                                        sharedPreferences.edit().putInt("level", level).apply();
                                        sharedPreferences.edit().putBoolean("logged", true).apply();
                                        user.setEmail(username);
                                        int uid = jsonObject.getInt("uid");
                                        sharedPreferences.edit().putInt("uid", uid).apply();
                                        sharedPreferences.edit().putString("username", username).apply();
                                        user.setUid(uid);
                                        UserEntity userEntity = new UserEntity("en");
                                        db.userDao().insertUser(userEntity);
                                        PostLoadingThread postLoadingThread = new PostLoadingThread(getApplicationContext());
                                        postLoadingThread.start();
                                        Log.e("","");
                                        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(getApplicationContext(),
                                                "Level retrieval failed!",Toast.LENGTH_LONG).show();
                                    }
                                }

                                @Override
                                public void onFailure(String errorMessage) {
                                    Toast.makeText(getApplicationContext(),
                                            "Level retrieval failed!",Toast.LENGTH_LONG).show();
                                }
                            });


                        } else {
                            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                            Log.e("","");
                        }

                    }

                    @Override
                    public void onFailure(String errorMessage) {
                        Log.e("","");
                        loadingBg.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), "Error!", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

        binding.btnLoginDecline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }
    class PostLoadingThread extends Thread{
        Database db;
        public PostLoadingThread(Context context){
            this.db = Database.getInstance(context);
        }
        @Override
        public void run(){
            LoginPresenter presenter = new LoginPresenter();
            presenter.savePosts(db);
        }
    }
}
