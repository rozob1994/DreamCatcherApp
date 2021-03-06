package com.catchydreams.dreamcatcher.activities.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.catchydreams.dreamcatcher.R;
import com.catchydreams.dreamcatcher.activities.profile.ProfileActivity;
import com.catchydreams.dreamcatcher.activities.Splash.SplashActivity;
import com.catchydreams.dreamcatcher.activities.signUp.SignUp;
import com.catchydreams.dreamcatcher.constants.ConnectionChecker;
import com.catchydreams.dreamcatcher.databinding.ActivityLoginBinding;
import com.catchydreams.dreamcatcher.managersAndFilters.IConnectionChecker;
import com.catchydreams.dreamcatcher.parameters.IResponseMessage;
import com.catchydreams.dreamcatcher.parameters.Users;
import com.catchydreams.dreamcatcher.webservice.ApiCaller;
import com.catchydreams.dreamcatcher.webservice.ApiPostCaller;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

public class LoginActivity extends AppCompatActivity implements IConnectionChecker {
    private SharedPreferences sharedPreferences, loginInput;
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
        ConnectionChecker connection = new ConnectionChecker(this);
        Locale locale = new Locale("en");
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
                Users.getInstance().setConnected(false);
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
                                    Users.getInstance().setConnected(true);
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
                                    } else {
                                        Toast.makeText(getApplicationContext(),
                                                "Level retrieval failed!",Toast.LENGTH_LONG).show();
                                    }
                                }

                                @Override
                                public void onFailure(String errorMessage) {
                                    Users.getInstance().setConnected(false);
                                    Toast.makeText(getApplicationContext(),
                                            "Level retrieval failed!",Toast.LENGTH_LONG).show();
                                }
                            });


                        } else {
                            Users.getInstance().setConnected(true);
                            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(String errorMessage) {
                        Users.getInstance().setConnected(false);
                    }
                });
                connection.checkConnection();

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

    @Override
    public void onConnected() {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onConnectionFailure() {
        Toast.makeText(getApplicationContext(), R.string.connectionTimerFailed,
                Toast.LENGTH_LONG).show();
        binding.loadingBg.setVisibility(View.GONE);
    }
}
