package com.example.android.jokeproviderlib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokeProviderClass {

    List<String> jokeList = new ArrayList<>();

    public void addJokes(){
        jokeList.add("I'm really good friends with 25 letters of the alphabet.... \n I don't know Y.");
        jokeList.add("Could you please call me a taxi?   \n  Alright, you're a taxi." );
        jokeList.add("What did the pirate say when he turned 80 \n Aye matey");
        jokeList.add("Four fonts walk into a bar. The barman says: \"Oi - get out. We don't want your typ in here\"");
        jokeList.add("Four fonts walk into a bar. The barman says: \n \"Oi - get out. We don't want your type in here\"");
        jokeList.add("Two fish in a tank. One says: \"How do you drive this thing?\"");
        jokeList.add("Why has nobody heard of the new band 1023 megabits \n They don't have any gigs.");
        jokeList.add("What do you call a priest that becomes a lawyer? \n A father in law.");
        jokeList.add(" Why are frogs are so happy? \n They eat whatever bugs them.");
        jokeList.add(" How do you befriend a squirrel? \n Just act like a nut.");
    }

    public String tellAJoke(){
        addJokes();
        Random random = new Random();
        String randomJoke = jokeList.get(random.nextInt(jokeList.size()));
        return  randomJoke;
    }

}
