package com.phrenologue.dreamcatcherapp.Activities.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.Activities.ProfileActivity;
import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.ActivityLoginBinding;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.OperationResults;
import com.phrenologue.dreamcatcherapp.parameters.Users;
import com.phrenologue.dreamcatcherapp.webservice.ApiCaller;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

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
                OperationResults results = OperationResults.getInstance();
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
                        if (status){
                            results.setSuccessfulResults(message);
                            user.setEmail(username);
                            int uid = jsonObject.getInt("uid");
                            user.setUid(uid);
                            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            results.setFailedResults(message);
                        }

                    }
                    @Override
                    public void onFailure(String errorMessage) {
                        loadingBg.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        results.setFailedResults(errorMessage);
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
