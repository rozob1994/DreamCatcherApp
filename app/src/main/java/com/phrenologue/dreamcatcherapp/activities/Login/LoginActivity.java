package com.phrenologue.dreamcatcherapp.activities.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.activities.ProfileActivity;
import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.ActivityLoginBinding;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.Users;
import com.phrenologue.dreamcatcherapp.webservice.ApiCaller;

import org.json.JSONException;
import org.json.JSONObject;

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
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        if (sharedPreferences.getBoolean("logged", false)) {
            Users user = Users.getInstance();
            user.setUid(sharedPreferences.getInt("uid", 0));
            user.setEmail(sharedPreferences.getString("username", ""));
            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
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
                            int level = jsonObject.getInt("level");
                            user.setLevel(level);
                            sharedPreferences.edit().putInt("level", level).apply();
                            sharedPreferences.edit().putBoolean("logged", true).apply();
                            user.setEmail(username);
                            int uid = jsonObject.getInt("uid");
                            sharedPreferences.edit().putInt("uid", uid).apply();
                            sharedPreferences.edit().putString("username", username).apply();
                            user.setUid(uid);
                            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(String errorMessage) {
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


}
