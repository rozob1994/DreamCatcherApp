package com.phrenologue.dreamcatcherapp.activities.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.activities.ProfileActivity;
import com.phrenologue.dreamcatcherapp.activities.SleepDreamInputActivity;
import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.ActivitySignUp2Binding;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.Users;
import com.phrenologue.dreamcatcherapp.presenters.SignUpPresenter;
import com.phrenologue.dreamcatcherapp.webservice.ApiCaller;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUp extends AppCompatActivity {
    ActivitySignUp2Binding binding;
    SignUpPresenter presenter;
    private SharedPreferences sharedPreferences, spLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUp2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        presenter = new SignUpPresenter();
        ApiCaller apiCaller = new ApiCaller();
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
                binding.loadingBg.setVisibility(View.VISIBLE);
                binding.loadingBg.setAlpha(0.5f);
                binding.progressBar.setVisibility(View.VISIBLE);
                if ((binding.edtTxtUsername.getText().toString() != "") & (binding.edtTxtPassword.getText().toString() != "")) {
                    Users user = Users.getInstance();
                    user.generateUid();
                    spLogin.edit().putInt("uid",user.getUid()).apply();
                    String mail = binding.edtTxtUsername.getText().toString();
                    String pass = binding.edtTxtPassword.getText().toString();
                    apiCaller.signUp(mail, pass, user.getUid(), new IResponseMessage() {
                        @Override
                        public void onSuccess(Object response) throws JSONException {
                            binding.loadingBg.setVisibility(View.GONE);
                            binding.progressBar.setVisibility(View.GONE);
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
                                Intent intent = new Intent(getApplicationContext(), SleepDreamInputActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
                            }

                        }

                        @Override
                        public void onFailure(String errorMessage) {
                            binding.loadingBg.setVisibility(View.GONE);
                            binding.progressBar.setVisibility(View.GONE);
                            Toast.makeText(getApplicationContext(),errorMessage,Toast.LENGTH_LONG).show();

                        }

                    });
                } else {
                    Toast.makeText(getApplicationContext(), R.string.field_not_filled_toast,
                            Toast.LENGTH_LONG).show();
                }
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
}

