package com.phrenologue.dreamcatcherapp.Activities.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.Activities.SleepDreamInputActivity;
import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.ActivitySignUp2Binding;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.Users;
import com.phrenologue.dreamcatcherapp.webservice.ApiCaller;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUp extends AppCompatActivity {
    ActivitySignUp2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUp2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnSignUpAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Users user = Users.getInstance();

                String mail = binding.edtTxtUsername.getText().toString();
                String pass = binding.edtTxtPassword.getText().toString();
                user.generateUid();

                ApiCaller apiCaller = new ApiCaller();
                apiCaller.signUp(mail, pass, user.getUid(), new IResponseMessage() {
                        @Override
                        public void onSuccess(Object response) throws JSONException {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            boolean status = jsonObject.getBoolean("status");
                            Log.e("", "");
                            if (status){
                                user.setEmail(mail);
                                user.setPassword(pass);
                                Intent intent = new Intent(getApplicationContext(), SleepDreamInputActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), R.string.taken_username_error,
                                        Toast.LENGTH_LONG).show();
                            }

                        }

                        @Override
                        public void onFailure(String errorMessage) {
                            Toast.makeText(getApplicationContext(), R.string.connection_error,
                                    Toast.LENGTH_LONG).show();

                            Log.e("", "");

                        }
                    });

            }
        });
    }
}
