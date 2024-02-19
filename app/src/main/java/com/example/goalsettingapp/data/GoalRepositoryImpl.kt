package com.example.goalsettingapp.data

import androidx.lifecycle.LiveData


//Implemenation of the goal repository interface
class GoalRepositoryImpl (
    private val dao: GoalDao
): GoalRepository {
    override suspend fun insertGoal(goal: Goal) {
        dao.insertGoal(goal)
    }
    override suspend fun deleteGoal(goal: Goal) {
        dao.deleteGoal(goal)
    }
    override suspend fun getGoalById(id: Int): Goal? {
        return dao.getGoalById(id)
    }
    override fun getGoals(): LiveData<List<Goal>> {
        return dao.getGoals()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GoalRepositoryImpl

        return dao == other.dao
    }

    override fun hashCode(): Int {
        return dao.hashCode()
    }


}