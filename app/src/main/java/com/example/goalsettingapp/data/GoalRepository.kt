package com.example.goalsettingapp.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow


//Defining the functions for our DAO
interface GoalRepository {
    suspend fun insertGoal(goal: Goal)
    suspend fun deleteGoal(goal: Goal)
    suspend fun getGoalById(id: Int): Goal?
    fun getGoals(): LiveData<List<Goal>>


            //Flow<List<Goal>>


}