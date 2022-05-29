package com.hanul.alcoholic;

import androidx.core.app.ActivityCompat;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import com.hanul.alcoholic.Registe.LoginActivity;

public class LoginActivityTest {
    @Rule
    public ActivityScenarioRule<LoginActivity> activityScenarioRule = new ActivityScenarioRule<>(LoginActivity.class);
    public String email = "suri@gachon.ac.kr";
    public String pwd = "qwerty";

    @Before
    public void beforeTest() {
        System.out.println("before()");
    }

    @After
    public void afterTest() {
        System.out.println("after()");
    }

    @Test
    public void pressLoginButton() {
        onView(withId(R.id.et_email))
                .perform(typeText(email), closeSoftKeyboard());
        onView(withId(R.id.et_pwd))
                .perform(typeText(pwd), closeSoftKeyboard());
        onView(withId(R.id.btn_login))
                .perform(click())
                .check(matches(isDisplayed()));

    }
    @Test
    public void pressSignupButton() {
        onView(withId(R.id.btn_register))
                .perform(click())
                .check(matches(isDisplayed()));
    }
}
