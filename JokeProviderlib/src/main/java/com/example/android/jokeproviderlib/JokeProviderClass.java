package com.example.android.jokeproviderlib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokeProviderClass {

    List<String> jokeList = new ArrayList<>();

    public void addJokes(){
        jokeList.add("I'm really good friends with 25 letters of the alphabet....  I don't know Y.");
        jokeList.add("Could you please call me a taxi?   \n  Alright, you're a taxi." );
        jokeList.add("What did the pirate say when he turned 80 \n Aye matey");
    }

    public String tellAJoke(){
        addJokes();
        Random random = new Random();
        String randomJoke = jokeList.get(random.nextInt(jokeList.size()));
        return  randomJoke;
    }

}
