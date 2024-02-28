package com.example.goalsettingapp.ui.theme.goals_list

import com.example.goalsettingapp.data.Goal

sealed class GoalListEvent {
    //Events that we can have - may need to make some adjustments as we progress
    data class OnDeleteGoalClick(val goal: Goal): GoalListEvent()
    data class OnGoalClick(val goal: Goal) : GoalListEvent()
    data class OnGoalEditClick(val goal: Goal) : GoalListEvent()
    object OnUndoDeleteClick: GoalListEvent()
    object OnAddGoalClick: GoalListEvent()



}