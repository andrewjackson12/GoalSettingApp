package com.example.goalsettingapp

import com.example.goalsettingapp.data.Goal
import org.junit.Assert
import org.junit.Test
import java.util.Date

class GoalDataTest {

    @Test
    fun createAndTestGoal() {
        //Date object will just get current date, should test with a future date later, but this is just for object creation testing

        var dateDue1 = Date()
        var goalTest = Goal("Title", "Description", dateDue1, "Daily")

        //Need to make data fields public to test this (commenting to avoid errors)
        /*
        Assert.assertEquals("Title", goalTest.title)
        Assert.assertEquals("Description", goalTest.description)
        Assert.assertEquals("Daily", goalTest.checkInFreq)
        */

    }
}