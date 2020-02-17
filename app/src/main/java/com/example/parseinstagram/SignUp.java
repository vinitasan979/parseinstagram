package com.example.parseinstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUp extends AppCompatActivity {
    TextView tvDetail;
    EditText etEmail;
    EditText etName;
    EditText etPwd;
    Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        tvDetail=findViewById(R.id.tvDetails);
        etEmail=findViewById(R.id.etEmail);
        etName=findViewById(R.id.etName);
        etPwd=findViewById(R.id.etPwd);
        btnConfirm=findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=etName.getText().toString();
                String password=etPwd.getText().toString();
                String email =etEmail.getText().toString();
                signup(email,username,password);
            }
        });


    }

    private void signup(String email, String username, String password) {
        ParseUser user = new ParseUser();
// Set core properties
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    gohomepage();
                } else {
                    Log.e("SignUp","issue with login");
                    e.printStackTrace();
                    return;
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                }
            }
        });

    }

    private void gohomepage() {
        Intent i= new Intent(this,Main2Activity.class);
        startActivity(i);
        finish(); //user cant go back till mainactivity is done
    }

}
