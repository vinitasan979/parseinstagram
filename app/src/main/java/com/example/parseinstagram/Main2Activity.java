package com.example.parseinstagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseUser;

import java.util.List;

public class Main2Activity extends AppCompatActivity {
    TextView tvTest;
    private Button btnLogout;
    //private ImageButton btnAdd;
    private Button btnPic;
    RecyclerView rvFeed;
    List<Post> posts;
    ImageView ivLogo;
    ImageView ivDirect;
    ImageView ivCame;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnLogout=findViewById(R.id.btnLogo);
        //btnAdd=findViewById(R.id.btnAdd);
        btnPic=findViewById(R.id.button3);
        ivCame=findViewById(R.id.ivCam);
        ivDirect=findViewById(R.id.ivDirect);
        ivLogo=findViewById(R.id.ivHead);



        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser();
                backtoLogin();
            }
        });

        btnPic.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goMainActivity();
            }
        }));
    }

    private void goMainActivity() {
        Intent i= new Intent(this, MainActivity.class);
        startActivity(i);

    }

    private void backtoLogin() {
        Intent i= new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();

    }
}
