package com.catchydreams.dreamcatcher.activities.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.catchydreams.dreamcatcher.R;
import com.catchydreams.dreamcatcher.activities.ProfileActivity;
import com.catchydreams.dreamcatcher.activities.SelectLanguageActivity;
import com.catchydreams.dreamcatcher.constants.ConnectionChecker;
import com.catchydreams.dreamcatcher.constants.PersianFont;
import com.catchydreams.dreamcatcher.databinding.ActivitySignUp2Binding;
import com.catchydreams.dreamcatcher.managersAndFilters.IConnectionChecker;
import com.catchydreams.dreamcatcher.managersAndFilters.SharedPreferencesManager;
import com.catchydreams.dreamcatcher.parameters.IResponseMessage;
import com.catchydreams.dreamcatcher.parameters.Users;
import com.catchydreams.dreamcatcher.presenters.SignUpPresenter;
import com.catchydreams.dreamcatcher.webservice.ApiCaller;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

public class SignUp extends AppCompatActivity implements IConnectionChecker {
    ActivitySignUp2Binding binding;
    SignUpPresenter presenter;
    private SharedPreferences sharedPreferences, spLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUp2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ConnectionChecker connection = new ConnectionChecker(this);
        SharedPreferences languagePrefs = getSharedPreferences("languages", MODE_PRIVATE);
        String languageToLoad = languagePrefs.getString("language", "en");
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        if (languageToLoad.equals("fa")){
            Typeface title = Typeface.createFromAsset(getAssets(), PersianFont.title);
            Typeface subTitle = Typeface.createFromAsset(getAssets(), PersianFont.regular);
            binding.signUpTitle.setTypeface(title);
            binding.signUpTitle.setTextSize(PersianFont.normalLarge);
            binding.passwordEdtTxtTitle.setTypeface(title);
            binding.usernameEdtTxtTitle.setTypeface(title);
            binding.passwordEdtTxtTitleTwo.setTypeface(title);
            binding.passwordEdtTxtTitle.setTextSize(PersianFont.normal);
            binding.passwordEdtTxtTitleTwo.setTextSize(PersianFont.normal);
            binding.usernameEdtTxtTitle.setTextSize(PersianFont.normal);
            binding.signUpBtnTitle.setTypeface(subTitle);
            binding.signinBtnTitle.setTypeface(subTitle);
            binding.signUpBtnTitle.setTextSize(PersianFont.normalSmall);
            binding.signinBtnTitle.setTextSize(PersianFont.normalSmall);
        }
        presenter = new SignUpPresenter();
        ApiCaller apiCaller = new ApiCaller();
        SharedPreferencesManager.clearDreamSleepQuest(getApplicationContext());
        sharedPreferences = getSharedPreferences("signUp", MODE_PRIVATE);
        spLogin = getSharedPreferences("login", MODE_PRIVATE);
        if ((sharedPreferences.getBoolean("signedUp", false))||(spLogin.getBoolean("logged", false))){
            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
            startActivity(intent);
            finish();
        }
        binding.btnSignUpAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Users.getInstance().setConnected(false);
                binding.loadingBg.setVisibility(View.VISIBLE);
                binding.loadingBg.setAlpha(0.5f);
                binding.progressBar.setVisibility(View.VISIBLE);
                if ((binding.edtTxtUsername.getText().toString() != "") & (binding.edtTxtPassword.getText().toString() != "")) {
                    Users user = Users.getInstance();
                    user.generateUid();
                    spLogin.edit().putInt("uid",user.getUid()).apply();
                    String mail = binding.edtTxtUsername.getText().toString();
                    String pass = binding.edtTxtPassword.getText().toString();
                    String secPass = binding.edtTxtPasswordTwo.getText().toString();
                    if (secPass.equals(pass)) {
                        apiCaller.signUp(mail, pass, user.getUid(), new IResponseMessage() {
                            @Override
                            public void onSuccess(Object response) throws JSONException {
                                Users.getInstance().setConnected(true);
                                JSONObject jsonObject = new JSONObject(response.toString());
                                boolean status = jsonObject.getBoolean("status");
                                String message = jsonObject.getString("message");
                                Log.e("", "");
                                if (status) {
                                    sharedPreferences.edit().putBoolean("signedUp", true).apply();
                                    user.setEmail(mail);
                                    spLogin.edit().putBoolean("logged", true).apply();
                                    spLogin.edit().putString("username", mail).apply();
                                    spLogin.edit().putInt("level", 1).apply();
                                    user.setPassword(pass);
                                }

                            }

                            @Override
                            public void onFailure(String errorMessage) {
                                binding.loadingBg.setVisibility(View.GONE);
                                binding.progressBar.setVisibility(View.GONE);
                                Users.getInstance().setConnected(false);

                            }

                        });
                    } else {
                        Toast.makeText(getApplicationContext(), R.string.pass_not_match,
                                Toast.LENGTH_LONG).show();
                        binding.loadingBg.setVisibility(View.INVISIBLE);
                    }

                } else {
                    Toast.makeText(getApplicationContext(), R.string.field_not_filled_toast,
                            Toast.LENGTH_LONG).show();
                }
                connection.checkConnection();
            }
        });

        binding.btnSignUpDecline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
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
        Intent intent = new Intent(getApplicationContext(), SelectLanguageActivity.class);
        intent.putExtra("firstLogin", true);
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

