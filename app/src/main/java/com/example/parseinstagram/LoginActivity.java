package com.example.parseinstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG="LoginActivity";
    private EditText etUserName;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnSign;
    private ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            gohomepage();
        }
        ivLogo=findViewById(R.id.ivLogo);
        etUserName=findViewById(R.id.etUser);
        etPassword=findViewById(R.id.etPassword);
        btnSign=findViewById(R.id.btnSignup);
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Signup();
            }
        });
        btnLogin=findViewById(R.id.btnLog);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=etUserName.getText().toString();
                String password=etPassword.getText().toString();
                login(username,password);
            }
        });
    }

    private void Signup() {
        Intent i= new Intent(this,SignUp.class);
        startActivity(i);
        finish();

    }

    private  void login(String username,String password){
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
              if(e!=null){
                  Log.e(TAG,"issue with login");
                  e.printStackTrace();
                  return;
              }
              //move to new activity if user signed in
                gohomepage();





            }
        });

    }

    private void gohomepage() {
        Intent i= new Intent(this,Main2Activity.class);
        startActivity(i);
        finish(); //user cant go back till mainactivity is done
    }
}
