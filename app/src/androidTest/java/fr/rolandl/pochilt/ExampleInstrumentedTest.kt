package fr.rolandl.pochilt

import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.espresso.Espresso
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class ExampleInstrumentedTest {
  
  @get:Rule(order = 0)
  val hiltRule = HiltAndroidRule(this)
  
  @get:Rule(order = 1)
  val composeTestRule = createAndroidComposeRule<MainActivity>()
  
  @Test
  fun useAppContext() {
    var cpt = 0
    
    composeTestRule.apply {
      (0..1000).forEach {
        onNodeWithText("Click").performClick()
        
        if(onNodeWithText("Error").isDisplayed() == true) {
          cpt++
        }
        
        Espresso.pressBack()
      }
      
      println("CPT ERROR: $cpt")
    }
  }
}