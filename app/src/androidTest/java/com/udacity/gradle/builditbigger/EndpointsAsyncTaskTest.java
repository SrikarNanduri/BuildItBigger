
package com.udacity.gradle.builditbigger;


import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
@LargeTest

public class EndpointsAsyncTaskTest extends AndroidTestCase{
    private static final String ERROR = "There was an error fetching the joke from the server";

   @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);


   @Test
   public void testJokeIsNotEmpty() throws Exception {

       EndpointsAsyncTask testHelper =  new EndpointsAsyncTask(new EndpointsAsyncTask.TaskCompleteListener() {
           @Override
           public void onTaskComplete(String result) {
           }
       });
       try {
       testHelper.execute(InstrumentationRegistry.getContext());
       String joke = testHelper.get();
       assertNotNull(joke);
       assertTrue(!joke.isEmpty());
       } catch (InterruptedException ie) {
           fail(ERROR);
       }
   }

    @Test
    public void testVerifyResponse() {
        onView(withId(R.id.joke_btn)).perform(click());
    }

}

