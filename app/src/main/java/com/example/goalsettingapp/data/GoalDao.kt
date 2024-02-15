package com.example.goalsettingapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

//Data access object for goal object - defines how to access data
@Dao
interface GoalDao {
    //Inserting a goal
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGoal(goal: Goal)

    //Deleting a goal
    @Delete
    suspend fun deleteGoal(goal: Goal)

    //Getting a single goal - returns null if given ID doesn't exist, else returns our goal
    @Query("SELECT * FROM goal WHERE id = :id")
    suspend fun getGoalById(id: Int): Goal?

    //Getting all goals in a Flow
    @Query("SELECT * FROM goal")
    fun getGoals(): Flow<List<Goal>>


}