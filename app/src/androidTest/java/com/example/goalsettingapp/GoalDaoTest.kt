package com.example.goalsettingapp

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.goalsettingapp.data.GoalDao
import com.example.goalsettingapp.data.GoalDatabase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import com.example.goalsettingapp.data.Goal
import java.util.Date
import org.junit.Assert.assertNull
import com.example.goalsettingapp.getOrAwaitValue
import org.junit.Assert
import org.junit.Rule
import androidx.arch.core.executor.testing.InstantTaskExecutorRule

//Todo: Comment and explain how this test is working

class GoalDaoTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    lateinit var database: GoalDatabase
    lateinit var goalDao: GoalDao

    //Creating local goal database - @Before makes sure this fun runs executes first
    @Before
    fun setupDatabase() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            GoalDatabase::class.java
        ).allowMainThreadQueries().build()

        goalDao = database.dao()
    }

    //Function to close our database - After annotation ensures this will execute only after tests
    @After
    fun closeDatabase() {
        database.close()
    }


    //Testing inputting goals into the database - returns true if successful
    @Test
    fun insertGoal_returnsTrue() = runBlocking {
        val testGoal = Goal("Test Title", "Test goal", Date(), "Daily")
        goalDao.insertGoal(testGoal)


        val listGoals = goalDao.getGoals().getOrAwaitValue()
        Assert.assertEquals(1, listGoals.size)
        Assert.assertEquals("Test Title", listGoals[0].title)
        Assert.assertEquals("Test goal", listGoals[0].description)
        Assert.assertEquals("Daily", listGoals[0].checkInFreq)


    }

    @Test
    fun deleteGoal_returnsTrue() = runBlocking {
        val testGoal2 = Goal("Test Title 2", "Test goal 2", Date(), "Daily")
        goalDao.insertGoal(testGoal2)
        goalDao.deleteGoal(testGoal2)

        val deletedGoal = testGoal2.id?.let {goalDao.getGoalById(it)}

        assertNull(deletedGoal)
    }

}