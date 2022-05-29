package com.hanul.alcoholic.Registe;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import com.hanul.alcoholic.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginExceptionTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void loginExceptionTest() {
        ViewInteraction appCompatEditText = onView(
allOf(withId(R.id.et_email),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()));
        appCompatEditText.perform(replaceText("suri@gachonkr"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText2 = onView(
allOf(withId(R.id.et_pwd),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()));
        appCompatEditText2.perform(replaceText("qwerty"), closeSoftKeyboard());
        
        ViewInteraction materialButton = onView(
allOf(withId(R.id.btn_login), withText("로그인"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()));
        materialButton.perform(click());
        
        ViewInteraction materialButton2 = onView(
allOf(withId(android.R.id.button3), withText("확인"),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.ScrollView")),
0),
0)));
        materialButton2.perform(scrollTo(), click());
        
        ViewInteraction appCompatEditText3 = onView(
allOf(withId(R.id.et_email), withText("suri@gachonkr"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()));
        appCompatEditText3.perform(replaceText("suri@gachon.ac.kr"));
        
        ViewInteraction appCompatEditText4 = onView(
allOf(withId(R.id.et_email), withText("suri@gachon.ac.kr"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()));
        appCompatEditText4.perform(closeSoftKeyboard());
        
        ViewInteraction appCompatEditText5 = onView(
allOf(withId(R.id.et_pwd), withText("qwerty"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()));
        appCompatEditText5.perform(replaceText("qwerty2"));
        
        ViewInteraction appCompatEditText6 = onView(
allOf(withId(R.id.et_pwd), withText("qwerty2"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()));
        appCompatEditText6.perform(closeSoftKeyboard());
        
        pressBack();
        
        ViewInteraction materialButton3 = onView(
allOf(withId(R.id.btn_login), withText("로그인"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()));
        materialButton3.perform(click());
        
        ViewInteraction materialButton4 = onView(
allOf(withId(android.R.id.button3), withText("확인"),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.ScrollView")),
0),
0)));
        materialButton4.perform(scrollTo(), click());
        
        ViewInteraction appCompatEditText7 = onView(
allOf(withId(R.id.et_pwd), withText("qwerty2"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()));
        appCompatEditText7.perform(click());
        
        ViewInteraction appCompatEditText8 = onView(
allOf(withId(R.id.et_pwd), withText("qwerty2"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()));
        appCompatEditText8.perform(replaceText("qwerty"));
        
        ViewInteraction appCompatEditText9 = onView(
allOf(withId(R.id.et_pwd), withText("qwerty"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()));
        appCompatEditText9.perform(closeSoftKeyboard());
        
        pressBack();
        
        ViewInteraction materialButton5 = onView(
allOf(withId(R.id.btn_login), withText("로그인"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()));
        materialButton5.perform(click());
        
        ViewInteraction materialButton6 = onView(
allOf(withId(R.id.search_name_btn), withText("칵테일 이름 검색"),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.FrameLayout")),
0),
0),
isDisplayed()));
        materialButton6.perform(click());
        
        ViewInteraction materialButton7 = onView(
allOf(withId(R.id.btnData), withText("데이터 불러오기"),
childAtPosition(
allOf(withId(R.id.postContent),
childAtPosition(
withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
0)),
2),
isDisplayed()));
        materialButton7.perform(click());
        }
    
    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup)parent).getChildAt(position));
            }
        };
    }
    }
