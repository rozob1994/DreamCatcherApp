package com.catchydreams.dreamcatcher.activities.signUp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.catchydreams.dreamcatcher.R;
import com.catchydreams.dreamcatcher.activities.Login.LoginActivity;
import com.catchydreams.dreamcatcher.activities.profile.ProfileActivity;
import com.catchydreams.dreamcatcher.constants.ConnectionChecker;
import com.catchydreams.dreamcatcher.database.user.UserEntity;
import com.catchydreams.dreamcatcher.databinding.ActivitySignUp2Binding;
import com.catchydreams.dreamcatcher.managersAndFilters.IConnectionChecker;
import com.catchydreams.dreamcatcher.managersAndFilters.SharedPreferencesManager;
import com.catchydreams.dreamcatcher.parameters.Users;
import com.catchydreams.dreamcatcher.presenters.SignUpPresenter;

import java.util.Locale;

public class SignUp extends AppCompatActivity implements IConnectionChecker {
    ActivitySignUp2Binding binding;
    SignUpPresenter presenter;
    private SignUpViewModel viewModel;
    private SharedPreferences sharedPreferences, spLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUp2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        viewModel = ViewModelProviders.of(this).get(SignUpViewModel.class);

        ConnectionChecker connection = new ConnectionChecker(this);

        Locale locale = new Locale("en");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());

        presenter = new SignUpPresenter();
        SharedPreferencesManager.clearDreamSleepQuest(getApplicationContext());
        sharedPreferences = getSharedPreferences("signUp", MODE_PRIVATE);
        spLogin = getSharedPreferences("login", MODE_PRIVATE);
        if ((sharedPreferences.getBoolean("signedUp", false)) || (spLogin.getBoolean("logged", false))) {
            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
            startActivity(intent);
            finish();
        }
        binding.privacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://catchydreams.com/echo/privacy-policy/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        binding.btnSignUpAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Users.getInstance().setConnected(false);
                if ((binding.edtTxtUsername.getText().toString() != "") & (binding.edtTxtPassword.getText().toString() != "")) {
                    Users user = Users.getInstance();
                    user.generateUid();
                    spLogin.edit().putInt("uid", user.getUid()).apply();
                    String mail = binding.edtTxtUsername.getText().toString();
                    String pass = binding.edtTxtPassword.getText().toString();
                    String secPass = binding.edtTxtPasswordTwo.getText().toString();
                    if (secPass.equals(pass)) {
                        user.setEmail(mail);
                        user.setPassword(pass);
                        user.setLevel(1);
                        sharedPreferences.edit().putBoolean("signedUp", true).apply();
                        spLogin.edit().putBoolean("logged", true).apply();
                        spLogin.edit().putString("username", mail).apply();
                        spLogin.edit().putString("pass", pass).apply();
                        spLogin.edit().putInt("level", 1).apply();

                        viewModel.register(new UserEntity());
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
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }

    @Override
    public void onConnected() {

    }

    @Override
    public void onConnectionFailure() {
        Toast.makeText(getApplicationContext(), R.string.connectionTimerFailed,
                Toast.LENGTH_LONG).show();
        binding.loadingBg.setVisibility(View.GONE);
    }
}

