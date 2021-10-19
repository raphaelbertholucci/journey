package com.bertholucci.journey.main

import androidx.appcompat.widget.AppCompatTextView
import androidx.test.core.app.ActivityScenario
import com.bertholucci.journey.Check
import com.bertholucci.journey.Execute
import com.bertholucci.journey.R
import com.bertholucci.journey.Setup
import com.bertholucci.journey.checkRecyclerViewItem
import com.bertholucci.journey.isTextDisplayed
import com.bertholucci.journey.presentation.ui.main.MainActivity
import org.junit.Ignore

fun setupView(func: MainActivityRobot.() -> Unit) =
    MainActivityRobot().apply(func)

class MainActivityRobot : Setup<MainActivityRobotExecute, MainActivityRobotCheck> {

    override fun executeCreator() = MainActivityRobotExecute()

    override fun checkCreator() = MainActivityRobotCheck()

    override fun launch() {
        ActivityScenario.launch(MainActivity::class.java)
    }
}

class MainActivityRobotExecute : Execute<MainActivityRobotCheck> {
    override fun checkCreator() = MainActivityRobotCheck()
}

class MainActivityRobotCheck : Check {

    fun checkRecycler() {
        Thread.sleep(1600) //This is necessary because of the delay in JourneyRepositoryImpl
        "Getting ready for your journey".isTextDisplayed()
        "Ready, set, prep!".isTextDisplayed()
        "DAY ZERO".isTextDisplayed()
        "Know your why".isTextDisplayed()
        "Discover your inner motivation".isTextDisplayed()
        "DAY ONE".isTextDisplayed()
    }

    @Ignore("This method needs an improvement")
    private fun checkRecyclerItem(position: Int, title: String, subtitle: String, day: String) {
        R.id.rv_items.checkRecyclerViewItem<AppCompatTextView>(position, R.id.tv_title) { view ->
            view.text == title
        }
        R.id.rv_items.checkRecyclerViewItem<AppCompatTextView>(
            position,
            R.id.tv_description
        ) { view ->
            view.text == subtitle
        }
        R.id.rv_items.checkRecyclerViewItem<AppCompatTextView>(position, R.id.tv_day) { view ->
            view.text == day
        }
    }
}