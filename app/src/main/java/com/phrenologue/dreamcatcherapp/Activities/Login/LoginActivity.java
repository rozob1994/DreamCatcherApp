package com.phrenologue.dreamcatcherapp.Activities.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.Activities.SleepDreamInputActivity;
import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.ActivityLoginBinding;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.Users;
import com.phrenologue.dreamcatcherapp.webservice.ApiCaller;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnLoginAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Users user = Users.getInstance();
                String mail = binding.edtTxtUsername.getText().toString();
                String pass = binding.edtTxtPassword.getText().toString();
                Log.e("", "");
                ApiCaller apiCaller = new ApiCaller();
                apiCaller.login(mail, pass, new IResponseMessage() {
                    @Override
                    public void onSuccess(Object response) throws JSONException {
                        JSONObject jsonObject = new JSONObject(response.toString());
                        boolean status = jsonObject.getBoolean("status");
                        if (status){
                            user.setEmail(mail);
                            int uid = jsonObject.getInt("uid");
                            user.setUid(uid);
                            Log.e("", "");
                            Intent intent = new Intent(getApplicationContext(), SleepDreamInputActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            String message = jsonObject.getString("message");
                            Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                        public void onFailure(String errorMessage) {
                        Log.e("", errorMessage);
                        Toast.makeText(getApplicationContext(), "login failed", Toast.LENGTH_LONG).show();

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
