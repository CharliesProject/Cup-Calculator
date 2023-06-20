package com.example.kalkulatorszklanek

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorTests {

    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_150_grams_wheat_flour() {
        onView(withId(R.id.enter_quantity))
            .perform(typeText("150"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.calculate_btn)).perform(click())

        onView(withId(R.id.result_text))
            .check(matches(withText(containsString("150g mąki pszennej to 1.0 szkl."))))
    }

    @Test
    fun calculate_100_grams_wheat_flour() {
        onView(withId(R.id.enter_quantity))
            .perform(typeText("100"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.calculate_btn)).perform(click())

        onView(withId(R.id.result_text))
            .check(matches(withText(containsString("100g mąki pszennej to 0.67 szkl."))))
    }

    @Test
    fun calculate_115_grams_rye_flour() {
        onView(withId(R.id.rye_flour_radio_button)).perform(click())

        onView(withId(R.id.enter_quantity))
            .perform(typeText("115"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.calculate_btn)).perform(click())

        onView(withId(R.id.result_text))
            .check(matches(withText(containsString("115g mąki żytniej to 1.0 szkl."))))
    }

    @Test
    fun calculate_100_grams_rye_flour() {
        onView(withId(R.id.rye_flour_radio_button)).perform(click())

        onView(withId(R.id.enter_quantity))
            .perform(typeText("100"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.calculate_btn)).perform(click())

        onView(withId(R.id.result_text))
            .check(matches(withText(containsString("100g mąki żytniej to 0.87 szkl."))))
    }

    @Test
    fun calculate_105_grams_oats_flour() {
        onView(withId(R.id.oats_flour_radio_button)).perform(click())

        onView(withId(R.id.enter_quantity))
            .perform(typeText("105"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.calculate_btn)).perform(click())

        onView(withId(R.id.result_text))
            .check(matches(withText(containsString("105g mąki owsianej to 1.0 szkl."))))
    }

    @Test
    fun calculate_100_grams_oats_flour() {
        onView(withId(R.id.oats_flour_radio_button)).perform(click())

        onView(withId(R.id.enter_quantity))
            .perform(typeText("100"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.calculate_btn)).perform(click())

        onView(withId(R.id.result_text))
            .check(matches(withText(containsString("100g mąki owsianej to 0.95 szkl."))))
    }

    @Test
    fun calculate_150_grams_rice_flour() {
        onView(withId(R.id.rice_flour_radio_button)).perform(click())

        onView(withId(R.id.enter_quantity))
            .perform(typeText("150"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.calculate_btn)).perform(click())

        onView(withId(R.id.result_text))
            .check(matches(withText(containsString("150g mąki ryżowej to 1.0 szkl."))))
    }

    @Test
    fun calculate_100_grams_rice_flour() {
        onView(withId(R.id.rice_flour_radio_button)).perform(click())

        onView(withId(R.id.enter_quantity))
            .perform(typeText("100"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.calculate_btn)).perform(click())

        onView(withId(R.id.result_text))
            .check(matches(withText(containsString("100g mąki ryżowej to 0.67 szkl."))))
    }

    @Test
    fun calculate_110_grams_oat_flakes() {
        onView(withId(R.id.oat_flakes_radio_button)).perform(click())

        onView(withId(R.id.enter_quantity))
            .perform(typeText("110"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.calculate_btn)).perform(click())

        onView(withId(R.id.result_text))
            .check(matches(withText(containsString("110g płatków owsianych to 1.0 szkl."))))
    }

    @Test
    fun calculate_101_grams_oat_flakes() {
        onView(withId(R.id.oat_flakes_radio_button)).perform(click())

        onView(withId(R.id.enter_quantity))
            .perform(typeText("101"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.calculate_btn)).perform(click())

        onView(withId(R.id.result_text))
            .check(matches(withText(containsString("101g płatków owsianych to 0.92 szkl."))))
    }

    @Test
    fun calculate_150_grams_wheat_flour_second_choose() {
        onView(withId(R.id.rye_flour_radio_button)).perform(click())

        onView(withId(R.id.wheat_flour_radio_button)).perform(click())

        onView(withId(R.id.enter_quantity))
            .perform(typeText("150"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.calculate_btn)).perform(click())

        onView(withId(R.id.result_text))
            .check(matches(withText(containsString("150g mąki pszennej to 1.0 szkl."))))
    }

    @Test
    fun calculate_max_grams_wheat_flour_second_choose() {
        onView(withId(R.id.rye_flour_radio_button)).perform(click())

        onView(withId(R.id.wheat_flour_radio_button)).perform(click())

        onView(withId(R.id.enter_quantity))
            .perform(typeText("99999"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.calculate_btn)).perform(click())

        onView(withId(R.id.result_text))
            .check(matches(withText(containsString("99999g mąki pszennej to 666.66 szkl."))))
    }

    @Test
    fun calculate_empty() {
        onView(withId(R.id.calculate_btn)).perform(click())

        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(isDisplayed()))
            .check(matches(withText(containsString("Podaj liczbę gramów mąki"))))
    }

    @Test
    fun check_hint_text() {
        onView(withId(R.id.enter_quantity))
            .check(matches(withHint("Tu wipisz liczbę w gramach")))
    }

    @Test
    fun check_wheat_flour_default_text() {
        onView(withId(R.id.result_text))
            .check(matches(withText(containsString("150g mąki pszennej to 1.0 szkl."))))
    }

    @Test
    fun check_rye_flour_default_text() {
        onView(withId(R.id.rye_flour_radio_button)).perform(click())

        onView(withId(R.id.result_text))
            .check(matches(withText(containsString("115g mąki żytniej to 1.0 szkl."))))
    }

    @Test
    fun check_oats_flour_default_text() {
        onView(withId(R.id.oats_flour_radio_button)).perform(click())

        onView(withId(R.id.result_text))
            .check(matches(withText(containsString("105g mąki owsianej to 1.0 szkl."))))
    }

    @Test
    fun check_rice_flour_default_text() {
        onView(withId(R.id.rice_flour_radio_button)).perform(click())

        onView(withId(R.id.result_text))
            .check(matches(withText(containsString("150g mąki ryżowej to 1.0 szkl."))))
    }

    @Test
    fun check_oat_flakes_default_text() {
        onView(withId(R.id.oat_flakes_radio_button)).perform(click())

        onView(withId(R.id.result_text))
            .check(matches(withText(containsString("110g płatków owsianych to 1.0 szkl."))))
    }
}
