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
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import com.hanul.alcoholic.Registe.LoginActivity;

public class WritingActivityTest {
    @Rule
    public ActivityScenarioRule<Community_writing> activityScenarioRule = new ActivityScenarioRule<>(Community_writing.class);
    public String title = "안녕하세요";
    public String content = "";
    // String writer = "Manager";

    @Before
    public void beforeTest() {
        System.out.println("before()");

    }

    @After
    public void afterTest() {
        System.out.println("after()");
    }

    @Test
    public void backButtonPressed() {
        onView(withId(R.id.button_back))
                .perform(click())
                .perform(pressKey(0))
                .check(matches(isDisplayed()));
    }
    @Test
    public void uploadButtonPressed() {
        onView(withId(R.id.editTextTitle))
                .perform(typeText(title));
        onView(withId(R.id.editTextContents))
                .perform(typeText(content), closeSoftKeyboard());
        onView(withId(R.id.button_upload))
                .perform(click())
                .check(matches(isDisplayed()));
    }
}
