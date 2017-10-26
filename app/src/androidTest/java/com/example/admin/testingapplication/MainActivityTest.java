package com.example.admin.testingapplication;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by Admin on 10/25/2017.
 */

public class MainActivityTest {

    public static final String PACKAGE_NAME = "com.example.admin.testingapplication";
    int first, second, result;

    @Before
    public void setup() {
        first = 10;
        second = 20;
        result = 30;
    }

//    @Rule
//    public ActivityTestRule<MainActivity> activityActivityTestRule =
//            new ActivityTestRule<MainActivity>( MainActivity.class );

    @Rule
    public IntentsTestRule<MainActivity> intentActivityTestRule =
            new IntentsTestRule<>( MainActivity.class );

    @Test
    public void additionIsCorrect() {
        // add value to first edit text view
        onView( withId( R.id.etFistNumber )).perform(
                typeText( String.valueOf( first )),
                ViewActions.closeSoftKeyboard());

        // add value to second edit text view
        onView( withId( R.id.etSecondNumber )).perform(
                typeText( String.valueOf( second )),
                ViewActions.closeSoftKeyboard());

        //preform button click
        onView( withId( R.id.btnResult )).perform( click());

        // create an assertion to test the result
        onView(withId( R.id.tvResult )).check(matches(withText(String.valueOf( result ))));
    }

    @Test
    public void testIntent() {
        // add value to first edit text view
        onView( withId( R.id.etFistNumber )).perform(
                typeText( String.valueOf( first )),
                ViewActions.closeSoftKeyboard());

        // add value to second edit text view
        onView( withId( R.id.etSecondNumber )).perform(
                typeText( String.valueOf( second )),
                ViewActions.closeSoftKeyboard());

        // preform button click
        onView( withId( R.id.btnResult )).perform( click());

        // preform button click
        onView( withId( R.id.btnSendResult )).perform( click());

        // click result button to test intent
        intended(allOf(
                hasComponent(hasShortClassName(".Main2Activity")),
                toPackage(PACKAGE_NAME),
                hasExtra(MainActivity.KEY_RESULT,
                String.valueOf(result))
        ));
    }
}
