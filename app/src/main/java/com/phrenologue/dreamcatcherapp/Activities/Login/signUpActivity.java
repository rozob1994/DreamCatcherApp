package com.phrenologue.dreamcatcherapp.Activities.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.Activities.SleepDreamInputActivity;
import com.phrenologue.dreamcatcherapp.databinding.ActivitySignUpBinding;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.Users;
import com.phrenologue.dreamcatcherapp.webservice.ApiCaller;

import org.json.JSONException;

public class signUpActivity extends AppCompatActivity {
    ActivitySignUpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnLoginAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Users user = Users.getInstance();
                String mail = binding.edtTxtUsername.getText().toString();
                String pass = binding.edtTxtPassword.getText().toString();
                user.generateUid();
                Log.e("","");
                ApiCaller apiCaller = new ApiCaller();
                apiCaller.signUp(mail, pass, user.getUid(), new IResponseMessage() {
                    @Override
                    public void onSuccess(Object response) throws JSONException {
                        user.setEmail(mail);
                        user.setPassword(pass);
                        Log.e("","");
                        Intent intent = new Intent(getApplicationContext(), SleepDreamInputActivity.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onFailure(String errorMessage) {

                        Log.e("","");

                    }
                });
            }
        });



    }
}
