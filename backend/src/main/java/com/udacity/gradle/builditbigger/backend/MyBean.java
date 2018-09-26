package com.udacity.gradle.builditbigger.backend;

import com.example.android.jokeproviderlib.JokeProviderClass;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public String getData() {

        myData = new JokeProviderClass().tellAJoke();
        return myData;
    }


}