package com.example.parseinstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass((Post.class));

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("vinita-instagram-cp") // should correspond to APP_ID env variable
                .clientKey("cp")  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("http://vinita-instagram-cp.herokuapp.com/parse").build());
    }
}
