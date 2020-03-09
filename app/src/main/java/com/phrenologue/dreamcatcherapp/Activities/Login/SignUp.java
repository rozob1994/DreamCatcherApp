package com.phrenologue.dreamcatcherapp.Activities.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.Activities.SleepDreamInputActivity;
import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.ActivitySignUp2Binding;
import com.phrenologue.dreamcatcherapp.presenters.SignUpPresenter;

public class SignUp extends AppCompatActivity {
    ActivitySignUp2Binding binding;
    SignUpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUp2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        presenter = new SignUpPresenter();

        binding.btnSignUpAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((binding.edtTxtUsername.getText().toString() != "") & (binding.edtTxtPassword.getText().toString() != "")) {
                    String mail = binding.edtTxtUsername.getText().toString();
                    String pass = binding.edtTxtPassword.getText().toString();
                    boolean status = presenter.doSignUp(mail, pass);

                    if (status){
                        Intent intent = new Intent(getApplicationContext(), SleepDreamInputActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Registration failed.",
                                Toast.LENGTH_LONG).show();
                    }
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
}
